/*
信息:
*/
package foodType.com.entity;

import dishes.com.entity.Dishes;

import java.util.HashSet;
import java.util.Set;

public class FoodType {
        private String id;
        private String foodName;
        private Set<Dishes> dishes=new HashSet<Dishes>();
    public FoodType() {
    }

    @Override
    public String toString() {
        return "FoodType{" +
                "id='" + id + '\'' +
                ", foodName='" + foodName + '\'' +
                ", dishes=" + dishes +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Set<Dishes> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dishes> dishes) {
        this.dishes = dishes;
    }
}
