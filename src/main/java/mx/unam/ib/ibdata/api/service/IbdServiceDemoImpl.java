package mx.unam.ib.ibdata.api.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.unam.ib.ibdata.api.dao.IbdDemoDAOInterface;
import mx.unam.ib.ibdata.api.model.entity.IbdUserEntity;
import mx.unam.ib.ibdata.api.model.vo.IbdUserVO;
import mx.unam.ib.ibdata.api.repository.IbdUserRepository;

@Service
public class IbdServiceDemoImpl implements IbdServiceDemoInterface{

	private static final Logger logger = LogManager.getLogger(IbdServiceDemoImpl.class);
	
	@Autowired
	IbdUserRepository userRepository;
	
	@Autowired
	IbdDemoDAOInterface ibdDemoDAO;
	
	
	@Override
	public IbdUserVO findUserByName(IbdUserVO req) throws Exception {
		IbdUserEntity resEntity = null;
		
		IbdUserVO res = null;
		try {
			
			List<IbdUserEntity> listUser = userRepository.findByNameAndLastName(req.getName(), req.getLastName());
		
			
			if(listUser != null && !listUser.isEmpty()) {
				resEntity = listUser.get(0);
			}
			
			if(resEntity != null) {
				res = new IbdUserVO();
				res.setId(resEntity.getId());
				res.setName(resEntity.getName());
				res.setLastName(resEntity.getLastName());
				res.setPhoneNumber(resEntity.getPhoneNumber());
				res.setSuccess(true);
				res.setCode("01");
				res.setMessage("Usuario encontrado");
			}
			
			ibdDemoDAO.callFunction();
			
			logger.error("getUser():" + res.getName());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return res;
	}

}
