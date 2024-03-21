package com.moutimid.sqlapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.moutimid.sqlapp.MainActivity;
import com.moutimid.sqlapp.R;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
public class TourshipActivity extends AppCompatActivity {
    private ImageView imageView;
    private Matrix matrix = new Matrix();
    private float scale = 1f;
    private ScaleGestureDetector scaleGestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourship);

        imageView = findViewById(R.id.image_view);
//        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

    }
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        scaleGestureDetector.onTouchEvent(event);
//        return true;
//    }
//
//    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
//        @Override
//        public boolean onScale(ScaleGestureDetector detector) {
//            scale *= detector.getScaleFactor();
//            scale = Math.max(0.1f, Math.min(scale, 10.0f)); // limit scale factor
//
//            matrix.setScale(scale, scale);
//            imageView.setImageMatrix(matrix);
//            return true;
//        }
//    }

    public void BackPress(View view) {
        onBackPressed();
    }
    public void menu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

        // Optional: Set a listener to respond to menu item clicks
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if ((item.getItemId() == R.id.menu_item_1)) {
                    startActivity(new Intent(TourshipActivity.this, MainActivity.class));
                    finishAffinity();
                }
                return true;
            }
        });

        popupMenu.show();

    }

}