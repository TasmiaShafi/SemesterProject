package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        appName=findViewById(R.id.splashText);
        //Font-style setting
        Typeface typeface= ResourcesCompat.getFont(this,R.font.blacklist);
        appName.setTypeface(typeface);
        //Animation setting
        Animation anim= AnimationUtils.loadAnimation(this,R.anim.my_anim);
        appName.setAnimation(anim);
        //Thread
        new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();

                }
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
            }
        }.start();


    }
}