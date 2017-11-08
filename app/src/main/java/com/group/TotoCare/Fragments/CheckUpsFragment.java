package com.group.TotoCare.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.group.TotoCare.Adapter.FirebaseDevelopmentListAdapter;
import com.group.TotoCare.Adapter.FirebaseTestsListAdapter;
import com.group.TotoCare.Adapter.FirebaseViewHolder;
import com.group.TotoCare.R;
import com.group.TotoCare.model.Development;
import com.group.TotoCare.model.Tests;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CheckUpsFragment extends Fragment {
    private FirebaseTestsListAdapter mFirebaseAdapter;
    @Bind(R.id.recyclerViewCheckUps)
    RecyclerView mRecyclerView;



    // Required empty public constructor
    public CheckUpsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_check_ups_fragment, container, false);
        ButterKnife.bind(this, view);
        setUpFirebaseAdapter();
        return view;
    }

    private void setUpFirebaseAdapter() {
        Query query = FirebaseDatabase.getInstance()
                .getReference("tests");

        mFirebaseAdapter = new FirebaseTestsListAdapter(Tests.class, R.layout.test_list_item, FirebaseViewHolder.class,
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
