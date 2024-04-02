package com.moutamid.sqlapp.activities.Calender.calenderapp.month;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.sqlapp.R;
import com.moutamid.sqlapp.activities.Calender.calenderapp.MainActivity;

import java.util.List;

public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.DateViewHolder> {

    private Context context;
    private List<String> dates;
    private List<String> search_dates;
    public String currentDate;
    MonthEventAdapter eventAdapter;

    public MonthAdapter(Context context, List<String> dates, String currentDate, List<String> search_dates) {
        this.context = context;
        this.dates = dates;
        this.currentDate = currentDate;
        this.search_dates = search_dates;
    }

    @NonNull
    @Override
    public MonthAdapter.DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_month, parent, false);
        return new MonthAdapter.DateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonthAdapter.DateViewHolder holder, int position) {
        holder.bind(dates.get(position));


        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        eventAdapter = new MonthEventAdapter(context, MainActivity.func_week(context, search_dates.get(position)));
        holder.recyclerView.setAdapter(eventAdapter);
        if(MainActivity.func_week(context, search_dates.get(position)).size()>0)
        {
            holder.main_layout.setBackgroundResource(R.drawable.bg_stroke_current);
        }
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }

    class DateViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RecyclerView recyclerView;
        RelativeLayout main_layout;

        public DateViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            recyclerView = itemView.findViewById(R.id.recyclerView);
            main_layout = itemView.findViewById(R.id.main_layout);
        }

        public void bind(String date) {
//            if (date.isEmpty()) {
//                itemView.setBackgroundColor(Color.parseColor("#EFEFEF"));
//                textView.setText("");
//            } else {
                textView.setText(date);
                // Reset background color
                // Set text color based on whether it's the current date or not
                if (date.equals(currentDate)) {
                    main_layout.setBackgroundResource(R.drawable.bg_stroke_current);
                    textView.setTextColor(Color.parseColor("#ffffff"));
                    textView.setBackgroundColor(Color.parseColor("#5C79FF"));

                } else {
                    main_layout.setBackgroundResource(R.drawable.bg_stroke);

                    textView.setTextColor(Color.parseColor("#000000"));
//                }
            }
        }

    }


    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
}
