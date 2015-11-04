package com.walter.doubletable;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database  extends SQLiteOpenHelper{

	public Database(Context context) 
	{
		super(context, "college", null, 1);		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		/*String students_tbl="CREATE TABLE IF NOT EXISTS students " +
							"(id INTEGER PRIMARY KEY AUTOINCREMENT," +
							" names TEXT NOT NULL, " +
							" email TEXT NOT NULL, " +
							" phone TEXT NOT NULL)";
		
		String scores_tbl ="CREATE TABLE IF NOT EXISTS cats (  " +
							" cid INTEGER PRIMARY KEY AUTOINCREMENT,  " +
							" student_id INTEGER NOT NULL,  " +
							" score INTEGER NOT NULL,  " +
							" date date NOT NULL)";
		
		db.execSQL(students_tbl);
		db.execSQL(scores_tbl);*/
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2)
	{
		/*String drop_students="DROP TABLE IF EXISTS students";
		String drop_scores="DROP TABLE IF EXISTS cats";
		db.execSQL(drop_students);
		db.execSQL(drop_scores);*/
	}
    public void insert_student(String names,String email,String phone) {
       /* SQLiteDatabase database = this.getWritableDatabase();        
        ContentValues values = new ContentValues();
        values.put("names",names);
        values.put("email", email);
        values.put("phone", phone);
        database.insert("students", null, values);
        database.close();*/
    }
    public void insert_cat(String student_id,String score,String date) {
        /*SQLiteDatabase database = this.getWritableDatabase();        
        ContentValues values = new ContentValues();
        values.put("student_id",student_id);
        values.put("score", score);
        values.put("date", date);
        database.insert("cats", null, values);
        database.close();*/
    }
    public ArrayList<Student> getAllStudents() 
    {
       /* ArrayList<Student>  table_students_array =new ArrayList<Student> ();
        String selectQuery = "SELECT  * FROM students";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {     
	            	String id=cursor.getString(0);//id 
	            	String names=cursor.getString(1);//names 
	            	String email=cursor.getString(2);//email
	            	String phone=cursor.getString(3);//phone  
	            	Student u=new Student();
	            	u.setId(id);
	            	u.setNames(names);
	            	u.setEmail(email);
	            	u.setPhone(phone);	            	
		            table_students_array.add(u);            	
               } 
              while (cursor.moveToNext());
        }
        database.close();
        return table_students_array;
        */
    }
    public ArrayList<Scores> getAllScores() 
    {
       /* ArrayList<Scores>  scores_array =new ArrayList<Scores> ();
        String selectQuery = "SELECT  names, score, date FROM students INNER JOIN cats ON students.id =cats.student_id";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {     
	            	String names=cursor.getString(0);
	            	String score=cursor.getString(1); 
	            	String date=cursor.getString(2);
	            	
                    Scores s=new Scores();  
                    s.setStudent_name(names);
                    s.setDate(date);
                    s.setScore(score);
                    scores_array.add(s);
               } 
              while (cursor.moveToNext());
        }
        database.close();
        return scores_array;*/
    }
    public int count_students()
    {
        /*int count = 0;
        String selectQuery = "SELECT  * FROM students";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        count = cursor.getCount();
        database.close();
        return count;*/
    }   
    public int count_scores()
    {
       /* int count = 0;
        String selectQuery = "SELECT  * FROM cats";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        count = cursor.getCount();
        database.close();
        return count;*/
    }

}
