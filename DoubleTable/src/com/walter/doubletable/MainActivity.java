package com.walter.doubletable;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
EditText edt1,edt2,edt3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edt1=(EditText) findViewById(R.id.edtNames);
		edt2=(EditText) findViewById(R.id.edtEmail);
		edt3=(EditText) findViewById(R.id.edtPhone);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
    public void save(View v)
    {
    	String names = edt1.getText().toString().trim();
    	String email = edt2.getText().toString().trim();
    	String phone = edt3.getText().toString().trim();
    	if(!TextUtils.isEmpty(names) && !TextUtils.isEmpty(phone) && !TextUtils.isEmpty(email))
    	{
    	  Database db =new Database(this);
    	  db.insert_student(names, email, phone);
    	  edt1.setText("");
    	  edt2.setText("");
    	  edt3.setText("");
    	  Toast.makeText(this, "You got "+db.count_students(), Toast.LENGTH_SHORT).show();
    	}        
    }
    public void scores(View v)
    {
    	startActivity(new Intent(this,AddScoreActivity.class));
    }
}
