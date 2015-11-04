package com.walter.lesson13;

import java.util.ArrayList;

import org.apache.http.Header;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class MainActivity extends Activity {
	EditText edtTitle, edtAuthor;
	ArrayList<Book> books;
    ProgressBar progress;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		progress=(ProgressBar) findViewById(R.id.progressBar1);
		edtTitle = (EditText) findViewById(R.id.editTextTitle);
		edtAuthor = (EditText) findViewById(R.id.editTextAuthor);
		books = new ArrayList<Book>();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void add(View k) {
		// collect all data
		String title = edtTitle.getText().toString();
		String author = edtAuthor.getText().toString();
		if (title.length() > 5 && author.length() > 5) {
			Book x = new Book(title, author);
			books.add(x);
			edtAuthor.setText("");
			edtTitle.setText("");
			Toast.makeText(this, "Count : " + books.size(), Toast.LENGTH_SHORT)
					.show();
		} else {
			Toast.makeText(this, "Invalid Values", Toast.LENGTH_SHORT).show();
		}

	}

	public void send(View k) {
		// send all data to the server
		if (books.size() > 0)
		{
			Gson g = new Gson();
			String data = g.toJson(books);
			Log.d("BOOKS", data);
			String url = "http://10.0.2.2/lesson13/insert.php";
			progress.setVisibility(View.VISIBLE);
			RequestParams params = new RequestParams();
			params.put("data", data);
			AsyncHttpClient client = new AsyncHttpClient();
			client.post(url, params, new AsyncHttpResponseHandler() {
				@Override
				public void onSuccess(int arg0, Header[] arg1, byte[] response) {
					String s = new String(response);
					Toast.makeText(getApplicationContext(), s,Toast.LENGTH_SHORT).show();
					Log.d("RESPONSE", s);
					books.clear();
					progress.setVisibility(View.INVISIBLE);
				}
				@Override
				public void onFailure(int arg0, Header[] arg1, byte[] arg2,	Throwable arg3) {
					Toast.makeText(getApplicationContext(),"Failed to Upload Books", Toast.LENGTH_SHORT)
							.show();
					progress.setVisibility(View.INVISIBLE);
				}
			});

		} else 
		{
			Toast.makeText(this, "No books to send", Toast.LENGTH_SHORT).show();
		}
	}
    
	public void second(View v)
	{
	 startActivity(new Intent(this,BooksActivity.class));	
	}
	
	
	
	
	
	
}
