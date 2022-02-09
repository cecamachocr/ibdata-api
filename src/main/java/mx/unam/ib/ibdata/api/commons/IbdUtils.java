package mx.unam.ib.ibdata.api.commons;

import java.util.Base64;
import java.util.Base64.Decoder;

import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import mx.unam.ib.ibdata.api.model.vo.IbdExecuteServiceVO;

public class IbdUtils {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IbdUtils.class);
	
	public static IbdExecuteServiceVO getDataFromBase64(String encodedStr) {
		IbdExecuteServiceVO vo = null;
		try {
			Decoder decoder = Base64.getDecoder();
			byte[] bytes = decoder.decode(encodedStr);
			
			String query = new String(bytes);
			logger.info(query);
			Gson g = new Gson();
			vo = g.fromJson(query, IbdExecuteServiceVO.class);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		
		return vo;
	}
}
