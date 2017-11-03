package com.group.TotoCare.Adapter;

import android.content.Context;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.group.TotoCare.model.Development;


import java.util.ArrayList;

/**
 * Created by david on 10/29/17
 */

public class FirebaseDevelopmentListAdapter extends FirebaseRecyclerAdapter<Development, FirebaseViewHolder> {
    private DatabaseReference mRef;
    private Context mContext;
    private ChildEventListener mChildEventListener;
    private ArrayList<Development> mDevs = new ArrayList<>();

    public FirebaseDevelopmentListAdapter(Class<Development> modelClass, int modelLayout, Class<FirebaseViewHolder> viewHolderClass,
                                          Query ref, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mContext = context;
        mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mDevs.add(dataSnapshot.getValue(Development.class));
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
    protected void populateViewHolder(final FirebaseViewHolder viewHolder, Development model, int position) {
        viewHolder.bindDevelopment(model);
    }


}
