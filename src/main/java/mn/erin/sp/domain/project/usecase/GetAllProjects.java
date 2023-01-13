package mn.erin.sp.domain.project.usecase;

import java.util.List;

import mn.erin.sp.domain.RepositoryBeanRegistry;
import mn.erin.sp.domain.project.model.Project;

/**
 * @author Byambajav
 */
public class GetAllProjects
{
  private final RepositoryBeanRegistry repositoryBeanRegistry;

  public GetAllProjects(RepositoryBeanRegistry repositoryBeanRegistry)
  {
    this.repositoryBeanRegistry = repositoryBeanRegistry;
  }

  public List<Project> execute()
  {
    return repositoryBeanRegistry.getProjectRepository().findAll();
  }
}
