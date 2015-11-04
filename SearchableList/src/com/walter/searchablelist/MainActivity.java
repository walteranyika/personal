package com.walter.searchablelist;

import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

@SuppressLint("DefaultLocale")
public class MainActivity extends Activity {
ArrayList<Movie> arraylist;
CustomAdapter adapter;
ListView listView;
EditText edtSearch;
ArrayList<Movie> searchResults;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView=(ListView) findViewById(R.id.listView);
		edtSearch=(EditText) findViewById(R.id.edtSearch);
		searchResults=new ArrayList<Movie>();
		arraylist=new ArrayList<Movie>();
        populate_list_with_random_data();
		adapter=new CustomAdapter(this, arraylist);
		listView.setAdapter(adapter);
		
		edtSearch.addTextChangedListener(new TextWatcher() {			
			@SuppressLint("DefaultLocale")
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                searchResults.clear();
				if(arg0.length()>2)
                 {
                	for (Movie m:arraylist) 
                	{
					  if(m.getName().toLowerCase().contains(arg0) || m.getGenre().toLowerCase().contains(arg0) || m.getYear().toLowerCase().contains(arg0))
					  {
					    searchResults.add(m);
					  }	 
					} 
                	Toast.makeText(getApplicationContext(),"Num Of Results "+searchResults.size(), Toast.LENGTH_SHORT).show();
                  
                 }				
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	private void populate_list_with_random_data() {
		String[] titles={"Lord of Rings","Fight Club","Lord of Rings 2","Shawshank Redemp","God Father 1","God Father 2","The Dark Knight","Pulp Fiction","Schindlers List","Forest Gump","Inception","Cukoos Nest","Lord of Rings 3","Good Fellas","Matrix","Star Wars","Chinese","City Of God","Seven","Silence Of Lambs","The Usual Suspects","its a wonderful Life"};
		String [] randomGenre={"Horror","Comedy","Romance","Action","Thriller","Drama"};
		Random rand = new Random();       

        
        for(int i=0; i<titles.length;i++)
        {
            int randomYear = rand.nextInt((2015- 1990) + 1) + 1990;
            int randomG = rand.nextInt((5-0) + 1) + 0;
            String genre=randomGenre[randomG];
            String year=""+randomYear;
            String title=titles[i];
            arraylist.add(new Movie(title,genre,year));
            
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
