package com.example.bedtimestorybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends AppCompatActivity {
TextView storyContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        storyContent = findViewById(R.id.contentOfStory);
        Intent i = getIntent();
        String title = i.getStringExtra("titleOfStory");
        String content = i.getStringExtra("contentOfStory");

        getSupportActionBar().setTitle(title);
        storyContent.setText(content);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}