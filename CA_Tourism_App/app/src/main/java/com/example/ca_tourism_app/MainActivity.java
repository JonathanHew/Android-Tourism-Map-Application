package com.example.ca_tourism_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button search_by_map_button;
    Button view_all_button;
    Button add_attraction_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_by_map_button = (Button) findViewById(R.id.search_map_button);
        search_by_map_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchScreens = new Intent(MainActivity.this, Search_By_Map_Activity.class);
                startActivity(switchScreens);
            }
        });

        view_all_button = (Button) findViewById(R.id.view_all_button);
        view_all_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("test", "view all button clicked");
                Intent switchScreens = new Intent(MainActivity.this, View_All_Activity.class);
                startActivity(switchScreens);
            }
        });

        add_attraction_button = (Button) findViewById(R.id.add_attraction_button);
        add_attraction_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchScreens = new Intent(MainActivity.this, Add_Attraction_Activity.class);
                startActivity(switchScreens);
            }
        });



        AttractionsDatabaseManager db = new AttractionsDatabaseManager(this);
        db.open();

        Log.d("test", "before cursor get all");
        Cursor cursor = db.getAllAttractions();
        Log.d("test", "after cursor get all");

        if(cursor.getCount() == 0) {
            Log.d("Insert: ", "Inserting ..");
            db.addAttraction(new Attraction("The Spire", "Located in Dublin City, a big metal pole.", "53.3498", "-6.2603"));
            db.addAttraction(new Attraction("The Cliffs of Moher", "About one and a half hours by car from Galway, in neighbouring County Clare, the cliffs are visited by close to a million people from across the globe each year. It's one of the popular day trips from Dublin. They stretch for eight kilometers along the Atlantic and rise some 214 meters at their highest point. Take a walk along the trail to experience the raw power of nature at its most majestic.", "52.9715", "-9.4309"));
            db.addAttraction(new Attraction("The GPO", "Located in Dublin City, a building very important to Irish History, now a post office", "53.3493", "-6.2607"));
            db.addAttraction(new Attraction("Grafton Street","So much more than just a great place to shop in Dublin, Grafton Street is alive with buskers, flower-sellers, and performance artists. You will also find countless places to stop off and simply watch the world meander by. Café culture has taken off in the capital, and on a sunny day, you'd be forgiven for thinking you were in Barcelona or Lisbon.","53.3414","-6.2602"));
            db.addAttraction(new Attraction("Killarney National Park","Standing close to the shores of Muckross Lake, one of three Killarney lakes famed worldwide for their splendor and beauty, this former mansion oozes the grandeur and gentility of bygone days. When exploring, bear in mind that Queen Victoria once visited here. In those days, a royal visit was no small affair; extensive renovations and re-landscaping took place in preparation, and no detail was left to chance.","52.0210","-9.5066"));
            db.addAttraction(new Attraction("Trinity College Dublin","Ireland's oldest university, Trinity College in Dublin is one of the country's ancient treasures. Founded in 1592 by Queen Elizabeth I, Trinity is a world within a world.","53.3438","-6.2546"));
            db.addAttraction(new Attraction("Kilmainham Gaol","Featured in many a rebel song and occupying a notoriously dark place in Irish history, Kilmainham Gaol should be high on the list of Dublin's best places to visit for those with any interest in Ireland's troubled past.","53.3419","-6.3098"));
            db.addAttraction(new Attraction("The Ring of Kerry","If in Kerry, take the time to explore what is arguably Ireland's most scenic route, the Ring of Kerry (Iveragh Peninsula). While you can start anywhere along this spectacular 111-mile-long tourist route, most people tend to set out from either Kenmare or Killarney ending, naturally enough, back in the same spot.","52.1545","-9.5669"));
            db.addAttraction(new Attraction("Glendalough","Magical and mysterious, Glendalough is home to one of the most important monastic sites in Ireland. The settlement was established by St. Kevin during the 6th century and eventually evolved into what's known as the Monastic City. ","53.0120","-6.326156"));
            db.addAttraction(new Attraction("Powerscourt House","Superb views, serene lakeside walks, engaging history, and the stunning backdrop of Sugarloaf Mountain are just some of the treats in store when visiting this magnificent home, just 20 kilometers from Dublin.","53.1843","-6.1867"));
            db.addAttraction(new Attraction("The Little Museum","This is a joyful museum that celebrates Dublin with all its quirkiness and humor.","53.3396","-6.2583"));
            db.addAttraction(new Attraction("The Rock of Cashel","Ireland's most visited heritage site, the Rock of Cashel stars in countless images of the Emerald Isle.","52.5201","-7.8905"));
            db.addAttraction(new Attraction("Blarney Castle","Possibly Ireland's best-known attraction and one it's must-see-castles, the Blarney Stone sits high on a tower of Blarney castle, not far from Cork.","51.9291","-8.5709"));
            db.addAttraction(new Attraction("Kinsale","Soaked in history and in a scenic coastal setting at the gateway to West Cork, Kinsale has been attracting large numbers of visitors for decades. It's one of the best small towns in Ireland for tourists.","51.7059","-8.5222"));
            db.addAttraction(new Attraction("Dingle","Part of The Wild Atlantic Way, a 1700-mile marked route around Ireland's west and adjacent coasts, the Dingle Peninsula combines wild beauty, history, and a glimpse of traditional Irish culture and language.","52.1409","-10.2640"));
            db.addAttraction(new Attraction("St. Stephen's Green","Beloved by Dubliners and with a colorful history, tranquil St. Stephen's Green is a great place to wind down, enjoy a picnic, or feed the ducks.","53.3400","-6.2623"));
            db.addAttraction(new Attraction("Bunratty Castle","A visit to the Shannon region wouldn't be complete without coming here. Dating from 1425, the castle is the best-preserved medieval fortress in Ireland and was lovingly restored in the 1950s.","52.6996","-8.8119"));
            db.addAttraction(new Attraction("The English Market","A market has existed on the site since the late 1700s, although the distinctive entrance on Princes Street dates from 1862. Recent worldwide fame came when Queen Elizabeth II dropped by on her first ever state visit to the Republic of Ireland in 2011. Iconic images of her sharing a joke with Fishmonger Pat O'Connell were beamed across the globe.","51.8976","-8.4748"));
            db.addAttraction(new Attraction("The Aran Islands","Wild, windswept, rugged, and utterly unique, the islands offer a visitor experience quite like no other. Once experienced, the great stone fort of Dun Aonghasa and the towering cliffs of Aran will never be forgotten.","53.0972","-9.6563"));



        }//end if

    }
}