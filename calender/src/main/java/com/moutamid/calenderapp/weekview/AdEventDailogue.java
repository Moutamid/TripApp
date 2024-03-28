package com.moutamid.calenderapp.weekview;

import android.app.Activity;
import android.app.Dialog;
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

import com.moutamid.calenderapp.R;
import com.moutamid.calenderapp.database.EventDbHelper;

public class AdEventDailogue extends Dialog {

    public Activity c;
    private EditText addEventEditText;
    private EditText date;
    private ImageView closeIcon, timerIcon, menuIcon;
    private CheckBox allDayCheckbox;
    private EditText descriptionText;
    private TextView saveButton;
    String date_str;
    String eventTime;

    public AdEventDailogue(Activity a, String date, String eventTime) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        this.date_str = date;
        this.eventTime = eventTime;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.add_event);

        // Find views
        addEventEditText = findViewById(R.id.add_event);
        closeIcon = findViewById(R.id.close_icon);
        timerIcon = findViewById(R.id.timer_icon);
        date = findViewById(R.id.date);
        allDayCheckbox = findViewById(R.id.all_day_checkbox);
        descriptionText = findViewById(R.id.description_text);
        saveButton = findViewById(R.id.save_button);
        date.setText(date_str);
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
                String date ="2024-03-28" ; // Get the date value from your EditText
                String time = eventTime; // Get the time value from your EditText
                String description = descriptionText.getText().toString();
                boolean checked = allDayCheckbox.isChecked();
                EventDbHelper dataSource = new EventDbHelper(getContext());
                dataSource.insertEvent(title, date, time, description, checked);
                dismiss();
            }
        });

    }
}
