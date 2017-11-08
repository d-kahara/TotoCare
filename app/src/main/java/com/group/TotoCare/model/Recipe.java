package com.group.TotoCare.model;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 11/1/17.
 */
@Parcel
public class Recipe {
    String recipeName;

    List <String> ingredients = new ArrayList<>();
    double rating;
    String imageUrl;
    int prepTime;
    String webUrl;

    //empty constructor required
    public Recipe() {}

    public Recipe(String recipeName, ArrayList<String> ingredients, double rating, String imageUrl, int prepTime) {
        this.recipeName = recipeName;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.ingredients = ingredients;
        this.prepTime=prepTime;

    }

    //getter methods
    public String getRecipeName() {
        return recipeName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public double getRating() {
        return rating;
    }
    public int getPrepTime(){
        return prepTime/60;
    }

}
