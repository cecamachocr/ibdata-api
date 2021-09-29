package mx.unam.ib.ibdata.api.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mx.unam.ib.ibdata.api.commons.IbdResponseCodes;
import mx.unam.ib.ibdata.api.dao.IbdDatOcurrenceDAOInterface;
import mx.unam.ib.ibdata.api.dao.IbdDemoDAOInterface;
import mx.unam.ib.ibdata.api.model.entity.IbdDatOcurrenceEntity;
import mx.unam.ib.ibdata.api.model.vo.IbdDatOccurrenceCriteriaVO;
import mx.unam.ib.ibdata.api.model.vo.IbdDatOcurrenceVO;
import mx.unam.ib.ibdata.api.repository.IbdDatOcurrenceRepository;
import mx.unam.ib.ibdata.api.repository.IbdUserRepository;

@Service
public class IbdDatOccurrenceServiceImpl implements IbdDatOccurrenceServiceInterface{

	private static final Logger logger = LogManager.getLogger(IbdDatOccurrenceServiceImpl.class);
	
	@Autowired
	IbdUserRepository userRepository;
	
	@Autowired
	IbdDemoDAOInterface ibdDemoDAO;
	
	@Autowired
	IbdDatOcurrenceDAOInterface ibdDatOcurrenceDAO;
	
	@Autowired
	IbdDatOcurrenceRepository ibdDatOcurrenceRepository;
	
	
	@Override
	public IbdDatOcurrenceVO findUserByIdCountry(IbdDatOccurrenceCriteriaVO req) throws Exception {
		
		IbdDatOcurrenceVO response = new IbdDatOcurrenceVO();
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
					response.setData(list);
				} else {
					response.setSuccess(true);
					response.setCode(IbdResponseCodes.OK_NOT_FOUND.getCode());
					response.setMessage(IbdResponseCodes.OK_NOT_FOUND.getMsg());
					response.setTotalRows(0L);
					response.setPageLimit(Long.valueOf(req.getPageLimit()));
					response.setPageNum(Long.valueOf(req.getPageNum()));
					response.setListSize(0L);
					response.setData(new ArrayList<IbdDatOcurrenceEntity>());
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
	public IbdDatOcurrenceVO findUserByIdCountryDAO(IbdDatOccurrenceCriteriaVO req) throws Exception {
		
		IbdDatOcurrenceVO response = new IbdDatOcurrenceVO();
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
					response.setData(list);
				} else {
					response.setSuccess(true);
					response.setCode(IbdResponseCodes.OK_NOT_FOUND.getCode());
					response.setMessage(IbdResponseCodes.OK_NOT_FOUND.getMsg());
					response.setTotalRows(0L);
					response.setPageLimit(Long.valueOf(req.getPageLimit()));
					response.setPageNum(Long.valueOf(req.getPageNum()));
					response.setListSize(0L);
					response.setData(new ArrayList<IbdDatOcurrenceEntity>());
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
