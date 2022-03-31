package mx.unam.ib.ibdata.api.model.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document("dat_occurrence")
public class IbdDatOcurrenceCollection {
	
	
	@Id
	@ApiModelProperty(
			name = "_id"
			,notes = "_id"
//			,dataType = "Long"
			,position = 1)
	private String _id;
	
	@ApiModelProperty(
			name = "occurrence_id"
			,notes = "occurrence_id"
//			,dataType = "Long"
			,position = 1)
	private String occurrence_id;
	
	@ApiModelProperty(
			name = "tax_label_name"
			,notes = "tax_label_name"
//			,dataType = "Long"
			,position = 1)
	private String tax_label_name;
	
	@ApiModelProperty(
			name = "tax_accepted_name"
			,notes = "tax_accepted_name"
//			,dataType = "Long"
			,position = 1)
	private String tax_accepted_name;
	
	@ApiModelProperty(
			name = "id_tax_label_name"
			,notes = "id_tax_label_name"
//			,dataType = "Long"
			,position = 1)
	private String id_tax_label_name;
	
	@ApiModelProperty(
			name = "id_tax_accepted_name"
			,notes = "id_tax_accepted_name"
//			,dataType = "Long"
			,position = 1)
	private String id_tax_accepted_name;
	
	@ApiModelProperty(
			name = "label_genus"
			,notes = "label_genus"
//			,dataType = "Long"
			,position = 1)
	private String label_genus;
	
	@ApiModelProperty(
			name = "label_specific_epithet"
			,notes = "label_specific_epithet"
//			,dataType = "Long"
			,position = 1)
	private String label_specific_epithet;
	
	@ApiModelProperty(
			name = "taxonRank"
			,notes = "taxonRank"
//			,dataType = "Long"
			,position = 1)
	private String taxonRank;
	
	@ApiModelProperty(
			name = "id_country"
			,notes = "id_country"
//			,dataType = "Long"
			,position = 1)
	private String id_country;
	
	@ApiModelProperty(
			name = "id_state"
			,notes = "id_state"
//			,dataType = "Long"
			,position = 1)
	private String id_state;
	
	@ApiModelProperty(
			name = "id_county"
			,notes = "id_county"
//			,dataType = "Long"
			,position = 1)
	private String id_county;
	
	@ApiModelProperty(
			name = "catalog_number"
			,notes = "catalog_number"
//			,dataType = "Long"
			,position = 1)
	private String catalog_number;
	
	@ApiModelProperty(
			name = "dataset_id"
			,notes = "dataset_id"
//			,dataType = "Long"
			,position = 1)
	private String dataset_id;
	
	@ApiModelProperty(
			name = "collection_code"
			,notes = "collection_code"
//			,dataType = "Long"
			,position = 1)
	private String collection_code;
	
	@ApiModelProperty(
			name = "collection_id"
			,notes = "collection_id"
//			,dataType = "Long"
			,position = 1)
	private String collection_id;
	
	@ApiModelProperty(
			name = "modified"
			,notes = "modified"
//			,dataType = "Long"
			,position = 1)
	private String modified;
	
	@ApiModelProperty(
			name = "bibliographic_citation"
			,notes = "bibliographic_citation"
//			,dataType = "Long"
			,position = 1)
	private String bibliographic_citation;
	
	@ApiModelProperty(
			name = "dynamic_properties"
			,notes = "dynamic_properties"
//			,dataType = "Long"
			,position = 1)
	private String dynamic_properties;
	
	@ApiModelProperty(
			name = "language"
			,notes = "language"
//			,dataType = "Long"
			,position = 1)
	private String language;
	
	@ApiModelProperty(
			name = "biodiversity_id"
			,notes = "biodiversity_id"
//			,dataType = "Long"
			,position = 1)
	private String biodiversity_id;
	
	@ApiModelProperty(
			name = "fuente_conabio"
			,notes = "_id"
//			,dataType = "Long"
			,position = 1)
	private String fuente_conabio;
	
	@ApiModelProperty(
			name = "recorded_by"
			,notes = "recorded_by"
//			,dataType = "Long"
			,position = 1)
	private String recorded_by;
	
	@ApiModelProperty(
			name = "record_number"
			,notes = "record_number"
//			,dataType = "Long"
			,position = 1)
	private String record_number;
	
	@ApiModelProperty(
			name = "life_stage"
			,notes = "life_stage"
//			,dataType = "Long"
			,position = 1)
	private String life_stage;
	
	@ApiModelProperty(
			name = "event_date"
			,notes = "event_date"
//			,dataType = "Long"
			,position = 1)
	private String event_date;
	
	@ApiModelProperty(
			name = "dyear"
			,notes = "dyear"
//			,dataType = "Long"
			,position = 1)
	private String dyear;
	
