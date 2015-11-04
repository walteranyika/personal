package com.walter.onlineexample;


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
        super(applicationcontext, "students.db", null, 1);
    }
    //Creates Table
    @Override
    public void onCreate(SQLiteDatabase database) {
        String query;
        query = "CREATE TABLE table_students ( SID INTEGER PRIMARY KEY, sName TEXT,sEmail TEXT, sPhone TEXT, sCourse TEXT)";
        database.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
        String query;
        query = "DROP TABLE IF EXISTS table_students";
        database.execSQL(query);
        onCreate(database);
    }
    /**
     * Inserts User into SQLite DB
     * @param queryValues
     */
    public void insert(String name,String email,String phone,String course) {
        SQLiteDatabase database = this.getWritableDatabase();        
        ContentValues values = new ContentValues();
        values.put("sName",name);
        values.put("sEmail", email);
        values.put("sPhone", phone);
        values.put("sCourse", course);
        database.insert("table_students", null, values);
        database.close();
    }
     /**
     * Get list of table_passwords from SQLite DB as Array List
     * @return
     */
    public ArrayList<Student> getAllStudents() 
    {
        ArrayList<Student>  table_students_array;
        table_students_array = new ArrayList<Student> ();
        String selectQuery = "SELECT  * FROM table_students";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {     
	            	String id=cursor.getString(0);//id 
	            	String names=cursor.getString(1);//names 
	            	String email=cursor.getString(2);//email
	            	String phone=cursor.getString(3);//phone 
	            	String course=cursor.getString(4);//course
	            	Student u=new Student(id,names,email,phone,course);	
		            table_students_array.add(u);            	
               } while (cursor.moveToNext());
        }
        database.close();
        return table_students_array;
    }
     
    /**
     * 
     * @param Returns one user fetched from db
     * @return
     */
    public Student getOneItem(String id)
    {
    	Student u=null;
        String selectQuery = "SELECT  * FROM table_students WHERE SID='"+id+"'";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) 
        {  
           u=new Student(  cursor.getString(0),
		        		   cursor.getString(1),
		        		   cursor.getString(2),
		        		   cursor.getString(3),
		        		   cursor.getString(4));
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
        String selectQuery = "SELECT  * FROM table_students";
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
        String updateQuery = "DELETE  FROM table_students WHERE SID='"+id+"'";
        Log.d("query",updateQuery);       
        database.execSQL(updateQuery);
        database.close();
    	
    }
    //Dele all records from table_passwords table
    public void deleteEverything()
    {
        SQLiteDatabase database = this.getWritableDatabase();    
        String updateQuery = "DELETE  FROM table_students WHERE 1";
        Log.d("query",updateQuery);       
        database.execSQL(updateQuery);
        database.close();
    	
    }
    
    
    
}









