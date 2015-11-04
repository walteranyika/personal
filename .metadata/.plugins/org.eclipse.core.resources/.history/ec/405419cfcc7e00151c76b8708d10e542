package com.walter.lesson13;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

public class BooksActivity extends Activity {
	ListView list;
	CustomAdapter adapter;
	ArrayList<Book> array_books;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_books);
		list = (ListView) findViewById(R.id.listView1);
		array_books = new ArrayList<Book>();
		adapter = new CustomAdapter(this, array_books);
		list.setAdapter(adapter);
		String url = "http://emobilis-server.com/lesson13/fetch.php";
		AsyncHttpClient client = new AsyncHttpClient();
		client.get(url, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] response) {
				String json = new String(response);
				Log.d("JSON", json);
				Gson g=new Gson();
				Book[] array=g.fromJson(json, Book[].class);
				
			    ArrayList<Book> all_books=new ArrayList<Book>(Arrays.asList(array));
			    array_books.addAll(all_books);
			    adapter.notifyDataSetChanged();
				/*try {
					JSONArray array = new JSONArray(json);
					for (int i = 0; i < array.length(); i++) {
						String title = array.getJSONObject(i).getString("title");
						String author = array.getJSONObject(i).getString("author");
						Book b = new Book(title, author);
						array_books.add(b);
					}
				} catch (JSONException e) {
					Toast.makeText(getApplicationContext(),	"Failed to Process", Toast.LENGTH_SHORT).show();
				}*/

			}

			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2,	Throwable arg3) {
				Toast.makeText(getApplicationContext(), "Failed to Load",Toast.LENGTH_SHORT).show();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.books, menu);
		return true;
	}

}
