package com.moutamid.calenderapp.week;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.calenderapp.MainActivity;
import com.moutamid.calenderapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateViewHolder> {

    private Context context;
    private List<String> dates;
    private List<String> search_dates;
    public String currentDate;
    EventAdapter eventAdapter;

    public DateAdapter(Context context, List<String> dates, String currentDate, List<String> search_dates) {
        this.context = context;
        this.dates = dates;
        this.currentDate = currentDate;
        this.search_dates = search_dates;
    }

    @NonNull
    @Override
    public DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_week, parent, false);
        return new DateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DateViewHolder holder, int position) {
        holder.bind(dates.get(position));


       holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        eventAdapter = new EventAdapter(context, MainActivity.func_week(context, search_dates.get(position)));
        holder.recyclerView.setAdapter(eventAdapter);
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }

    class DateViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        View dateView;
        RecyclerView recyclerView;

        public DateViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            dateView = itemView.findViewById(R.id.dateView);
            recyclerView = itemView.findViewById(R.id.recyclerView);
        }

        public void bind(String date) {
            String[] parts = date.split(" ");
            String dayOfWeek = parts[0];
            String dayOfMonth = parts[1];
            SpannableStringBuilder builder = new SpannableStringBuilder(dayOfWeek + "\n" + dayOfMonth);
            builder.setSpan(new AbsoluteSizeSpan(10, true), 0, dayOfWeek.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            builder.setSpan(new AbsoluteSizeSpan(13, true), dayOfWeek.length() + 1, builder.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            textView.setText(builder);
            if (date.equals(currentDate))
            {
                dateView.setVisibility(View.VISIBLE);
                textView.setTextColor(Color.parseColor("#5C79FF"));
            } else {
                dateView.setVisibility(View.GONE);
                textView.setTextColor(Color.parseColor("#000000"));

            }


        }
    }


    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
}