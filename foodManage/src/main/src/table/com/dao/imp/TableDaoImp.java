/*
信息:
*/
package table.com.dao.imp;

import org.hibernate.Query;
import table.com.dao.TableDao;
import table.com.entity.Table;
import yd.com.core.dao.imp.BaseDaoImp;

import java.util.Date;
import java.util.List;


public class TableDaoImp extends BaseDaoImp<Table> implements TableDao {
    @Override
    public void orderById(String id, Date date) {
      Query query= currentSession().createQuery("update Table set tableStatus=1,date=? where id=?");
       query.setParameter(0,date);
       query.setParameter(1,id);
       query.executeUpdate();
    }

    @Override
    public void retreatById(String id) {
        Query query= currentSession().createQuery("update Table set tableStatus=0,date="+null+" where id=?");
        query.setParameter(0,id);
        query.executeUpdate();
    }

    @Override
    public List<Table> findByName(String tableName) {
        Query query=currentSession().createQuery("FROM Table Where tableName=?");
        query.setParameter(0,tableName);
        return query.list();
    }
}
