package mx.unam.ib.ibdata.api.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Formatter;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class IbdDemoDAOImpl implements IbdDemoDAOInterface {
	
	private static final Logger logger = LoggerFactory.getLogger(IbdDemoDAOImpl.class);
		
	@Autowired
	@Qualifier(value = "postgresDataSource")
	private DataSource dataSource;
	
	@Override
	public void callFunction() {

		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet results = null;
		long initTime = System.currentTimeMillis();
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall("{? = call ibdata_api.fn_get_users(?,?) }");
			
			int rs_type = Types.REF_CURSOR;
			Integer page_num = 1;
			Integer page_limit = 8;
			cstmt.registerOutParameter(1, rs_type);
			cstmt.setInt(2, page_num);
			cstmt.setInt(3, page_limit);
			
			StringBuilder sbuf = new StringBuilder();
			Formatter fmt = new Formatter(sbuf);
			
			logger.info("call function :{? = call ibdata_api.fn_get_users(?,?) }");
			
			fmt.format("params:[rs_type=%d, page_num=%d, page_limit=%d]",rs_type, page_num, page_limit);
			logger.info(fmt.toString());
			fmt.close();
			
			cstmt.execute();
			
			results = (ResultSet) cstmt.getObject(1);
			while (results.next())
			{
				logger.error(results.getString("id"));
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
