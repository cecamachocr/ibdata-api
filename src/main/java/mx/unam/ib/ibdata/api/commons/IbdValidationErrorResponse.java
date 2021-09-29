package mx.unam.ib.ibdata.api.commons;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "IbdValidationErrorResponse", description = "Respuesta generica de petición incorrecta")
public class IbdValidationErrorResponse  extends IbdGenericResponse {
	
	
	private List<IbdViolation> violations = new ArrayList<IbdViolation>();

	public List<IbdViolation> getViolations() {
		return violations;
	}

	public void setViolations(List<IbdViolation> violations) {
		this.violations = violations;
	}
	
	
}
