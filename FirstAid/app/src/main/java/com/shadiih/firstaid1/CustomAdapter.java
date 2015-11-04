package com.shadiih.firstaid1;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomAdapter  extends BaseAdapter {
	private ArrayList<FirstAidIconsItems> data;
	private Context context;
		public CustomAdapter(Context context,ArrayList<FirstAidIconsItems> data)
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
		// change arg2 to convertView, arg3 to parent
		
		View v=convertView;
		if (v==null) {
			LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v=inflater.inflate(R.layout.row_first_aid_layout1, null);
		}
		TextView tvTitle=(TextView)v.findViewById(R.id.textViewFirstAid);
		ImageView imgPic=(ImageView)v.findViewById(R.id.imageView1);
		FirstAidIconsItems item=data.get(position);
		//u can add more textviews here if u have them
		tvTitle.setText(item.getTitle());
		imgPic.setImageResource(item.getPoster());
		return v;
	}

}

