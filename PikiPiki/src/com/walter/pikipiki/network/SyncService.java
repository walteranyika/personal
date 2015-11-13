package com.walter.pikipiki.network;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.walter.pikipiki.model.Database;
import com.walter.pikipiki.model.MotorBike;
import com.walter.pikipiki.utils.Utils;

public class SyncService extends Service {
	String TAG=SyncService.class.getSimpleName();
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		final Database db = new Database(getApplicationContext());
        String last_uid=db.getLastID();
        AsyncHttpClient client=new AsyncHttpClient();
        RequestParams params=new RequestParams();
        params.put("uid", last_uid);
        Log.d(TAG, last_uid);
        client.post(Utils.SYN_URL, params, new AsyncHttpResponseHandler() {			
			@Override
			public void onSuccess(int status, Header[] header, byte[] response) {
				String json=new String(response);
				Log.d(TAG, json);				
				processJson(db, json);				
			}			
			@Override
			public void onFailure(int status, Header[] header, byte[] response, Throwable arg3) {
			   Log.d(TAG, "Could not fetch from the server");
			   stopSelf();
			   
			}
		});
		return Service.START_NOT_STICKY;
	}
    
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	private void processJson(final Database db, String json) {
		try {
			JSONArray array=new JSONArray(json);
			if(array.length()>0)
			{
			  Gson gson=new Gson();
			  MotorBike[] items=gson.fromJson(json, MotorBike[].class);	
			  for (MotorBike motorBike : items) 
			  {
					Log.d(TAG, motorBike.getDriverNames());
					db.insertBike(motorBike);
			  }
			}else{
				Log.d(TAG, "No new Records to sync");						
			}
			
		} catch (JSONException e) 
		{
			Log.d(TAG, "Error while processing json string");
		}
		this.stopSelf();
	}
    	
	
	

}
