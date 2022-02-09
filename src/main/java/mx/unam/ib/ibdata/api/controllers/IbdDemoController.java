package mx.unam.ib.ibdata.api.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.unam.ib.ibdata.api.model.vo.IbdUserVO;
import mx.unam.ib.ibdata.api.service.IbdServiceDemoInterface;

//@Api(value = IbdContants.BASE_PATH_V1 + IbdContants.BASE_PATH_M1 , tags = {"1: DEMO"}, description = "Modulo de...")
//@RestController
//@RequestMapping(IbdContants.BASE_PATH_V1 + IbdContants.BASE_PATH_M1)
public class IbdDemoController {
	
	private static final Logger logger = LoggerFactory.getLogger(IbdDemoController.class);
	
	@Autowired
	IbdServiceDemoInterface service;
	
	
//	@ApiOperation(
//			value= "findUserByName"
//			, notes = "Obtiene ..."
//			, nickname = "operation_1")
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Proceso finalizado correctamente", response = IbdUserVO.class),
//			@ApiResponse(code = 400, message = "Peticion Incorrecta", response = String.class),
//			@ApiResponse(code = 401, message = "No autorizado", response = Exception.class),
//			@ApiResponse(code = 500, message = "Error interno del servidor", response = Exception.class) })
	@RequestMapping(
			path="/findUserByName"
			, method = RequestMethod.POST
			, consumes = MediaType.APPLICATION_JSON_VALUE
			, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody IbdUserVO getUserRamdom(  HttpServletRequest request, @RequestBody IbdUserVO userVOReq) throws Exception{
		try {
			
			IbdUserVO res = service.findUserByName(userVOReq);
			return res;
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		
		
	}

}
