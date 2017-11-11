package com.group.TotoCare.Adapter;

/**
 * Created by david on 11/7/17.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.group.TotoCare.R;
import com.group.TotoCare.User_Interface.RecipeDetailActivity;
import com.group.TotoCare.model.Recipe;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by carol on 9/15/17.
 */
//class extends the recyclerviewadapter class
public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    private ArrayList<Recipe> mRecipes=new ArrayList<>();//required to calculate the recipe counts so
    //the recycler is aware how many individual list item views it needs to recycle
    private Context mContext;//required to create viewholder


    public RecipeListAdapter(Context context, ArrayList<Recipe> recipes){
        mContext=context;
        mRecipes=recipes;
    }
//create the methods required by the RecycleViewAdapter

    @Override
    //method creates the ViewHolder object required from the adapter and inflates the layout
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item, parent, false);
        RecipeViewHolder viewHolder = new RecipeViewHolder(view);
        return viewHolder;
    }

    @Override
    //updates the contents of the itemView to represent a recipe at a given position
    public void onBindViewHolder(RecipeListAdapter.RecipeViewHolder holder, int position) {
        holder.bindRecipe(mRecipes.get(position));
    }

    @Override
    //sets the number of items the adapter will display
    public int getItemCount() {
        return mRecipes.size();
    }
    //create a nested class which is our view holder
    public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @Bind(R.id.recipeNameTextView)
        TextView mNameTextView;

        @Bind(R.id.recipeImageView)
        ImageView mRecipeImageView;
        @Bind(R.id.prepTimeTextView) TextView mPrepTimeTextView;
        // @Bind(R.id.ingredientsTextView) TextView mIngredientsTextView;

        private Context mContext;

        public RecipeViewHolder(View itemView){


            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext=itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, RecipeDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("recipes", Parcels.wrap(mRecipes));
            mContext.startActivity(intent);
        }

        public void bindRecipe(Recipe recipe){

            //allow picasso to handle the image loading
            Glide.with(mContext).load(recipe.getImageUrl()).into(mRecipeImageView);

            mNameTextView.setText(recipe.getRecipeName());
            mPrepTimeTextView.setText("Prep Time:"+recipe.getPrepTime() + "Mins");
            Typeface myFont=Typeface.createFromAsset(itemView.getContext().getAssets(),"fonts/Raleway-Regular.ttf");
            mNameTextView.setTypeface(myFont);
            mPrepTimeTextView.setTypeface(myFont);
        }
    }












}