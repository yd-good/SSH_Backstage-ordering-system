/*
信息:
*/
package foodType.com.dao.imp;

import foodType.com.dao.FoodTypeDao;
import foodType.com.entity.FoodType;
import org.hibernate.Query;
import yd.com.core.dao.imp.BaseDaoImp;

import java.util.List;

public class FoodTypeDaoImp extends BaseDaoImp<FoodType> implements FoodTypeDao {

    @Override
    public List<FoodType> findByName(String foodName) {
        Query query=currentSession().createQuery("FROM FoodType where foodName=?");
        query.setParameter(0,foodName);
        return query.list();
    }
}
