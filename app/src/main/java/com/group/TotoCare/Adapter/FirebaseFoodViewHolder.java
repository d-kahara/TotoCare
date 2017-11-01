package com.group.TotoCare.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.group.TotoCare.R;
import com.group.TotoCare.model.Food;

/**
 * Created by david on 10/29/17
 */

public class FirebaseFoodViewHolder extends RecyclerView.ViewHolder {
    View mView;
    Context mContext;

    public FirebaseFoodViewHolder(View itemView) {
        super(itemView);

        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindFood(Food food) {
        TextView nutrient = mView.findViewById(R.id.nutrient);
        TextView description = mView.findViewById(R.id.description);
        TextView foods = mView.findViewById(R.id.foods);

        nutrient.setText(food.getNutrient());
        description.setText(food.getDescription());
        foods.setText(food.getFoods());
    }
}
