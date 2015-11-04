package com.walter.calculator;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

	ArrayList<String> arrayList = new ArrayList<String>();
	String string = "";
	String string1 = "";

	public void onBtnClick(View v) {
		TextView tvTop =(TextView) findViewById(R.id.textViewTop);
		Button btn = (Button) v;
		string = btn.getText().toString();
		if (!string.contains("+") && !string.contains("*")	&& !string.contains("/") && !string.contains("-"))
		{
			string1 = string1 + string;
			if (arrayList.size() > 0) 
			{
				arrayList.remove(arrayList.size() - 1);
			}
			arrayList.add(string1);

		} else 
		{
			arrayList.add(string1);
			arrayList.add(string1);
			string1 ="";
		}
       //tvTop.setText(tvTop.getText().toString()+string);
       tvTop.setText(arrayList.toString());
	}

}
