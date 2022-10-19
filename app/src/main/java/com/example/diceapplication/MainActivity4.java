package com.example.diceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity4 extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        textView = findViewById(R.id.tvMain4);
        Intent i = getIntent();
        if (i != null) {
            String input = i.getStringExtra("key");
            textView.setText(input);
        }
    }
    public void backFirstActivityTaiXiu(View view){
        onBackPressed();
    }
}