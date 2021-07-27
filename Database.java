package com.example.spaceforu;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Users.db"; //Name of the database
    private static final String TABLE_NAME = "User_Table"; //Name of the table
    private static final String USER_ID = "ID"; //User's assigned ID
    private static final String FIRST_NAME = "First_Name"; //Users first name
    private static final String LAST_NAME = "Last_Name"; //Users last name
    private static final String USER_NAME = "User_Name"; //Users user name
    private static final String PASSWORD = "Password"; //Users password

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) { //Creates the database table
        db.execSQL("CREATE TABLE User_Table (USER_ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRST_NAME TEXT, LAST_NAME TEXT, USER_NAME TEXT, PASSWORD TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { //Updates the table if changes have been made
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean register(String userFirstName, String userLastName, String userName, String userPassword) { //Inserts users data into the database table
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIRST_NAME, userFirstName);
        values.put(LAST_NAME, userLastName);
        values.put(USER_NAME, userName);
        values.put(PASSWORD, userPassword);
        long insert = db.insert(TABLE_NAME,null,values);
        if (insert == -1)

            return false;

        else

            return true;

    }

    public boolean logIn(String username, String userPassword) { //Checks the database table to see if there is a matching user
        SQLiteDatabase db = getReadableDatabase();
        Cursor query = db.rawQuery("select * from User_Table where  USER_NAME=? and PASSWORD=?", new String[] {username, userPassword});
        if (query.getCount()>0)

            return true;
        else

            return false;

    }

    public Cursor getData() { //Retrieves data from the database table
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {Database.FIRST_NAME, Database.LAST_NAME, Database.USER_NAME, Database.PASSWORD}; //Retrieves the data from these columns
        Cursor retrieve = db.query(TABLE_NAME,columns,null,null,null,null,null);
        return retrieve;
    }



}