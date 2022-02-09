package mx.unam.ib.ibdata.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import mx.unam.ib.ibdata.api.model.collection.IbdDatOcurrenceCollection;

public interface IbdDatOcurrenceMDRepository extends MongoRepository<IbdDatOcurrenceCollection, String>
{
	
	@Query(value = "{'occurrence_id':?0}")
	List<IbdDatOcurrenceCollection> findByOcurrenceId(String ocurrenceId, Pageable pageable);
	
	
	@Query(value = "{'occurrence_id': ?0}", count = true)
	public Long countByOcurrenceId(String ocurrenceId);
	

}
