package com.walter.onlineexample;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
	Spinner spinner;
	String course="";
	EditText edNames,edEmail,edPhone;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		spinner=(Spinner) findViewById(R.id.spinner1);
	    final String[] data={"Android","Windows","Html","PHP"};
	    ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,data);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner.setAdapter(adapter);
	    spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View arg1,	int position, long arg3) {
				course=data[position];				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});

	    edNames=(EditText) findViewById(R.id.edtNames);
		edEmail=(EditText) findViewById(R.id.edtPhone);
		edPhone=(EditText) findViewById(R.id.edtEmails);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void register(View v) 
	{
		String names=edNames.getText().toString();
		String email=edEmail.getText().toString();
		String phone=edPhone.getText().toString();
		
		String url ="http://10.0.2.2/school/insert.php";
		RequestParams params=new RequestParams();
		params.put("names", names);
		params.put("email", email);
		params.put("phone", phone);
		params.put("course", course);
		AsyncHttpClient client =new AsyncHttpClient();
		client.post(url, params,new AsyncHttpResponseHandler() {			
			@Override
			public void onSuccess(int statusCode, Header[] arg1, byte[] response) {
				String data = new String(response);
				Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
				
			}			
			@Override
			public void onFailure(int statusCode, Header[] arg1, byte[] response, Throwable error) {
				
				Toast.makeText(getApplicationContext(), "Failed "+statusCode, Toast.LENGTH_LONG).show();		
			}
		});
	}
    public void view_students(View v)
    {
      startActivity(new Intent(this,AllStudentsActivity.class))	;
    }
   
    public void save(View v)
    {
		String names=edNames.getText().toString();
		String email=edEmail.getText().toString();
		String phone=edPhone.getText().toString();
		
		DBController db=new DBController(this);
		db.insert(names, email, phone, course);
		
    }
    public void count(View v)
    {
    	DBController db=new DBController(this);
    	int count=db.countRecords();
    	Toast.makeText(this, "# "+count, Toast.LENGTH_SHORT).show();
    }

    
    
    
    
}
