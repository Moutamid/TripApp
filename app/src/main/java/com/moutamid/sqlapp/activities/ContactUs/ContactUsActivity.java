package com.moutamid.sqlapp.activities.ContactUs;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.fxn.stash.Stash;
import com.google.android.material.textfield.TextInputLayout;
import com.moutamid.sqlapp.R;
import com.moutamid.sqlapp.activities.DashboardActivity;
import com.moutamid.sqlapp.activities.NetworkTask;
import com.moutamid.sqlapp.activities.Organizer.Model.EditedText;
import com.moutamid.sqlapp.activities.Organizer.Model.ImageData;
import com.moutamid.sqlapp.activities.Organizer.SendActivity;
import com.moutamid.sqlapp.activities.Organizer.helper.DatabaseContract;
import com.moutamid.sqlapp.activities.Organizer.helper.DatabaseHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ContactUsActivity extends AppCompatActivity {
    EditText first_name, last_name, email, message;
    TextView name_txt, last_name_txt, email_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        first_name = findViewById(R.id.first_name);
        name_txt = findViewById(R.id.name_txt);
        last_name = findViewById(R.id.last_name);
        last_name_txt = findViewById(R.id.last_name_txt);
        email = findViewById(R.id.email);
        email_txt = findViewById(R.id.email_txt);
        message = findViewById(R.id.message);
        applyStylesToTextInputLayoutHint(first_name, name_txt, "First Name*");
        applyStylesToTextInputLayoutHint(last_name, last_name_txt, "Last Name*");
        applyStylesToTextInputLayoutHint(email, email_txt, "E-mail*");
        applyStylesToTextInputLayoutHint1(message, "Message");

    }

    public void BackPress(View view) {
        onBackPressed();
    }


    private void applyStylesToTextInputLayoutHint(EditText editText, TextView textView, String hint) {
        TextInputLayout textInputLayout = (TextInputLayout) editText.getParent().getParent();
        SpannableString spannableString = new SpannableString(hint);
        spannableString.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), 0, hint.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textInputLayout.setHint(spannableString);
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (editText.getText().toString().length() != 0) {
                    textView.setVisibility(View.INVISIBLE);
                } else {
                    textView.setVisibility(View.VISIBLE);

                }
                return false;
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() < 1) {
                    if (!editText.isFocused()) {
                        textView.setVisibility(View.INVISIBLE);
                    } else {
                        textView.setVisibility(View.VISIBLE);
                    }
                } else {
                    textView.setVisibility(View.INVISIBLE);
                }
            }
        });

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // The EditText gained focus
                    if (editText.getText().toString().length() != 0) {
                        textView.setVisibility(View.INVISIBLE);
                    } else {
                        textView.setVisibility(View.VISIBLE);

                    }
                } else {
                    textView.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
 private void applyStylesToTextInputLayoutHint1(EditText editText, String hint) {
        TextInputLayout textInputLayout = (TextInputLayout) editText.getParent().getParent();
        SpannableString spannableString = new SpannableString(hint);
        spannableString.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), 0, hint.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textInputLayout.setHint(spannableString);



    }

    public void send(View view) {
        if (first_name.getText().toString().length() == 0 && last_name.getText().toString().length() == 0 && email.getText().toString().length() == 0 && message.getText().toString().length() == 0) {
            ErrorDialog cdd = new ErrorDialog(ContactUsActivity.this);
            cdd.show();
        } else {
            Stash.put("email_first_name", first_name.getText().toString());
            Stash.put("email_last_name", last_name.getText().toString());
            Stash.put("email_address", email.getText().toString());
            Stash.put("email_message", message.getText().toString());
            SendNetworkTask networkTask = new SendNetworkTask(ContactUsActivity.this);
            networkTask.execute();
        }
    }
}