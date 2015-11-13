package com.walter.pikipiki;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import com.walter.pikipiki.adapters.CustomAdapter;
import com.walter.pikipiki.model.Database;
import com.walter.pikipiki.model.MotorBike;
import com.walter.pikipiki.network.SyncService;

public class MainActivity extends Activity {
	//TextView tvregNo, tvownerNames, tvownerId, tvdriverNames, tvdriverId,tvregDate, tvarea, tvphone;
	EditText edtSearch;
    ListView list;
    CustomAdapter adapter;
    ArrayList<MotorBike> data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().hide();
		edtSearch = (EditText) findViewById(R.id.editTextSearch);
		list=(ListView) findViewById(R.id.listView1);
		data=new ArrayList<MotorBike>();
		adapter=new CustomAdapter(this, data);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View parent, int pos,	long id) {
				MotorBike bike= data.get(pos);
				Intent i=new Intent(MainActivity.this,DetailsActivity.class);
				i.putExtra("bike", bike.getDataAsArray());
				startActivity(i);
			}
		});
		edtSearch.setOnEditorActionListener(new OnEditorActionListener() {			
			@Override
			public boolean onEditorAction(TextView arg0, int actionId, KeyEvent arg2) 
			{
				if(actionId==EditorInfo.IME_ACTION_SEARCH)
				{
					String s = edtSearch.getText().toString().trim();
					if (s.length() > 2) 
					{
						new SearchDB().execute(new String[] { s });
						//hideKeyBoard();
					} 
					else 
					{
						Toast.makeText(getApplicationContext(),	"Invalid Search Term",	Toast.LENGTH_SHORT).show();
					}	
					return true;
				}
				return false;
			}
		});
	}
	public void search(View v) {
		
		String s = edtSearch.getText().toString().trim();
		if (s.length() > 2) 
		{
			new SearchDB().execute(new String[] { s });
			hideKeyBoard();
		} 
		else 
		{
			Toast.makeText(getApplicationContext(),	"Invalid Search Term",	Toast.LENGTH_SHORT).show();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==R.id.action_sync)
		{
			
		 Intent i=new Intent(this,SyncService.class);
		 startService(i);
		}
		return super.onOptionsItemSelected(item);
	}
    private class SearchDB extends AsyncTask<String, Void,ArrayList<MotorBike>> {

		@Override
		protected ArrayList<MotorBike> doInBackground(String... search) {
			Database db = new Database(getApplicationContext());			
			return db.searcBike(search[0]);
			
		}

		@Override
		protected void onPostExecute(ArrayList<MotorBike> result) {
			if (result != null) 
			{
				data.clear();
				data.addAll(result);
				adapter.notifyDataSetChanged();               
			} else 
			{
				Toast.makeText(getApplicationContext(),	"No Item Found That Matches Your Search Term",	Toast.LENGTH_SHORT).show();
			}
			super.onPostExecute(result);
		}

	}
    public void hideKeyBoard()
    {
    	InputMethodManager imm=(InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
    	if(imm.isAcceptingText())
    	{
    	  imm.hideSoftInputFromWindow(edtSearch.getWindowToken(), 0);	
    	  Log.d("MAIN", "Hiding");
    	}
    }
}
