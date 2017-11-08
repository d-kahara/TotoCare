package com.group.TotoCare.Fragments;

import android.content.Intent;
import android.graphics.Typeface;
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
    @Bind(R.id.cardView8) Button mCard8;
    @Bind(R.id.cardView12) Button mCard12;
    @Bind(R.id.cardView16) Button mCard16;
    @Bind(R.id.cardView20) Button mCard20;
    @Bind(R.id.cardView24) Button mCard24;
    @Bind(R.id.cardView32) Button mCard32;
    @Bind(R.id.cardView36) Button mCard36;
    @Bind(R.id.cardView40) Button mCard40;




    // Required empty public constructor
    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_fragment, container, false);
        ButterKnife.bind(this, view);
        Typeface myfont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Raleway-Regular.ttf");
        mCard4.setTypeface(myfont);
        mCard8.setTypeface(myfont);
        mCard12.setTypeface(myfont);
        mCard16.setTypeface(myfont);
        mCard20.setTypeface(myfont);
        mCard24.setTypeface(myfont);
        mCard32.setTypeface(myfont);
        mCard36.setTypeface(myfont);
        mCard40.setTypeface(myfont);



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
