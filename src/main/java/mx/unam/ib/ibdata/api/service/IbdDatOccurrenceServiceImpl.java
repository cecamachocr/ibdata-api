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
		
		List<IbdDatOcurrenceEntity> res = new ArrayList<IbdDatOcurrenceEntity>();
		
		IbdDatOcurrenceVO response = new IbdDatOcurrenceVO();
		try {
			
			if(req!= null) {
				
				ibdDatOcurrenceDAO.callFunctionGetByIdCountry(req.getIdCountry(), req.getPageNum(), req.getPageLimit());
				
				Pageable pageable = PageRequest.of(req.getPageNum() - 1, req.getPageLimit());
				
				List<IbdDatOcurrenceEntity> list = ibdDatOcurrenceRepository.findAllByIdCountryOrderByOccurrenceIdDesc(req.getIdCountry(), pageable);
				
				if(list != null) {
					for(IbdDatOcurrenceEntity e : list) {
						
						
						res.add(e);
						logger.error(e.getOccurrenceId());
					}
					
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
					response.setData(list);
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
