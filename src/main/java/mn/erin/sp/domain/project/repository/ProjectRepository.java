package mn.erin.sp.domain.project.repository;

import java.util.List;

import mn.erin.sp.domain.project.model.Project;

/**
 * @author Byambajav
 */
public interface ProjectRepository
{
  String create(String code, String name, String key, String imageUrl);

  List<Project> findAll();

  void updateBoard(String code, String boardId);
}
