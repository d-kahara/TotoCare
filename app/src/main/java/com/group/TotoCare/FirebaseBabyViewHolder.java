package com.group.TotoCare;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.group.TotoCare.model.Development;
import com.group.TotoCare.model.Food;
import com.group.TotoCare.model.Tests;

/**
 * Created by david on 11/2/17.
 */

public class FirebaseBabyViewHolder extends RecyclerView.ViewHolder {
    View mView;
    Context mContext;

    public FirebaseBabyViewHolder(View itemView) {
        super(itemView);

        mView = itemView;
        mContext = itemView.getContext();
    }



//    public void bindDevelopment(Development development) {
//        TextView size = mView.findViewById(R.id.sizeDev);
//        TextView description = mView.findViewById(R.id.descriptionHome);
//        ImageView image = mView.findViewById(R.id.imageHome);
//
//        size.setText(development.getSize());
//        description.setText(development.getDescription());
//        Glide.with(mContext)
//                .load(development.getUrl())
//                .into(image);
//    }


}
