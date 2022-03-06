package com.example.ca_tourism_app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Add_Attraction_Activity extends AppCompatActivity {

    EditText name, description, latitude, longitude;
    Button submit;
    AttractionsDatabaseManager db = new AttractionsDatabaseManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_attraction_layout);
        Log.i("test", "add attraction page entered");
        //back button code snippet from @https://stackoverflow.com/questions/14545139/android-back-button-in-the-title-bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Reference Complete
        db.open();

        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        latitude = findViewById(R.id.lat);
        longitude = findViewById(R.id.Longitude);

        submit = findViewById(R.id.submitInsert);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameText = name.getText().toString();
                String descriptionText = description.getText().toString();
                String latText = latitude.getText().toString();
                String longiText = longitude.getText().toString();

                Attraction attraction = new Attraction(nameText, descriptionText, latText, longiText);
                db.addAttraction(attraction);
                Log.d("test", "added into DB");
                Toast.makeText(Add_Attraction_Activity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                Log.d("test", "reached toast");
                finish();
            }
        });
    }
}
