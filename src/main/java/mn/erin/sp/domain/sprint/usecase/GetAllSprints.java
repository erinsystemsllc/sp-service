package mn.erin.sp.domain.sprint.usecase;

import java.util.List;

import mn.erin.sp.domain.RepositoryBeanRegistry;
import mn.erin.sp.domain.sprint.model.Sprint;

/**
 * @author Byambajav
 */
public class GetAllSprints
{
  private final RepositoryBeanRegistry repositoryBeanRegistry;

  public GetAllSprints(RepositoryBeanRegistry repositoryBeanRegistry)
  {
    this.repositoryBeanRegistry = repositoryBeanRegistry;
  }

  public List<Sprint> execute()
  {
    return repositoryBeanRegistry.getSprintRepository().findAll();
  }

}
