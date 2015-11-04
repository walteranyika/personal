package com.walter.todays;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    fetch_and_display_data();		
	}
	
    @Override
    protected void onResume() {
    	fetch_and_display_data();
    	super.onResume();
    }
    
	private void fetch_and_display_data() {
		
		String url="http://api.openweathermap.org/data/2.5/weather?q=Nairobi,ke&units=metric";	
	    AsyncHttpClient client=new AsyncHttpClient();
	    client.get(url, new AsyncHttpResponseHandler() {			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] response) {
				String jsonResponse=new String(response);
				try 
				{   //Parse json string
					JSONObject main_obj=new JSONObject(jsonResponse);
					JSONArray array_weather=main_obj.getJSONArray("weather");
					JSONObject obj_weather= array_weather.getJSONObject(0);
					String main_w = obj_weather.getString("main");
					String desc =obj_weather.getString("description");
					
					JSONObject obj2 =main_obj.getJSONObject("main");
					String temp = obj2.getString("temp");
					String temp_max = obj2.getString("temp_max");
					String temp_min = obj2.getString("temp_min");
					//iconfinder.com
					Log.d("WEATHER_MAIN", main_w);
					Log.d("WEATHER_DESC", desc);
					Log.d("WEATHER_TEMP", temp);
					Log.d("WEATHER_MAX", temp_max);
					Log.d("WEATHER_MIN", temp_min);
					
					
				 } catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
			  Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();	
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
