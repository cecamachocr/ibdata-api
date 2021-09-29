package mx.unam.ib.ibdata.api.model.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value= "IbdGenericResponseVO", description = "Objeto generico de respuesta")
public class IbdGenericResponseVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(
			name = "success"
			,notes = "indicador de proceso exitoso"
			,example ="false"
//			,dataType = "Long"
			,position = 1)
	private boolean success;
	
	@ApiModelProperty(
			name = "code"
			,notes = "Codigo de proceso"
			,example ="01"
//			,dataType = "Long"
			,position = 2)
	private String code;
	
	@ApiModelProperty(
			name = "message"
			,notes = "Mensaje de proceso"
			,example ="Proceso ejecutado correctamente"
//			,dataType = "Long"
			,position = 3)
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
