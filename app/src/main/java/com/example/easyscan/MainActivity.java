package com.example.easyscan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclickButton(View view) {
        Intent changeIntent = new Intent(this, MailActivity.class);
        startActivity(changeIntent);
    }

    @Deprecated("Deprecated in Java")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode != 123) {
            return;
        }
        Bitmap photo = (Bitmap) data.getExtras().get("data");

        //Bitmap newBM = Bitmap.createBitmap(photo, 0, 0, photo.getWidth(), photo.width)

        imageView.setImageBitmap(photo);
        Storage.myMeWhereImage = photo;
    }
}