/*
信息:
*/
package dishes.com.service.imp;

import dishes.com.dao.DishesDao;
import dishes.com.entity.Dishes;
import dishes.com.service.DishesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
@Service("dishesService")
public class DishesServiceImp implements DishesService {
    @Resource
     private DishesDao dishesDao;
    @Override
    public void save(Dishes entity) {
          dishesDao.save(entity);
    }

    @Override
    public void update(Dishes entity) {
          dishesDao.update(entity);
    }

    @Override
    public void deleteById(Serializable id) {
    dishesDao.deleteById(id);
    }

    @Override
    public List<Dishes> findAll() {
        return dishesDao.findAll();
    }

    @Override
    public Dishes findById(Serializable id) {
        return dishesDao.findById(id);
    }

    @Override
    public void deleteDishesById(String id) {
        dishesDao.deleteDishesById(id);
    }
}
