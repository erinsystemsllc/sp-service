package mn.erin.sp.domain.project.usecase;

import mn.erin.sp.domain.RepositoryBeanRegistry;

/**
 * @author Byambajav
 */
public class CreateProject
{
  private final RepositoryBeanRegistry repositoryBeanRegistry;

  public CreateProject(RepositoryBeanRegistry repositoryBeanRegistry)
  {
    this.repositoryBeanRegistry = repositoryBeanRegistry;
  }

  public String execute(String code, String name, String key, String imageUrl)
  {
    return repositoryBeanRegistry.getProjectRepository().create(code, name, key, imageUrl);
  }
}
