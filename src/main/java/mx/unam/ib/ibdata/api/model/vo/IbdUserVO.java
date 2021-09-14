package mx.unam.ib.ibdata.api.model.vo;

import java.util.UUID;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import mx.unam.ib.ibdata.api.commons.IbdGenericResponse;

@ApiModel(value= "IbdUserVO", description = "Descripcion del objeto IbdUserVO")
public class IbdUserVO extends IbdGenericResponse{
	
	@ApiModelProperty(
			name = "id"
			,notes = "Identificador unico de usuario"
			,example ="93829"
//			,dataType = "Long"
			,position = 1)
	private UUID id;
	
	@ApiModelProperty(
			name = "name"
			,notes = "Nombre de usuario"
			,example ="Jose"
//			,dataType = "String"
			,required = true
			,position = 2)
	private String name;
	
	@ApiModelProperty(
			name = "lastName"
			,notes = "Apellido paterno de usuario"
			,example ="Lopez"
//			,dataType = "String"
			,required = true
			,position = 3)
	private String lastName;
	
	@ApiModelProperty(
			name = "phoneNumber"
			,notes = "Numero celular del usuario"
			,example ="5555555555"
//			,dataType = "Long"
			,required = true
			,position = 4)
	private Long phoneNumber;
	
	@ApiModelProperty(
			name = "message"
			,notes = "Mensaje de proceso"
			,example ="mensaje de proceso"
//			,dataType = "String"
			,position = 5)
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
