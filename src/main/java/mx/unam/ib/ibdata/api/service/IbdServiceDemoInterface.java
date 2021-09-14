package mx.unam.ib.ibdata.api.service;

import mx.unam.ib.ibdata.api.model.vo.IbdUserVO;

public interface IbdServiceDemoInterface {
	
	public IbdUserVO findUserByName(IbdUserVO req) throws Exception;
}
