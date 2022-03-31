package mx.unam.ib.ibdata.api.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.util.Assert;


public class IbdResourceRepositoryImpl <T, I extends Serializable> extends SimpleMongoRepository<T, I> implements IbdResourceRepository<T, I>{
	
	
	private MongoOperations mongoOperations;
    private MongoEntityInformation entityInformation;
    
	public IbdResourceRepositoryImpl(MongoEntityInformation<T, I> entityInformation, MongoOperations mongoOperations) {
		super(entityInformation, mongoOperations);
		this.entityInformation = entityInformation;
		this.mongoOperations = mongoOperations;
       
	}
	
	
	@Override
    public Page<T> findAll(final Query query, final Pageable pageable) {
        Assert.notNull(query, "Query must not be null!");

        return new PageImpl<T>(
        		mongoOperations.find(query.with(pageable), entityInformation.getJavaType(), entityInformation.getCollectionName()),
                pageable,
                mongoOperations.count(query, entityInformation.getJavaType(), entityInformation.getCollectionName())
        );
    }
	
	@Override
    public Long countByQuery(final Query query) {
        Assert.notNull(query, "Query must not be null!");

        return mongoOperations.count(query, entityInformation.getJavaType(), entityInformation.getCollectionName());
        
    }

}
