package mn.erin.sp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import mn.erin.sp.domain.RepositoryBeanRegistry;
import mn.erin.sp.domain.project.repository.MongoProjectRepository;
import mn.erin.sp.domain.project.repository.ProjectRepository;
import mn.erin.sp.domain.project.repository.ProjectRepositoryImpl;
import mn.erin.sp.domain.sprint.repository.MongoSprintRepository;
import mn.erin.sp.domain.sprint.repository.SprintRepository;
import mn.erin.sp.domain.sprint.repository.SprintRepositoryImpl;
import mn.erin.sp.domain.user.repository.MongoUserRepository;
import mn.erin.sp.domain.user.repository.UserRepository;
import mn.erin.sp.domain.user.repository.UserRepositoryImpl;
import mn.erin.sp.repository.MongoSpBeanConfig;

/**
 * @author Byambajav
 */
@Configuration
@Import({ MongoSpBeanConfig.class })
public class RepositoryConfiguration
{
  @Bean
  UserRepository userRepository(@Autowired MongoUserRepository mongoUserRepository)
  {
    return new UserRepositoryImpl(mongoUserRepository);
  }

  @Bean
  ProjectRepository projectRepository(@Autowired MongoProjectRepository mongoProjectRepository)
  {
    return new ProjectRepositoryImpl(mongoProjectRepository);
  }

  @Bean
  SprintRepository sprintRepository(@Autowired MongoSprintRepository mongoSprintRepository)
  {
    return new SprintRepositoryImpl(mongoSprintRepository);
  }

  @Bean
  RepositoryBeanRegistry repositoryBeanRegistry()
  {
    return new RepositoryBeanRegistry()
    {
      @Autowired
      MongoUserRepository mongoUserRepository;
      @Autowired
      MongoProjectRepository mongoProjectRepository;
      @Autowired
      MongoSprintRepository mongoSprintRepository;

      @Override
      public UserRepository getUserRepository()
      {
        return userRepository(mongoUserRepository);
      }

      @Override
      public ProjectRepository getProjectRepository()
      {
        return projectRepository(mongoProjectRepository);
      }
      @Override
      public SprintRepository getSprintRepository()
      {
        return sprintRepository(mongoSprintRepository);
      }
    };
  }
}
