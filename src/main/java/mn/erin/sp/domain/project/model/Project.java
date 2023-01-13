package mn.erin.sp.domain.project.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Byambajav
 */
public class Project
{
  private String id;
  private String code;
  private String name;
  private String key;
  private String imageUrl;
  Set<String> boardIds = new HashSet<>();

  public Project(String id, String code, String name, String key, String imageUrl)
  {
    this.id = id;
    this.code = code;
    this.name = name;
    this.key = key;
    this.imageUrl = imageUrl;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getCode()
  {
    return code;
  }

  public void setCode(String code)
  {
    this.code = code;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getKey()
  {
    return key;
  }

  public void setKey(String key)
  {
    this.key = key;
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
