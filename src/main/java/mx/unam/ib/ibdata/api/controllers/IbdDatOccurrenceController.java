package mx.unam.ib.ibdata.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.unam.ib.ibdata.api.service.IbdDatOccurrenceServiceInterface;
import mx.unam.ib.ibdata.api.utils.IbdContants;

//@Api(value = IbdContants.BASE_PATH_V1 + IbdContants.BASE_PATH_MODULE_DAT_OCCURRENCE , tags = {"1: DAT OCCURRENCE"}, description = "Modulo de consultas a dat_occurrence")
@RestController
@RequestMapping(IbdContants.BASE_PATH_V1 + IbdContants.BASE_PATH_MODULE_DAT_OCCURRENCE)
@Validated
public class IbdDatOccurrenceController {
	
	//private static final Logger logger = LoggerFactory.getLogger(IbdDatOccurrenceController.class);
	
	@Autowired
	IbdDatOccurrenceServiceInterface service;
	
	
//	@ApiOperation(
//			value= "findByIdCountry"
//			, notes = "Obtiene informacion de occurrence por el id country"
//			, nickname = "operation_1"
//			, position = 1)
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Proceso finalizado correctamente", response = IbdDatOcurrenceVO.class),
//			@ApiResponse(code = 400, message = "Peticion Incorrecta", response = IbdValidationErrorResponse.class),
//			@ApiResponse(code = 401, message = "No autorizado", response = Exception.class),
//			@ApiResponse(code = 500, message = "Error interno del servidor", response = Exception.class) })
//	@RequestMapping(
//			path="/findByIdCountry"
//			, method = RequestMethod.POST
//			, consumes = MediaType.APPLICATION_JSON_VALUE
//			, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody ResponseEntity<?> findByIdCountry(HttpServletRequest request, @Valid @RequestBody IbdDatOccurrenceCriteriaVO criteria) throws Exception{
//		try {
//			
//			return ResponseEntity.ok().body(service.findUserByIdCountry(criteria));
//			
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			return ResponseEntity.internalServerError().body(e);
//		}
//		
//		
//	}
	
	
//	@ApiOperation(
//			value= "findByIdCountry"
//			, notes = "Obtiene informacion de occurrence por el id country"
//			, nickname = "operation_2"
//			, position = 2)
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Proceso finalizado correctamente", response = IbdDatOcurrenceVO.class),
//			@ApiResponse(code = 400, message = "Peticion Incorrecta", response = IbdValidationErrorResponse.class),
//			@ApiResponse(code = 401, message = "No autorizado", response = Exception.class),
//			@ApiResponse(code = 500, message = "Error interno del servidor", response = Exception.class) })
//	@RequestMapping(
//			path="/dao/findByIdCountry"
//			, method = RequestMethod.POST
//			, consumes = MediaType.APPLICATION_JSON_VALUE
//			, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody ResponseEntity<?> findByIdCountryDAO(HttpServletRequest request, @Valid @RequestBody IbdDatOccurrenceCriteriaVO criteria) throws Exception{
//		try {
//			
//			return ResponseEntity.ok().body(service.findUserByIdCountryDAO(criteria));
//			
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			return ResponseEntity.internalServerError().body(e);
//		}
//		
//		
//	}
      
}
