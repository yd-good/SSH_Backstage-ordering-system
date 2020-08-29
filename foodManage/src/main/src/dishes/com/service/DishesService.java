package dishes.com.service;

import dishes.com.entity.Dishes;
import table.com.entity.Table;

import java.io.Serializable;
import java.util.List;

public interface DishesService {
    void save(Dishes entity);
    void update(Dishes entity);
    void deleteById(Serializable id);
    List<Dishes> findAll();
    Dishes findById(Serializable id);

    void deleteDishesById(String id);
}
