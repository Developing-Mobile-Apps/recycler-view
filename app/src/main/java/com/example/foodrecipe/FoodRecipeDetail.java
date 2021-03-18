package com.example.foodrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FoodRecipeDetail extends AppCompatActivity {

    private ImageView finishedDish;
    private TextView foodRecipeIngredients;
    private TextView foodRecipeProcedure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_recipe_detail);

        // get the view from the layout
        finishedDish = findViewById(R.id.finished_dish);
        foodRecipeIngredients = findViewById(R.id.food_recipe_ingredients);
        foodRecipeProcedure = findViewById(R.id.food_recipe_procedure);

        // get the intent that started this activity
        Intent intent = getIntent();

        // get the data from the intent
        String ingredients = intent.getStringExtra("ingredients");
        String procedure = intent.getStringExtra("procedure");
        int imageId = intent.getIntExtra("image", 0);

        // set data to the view
        foodRecipeIngredients.setText(ingredients);
        foodRecipeProcedure.setText(procedure);
        finishedDish.setImageResource(imageId);
    }
}