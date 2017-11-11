package com.group.TotoCare.Adapter;

import android.content.Context;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.group.TotoCare.model.Tests;

import java.util.ArrayList;

/**
 * Created by david on 11/2/17.
 */

public class FirebaseTestsListAdapter extends FirebaseRecyclerAdapter<Tests, FirebaseViewHolder> {
    private DatabaseReference mRef;
    private Context mContext;
    private ChildEventListener mChildEventListener;
    private ArrayList<Tests> mTests = new ArrayList<>();

    public FirebaseTestsListAdapter(Class<Tests> modelClass, int modelLayout, Class<FirebaseViewHolder> viewHolderClass,
                                    Query ref, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mContext = context;
        mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mTests.add(dataSnapshot.getValue(Tests.class));
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
    protected void populateViewHolder(final FirebaseViewHolder viewHolder, Tests model, int position) {
        viewHolder.bindTest(model);
    }


}
