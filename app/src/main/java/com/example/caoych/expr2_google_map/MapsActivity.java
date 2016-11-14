package com.example.caoych.expr2_google_map;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private float DEFAULT_ZOOM = 15;
    private int markerCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        UiSettings settingMap = mMap.getUiSettings();
        Intent intent = getIntent();

        LatLng lille1 = new LatLng(50.6103, 3.1405);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lille1, DEFAULT_ZOOM));

        Boolean allowZoom = intent.getBooleanExtra("zoom", true);
        Boolean allowRotate = intent.getBooleanExtra("rotate", true);
        settingMap.setZoomGesturesEnabled(allowZoom);
        settingMap.setRotateGesturesEnabled(allowRotate);


        PolygonOptions lille1Surface = new PolygonOptions()
                .add(new LatLng(50.612532, 3.142158),
                        new LatLng(50.610291, 3.13722),
                        new LatLng(50.606268, 3.135161),
                        new LatLng(50.606823, 3.144594),
                        new LatLng(50.610788, 3.146718)
                        );
        Polygon polygon = mMap.addPolygon(lille1Surface.strokeColor(Color.RED));

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener(){
            @Override
            public void onMapLongClick(LatLng latLng) {
                mMap.addMarker(new MarkerOptions().position(latLng));
            }
        });
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
                return true;
            }
        });
    }

}
