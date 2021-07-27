package com.example.spaceforu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database2 extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Parking.db"; //Name of the database
    private static final String TABLE_NAME = "Parking_Table"; //Name of the table
    private static final String PLACE = "Place"; //Location of car park
    private static final String POSTCODE = "Postcode"; //Postcode of car park
    private static final String CAR_PARK_NAME = "Car_Park_Name"; //Name of car park
    private static final String NUMBER_OF_SPACES = "Number_Of_Spaces"; //Total spaces in the car park
    private static final String SPACES_AVAILABLE = "Spaces_Available"; //Spaces currently available
    private static final String OPENING_TIME = "Opening_Time"; //Car park opening time
    private static final String CLOSING_TIME = "Closing_Time"; //Car park closing time
    private static final String CHEAPEST_TICKET = "Cheapest_Ticket"; //The price of the cheapest ticket you can buy
    private static final String LATITUDE = "Latitude"; //Latitude of the car park
    private static final String LONGITUDE = "Longitude"; //Longitude of the car park

    public Database2(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) { //Creates the database table and inserts the car park data into it
        db.execSQL("CREATE TABLE Parking_Table (PLACE TEXT, POSTCODE TEXT, CAR_PARK_NAME TEXT, NUMBER_OF_SPACES REAL, SPACES_AVAILABLE REAL, OPENING_TIME TEXT, CLOSING_TIME TEXT, CHEAPEST_TICKET TEXT, LATITUDE REAL, LONGITUDE REAL)");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(PLACE, POSTCODE, CAR_PARK_NAME, NUMBER_OF_SPACES, SPACES_AVAILABLE, OPENING_TIME, CLOSING_TIME, CHEAPEST_TICKET, LATITUDE, LONGITUDE) VALUES ('Ormskirk', 'L39 4QP', 'Edgehill university main car park', 100, 20, 'Open all day', 'Open all day', 'Free all day', 53.55761629599739, -2.86973007338112)");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(PLACE, POSTCODE, CAR_PARK_NAME, NUMBER_OF_SPACES, SPACES_AVAILABLE, OPENING_TIME, CLOSING_TIME, CHEAPEST_TICKET, LATITUDE, LONGITUDE) VALUES ('Ormskirk', 'L39 4QP', 'Ormskirk Morrisons car park', 80, 48, '7:00', '22:00', 'Free for 2 hours', 53.56589977186184, -2.8885750052343906)");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(PLACE, POSTCODE, CAR_PARK_NAME, NUMBER_OF_SPACES, SPACES_AVAILABLE, OPENING_TIME, CLOSING_TIME, CHEAPEST_TICKET, LATITUDE, LONGITUDE) VALUES ('Ormskirk', 'L39 4QP', 'Market way car park', 60, 32, 'Open all day', 'Open all day', '£1 for 3 hours', 53.566766926224226, -2.885086547903794)");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(PLACE, POSTCODE, CAR_PARK_NAME, NUMBER_OF_SPACES, SPACES_AVAILABLE, OPENING_TIME, CLOSING_TIME, CHEAPEST_TICKET, LATITUDE, LONGITUDE) VALUES ('Ormskirk', 'L39 4QP', 'Park road car park', 45, 0, 'Open all day', 'Open all day', 'Free for 1 hour', 53.56766873836309, -2.8881916300772583)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { //Updates the table if changes have been made
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean getSpaces(String place, String postcode) { //Checks the data to see if there are car parks in the table
        SQLiteDatabase db = getReadableDatabase();
        Cursor query = db.rawQuery("select * from Parking_Table where  PLACE=? and POSTCODE=?", new String[] {place, postcode});
        if (query.getCount()>0)

            return true;
        else

            return false;

    }

    public Cursor getData2() { //Retrieves data from the database table
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {Database2.PLACE, Database2.POSTCODE, Database2.CAR_PARK_NAME, Database2.NUMBER_OF_SPACES, Database2.SPACES_AVAILABLE, Database2.OPENING_TIME, Database2.CLOSING_TIME, Database2.CHEAPEST_TICKET, Database2.LATITUDE, Database2.LONGITUDE};
        Cursor retrieve = db.query(TABLE_NAME,columns,null,null,null,null,null);
        return retrieve;
    }
}
