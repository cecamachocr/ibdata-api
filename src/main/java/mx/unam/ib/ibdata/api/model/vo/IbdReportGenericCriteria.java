package mx.unam.ib.ibdata.api.model.vo;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value= "IbdReportGenericCriteria", description = "Objeto generico de criterios de busqueda para reportes")
public class IbdReportGenericCriteria implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2655331247639483694L;
	
	@ApiModelProperty(
			name = "reportId"
			,notes = "Identificador unico de reporte"
//			,dataType = "Long"
			,position = 4)
	private Long reportId;
	
	
	@ApiModelProperty(
			name = "pageNum"
			,notes = "Numero de pagina solicitada"
			,example ="1"
//			,dataType = "Long"
			,position = 1)
	@Min(1)
	@Max(10000)
	private int pageNum;
	
	
	@ApiModelProperty(
			name = "pageLimit"
			,notes = "Numero de registros por pagina solicitados"
			,example ="1"
//			,dataType = "Long"
			,position = 2)
	@Min(1)
	@Max(100)
	private int pageLimit;


	public Long getReportId() {
		return reportId;
	}


	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public int getPageLimit() {
		return pageLimit;
	}


	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}


	
	
	
}
