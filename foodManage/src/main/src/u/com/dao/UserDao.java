package u.com.dao;

import role.com.entity.Role;
import u.com.entity.User;
import u.com.entity.UserRole;
import yd.com.core.dao.BaseDao;

import java.util.List;

public interface UserDao extends BaseDao<User> {

    List<User> findByEmail(String email);

    User findByEmailAndPassWord(User user);

    void saveUserAndRole(User user, String roleIds);

    List<UserRole> findUserRoleAll();
}
