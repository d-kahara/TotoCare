package com.group.TotoCare.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.group.TotoCare.Adapter.FirebaseFoodListAdapter;
import com.group.TotoCare.Adapter.FirebaseFoodViewHolder;
import com.group.TotoCare.R;
import com.group.TotoCare.model.Food;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BabyFragment extends Fragment {
    private FirebaseFoodListAdapter mFirebaseAdapter;

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    // Required empty public constructor
    public BabyFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_baby_fragment, container, false);
        ButterKnife.bind(this, view);
        setUpFirebaseAdapter();
        return view;
    }

    private void setUpFirebaseAdapter() {
        Query query = FirebaseDatabase.getInstance()
                .getReference("nutrition");

        mFirebaseAdapter = new FirebaseFoodListAdapter(Food.class, R.layout.food_list_item, FirebaseFoodViewHolder.class,
                query, getActivity());

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        mRecyclerView.setAdapter(mFirebaseAdapter);


    }

    @Override
    //method is now public
    public void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }


}