package com.group.TotoCare.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.group.TotoCare.model.Baby;

/**
 * Created by david on 10/29/17.
 */

public class FirebaseBabyViewHolder extends RecyclerView.ViewHolder {
    View mView;
    Context mContext;

    public FirebaseBabyViewHolder(View itemView) {
        super(itemView);

        mView = itemView;
        mContext = itemView.getContext();
    }

//    public void bindBaby(Baby baby) {
//        TextView week
//    }
}
