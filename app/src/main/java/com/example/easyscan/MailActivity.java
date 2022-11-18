package com.example.easyscan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MailActivity extends AppCompatActivity {
    private Button sendButton;
    private Button cancelButton;
    private EditText toMail;
    private EditText subject;
    private EditText body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        sendButton = findViewById(R.id.sendButton);
        cancelButton = findViewById(R.id.cancelButton);
        toMail = findViewById(R.id.toField);
        subject = findViewById(R.id.subjectField);
        body = findViewById(R.id.bodyField);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open(view);
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MailActivity.this, MainActivity.class));
            }
        });
    }

    public void open(View view) {
        /*Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Email betreff");
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Body of the Mail");
        startActivity(sendIntent);*/

        //String recipientList = "test.testform335@gmail.com";
        //String subject = "Ein Dieb wollte zuschlagen!";
        //String message = "Test1234";

        Intent intent = new Intent(Intent.ACTION_SEND);
        //intent.putExtra(Intent.EXTRA_EMAIL, this.toMail.getText().toString());
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{
                toMail.getText().toString()
        });
        intent.putExtra(Intent.EXTRA_SUBJECT, this.subject.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, this.body.getText().toString());
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }
}