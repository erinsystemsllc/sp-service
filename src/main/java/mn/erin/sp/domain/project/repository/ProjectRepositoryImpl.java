package mn.erin.sp.domain.project.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import mn.erin.sp.domain.project.model.Project;

/**
 * @author Byambajav
 */
public class ProjectRepositoryImpl implements ProjectRepository
{
  private final MongoProjectRepository mongoProjectRepository;

  public ProjectRepositoryImpl(MongoProjectRepository mongoProjectRepository)
  {
    this.mongoProjectRepository = mongoProjectRepository;
  }

  @Override
  public String create(String code, String name, String key, String imageUrl)
  {
    Optional<MongoProject> mongoProject = mongoProjectRepository.findByCode(code);
    if (mongoProject.isPresent())
    {
      return mongoProject.get().getId();
    }
    else
    {
      MongoProject newMongoProject = new MongoProject(UUID.randomUUID().toString(), code, name, key);
      newMongoProject.setImageUrl(imageUrl);
      mongoProjectRepository.save(newMongoProject);
      return newMongoProject.getId();
    }
  }

  @Override
  public List<Project> findAll()
  {
    List<MongoProject> mongoProjects = mongoProjectRepository.findAll();
    return mongoProjects.stream().map(this::convert).collect(Collectors.toList());
  }

  @Override
  public void updateBoard(String code, String boardId)
  {
    Optional<MongoProject> mongoProject = mongoProjectRepository.findByCode(code);
    if (mongoProject.isPresent())
    {
      MongoProject project = mongoProject.get();
      Set<String> boardIds = project.getBoardIds();
      boardIds.add(boardId);
      project.setBoardIds(boardIds);
      mongoProjectRepository.save(project);
    }
  }

  private Project convert(MongoProject mongoProject)
  {
    return new Project(mongoProject.getId(), mongoProject.getCode(), mongoProject.getName(), mongoProject.getKey(), mongoProject.getImageUrl());
  }
}
