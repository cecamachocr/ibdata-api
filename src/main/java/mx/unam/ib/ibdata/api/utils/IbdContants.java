package mx.unam.ib.ibdata.api.utils;

public class IbdContants {
	
	public static final String BASE_PATH_V1 = "/api-v1";
	
	public static final String BASE_PATH_M1 = "/demo";
	
	public static final String BASE_PATH_MODULE_DAT_OCCURRENCE = "/datOccurrence";
	
	public static final String BASE_PATH_MODULE_REPORT_GENERIC = "/report/generic";
	
	public static final String BASE_PATH_MODULE_MONGO = "/mongo/";
	
	
	public static final String SCHEMA_VHO_PUBLIC = "public";
	
	public static final String SCHEMA_VHO_IBDATA_API = "ibdata_api";
	
	
	public static final String PATH_SERVICE_REPORT_DOWNLOAD = "/downloadFileReport";
	
	
	public static final String PATH_DONWLOAD_REPORT = IbdContants.BASE_PATH_V1 + IbdContants.BASE_PATH_MODULE_REPORT_GENERIC + IbdContants.PATH_SERVICE_REPORT_DOWNLOAD+ "?query=";
}
