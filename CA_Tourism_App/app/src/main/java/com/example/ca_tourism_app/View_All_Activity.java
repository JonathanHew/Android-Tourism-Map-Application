package com.example.ca_tourism_app;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class View_All_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //view_all_layout.xml  relativeLayout plan from AllCodingTutorials @https://www.youtube.com/watch?v=9t8VVWebRFM
        setContentView(R.layout.view_all_layout);
        Log.i("test", "entered view all activity");
        //back button code snippet from @https://stackoverflow.com/questions/14545139/android-back-button-in-the-title-bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Reference Complete
        SimpleCursorAdapter attractionAdapter;
        String names[] = new String[]{"name"};
        int[] rowColumns = new int[]{R.id.name};
        ListView listView = (ListView) findViewById(R.id.view_all_list);


        AttractionsDatabaseManager db = new AttractionsDatabaseManager(this);
        db.open();

        Cursor results = db.getAllAttractions();
        results.moveToFirst();
        //Log.i("test", results.getString(1) + " " + results.getString(2) + " " + results.getString(3) + " " + results.getString(4));

        attractionAdapter = new SimpleCursorAdapter(this, R.layout.row, results, names, rowColumns, 0);
        Log.i("test", "number of rows returned are " + results.getCount());
        listView.setAdapter(attractionAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                Cursor data = (Cursor) listView.getItemAtPosition(position);
                String dataID = data.getString(data.getColumnIndexOrThrow("_id"));
                String dataName = data.getString(data.getColumnIndexOrThrow("name"));
                String dataDescription = data.getString(data.getColumnIndexOrThrow("description"));
                String dataLat = data.getString(data.getColumnIndexOrThrow("lat"));
                String dataLongi = data.getString(data.getColumnIndexOrThrow("longi"));
                String dataString = dataName + " " + dataDescription + " " + dataLat + " " + dataLongi;
                Intent intent = new Intent(View_All_Activity.this, NewActivity.class);
                intent.putExtra("data", dataString);
                intent.putExtra("id", dataID);
                intent.putExtra("name", dataName);
                intent.putExtra("description", dataDescription);
                intent.putExtra("lat", dataLat);
                intent.putExtra("longi", dataLongi);
                finish();
                startActivity(intent);
            }
        });
    }//end onCreate

}
