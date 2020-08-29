/*
信息:
*/
package u.com.dao.imp;

import org.hibernate.Query;
import role.com.entity.Role;
import u.com.dao.UserDao;
import u.com.entity.User;
import u.com.entity.UserRole;
import u.com.entity.UserRoleId;
import yd.com.core.dao.imp.BaseDaoImp;

import java.util.List;

public class UserDaoImp extends BaseDaoImp<User> implements UserDao {
    @Override
    public List<User> findByEmail(String email) {
       Query query=currentSession().createQuery("FROM User where email=?");
       query.setParameter(0,email);
        return query.list();
    }

    @Override
    public User findByEmailAndPassWord(User user) {
        Query query=currentSession().createQuery("FROM User where email=? and passWord=?");
        query.setParameter(0,user.getEmail());
        query.setParameter(1,user.getPassWord());
        return (User) query.uniqueResult();
    }

    @Override
    public void saveUserAndRole(User user, String roleIds) {
        currentSession().save(user);
        currentSession().save(new UserRole(new UserRoleId(new Role(roleIds),user.getId())));

    }

    @Override
    public List<UserRole> findUserRoleAll() {
        Query query=currentSession().createQuery("FROM UserRole");
        return query.list();
    }

}
