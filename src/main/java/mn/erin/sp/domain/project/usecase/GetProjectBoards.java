//package mn.erin.sp.domain.project.usecase;
//
//import java.util.List;
//
//import mn.erin.sp.domain.RepositoryBeanRegistry;
//import mn.erin.sp.domain.project.model.Project;
//
///**
// * @author Byambajav
// */
//public class GetProjectBoards
//{
//  private final RepositoryBeanRegistry repositoryBeanRegistry;
//
//  public GetProjectBoards(RepositoryBeanRegistry repositoryBeanRegistry)
//  {
//    this.repositoryBeanRegistry = repositoryBeanRegistry;
//  }
//
//  public List<String> execute(String projectId)
//  {
//    List<Project> projects = repositoryBeanRegistry.getProjectRepository().findAll();
//  }
//}
