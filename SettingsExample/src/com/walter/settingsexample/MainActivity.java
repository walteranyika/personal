package com.walter.settingsexample;

import android.R.bool;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	   TextView tvSettings=(TextView) findViewById(R.id.tvSettins);
	   SharedPreferences SP=
			   PreferenceManager.getDefaultSharedPreferences(this);
	   String username=SP.getString("username", "Empty");
	   String sports =SP.getString("sports", "1");
	   boolean updates=SP.getBoolean("updates", false);
	   tvSettings.setText(username+"\n"+sports+"\n"+updates);
	   //goo.gl/5J3Nna
	      
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==R.id.action_settings)
		{
		  Intent i=new Intent(this,SettingsActivity.class);	
		  startActivity(i);			
		}
		return super.onOptionsItemSelected(item);
	}
	
}
