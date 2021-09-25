package mx.unam.ib.ibdata.api.model.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import mx.unam.ib.ibdata.api.model.entity.IbdDatOcurrenceEntity;


@ApiModel(value= "IbdDatOcurrenceVO", description = "Descripcion del objeto IbdDatOcurrenceEntity")
public class IbdDatOcurrenceVO  extends IbdGenericResponseVO{

	
	@ApiModelProperty(
			name = "data"
			,notes = "respuesta del servicio"
//			,dataType = "Long"
			,position = 4)
	List<IbdDatOcurrenceEntity> data;

	public List<IbdDatOcurrenceEntity> getData() {
		return data;
	}

	public void setData(List<IbdDatOcurrenceEntity> data) {
		this.data = data;
	}
	
	

}