	@ApiModelProperty(
			name = "dmonth"
			,notes = "dmonth"
//			,dataType = "Long"
			,position = 1)
	private String dmonth;
	
	@ApiModelProperty(
			name = "dday"
			,notes = "dday"
//			,dataType = "Long"
			,position = 1)
	private String dday;
	
	@ApiModelProperty(
			name = "verbatim_event_date"
			,notes = "verbatim_event_date"
//			,dataType = "Long"
			,position = 1)
	private String verbatim_event_date;
	
	@ApiModelProperty(
			name = "habitat"
			,notes = "habitat"
//			,dataType = "Long"
			,position = 1)
	private String habitat;
	
	@ApiModelProperty(
			name = "higher_classification"
			,notes = "higher_classification"
//			,dataType = "Long"
			,position = 1)
	private String higher_classification;
	
	@ApiModelProperty(
			name = "scientific_name_id"
			,notes = "scientific_name_id"
//			,dataType = "Long"
			,position = 1)
	private String scientific_name_id;
	
	@ApiModelProperty(
			name = "accepted_name_usage_id"
			,notes = "accepted_name_usage_id"
//			,dataType = "Long"
			,position = 1)
	private String accepted_name_usage_id;
	
	@ApiModelProperty(
			name = "date_identified"
			,notes = "date_identified"
//			,dataType = "Long"
			,position = 1)
	private String date_identified;
	
	@ApiModelProperty(
			name = "identified_by"
			,notes = "identified_by"
//			,dataType = "Long"
			,position = 1)
	private String identified_by;
    
    @ApiModelProperty(
			name = "locality"
			,notes = "locality"
//			,dataType = "Long"
			,position = 1)
	private String locality;
	
	@ApiModelProperty(
			name = "verbatim_locality"
			,notes = "verbatim_locality"
//			,dataType = "Long"
			,position = 1)
	private String verbatim_locality;
	
	@ApiModelProperty(
			name = "minimum_elevation_in_meters"
			,notes = "minimum_elevation_in_meters"
//			,dataType = "Long"
			,position = 1)
	private String minimum_elevation_in_meters;
	
	@ApiModelProperty(
			name = "verbatim_elevation"
			,notes = "verbatim_elevation"
//			,dataType = "Long"
			,position = 1)
	private String verbatim_elevation;
	
	@ApiModelProperty(
			name = "coleccion"
			,notes = "coleccion"
//			,dataType = "Long"
			,position = 1)
	private String coleccion;
	
	@ApiModelProperty(
			name = "associated_media_ke002"
			,notes = "associated_media_ke002"
//			,dataType = "Long"
			,position = 1)
	private String associated_media_ke002;
	
	@ApiModelProperty(
			name = "associated_media"
			,notes = "associated_media"
//			,dataType = "Long"
			,position = 1)
	private String associated_media;
	
	@ApiModelProperty(
			name = "id_infra_sp"
			,notes = "id_infra_sp"
//			,dataType = "Long"
			,position = 1)
	private String id_infra_sp;
	
	@ApiModelProperty(
			name = "id_sp"
			,notes = "id_sp"
//			,dataType = "Long"
			,position = 1)
	private String id_sp;
	
	
	@ApiModelProperty(
			name = "id_genus"
			,notes = "id_genus"
//			,dataType = "Long"
			,position = 1)
	private String id_genus;
	
	@ApiModelProperty(
			name = "id_family"
			,notes = "id_family"
//			,dataType = "Long"
			,position = 1)
	private String id_family;
	
	@ApiModelProperty(
			name = "infra_sp"
			,notes = "infra_sp"
//			,dataType = "Long"
			,position = 1)
	private String infra_sp;
	
	@ApiModelProperty(
			name = "sp"
			,notes = "sp"
//			,dataType = "Long"
			,position = 1)
	private String sp;
	
	@ApiModelProperty(
			name = "genus"
			,notes = "genus"
//			,dataType = "Long"
			,position = 1)
	private String genus;
	
	@ApiModelProperty(
			name = "family"
			,notes = "family"
//			,dataType = "Long"
			,position = 1)
	private String family;
	
	@ApiModelProperty(
			name = "county"
			,notes = "county"
//			,dataType = "Long"
			,position = 1)
	private String county;
	
	@ApiModelProperty(
			name = "state"
			,notes = "state"
//			,dataType = "Long"
			,position = 1)
	private String state;
	
	@ApiModelProperty(
			name = "country"
			,notes = "country"
//			,dataType = "Long"
			,position = 1)
	private String country;
	
	@ApiModelProperty(
			name = "grupo_biologico"
			,notes = "grupo_biologico"
//			,dataType = "Long"
			,position = 1)
	private String grupo_biologico;
	
