package com.walter.remte;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void save(View v)
	{
	    //goo.gl/L5e7No
		EditText edtNames=(EditText) findViewById(R.id.edtNames);
		EditText edtEmail=(EditText) findViewById(R.id.edtEmail);
		EditText edtCourse=(EditText) findViewById(R.id.edtCourse);
	    String names=edtNames.getText().toString();
	    String email=edtEmail.getText().toString();
	    String course=edtCourse.getText().toString();
	    if( !names.equals("") && !email.equals("") && !course.equals(""))
	    {
	      //send the values
	    	AsyncHttpClient client=new AsyncHttpClient();
	    	RequestParams params=new RequestParams();
	    	params.put("names", names);
	    	params.put("email", email);
	    	params.put("course", course);
	    	String url="http://inspire-africa.org/android/insert.php";
	    	//
	    	//http://inspire-africa.org/android/insert.php
	    	client.post(url,params, new AsyncHttpResponseHandler() {
		     	@Override
				public void onSuccess(int arg0, Header[] arg1, byte[] response) {
                  String data=new String(response);					
				  Toast.makeText(getApplicationContext(), data,Toast.LENGTH_LONG).show();                  
				}				
				@Override
				public void onFailure(int arg0, Header[] arg1, byte[] response, Throwable arg3) {
					Toast.makeText(getApplicationContext(), "Check Your Internet Settings",Toast.LENGTH_LONG).show();	
				}
			});
	    	//inspire-africa.org
	    	
	    	
	    	
	    }
	    else
	    {
	      Toast.makeText(this, "Fill All Fields", Toast.LENGTH_SHORT).show();
	    }
	    
	    
		
	}
	
	public void count(View v)
	{
	
	
	}
	
}
//http://inspire-africa.org/android/insert.php
