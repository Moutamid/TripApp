package com.moutamid.sqlapp.activities.Calender.calenderapp.weekview;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.moutamid.sqlapp.R;
import com.moutamid.sqlapp.activities.Calender.calenderapp.MainActivity;
import com.moutamid.sqlapp.activities.Calender.calenderapp.database.EventDbHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EditEventDailogue extends Dialog {

    public Context c;
    private EditText addEventEditText;
    private EditText date_edit;
    private ImageView closeIcon, delete_icon,  timerIcon, menuIcon;
    private CheckBox allDayCheckbox;
    private EditText descriptionText;
    private TextView saveButton;
    String date_str;
    String eventTime;

    public long id;
    public String title_value;
    public String date_value;
    public String time_value;
    public String description_value;
    public boolean checked_value;
    public EditEventDailogue(Context a, long id, String title, String time, String description, boolean checked, String date) {
        super(a);
        // Initialize fields with provided parameters
        this.id = id;
        this.title_value = title;
        this.time_value = time;
        this.description_value = description;
        this.checked_value = checked;
        this.date_value = date;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.edit_add_event);
        // Find views
        addEventEditText = findViewById(R.id.add_event);
        closeIcon = findViewById(R.id.close_icon);
        delete_icon = findViewById(R.id.delete_icon);
        timerIcon = findViewById(R.id.timer_icon);
        date_edit = findViewById(R.id.date);
        allDayCheckbox = findViewById(R.id.all_day_checkbox);
        descriptionText = findViewById(R.id.description_text);
        saveButton = findViewById(R.id.save_button);

        addEventEditText.setText(title_value);
        descriptionText.setText(description_value);
        String dateStr = date_value;
        String timeStr = time_value;

        // Format date
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("MMMM, dd, yyyy", Locale.getDefault());
        String formattedDate = "";
        try {
            Date date = inputDateFormat.parse(dateStr);
            formattedDate = outputDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Format time
        SimpleDateFormat inputTimeFormat = new SimpleDateFormat("HH-mm", Locale.getDefault());
        SimpleDateFormat outputTimeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String formattedTime = "";
        try {
            Date time = inputTimeFormat.parse(timeStr);
            formattedTime = outputTimeFormat.format(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        delete_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventDbHelper dataSource = new EventDbHelper(getContext());
                dataSource.deleteEvent(id);
//                MainActivity.activity.startActivity(new Intent(MainActivity.activity, MainActivity.class));
                dismiss();

            }
        });
        date_edit.setText(formattedDate+" "+formattedTime);
        allDayCheckbox.setChecked(checked_value);
        addEventEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString().trim();
                if (input.length() > 15) {
                    addEventEditText.setError("Character limit is 15");
                    saveButton.setEnabled(false);
                } else {
                    addEventEditText.setError(null); // Remove the error
                    saveButton.setEnabled(true);
                }
            }
        });
        closeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(); // Dismiss the dialog
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = addEventEditText.getText().toString();
                String date =date_value ; // Get the date value from your EditText
                String time = timeStr; // Get the time value from your EditText
                String description = descriptionText.getText().toString();
                boolean checked = allDayCheckbox.isChecked();
                EventDbHelper dataSource = new EventDbHelper(getContext());
                dataSource.updateEvent(id, title, date, time, description, checked);
//                MainActivity.activity.startActivity(new Intent(MainActivity.activity, MainActivity.class));
                dismiss();
            }
        });

    }
}
