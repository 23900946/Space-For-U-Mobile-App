package com.example.spaceforu;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    Database database;
    Database2 database2;
    Button findSpace;
    EditText town, postcode;
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home); //Loads home page layout

        database = new Database(this); //Creates instance of user database
        database2 = new Database2(this); //Creates instance of parking database
        findSpace = (Button) findViewById(R.id.button5);
        town = (EditText) findViewById(R.id.editText7);
        postcode = (EditText) findViewById(R.id.editText6);

        Cursor getData = database.getData(); //Gets the getData() method from the database class
        getData.moveToFirst(); //Moves to the first row of the table
        welcome = (TextView) findViewById(R.id.textView7);
        welcome.setText("Welcome " + getData.getString(0)); //Displays the user's first name

        Button logOut = (Button) findViewById(R.id.button4);
        logOut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(Home.this, MainActivity.class));

            }
        });

        Button guide = (Button) findViewById(R.id.button2);
        guide.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Guide.class));

            }
        });

        Button settings = (Button) findViewById(R.id.button3);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Settings.class));

            }
        });

        findSpace.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String placeInput = town.getText().toString(); //Gets the city/town the user entered
                String postcodeInput = postcode.getText().toString().toUpperCase(); //Gets the postcode the user entered and forces into upper case

                Boolean check = database2.getSpaces(placeInput, postcodeInput); //Checks the place name and postcode the user entered to see if it matches with a car park in the parking database


                if(check == true) { //If place name and postcode matches a car park in the parking database

                    startActivity(new Intent(Home.this, Spaces.class)); //Load spaces page

                }

                else { //If place name and postcode does not match any car parks in the parking database

                    Toast.makeText(Home.this,"No spaces found or you have entered incorrectly",Toast.LENGTH_SHORT).show();

                }

            }
        });


    }

}

