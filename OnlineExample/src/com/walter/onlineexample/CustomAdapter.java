package com.walter.onlineexample;
import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter  extends BaseAdapter{
 private ArrayList<Student>  data;
 private Context context;
    //constructor
     public CustomAdapter(Context context , ArrayList<Student>  data)
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
        TextView tvNames=(TextView) v.findViewById(R.id.tvNames);
        TextView tvEmail=(TextView) v.findViewById(R.id.tvEmail);
        TextView tvPhone=(TextView) v.findViewById(R.id.tvPhone);
        TextView tvCourse=(TextView) v.findViewById(R.id.tvCourse);
        
        Student i=data.get(position);
        tvNames.setText(i.getNames());
        tvEmail.setText(i.getEmail());
        tvPhone.setText(i.getPhone());
        tvCourse.setText(i.getCourse());        
		return v;
	}

}









