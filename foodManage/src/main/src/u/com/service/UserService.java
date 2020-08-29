/*
信息:
*/
package u.com.service;

import role.com.entity.Role;
import u.com.entity.User;
import u.com.entity.UserRole;

import java.io.Serializable;
import java.util.List;

public interface UserService {
    void save(User entity);
    void update(User entity);
    void deleteById(Serializable id);
    List<User> findAll();
    User findById(Serializable id);

    List<User> findByEmail(String email);

    User findByEmailAndPassWord(User user);

    void saveUserAndRole(User user, String roleIds);

    List<UserRole> findUserRoleAll();
}
