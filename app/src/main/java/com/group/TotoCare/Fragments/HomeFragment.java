package com.group.TotoCare.Fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.group.TotoCare.Adapter.FirebaseDevelopmentListAdapter;
import com.group.TotoCare.Adapter.FirebaseViewHolder;
import com.group.TotoCare.R;
import com.group.TotoCare.User_Interface.week4Activity;
import com.group.TotoCare.model.Development;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends Fragment implements View.OnClickListener{
    private FirebaseDevelopmentListAdapter mFirebaseAdapter;
   @Bind(R.id.cardView) Button mCard4;




    // Required empty public constructor
    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_fragment, container, false);
        ButterKnife.bind(this, view);
        mCard4.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mCard4 ) {
            Intent intent = new Intent(getActivity(), week4Activity.class);
            startActivity(intent);

        }

    }


}
