package mn.erin.sp.domain.user.repository;

import mn.erin.sp.domain.user.model.User;

/**
 * @author Byambajav
 */
public interface UserRepository
{
  User findUserById(String id);
  String create(String accountId, String displayName, String email);

}
