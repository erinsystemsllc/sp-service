package mn.erin.sp.domain.sprint.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import mn.erin.sp.domain.sprint.model.Sprint;
import mn.erin.sp.rest.model.ProjectRestModel;

/**
 * @author Byambajav
 */
public class SprintRepositoryImpl implements SprintRepository
{
  private final MongoSprintRepository mongoSprintRepository;

  public SprintRepositoryImpl(MongoSprintRepository mongoSprintRepository)
  {
    this.mongoSprintRepository = mongoSprintRepository;
  }

  @Override
  public String create(String code, String name, String description, String projectId, String boardId, LocalDate startDate, LocalDate endDate)
  {
    MongoSprint mongoSprint = new MongoSprint(name, description, projectId);
    mongoSprint.setCode(code);
    mongoSprint.setId(UUID.randomUUID().toString());
    mongoSprint.setStartDate(startDate);
    mongoSprint.setEndDate(endDate);
    mongoSprint.setBoardId(boardId);
    mongoSprintRepository.save(mongoSprint);
    return mongoSprint.getId();
  }

  @Override
  public List<Sprint> findAll()
  {
    return mongoSprintRepository.findAll().stream().map(this::toSprint).collect(Collectors.toList());
  }

  private Sprint toSprint(MongoSprint mongoSprint)
  {
    Sprint sprint = new Sprint(mongoSprint.getId(), mongoSprint.getName(), mongoSprint.getDescription(), mongoSprint.getProjectId());
    sprint.setBoardId(mongoSprint.getBoardId());
    sprint.setStartDate(mongoSprint.getStartDate());
    sprint.setEndDate(mongoSprint.getEndDate());
    sprint.setCode(mongoSprint.getCode());
    return sprint;
  }


}
