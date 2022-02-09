package mx.unam.ib.ibdata.api.controllers;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.unam.ib.ibdata.api.commons.IbdValidationErrorResponse;
import mx.unam.ib.ibdata.api.model.vo.IbdReportCriteria;
import mx.unam.ib.ibdata.api.service.IbdGenericReportServiceInterface;
import mx.unam.ib.ibdata.api.utils.IbdContants;

@Api(value = IbdContants.BASE_PATH_V1 + IbdContants.BASE_PATH_MODULE_REPORT_GENERIC, tags = {
		"2: REPORTES GENERICOS " }, description = "Modulo de reportes genericos")
@RestController
@RequestMapping(IbdContants.BASE_PATH_V1 + IbdContants.BASE_PATH_MODULE_REPORT_GENERIC)
@Validated
public class IbdGenericReportController {

	private static final Logger logger = LoggerFactory.getLogger(IbdGenericReportController.class);

	@Autowired
	IbdGenericReportServiceInterface service;

	@ApiOperation(value = "downloadReport", notes = "Descargar reportes en archivos en formatos .xlsx", nickname = "operation_1", position = 1)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Archivo creado", response = ByteArrayResource.class),
			@ApiResponse(code = 400, message = "Peticion Incorrecta", response = IbdValidationErrorResponse.class),
			@ApiResponse(code = 401, message = "No autorizado", response = Exception.class),
			@ApiResponse(code = 500, message = "Error interno del servidor", response = Exception.class) })
	@RequestMapping(path = "/downloadReport", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<?> downloadReport(HttpServletRequest request, @Valid @RequestBody IbdReportCriteria criteria)
			throws Exception {
		try {
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "force-download"));
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString() + ".xlsx";

			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
			ByteArrayOutputStream stream = service.downloadReport(criteria);
			logger.error(criteria.toString());
			return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()), header, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = IbdContants.PATH_SERVICE_REPORT_DOWNLOAD, notes = "Descargar reportes en archivos en formatos .xlsx", nickname = "operation_2", position = 2)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Archivo creado", response = ByteArrayResource.class),
			@ApiResponse(code = 400, message = "Peticion Incorrecta", response = IbdValidationErrorResponse.class),
			@ApiResponse(code = 401, message = "No autorizado", response = Exception.class),
			@ApiResponse(code = 500, message = "Error interno del servidor", response = Exception.class) })
	@RequestMapping(path = IbdContants.PATH_SERVICE_REPORT_DOWNLOAD, method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<?> downloadFileReport(HttpServletRequest req, HttpServletResponse res, @RequestParam String query)
			throws Exception {
		try {
		    
		    HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "force-download"));
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString() + ".xlsx";

			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
			ByteArrayOutputStream stream = service.downloadFileReport(query);
			return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()), header, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
