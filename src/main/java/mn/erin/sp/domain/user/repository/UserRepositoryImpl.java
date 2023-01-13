package mn.erin.sp.domain.user.repository;

import java.util.Optional;
import java.util.UUID;

import mn.erin.sp.domain.user.model.User;

/**
 * @author Byambajav
 */
public class UserRepositoryImpl implements UserRepository
{
  private final MongoUserRepository mongoUserRepository;

  public UserRepositoryImpl(MongoUserRepository mongoUserRepository)
  {
    this.mongoUserRepository = mongoUserRepository;
  }

  @Override
  public User findUserById(String id)
  {
    return null;
  }

  @Override
  public String create(String accountId, String displayName, String email)
  {
    Optional<MongoUser> optionalUser = mongoUserRepository.findByAccountId(accountId);
    if (optionalUser.isPresent())
    {
      return optionalUser.get().getId();
    }
    else
    {
      MongoUser mongoUser = new MongoUser(UUID.randomUUID().toString(), accountId, displayName, email);
      mongoUserRepository.save(mongoUser);
      return mongoUser.getId();
    }
  }
}
