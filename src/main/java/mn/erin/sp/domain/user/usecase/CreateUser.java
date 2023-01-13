package mn.erin.sp.domain.user.usecase;

import mn.erin.sp.domain.RepositoryBeanRegistry;

/**
 * @author Byambajav
 */
public class CreateUser
{
  private final RepositoryBeanRegistry repositoryBeanRegistry;

  public CreateUser(RepositoryBeanRegistry repositoryBeanRegistry)
  {
    this.repositoryBeanRegistry = repositoryBeanRegistry;
  }

  public String execute(String accountId, String displayName, String email)
  {
    return repositoryBeanRegistry.getUserRepository().create(accountId, displayName, email);
  }
}
