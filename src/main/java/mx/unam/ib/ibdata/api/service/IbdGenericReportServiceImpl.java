package mx.unam.ib.ibdata.api.service;

import java.io.ByteArrayOutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import mx.unam.ib.ibdata.api.model.vo.IbdReportCriteria;

@Service
public class IbdGenericReportServiceImpl implements IbdGenericReportServiceInterface{

	private static final Logger logger = LogManager.getLogger(IbdGenericReportServiceImpl.class);
	
	
	@Override
	public  ByteArrayOutputStream downloadReport(IbdReportCriteria req) throws Exception {
		
		ByteArrayOutputStream response;
		
		try {
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
        	Workbook wbook = new XSSFWorkbook();
        	wbook.createSheet();
              
            //HttpHeaders header = new HttpHeaders();
            
            
            wbook.write(stream);
            stream.close();
            response = stream;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage(),e);
		}

		return response;
	}
	
}
