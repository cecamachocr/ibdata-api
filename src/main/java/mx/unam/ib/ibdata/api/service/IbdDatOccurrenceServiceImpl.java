package mx.unam.ib.ibdata.api.service;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.unam.ib.ibdata.api.commons.IbdResponseCodes;
import mx.unam.ib.ibdata.api.dao.IbdDatOcurrenceDAOInterface;
import mx.unam.ib.ibdata.api.dao.IbdDemoDAOInterface;
import mx.unam.ib.ibdata.api.model.collection.IbdDatOcurrenceCollection;
import mx.unam.ib.ibdata.api.model.entity.IbdDatOcurrenceEntity;
import mx.unam.ib.ibdata.api.model.vo.IbdClaveValor;
import mx.unam.ib.ibdata.api.model.vo.IbdDatOccurrenceCriteriaVO;
import mx.unam.ib.ibdata.api.model.vo.IbdDatOcurrenceResponse;
import mx.unam.ib.ibdata.api.model.vo.IbdExecuteServiceVO;
import mx.unam.ib.ibdata.api.repository.IbdDatOcurrenceMDRepository;
import mx.unam.ib.ibdata.api.repository.IbdDatOcurrenceRepository;
import mx.unam.ib.ibdata.api.repository.IbdUserRepository;
import mx.unam.ib.ibdata.api.utils.IbdContants;

@Service
public class IbdDatOccurrenceServiceImpl implements IbdDatOccurrenceServiceInterface{

	private static final Logger logger = LoggerFactory.getLogger(IbdDatOccurrenceServiceImpl.class);
	
	@Autowired
	IbdUserRepository userRepository;
	
	@Autowired
	IbdDemoDAOInterface ibdDemoDAO;
	
	@Autowired
	IbdDatOcurrenceDAOInterface ibdDatOcurrenceDAO;
	