	@ApiModelProperty(
			name = "id_collection"
			,notes = "id_collection"
//			,dataType = "Long"
			,position = 1)
	private String id_collection;
	
	@ApiModelProperty(
			name = "collection"
			,notes = "collection"
//			,dataType = "Long"
			,position = 1)
	private String collection;
	
	@ApiModelProperty(
			name = "has_image"
			,notes = "has_image"
//			,dataType = "Long"
			,position = 1)
	private String has_image;
	
	@ApiModelProperty(
			name = "has_lat_lon"
			,notes = "has_lat_lon"
//			,dataType = "Long"
			,position = 1)
	private String has_lat_lon;
	
	@ApiModelProperty(
			name = "id_valida_fecha_colecta"
			,notes = "id_valida_fecha_colecta"
//			,dataType = "Long"
			,position = 1)
	private String id_valida_fecha_colecta;
	
	@ApiModelProperty(
			name = "id_valida_anio_colecta"
			,notes = "id_valida_anio_colecta"
//			,dataType = "Long"
			,position = 1)
	private String id_valida_anio_colecta;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getOccurrence_id() {
		return occurrence_id;
	}

	public void setOccurrence_id(String occurrence_id) {
		this.occurrence_id = occurrence_id;
	}

	public String getTax_label_name() {
		return tax_label_name;
	}

	public void setTax_label_name(String tax_label_name) {
		this.tax_label_name = tax_label_name;
	}

	public String getTax_accepted_name() {
		return tax_accepted_name;
	}

	public void setTax_accepted_name(String tax_accepted_name) {
		this.tax_accepted_name = tax_accepted_name;
	}

	public String getId_tax_label_name() {
		return id_tax_label_name;
	}

	public void setId_tax_label_name(String id_tax_label_name) {
		this.id_tax_label_name = id_tax_label_name;
	}

	public String getId_tax_accepted_name() {
		return id_tax_accepted_name;
	}

	public void setId_tax_accepted_name(String id_tax_accepted_name) {
		this.id_tax_accepted_name = id_tax_accepted_name;
	}

	public String getLabel_genus() {
		return label_genus;
	}

	public void setLabel_genus(String label_genus) {
		this.label_genus = label_genus;
	}

	public String getLabel_specific_epithet() {
		return label_specific_epithet;
	}

	public void setLabel_specific_epithet(String label_specific_epithet) {
		this.label_specific_epithet = label_specific_epithet;
	}

	public String getTaxonRank() {
		return taxonRank;
	}

	public void setTaxonRank(String taxonRank) {
		this.taxonRank = taxonRank;
	}

	public String getId_country() {
		return id_country;
	}

	public void setId_country(String id_country) {
		this.id_country = id_country;
	}

	public String getId_state() {
		return id_state;
	}

	public void setId_state(String id_state) {
		this.id_state = id_state;
	}

	public String getId_county() {
		return id_county;
	}

	public void setId_county(String id_county) {
		this.id_county = id_county;
	}

	public String getCatalog_number() {
		return catalog_number;
	}

	public void setCatalog_number(String catalog_number) {
		this.catalog_number = catalog_number;
	}

	public String getDataset_id() {
		return dataset_id;
	}

	public void setDataset_id(String dataset_id) {
		this.dataset_id = dataset_id;
	}

	public String getCollection_code() {
		return collection_code;
	}

	public void setCollection_code(String collection_code) {
		this.collection_code = collection_code;
	}

	public String getCollection_id() {
		return collection_id;
	}

