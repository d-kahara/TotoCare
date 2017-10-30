package com.group.TotoCare.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.group.TotoCare.Adapter.Week_Adapter;
import com.group.TotoCare.R;
import com.group.TotoCare.model.Weeks;

import java.util.ArrayList;

public class BabyFragment extends Fragment{
    private RecyclerView recyclerView;
    private Week_Adapter week_adapter;
    private FirebaseHelper firebaseHelper;
    private Context context = getContext();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_baby_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerview_baby);
        week_adapter = new Week_Adapter(context, firebaseHelper.retrieve());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(week_adapter);
        return view;
    }

    public class FirebaseHelper {
        private ArrayList<Weeks> weeksArrayList = new ArrayList<>();
        private DatabaseReference databaseReference;

        public FirebaseHelper(DatabaseReference databaseReference) {
            this.databaseReference = databaseReference;
        }

        private void fetchData(DataSnapshot dataSnapshot) {
            weeksArrayList.clear();
            for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                Weeks weeks = dataSnapshot1.getValue(Weeks.class);
                weeksArrayList.add(weeks);
            }
        }

        public ArrayList<Weeks> retrieve() {
            databaseReference = FirebaseDatabase.getInstance().getReference().child("pregnancy");
            databaseReference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    fetchData(dataSnapshot);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    fetchData(dataSnapshot);
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
            return weeksArrayList;
        }
    }
}
