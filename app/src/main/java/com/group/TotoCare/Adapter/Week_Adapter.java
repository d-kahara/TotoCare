package com.group.TotoCare.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.group.TotoCare.R;
import com.group.TotoCare.model.Weeks;

import java.util.ArrayList;

/**
 * Created by rahmak on 10/23/17
 */

public class Week_Adapter extends RecyclerView.Adapter<Week_Adapter.ViewHolder> {
    Context context;
    ArrayList<Weeks> weeksArrayList = new ArrayList<>();

    public Week_Adapter(Context context, ArrayList<Weeks> weeksArrayList) {
        this.context = context;
        this.weeksArrayList = weeksArrayList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.baby_week_progress, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindWeek(weeksArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return weeksArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Context context;
        TextView textView_week;
        public ViewHolder(View itemView) {
            super(itemView);
            textView_week = itemView.findViewById(R.id.textView_week);
            context = itemView.getContext();
        }

        public void bindWeek(final Weeks weeks){
            textView_week.setText(weeks.getWeek_day());
        }
    }
}
