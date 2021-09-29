package mx.unam.ib.ibdata.api.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.unam.ib.ibdata.api.commons.IbdValidationErrorResponse;
import mx.unam.ib.ibdata.api.model.vo.IbdDatOccurrenceCriteriaVO;
import mx.unam.ib.ibdata.api.model.vo.IbdDatOcurrenceVO;
import mx.unam.ib.ibdata.api.service.IbdDatOccurrenceServiceInterface;
import mx.unam.ib.ibdata.api.utils.IbdContants;

@Api(value = IbdContants.BASE_PATH_V1 + IbdContants.BASE_PATH_MODULE_DAT_OCCURRENCE , tags = {"1: Dat_occurrence"}, description = "Modulo de consultas a dat_occurrence")
@RestController
@RequestMapping(IbdContants.BASE_PATH_V1 + IbdContants.BASE_PATH_MODULE_DAT_OCCURRENCE)
@Validated
public class IbdDatOccurrenceController {
	
	private static final Logger logger = LogManager.getLogger(IbdDatOccurrenceController.class);
	
	@Autowired
	IbdDatOccurrenceServiceInterface service;
	
	
	@ApiOperation(
			value= "findByIdCountry"
			, notes = "Obtiene informacion de occurrence por el id country"
			, nickname = "operation_1")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso finalizado correctamente", response = IbdDatOcurrenceVO.class),
			@ApiResponse(code = 400, message = "Peticion Incorrecta", response = IbdValidationErrorResponse.class),
			@ApiResponse(code = 401, message = "No autorizado", response = Exception.class),
			@ApiResponse(code = 500, message = "Error interno del servidor", response = Exception.class) })
	@RequestMapping(
			path="/findByIdCountry"
			, method = RequestMethod.POST
			, consumes = MediaType.APPLICATION_JSON_VALUE
			, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody ResponseEntity<?> findByIdCountry(HttpServletRequest request, @Valid @RequestBody IbdDatOccurrenceCriteriaVO criteria) throws Exception{
		try {
			
			return ResponseEntity.ok().body(service.findUserByIdCountry(criteria));
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().body(e);
		}
		
		
	}
	
	
	@ApiOperation(
			value= "findByIdCountry"
			, notes = "Obtiene informacion de occurrence por el id country"
			, nickname = "operation_1")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso finalizado correctamente", response = IbdDatOcurrenceVO.class),
			@ApiResponse(code = 400, message = "Peticion Incorrecta", response = IbdValidationErrorResponse.class),
			@ApiResponse(code = 401, message = "No autorizado", response = Exception.class),
			@ApiResponse(code = 500, message = "Error interno del servidor", response = Exception.class) })
	@RequestMapping(
			path="/dao/findByIdCountry"
			, method = RequestMethod.POST
			, consumes = MediaType.APPLICATION_JSON_VALUE
			, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody ResponseEntity<?> findByIdCountryDAO(HttpServletRequest request, @Valid @RequestBody IbdDatOccurrenceCriteriaVO criteria) throws Exception{
		try {
			
			return ResponseEntity.ok().body(service.findUserByIdCountryDAO(criteria));
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().body(e);
		}
		
		
	}
}