	public void setCollection_id(String collection_id) {
		this.collection_id = collection_id;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getBibliographic_citation() {
		return bibliographic_citation;
	}

	public void setBibliographic_citation(String bibliographic_citation) {
		this.bibliographic_citation = bibliographic_citation;
	}

	public String getDynamic_properties() {
		return dynamic_properties;
	}

	public void setDynamic_properties(String dynamic_properties) {
		this.dynamic_properties = dynamic_properties;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getBiodiversity_id() {
		return biodiversity_id;
	}

	public void setBiodiversity_id(String biodiversity_id) {
		this.biodiversity_id = biodiversity_id;
	}

	public String getFuente_conabio() {
		return fuente_conabio;
	}

	public void setFuente_conabio(String fuente_conabio) {
		this.fuente_conabio = fuente_conabio;
	}

	public String getRecorded_by() {
		return recorded_by;
	}

	public void setRecorded_by(String recorded_by) {
		this.recorded_by = recorded_by;
	}

	public String getRecord_number() {
		return record_number;
	}

	public void setRecord_number(String record_number) {
		this.record_number = record_number;
	}

	public String getLife_stage() {
		return life_stage;
	}

	public void setLife_stage(String life_stage) {
		this.life_stage = life_stage;
	}

	public String getEvent_date() {
		return event_date;
	}

	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}

	public String getDyear() {
		return dyear;
	}

	public void setDyear(String dyear) {
		this.dyear = dyear;
	}

	public String getDmonth() {
		return dmonth;
	}

	public void setDmonth(String dmonth) {
		this.dmonth = dmonth;
	}

	public String getDday() {
		return dday;
	}

	public void setDday(String dday) {
		this.dday = dday;
	}

	public String getVerbatim_event_date() {
		return verbatim_event_date;
	}

	public void setVerbatim_event_date(String verbatim_event_date) {
		this.verbatim_event_date = verbatim_event_date;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public String getHigher_classification() {
		return higher_classification;
	}

	public void setHigher_classification(String higher_classification) {
		this.higher_classification = higher_classification;
	}

	public String getScientific_name_id() {
		return scientific_name_id;
	}

	public void setScientific_name_id(String scientific_name_id) {
		this.scientific_name_id = scientific_name_id;
	}

	public String getAccepted_name_usage_id() {
		return accepted_name_usage_id;
	}

	public void setAccepted_name_usage_id(String accepted_name_usage_id) {
		this.accepted_name_usage_id = accepted_name_usage_id;
	}

	public String getDate_identified() {
		return date_identified;
	}

	public void setDate_identified(String date_identified) {
		this.date_identified = date_identified;
	}

	public String getIdentified_by() {
		return identified_by;
	}

	public void setIdentified_by(String identified_by) {
		this.identified_by = identified_by;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getVerbatim_locality() {
		return verbatim_locality;
	}

	public void setVerbatim_locality(String verbatim_locality) {
		this.verbatim_locality = verbatim_locality;
	}

	public String getMinimum_elevation_in_meters() {
		return minimum_elevation_in_meters;
	}

	public void setMinimum_elevation_in_meters(String minimum_elevation_in_meters) {
		this.minimum_elevation_in_meters = minimum_elevation_in_meters;
	}

	public String getVerbatim_elevation() {
		return verbatim_elevation;
	}

	public void setVerbatim_elevation(String verbatim_elevation) {
		this.verbatim_elevation = verbatim_elevation;
	}

	public String getColeccion() {
		return coleccion;
	}

	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	public String getAssociated_media_ke002() {
		return associated_media_ke002;
	}

	public void setAssociated_media_ke002(String associated_media_ke002) {
		this.associated_media_ke002 = associated_media_ke002;
	}

	public String getAssociated_media() {
		return associated_media;
	}

	public void setAssociated_media(String associated_media) {
		this.associated_media = associated_media;
	}

	public String getId_infra_sp() {
		return id_infra_sp;
	}

	public void setId_infra_sp(String id_infra_sp) {
		this.id_infra_sp = id_infra_sp;
	}

	public String getId_sp() {
		return id_sp;
	}

	public void setId_sp(String id_sp) {
		this.id_sp = id_sp;
	}

	public String getId_genus() {
		return id_genus;
	}

	public void setId_genus(String id_genus) {
		this.id_genus = id_genus;
	}

	public String getId_family() {
		return id_family;
	}

	public void setId_family(String id_family) {
		this.id_family = id_family;
	}

	public String getInfra_sp() {
		return infra_sp;
	}

	public void setInfra_sp(String infra_sp) {
		this.infra_sp = infra_sp;
	}

	public String getSp() {
		return sp;
	}

	public void setSp(String sp) {
		this.sp = sp;
	}

	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGrupo_biologico() {
		return grupo_biologico;
	}

	public void setGrupo_biologico(String grupo_biologico) {
		this.grupo_biologico = grupo_biologico;
	}

	public String getId_collection() {
		return id_collection;
	}

	public void setId_collection(String id_collection) {
		this.id_collection = id_collection;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getHas_image() {
		return has_image;
	}

	public void setHas_image(String has_image) {
		this.has_image = has_image;
	}

	public String getHas_lat_lon() {
		return has_lat_lon;
	}

	public void setHas_lat_lon(String has_lat_lon) {
		this.has_lat_lon = has_lat_lon;
	}

	public String getId_valida_fecha_colecta() {
		return id_valida_fecha_colecta;
	}

	public void setId_valida_fecha_colecta(String id_valida_fecha_colecta) {
		this.id_valida_fecha_colecta = id_valida_fecha_colecta;
	}

	public String getId_valida_anio_colecta() {
		return id_valida_anio_colecta;
	}

	public void setId_valida_anio_colecta(String id_valida_anio_colecta) {
		this.id_valida_anio_colecta = id_valida_anio_colecta;
	}


}
