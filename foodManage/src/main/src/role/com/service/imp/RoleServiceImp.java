/*
信息:
*/
package role.com.service.imp;

import org.springframework.stereotype.Service;
import role.com.dao.RoleDao;
import role.com.entity.Role;
import role.com.service.RoleService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service("roleService")
public class RoleServiceImp implements RoleService {
    @Resource
     private RoleDao roleDao;
    @Override
    public void save(Role entity) {
        roleDao.save(entity);
    }

    @Override
    public void update(Role entity) {
          roleDao.update(entity);
    }

    @Override
    public void deleteById(Serializable id) {
       roleDao.deleteById(id);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findById(Serializable id) {
        return roleDao.findById(id);
    }

}
