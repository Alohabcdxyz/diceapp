package com.example.diceapplication;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    TextView textView2;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    Button button1;
    TextView textView;
    String lichsu = "";
    Button buttonLicSu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button1 = findViewById(R.id.buttonLac);
        imageView1 = findViewById(R.id.diceImage1);
        imageView2 = findViewById(R.id.diceImage2);
        imageView3 = findViewById(R.id.diceImage3);
        textView2 = findViewById(R.id.ketQua);
        textView = findViewById(R.id.tvLichSu);
        buttonLicSu = findViewById(R.id.btnLichSu);

        SharedPreferences mypref = getSharedPreferences("mysave", MODE_PRIVATE);
        lichsu = mypref.getString("ls", "");
        textView.setText(lichsu);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int score1 = random.nextInt(6) + 1;
                int score2 = random.nextInt(6) + 1;
                int score3 = random.nextInt(6) + 1;
                startAnimation();
                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        switch (score1){
                            case 1:
                                imageView1.setImageResource(R.drawable.dice_1);
                                break;
                            case 2:
                                imageView1.setImageResource(R.drawable.dice_2);
                                break;
                            case 3:
                                imageView1.setImageResource(R.drawable.dice_3);
                                break;
                            case 4:
                                imageView1.setImageResource(R.drawable.dice_4);
                                break;
                            case 5:
                                imageView1.setImageResource(R.drawable.dice_5);
                                break;
                            case 6:
                                imageView1.setImageResource(R.drawable.dice_6);
                                break;
                        }
                        switch (score2){
                            case 1:
                                imageView2.setImageResource(R.drawable.dice_1);
                                break;
                            case 2:
                                imageView2.setImageResource(R.drawable.dice_2);
                                break;
                            case 3:
                                imageView2.setImageResource(R.drawable.dice_3);
                                break;
                            case 4:
                                imageView2.setImageResource(R.drawable.dice_4);
                                break;
                            case 5:
                                imageView2.setImageResource(R.drawable.dice_5);
                                break;
                            case 6:
                                imageView2.setImageResource(R.drawable.dice_6);
                                break;
                        }
                        switch (score3){
                            case 1:
                                imageView3.setImageResource(R.drawable.dice_1);
                                break;
                            case 2:
                                imageView3.setImageResource(R.drawable.dice_2);
                                break;
                            case 3:
                                imageView3.setImageResource(R.drawable.dice_3);
                                break;
                            case 4:
                                imageView3.setImageResource(R.drawable.dice_4);
                                break;
                            case 5:
                                imageView3.setImageResource(R.drawable.dice_5);
                                break;
                            case 6:
                                imageView3.setImageResource(R.drawable.dice_6);
                                break;
                        }
                    }
                }, 1000);
                if((score1 + score2 + score3) > 4 && (score1 + score2 + score3) < 10 ){
                    textView2.setText((score1 + score2 + score3) + " - "+ "XỈU");
                    lichsu += score1 + score2 + score3  + " - "+ "XỈU";
                    textView.setText(lichsu);
                    lichsu += "\n";
                    String a = lichsu;
                    buttonLicSu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intentLichSu = new Intent(MainActivity3.this, MainActivity4.class);
                            intentLichSu.putExtra("key", a);
                            startActivity(intentLichSu);
                        }
                    });

                } else if((score1 + score2 + score3) > 11 && (score1 + score2 + score3) < 17 ){
                    textView2.setText((score1 + score2 + score3) + " - "+ "TÀI");
                    lichsu += score1 + score2 + score3  + " - "+ "TÀI";
                    textView.setText(lichsu);
                    lichsu += "\n";
                }
            }
        });

    }

    public void startAnimation(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView1, "rotation",0f, 360f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView2, "rotation",0f, 360f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView3, "rotation",0f, 360f);

        animator.setDuration(1000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator);
        animatorSet.start();

        animator2.setDuration(1000);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(animator2);
        animatorSet2.start();

        animator3.setDuration(1000);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(animator3);
        animatorSet3.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences mypref = getSharedPreferences("mysave", MODE_PRIVATE);
        SharedPreferences.Editor myedit = mypref.edit();
        myedit.putString("ls", lichsu);
        myedit.commit();
    }

    public void backFirstActivity1(View view){
        onBackPressed();
    }
}
