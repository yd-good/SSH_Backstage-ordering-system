/*
信息:
*/
package foodType.com.service.imp;

import foodType.com.dao.imp.FoodTypeDaoImp;
import foodType.com.entity.FoodType;
import foodType.com.service.FoodTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
@Service("foodTypeService")
public class FoodTypeServiceImp implements FoodTypeService {
    @Resource
    private FoodTypeDaoImp foodTypeDao;
    @Override
    public void save(FoodType entity) {
        foodTypeDao.save(entity);
    }

    @Override
    public void update(FoodType entity) {
       foodTypeDao.update(entity);
    }

    @Override
    public void deleteById(Serializable id) {
      foodTypeDao.deleteById(id);
    }

    @Override
    public List<FoodType> findAll() {
        return foodTypeDao.findAll();
    }

    @Override
    public FoodType findById(Serializable id) {
        return foodTypeDao.findById(id);
    }

    @Override
    public List<FoodType> findByName(String foodName) {
        return foodTypeDao.findByName(foodName);
    }
}
