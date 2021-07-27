package com.example.spaceforu;

import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    Database database;
    Button register;
    EditText firstName, lastName, userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register); //Loads register page layout

        database = new Database(this); //Creates instance of user database

        register = (Button) findViewById(R.id.username2);
        firstName = (EditText) findViewById(R.id.editText);
        lastName = (EditText) findViewById(R.id.editText3);
        userName = (EditText) findViewById(R.id.editText4);
        password = (EditText) findViewById(R.id.editText5);
        addUser();

    }

    public void addUser() {

        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Code below gets the first name, lastname, username and password that the user entered
                boolean insert = database.register(firstName.getText().toString().trim(),
                        lastName.getText().toString().trim(),
                        userName.getText().toString().trim(),
                        password.getText().toString().trim());

                if (insert == true) { //If registration is successful

                    Toast.makeText(Register.this, "You have now registered", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(Register.this, MainActivity.class));

                }

                else { //If registration fails

                    Toast.makeText(Register.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }

}
