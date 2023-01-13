package mn.erin.sp.domain.sprint.usecase;

import java.time.LocalDate;

import mn.erin.sp.domain.RepositoryBeanRegistry;

/**
 * @author Byambajav
 */
public class CreateSprint
{
  private final RepositoryBeanRegistry repositoryBeanRegistry;

  public CreateSprint(RepositoryBeanRegistry repositoryBeanRegistry)
  {
    this.repositoryBeanRegistry = repositoryBeanRegistry;
  }

  public String execute(String code, String name, String description, String projectId, String boardId, LocalDate startDate, LocalDate endDate)
  {
    return repositoryBeanRegistry.getSprintRepository().create(code, name, description, projectId,boardId, startDate, endDate);
  }
}
