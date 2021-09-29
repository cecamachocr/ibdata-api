package mx.unam.ib.ibdata.api.commons.controller;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mx.unam.ib.ibdata.api.commons.IbdResponseCodes;
import mx.unam.ib.ibdata.api.commons.IbdValidationErrorResponse;
import mx.unam.ib.ibdata.api.commons.IbdViolation;

@ControllerAdvice
public class IbdErrorHandlingControllerAdvice {

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	IbdValidationErrorResponse onConstraintValidationException(ConstraintViolationException e) {
		IbdValidationErrorResponse error = new IbdValidationErrorResponse();
		error.setSuccess(false);
		error.setCode(IbdResponseCodes.ERROR_HTTPS_400_BAD_REQUEST.getCode());
		error.setMessage(IbdResponseCodes.ERROR_HTTPS_400_BAD_REQUEST.getMsg());
		for (ConstraintViolation violation : e.getConstraintViolations()) {
			error.getViolations().add(new IbdViolation(violation.getPropertyPath().toString(), violation.getMessage()));
		}
		return error;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	IbdValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		IbdValidationErrorResponse error = new IbdValidationErrorResponse();
		error.setSuccess(false);
		error.setCode(IbdResponseCodes.ERROR_HTTPS_400_BAD_REQUEST.getCode());
		error.setMessage(IbdResponseCodes.ERROR_HTTPS_400_BAD_REQUEST.getMsg());
		
		for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			error.getViolations().add(new IbdViolation(fieldError.getField(), fieldError.getDefaultMessage()));
		}
		return error;
	}
}
