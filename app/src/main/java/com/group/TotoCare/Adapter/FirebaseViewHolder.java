package com.group.TotoCare.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.group.TotoCare.R;
import com.group.TotoCare.model.Food;
import com.group.TotoCare.model.Tests;

/**
 * Created by david on 10/29/17
 */

public class FirebaseViewHolder extends RecyclerView.ViewHolder {
    View mView;
    Context mContext;

    public FirebaseViewHolder(View itemView) {
        super(itemView);

        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindFood(Food food) {
        TextView nutrient = mView.findViewById(R.id.nutrient);
        TextView description = mView.findViewById(R.id.description);
        TextView foods = mView.findViewById(R.id.foods);

        Typeface myFont=Typeface.createFromAsset(itemView.getContext().getAssets(),"fonts/Raleway-Regular.ttf");
        nutrient.setText(food.getNutrient());
        description.setText(food.getDescription());
        foods.setText(food.getFoods());
        nutrient.setTypeface(myFont);
        description.setTypeface(myFont);
        foods.setTypeface(myFont);
    }



    public void bindTest(Tests tests) {
        TextView test = mView.findViewById(R.id.test);
        TextView description = mView.findViewById(R.id.descriptionTest);
        ImageView image = mView.findViewById(R.id.imageTest);

        Typeface myFont=Typeface.createFromAsset(itemView.getContext().getAssets(),"fonts/Raleway-Regular.ttf");
        test.setTypeface(myFont);
        description.setTypeface(myFont);

        test.setText(tests.getTest());
        description.setText(tests.getDescription());
        Glide.with(mContext)
                .load(tests.getUrl())
                .into(image);
    }
}
