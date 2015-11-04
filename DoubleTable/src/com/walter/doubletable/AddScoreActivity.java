package com.walter.doubletable;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class AddScoreActivity extends Activity {
 EditText edt_scores,edt_date;
 Spinner spinner; 
 Database db;
 ArrayList<Student> data;
 SpinnerAdapter adapter;
 String id_student;
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_score);
		db=new Database(this);
		edt_scores= (EditText) findViewById(R.id.edt_score);
		edt_date =(EditText) findViewById(R.id.edtDate);
		spinner =(Spinner) findViewById(R.id.spinner1);
		data=db.getAllStudents();
		adapter=new SpinnerAdapter(this, data);
		spinner.setAdapter(adapter);	
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,int position, long arg3) {
			 Student s= data.get(position);
			 id_student=s.getId();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_score, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void save_score(View v)
	{
	   String score=edt_scores.getText().toString();
	   String date=edt_date.getText().toString();
	   db.insert_cat(id_student, score, date);
 	   Toast.makeText(this, "Scores "+db.count_scores(), Toast.LENGTH_SHORT).show();
       ArrayList<Scores> scorres=db.getAllScores();
       for(Scores s: scorres)
       {
    	 Log.d("SCORE ",s.getStudent_name()+" "+s.getScore());  
       }
	}
}
