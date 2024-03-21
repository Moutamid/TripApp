package com.moutimid.sqlapp.activities.Organizer;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.moutimid.sqlapp.R;

import java.io.File;

public class PdfViewerActivity extends AppCompatActivity {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    private PDFView pdfView;
    private String filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);
        pdfView = findViewById(R.id.pdfView);
        filePath = "storage/emulated/0/Download/EcommerceApp.pdf";
        OpenPDFFile();
        // Check for permission and load PDF
        if (checkStoragePermission()) {
//            loadPDF(filePath);
//            openPdfWithExternalViewer(filePath);
        } else {
            requestStoragePermission();
        }
    }

    private void loadPDF(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            pdfView.fromFile(file)
                    .password(null)
                    .defaultPage(0)
                    .enableSwipe(true)
                    .swipeHorizontal(false)
                    .enableDoubletap(true)
                    .onLoad(new OnLoadCompleteListener() {
                        @Override
                        public void loadComplete(int nbPages) {
                            Log.d("PDF Load", "Load complete: " + nbPages + " pages");
                        }
                    })
                    .onError(new OnErrorListener() {
                        @Override
                        public void onError(Throwable t) {
                            Log.e("PDF Load", "Error loading PDF: " + t.getMessage());
                        }
                    })
                    .load();
        } else {
            Log.e("PDF Load", "File does not exist at path: " + filePath);
        }
    }

    // Permission handling methods
    private boolean checkStoragePermission() {
        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        return permission == PackageManager.PERMISSION_GRANTED;
    }

    private void requestStoragePermission() {
        ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, load the PDF
                loadPDF(filePath);
            } else {
                // Permission denied, show a message or handle accordingly
                Toast.makeText(this, "Permission denied. Cannot load PDF.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void openPdfWithExternalViewer(String pdfUrl) {
        try {
            Uri uri = Uri.parse(pdfUrl);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // If no PDF viewer app is installed, inform the user to install one
            Toast.makeText(this, "No PDF viewer app installed", Toast.LENGTH_SHORT).show();
        }
    }
    public void OpenPDFFile() {
        File pdfFile = new File(Environment.getExternalStorageDirectory(),filePath);//File path
        if (pdfFile.exists()) //Checking for the file is exist or not
        {
            Uri path = Uri.fromFile(pdfFile);
            Intent objIntent = new Intent(Intent.ACTION_VIEW);
            objIntent.setDataAndType(path, "application/pdf");
            objIntent.setFlags(Intent. FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(objIntent);//Staring the pdf viewer
        }
    }
}
