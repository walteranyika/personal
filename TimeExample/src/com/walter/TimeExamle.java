package com.walter;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeExamle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Long time = 1441855615L;        
		System.out.println(convertTime(time));
	}
	public static String convertTime(long time){
	    Date date = new Date(time*1000);
	    Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
	    return format.format(date);
	}
   //to call the function
	//Long time = 1441855615L;        
	//System.out.println(convertTime(time));
}
