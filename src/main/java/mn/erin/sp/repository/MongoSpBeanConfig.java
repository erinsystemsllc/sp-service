package mn.erin.sp.repository;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.lang.NonNull;

/**
 * @author Byambajav
 */
@Configuration
@PropertySource("classpath:sp-mongo.properties")
@EnableMongoRepositories(basePackages = "mn.erin.sp.domain*")
public class MongoSpBeanConfig extends AbstractMongoClientConfiguration
{
  @Value("${spring.data.mongodb.database}")
  private String dbName;
  @Value("${spring.data.mongodb.uri}")
  private String uri;

  @Override
  @NonNull
  protected String getDatabaseName()
  {
    return dbName;
  }

  @Override
  @NonNull
  public MongoClient mongoClient()
  {
    ConnectionString connectionString = new ConnectionString(uri);
    MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
        .applyConnectionString(connectionString)
        .build();

    return MongoClients.create(mongoClientSettings);
  }
}
