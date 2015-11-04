package com.walter.locker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_item, menu);
		return true;
	}
	public void save_item(View v)
	{
	  EditText edt_site=(EditText) findViewById(R.id.edt_site);
	  EditText edt_pass=(EditText) findViewById(R.id.edt_pass);
	  String site=edt_site.getText().toString().trim();
	  String pass=edt_pass.getText().toString().trim();
	  if(!pass.isEmpty() && !site.isEmpty())
	  {
		  DBController db=new DBController(this);
		  db.insert(site, pass, "7/22/2015");
		  edt_site.setText("");
		  edt_pass.setText("");
		  Toast.makeText(this, "Saved Succesfully", Toast.LENGTH_SHORT).show();  
		  
	  }
	  else
	  {
		 Toast.makeText(this, "Fill In All Fields", Toast.LENGTH_SHORT).show();  
	  }
	}

}
