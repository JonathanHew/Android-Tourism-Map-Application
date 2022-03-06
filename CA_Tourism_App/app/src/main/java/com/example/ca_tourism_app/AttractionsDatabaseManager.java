package com.example.ca_tourism_app;

import static com.example.ca_tourism_app.AttractionsDatabaseHelper.KEY_DESCRIPTION;
import static com.example.ca_tourism_app.AttractionsDatabaseHelper.KEY_ID;
import static com.example.ca_tourism_app.AttractionsDatabaseHelper.KEY_LAT;
import static com.example.ca_tourism_app.AttractionsDatabaseHelper.KEY_LONGI;
import static com.example.ca_tourism_app.AttractionsDatabaseHelper.KEY_NAME;
import static com.example.ca_tourism_app.AttractionsDatabaseHelper.TABLE_ATTRACTIONS;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class AttractionsDatabaseManager {
    Context context;
    private AttractionsDatabaseHelper AttractionsDbHelper;
    private SQLiteDatabase database;


    public AttractionsDatabaseManager(Context context)
    {
        this.context = context;

    }

    public AttractionsDatabaseManager open() throws SQLException {
        AttractionsDbHelper = new AttractionsDatabaseHelper(context);
        database = AttractionsDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        AttractionsDbHelper.close();
    }

    //add new attraction
    void addAttraction(Attraction attraction)
    {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, attraction.getName());
        values.put(KEY_DESCRIPTION, attraction.getDescription());
        values.put(KEY_LAT, attraction.getLat());
        values.put(KEY_LONGI, attraction.getLongi());

        Log.i("dbTest", "data is " + attraction.getName() + " " + attraction.getDescription() + " " + attraction.getLat() + " " + attraction.getLongi());
        //insering row
        database.insert(TABLE_ATTRACTIONS, null, values);
    }

    //get task
    Attraction getAttraction(int id)
    {
        Cursor cursor = database.query(TABLE_ATTRACTIONS, new String[]
                        {KEY_ID, KEY_NAME, KEY_DESCRIPTION, KEY_LAT, KEY_LONGI}, KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null ,null);

        if(cursor != null)
        {
            cursor.moveToFirst();
        }//end if

        Attraction attraction = new Attraction (cursor.getString(1),cursor.getString(2), cursor.getString(3),  cursor.getString(4));
        //return attraction
        return attraction;
    }

    //get all in a list view
    public Cursor getAllAttractions()
    {
        //select all query
        String selectQuery = "SELECT * FROM " + TABLE_ATTRACTIONS;
        Cursor attractionList = database.rawQuery(selectQuery, null);
        return attractionList;
    }


    //update a single attraction
    public int updateAttraction(String attractionID, String desc, String lat, String longi)
    {
        ContentValues values = new ContentValues();
        values.put(KEY_DESCRIPTION, desc);
        values.put(KEY_LAT, lat);
        values.put(KEY_LONGI, longi);

        Log.d("test", "attraction about to be updated");
        return database.update(TABLE_ATTRACTIONS, values, KEY_ID + " = ?", new String[] {String.valueOf(attractionID)});

        //updating row
        //return database.update(TABLE_ATTRACTIONS, values, KEY_NAME + " = ?", new String[] {String.valueOf(attraction.getName())});

    }

    //deleting a single attraction
    public void deleteAttraction(String attractionId)
    {
        database.delete(TABLE_ATTRACTIONS, KEY_ID + " = ?", new String[] {String.valueOf(attractionId)});
        database.close();
    }

    //getting attraction count
    public int getAttractionCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ATTRACTIONS;
        Cursor cursor = database.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }



}

