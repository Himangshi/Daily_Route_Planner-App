package com.example.dailyrouteplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TripActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);

        EditText editTextSource = findViewById(R.id.source);
        EditText editTextDest = findViewById(R.id.destination);
        Button btnS = findViewById(R.id.btnSubmit);
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = editTextSource.getText().toString();
                String dest =editTextDest.getText().toString();
                if(source.equals("") || dest.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter the source and destination both.",Toast.LENGTH_SHORT).show();
                }
                else {
                    Uri uri = Uri.parse("https://www.google.com/maps/dir/" + source + "/" + dest);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }
}