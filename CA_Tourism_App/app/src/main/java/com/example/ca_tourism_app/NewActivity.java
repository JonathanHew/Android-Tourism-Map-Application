package com.example.ca_tourism_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class NewActivity extends AppCompatActivity {

    TextView title;
    TextView desc;
    TextView lat;
    TextView longi;
    Button delete;
    Button update;
    AttractionsDatabaseManager db = new AttractionsDatabaseManager(this);


    protected void onCreate(Bundle savedInstanceState) {

        //back button code snippet from @https://stackoverflow.com/questions/14545139/android-back-button-in-the-title-bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Reference Complete
        Log.i("test", "Entered new activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_screen);
        Intent intentData = getIntent();
        String dataRetrieved = intentData.getStringExtra("data");
        String idRetrieved = intentData.getStringExtra("id");
        String nameRetrieved = intentData.getStringExtra("name");
        String descRetrieved = intentData.getStringExtra("description");
        String latRetrieved = intentData.getStringExtra("lat");
        String longiRetrieved = intentData.getStringExtra("longi");

        title = (TextView)findViewById(R.id.title);
        title.setText(nameRetrieved);

        desc = (TextView)findViewById(R.id.desc);
        desc.setText(descRetrieved);

        lat = (TextView)findViewById(R.id.lat);
        lat.setText(latRetrieved);

        longi = (TextView)findViewById(R.id.longi);
        longi.setText(longiRetrieved);


        db.open();



        delete = findViewById(R.id.delete_button);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteAttraction(idRetrieved);
                Toast.makeText(NewActivity.this, "Attraction Deleted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        update = findViewById(R.id.update_button);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchScreens = new Intent(NewActivity.this, Update_Attraction_Activity.class);
                switchScreens.putExtra("attractionID", idRetrieved);
                startActivity(switchScreens);
                finish();
            }
        });
    }
}