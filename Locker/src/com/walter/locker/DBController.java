package com.walter.locker;

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
        super(applicationcontext, "passwords.db", null, 1);
    }
    //Creates Table
    @Override
    public void onCreate(SQLiteDatabase database) {
        String query;
        query = "CREATE TABLE table_passwords ( passwordID INTEGER PRIMARY KEY, siteName TEXT,sitePassword TEXT,dateAdded TEXT)";
        database.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
        String query;
        query = "DROP TABLE IF EXISTS table_passwords";
        database.execSQL(query);
        onCreate(database);
    }
    /**
     * Inserts User into SQLite DB
     * @param queryValues
     */
    public void insert(String site_name,String site_password,String date_added) {
        SQLiteDatabase database = this.getWritableDatabase();        
        ContentValues values = new ContentValues();
        values.put("siteName", site_name);
        values.put("sitePassword", site_password);
        values.put("dateAdded", date_added);
        database.insert("table_passwords", null, values);
        database.close();
    }
     /**
     * Get list of table_passwords from SQLite DB as Array List
     * @return
     */
    public ArrayList<Movie> getAllPasswords() 
    {
        ArrayList<Movie> table_passwords_array;
        table_passwords_array = new ArrayList<Movie>();
        String selectQuery = "SELECT  * FROM table_passwords";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {               
	            	Movie u=new Movie(cursor.getString(0),
	            			        cursor.getString(1), 
	            			        cursor.getString(2),
	            			        cursor.getString(3));
	            	table_passwords_array.add(u);
            	
               } while (cursor.moveToNext());
        }
        database.close();
        return table_passwords_array;
    }
     
    /**
     * 
     * @param Returns one user fetched from db
     * @return
     */
    public Movie getOneItem(String id)
    {
        Movie u=null;
        String selectQuery = "SELECT  * FROM table_passwords WHERE passwordID='"+id+"'";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) 
        {  
           u=new Movie( cursor.getString(0),
	        		   cursor.getString(1),
	        		   cursor.getString(2),
	        		   cursor.getString(3));
        }
        database.close();
        return u;	
    }
    /**
     * Get SQLite records that are yet to be Synced
     * @return
     */
    public int countRecords()
    {
        int count = 0;
        String selectQuery = "SELECT  * FROM table_passwords";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        count = cursor.getCount();
        database.close();
        return count;
    }
     /**
     * Update User against each User ID
     * @param id
     * @param status
     */
    public void updateItem(String id, String siteName,String sitePassword,String dateAdded)
    {
    	//passwordID INTEGER PRIMARY KEY, siteName TEXT,sitePassword TEXT,dateAdded TEXT
        SQLiteDatabase database = this.getWritableDatabase();    
        String updateQuery = "Update table_passwords set siteName='"+siteName+"',sitePassword='"+sitePassword+"',dateAdded='"+dateAdded+"' WHERE  passwordID='"+id+"' ";
        Log.d("query",updateQuery);       
        database.execSQL(updateQuery);
        database.close();
    }
    //Deleting a user given a passwordID
    public void deleteOneItem(String id)
    {
        SQLiteDatabase database = this.getWritableDatabase();    
        String updateQuery = "DELETE  FROM table_passwords WHERE passwordID='"+id+"'";
        Log.d("query",updateQuery);       
        database.execSQL(updateQuery);
        database.close();
    	
    }
    //Dele all records from table_passwords table
    public void deleteEverything()
    {
        SQLiteDatabase database = this.getWritableDatabase();    
        String updateQuery = "DELETE  FROM table_passwords WHERE 1";
        Log.d("query",updateQuery);       
        database.execSQL(updateQuery);
        database.close();
    	
    }
    
    
    
}



