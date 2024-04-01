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

    private RecyclerView recyclerView;
    private ImageView previousButton, nextButton;
    private List<String> dates = new ArrayList<>();
    private Calendar currentDate = Calendar.getInstance();
    TextView dateRangeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week2);

        dateRangeTextView = findViewById(R.id.dateRangeTextView);
        recyclerView = findViewById(R.id.recyclerView);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);

        updateDates(currentDate);

        DateAdapter adapter = new DateAdapter(this, dates);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDate.add(Calendar.DATE, -7);
                updateDates(currentDate);
                adapter.notifyDataSetChanged();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDate.add(Calendar.DATE, 7);
                updateDates(currentDate);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void updateDates(Calendar currentDate) {
        dates.clear();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE d", Locale.getDefault());
        Calendar startDate = (Calendar) currentDate.clone();

        // Set startDate to the current date
        startDate.set(Calendar.HOUR_OF_DAY, 0);
        startDate.set(Calendar.MINUTE, 0);
        startDate.set(Calendar.SECOND, 0);
        startDate.set(Calendar.MILLISECOND, 0);

        for (int i = 0; i < 7; i++) {
            dates.add(sdf.format(startDate.getTime()));
            startDate.add(Calendar.DATE, 1);
        }

        String startDateString = sdf.format(currentDate.getTime());
        currentDate.add(Calendar.DATE, 6);
        String endDateString = sdf.format(currentDate.getTime());
        currentDate.add(Calendar.DATE, -6); // Reset current date
        dateRangeTextView.setText(getMonthName(currentDate.get(Calendar.MONTH)) + " " + startDateString + "-" + endDateString);
    }

    private String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }
}
