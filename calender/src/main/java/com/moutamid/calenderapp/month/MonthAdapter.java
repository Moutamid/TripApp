package com.moutamid.calenderapp.month;


import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.calenderapp.MainActivity;
import com.moutamid.calenderapp.R;
import com.moutamid.calenderapp.week.EventAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MonthAdapter extends RecyclerView.Adapter<com.moutamid.calenderapp.month.MonthAdapter.DateViewHolder> {

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
    public com.moutamid.calenderapp.month.MonthAdapter.DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_month, parent, false);
        return new com.moutamid.calenderapp.month.MonthAdapter.DateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.moutamid.calenderapp.month.MonthAdapter.DateViewHolder holder, int position) {
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
