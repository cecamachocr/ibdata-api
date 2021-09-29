package mx.unam.ib.ibdata.api.model.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import mx.unam.ib.ibdata.api.model.entity.IbdDatOcurrenceEntity;


@ApiModel(value= "IbdDatOcurrenceVO", description = "Descripcion del objeto IbdDatOcurrenceEntity")
public class IbdDatOcurrenceVO  extends IbdGenericResponseVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(
			name = "listSize"
			,notes = "Tamanio de la lista de respuesta"
//			,dataType = "Long"
			,position = 4)
	private Long listSize;
	
	@ApiModelProperty(
			name = "totalRows"
			,notes = "Numero total de registros de la consulta"
//			,dataType = "Long"
			,position = 5)
	private Long totalRows;
	
	@ApiModelProperty(
			name = "pageNum"
			,notes = "Numero de pagina consultada"
//			,dataType = "Long"
			,position = 6)
	private Long pageNum;
	
	@ApiModelProperty(
			name = "pageLimit"
			,notes = "Numero de registros por pagina"
//			,dataType = "Long"
			,position = 7)
	private Long pageLimit;
	
	
	@ApiModelProperty(
			name = "data"
			,notes = "respuesta del servicio"
//			,dataType = "Long"
			,position = 8)
	List<IbdDatOcurrenceEntity> data;


	public Long getListSize() {
		return listSize;
	}


	public void setListSize(Long listSize) {
		this.listSize = listSize;
	}


	public Long getTotalRows() {
		return totalRows;
	}


	public void setTotalRows(Long totalRows) {
		this.totalRows = totalRows;
	}


	public Long getPageNum() {
		return pageNum;
	}


	public void setPageNum(Long pageNum) {
		this.pageNum = pageNum;
	}


	public Long getPageLimit() {
		return pageLimit;
	}


	public void setPageLimit(Long pageLimit) {
		this.pageLimit = pageLimit;
	}


	public List<IbdDatOcurrenceEntity> getData() {
		return data;
	}


	public void setData(List<IbdDatOcurrenceEntity> data) {
		this.data = data;
	}

}
