package com.example.spaceforu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings); //Loads settings page layout

        Button home = (Button) findViewById(R.id.button);
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(Settings.this, Home.class));

            }
        });

        Button guide = (Button) findViewById(R.id.button2);
        guide.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(Settings.this, Guide.class));

            }
        });

        Spinner button = (Spinner) findViewById(R.id.spinner);
        button.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //Spinner that allows user to change button colours in the app

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0) { //If position 0 selected then change colour to red

                    Button a = (Button) findViewById(R.id.button);
                    a.setBackgroundColor(Color.RED);

                    Button b = (Button) findViewById(R.id.button2);
                    b.setBackgroundColor(Color.RED);

                }

                if(position == 1) { //If position 1 selected then change colour to yellow

                    Button a = (Button) findViewById(R.id.button);
                    a.setBackgroundColor(Color.YELLOW);

                    Button b = (Button) findViewById(R.id.button2);
                    b.setBackgroundColor(Color.YELLOW);


                }

                if(position == 2) { //If position 2 selected then change colour to blue

                    Button a = (Button) findViewById(R.id.button);
                    a.setBackgroundColor(Color.BLUE);

                    Button b = (Button) findViewById(R.id.button2);
                    b.setBackgroundColor(Color.BLUE);

                }

                if(position == 3) { //If position 3 selected then change colour to green

                    Button a = (Button) findViewById(R.id.button);
                    a.setBackgroundColor(Color.GREEN);

                    Button b = (Button) findViewById(R.id.button2);
                    b.setBackgroundColor(Color.GREEN);

                }

                if(position == 4) { //If position 4 selected then change colour to black

                    Button a = (Button) findViewById(R.id.button);
                    a.setBackgroundColor(Color.BLACK);

                    Button b = (Button) findViewById(R.id.button2);
                    b.setBackgroundColor(Color.BLACK);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner background = (Spinner) findViewById(R.id.spinner2);
        background.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //Spinner that allows user to change background colour of the app

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) { //If position 0 selected then change colour to black

                    ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);
                    layout.setBackgroundColor(Color.BLACK);


                }

                if (position == 1) { //If position 1 selected then change colour to yellow

                    ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);
                    layout.setBackgroundColor(Color.YELLOW);


                }

                if (position == 2) { //If position 2 selected then change colour to blue

                    ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);
                    layout.setBackgroundColor(Color.BLUE);


                }

                if (position == 3) { //If position 3 selected then change colour to green

                    ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);
                    layout.setBackgroundColor(Color.GREEN);


                }

                if (position == 4) { //If position 4 selected then change colour to red

                    ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);
                    layout.setBackgroundColor(Color.RED);


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
