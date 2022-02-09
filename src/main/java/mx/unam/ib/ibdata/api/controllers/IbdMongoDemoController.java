package mx.unam.ib.ibdata.api.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.unam.ib.ibdata.api.model.vo.IbdDatOccurrenceCriteriaVO;
import mx.unam.ib.ibdata.api.utils.IbdContants;

//@Api(value = IbdContants.BASE_PATH_V1 + IbdContants.BASE_PATH_MODULE_MONGO, 
//tags = {"3: DAT_OCURRENCE " }, description = "Modulo de servicios para dat_ocurrence")
@RestController
@RequestMapping(IbdContants.BASE_PATH_V1 + IbdContants.BASE_PATH_MODULE_MONGO)
@Validated
public class IbdMongoDemoController {
	
	private static final Logger logger = LoggerFactory.getLogger(IbdMongoDemoController.class);
	
//	@Autowired
//	private IbdCommentServiceInterface service;
	
//	@ApiOperation(
//			value= "findByName"
//			, notes = "Obtiene informacion de comments por el name"
//			, nickname = "operation_1"
//			, position = 1)
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Proceso finalizado correctamente", response = IbdComment.class),
//			@ApiResponse(code = 400, message = "Peticion Incorrecta", response = IbdValidationErrorResponse.class),
//			@ApiResponse(code = 401, message = "No autorizado", response = Exception.class),
//			@ApiResponse(code = 500, message = "Error interno del servidor", response = Exception.class) })
//	@RequestMapping(
//			path="/findByName"
//			, method = RequestMethod.POST
//			, consumes = MediaType.APPLICATION_JSON_VALUE
//			, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody ResponseEntity<?> findByName(HttpServletRequest request, @Valid @RequestBody IbdDatOccurrenceCriteriaVO criteria) throws Exception{
		try {
			
			return ResponseEntity.ok().body(null//service.findByName(criteria)
					);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().body(e);
		}
		
		
	}

}
