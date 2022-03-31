package mx.unam.ib.ibdata.api.service;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
		long initTime = System.currentTimeMillis();
		ByteArrayOutputStream response = null;
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet reqSheet = workbook.createSheet("request");
		XSSFRow rowReq = null;
		
		int rowInformationCounter = 0;
		try {

			IbdExecuteServiceVO vo = IbdUtils.getDataFromBase64(queryEncoded);
			
			
			rowReq = reqSheet.createRow(rowInformationCounter);
			rowInformationCounter++;
			XSSFCell cell0 = rowReq.createCell(0);
			XSSFCell cell1 = rowReq.createCell(1);
			
			cell0.setCellValue("Información:");
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(vo);
			cell1.setCellValue(json);

			String interfaceClassName = vo.getInterfaceClass();
			String methodName = vo.getMethodName();
			Map<Integer, IbdClaveValor> params = vo.getParams();
			
			Class<?> interfaceClass = Class.forName(interfaceClassName);

			Object bean = context.getBean(interfaceClass);
			
			Class<?> castResponseClass = Class.forName(vo.getReturnTypeName());
			
			

			int countParams = params.size();

			Class<?>[] parametersTypes = new Class[countParams];
			Object[] paramsObj = new Object[countParams];

			int countElement = 0;
			for (Entry<Integer, IbdClaveValor> entry : params.entrySet()) {
				
				rowReq = reqSheet.createRow(rowInformationCounter);
				rowInformationCounter++;
				Class<?> c1azzParam = Class.forName(entry.getValue().getClave());
				parametersTypes[countElement] = c1azzParam;

				Gson gParam = new Gson();
				Object vod = gParam.fromJson(entry.getValue().getValor(), c1azzParam);
				ObjectMapper mapperParam = new ObjectMapper();
				String jsonParam = mapperParam.writeValueAsString(vod);
				cell0 = rowReq.createCell(0);
				cell0.setCellValue("Petición:");
				cell1 = rowReq.createCell(1);
				cell1.setCellValue(jsonParam);
				paramsObj[countElement] = vod;
				
				countElement++;
			}

			Method method = bean.getClass().getDeclaredMethod(methodName, parametersTypes);

			Object responseService = method.invoke(bean, paramsObj);
			
			LinkedHashMap<String, String> genericHeaders = new LinkedHashMap<String, String>();
			if (responseService.getClass().isAssignableFrom(castResponseClass)) {
				ObjectMapper mapperRes = new ObjectMapper();
				String jsonRes = mapperRes.writeValueAsString(responseService);
				ObjectNode node = (ObjectNode) new ObjectMapper().readTree(jsonRes);
				node.remove("data");
				rowReq = reqSheet.createRow(rowInformationCounter);
				cell0 = rowReq.createCell(0);
				cell0.setCellValue("Respuesta:");
				cell1 = rowReq.createCell(1);
				cell1.setCellValue(node.toString());
				rowInformationCounter++;
				Field[] fields = responseService.getClass().getDeclaredFields();

				for (Field field : fields) {
					field.setAccessible(true);
					if ("data".equals(field.getName())) {
						if (field.getType().isAssignableFrom(ArrayList.class)) {
							field.setAccessible(true); 
							List<?> value = (List<?>) field.get(responseService); 
							int rowCounter = 1;
							XSSFSheet sheet = workbook.createSheet("data");;
							for (int i = 0; i < value.size(); i++) {
								Object data = value.get(i);
								Field[] fieldsDataVO = data.getClass().getDeclaredFields();
								
								Map<String, String> dataValue = new HashMap<String, String>();
								
								for (Field fieldVO : fieldsDataVO) {
									fieldVO.setAccessible(true);
									String str = fieldVO.getName();
									Object object = fieldVO.get(data);
									dataValue.put(str, (String) object);
									genericHeaders.put(str, str);
								}
								
								XSSFRow row = null;
								XSSFRow rowAux = null;
								
								if(i == 0) {
									row = sheet.createRow(0);
									rowAux = sheet.createRow(1);
								}else {
									row = sheet.createRow(rowCounter);
								}
								
								int columCounter = 0;
								for (Map.Entry<String, String> entry : genericHeaders.entrySet()) {
									XSSFCell cell = row.createCell(columCounter);

									if (i == 0) { // first row is for column headers
										cell.setCellValue(entry.getValue()); // content **must** be here for table column
																			// names
										XSSFCell cellAux = rowAux.createCell(columCounter);
										cellAux.setCellValue(dataValue.get(entry.getKey()));
									} else {
										cell.setCellValue(dataValue.get(entry.getKey()));
									}
									columCounter++;
								}

								rowCounter++;
							}
						}
					}
				}
			}

			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			rowReq = reqSheet.createRow(rowInformationCounter);
			cell0 = rowReq.createCell(0);
			cell1 = rowReq.createCell(1);
			cell0.setCellValue("Tiempo de ejecucion:");
			long endTime = System.currentTimeMillis();
			cell1.setCellValue((endTime - initTime)/ 1000D);
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
