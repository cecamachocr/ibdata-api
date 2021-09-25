package mx.unam.ib.ibdata.api.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mx.unam.ib.ibdata.api.model.entity.IbdDatOcurrenceEntity;
import mx.unam.ib.ibdata.api.utils.IbdContants;

@Repository
public class IbdDatOcurrenceDAOImpl implements IbdDatOcurrenceDAOInterface {
	
	private static final Logger logger = LogManager.getLogger(IbdDatOcurrenceDAOImpl.class);
	
	
	private String schema = IbdContants.SCHEMA_VHO_PUBLIC;
	
	@Autowired
	@Qualifier(value = "postgresDataSource")
	private DataSource dataSource;
	
	
	
	@Override
	public void callFunctionGetByIdCountry(Integer idCountry, Integer pageNum, Integer pageLimit) {

		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet results = null;
		long initTime = System.currentTimeMillis();
		
		String fnName = "fn_oc_getbyidcountry";
		
		List<IbdDatOcurrenceEntity> lisrResult = new ArrayList<IbdDatOcurrenceEntity>();
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			
			StringBuilder callSB = new StringBuilder("{? = call ");
			callSB.append(schema)
			.append(".")
			.append(fnName)
			.append("(?,?,?)}");
			
			logger.info(callSB.toString());
			cstmt = conn.prepareCall(callSB.toString());
			
			int rs_type = Types.REF_CURSOR;
			Integer page_num = pageNum;
			Integer page_limit = pageLimit;
			
			cstmt.registerOutParameter(1, rs_type);
			cstmt.setInt(2, idCountry);
			cstmt.setInt(3, page_num);
			cstmt.setInt(4, page_limit);
			
			StringBuilder sbuf = new StringBuilder();
			Formatter fmt = new Formatter(sbuf);
			
			fmt.format("params:[rs_type=%d, idCountry=%d, page_num=%d, page_limit=%d]",rs_type, idCountry, page_num, page_limit);
			logger.info(fmt.toString());
			fmt.close();
			
			cstmt.execute();
			
			results = (ResultSet) cstmt.getObject(1);
			while (results.next())
			{
				logger.error(results.getString("occurrence_id"));
				IbdDatOcurrenceEntity vo = new IbdDatOcurrenceEntity();
				vo.setOccurrenceId(results.getString("occurrence_id"));
				//
				
				lisrResult.add(vo);
			}
			
			
			long endTime = System.currentTimeMillis();
			
			logger.info("excution time call to function:[" + (endTime - initTime) / 1000D + " seg]");

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error(e.getMessage(), e);
				}
			}
			if(results != null) {
				try {
					results.close();
				} catch (Exception e2) {
					logger.error(e2.getMessage(), e2);
				}
			}
		}

	}

}
