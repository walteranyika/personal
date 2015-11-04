package com.shadiih.firstaid1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class BitesAndStingsActivity extends Activity {
	
	TextView info;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bites_and_stings);
		
		
		getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#304FFE")));
		getActionBar().setTitle(Html.fromHtml("<h5><font color='#ffffff'>Bites|Stings First Aid</font></h5>"));
		
		getActionBar().setIcon(R.drawable.woundicon);
		
info=(TextView) findViewById(R.id.tvBites_stings);

Typeface font=Typeface.createFromAsset(getAssets(), "fonts/Aller.ttf");
info.setTypeface(font);
		
		String res = null;
		try {
			res = new TextFilesReader(this).readTxt("bitesstings.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//calling class.method respectively
		
		info.setText(Html.fromHtml(res));//use Html to make sure it doesnt pring html tags
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bites_and_stings, menu);
		return true;
	}
	
	public void bites_stings(View v)
	{
		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=lE5KA6Tb_jU")));
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
int id= item.getItemId();
		
		if (id==R.id.action_share) {
			
			String toshare=info.getText().toString();
			Intent shareIntent=new Intent(Intent.ACTION_SEND);
			shareIntent.setType("text/plain");
			shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, toshare);
			startActivity(Intent.createChooser(shareIntent, "Share via"));
		}
		return super.onOptionsItemSelected(item);
	}

}
