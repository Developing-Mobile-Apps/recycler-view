package com.example.foodrecipe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class FoodRecipeListAdapter extends RecyclerView.Adapter<FoodRecipeListAdapter.FoodRecipeViewHolder> {

    private final LinkedList<FoodRecipe> foodRecipeList;
    private LayoutInflater layoutInflater;
    private Context context;

    public FoodRecipeListAdapter(Context context, LinkedList<FoodRecipe> foodRecipeList) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.foodRecipeList = foodRecipeList;
    }

    @NonNull
    @Override
    public FoodRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View foodRecipe = layoutInflater.inflate(R.layout.food_recipe, parent, false);

        return new FoodRecipeViewHolder(context, foodRecipe, this, foodRecipeList);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodRecipeViewHolder holder, int position) {
        FoodRecipe currentFoodRecipe = foodRecipeList.get(position);
        TextView foodRecipeTitle = holder.foodRecipeItemView.findViewById(R.id.food_recipe_item_title);
        TextView foodRecipeContent = holder.foodRecipeItemView.findViewById(R.id.food_recipe_item_content);

        foodRecipeTitle.setText(currentFoodRecipe.getTitle());
        foodRecipeContent.setText(currentFoodRecipe.getBriefDescription());
    }

    @Override
    public int getItemCount() {
        return foodRecipeList.size();
    }

    class FoodRecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final View foodRecipeItemView;
        final FoodRecipeListAdapter foodRecipeListAdapter;
        final Context context;
        final LinkedList<FoodRecipe> foodRecipeList;

        public FoodRecipeViewHolder(Context context, View view, FoodRecipeListAdapter adapter, LinkedList<FoodRecipe> foodRecipeList) {
            super(view);
            this.context = context;
            foodRecipeItemView = view;
            foodRecipeListAdapter = adapter;
            foodRecipeItemView.setOnClickListener(this);
            this.foodRecipeList = foodRecipeList;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, FoodRecipeDetail.class);
            // get the position of the item that was clicked
            int foodRecipePosition = getLayoutPosition();
            // get the foodRecipe
            FoodRecipe foodRecipe = foodRecipeList.get(foodRecipePosition);

            // send the data with the intent
            intent.putExtra("ingredients", foodRecipe.getIngredients());
            intent.putExtra("procedure", foodRecipe.getProcedure());
            intent.putExtra("image", foodRecipe.getImage());

            // navigate to another activity
            context.startActivity(intent);
        }
    }
}
