package mx.com.unam.ib.ibdata.api.commons;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IbdGenericResponse", description = "Respuesta generica")
public class IbdGenericResponse {
	
	@ApiModelProperty(name ="success", notes="Indicador de proceso completo", example = "false", position = 1)
	private boolean success;
	
	@ApiModelProperty(name ="code", notes="Codigo de respuesta", example = "", position = 2)
	private String code;
	
	@ApiModelProperty(name ="success", notes="Mensaje de respuesta", example = "", position = 3)
	private String message;

	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
