package com.example.spaceforu;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Space;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Spaces extends AppCompatActivity {

    Button findSpace;
    Database2 database;
    TextView name, spaces, spacesLeft, opening, closing, ticket, lat, lang, lat2, lang2, lat3, lang3, lat4, lang4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spaces); //Loads spaces page layout

        database = new Database2(this); //Creates instance of parking database

        Cursor getData = database.getData2(); //Gets the getData2() method from the database2 class
        getData.moveToFirst(); //Moves to the first row of the table

        //Code below retrieves data from the database and inserts it onto the page
        name = (TextView) findViewById(R.id.textView20);
        name.setText(getData.getString(2));
        spaces = (TextView) findViewById(R.id.textView19);
        spaces.setText("Total spaces: " + getData.getString(3));
        spacesLeft = (TextView) findViewById(R.id.textView27);
        spacesLeft.setText("Spaces left: " + getData.getString(4));
        opening = (TextView) findViewById(R.id.textView30);
        opening.setText("Opening time: " + getData.getString(5));
        closing = (TextView) findViewById(R.id.textView32);
        closing.setText("Closing time: " + getData.getString(6));
        ticket = (TextView) findViewById(R.id.textView31);
        ticket.setText(getData.getString(7));
        lat = (TextView) findViewById(R.id.textView33);
        lat.setText(getData.getString(8));
        lang = (TextView) findViewById(R.id.textView29);
        lang.setText(getData.getString(9));

        findSpace = (Button) findViewById(R.id.button6);
        findSpace.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Code below retrieves car park coordinates and loads the maps activity
                startActivity(new Intent(Spaces.this, MapsActivity.class));
                Intent intent = new Intent(Spaces.this, MapsActivity.class);
                intent.putExtra("Latitude", lat.getText());
                intent.putExtra("Longitude", lang.getText());
                startActivity(intent);

            }
        });

        getData.moveToNext(); //Moves to next row in table

        //Code below retrieves data from the database and inserts it onto the page
        name = (TextView) findViewById(R.id.textView18);
        name.setText(getData.getString(2));
        spaces = (TextView) findViewById(R.id.textView34);
        spaces.setText("Total spaces: " + getData.getString(3));
        spacesLeft = (TextView) findViewById(R.id.textView37);
        spacesLeft.setText("Spaces left: " + getData.getString(4));
        opening = (TextView) findViewById(R.id.textView36);
        opening.setText("Opening time: " + getData.getString(5));
        closing = (TextView) findViewById(R.id.textView35);
        closing.setText("Closing time: " + getData.getString(6));
        ticket = (TextView) findViewById(R.id.textView38);
        ticket.setText(getData.getString(7));
        lat2 = (TextView) findViewById(R.id.textView39);
        lat2.setText(getData.getString(8));
        lang2 = (TextView) findViewById(R.id.textView40);
        lang2.setText(getData.getString(9));

        findSpace = (Button) findViewById(R.id.button7);
        findSpace.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Code below retrieves car park coordinates and loads the maps activity
                startActivity(new Intent(Spaces.this, MapsActivity.class));
                Intent intent = new Intent(Spaces.this, MapsActivity.class);
                intent.putExtra("Latitude", lat2.getText());
                intent.putExtra("Longitude", lang2.getText());
                startActivity(intent);

            }
        });

        getData.moveToNext(); //Moves to next row in table

        //Code below retrieves data from the database and inserts it onto the page
        name = (TextView) findViewById(R.id.textView41);
        name.setText(getData.getString(2));
        spaces = (TextView) findViewById(R.id.textView42);
        spaces.setText("Total spaces: " + getData.getString(3));
        spacesLeft = (TextView) findViewById(R.id.textView43);
        spacesLeft.setText("Spaces left: " + getData.getString(4));
        opening = (TextView) findViewById(R.id.textView44);
        opening.setText("Opening time: " + getData.getString(5));
        closing = (TextView) findViewById(R.id.textView45);
        closing.setText("Closing time: " + getData.getString(6));
        ticket = (TextView) findViewById(R.id.textView46);
        ticket.setText(getData.getString(7));
        lat3 = (TextView) findViewById(R.id.textView47);
        lat3.setText(getData.getString(8));
        lang3 = (TextView) findViewById(R.id.textView48);
        lang3.setText(getData.getString(9));

        findSpace = (Button) findViewById(R.id.button8);
        findSpace.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Code below retrieves car park coordinates and loads the maps activity
                startActivity(new Intent(Spaces.this, MapsActivity.class));
                Intent intent = new Intent(Spaces.this, MapsActivity.class);
                intent.putExtra("Latitude", lat3.getText());
                intent.putExtra("Longitude", lang3.getText());
                startActivity(intent);

            }
        });

        getData.moveToNext(); //Moves to next row in table

        //Code below retrieves data from the database and inserts it onto the page
        name = (TextView) findViewById(R.id.textView49);
        name.setText(getData.getString(2));
        spaces = (TextView) findViewById(R.id.textView50);
        spaces.setText("Total spaces: " + getData.getString(3));
        spacesLeft = (TextView) findViewById(R.id.textView51);
        spacesLeft.setText("Spaces left: " + getData.getString(4));
        opening = (TextView) findViewById(R.id.textView52);
        opening.setText("Opening time: " + getData.getString(5));
        closing = (TextView) findViewById(R.id.textView53);
        closing.setText("Closing time: " + getData.getString(6));
        ticket = (TextView) findViewById(R.id.textView54);
        ticket.setText(getData.getString(7));
        lat4 = (TextView) findViewById(R.id.textView55);
        lat4.setText(getData.getString(8));
        lang4 = (TextView) findViewById(R.id.textView56);
        lang4.setText(getData.getString(9));

        findSpace = (Button) findViewById(R.id.button9);
        findSpace.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Code below retrieves car park coordinates and loads the maps activity
                startActivity(new Intent(Spaces.this, MapsActivity.class));
                Intent intent = new Intent(Spaces.this, MapsActivity.class);
                intent.putExtra("Latitude", lat4.getText());
                intent.putExtra("Longitude", lang4.getText());
                startActivity(intent);

            }
        });


    }

}
