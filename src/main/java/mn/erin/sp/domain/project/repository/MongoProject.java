package mn.erin.sp.domain.project.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Byambajav
 */
@Document
public class MongoProject
{
  @Id
  private final String id;
  private final String name;
  private final String key;
  private final String code;
  private String imageUrl;
  Set<String> boardIds = new HashSet<>();

  public MongoProject(String id, String code, String name, String key)
  {
    this.id = id;
    this.name = name;
    this.key = key;
    this.code = code;
  }

  public String getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getKey()
  {
    return key;
  }

  public String getCode()
  {
    return code;
  }

  public String getImageUrl()
  {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl)
  {
    this.imageUrl = imageUrl;
  }

  public Set<String> getBoardIds()
  {
    return boardIds;
  }

  public void setBoardIds(Set<String> boardIds)
  {
    this.boardIds = boardIds;
  }
}
