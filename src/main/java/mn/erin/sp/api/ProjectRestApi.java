package mn.erin.sp.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import mn.erin.sp.domain.RepositoryBeanRegistry;
import mn.erin.sp.domain.project.model.Project;
import mn.erin.sp.domain.project.usecase.CreateProject;
import mn.erin.sp.domain.project.usecase.GetAllProjects;
import mn.erin.sp.domain.project.usecase.UpdateProjectBoard;
import mn.erin.sp.rest.ProjectApiDelegate;
import mn.erin.sp.rest.model.GetAllProjectResponseRestModel;
import mn.erin.sp.rest.model.ProjectBoardsResponseRestModel;
import mn.erin.sp.rest.model.ProjectCreationRequestRestModel;
import mn.erin.sp.rest.model.ProjectCreationResponseRestModel;
import mn.erin.sp.rest.model.ProjectRestModel;
import mn.erin.sp.rest.model.UpdateProjectBoardRequestRestModel;
import mn.erin.sp.rest.model.UpdateProjectBoardResponseRestModel;

/**
 * @author Byambajav
 */
public class ProjectRestApi implements ProjectApiDelegate
{
  private final RepositoryBeanRegistry repositoryBeanRegistry;

  public ProjectRestApi(RepositoryBeanRegistry repositoryBeanRegistry)
  {
    this.repositoryBeanRegistry = repositoryBeanRegistry;
  }

  @Override
  public ResponseEntity<ProjectCreationResponseRestModel> createProject(ProjectCreationRequestRestModel projectCreationRequestRestModel)
  {
    CreateProject createProject = new CreateProject(repositoryBeanRegistry);
    String projectId = createProject.execute(
        projectCreationRequestRestModel.getCode(),
        projectCreationRequestRestModel.getName(),
        projectCreationRequestRestModel.getKey(),
        projectCreationRequestRestModel.getImageUrl());
    return ResponseEntity.ok(new ProjectCreationResponseRestModel().id(projectId));
  }

  @Override
  public ResponseEntity<ProjectBoardsResponseRestModel> getProjectBoards()
  {
    return ProjectApiDelegate.super.getProjectBoards();
  }

  @Override
  public ResponseEntity<GetAllProjectResponseRestModel> getProjects()
  {
    GetAllProjects getAllProjects = new GetAllProjects(repositoryBeanRegistry);
    List<Project> projects = getAllProjects.execute();
    return ResponseEntity.ok(new GetAllProjectResponseRestModel().projects(projects.stream().map(this::convert).collect(Collectors.toList())));
  }

  @Override
  public ResponseEntity<UpdateProjectBoardResponseRestModel> updateProjectBoard(UpdateProjectBoardRequestRestModel updateProjectBoardRequestRestModel)
  {
    UpdateProjectBoard updateProjectBoard = new UpdateProjectBoard(repositoryBeanRegistry);
    updateProjectBoard.execute(
        updateProjectBoardRequestRestModel.getProjectCode(),
        updateProjectBoardRequestRestModel.getBoardId());
    return ResponseEntity.ok(new UpdateProjectBoardResponseRestModel().id("OK"));
  }

  private ProjectRestModel convert(Project project)
  {
    return new ProjectRestModel()
        .code(project.getCode())
        .name(project.getName())
        .key(project.getKey())
        .imageUrl(project.getImageUrl());
  }
}
