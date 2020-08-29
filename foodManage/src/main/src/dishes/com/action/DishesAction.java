/*
信息:
*/
package dishes.com.action;

import com.opensymphony.xwork2.ActionSupport;
import dishes.com.entity.Dishes;
import dishes.com.service.DishesService;
import foodType.com.entity.FoodType;
import foodType.com.service.FoodTypeService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;
import yd.com.core.action.CoreAction;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class DishesAction extends CoreAction {
    @Resource()
    private DishesService dishesService;
    @Resource
    private FoodTypeService foodTypeService;
    private List<FoodType> foodTypes;
    private FoodType foodType;
    private Dishes dishes;
    private List<Dishes> dishesList;
   public String allFoodList(){
        dishesList=dishesService.findAll();
        return "allFoodList";
   }
   public String saveFoodPage(){
       foodTypes=foodTypeService.findAll();

       return "saveFoodPage";
   }
   public String saveFood(){
       if (StringUtils.isNotBlank(dishes.getFoodName())){
           foodType=foodTypeService.findById(foodType.getId());
           if(headImg!=null){
               process_pictures(dishes);
           }
           dishes.setFoodType(foodType);
           dishesService.save(dishes);
       }
       return allFoodList();
   }
  public String showUpFood(){
       if (StringUtils.isNotBlank(dishes.getId())){
           dishes=dishesService.findById(dishes.getId());
           foodTypes=foodTypeService.findAll();
       }
       return "showUpFood";
  }
  public String deleteDishes(){
       if (StringUtils.isNotBlank(dishes.getId())){
           dishes=dishesService.findById(dishes.getId());
           dishes.getFoodType().getDishes().remove(dishes);
           dishesService.deleteDishesById(dishes.getId());
       }
      return allFoodList();
  }

    public File getHeadImg() {
        return headImg;
    }

    public void setHeadImg(File headImg) {
        this.headImg = headImg;
    }

    public String getHeadImgContentType() {
        return headImgContentType;
    }

    public void setHeadImgContentType(String headImgContentType) {
        this.headImgContentType = headImgContentType;
    }

    public String getHeadImgFileName() {
        return headImgFileName;
    }

    public void setHeadImgFileName(String headImgFileName) {
        this.headImgFileName = headImgFileName;
    }

    public List<Dishes> getDishesList() {
        return dishesList;
    }

    public void setDishesList(List<Dishes> dishesList) {
        this.dishesList = dishesList;
    }

    public FoodTypeService getFoodTypeService() {
        return foodTypeService;
    }

    public void setFoodTypeService(FoodTypeService foodTypeService) {
        this.foodTypeService = foodTypeService;
    }

    public List<FoodType> getFoodTypes() {
        return foodTypes;
    }

    public void setFoodTypes(List<FoodType> foodTypes) {
        this.foodTypes = foodTypes;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public DishesService getDishesService() {
        return dishesService;
    }

    public void setDishesService(DishesService dishesService) {
        this.dishesService = dishesService;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }
}
