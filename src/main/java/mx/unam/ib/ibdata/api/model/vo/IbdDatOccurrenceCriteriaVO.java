package mx.unam.ib.ibdata.api.model.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value= "IbdCriteriaDatOccurrenceVO", description = "Objeto del consulta para la entidad dat_occurrence")
public class IbdDatOccurrenceCriteriaVO  extends IbdGenericCriteria{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5219264200528665698L;
	
	
	@ApiModelProperty(
			name = "occurrenceId"
			,notes = "Identificador unico de registro"
			,example ="IBUNAM:MEXU:14622"
//			,dataType = "Long"
			,position = 1)
	private String occurrence_id;
	
	@ApiModelProperty(
			name = "state"
			,notes = "state"
			,example ="Estado"
//			,dataType = "Long"
			,position = 5)
	private String state;
	
	@ApiModelProperty(
			name = "grupo_biologico"
			,notes = "grupo_biologico"
			,example ="grupo_biologico"
//			,dataType = "Long"
			,position = 5)
	private String grupo_biologico;

	public String getOccurrence_id() {
		return occurrence_id;
	}

	public void setOccurrence_id(String occurrence_id) {
		this.occurrence_id = occurrence_id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGrupo_biologico() {
		return grupo_biologico;
	}

	public void setGrupo_biologico(String grupo_biologico) {
		this.grupo_biologico = grupo_biologico;
	}
	
	
}
