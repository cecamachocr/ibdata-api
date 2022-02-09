package mx.unam.ib.ibdata.api.model.vo;

import java.util.TreeMap;

public class IbdExecuteServiceVO {
	
	private String serviceClass;
	
	private String interfaceClass;
	
	private String methodName;
	
	private String returnTypeName;
	
	private TreeMap<Integer, IbdClaveValor> params;

	public String getServiceClass() {
		return serviceClass;
	}

	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}

	public String getInterfaceClass() {
		return interfaceClass;
	}

	public void setInterfaceClass(String interfaceClass) {
		this.interfaceClass = interfaceClass;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getReturnTypeName() {
		return returnTypeName;
	}

	public void setReturnTypeName(String returnTypeName) {
		this.returnTypeName = returnTypeName;
	}

	public TreeMap<Integer, IbdClaveValor> getParams() {
		return params;
	}

	public void setParams(TreeMap<Integer, IbdClaveValor> params) {
		this.params = params;
	}


	
}
