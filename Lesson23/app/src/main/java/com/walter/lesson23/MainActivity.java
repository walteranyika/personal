package com.walter.lesson23;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
TextView tvLon,tvLat,tvSpeed;
    LocationManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLon= (TextView) findViewById(R.id.textViewLon);
        tvLat= (TextView) findViewById(R.id.textViewLat);
        tvSpeed= (TextView) findViewById(R.id.textViewSpeed);
        manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

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

    public void fetch(View view) {
      String provider = LocationManager.GPS_PROVIDER;
     try {
         Location location= manager.getLastKnownLocation(provider);
         if(location!=null)
         {
             double lat= location.getLatitude();
             double lon = location.getLongitude();
             double speed =location.getSpeed();
             tvLat.setText(""+lat);
             tvLon.setText(""+lon);
             tvSpeed.setText(""+speed);
         }else{
             Toast.makeText(this, "Turn on GPS", Toast.LENGTH_SHORT).show();
         }
         }catch (SecurityException e){
            Log.e("DATA","Error with Permissions");
         }

    }
}






