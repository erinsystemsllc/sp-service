package mn.erin.sp.domain.user.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Byambajav
 */
@Document
public class MongoUser
{
  @Id
  private final String id;
  private final String displayName;
  private String accountId;
  private String email;

  public MongoUser(String id, String accountId, String displayName,  String email)
  {
    this.id = id;
    this.displayName = displayName;
    this.accountId = accountId;
    this.email = email;
  }

  public String getId()
  {
    return id;
  }

  public String getDisplayName()
  {
    return displayName;
  }

  public String getAccountId()
  {
    return accountId;
  }

  public void setAccountId(String accountId)
  {
    this.accountId = accountId;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }
}
