package mn.erin.sp.domain.sprint.repository;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Byambajav
 */
@Document
public class MongoSprint
{
  @Id
  private String id;
  private String code;
  private String name;
  private String description;
  private String projectId;
  private LocalDate startDate;
  private LocalDate endDate;
  private String boardId;

  public MongoSprint(String name, String description, String projectId)
  {
    this.name = name;
    this.description = description;
    this.projectId = projectId;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
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

  public void setBoardId(String boardId)
  {
    this.boardId = boardId;
  }

  public String getCode()
  {
    return code;
  }

  public void setCode(String code)
  {
    this.code = code;
  }
}
