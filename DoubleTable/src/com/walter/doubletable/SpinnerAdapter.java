package com.walter.doubletable;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SpinnerAdapter extends BaseAdapter {
	private ArrayList<Student> data;
	private Context context;

	public SpinnerAdapter(Context context, ArrayList<Student> data) {
		this.context = context;
		this.data = data;
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
	       	LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	       	v=inflater.inflate(R.layout.spinner_item_layout,null);        	
        }
		TextView tvTitle=(TextView)v.findViewById(R.id.spinner_item);
			
		Student p=data.get(position);
		tvTitle.setText(p.getNames());			

		return v;
	
	}

}
