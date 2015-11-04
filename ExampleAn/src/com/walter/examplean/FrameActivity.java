package com.walter.examplean;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class FrameActivity extends Activity {
ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frame);
	    imageView=(ImageView) findViewById(R.id.imageViewFrame);
	}
   ///resources.rar
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.frame, menu);
		return true;
	}
	public void load_anim(View v)
	{
	  imageView.setImageResource
	       (R.drawable.ball_animation);	
	}
	
	
	
	
	
	

}
