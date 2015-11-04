package com.shadiih.firstaid1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#304FFE")));
		//getActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>First Aid Kit</font>"));
		
		//putting off actionBar title
		getActionBar().setDisplayShowTitleEnabled(false);
		
		//removing actionBar icon
		getActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
		
		//setting the face font
		TextView tv=(TextView) findViewById(R.id.textViewMainUp);
		 Typeface font=Typeface.createFromAsset(getAssets(), "fonts/Aller.ttf");
		    tv.setTypeface(font);

		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void save_lives(View v)
	{
		Intent i=new Intent(this,FirstAidActivity.class);
		startActivity(i);
	}
	
	public void disclaimer(View v)
	{
		Intent j=new Intent(this,DisclaimerActivity.class);
		startActivity(j);
	}
	
	public void call(View v)
	{
		Intent callIntent = new Intent(Intent.ACTION_CALL);
		callIntent.setData(Uri.parse("tel:1199"));
		startActivity(callIntent);
	}
	
	private boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager 
	          = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

	
		return super.onOptionsItemSelected(item);
	}
	

}
