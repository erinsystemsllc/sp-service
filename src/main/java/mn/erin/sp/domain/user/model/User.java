package mn.erin.sp.domain.user.model;

import mn.erin.common.domain.stereotype.Entity;

/**
 * @author Byambajav
 */
@Entity
public class User
{
  private final String id;
  private final String displayName;
  private String accountId;
  private String email;

  public User(String id, String name, String accountId, String email)
  {
    this.id = id;
    this.displayName = name;
    this.accountId = accountId;
    this.email = email;
  }

  public String getAccountId()
  {
    return accountId;
  }

  public void setAccountId(String accountId)
  {
    this.accountId = accountId;
  }

  public String getId()
  {
    return id;
  }

  public String getDisplayName()
  {
    return displayName;
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
