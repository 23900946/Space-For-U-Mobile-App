package com.example.spaceforu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Guide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_guide);

        Button home = (Button) findViewById(R.id.button);
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(Guide.this, Home.class));

            }
        });

        Button settings = (Button) findViewById(R.id.button3);
        settings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(Guide.this, Settings.class));

            }
        });

    }
}
