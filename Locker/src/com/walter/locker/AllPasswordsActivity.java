package com.walter.locker;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;

public class AllPasswordsActivity extends Activity {
ListView list;
CustomAdapter adapter;
ArrayList<Movie> data;
DBController db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_passwords);
		list=(ListView) findViewById(R.id.listView1);
		db=new DBController(this);
		data=db.getAllPasswords();
		adapter=new CustomAdapter(this, data);
		list.setAdapter(adapter);
		registerForContextMenu(list);
		//Toast.makeText(this, "Count "+db.countRecords(), Toast.LENGTH_SHORT).show();  

	}
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.all_passwords, menu);
		return true;
	}
   @Override
	public boolean onOptionsItemSelected(MenuItem item) {
	   if(item.getItemId()==R.id.action_add)
	   {
		  Intent i=new Intent(this,AddItemActivity.class); 
		  startActivity(i);
	   }
		return super.onOptionsItemSelected(item);
	}
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
    			ContextMenuInfo menuInfo) {
    		// TODO Auto-generated method stub
    	getMenuInflater().inflate(R.menu.context_menu, menu);
    		super.onCreateContextMenu(menu, v, menuInfo);
    	}
    @Override
    	public boolean onContextItemSelected(MenuItem item) {
    		// TODO Auto-generated method stub
    	   AdapterContextMenuInfo info=(AdapterContextMenuInfo) item.getMenuInfo();
    	   int position=info.position;
    	   Movie x=data.get(position);
    	   if(item.getItemId()==R.id.delete_item)
    	   {
    		 db.deleteOneItem(x.getId());
    		 data.remove(position);
    		 adapter.notifyDataSetChanged();
    	   }
    	   else if(item.getItemId()==R.id.edit_item)
    	   {
    		 //TODO Edit The Item Here
    		   
    	   }
    	   
    	   return super.onContextItemSelected(item);
    	}
}
