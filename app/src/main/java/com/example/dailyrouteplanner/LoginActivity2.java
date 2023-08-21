package com.example.dailyrouteplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity2 extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        btn1=findViewById(R.id.LOGIN_button);
        btn2=findViewById(R.id.SIGN_UP_button2);
        btn3=findViewById(R.id.button3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity(new Intent(LoginActivity2.this,LoginActivity.class));
            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity2.this,SignUpActivity.class));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity2.this,HomeActivity.class));
            }
        });

    }
}