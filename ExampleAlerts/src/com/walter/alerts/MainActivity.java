package com.walter.alerts;

import android.os.Bundle;
import android.provider.AlarmClock;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.View;

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
	public void show_dialog(View v)
	{
		AlertDialog.Builder a_dialog= new AlertDialog.Builder(this);
		a_dialog.setMessage("Do you really want to close this app?");
		a_dialog.setCancelable(false);
		a_dialog.setPositiveButton("Yes", new OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
               finish();				
			}
		});
		a_dialog.setNegativeButton("No", new OnClickListener() {			
			@Override
			public void onClick(DialogInterface dialog, int arg1) {
				dialog.dismiss();				
			}
		});
        AlertDialog dialog=a_dialog.create();
        dialog.setTitle("App Close");
        dialog.show();
	}

}
