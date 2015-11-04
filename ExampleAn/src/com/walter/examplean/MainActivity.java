package com.walter.examplean;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends Activity {
ImageView imgView;
Animation anim;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imgView=(ImageView) findViewById(R.id.imageView1);
	}
	//frame animation 
	//tween animation

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void move_anim(View v)
	{
		anim=AnimationUtils.loadAnimation
				      (this, R.anim.move_anim);
		imgView.startAnimation(anim);
	}

	public void rotate_anim(View v)
	{
	   anim=AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
	   imgView.startAnimation(anim);		
	}
	public void zoom_anim(View v)
	{
		anim=AnimationUtils.loadAnimation(this, R.anim.sacle_anim);
	   imgView.startAnimation(anim);		
	}
	public void fade_anim(View v)
	{
	   anim=AnimationUtils.loadAnimation(this, R.anim.fade_anim);
	   imgView.startAnimation(anim);		
	}
	public void frame_anim(View v)
	{
		 Intent i=new Intent(this,FrameActivity.class);
		 startActivity(i);
	}
}
