package com.walter.projectholder;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
ListView mListView;
CustomAdapter mAdapter;
ArrayList<Movie> mArrayList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String [] movies ={"Lord Of Rings","Fight Club","Lord Of Rings II","The Shawshank Redemption","The Godfather","The Godfather II","The Dark Night","Pulp Fiction","Schindlers List","Forest Grump","Inception","One Flew Over The Cuckoos Nest"};
		int images[] ={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10,R.drawable.img11,R.drawable.img12};
		mArrayList =new ArrayList<Movie>();
		for(int i=0;i<movies.length; i++)
		{
		 mArrayList.add(new Movie(movies[i], images[i], "Horror"));	
		}
		mListView =(ListView) findViewById(R.id.listViewMovies);
		mAdapter=new CustomAdapter(this,mArrayList);
		mListView.setAdapter(mAdapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
