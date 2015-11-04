package com.walter.receivers;

import java.util.ArrayList;

import org.apache.http.Header;
import org.json.JSONArray;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
EditText edt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    edt=(EditText) findViewById(R.id.edtName);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void save(View v)
    {
      String names=edt.getText().toString();
	  DBController db=new DBController(this);
	  if(names.trim().length()>6)
	  {
		  db.insert(names);
		  Toast.makeText(this, "Count is "+db.countRecords(), Toast.LENGTH_SHORT).show();
	      edt.setText("");
	  }
    }
    public void start(View v)
    {
    	Intent service=new Intent(this,UploadService.class);
        startService(service);
    	
    }
}










