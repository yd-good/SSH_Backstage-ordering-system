/*
信息:
*/
package table.com.dao;

import table.com.entity.Table;
import yd.com.core.dao.BaseDao;

import java.util.Date;
import java.util.List;

public interface TableDao extends BaseDao<Table> {
    void orderById(String id, Date date);

    void retreatById(String id);

    List<Table> findByName(String tableName);
}
