package mx.unam.ib.ibdata.api.dao;

import java.util.List;

import mx.unam.ib.ibdata.api.model.entity.IbdDatOcurrenceEntity;

public interface IbdDatOcurrenceDAOInterface {
	
	public List<IbdDatOcurrenceEntity> callFunctionGetByIdCountry(Integer idCountry, Integer pageNum, Integer pageLimit);
	
	public Integer callFunctionGetByIdCountryCount(Integer idCountry);
}
