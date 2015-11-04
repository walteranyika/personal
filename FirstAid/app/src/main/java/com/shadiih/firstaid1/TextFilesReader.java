package com.shadiih.firstaid1;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;

public class TextFilesReader {

	Context g;//borrowing from main activity
	
	//constructor
	public TextFilesReader(Context c){
		this.g = c;
		
	}

	
	public String readTxt(String a) throws IOException{
		   
		   
		   //g.getResources to get resources and combine with assets
		  // InputStream reads
	    //InputStream inputStream = g.getResources().openRawResource(R.raw.hym1);
	    InputStream inputStream = g.getResources().getAssets().open(a);//using a than specific txt will print any file u provide
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		     
		     int i;
		  try {
		   i = inputStream.read();
		   while (i != -1)
		      {
		       byteArrayOutputStream.write(i);
		       i = inputStream.read();
		      }
		      inputStream.close();
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  
		     return byteArrayOutputStream.toString();
		    }	
	
	public String ReadFromfile(String fileName) {
	    StringBuilder returnString = new StringBuilder();
	    InputStream fIn = null;
	    InputStreamReader isr = null;
	    BufferedReader input = null;
	    try {
	        fIn =g.getResources().getAssets()
	                .open(fileName, Context.MODE_WORLD_READABLE);
	        isr = new InputStreamReader(fIn);
	        input = new BufferedReader(isr);
	        String line = "";
	        while ((line = input.readLine()) != null) {
	            returnString.append(line);
	        }
	    } catch (Exception e) {
	        e.getMessage();
	    } finally {
	        try {
	            if (isr != null)
	                isr.close();
	            if (fIn != null)
	                fIn.close();
	            if (input != null)
	                input.close();
	        } catch (Exception e2) {
	            e2.getMessage();
	        }
	    }
	    return returnString.toString();
	}
}
