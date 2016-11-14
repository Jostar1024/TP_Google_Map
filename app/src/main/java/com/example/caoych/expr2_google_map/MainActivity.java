package com.example.caoych.expr2_google_map;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
// Yucheng CAO
public class MainActivity extends AppCompatActivity {

    private Switch swZoom;
    private Switch swRotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swZoom = (Switch) findViewById(R.id.swZoom);
        swRotate = (Switch) findViewById(R.id.swRotate);
    }


    public void jumpToMap(View view) {
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.putExtra("zoom", swZoom.isChecked());
        intent.putExtra("rotate", swRotate.isChecked());
        
        startActivity(intent);
    }
}
