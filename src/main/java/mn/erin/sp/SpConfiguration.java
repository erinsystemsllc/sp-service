package mn.erin.sp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import mn.erin.sp.api.ProjectRestApi;
import mn.erin.sp.api.SprintRestApi;
import mn.erin.sp.api.UserRestApi;
import mn.erin.sp.domain.RepositoryBeanRegistry;

/**
 * @author Byambajav
 */
@Configuration

@Import({ RepositoryConfiguration.class })
public class SpConfiguration
{
  @Bean
  UserRestApi userRestApi(@Autowired RepositoryBeanRegistry repositoryBeanRegistry)
  {
    return new UserRestApi(repositoryBeanRegistry);
  }

  @Bean
  ProjectRestApi projectRestApi(@Autowired RepositoryBeanRegistry repositoryBeanRegistry)
  {
    return new ProjectRestApi(repositoryBeanRegistry);
  }

  @Bean
  SprintRestApi sprintRestApi(@Autowired RepositoryBeanRegistry repositoryBeanRegistry)
  {
    return new SprintRestApi(repositoryBeanRegistry);
  }
}
