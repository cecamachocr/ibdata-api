package mx.unam.ib.ibdata.api.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import mx.unam.ib.ibdata.api.model.vo.IbdDatOcurrenceResponse;
import mx.unam.ib.ibdata.api.service.IbdDatOccurrenceServiceInterface;
import mx.unam.ib.ibdata.api.utils.IbdContants;

@Api(value = IbdContants.BASE_PATH_V1 + IbdContants.BASE_PATH_MODULE_DAT_OCCURRENCE, 
tags = {"1: DAT_OCURRENCE " }, description = "Modulo de servicios para dat_ocurrence")
@RestController
@RequestMapping(IbdContants.BASE_PATH_V1 + IbdContants.BASE_PATH_MODULE_DAT_OCCURRENCE)
@Validated
public class IbdDatOcurrenceMongoController extends IbdGenericController{
	
	private static final Logger logger = LoggerFactory.getLogger(IbdDatOcurrenceMongoController.class);
	
	@Autowired
	private IbdDatOccurrenceServiceInterface service;
	
	@ApiOperation(
			value= "findByCriteria"
			, notes = "Obtiene informacion de dat_ocurrence"
			, nickname = "operation_1"
			, position = 1)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso finalizado correctamente", response = IbdDatOcurrenceResponse.class),
			@ApiResponse(code = 400, message = "Peticion Incorrecta", response = IbdValidationErrorResponse.class),
			@ApiResponse(code = 401, message = "No autorizado", response = Exception.class),
			@ApiResponse(code = 500, message = "Error interno del servidor", response = Exception.class) })
	@RequestMapping(
			path="/findByCriteria"
			, method = RequestMethod.POST
			, consumes = MediaType.APPLICATION_JSON_VALUE
			, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody ResponseEntity<?> findByCriteria(HttpServletRequest req, HttpServletResponse res, @Valid @RequestBody IbdDatOccurrenceCriteriaVO criteria) throws Exception{
		try {
			criteria.setUrlServer(getUrlServer(req));
			criteria.setFromAPI(true);
			return ResponseEntity.ok().body(service.findByCriteriaLimit(criteria));
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().body(e);
		}
		
		
	}

}
