package com.example.easyscan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclickButton(View view) {
        Intent changeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
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
    }
}