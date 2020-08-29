/*
信息:
*/
package foodType.com.action;

import com.opensymphony.xwork2.ActionContext;
import dishes.com.entity.Dishes;
import dishes.com.service.DishesService;
import foodType.com.entity.FoodType;
import foodType.com.service.FoodTypeService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import yd.com.core.action.CoreAction;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FoodTypeAction extends CoreAction {
     @Resource
     private FoodTypeService foodTypeService;
     @Resource
     private DishesService dishesService;
     private List<FoodType> foodTypes;
     private Dishes dishes;
     private FoodType foodType;
     private List<Dishes> dishesList;
     private String foodTypeId;
//    进入当前页面
    public String list(){
       foodTypes=foodTypeService.findAll();
       return "list";
     }
    public String updatePage(){
       foodType=foodTypeService.findById(foodType.getId());
        return "updateCuisine";
    }
    public String update(){
        foodTypeService.update(foodType);
        return list();
    }
    public String delete(){
       foodTypeService.deleteById(foodType.getId());
        return list();
    }
//    显示当前菜系下的菜品
    public String showDishes(){
      foodType=foodTypeService.findById(foodType.getId());
      if (foodType.getDishes().size()>0){
          dishesList=new ArrayList<Dishes>();
          for (Dishes dishes:foodType.getDishes()){
              dishesList.add(dishes);
          }
      }
        return "dishesList";
    }
//    保存菜系
    public String saveFoodType(){
       if (StringUtils.isNotBlank(foodType.getFoodName())){
           if (StringUtils.isNotBlank(dishes.getFoodName())){
               if (headImg!=null) {
                   process_pictures(dishes);
               }
               foodType.getDishes().add(dishes);
           }
           foodTypeService.save(foodType);
       }

        return list();
    }
//    进入修改菜品页面
    public String showUpFood(){
        foodTypes=foodTypeService.findAll();
        dishes=dishesService.findById(dishes.getId());
        return "showUpFood";
    }
    public String updateDishes(){
        if (StringUtils.isNotBlank(dishes.getFoodName())){
            if (headImg!=null){
                process_pictures(dishes);
            }
            foodType=foodTypeService.findById(foodType.getId());
            dishes.setFoodType(foodType);
            dishesService.update(dishes);
        }
        return showDishes();
    }
    //删除菜品
    public String deleteDishes(){
        if (StringUtils.isNotBlank(dishes.getId())) {
            foodType=dishesService.findById(dishes.getId()).getFoodType();
            dishesService.deleteDishesById(dishes.getId());
        }
        return showDishes();
    }

    //    唯一名字校验
    public void uniqueName() {
       if (foodType!=null&&StringUtils.isNotBlank(foodType.getFoodName())){
           foodTypes=foodTypeService.findByName(foodType.getFoodName());
           HttpServletResponse response= ServletActionContext.getResponse();
           response.setContentType("text/html");
           try {
              ServletOutputStream outputStream = response.getOutputStream();
              String reInfo="true";
               if (foodTypes.size()>0&&foodTypes!=null){
                   reInfo="false";
               }
               outputStream.write(reInfo.getBytes());
               outputStream.close();
           } catch (Exception e) {
             throw new RuntimeException(e);
           }

       }

    }

    public String getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(String foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
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

    public DishesService getDishesService() {
        return dishesService;
    }

    public void setDishesService(DishesService dishesService) {
        this.dishesService = dishesService;
    }
}
