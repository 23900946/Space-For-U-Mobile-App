package com.example.spaceforu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Database database;
    Database2 database2;
    Button log_in;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Loads log in page layout

        database = new Database(this); //Creates instance of user database
        database2 = new Database2(this); //Creates instance of parking database
        log_in = (Button)findViewById(R.id.login);
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);

        log_in.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String usernameInput = username.getText().toString().trim(); //Gets the user name the user entered
                String passwordInput = password.getText().toString().trim(); //Gets the password the user entered
                Boolean check = database.logIn(usernameInput, passwordInput); //Checks the username and password the user entered to see if it matches with a user's in the user database

                if (check == true) { //If username and password matches a user's in the user database

                    Toast.makeText(MainActivity.this, "Log in successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, Home.class)); //Load home page

                }

                else { //If username and password does not match any users in the user database

                    Toast.makeText(MainActivity.this, "Username or password does not exist",Toast.LENGTH_SHORT).show();

                }
            }

        });

        Button register = (Button)findViewById(R.id.register);
        register.setOnClickListener(new OnClickListener(){

            public void onClick(View v){

                startActivity(new Intent(MainActivity.this, Register.class));

            }

        });
    }
}