package table.com.service;

import table.com.entity.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public interface TableService {
    void save(Table entity);
    void update(Table entity);
    void deleteById(Serializable id);
    List<Table> findAll();
    Table findById(Serializable id);

    void orderById(String id,Date date);

    void retreatById(String id);

    List<Table> findByName(String tableName);
}
