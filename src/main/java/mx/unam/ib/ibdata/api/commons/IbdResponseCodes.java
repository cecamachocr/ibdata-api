package mx.unam.ib.ibdata.api.commons;

public enum IbdResponseCodes {
	
	//success
	OK_SUCCESS("01","Procesado correctamente"),
	OK_NOT_FOUND("02","Sin resultados"),
	
	//erros
	ERROR_INTERNAL_ERROR("-1", "Error inesperado"),
	ERROR_BAD_REQUEST("-2","Petición incorrecta"),
	ERROR_HTTPS_400_BAD_REQUEST("400", "Bad Request")
	;
	
	private final String code;
	private final String msg;
	
	private IbdResponseCodes(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	
}
