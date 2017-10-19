package com.group.TotoCare.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.group.TotoCare.R;
import com.group.TotoCare.model.Baby;

/**
 * Created by david on 10/18/17.
 */

public class FirebaseBabyViewHolder extends RecyclerView.ViewHolder  {



    View mView;
    Context mContext;

    public FirebaseRestaurantViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindRestaurant(Baby baby) {

    }
}
