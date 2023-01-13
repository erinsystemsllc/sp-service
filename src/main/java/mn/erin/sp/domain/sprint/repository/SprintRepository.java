package mn.erin.sp.domain.sprint.repository;

import java.time.LocalDate;
import java.util.List;

import mn.erin.sp.domain.sprint.model.Sprint;

/**
 * @author Byambajav
 */
public interface SprintRepository
{
  String create(String code, String name, String description, String projectId, String boardId, LocalDate startDate, LocalDate endDate);
  List<Sprint> findAll();
}
