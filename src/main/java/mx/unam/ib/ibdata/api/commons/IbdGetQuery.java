package mx.unam.ib.ibdata.api.commons;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class IbdGetQuery {
	
	private static final Logger logger = LoggerFactory.getLogger(IbdGetQuery.class);
	
	public Query getQueryByNamesAttributes(Object req) {
		Query query = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			String json = mapper.writeValueAsString(req);
			
			Map<String,Object> mapValues = getMapValues(json);
			
			query = new Query();
			
			for (Map.Entry<String, Object> entry : mapValues.entrySet()) {
			    
			    if(entry.getValue() != null) {
			    	if(entry.getValue().getClass().equals(String.class)) {
			    		logger.info("is String[" + entry.getKey() + ":" + entry.getValue() + "]");
				    	query.addCriteria(Criteria.where(entry.getKey()).regex((String)entry.getValue()));
				    }
				    
				    if(entry.getValue().getClass().equals(Integer.class)) {
				    	logger.info("is Integer[" + entry.getKey() + ":" + entry.getValue() + "]");
				    	query.addCriteria(Criteria.where(entry.getKey()).is((Integer)entry.getValue()));
				    }
				    
				    if(entry.getValue().getClass().equals(Long.class)) {
				    	logger.info("is Long[" + entry.getKey() + ":" + entry.getValue() + "]");
				    	query.addCriteria(Criteria.where(entry.getKey()).is((Long)entry.getValue()));
				    }
				    
				    if(entry.getValue().getClass().equals(Double.class)) {
				    	logger.info("is Double[" + entry.getKey() + ":" + entry.getValue() + "]");
				    	query.addCriteria(Criteria.where(entry.getKey()).is((Double)entry.getValue()));
				    }
			    }
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return query;
	}
	
	public Map<String,Object> getMapValues(String jsonStr) {
	    Map<String,Object> mapValues = new HashMap<String,Object>();
	    try {
	    	JSONObject jObj= new JSONObject(jsonStr);
	    	jObj.remove("pageLimit");
	    	jObj.remove("urlServer");
	    	jObj.remove("pageNum");
	    	jObj.remove("fromAPI");
	    	jObj.remove("totalRows");
	    	
	    	for (Object keyObj: jObj.keySet()){
	    	    String key = (String)keyObj;
	    	    Object value = jObj.get(key);
	    	    mapValues.put(key, value);
	    	    logger.info(key + ":" + value);
	    	}
	    	
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return mapValues;
	}
}
