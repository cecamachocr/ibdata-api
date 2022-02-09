package mx.unam.ib.ibdata.api.service;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import mx.unam.ib.ibdata.api.commons.IbdUtils;
import mx.unam.ib.ibdata.api.model.vo.IbdClaveValor;
import mx.unam.ib.ibdata.api.model.vo.IbdExecuteServiceVO;
import mx.unam.ib.ibdata.api.model.vo.IbdReportCriteria;

@Service
public class IbdGenericReportServiceImpl implements IbdGenericReportServiceInterface {

	private static final Logger logger = LoggerFactory.getLogger(IbdGenericReportServiceImpl.class);

	@Autowired
	ApplicationContext context;

	@Override
	public ByteArrayOutputStream downloadReport(IbdReportCriteria req) throws Exception {

		ByteArrayOutputStream response;

		try {

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			Workbook wbook = new XSSFWorkbook();
			wbook.createSheet();

			// HttpHeaders header = new HttpHeaders();

			wbook.write(stream);
			stream.close();
			response = stream;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage(), e);
		}

		return response;
	}

	public ByteArrayOutputStream downloadFileReport(String queryEncoded) throws Exception {

		ByteArrayOutputStream response = null;

		try {

			IbdExecuteServiceVO vo = IbdUtils.getDataFromBase64(queryEncoded);

			String interfaceClassName = vo.getInterfaceClass();
			String methodName = vo.getMethodName();
			Map<Integer, IbdClaveValor> params = vo.getParams();
			
			Class<?> interfaceClass = Class.forName(interfaceClassName);

			Object bean = context.getBean(interfaceClass);
			
			Class<?> castResponseClass = Class.forName(vo.getReturnTypeName());
			
			XSSFWorkbook workbook = new XSSFWorkbook();

			int countParams = params.size();

			Class<?>[] parametersTypes = new Class[countParams];
			Object[] paramsObj = new Object[countParams];

			int countElement = 0;
			for (Entry<Integer, IbdClaveValor> entry : params.entrySet()) {

				Class<?> c1azzParam = Class.forName(entry.getValue().getClave());
				parametersTypes[countElement] = c1azzParam;

				Gson gParam = new Gson();
				Object vod = gParam.fromJson(entry.getValue().getValor(), c1azzParam);
				paramsObj[countElement] = vod;

				countElement++;
			}

			Method method = bean.getClass().getDeclaredMethod(methodName, parametersTypes);

			Object responseService = method.invoke(bean, paramsObj);
			
			List<String> headers = new ArrayList<String>();
			

			if (responseService.getClass().isAssignableFrom(castResponseClass)) {
				Field[] fields = responseService.getClass().getDeclaredFields();

				for (Field field : fields) {
					field.setAccessible(true);
					if ("data".equals(field.getName())) {
						if (field.getType().isAssignableFrom(ArrayList.class)) {
							field.setAccessible(true); 
							List<?> value = (List<?>) field.get(responseService); 
																							
							for (int i = 0; i < value.size(); i++) {
								Object data = value.get(i);
								Field[] fieldsDataVO = data.getClass().getDeclaredFields();
								List<String> values = new ArrayList<String>();
								for (Field fieldVO : fieldsDataVO) {
									fieldVO.setAccessible(true);
									String str = fieldVO.getName();
									Object object = fieldVO.get(data);
									if(i==0) {
										headers.add(str);
									}
									values.add((String) object);
								}
								if(i==0) {
									
								    XSSFSheet sheet = workbook.createSheet("data");

								    for (int r = 0; r < value.size() + 1 ; r++) {
								      XSSFRow row = sheet.createRow(r);
								      for(int c = 0; c < headers.size(); c++) {
								        XSSFCell cell = row.createCell(c);
								        if(r == 0) { //first row is for column headers
								          cell.setCellValue(headers.get(c)); //content **must** be here for table column names
								        } else {
								          cell.setCellValue(values.get(c));
								        }
								      }
								    }
								}
							}
						}
					}
				}
			}

			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			workbook.write(stream);
			stream.close();
			response = stream;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage(), e);
		}

		return response;
	}

}
