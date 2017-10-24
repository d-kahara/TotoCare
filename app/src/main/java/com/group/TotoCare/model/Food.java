package com.group.TotoCare.model;

/**
 * Created by david on 10/24/17.
 */

public class Food {
    private String nutrient;
    private String foods;
    private String description;
    //create empty constructor
    public Food(){

    }
    public Food(String nutrient, String foods, String description){
        this.nutrient=nutrient;
        this.foods=foods;
        this.description=description;
    }


    public String getNutrient(){
        return nutrient;
    }
    public String getDescription(){
        return description;
    }
    public String getFoods(){
        return foods;
    }
}
