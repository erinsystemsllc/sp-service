package mn.erin.sp.api;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import org.springframework.http.ResponseEntity;

import mn.erin.sp.domain.RepositoryBeanRegistry;
import mn.erin.sp.domain.sprint.usecase.CreateSprint;
import mn.erin.sp.rest.SprintApiDelegate;
import mn.erin.sp.rest.model.SprintCreationRequestRestModel;
import mn.erin.sp.rest.model.SprintCreationResponseRestModel;

/**
 * @author Byambajav
 */
public class SprintRestApi implements SprintApiDelegate
{
  private final RepositoryBeanRegistry repositoryBeanRegistry;

  public SprintRestApi(RepositoryBeanRegistry repositoryBeanRegistry)
  {
    this.repositoryBeanRegistry = repositoryBeanRegistry;
  }

  @Override
  public ResponseEntity<SprintCreationResponseRestModel> createSprint(SprintCreationRequestRestModel sprintCreationRequestRestModel)
  {
    CreateSprint createSprint = new CreateSprint(repositoryBeanRegistry);
    Instant startInstant = Instant.parse(sprintCreationRequestRestModel.getStartDate());
    Instant endInstant = Instant.parse(sprintCreationRequestRestModel.getEndDate());
    LocalDate startDate = LocalDateTime.ofInstant(startInstant, ZoneId.of(ZoneOffset.UTC.getId())).toLocalDate();
    LocalDate endDate = LocalDateTime.ofInstant(endInstant, ZoneId.of(ZoneOffset.UTC.getId())).toLocalDate();
    String sprintId = createSprint.execute(
        sprintCreationRequestRestModel.getCode(),
        sprintCreationRequestRestModel.getName(),
        sprintCreationRequestRestModel.getDescription(),
        sprintCreationRequestRestModel.getProjectId(),
        sprintCreationRequestRestModel.getBoardId(), startDate, endDate);
    return ResponseEntity.ok(new SprintCreationResponseRestModel().id(sprintId));
  }
}
