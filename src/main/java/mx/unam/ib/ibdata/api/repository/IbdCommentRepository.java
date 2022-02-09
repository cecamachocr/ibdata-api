package mx.unam.ib.ibdata.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;

import mx.unam.ib.ibdata.api.model.collection.IbdComment;

public interface IbdCommentRepository
{
	
	@Query(value = "{name:'?0'}")
	List<IbdComment> findByName(String name, Pageable pageable);
	
	
	@Query(value = "{'name': ?0}", count = true)
	public Long countByName(String name);
	

}
