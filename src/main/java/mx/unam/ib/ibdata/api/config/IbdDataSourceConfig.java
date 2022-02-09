package mx.unam.ib.ibdata.api.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class IbdDataSourceConfig extends AbstractMongoClientConfiguration{
	
//	@Autowired
//	private Environment environment;

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "ibdata_test";
	}
	
	@Override
    public MongoClient mongoClient() {
        //ConnectionString connectionString = new ConnectionString("mongodb+srv://root:Ccaj030909@cluster0.9svg8.mongodb.net/test?authSource=admin&replicaSet=atlas-vissu8-shard-0&readPreference=primary&appname=MongoDB%20Compass&ssl=true");
		
		ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/?ssl=false");
        
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
        
        return MongoClients.create(mongoClientSettings);
    }
 
	@Override
    public Collection<String> getMappingBasePackages() {
        return Collections.singleton("mx.unam.ib.ibdata.api.model.collection");
    }
	
}