	@Autowired
	IbdDatOcurrenceRepository ibdDatOcurrenceRepository;
	
	
	@Autowired
	IbdDatOcurrenceMDRepository datOcurrenceRepository;
	
	
	@Override
	public IbdDatOcurrenceResponse findByOcurrenceId(IbdDatOccurrenceCriteriaVO req) throws Exception {
		
		IbdDatOcurrenceResponse response = new IbdDatOcurrenceResponse();
		
		try {
			List<IbdDatOcurrenceCollection> list = null;
			
			if(req!= null) {
				String finalUrl = req.getUrlServer() + IbdContants.PATH_DONWLOAD_REPORT;
				
				
				Long totalRows = datOcurrenceRepository.countByOcurrenceId(req.getOccurrenceId());
				
				if(totalRows != null && totalRows > 0) {
					
					Pageable pageable = PageRequest.of(req.getPageNum() - 1, req.getPageLimit());
					
					list = datOcurrenceRepository.findByOcurrenceId(req.getOccurrenceId(), pageable);
					
					IbdExecuteServiceVO execServiceVO = new IbdExecuteServiceVO();
					TreeMap<Integer, IbdClaveValor> mapParam = new TreeMap<Integer, IbdClaveValor>();
					
					String sMethodName = new String (Thread.currentThread().getStackTrace()[1].getMethodName());
				    String sClassName  = new String (Thread.currentThread().getStackTrace()[1].getClassName());

				    execServiceVO.setServiceClass(sClassName);
				    execServiceVO.setMethodName(sMethodName);
				     
				    Class<?> c1 = Class.forName(sClassName); 
				    execServiceVO.setInterfaceClass(c1.getInterfaces()[0].getName());
				    
				    Parameter[] parameters = null;
				    List<String> parameterNames = new ArrayList<>();
				    for (Method m : this.getClass().getMethods()) {
				    	if(m.getName().equals(sMethodName)) {
				    		parameters = m.getParameters();
				    		execServiceVO.setReturnTypeName(m.getReturnType().getName());
				    		break;
				    		
				    	}
				    }
				    
				    ObjectMapper mapperReq = new ObjectMapper();
				    String jsonReq = "";
				    try {
				    	jsonReq = mapperReq.writeValueAsString(req);
				    } catch (JsonProcessingException e) {
				    	logger.error(e.getMessage(), e);
				    }
				    
				    int countParam = 0;
			        for (Parameter parameter : parameters) {
			            if(!parameter.isNamePresent()) {
			                throw new IllegalArgumentException("Parameter names are not present!");
			            }

			            String parameterName = parameter.getName();
			            parameterNames.add(parameterName);
			            IbdClaveValor cv = new IbdClaveValor();
			            
			            cv.setClave(parameter.getParameterizedType().getTypeName());
			            cv.setValor(jsonReq);
			            
			            mapParam.put(countParam, cv);
			            

			        }
			        execServiceVO.setParams(mapParam);
				    
			        String mapperExecStr = "";
				    try {
				    	mapperExecStr = mapperReq.writeValueAsString(execServiceVO);
				    } catch (JsonProcessingException e) {
				    	logger.error(e.getMessage(), e);
				    }
				    
				    
				    Encoder encoder = Base64.getEncoder();
				    String originalString = mapperExecStr;
				    String encodedString = encoder.encodeToString(originalString.getBytes());

				    finalUrl = finalUrl + encodedString;
				    response.setUrlDownloadReport(finalUrl);
				}
				
				if(list != null) {
					
					String msg = "";
					String code = "";
					if(list == null || (list != null && list.isEmpty())) {
						code = IbdResponseCodes.OK_NOT_FOUND.getCode();
						msg = IbdResponseCodes.OK_NOT_FOUND.getMsg();
					} else {
						code = IbdResponseCodes.OK_SUCCESS.getCode();
						msg = IbdResponseCodes.OK_SUCCESS.getMsg();
					}
					response.setSuccess(true);
					response.setCode(code);
					response.setMessage(msg);
					response.setTotalRows(totalRows);
					response.setPageLimit(Long.valueOf(req.getPageLimit()));
					response.setPageNum(Long.valueOf(req.getPageNum()));
					response.setListSize(Long.valueOf(list.size()));
					response.setData(list);
				} else {
					response.setSuccess(true);
					response.setCode(IbdResponseCodes.OK_NOT_FOUND.getCode());
					response.setMessage(IbdResponseCodes.OK_NOT_FOUND.getMsg());
					response.setTotalRows(0L);
					response.setPageLimit(Long.valueOf(req.getPageLimit()));
					response.setPageNum(Long.valueOf(req.getPageNum()));
					response.setListSize(0L);
					response.setData(new ArrayList<IbdDatOcurrenceCollection>());
				}
			} else {
				response.setSuccess(true);
				response.setCode(IbdResponseCodes.ERROR_BAD_REQUEST.getCode());
				response.setMessage(IbdResponseCodes.ERROR_BAD_REQUEST.getMsg());
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage(),e);
		}

		return response;
	}
	
