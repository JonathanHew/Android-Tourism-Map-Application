package com.example.ca_tourism_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Update_Attraction_Activity extends AppCompatActivity {

    EditText name, description, latitude, longitude;
    Button submit;
    AttractionsDatabaseManager db = new AttractionsDatabaseManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_attraction_layout);
        Log.i("test", "update attraction page entered");
        //back button code snippet from @https://stackoverflow.com/questions/14545139/android-back-button-in-the-title-bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Reference Complete
        db.open();

        description = findViewById(R.id.update_description);
        latitude = findViewById(R.id.update_lat);
        longitude = findViewById(R.id.update_Longitude);

        submit = findViewById(R.id.submitUpdate);

        Intent intentData = getIntent();
        String idRetrieved = intentData.getStringExtra("attractionID");


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String descriptionText = description.getText().toString();
                String latText = latitude.getText().toString();
                String longiText = longitude.getText().toString();

                db.updateAttraction(idRetrieved, descriptionText, latText, longiText);
                Toast.makeText(Update_Attraction_Activity.this, "Attraction Details Updated", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }
}

