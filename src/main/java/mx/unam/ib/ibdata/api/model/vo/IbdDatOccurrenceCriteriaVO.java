package mx.unam.ib.ibdata.api.model.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value= "IbdCriteriaDatOccurrenceVO", description = "Objeto del consulta para la tabla dat_occurrence")
public class IbdDatOccurrenceCriteriaVO  extends IbdCriteriaGeneric{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5219264200528665698L;
	
	
	@ApiModelProperty(
			name = "occurrenceId"
			,notes = "Identificador unico de registro"
			,example ="IBUNAM:MEXU:001010"
//			,dataType = "Long"
			,position = 1)
	private String occurrenceId;
	
	@ApiModelProperty(
			name = "idCountry"
			,notes = "Identificador unico de pais"
			,example ="1010"
//			,dataType = "Long"
			,position = 2)
	@Min(1)
	@NotNull
	private Integer idCountry;
	
	
	@ApiModelProperty(
			name = "scientificName"
			,notes = "Nombre cientifico"
			,example ="Randia aculeata L"
//			,dataType = "Long"
			,position = 3)
	private String scientificName;
	
	
	@ApiModelProperty(
			name = "acceptedNameUsage"
			,notes = "Nombre aceptado en uso"
			,example ="Randia aculeata L"
//			,dataType = "Long"
			,position = 4)
	private String acceptedNameUsage;

	public String getOccurrenceId() {
		return occurrenceId;
	}

	public void setOccurrenceId(String occurrenceId) {
		this.occurrenceId = occurrenceId;
	}

	public Integer getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Integer idCountry) {
		this.idCountry = idCountry;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public String getAcceptedNameUsage() {
		return acceptedNameUsage;
	}

	public void setAcceptedNameUsage(String acceptedNameUsage) {
		this.acceptedNameUsage = acceptedNameUsage;
	}
	
	
}
