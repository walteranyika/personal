package com.walter.ninsample;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
   TextView textView;
   ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView =(TextView) findViewById(R.id.textView1);
		imageView = (ImageView) findViewById(R.id.imageView1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
     
	public void animate_btn_click(View v)
	{
		//animate_image();
		animate_text();
	}
	private void animate_image()
	{ 
		//frame animation
		imageView.setImageResource(R.drawable.ball_animation);
		AnimationDrawable imageAnimation=(AnimationDrawable) imageView.getDrawable();
		if(imageAnimation.isRunning())
		{
			imageAnimation.stop();
		}
		imageAnimation.start();
	}
	
	private void animate_text()
	{
		//tween animation
		AlphaAnimation textAnimation  =new AlphaAnimation(0, 1);
		textAnimation.setDuration(3000);
		textAnimation.setFillAfter(true);
		textView.startAnimation(textAnimation);		
		//textAnimation.start();
		
	}
}





