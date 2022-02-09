package mx.unam.ib.ibdata.api.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.unam.ib.ibdata.api.utils.IbdContants;

@Entity
@Table(schema = IbdContants.SCHEMA_VHO_PUBLIC, name = "dat_occurrence")
public class IbdDatOcurrenceEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6872549190233465907L;
	
	@Id
	@Column(name = "occurrence_id", nullable = false)
	private String occurrenceId;
	
	@Column(name = "\"scientificName\"", length = 2000)
	private String scientificName;
	
	@Column(name = "\"acceptedNameUsage\"", length = 2000)
	private String acceptedNameUsage;
	
	@Column(name = "id_tax_label_name")
	private Integer idTaxLabelName;
	
	@Column(name = "id_tax_accepted_name")
	private String idTazAcceptedName;
	
	@Column(name = "genus", length = 255)
	private String genus;
	
	@Column(name = "\"specificEpithet\"", length = 255)
	private String specificEpithet;
	
	@Column(name = "\"taxonRank\"", length = 255)
	private String taxonRank;
	
	@Column(name = "id_country")
	private Integer idCountry;
	
	@Column(name = "id_state")
	private Integer idState;
	
	@Column(name = "id_county")
	private Integer idCounty;
	
	@Column(name = "catalog_number", length = 2000)
	private String catalogNumber;
	
	@Column(name = "dataset_id", length = 2000)
	private String datasetId;
	
	@Column(name = "collection_code", length = 2000)
	private String collectionCode;
	
	@Column(name = "collection_id", length = 2000)
	private String collectionId;
	
	@Column(name = "modified", length = 2000)
	private String modified;
	
	@Column(name = "bibliographic_citation", length = 2000)
	private String bibliographicCitation;
	
	@Column(name = "dynamic_properties", length = 2000)
	private String dynamicProperties;
	
	@Column(name = "\"_language\"", length = 2000)
	private String language;
	
	@Column(name = "occurrence_status", length = 2000)
	private String occurrenceStatus;
	
	@Column(name = "uuid", length = 2000)
	private String uuid;
	
	@Column(name = "individual_id", length = 2000)
	private String individualId;
	
	
	@Column(name = "biodiversity_id", length = 2000)
	private String biodiversityId;
	
	@Column(name = "fuente_conabio", length = 2000)
	private String fuenteConabio;
	
	@Column(name = "other_catalog_numbers", length = 2000)
	private String otherCatalogNumbers;
	
	@Column(name = "occurrence_remarks", length = 2000)
	private String occurrenceRemarks;
	
	@Column(name = "recorded_by", length = 2000)
	private String recordedBy;
	
	@Column(name = "record_number", length = 2000)
	private String recordNumber;
	
	@Column(name = "life_stage", length = 2000)
	private String lifeStage;
	
	@Column(name = "sex", length = 2000)
	private String sex;
	
	@Column(name = "event_date", length = 2000)
	private String eventDate;
	
	@Column(name = "\"_year\"", length = 2000)
	private String year;
	
	@Column(name = "\"_month\"", length = 2000)
	private String month;
	
	@Column(name = "\"_day\"", length = 2000)
	private String day;
	
	@Column(name = "event_time", length = 2000)
	private String eventTime;
	
	@Column(name = "verbatim_event_date", length = 2000)
	private String verbatimEventDate;
	
	@Column(name = "field_notes")//text
	private String fieldNotes;
	
	@Column(name = "habitat", length = 2000)
	private String habitat;
	
	@Column(name = "higher_classification", length = 2000)
	private String higherClassification;
	
	@Column(name = "vernacular_name", length = 2000)
	private String vernacularName;
	
	@Column(name = "scientific_name_id", length = 2000)
	private String scientificNameId;
	
	@Column(name = "verbatim_taxon_rank", length = 2000)
	private String verbatimTaxonRank;
	
	@Column(name = "accepted_name_usage_id", length = 2000)
	private String acceptedNameUsageId;
	
	@Column(name = "date_identified", length = 2000)
	private String dateIdentified;
	
	@Column(name = "identified_by", length = 2000)
	private String identifiedBy;
	
	@Column(name = "identification_remarks", length = 2000)
	private String identificationRemarks;
	
	@Column(name = "identification_qualifier", length = 2000)
	private String identificationQualifier;
	
	@Column(name = "locality", length = 2000)
	private String locality;
	
	@Column(name = "verbatim_locality", length = 2000)
	private String verbatimLocality;
	
	@Column(name = "minimum_elevation_in_meters", length = 2000)
	private String minimumElevationInMeters;
	
	@Column(name = "maximum_elevation_in_meters", length = 2000)
	private String maximumElevationInMeters;
	
	@Column(name = "verbatim_elevation", length = 2000)
	private String verbatimElevation;
	
	@Column(name = "decimal_latitude", length = 2000)
	private String decimalLatitude;
	
	@Column(name = "decimal_longitude", length = 2000)
	private String decimalLongitude;
	
	@Column(name = "verbatim_latitude", length = 2000)
	private String verbatimLatitude;
	
	@Column(name = "verbatim_longitude", length = 2000)
	private String verbatimLongitude;
	
	@Column(name = "continent", length = 2000)
	private String continent;
	
	@Column(name = "higher_geography", length = 2000)
	private String higherGeography;
	
	@Column(name = "coleccion", length = 20)
	private String coleccion;
	
	@Column(name = "associated_media_ke002", length = 255)
	private String associatedMediaKe002;
	
	@Column(name = "associated_media")
	private String associatedMedia;
	
	@Column(name = "associated_media_min", length = 2000)
	private String associatedMediaMin;

	
	public String getOccurrenceId() {
		return occurrenceId;
	}

	public void setOccurrenceId(String occurrenceId) {
		this.occurrenceId = occurrenceId;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public String getAcceptedNameUsage() {
		return acceptedNameUsage;
	}

	public void setAcceptedNameUsage(String acceptedNameUsage) {
		this.acceptedNameUsage = acceptedNameUsage;
	}

	public Integer getIdTaxLabelName() {
		return idTaxLabelName;
	}

	public void setIdTaxLabelName(Integer idTaxLabelName) {
		this.idTaxLabelName = idTaxLabelName;
	}

	public String getIdTazAcceptedName() {
		return idTazAcceptedName;
	}

	public void setIdTazAcceptedName(String idTazAcceptedName) {
		this.idTazAcceptedName = idTazAcceptedName;
	}

	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getSpecificEpithet() {
		return specificEpithet;
	}

	public void setSpecificEpithet(String specificEpithet) {
		this.specificEpithet = specificEpithet;
	}

	public String getTaxonRank() {
		return taxonRank;
	}

	public void setTaxonRank(String taxonRank) {
		this.taxonRank = taxonRank;
	}

	public Integer getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Integer idCountry) {
		this.idCountry = idCountry;
	}

	public Integer getIdState() {
		return idState;
	}

	public void setIdState(Integer idState) {
		this.idState = idState;
	}

	public Integer getIdCounty() {
		return idCounty;
	}

	public void setIdCounty(Integer idCounty) {
		this.idCounty = idCounty;
	}

	public String getCatalogNumber() {
		return catalogNumber;
	}

	public void setCatalogNumber(String catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

	public String getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}

	public String getCollectionCode() {
		return collectionCode;
	}

	public void setCollectionCode(String collectionCode) {
		this.collectionCode = collectionCode;
	}

	public String getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getBibliographicCitation() {
		return bibliographicCitation;
	}

	public void setBibliographicCitation(String bibliographicCitation) {
		this.bibliographicCitation = bibliographicCitation;
	}

	public String getDynamicProperties() {
		return dynamicProperties;
	}

	public void setDynamicProperties(String dynamicProperties) {
		this.dynamicProperties = dynamicProperties;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getOccurrenceStatus() {
		return occurrenceStatus;
	}

	public void setOccurrenceStatus(String occurrenceStatus) {
		this.occurrenceStatus = occurrenceStatus;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getIndividualId() {
		return individualId;
	}

	public void setIndividualId(String individualId) {
		this.individualId = individualId;
	}

	public String getBiodiversityId() {
		return biodiversityId;
	}

	public void setBiodiversityId(String biodiversityId) {
		this.biodiversityId = biodiversityId;
	}

	public String getFuenteConabio() {
		return fuenteConabio;
	}

	public void setFuenteConabio(String fuenteConabio) {
		this.fuenteConabio = fuenteConabio;
	}

	public String getOtherCatalogNumbers() {
		return otherCatalogNumbers;
	}

	public void setOtherCatalogNumbers(String otherCatalogNumbers) {
		this.otherCatalogNumbers = otherCatalogNumbers;
	}

	public String getOccurrenceRemarks() {
		return occurrenceRemarks;
	}

	public void setOccurrenceRemarks(String occurrenceRemarks) {
		this.occurrenceRemarks = occurrenceRemarks;
	}

	public String getRecordedBy() {
		return recordedBy;
	}

	public void setRecordedBy(String recordedBy) {
		this.recordedBy = recordedBy;
	}

	public String getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}

	public String getLifeStage() {
		return lifeStage;
	}

	public void setLifeStage(String lifeStage) {
		this.lifeStage = lifeStage;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getVerbatimEventDate() {
		return verbatimEventDate;
	}

	public void setVerbatimEventDate(String verbatimEventDate) {
		this.verbatimEventDate = verbatimEventDate;
	}

	public String getFieldNotes() {
		return fieldNotes;
	}

	public void setFieldNotes(String fieldNotes) {
		this.fieldNotes = fieldNotes;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public String getHigherClassification() {
		return higherClassification;
	}

	public void setHigherClassification(String higherClassification) {
		this.higherClassification = higherClassification;
	}

	public String getVernacularName() {
		return vernacularName;
	}

	public void setVernacularName(String vernacularName) {
		this.vernacularName = vernacularName;
	}

	public String getScientificNameId() {
		return scientificNameId;
	}

	public void setScientificNameId(String scientificNameId) {
		this.scientificNameId = scientificNameId;
	}

	public String getVerbatimTaxonRank() {
		return verbatimTaxonRank;
	}

	public void setVerbatimTaxonRank(String verbatimTaxonRank) {
		this.verbatimTaxonRank = verbatimTaxonRank;
	}

	public String getAcceptedNameUsageId() {
		return acceptedNameUsageId;
	}

	public void setAcceptedNameUsageId(String acceptedNameUsageId) {
		this.acceptedNameUsageId = acceptedNameUsageId;
	}

	public String getDateIdentified() {
		return dateIdentified;
	}

	public void setDateIdentified(String dateIdentified) {
		this.dateIdentified = dateIdentified;
	}

	public String getIdentifiedBy() {
		return identifiedBy;
	}

	public void setIdentifiedBy(String identifiedBy) {
		this.identifiedBy = identifiedBy;
	}

	public String getIdentificationRemarks() {
		return identificationRemarks;
	}

	public void setIdentificationRemarks(String identificationRemarks) {
		this.identificationRemarks = identificationRemarks;
	}

	public String getIdentificationQualifier() {
		return identificationQualifier;
	}

	public void setIdentificationQualifier(String identificationQualifier) {
		this.identificationQualifier = identificationQualifier;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getVerbatimLocality() {
		return verbatimLocality;
	}

	public void setVerbatimLocality(String verbatimLocality) {
		this.verbatimLocality = verbatimLocality;
	}

	public String getMinimumElevationInMeters() {
		return minimumElevationInMeters;
	}

	public void setMinimumElevationInMeters(String minimumElevationInMeters) {
		this.minimumElevationInMeters = minimumElevationInMeters;
	}

	public String getMaximumElevationInMeters() {
		return maximumElevationInMeters;
	}

	public void setMaximumElevationInMeters(String maximumElevationInMeters) {
		this.maximumElevationInMeters = maximumElevationInMeters;
	}

	public String getVerbatimElevation() {
		return verbatimElevation;
	}

	public void setVerbatimElevation(String verbatimElevation) {
		this.verbatimElevation = verbatimElevation;
	}

	public String getDecimalLatitude() {
		return decimalLatitude;
	}

	public void setDecimalLatitude(String decimalLatitude) {
		this.decimalLatitude = decimalLatitude;
	}

	public String getDecimalLongitude() {
		return decimalLongitude;
	}

	public void setDecimalLongitude(String decimalLongitude) {
		this.decimalLongitude = decimalLongitude;
	}

	public String getVerbatimLatitude() {
		return verbatimLatitude;
	}

	public void setVerbatimLatitude(String verbatimLatitude) {
		this.verbatimLatitude = verbatimLatitude;
	}

	public String getVerbatimLongitude() {
		return verbatimLongitude;
	}

	public void setVerbatimLongitude(String verbatimLongitude) {
		this.verbatimLongitude = verbatimLongitude;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getHigherGeography() {
		return higherGeography;
	}

	public void setHigherGeography(String higherGeography) {
		this.higherGeography = higherGeography;
	}

	public String getColeccion() {
		return coleccion;
	}

	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	public String getAssociatedMediaKe002() {
		return associatedMediaKe002;
	}

	public void setAssociatedMediaKe002(String associatedMediaKe002) {
		this.associatedMediaKe002 = associatedMediaKe002;
	}

	public String getAssociatedMedia() {
		return associatedMedia;
	}

	public void setAssociatedMedia(String associatedMedia) {
		this.associatedMedia = associatedMedia;
	}

	public String getAssociatedMediaMin() {
		return associatedMediaMin;
	}

	public void setAssociatedMediaMin(String associatedMediaMin) {
		this.associatedMediaMin = associatedMediaMin;
	}

}
