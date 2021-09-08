package mx.com.unam.ib.ibdata.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.unam.ib.ibdata.api.model.entity.IbdUserEntity;
import mx.com.unam.ib.ibdata.api.model.vo.IbdUserVO;
import mx.com.unam.ib.ibdata.api.repository.IbdUserRepository;

@Service
public class IbdServiceDemoImpl implements IbdServiceDemoInterface{

	
	@Autowired
	IbdUserRepository userRepository;
	@Override
	public IbdUserVO findUserByName(IbdUserVO req) throws Exception {
		IbdUserEntity resEntity = null;
		
		IbdUserVO res = null;
		try {
			
			List<IbdUserEntity> listUser = userRepository.findByName(req.getName());
			
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
			
			System.out.println("getUser():" + res.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
