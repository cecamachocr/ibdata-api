package mx.unam.ib.ibdata.api.model.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import mx.unam.ib.ibdata.api.model.collection.IbdDatOcurrenceCollection;


@ApiModel(value= "IbdDatOcurrenceResponse", description = "Descripcion del objeto IbdDatOcurrenceEntity")
public class IbdDatOcurrenceResponse  extends IbdGenericResponseVO{

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
			name = "urlDownloadReport"
			,notes = "Url para descargar reporte en formato .xlsx"
//			,dataType = "Long"
			,position = 8)
	private List<String> urlDownloadReport;
	
	
	@ApiModelProperty(
			name = "executionTime"
			,notes = "tiempo de ejecucion en segundos"
//			,dataType = "Long"
			,position = 9)
	private Double executionTime;
	
	@ApiModelProperty(
			name = "data"
			,notes = "Datos de respuesta del servicio"
//			,dataType = "Long"
			,position = 10)
	private List<IbdDatOcurrenceCollection> data;

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

	public List<String> getUrlDownloadReport() {
		return urlDownloadReport;
	}

	public void setUrlDownloadReport(List<String> urlDownloadReport) {
		this.urlDownloadReport = urlDownloadReport;
	}

	public Double getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Double executionTime) {
		this.executionTime = executionTime;
	}

	public List<IbdDatOcurrenceCollection> getData() {
		return data;
	}

	public void setData(List<IbdDatOcurrenceCollection> data) {
		this.data = data;
	}

}
