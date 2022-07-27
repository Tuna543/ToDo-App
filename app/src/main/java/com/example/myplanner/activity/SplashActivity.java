package com.example.myplanner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myplanner.R;
import android.content.Intent;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * This is SplashActivity class of MyPlanner application
 * Some Animation will be on this
 * SplashActivity class
 *
 */

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH = 3300 ;

    ImageView img1;
    TextView txt1,txt2,txt3,txt4,txt5;
    Animation top,bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);


        img1=(ImageView)findViewById(R.id.logo);
        txt1=(TextView)findViewById(R.id.sublogo1);
        txt2=(TextView)findViewById(R.id.sublogo2);
        txt3=(TextView)findViewById(R.id.sublogo3);
        txt4=(TextView)findViewById(R.id.sublogo4);
        txt5=(TextView)findViewById(R.id.sublogo5);
        
/**
 * For Animation
 * 
 */

        top= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mainlogoanimation);
        bottom=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sublogo1animation);

        img1.setAnimation(top);
        txt1.setAnimation(bottom);
        txt2.setAnimation(bottom);
        txt3.setAnimation(bottom);
        txt4.setAnimation(bottom);
        txt5.setAnimation(bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this , MainActivity.class );
                startActivity(intent);
                finish();
            }
        },SPLASH);

    }
}
