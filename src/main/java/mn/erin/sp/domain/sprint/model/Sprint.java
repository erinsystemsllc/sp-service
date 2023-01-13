package mn.erin.sp.domain.sprint.model;

import java.time.LocalDate;

import mn.erin.common.domain.stereotype.Entity;

/**
 * @author Byambajav
 */
@Entity
public class Sprint
{
  private final String id;
  private final String name;
  private String code;
  private LocalDate startDate;
  private LocalDate endDate;
  private String boardId;
  private String description;
  private String projectId;

  public Sprint(String id, String name, String description, String projectId)
  {
    this.id = id;
    this.name = name;
    this.description = description;
    this.projectId = projectId;
  }

  public String getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getProjectId()
  {
    return projectId;
  }

  public void setProjectId(String projectId)
  {
    this.projectId = projectId;
  }

  public LocalDate getStartDate()
  {
    return startDate;
  }

  public void setStartDate(LocalDate startDate)
  {
    this.startDate = startDate;
  }

  public LocalDate getEndDate()
  {
    return endDate;
  }

  public void setEndDate(LocalDate endDate)
  {
    this.endDate = endDate;
  }

  public String getBoardId()
  {
    return boardId;
  }

  public String getCode()
  {
    return code;
  }

  public void setCode(String code)
  {
    this.code = code;
  }

  public void setBoardId(String boardId)
  {
    this.boardId = boardId;
  }
}
