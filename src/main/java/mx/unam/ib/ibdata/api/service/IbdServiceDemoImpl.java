package mx.unam.ib.ibdata.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mx.unam.ib.ibdata.api.dao.IbdDatOcurrenceDAOInterface;
import mx.unam.ib.ibdata.api.dao.IbdDemoDAOInterface;
import mx.unam.ib.ibdata.api.model.entity.IbdDatOcurrenceEntity;
import mx.unam.ib.ibdata.api.model.vo.IbdUserVO;
import mx.unam.ib.ibdata.api.repository.IbdDatOcurrenceRepository;
import mx.unam.ib.ibdata.api.repository.IbdUserRepository;

@Service
public class IbdServiceDemoImpl implements IbdServiceDemoInterface{

	private static final Logger logger = LoggerFactory.getLogger(IbdServiceDemoImpl.class);
	
	@Autowired
	IbdUserRepository userRepository;
	
	@Autowired
	IbdDemoDAOInterface ibdDemoDAO;
	
	@Autowired
	IbdDatOcurrenceDAOInterface ibdDatOcurrenceDAO;
	
	@Autowired
	IbdDatOcurrenceRepository ibdDatOcurrenceRepository;
	
	
	@Override
	public IbdUserVO findUserByName(IbdUserVO req) throws Exception {
		
		IbdUserVO res = null;
		
		try {
			ibdDatOcurrenceDAO.callFunctionGetByIdCountry(100108, 0,10);
			
			Pageable firstPageWithTenElements = PageRequest.of(0, 10);
			
			List<IbdDatOcurrenceEntity> list = ibdDatOcurrenceRepository.findAllByIdCountryOrderByOccurrenceIdDesc(100108, firstPageWithTenElements);
			if(list != null) {
				for(IbdDatOcurrenceEntity e : list) {
					logger.error(e.getOccurrenceId());
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage(),e);
		}
		try {
			
//			List<IbdUserEntity> listUser = userRepository.findByNameAndLastName(req.getName(), req.getLastName());
//		
//			
//			if(listUser != null && !listUser.isEmpty()) {
//				resEntity = listUser.get(0);
//			}
//			
//			if(resEntity != null) {
//				res = new IbdUserVO();
//				res.setId(resEntity.getId());
//				res.setName(resEntity.getName());
//				res.setLastName(resEntity.getLastName());
//				res.setPhoneNumber(resEntity.getPhoneNumber());
//				res.setSuccess(true);
//				res.setCode("01");
//				res.setMessage("Usuario encontrado");
//			}
			
//			ibdDemoDAO.callFunction();
			
//			logger.error("getUser():" + res.getName());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage(),e);
		}
		return res;
	}

}
