package com.shadiih.firstaid1;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class FirstAidActivity extends Activity {
	
	ListView list;
	ArrayList<FirstAidIconsItems> data;
	CustomAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_aid);
		
		//removing icon
		//getActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
		
		//giving activity icon
		getActionBar().setIcon(R.drawable.woundicon);
		
		getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#304FFE")));
		getActionBar().setTitle(Html.fromHtml("<h5><font color='#ffffff'>GET STARTED</font></h5>"));
		
		list=(ListView) findViewById(R.id.lvFirstAid);
		String [] title={
				
				"Asthma Attack",
				"Bites And Stings",
				"Bleeding",
				"Broken Bone",
				"Burns And Scalds",
				"Choking",
				"Diabetes",
				"Distressed",
				"Head Injury",
				"Heart Attack",	
				"Nose Bleed",
				"Poisoning",
				"Seizures (Epilepsy)",
				"Stroke",																												
				"Unconscious",
				"Wounds"};
		int [] images={
				
				R.drawable.woundicon,
				R.drawable.bitesicon,
				R.drawable.bleedingicon,
				R.drawable.boneicon,
				R.drawable.burnicon,
				R.drawable.chokeicon,
				R.drawable.diabeteicon,
				R.drawable.distressedicon,
				R.drawable.headinjuryicon,
				R.drawable.hearticon,
				R.drawable.noseicon,
				R.drawable.poisonicon,
				R.drawable.seizureicon,
				R.drawable.strokeicon,
				R.drawable.cpricon,
				R.drawable.woundicon};
		
		
		data=new ArrayList<FirstAidIconsItems>();
		
	
		for (int i = 0; i < 16; i++) {
			
			data.add(new FirstAidIconsItems(title[i],images[i]));
			
		}
		adapter=new CustomAdapter(this, data);
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				FirstAidIconsItems m=data.get(position);
				String title=m.getTitle();
				
				if (title.equals("Asthma Attack")) {
					
					Intent u=new Intent(getApplicationContext(),AsthmaAttackActivity.class);
					startActivity(u);
				}else if (title.equals("Bites And Stings")) {
					
					Intent u=new Intent(getApplicationContext(),BitesAndStingsActivity.class);
					startActivity(u);
				}else if (title.equals("Bleeding")) {
					
					Intent u=new Intent(getApplicationContext(),BleedingActivity.class);
					startActivity(u);
				}else if (title.equals("Broken Bone")) {
					
					Intent u=new Intent(getApplicationContext(),BrokenBoneActivity.class);
					startActivity(u);
				}else if (title.equals("Burns And Scalds")) {
					
					Intent u=new Intent(getApplicationContext(),BurnsActivity.class);
					startActivity(u);
				}else if (title.equals("Choking")) {
					Intent choking=new Intent(getApplicationContext(),ChokingActivity.class);
					startActivity(choking);
				}else if (title.equals("Diabetes")) {
					
					Intent u=new Intent(getApplicationContext(),DiabetesActivity.class);
					startActivity(u);
				}else if (title.equals("Distressed")) {
					
					Intent u=new Intent(getApplicationContext(),DistressedActivity.class);
					startActivity(u);
				}else if (title.equals("Head Injury")) {
					
					Intent u=new Intent(getApplicationContext(),HeadInjuryActivity.class);
					startActivity(u);
				}else if (title.equals("Heart Attack")) {
					
					Intent u=new Intent(getApplicationContext(),HeartAttackActivity.class);
					startActivity(u);
				}else if (title.equals("Nose Bleed")) {
					
					Intent u=new Intent(getApplicationContext(),NoseBleedActivity.class);
					startActivity(u);
				}else if (title.equals("Poisoning")) {
					
					Intent u=new Intent(getApplicationContext(),PoisonActivity.class);
					startActivity(u);
				}else if (title.equals("Seizures (Epilepsy)")) {
					
					Intent u=new Intent(getApplicationContext(),SeizuresEpilepsyActivity.class);
					startActivity(u);
				}else if (title.equals("Stroke")) {
					
					Intent u=new Intent(getApplicationContext(),StrokeActivity.class);
					startActivity(u);
				}else if (title.equals("Unconscious")) {
					
					Intent u=new Intent(getApplicationContext(),UnconsciousAndBreathingActivity.class);
					startActivity(u);
					
				}else if (title.equals("Wounds")) {
					
					Intent w=new Intent(getApplicationContext(),WoundsActivity.class);
					startActivity(w);
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first_aid, menu);
		return true;
	}
	
	
	
	

}
