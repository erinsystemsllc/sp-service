package mn.erin.sp.domain.project.usecase;

import mn.erin.sp.domain.RepositoryBeanRegistry;

/**
 * @author Byambajav
 */
public class UpdateProjectBoard
{
  private final RepositoryBeanRegistry repositoryBeanRegistry;

  public UpdateProjectBoard(RepositoryBeanRegistry repositoryBeanRegistry)
  {
    this.repositoryBeanRegistry = repositoryBeanRegistry;
  }

  public void execute(String projectCode, String boardId)
  {
    repositoryBeanRegistry.getProjectRepository().updateBoard(projectCode, boardId);
  }
}
