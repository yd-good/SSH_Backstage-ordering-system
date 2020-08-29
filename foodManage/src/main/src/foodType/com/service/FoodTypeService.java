package foodType.com.service;

import dishes.com.entity.Dishes;
import foodType.com.entity.FoodType;

import java.io.Serializable;
import java.util.List;

public interface FoodTypeService {
    void save(FoodType entity);
    void update(FoodType entity);
    void deleteById(Serializable id);
    List<FoodType> findAll();
    FoodType findById(Serializable id);

    List<FoodType> findByName(String foodName);
}
