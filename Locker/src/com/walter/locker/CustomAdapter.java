package com.walter.locker;



import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter  extends BaseAdapter{
 private ArrayList<Movie>  data;
 private Context context;
    //constructor
     public CustomAdapter(Context context , ArrayList<Movie> data)
     {
    	 this.data=data;
    	 this.context=context;
     }
    
	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
         View v=convertView;
         if(v == null)
         {
        	LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        	v=inflater.inflate(R.layout.row_layout,null);        	
         }
        TextView tvSite=(TextView) v.findViewById(R.id.textViewSite);
        TextView tvPassword=(TextView) v.findViewById(R.id.textViewPassword);
        
        Movie i=data.get(position);
        tvSite.setText(i.getSite());
        tvPassword.setText(i.getPassword());
        
		return v;
	}

}








