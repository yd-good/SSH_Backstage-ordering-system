/*
信息:
*/
package dishes.com.entity;

import foodType.com.entity.FoodType;

public class Dishes {
    private String id;
    private String foodName;
    private double foodPrice;
    private double memberPrice;
    private String introduction;
    private String img;
    private FoodType foodType;

    public Dishes() {
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

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public double getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(double memberPrice) {
        this.memberPrice = memberPrice;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return "Dishes{" +
                "id='" + id + '\'' +
                ", foodName='" + foodName + '\'' +
                ", foodPrice=" + foodPrice +
                ", memberPrice=" + memberPrice +
                ", introduction='" + introduction + '\'' +
                ", img='" + img + '\'' +
                ", foodType=" + foodType +
                '}';
    }
}
