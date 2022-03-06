package com.example.ca_tourism_app;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


//google map code snippets from Tutorialspoint.com @https://www.tutorialspoint.com/android/android_google_maps.htm used
public class Search_By_Map_Activity extends FragmentActivity implements OnMapReadyCallback, LocationListener
{

    private GoogleMap mMap;

    private LocationManager locationManager;
    private double user_lat;
    private double user_longi;
    private long minTime = 500;
    private float minDistance = 1;
    private static final int MY_PERMISSION_GPS = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_by_map_layout);
        Log.i("test", "entered search by map page");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        setUpLocation();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng TheSpire = new LatLng(53.3498, -6.2603);
        mMap.addMarker(new
                MarkerOptions().position(TheSpire).title("The Spire"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TheSpire, 12));

        LatLng TheGPO = new LatLng(53.3493, -6.2607);
        mMap.addMarker(new
                MarkerOptions().position(TheGPO).title("The GPO"));

        LatLng TheMoher = new LatLng(52.9715, -9.4309);
        mMap.addMarker(new
                MarkerOptions().position(TheMoher).title("The GPO"));

        LatLng  GraftonStreet= new LatLng(53.3414, -6.2602);
        mMap.addMarker(new
                MarkerOptions().position(GraftonStreet).title("Grafton Street"));

        LatLng KillarneyPark = new LatLng(52.0210, -9.5066);
        mMap.addMarker(new
                MarkerOptions().position(KillarneyPark).title("Killarney Park"));

        LatLng  TrinityCollegeDublin= new LatLng(53.3438,-6.2546 );
        mMap.addMarker(new
                MarkerOptions().position(TrinityCollegeDublin).title("Trinity College Dublin"));

        LatLng KilmainhamJail = new LatLng(53.3419, -6.3098);
        mMap.addMarker(new
                MarkerOptions().position(KilmainhamJail).title("Kilmainham Jail"));

        LatLng TheRingofKerry = new LatLng(52.1545, -9.5669);
        mMap.addMarker(new
                MarkerOptions().position(TheRingofKerry).title("The Ring of Kerry"));

        LatLng Glendalough = new LatLng(53.0120, -6.326156);
        mMap.addMarker(new
                MarkerOptions().position(Glendalough).title("Glendalough"));

        LatLng PowerscourtHouse = new LatLng(53.1843, -6.1867);
        mMap.addMarker(new
                MarkerOptions().position(PowerscourtHouse).title("Powerscourt House"));

        LatLng TheLittleMuseum = new LatLng(53.3396, -6.2583);
        mMap.addMarker(new
                MarkerOptions().position(TheLittleMuseum).title("TheLittle Museum"));

        LatLng TheRockofCashel = new LatLng(52.5201, -7.8905);
        mMap.addMarker(new
                MarkerOptions().position(TheRockofCashel).title("The Rock of Cashel"));

        LatLng BlarneyCastle = new LatLng(51.9291, -8.5709);
        mMap.addMarker(new
                MarkerOptions().position(BlarneyCastle).title("Blarney Castle"));

        LatLng Kinsale = new LatLng(51.7059, -8.5222);
        mMap.addMarker(new
                MarkerOptions().position(Kinsale).title("Kinsale"));

        LatLng Dingle = new LatLng(52.1409, -10.2640);
        mMap.addMarker(new
                MarkerOptions().position(Dingle).title("Dingle"));

        LatLng StStephensGreen = new LatLng(53.3400, -6.2623);
        mMap.addMarker(new
                MarkerOptions().position(StStephensGreen).title("St Stephens Green"));

        LatLng BunrattyCastle = new LatLng(52.6996, -8.8119);
        mMap.addMarker(new
                MarkerOptions().position(BunrattyCastle).title("Bunratty Castle"));


        LatLng TheEnglishMarket = new LatLng(51.8976, -8.4748);
        mMap.addMarker(new
                MarkerOptions().position(TheEnglishMarket).title("The English Market"));

        LatLng TheAranIslands = new LatLng(53.0972, -9.6563);
        mMap.addMarker(new
                MarkerOptions().position(TheAranIslands).title("The Aran Islands"));

    }
    //Reference Complete

    private void setUpLocation() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //Check if permission exists.. if not ask the user

        if (ContextCompat.checkSelfPermission(Search_By_Map_Activity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Search_By_Map_Activity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSION_GPS);
        } else { // permission granted

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, this);


        }
    }

    public void onLocationChanged(Location location) {
        String latestLocation = "";

        Log.d("GPSLOCATION", "LOCATION CHANGED!");

        if (location != null) {
            latestLocation = String.format(
                    "Current Location: Latitude %1$s Longitude : %2$s",
                    Math.round(location.getLatitude()), Math.round(location.getLongitude()));

            user_lat = location.getLatitude();
            user_longi = location.getLongitude();


            Log.d("GPSLOCATION", "LOCATION forattedd for textview!");


            LatLng userLocation = new LatLng(user_lat, user_longi);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 12));

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSION_GPS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // All good!
                } else {
                    Toast.makeText(this, "Need your location!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpLocation();
        Log.i("test", "restarted location updates");

    }

    @Override
    protected void onPause() {
        super.onPause();

        locationManager.removeUpdates(this);
        Log.i("test", "stopped location updates");

    }
}