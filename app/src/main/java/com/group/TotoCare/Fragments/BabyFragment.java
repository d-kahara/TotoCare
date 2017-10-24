package com.group.TotoCare.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.google.firebase.database.ValueEventListener;
import com.group.TotoCare.R;
import com.group.TotoCare.model.Food;

import java.util.ArrayList;

public class BabyFragment extends Fragment{

    private DatabaseReference mDatabase;
    private ArrayList<Food> foodList=new ArrayList<>();
    private ListView mFoodsListView;
    private TextView mFoodView;
    private TextView mNutrientView;




    //Requires an empty constructor
    public BabyFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


//call the layout for the fragment
        View myView=inflater.inflate(R.layout.activity_baby_fragment, container, false);

        mFoodsListView=(ListView) myView.findViewById(R.id.foodsListView);

        mDatabase = FirebaseDatabase.getInstance().getReference("nutrition");
//        mNutrientView=(TextView) getActivity().findViewById(R.id.nutrientView);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data:dataSnapshot.getChildren()){
                    foodList.add(data.getValue(Food.class));
                }

                ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,foodList);
                mFoodsListView.setAdapter(adapter);
            }

            //method fired up in the event of any error
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return myView;
    }

}