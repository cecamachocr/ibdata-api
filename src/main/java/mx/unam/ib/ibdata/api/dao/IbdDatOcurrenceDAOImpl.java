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
	public List<IbdDatOcurrenceEntity> callFunctionGetByIdCountry(Integer idCountry, Integer pageNum, Integer pageLimit) {

		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet results = null;
		long initTime = System.currentTimeMillis();
		
		String fnName = "fn_oc_getbyidcountry";
		
		List<IbdDatOcurrenceEntity> listResult = new ArrayList<IbdDatOcurrenceEntity>();
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
				//logger.error(results.getString("occurrence_id"));
				IbdDatOcurrenceEntity vo = new IbdDatOcurrenceEntity();
				vo.setOccurrenceId(results.getString("occurrence_id"));
				vo.setScientificName(results.getString("scientificName"));
				vo.setAcceptedNameUsage(results.getString("acceptedNameUsage"));
				vo.setIdTaxLabelName(results.getInt("id_tax_label_name"));
				vo.setIdTazAcceptedName(results.getString("id_tax_accepted_name"));
				vo.setGenus(results.getString("genus"));
				vo.setSpecificEpithet(results.getString("specificEpithet"));
				vo.setTaxonRank(results.getString("taxonRank"));
				vo.setIdCountry(results.getInt("id_country"));
				vo.setIdState(results.getInt("id_state"));
				vo.setIdCounty(results.getInt("id_county"));
				vo.setCatalogNumber(results.getString("catalog_number"));
				vo.setDatasetId(results.getString("dataset_id"));
				vo.setCollectionCode(results.getString("collection_code"));
				vo.setCollectionId(results.getString("collection_id"));
				vo.setModified(results.getString("modified"));
				vo.setBibliographicCitation(results.getString("bibliographic_citation"));
				vo.setDynamicProperties(results.getString("dynamic_properties"));
				vo.setLanguage(results.getString("_language"));
				vo.setOccurrenceStatus(results.getString("occurrence_status"));
				vo.setUuid(results.getString("uuid"));
				vo.setIndividualId(results.getString("individual_id"));
				vo.setBiodiversityId(results.getString("biodiversity_id"));
				vo.setFuenteConabio(results.getString("fuente_conabio"));
				vo.setOtherCatalogNumbers(results.getString("other_catalog_numbers"));
				vo.setOccurrenceRemarks(results.getString("occurrence_remarks"));
				vo.setRecordedBy(results.getString("recorded_by"));
				vo.setRecordNumber(results.getString("record_number"));
				vo.setLifeStage(results.getString("life_stage"));
				vo.setSex(results.getString("sex"));
				vo.setEventDate(results.getString("event_date"));
				vo.setYear(results.getString("_year"));
				vo.setMonth(results.getString("_month"));
				vo.setDay(results.getString("_day"));
				vo.setEventTime(results.getString("event_time"));
				vo.setVerbatimEventDate(results.getString("verbatim_event_date"));
				vo.setFieldNotes(results.getString("field_notes"));
				vo.setHabitat(results.getString("habitat"));
				vo.setHigherClassification(results.getString("higher_classification"));
				vo.setVernacularName(results.getString("vernacular_name"));
				vo.setScientificNameId(results.getString("scientific_name_id"));
				vo.setVerbatimTaxonRank(results.getString("verbatim_taxon_rank"));
				vo.setAcceptedNameUsageId(results.getString("accepted_name_usage_id"));
				vo.setDateIdentified(results.getString("date_identified"));
				vo.setIdentifiedBy(results.getString("identified_by"));
				vo.setIdentificationRemarks(results.getString("identification_remarks"));
				vo.setIdentificationQualifier(results.getString("identification_qualifier"));
				vo.setLocality(results.getString("locality"));
				vo.setVerbatimLocality(results.getString("verbatim_locality"));
				vo.setMinimumElevationInMeters(results.getString("minimum_elevation_in_meters"));
				vo.setMaximumElevationInMeters(results.getString("maximum_elevation_in_meters"));
				vo.setVerbatimElevation(results.getString("verbatim_elevation"));
				vo.setDecimalLatitude(results.getString("decimal_latitude"));
				vo.setDecimalLongitude(results.getString("decimal_longitude"));
				vo.setVerbatimLatitude(results.getString("verbatim_latitude"));
				vo.setVerbatimLongitude(results.getString("verbatim_longitude"));
				vo.setContinent(results.getString("continent"));
				vo.setHigherGeography(results.getString("higher_geography"));
				vo.setColeccion(results.getString("coleccion"));
				vo.setAssociatedMediaKe002(results.getString("associated_media_ke002"));
				vo.setAssociatedMedia(results.getString("associated_media"));
				vo.setAssociatedMediaMin(results.getString("associated_media_min"));
				
				listResult.add(vo);
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
		return listResult;

	}
	
	@Override
	public Integer callFunctionGetByIdCountryCount(Integer idCountry) {

		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet results = null;
		Integer count = 0;
		long initTime = System.currentTimeMillis();
		
		String fnName = "fn_oc_getbyidcountry_count";
		
		List<IbdDatOcurrenceEntity> lisrResult = new ArrayList<IbdDatOcurrenceEntity>();
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			
			StringBuilder callSB = new StringBuilder("{? = call ");
			callSB.append(schema)
			.append(".")
			.append(fnName)
			.append("(?)}");
			
			logger.info(callSB.toString());
			cstmt = conn.prepareCall(callSB.toString());
			
			int rs_type = Types.INTEGER;
			
			cstmt.registerOutParameter(1, rs_type);
			cstmt.setInt(2, idCountry);
			
			StringBuilder sbuf = new StringBuilder();
			Formatter fmt = new Formatter(sbuf);
			
			fmt.format("params:[rs_type=%d, idCountry=%d]",rs_type, idCountry);
			logger.info(fmt.toString());
			fmt.close();
			
			cstmt.execute();
			
			 count = cstmt.getInt(1);
			
			logger.error(count);
			
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
		
		return count;

	}

}
