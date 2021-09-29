package mx.unam.ib.ibdata.api.commons;

public class IbdViolation {
	
	public IbdViolation(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	private String fieldName;
	
	private String message;

	public String getFieldName() {
		return fieldName;
	}

	public String getMessage() {
		return message;
	}
	
	
	
}
