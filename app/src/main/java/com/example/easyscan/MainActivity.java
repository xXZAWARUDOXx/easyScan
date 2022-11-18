package com.example.easyscan;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.graphics.Bitmap.CompressFormat.PNG;
import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onclickButton(View view) {
        if (ContextCompat.checkSelfPermission(this, CAMERA) == PackageManager.PERMISSION_DENIED) {
            requestPermissions(new String[]{CAMERA},1);
            return;
        }
        Intent changeIntent = new Intent(ACTION_IMAGE_CAPTURE);
        startActivityForResult(changeIntent, 123);
    }

    public void onclickHistory(View view) {
        Intent changeIntent = new Intent(this, HistoryActivity.class);
        startActivity(changeIntent);
    }

    public void mailActivity(View view) {
        Intent changeIntent = new Intent(this, MailActivity.class);
        startActivity(changeIntent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode != 123) {
            return;
        }
        Bitmap photo = (Bitmap) data.getExtras().get("data");
        Bitmap newBM = Bitmap.createBitmap(photo, 0, 0, photo.getWidth(), photo.getWidth());

        /*ByteArrayOutputStream baos = new ByteArrayOutputStream();
        newBM.compress(PNG, 100, baos);*/

        Intent intent = new Intent(this, MailActivity.class);
        //intent.putExtra("attachment", baos);

        startActivity(intent);
    }
}