package mn.erin.sp.domain;

import mn.erin.sp.domain.project.repository.ProjectRepository;
import mn.erin.sp.domain.sprint.repository.SprintRepository;
import mn.erin.sp.domain.user.repository.UserRepository;

/**
 * @author Byambajav
 */
public interface RepositoryBeanRegistry
{
  UserRepository getUserRepository();

  ProjectRepository getProjectRepository();

  SprintRepository getSprintRepository();
}
