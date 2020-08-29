/*
信息:
*/
package table.com.service.imp;

import org.springframework.stereotype.Service;
import table.com.dao.TableDao;
import table.com.entity.Table;
import table.com.service.TableService;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Service("tableService")
public class TableServiceImp implements TableService {
    @Resource
    private TableDao tableDao;
    @Override
    public void save(Table entity) {
        tableDao.save(entity);
    }

    @Override
    public void update(Table entity) {
        tableDao.update(entity);
    }

    @Override
    public void deleteById(Serializable id) {
         tableDao.deleteById(id);
    }

    @Override
    public List<Table> findAll() {
        return tableDao.findAll();
    }

    @Override
    public Table findById(Serializable id) {
        return tableDao.findById(id);
    }

    @Override
    public void orderById(String id,Date date) {
        tableDao.orderById(id,date);
    }

    @Override
    public void retreatById(String id) {
        tableDao.retreatById(id);
    }

    @Override
    public List<Table> findByName(String tableName) {
        return tableDao.findByName(tableName);
    }
}
