package mn.erin.sp.domain.user.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Byambajav
 */
public interface MongoUserRepository extends MongoRepository<MongoUser, String>
{
  Optional<MongoUser> findByAccountId(String accountId);
}
