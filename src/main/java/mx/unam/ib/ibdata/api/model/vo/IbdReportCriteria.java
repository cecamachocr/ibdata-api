package mx.unam.ib.ibdata.api.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value= "IbdReportCriteria", description = "Descripcion del objeto IbdDatOcurrenceEntity")
public class IbdReportCriteria  extends IbdReportGenericCriteria{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	private Long pageNumReq;
	
	@ApiModelProperty(
			name = "pageLimit"
			,notes = "Numero de registros por pagina solicitados"
//			,dataType = "Long"
			,position = 7)
	private Long pageLimitReq;


	public Long getTotalRows() {
		return totalRows;
	}


	public void setTotalRows(Long totalRows) {
		this.totalRows = totalRows;
	}


	public Long getPageNumReq() {
		return pageNumReq;
	}


	public void setPageNumReq(Long pageNumReq) {
		this.pageNumReq = pageNumReq;
	}


	public Long getPageLimitReq() {
		return pageLimitReq;
	}


	public void setPageLimitReq(Long pageLimitReq) {
		this.pageLimitReq = pageLimitReq;
	}


	@Override
	public String toString() {
		return "IbdReportCriteria [totalRows=" + totalRows + ", pageNumReq=" + pageNumReq + ", pageLimitReq="
				+ pageLimitReq + "]";
	}
	

}
