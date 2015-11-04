package com.walter.receivers;

import java.util.ArrayList;

import org.apache.http.Header;
import org.json.JSONArray;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class UploadService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
    	final DBController db=new DBController(this);
     	ArrayList<String> data =db.getAllData();
     	JSONArray array=new JSONArray(data);
     	Log.d("JSON DATA", array.toString());
     	String url="http://10.0.2.2/school/service.php";
     	AsyncHttpClient client=new AsyncHttpClient();
     	RequestParams params=new RequestParams();
     	params.put("json", array.toString());
     	if(db.countRecords()>0)
     	{
 	    	client.post(url, params,new AsyncHttpResponseHandler() {			
 				@Override
 				public void onSuccess(int arg0, Header[] arg1, byte[] response) {
 				    String serverReply=new String(response);
 				    Log.d("SERVER", serverReply);
 				    if(serverReply.contains("success"))
 				    {
 				      db.deleteEverything();	
 				    }
 				}			
 				@Override
 				public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
 					Log.d("SERVER", "FAILED"); 				
 				}
 			});
	    
     	}
     	this.stopSelf();
    	return Service.START_NOT_STICKY;
    } 
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
