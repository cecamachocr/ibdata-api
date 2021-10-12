package mx.unam.ib.ibdata.api.service;

import java.io.ByteArrayOutputStream;

import mx.unam.ib.ibdata.api.model.vo.IbdReportCriteria;

public interface IbdGenericReportServiceInterface {
	
	public ByteArrayOutputStream downloadReport(IbdReportCriteria req) throws Exception;
	
}
