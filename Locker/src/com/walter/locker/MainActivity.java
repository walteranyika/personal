package com.walter.locker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
EditText edtPass;
TextView textWrongPassword;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edtPass=(EditText) findViewById(R.id.editTextPassword);
		textWrongPassword=(TextView) findViewById(R.id.textWrongPassword);
		getActionBar().hide();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void sign_in(View v)
	{
		
		String password=edtPass.getText().toString().trim();
		if(password.equals("1234"))
		{
		    //login successfully 
			Intent i=new Intent(this,AllPasswordsActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);
		}
		else
		{
		   //show error message 	
			textWrongPassword.setVisibility(View.VISIBLE);
		}
	}
}
