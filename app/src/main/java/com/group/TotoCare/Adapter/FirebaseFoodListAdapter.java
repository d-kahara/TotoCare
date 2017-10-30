package com.group.TotoCare.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.group.TotoCare.model.Food;

import java.util.ArrayList;

/**
 * Created by david on 10/29/17.
 */

public class FirebaseFoodListAdapter extends FirebaseRecyclerAdapter<Food, FirebaseFoodViewHolder> {
    private DatabaseReference mRef;
    private Context mContext;
    private ChildEventListener mChildEventListener;
    private ArrayList<Food> mFoods = new ArrayList<>();

    public FirebaseFoodListAdapter(Class<Food> modelClass, int modelLayout, Class<FirebaseFoodViewHolder> viewHolderClass,
                                   Query ref, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mContext = context;
        mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mFoods.add(dataSnapshot.getValue(Food.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void populateViewHolder(final FirebaseFoodViewHolder viewHolder, Food model, int position) {
        viewHolder.bindFood(model);
    }


}
