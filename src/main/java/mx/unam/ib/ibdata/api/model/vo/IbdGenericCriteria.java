package mx.unam.ib.ibdata.api.model.vo;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value= "IbdGenericCriteria", description = "Objeto generico de criterios de busqueda")
public class IbdGenericCriteria implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2655331247639483694L;
	
	
	@ApiModelProperty(
			name = "pageNum"
			,notes = "Numero de pagina consultada"
			,example ="1"
//			,dataType = "Long"
			,position = 1)
	@Min(1)
	@Max(100000)
	private int pageNum;
	
	
	@ApiModelProperty(
			name = "pageLimit"
			,notes = "Numero de registros por pagina solicitados"
			,example ="1"
//			,dataType = "Long"
			,position = 2)
	@Min(1)
	@Max(100000)
	private int pageLimit;
	
	
	@ApiModelProperty(
			name = "urlServer"
			,notes = "servidor"
			,example ="https//localhost:8443/"
//			,dataType = "Long"
			,position = 3
			,hidden = true)
	private String urlServer;
	
	@ApiModelProperty(
			name = "isFromAPI"
			,notes = "isFromAPI"
			,example ="false"
//			,dataType = "Long"
			,position = 4
			,hidden = true)
	private boolean isFromAPI;
	
	
	@ApiModelProperty(
			name = "totalRows"
			,notes = "Numero total de registros de la consulta"
			,example ="1"
//			,dataType = "Long"
			,position = 1)
	private Long totalRows;

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

	public String getUrlServer() {
		return urlServer;
	}

	public void setUrlServer(String urlServer) {
		this.urlServer = urlServer;
	}

	public boolean isFromAPI() {
		return isFromAPI;
	}

	public void setFromAPI(boolean isFromAPI) {
		this.isFromAPI = isFromAPI;
	}

	public Long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Long totalRows) {
		this.totalRows = totalRows;
	}
	
	
	
}
