package mx.unam.ib.ibdata.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;

import mx.unam.ib.ibdata.api.model.collection.IbdDatOcurrenceCollection;

public interface IbdDatOcurrenceMDRepository extends IbdResourceRepository<IbdDatOcurrenceCollection, String>
{
	
	@Query(value = "{'occurrence_id':?0}")
	List<IbdDatOcurrenceCollection> findByOcurrenceIds(String ocurrenceId, Pageable pageable);
	
	
	@Query(value = "{'occurrence_id': ?0}", count = true)
	public Long countByOcurrenceId(String ocurrenceId);
	
	
	
	@Query(value = "{'state':?0}")
	List<IbdDatOcurrenceCollection> findByState(String state, Pageable pageable);
	
	
	@Query(value = "{'state': ?0}", count = true)
	public Long countByState(String state);
	

}
