package com.example.diceapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.scoreText);
        button = findViewById(R.id.buttonToss);
        imageView = findViewById(R.id.diceImage);

        

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int score = random.nextInt(6) + 1;
                startAnimation();
                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        switch (score) {
                            case 1:
                                imageView.setImageResource(R.drawable.dice_1);
                                break;
                            case 2:
                                imageView.setImageResource(R.drawable.dice_2);
                                break;
                            case 3:
                                imageView.setImageResource(R.drawable.dice_3);
                                break;
                            case 4:
                                imageView.setImageResource(R.drawable.dice_4);
                                break;
                            case 5:
                                imageView.setImageResource(R.drawable.dice_5);
                                break;
                            case 6:
                                imageView.setImageResource(R.drawable.dice_6);
                                break;
                        }
                    }
                }, 1000);

                textView.setText(String.valueOf(score));
            }
        });

    }

    public void startAnimation(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotation",0f, 360f);
        animator.setDuration(1000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator);
        animatorSet.start();
    }


    public void backFirstActivity(View view){
        onBackPressed();
    }

}
