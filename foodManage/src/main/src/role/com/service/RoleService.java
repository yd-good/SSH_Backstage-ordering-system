/*
信息:
*/
package role.com.service;

import role.com.entity.Role;
import u.com.entity.User;

import java.io.Serializable;
import java.util.List;

public interface RoleService {
    void save(Role entity);
    void update(Role entity);
    void deleteById(Serializable id);
    List<Role> findAll();
    Role findById(Serializable id);
}
