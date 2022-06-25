 package com.example.my_planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {

     private static final int SPLASH = 3300 ;

     ImageView img1;
     TextView txt1,txt2;
     Animation top,bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        img1=(ImageView)findViewById(R.id.logo);
        txt1=(TextView)findViewById(R.id.sublogo1);
        txt2=(TextView)findViewById(R.id.sublogo2);

        top= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mainlogoanimation);
        bottom=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sublogo1animation);

        img1.setAnimation(top);
        txt1.setAnimation(bottom);
        txt2.setAnimation(bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this ,SecondActivity.class );
                startActivity(intent);
                finish();
            }
        },SPLASH);


    }
}