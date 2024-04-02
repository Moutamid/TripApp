package com.moutamid.calenderapp.week;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.calenderapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class WeekActivity extends AppCompatActivity {

    private RecyclerView recyclerView_week;
    private ImageView previousButton, nextButton;
    private List<String> dates = new ArrayList<>();
    private List<String> search_dates = new ArrayList<>();
    private Calendar currentDate = Calendar.getInstance();
    private TextView dateRangeTextView, range;
    String search_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week2);

        range = findViewById(R.id.range);
        dateRangeTextView = findViewById(R.id.dateRangeTextView);
        recyclerView_week = findViewById(R.id.recyclerView);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);
        updateDates(currentDate);
        DateAdapter adapter = new DateAdapter(this, dates, getDate(currentDate), search_dates);
        recyclerView_week.setAdapter(adapter);
        recyclerView_week.setLayoutManager(new LinearLayoutManager(this));

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDate.add(Calendar.DATE, -7);
                updateDates(currentDate);
                adapter.setCurrentDate(getDate(currentDate));
                adapter.notifyDataSetChanged();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDate.add(Calendar.DATE, 7);
                updateDates(currentDate);
                adapter.setCurrentDate(getDate(currentDate));
                adapter.notifyDataSetChanged();
            }
        });
    }

    private String getDate(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE dd", Locale.getDefault());
        return sdf.format(calendar.getTime());
    }
    private String getSearch_date(Calendar calendar) {
        SimpleDateFormat search_date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return search_date.format(calendar.getTime());
    }

    private void updateDates(Calendar currentDate) {
        dates.clear();
        search_dates.clear();
        SimpleDateFormat search_date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat sdf = new SimpleDateFormat("EEE dd", Locale.getDefault());
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd", Locale.getDefault());
        Calendar startDate = (Calendar) currentDate.clone();

        // Set startDate to the current date
        startDate.set(Calendar.HOUR_OF_DAY, 0);
        startDate.set(Calendar.MINUTE, 0);
        startDate.set(Calendar.SECOND, 0);
        startDate.set(Calendar.MILLISECOND, 0);

        for (int i = 0; i < 7; i++) {
            dates.add(sdf.format(startDate.getTime()));
            search_dates.add(search_date.format(startDate.getTime()));
            startDate.add(Calendar.DATE, 1);
        }

        String startDateString = sdf1.format(currentDate.getTime());
        currentDate.add(Calendar.DATE, 6);
        String endDateString = sdf1.format(currentDate.getTime());
        currentDate.add(Calendar.DATE, -6); // Reset current date
        range.setText(getMonthName(currentDate.get(Calendar.MONTH)) + " " + startDateString + "-" + endDateString);
        dateRangeTextView.setText(getMonthName(currentDate.get(Calendar.MONTH)) + " " + startDateString + "-" + endDateString);
    }

    private String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }
}
