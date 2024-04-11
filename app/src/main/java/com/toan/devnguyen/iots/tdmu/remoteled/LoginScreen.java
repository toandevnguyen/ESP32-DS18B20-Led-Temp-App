package com.toan.devnguyen.iots.tdmu.remoteled;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity {
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}