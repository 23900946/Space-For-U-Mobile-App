package com.example.spaceforu;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps); //Loads maps layout
        String Latitude = getIntent().getStringExtra("Latitude"); //Gets latitude intent from the spaces page
        String Longitude = getIntent().getStringExtra("Longitude"); //Gets longitude intent from the spaces page

        if(Latitude != null && Longitude != null) { //Prevents Google maps from crashing when opened a second time
            latitude = Double.parseDouble(Latitude);
            longitude = Double.parseDouble(Longitude);
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        float zoom = 16.0f; //Zoom level
        LatLng location = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(location).title("Marker")); //Marks the location
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, zoom)); //Display the location and adjust zoom
    }
}