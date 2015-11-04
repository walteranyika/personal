package com.walter.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.sax.StartElementListener;

public class NetworkDetectorReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
	  ConnectivityManager cm=(ConnectivityManager)
	     context.getSystemService(Context.CONNECTIVITY_SERVICE);    
	  NetworkInfo info=cm.getActiveNetworkInfo();
	  DBController db=new DBController(context);
	  if(info!=null && info.isConnected() && db.countRecords()>0)
	  {
		 Intent s=new Intent(context,UploadService.class);
		 context.startService(s);		  
	  }
	  
	  
	}
}
