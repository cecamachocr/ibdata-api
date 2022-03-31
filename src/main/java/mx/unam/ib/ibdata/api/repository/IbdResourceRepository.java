package mx.unam.ib.ibdata.api.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IbdResourceRepository <T, I extends Serializable> extends MongoRepository<T, I>{
	
	Page<T> findAll(Query query, Pageable pageable);
	
	Long countByQuery(Query query);
}
