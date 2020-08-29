package foodType.com.dao;

import foodType.com.entity.FoodType;
import yd.com.core.dao.BaseDao;

import java.util.List;

public interface FoodTypeDao extends BaseDao<FoodType> {
    public List<FoodType> findByName(String foodName);
}
