package com.walter.pikipiki.model;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

	private static final int VERSION = 3;
	private static final String DB_NAME = "pikipiki";
	private static final String UID = "uid";
	private static final String REG_NO = "reg_no";
	private static final String OWNER_NAMES = "owner_names";
	private static final String OWNER_ID = "owner_id";
	private static final String DRIVER_NAMES = "driver_names";
	private static final String DRIVER_ID = "driver_id";
	private static final String REG_DATE = "reg_date";
	private static final String AREA = "area";
	private static final String OWNER_PHONE = "owner_phone";
	private static final String TABLE = "bikes";
	public Database(Context context) {
		super(context, DB_NAME, null, VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql =    "CREATE TABLE IF NOT EXISTS bikes "
						+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
						+ " uid TEXT NOT NULL, "
						+ " reg_no TEXT NOT NULL, "
						+ " owner_names TEXT NOT NULL, "
						+ " owner_id TEXT NOT NULL, "
						+ " driver_names TEXT NOT NULL, "
						+ " driver_id TEXT NOT NULL, "
						+ " reg_date TEXT NOT NULL, "
						+ " area TEXT NOT NULL, " 
						+ " owner_phone TEXT NOT NULL, " +
						" UNIQUE (uid) ON CONFLICT REPLACE )";
		db.execSQL(sql);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = "DROP TABLE IF EXISTS bikes";
		db.execSQL(sql);
		String sql2 =    "CREATE TABLE IF NOT EXISTS bikes "
				+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " uid TEXT NOT NULL, "
				+ " reg_no TEXT NOT NULL, "
				+ " owner_names TEXT NOT NULL, "
				+ " owner_id TEXT NOT NULL, "
				+ " driver_names TEXT NOT NULL, "
				+ " driver_id TEXT NOT NULL, "
				+ " reg_date TEXT NOT NULL, "
				+ " area TEXT NOT NULL, " 
				+ " owner_phone TEXT NOT NULL," +
				" UNIQUE (uid) ON CONFLICT REPLACE )";
       db.execSQL(sql2);
	}
	public void insertBike(MotorBike bike) {
			SQLiteDatabase db = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put(UID, bike.getUid());
			values.put(REG_NO, bike.getRegNo());
			values.put(OWNER_NAMES, bike.getOwnerNames());
			values.put(OWNER_ID, bike.getOwnerId());
			values.put(DRIVER_NAMES, bike.getDriverNames());
			values.put(DRIVER_ID, bike.getDriverId());
			values.put(REG_DATE, bike.getRegDate());
			values.put(AREA, bike.getArea());
			values.put(OWNER_PHONE, bike.getPhone());
			db.insert(TABLE, null, values);
			db.close();
	}
	public ArrayList<MotorBike> searcBike(String regNo)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ArrayList<MotorBike> data=new ArrayList<MotorBike>();
		Cursor cursor=db.rawQuery("SELECT * FROM bikes WHERE reg_no LIKE '"+regNo+"'", null);
		if(cursor.moveToFirst())
		{
			do{
			 String uid=cursor.getString(1);
			 String regNo_=cursor.getString(2);
			 String ownerNames=cursor.getString(3);
			 String ownerId=cursor.getString(4);
			 String driverNames=cursor.getString(5);
			 String driverId=cursor.getString(6);
			 String regDate=cursor.getString(7);
			 String area=cursor.getString(8);
			 String phone=cursor.getString(9);
			 MotorBike bike =new MotorBike(uid, regNo_, ownerNames, ownerId, driverNames, driverId, regDate, area, phone);
			 data.add(bike);
			}while(cursor.moveToNext());
			 return data;
		}
		return null;
	}
	public String getLastID()
	{
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor=db.rawQuery("SELECT uid FROM bikes ORDER BY id DESC LIMIT 1", null);
		if(cursor.moveToFirst())
		{
			 String uid=cursor.getString(0);
             return uid;
		}
		return "";
	}
    public int countRecords()
    {
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor=db.rawQuery("SELECT uid FROM bikes", null);
		return cursor.getCount();	
    }

    
}
