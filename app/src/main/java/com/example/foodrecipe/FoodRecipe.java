package com.example.foodrecipe;

import java.util.ArrayList;

public class FoodRecipe {
    private String title;
    private String briefDescription;
    private ArrayList<String> ingredients;
    private String procedure;
    private int image;

    public FoodRecipe(String title, String briefDescription, ArrayList<String> ingredients, String procedure, int image) {
        this.title = title;
        this.briefDescription = briefDescription;
        this.ingredients = ingredients;
        this.procedure = procedure;
        this.image = image;
    }

    public String getIngredients() {
        StringBuilder ingredients = new StringBuilder();

        for (String ingredient :
                this.ingredients) {
            ingredients.append(ingredient);
            ingredients.append("\n");
        }

        return ingredients.toString();
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public String getProcedure() {
        return this.procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }
}
