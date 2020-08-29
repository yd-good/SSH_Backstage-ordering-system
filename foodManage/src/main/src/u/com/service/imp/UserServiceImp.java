/*
信息:
*/
package u.com.service.imp;

import org.springframework.stereotype.Service;
import role.com.entity.Role;
import u.com.dao.UserDao;
import u.com.entity.User;
import u.com.entity.UserRole;
import u.com.service.UserService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
@Service("userService")
public class UserServiceImp implements UserService {
    @Resource
     private UserDao userDao;
    @Override
    public void save(User entity) {
        userDao.save(entity);
    }

    @Override
    public void update(User entity) {
          userDao.update(entity);
    }

    @Override
    public void deleteById(Serializable id) {
       userDao.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Serializable id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User findByEmailAndPassWord(User user) {
        return userDao.findByEmailAndPassWord(user);
    }

    @Override
    public void saveUserAndRole(User user, String roleIds) {
        userDao.saveUserAndRole(user,roleIds);
    }

    @Override
    public List<UserRole> findUserRoleAll() {
        return userDao.findUserRoleAll();
    }


}