	@Override
	public IbdDatOcurrenceResponse findUserByIdCountry(IbdDatOccurrenceCriteriaVO req) throws Exception {
		
		IbdDatOcurrenceResponse response = new IbdDatOcurrenceResponse();
		try {
			List<IbdDatOcurrenceEntity> list = null;
			if(req!= null) {
				
				//ibdDatOcurrenceDAO.callFunctionGetByIdCountry(req.getIdCountry(), req.getPageNum(), req.getPageLimit());
				
				Long totalRows = ibdDatOcurrenceRepository.countByIdCountry(req.getIdCountry());
				
				if(totalRows != null && totalRows > 0) {
					
					Pageable pageable = PageRequest.of(req.getPageNum() - 1, req.getPageLimit());
					
					list = ibdDatOcurrenceRepository.findAllByIdCountryOrderByOccurrenceIdDesc(req.getIdCountry(), pageable);
				
				}
				
				if(list != null) {
					
					String msg = "";
					String code = "";
					if(list == null || (list != null && list.isEmpty())) {
						code = IbdResponseCodes.OK_NOT_FOUND.getCode();
						msg = IbdResponseCodes.OK_NOT_FOUND.getMsg();
					} else {
						code = IbdResponseCodes.OK_SUCCESS.getCode();
						msg = IbdResponseCodes.OK_SUCCESS.getMsg();
					}
					response.setSuccess(true);
					response.setCode(code);
					response.setMessage(msg);
					response.setTotalRows(totalRows);
					response.setPageLimit(Long.valueOf(req.getPageLimit()));
					response.setPageNum(Long.valueOf(req.getPageNum()));
					response.setListSize(Long.valueOf(list.size()));
					//response.setData(list);
				} else {
					response.setSuccess(true);
					response.setCode(IbdResponseCodes.OK_NOT_FOUND.getCode());
					response.setMessage(IbdResponseCodes.OK_NOT_FOUND.getMsg());
					response.setTotalRows(0L);
					response.setPageLimit(Long.valueOf(req.getPageLimit()));
					response.setPageNum(Long.valueOf(req.getPageNum()));
					response.setListSize(0L);
					//response.setData(new ArrayList<IbdDatOcurrenceEntity>());
				}
			} else {
				response.setSuccess(true);
				response.setCode(IbdResponseCodes.ERROR_BAD_REQUEST.getCode());
				response.setMessage(IbdResponseCodes.ERROR_BAD_REQUEST.getMsg());
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage(),e);
		}

		return response;
	}
	
	
	@Override
	public IbdDatOcurrenceResponse findUserByIdCountryDAO(IbdDatOccurrenceCriteriaVO req) throws Exception {
		
		IbdDatOcurrenceResponse response = new IbdDatOcurrenceResponse();
		try {
			List<IbdDatOcurrenceEntity> list = null;
			if(req!= null) {
				
				Integer count = ibdDatOcurrenceDAO.callFunctionGetByIdCountryCount(req.getIdCountry());
				
				Long totalRows = ibdDatOcurrenceRepository.countByIdCountry(req.getIdCountry());
				
				if(count!= null && count > 0) {
					
					list = ibdDatOcurrenceDAO.callFunctionGetByIdCountry(req.getIdCountry(), req.getPageNum(), req.getPageLimit());
									
				}
				
				if(list != null) {
					
					String msg = "";
					String code = "";
					if(list == null || (list != null && list.isEmpty())) {
						code = IbdResponseCodes.OK_NOT_FOUND.getCode();
						msg = IbdResponseCodes.OK_NOT_FOUND.getMsg();
					} else {
						code = IbdResponseCodes.OK_SUCCESS.getCode();
						msg = IbdResponseCodes.OK_SUCCESS.getMsg();
					}
					response.setSuccess(true);
					response.setCode(code);
					response.setMessage(msg);
					response.setTotalRows(totalRows);
					response.setPageLimit(Long.valueOf(req.getPageLimit()));
					response.setPageNum(Long.valueOf(req.getPageNum()));
					response.setListSize(Long.valueOf(list.size()));
					//response.setData(list);
				} else {
					response.setSuccess(true);
					response.setCode(IbdResponseCodes.OK_NOT_FOUND.getCode());
					response.setMessage(IbdResponseCodes.OK_NOT_FOUND.getMsg());
					response.setTotalRows(0L);
					response.setPageLimit(Long.valueOf(req.getPageLimit()));
					response.setPageNum(Long.valueOf(req.getPageNum()));
					response.setListSize(0L);
					//response.setData(new ArrayList<IbdDatOcurrenceEntity>());
				}
			} else {
				response.setSuccess(true);
				response.setCode(IbdResponseCodes.ERROR_BAD_REQUEST.getCode());
				response.setMessage(IbdResponseCodes.ERROR_BAD_REQUEST.getMsg());
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage(),e);
		}

		return response;
	}

}
