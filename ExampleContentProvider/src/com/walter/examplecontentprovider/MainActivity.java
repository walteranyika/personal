package com.walter.examplecontentprovider;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;
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
	
	public void show_inbox(View v)
	{
		Uri uri=Uri.parse("content://sms/inbox");
	  	Cursor cursor = getContentResolver().
	     query(uri, null, null, null, null);
	  	Toast.makeText(this,"Number of  Records "+cursor.getCount(),Toast.LENGTH_SHORT).show();
	  	if(cursor.moveToFirst())
	  	{
	  	   do{
	  		   //Log.d("NUM OF COLUMS", "NUM "+cursor.getColumnCount()); 
	  		   Log.d("SMS", cursor.getString(0) +" "+cursor.getString(1)+" "+cursor.getString(2));
	  		   break;
	  	     }while(cursor.moveToNext());	
	  	}
	  	else
	  	{
	  		Toast.makeText(this,"No Records "+cursor.getCount(),Toast.LENGTH_SHORT).show();
	  	}  	
	  	
	}
	
	public void save_item(View v)
	{
		String names= ((EditText)findViewById(R.id.editText1)).getText().toString();
		String email= ((EditText)findViewById(R.id.editText2)).getText().toString();
		ContentValues values=new ContentValues();
		values.put(StudentsProvider.NAME,names);
		values.put(StudentsProvider.EMAIL, email);
		//saving
		Uri uri=getContentResolver().
		     insert(StudentsProvider.CONTENT_URI, values);
		Toast.makeText(this,uri.toString(), Toast.LENGTH_LONG).show();		
	}
	
	public void show_item(View v)
	{
	  Uri uri =Uri.parse("content://com.walter.College/students");
	  Cursor cursor =getContentResolver().query(uri, null,null, null, null);	
	  Toast.makeText(this,"Count "+cursor.getCount(),Toast.LENGTH_LONG).show();
		if(cursor.moveToFirst())
		{
		  do{			  
			  Log.d("ITEM", cursor.getString(1));			  
		                                                                                         }while(cursor.moveToNext());
		}
	  
	}
	
	
	

}
