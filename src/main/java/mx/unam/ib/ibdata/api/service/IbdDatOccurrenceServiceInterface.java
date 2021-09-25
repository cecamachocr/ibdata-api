package mx.unam.ib.ibdata.api.service;

import mx.unam.ib.ibdata.api.model.vo.IbdDatOccurrenceCriteriaVO;
import mx.unam.ib.ibdata.api.model.vo.IbdDatOcurrenceVO;

public interface IbdDatOccurrenceServiceInterface {
	
	public IbdDatOcurrenceVO findUserByIdCountry(IbdDatOccurrenceCriteriaVO req) throws Exception;
}
