package com.walter.pikipiki.adapters;

import java.util.ArrayList;

import com.walter.pikipiki.R;
import com.walter.pikipiki.model.MotorBike;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class CustomAdapter extends BaseAdapter {
	Context mContext;
	ArrayList<MotorBike> data;
	public CustomAdapter(Context context, ArrayList<MotorBike> data) {
		this.mContext = context;
		this.data = data;
	}
	@Override
	public int getCount() {
		return data.size();// # of items in your arraylist
	}
	@Override
	public Object getItem(int position) {
		return data.get(position);// get the actual movie
	}
	@Override
	public long getItemId(int id) {
		return id;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			convertView = inflater.inflate(R.layout.list_item_layout, parent,false);
			viewHolder = new ViewHolder();
			viewHolder.regTextView = (TextView) convertView.findViewById(R.id.textViewRegNo);
			viewHolder.ownerTextView = (TextView) convertView.findViewById(R.id.textViewOwner);
			viewHolder.driverTextView = (TextView) convertView.findViewById(R.id.textViewDriver);
			viewHolder.areaTextView = (TextView) convertView.findViewById(R.id.textViewArea);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
        MotorBike bike = data.get(position);
        viewHolder.ownerTextView.setText(bike.getOwnerNames());
        viewHolder.driverTextView.setText(bike.getDriverNames());
        viewHolder.regTextView.setText(bike.getRegNo());
        viewHolder.areaTextView.setText(bike.getArea());
		return convertView;
	}
	static class ViewHolder {
		TextView regTextView;
		TextView ownerTextView;
		TextView driverTextView;
		TextView areaTextView;
	}

}