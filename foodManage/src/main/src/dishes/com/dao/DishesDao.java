package dishes.com.dao;

import dishes.com.entity.Dishes;
import yd.com.core.dao.BaseDao;

public interface DishesDao extends BaseDao<Dishes> {
    void deleteDishesById(String id);
}
