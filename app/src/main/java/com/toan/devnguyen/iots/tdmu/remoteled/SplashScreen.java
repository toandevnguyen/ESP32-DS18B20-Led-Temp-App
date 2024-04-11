package com.toan.devnguyen.iots.tdmu.remoteled;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
//    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        progressBar=(ProgressBar) findViewById(R.id.progressBar);


        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginScreen.class);
                startActivity(intent);
//                progressBar.setVisibility(View.VISIBLE);

                finish();
            }
        }, 2000);
    }
}