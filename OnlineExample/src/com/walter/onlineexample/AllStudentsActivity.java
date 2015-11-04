package com.walter.onlineexample;

import java.util.ArrayList;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class AllStudentsActivity extends Activity {
 String url="http://10.0.2.2/school/fetch.php";
 ListView list;
 CustomAdapter adapter;
 ArrayList<Student> array_list;
 ProgressBar progress;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_students);
		list=(ListView) findViewById(R.id.listView1);
		progress=(ProgressBar) findViewById(R.id.progressBar1);		
		array_list=new ArrayList<Student>();
		adapter=new CustomAdapter(this, array_list);		
		list.setAdapter(adapter);
		fetch_data();	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.all_students, menu);
		return true;
	}
	
	private void fetch_data()
	{
		AsyncHttpClient client=new AsyncHttpClient();
		client.get(url,new AsyncHttpResponseHandler() {			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] response) {
				String json=new String(response);				
				try{
					JSONArray array= new JSONArray(json);
					for(int index=0; index<array.length(); index++)
					{
					  JSONObject obj=array.getJSONObject(index);
					  String id= obj.getString("id");
					  String names= obj.getString("names");
					  String email= obj.getString("email");
					  String phone= obj.getString("phone");
					  String course= obj.getString("course");
					  
					  Student s=new Student(id, names, email, phone, course);
					  array_list.add(s);
					  
					  Log.d("ITEM", names+" "+email);
					}
					adapter.notifyDataSetChanged();
					progress.setVisibility(View.INVISIBLE);
					
				} catch (JSONException e) 
				{					
					e.printStackTrace();
				}
				
			}			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();		
				progress.setVisibility(View.INVISIBLE);			
			}
		});	
		
	}
	

}
