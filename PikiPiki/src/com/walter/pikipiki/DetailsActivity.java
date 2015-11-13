package com.walter.pikipiki;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class DetailsActivity extends Activity {
TextView tvNameOwner,tvIdOwner,tvDRiverNames,tvDriverId,tvPhone,tvArea,tvRegDate,tvRegNo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		String[] data=getIntent().getExtras().getStringArray("bike");
		getActionBar().setTitle(data[7]);
		tvNameOwner=(TextView) findViewById(R.id.tvOwnerName);
		tvIdOwner=(TextView) findViewById(R.id.tvOwnerId);
		tvDRiverNames=(TextView) findViewById(R.id.tvDriverName);
		tvDriverId=(TextView) findViewById(R.id.tvDriverId);
		tvPhone=(TextView) findViewById(R.id.tvPhone);
		tvRegDate=(TextView) findViewById(R.id.tvDate);
		tvRegNo=(TextView) findViewById(R.id.tvRegNo);
		tvArea=(TextView) findViewById(R.id.tvAreaOperation);

		//ownerNames, ownerId, driverNames, driverId, regDate,area, phone ,regNo
		tvNameOwner.setText(data[0]);
		tvIdOwner.setText(data[1]);
		tvDRiverNames.setText(data[2]);
		tvDriverId.setText(data[3]);		
		tvRegDate.setText(data[4]);
		tvArea.setText(data[5]);
		tvPhone.setText(data[6]);
		tvRegNo.setText(data[7]);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.details, menu);
		return true;
	}

}
