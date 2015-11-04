package com.walter.pappymappy;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MyLocationActivity extends Activity {
GoogleMap gMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_location);
        set_up_maps();
    }

    private void set_up_maps()
    {
        if(gMap==null)
        {
            gMap =((MapFragment)getFragmentManager().findFragmentById(R.id.mymap)).getMap();
            gMap.getUiSettings().setZoomControlsEnabled(true);
            gMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            add_makers();
            gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(1.26, 36.80), 13));

            if(gMap==null)
            {
                Toast.makeText(this, "Sorry, Unable to create maps", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_location, menu);
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

    public void add_makers(){
        MarkerOptions marker=new MarkerOptions().position(new LatLng(-1.26,36.80)).title("Am Here");

        gMap.addMarker(marker);
    }


    public void change_loc(View view) {
        gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-1.26, 36.80), 13));
    }
}
