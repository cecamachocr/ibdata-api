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
	
	private String urlServer;

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
	
	
	
}
