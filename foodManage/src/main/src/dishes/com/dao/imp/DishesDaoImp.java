/*
信息:
*/
package dishes.com.dao.imp;

import dishes.com.dao.DishesDao;
import dishes.com.entity.Dishes;
import org.hibernate.Query;
import yd.com.core.dao.imp.BaseDaoImp;

public class DishesDaoImp extends BaseDaoImp<Dishes> implements DishesDao {

    @Override
    public void deleteDishesById(String id) {
        Query query=currentSession().createQuery("DELETE FROM Dishes  WHERE id=?");
        query.setParameter(0,id);
        query.executeUpdate();
    }
}
