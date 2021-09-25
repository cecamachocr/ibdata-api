package mx.unam.ib.ibdata.api.model.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value= "IbdCriteriaGeneric", description = "Objeto generico de criterios de busqueda")
public class IbdCriteriaGeneric implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2655331247639483694L;
	
	
	@ApiModelProperty(
			name = "pageNum"
			,notes = "Numero de pagina de consulta"
			,example ="1"
//			,dataType = "Long"
			,position = 1)
	private int pageNum;
	
	
	@ApiModelProperty(
			name = "pageNum"
			,notes = "Numero de registros por pagina"
			,example ="1"
//			,dataType = "Long"
			,position = 2)
	private int pageLimit;

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
