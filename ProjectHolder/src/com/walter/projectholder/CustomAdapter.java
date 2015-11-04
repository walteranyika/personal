package com.walter.projectholder;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	Context mContext;
	ArrayList<Movie> data;

	public CustomAdapter(Context context, ArrayList<Movie> data) {
		this.mContext = context;
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
	public long getItemId(int id) {
		return id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if(convertView==null)
		{
		  LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
		  convertView=inflater.inflate(R.layout.list_item_layout, parent,false);
		  viewHolder = new ViewHolder();
		  viewHolder.titleTextView =(TextView) convertView.findViewById(R.id.textViewTitle);
		  viewHolder.genreTextView =(TextView) convertView.findViewById(R.id.textViewGenre);
		  viewHolder.imageView=(ImageView)convertView.findViewById(R.id.imageViewPoster);
		  convertView.setTag(viewHolder);
		}else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Movie movie = data.get(position);
		viewHolder.titleTextView.setText(movie.getTitle());
		viewHolder.genreTextView.setText(movie.getGenre());
		viewHolder.imageView.setImageResource(movie.getImage());
		
		return convertView;
	}

	static class ViewHolder {
		TextView titleTextView;
		TextView genreTextView;
		ImageView imageView;
	}

}
