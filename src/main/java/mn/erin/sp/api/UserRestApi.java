package mn.erin.sp.api;

import org.springframework.http.ResponseEntity;

import mn.erin.sp.domain.RepositoryBeanRegistry;
import mn.erin.sp.domain.user.usecase.CreateUser;
import mn.erin.sp.rest.UserApiDelegate;
import mn.erin.sp.rest.model.UserCreationRequestRestModel;
import mn.erin.sp.rest.model.UserCreationResponseRestModel;

/**
 * @author Byambajav
 */
public class UserRestApi implements UserApiDelegate
{
  private final RepositoryBeanRegistry repositoryBeanRegistry;

  public UserRestApi(RepositoryBeanRegistry repositoryBeanRegistry)
  {
    this.repositoryBeanRegistry = repositoryBeanRegistry;
  }

  @Override
  public ResponseEntity<UserCreationResponseRestModel> createUser(UserCreationRequestRestModel userCreationRequestRestModel)
  {
    CreateUser createUser = new CreateUser(repositoryBeanRegistry);

    String userId = createUser.execute(userCreationRequestRestModel.getAccountId(), userCreationRequestRestModel.getDisplayName(),
        userCreationRequestRestModel.getEmail());
    return ResponseEntity.ok(new UserCreationResponseRestModel().id(userId));
  }
}
