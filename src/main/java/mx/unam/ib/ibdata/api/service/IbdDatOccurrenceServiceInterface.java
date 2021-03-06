package mx.unam.ib.ibdata.api.service;

import mx.unam.ib.ibdata.api.model.vo.IbdDatOccurrenceCriteriaVO;
import mx.unam.ib.ibdata.api.model.vo.IbdDatOcurrenceResponse;

public interface IbdDatOccurrenceServiceInterface {
	
	public IbdDatOcurrenceResponse findUserByIdCountry(IbdDatOccurrenceCriteriaVO req) throws Exception;
	
	public IbdDatOcurrenceResponse findUserByIdCountryDAO(IbdDatOccurrenceCriteriaVO req) throws Exception;
	
	public IbdDatOcurrenceResponse findByCriteria(IbdDatOccurrenceCriteriaVO req) throws Exception;
	
	public IbdDatOcurrenceResponse findByCriteriaLimit(IbdDatOccurrenceCriteriaVO req) throws Exception;
}
