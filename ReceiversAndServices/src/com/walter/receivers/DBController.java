package com.walter.receivers;


import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
 
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
 
public class DBController  extends SQLiteOpenHelper {
	   //create a database called androidsqlite.db
   public DBController(Context applicationcontext) 
	{
	    super(applicationcontext, "test.db", null, 1);
	}
  @Override
   public void onCreate(SQLiteDatabase database) {
	    String query;
	    query = "CREATE TABLE table_test ( id INTEGER PRIMARY KEY, name TEXT)";
	    database.execSQL(query);
	}
    @Override
   public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
        String query;
        query = "DROP TABLE IF EXISTS table_test";
        database.execSQL(query);
        onCreate(database);
    }
   public void insert(String name) 
    {
        SQLiteDatabase database = this.getWritableDatabase();        
        ContentValues values = new ContentValues();
        values.put("name",name);
        database.insert("table_test", null, values);
        database.close();
    }
   public ArrayList<String> getAllData() 
    {
        ArrayList<String> data_array=new ArrayList<String> ();        
        String selectQuery = "SELECT  * FROM table_test";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) 
        {
            do { 	            	
	             String names=cursor.getString(1);//names 	            	
		         data_array.add(names);            	
               }
              while (cursor.moveToNext());
        }
        database.close();
        return data_array;
    }
   public int countRecords()
  {
        int count = 0;
        String selectQuery = "SELECT  * FROM table_test";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        count = cursor.getCount();
        database.close();
        return count;
    }
   public void deleteEverything()
    {
        SQLiteDatabase database = this.getWritableDatabase();    
        String updateQuery = "DELETE  FROM table_test WHERE 1";
        Log.d("query",updateQuery);       
        database.execSQL(updateQuery);
        database.close();
    	
    }
    
    
    
}









