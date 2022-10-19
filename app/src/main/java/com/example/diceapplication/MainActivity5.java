package com.example.diceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {
    private RatingBar myRatingBar;
    private TextView myRatingScale;
    private EditText feedback;
    private Button sendFeed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        myRatingBar = findViewById(R.id.ratingBar);
        myRatingScale = findViewById(R.id.tvRatingScale);
        feedback = findViewById(R.id.edtFb);
        sendFeed = findViewById(R.id.btnSubmit);

        myRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                myRatingScale.setText(String.valueOf(v));
                switch((int) ratingBar.getRating()){
                    case 1:
                        myRatingScale.setText("Very Bad. I'm sorry for the bad experience");
                        break;
                    case 2:
                        myRatingScale.setText("Need some improvement");
                        break;
                    case 3:
                        myRatingScale.setText("You think it's Good");
                        break;
                    case 4:
                        myRatingScale.setText("Great! Yeah");
                        break;
                    case 5:
                        myRatingScale.setText("OMG, Awesome, I love it");
                        break;
                }
            }
        });

        sendFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(feedback.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity5.this, "Please give some comment", Toast.LENGTH_SHORT).show();
                }
                else{
                    feedback.setText("");
                    myRatingBar.setRating(0);
                    Toast.makeText(MainActivity5.this, "Thank you", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}