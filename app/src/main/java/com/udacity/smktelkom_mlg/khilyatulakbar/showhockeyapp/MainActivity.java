package com.udacity.smktelkom_mlg.khilyatulakbar.showhockeyapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition SRONO = CameraPosition.builder()
            .target(new LatLng(-8.401871, 114.268358))
            .zoom(15)
            .bearing(0)
            .tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;
    MarkerOptions house;
    MarkerOptions quba;
    MarkerOptions eskape;
    MarkerOptions mts;
    MarkerOptions koramil;
    MarkerOptions pasar;
    MarkerOptions toko;

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        house = new MarkerOptions()
                .position(new LatLng(-8.400375, 114.273540))
                .title("My House")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        quba = new MarkerOptions()
                .position(new LatLng(-8.402491, 114.272767))
                .title("Masjid Al Quba")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        eskape = new MarkerOptions()
                .position(new LatLng(-8.398974, 114.274173))
                .title("Eskape TV")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        mts = new MarkerOptions()
                .position(new LatLng(-8.403169, 114.262172))
                .title("MTsN Srono")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        koramil = new MarkerOptions()
                .position(new LatLng(-8.395404, 114.273552))
                .title("Koramil")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        pasar = new MarkerOptions()
                .position(new LatLng(-8.402066, 114.264051))
                .title("Pasar Srono")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        toko = new MarkerOptions()
                .position(new LatLng(-8.397795, 114.269773))
                .title("Toko Sahabat")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        Toast toast = Toast.makeText(getApplicationContext(), "Map Ready!", Toast.LENGTH_SHORT);
        toast.show();
        //MapsInitializer.initialize(getApplicationContext());
        mapReady = true;
        m_map = map;
        m_map.addMarker(house);
        m_map.addMarker(quba);
        m_map.addMarker(eskape);
        m_map.addMarker(mts);
        m_map.addMarker(koramil);
        m_map.addMarker(pasar);
        m_map.addMarker(toko);
        flyTo(SRONO);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
