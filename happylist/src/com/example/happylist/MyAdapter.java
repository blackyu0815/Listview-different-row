package com.example.happylist;

import java.util.ArrayList;
import java.util.TreeSet;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends BaseAdapter{
	Context c;
	LayoutInflater inflater;
	ArrayList<String> device_name; 
	TreeSet<Integer> mData2 = new TreeSet<Integer>(); 
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;
    private String[] arrtemp;
    int index = -1;
	public MyAdapter(Context c) {
		// TODO Auto-generated constructor stub
		this.c = c;
		inflater = LayoutInflater.from(c);
		device_name = new ArrayList<String>();
		addItem("Gender :");
		addItem("year:");
		addSeparatorsSet("Iphone");
		addSeparatorsSet("hTC");
		addSeparatorsSet("Sony");
		addSeparatorsSet("Asus");
		arrtemp = new String[device_name.size()];
	}
	public void addSeparatorsSet( final String item) {
		// TODO Auto-generated method stub
		device_name.add(item);
//--------save change view position-----------------//
		mData2.add(device_name.size()-1);
		notifyDataSetChanged();
	}
	public void addItem( final String item){
		device_name.add(item);
		notifyDataSetChanged();
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		//return super.getItemViewType(position);
		return mData2.contains(position)? TYPE_SEPARATOR : TYPE_ITEM;
	}
	
	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		//return super.getViewTypeCount();
		return 2;
	}		
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return device_name.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return device_name.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final ViewHolder holder;
		int type = getItemViewType(position);
		if(convertView == null){
			holder = new ViewHolder();
//-----------------------------------------------------------------------------------------------//
//------------------------Different list row-----------------------------------------------------//
			 switch (type) {
             case TYPE_ITEM:
            	 convertView = inflater.inflate(R.layout.listview_list, null);
            	 holder.textView1 = (TextView)convertView.findViewById(R.id.textview1);
            	 holder.editText1 = (EditText)convertView.findViewById(R.id.edittext1);
            	 holder.button = (Button)convertView.findViewById(R.id.bt_Enter);
            	 break;
             case TYPE_SEPARATOR:
            	 convertView = inflater.inflate(R.layout.listview_list2, null);
            	 holder.textView1 = (TextView)convertView.findViewById(R.id.device);
            	 holder.selectBtn = (RadioButton)convertView.findViewById(R.id.radio);
            	 break;
			 }
			convertView.setTag(holder);
			
		}
		else{
			holder = (ViewHolder)convertView.getTag();
		}
//------------------------Different list row-----------------------------------------------------//	
//-----------------------------------------------------------------------------------------------//		
		holder.textView1.setText(device_name.get(position));
		
		
//-----------------------------------------------------------------------------//		
//----------------------EditText-----------------------------------------------//	

		try{
		holder.editText1.setText(arrtemp[position]);
		holder.editText1.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				arrtemp[holder.ref] = s.toString();
			}
		});
		holder.button.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if( position < 2){
					//String command =  holder.editText1.getText().toString();
					Toast.makeText(c, holder.editText1.getText(), Toast.LENGTH_SHORT).show();
					//ChangeWord(command);
				}
				else{
					//Toast.makeText(getApplication(), "empty", Toast.LENGTH_SHORT).show();
					//String command =  "EMPTY";
					Toast.makeText(c, "empty", Toast.LENGTH_SHORT).show();
					//ChangeWord(command);
				}
			}
		});
		}catch(Exception e){
			Log.e("Happylist", " edittext not work");
		}

//----------------------EditText-----------------------------------------------//	
//-----------------------------------------------------------------------------//			
		
		
//-----------------------------------------------------------------------------//
//----------------------Radio Button-------------------------------------------//
		try{
		holder.selectBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(c, "You choice is¡G" + device_name.get(position),Toast.LENGTH_SHORT).show();
                index = position;
                notifyDataSetChanged();	
			}
		});
		if (index == position) {
            holder.selectBtn.setChecked(true);
        } else {
            holder.selectBtn.setChecked(false);
        }
	}catch(Exception e){
		Log.e("Happylist", "Radio btn not work");
	}
//----------------------Radio Button-------------------------------------------//	
//-----------------------------------------------------------------------------//		
		
		return convertView;
	}

	public class ViewHolder {
		TextView textView1;
		EditText editText1;
		Button button;
        RadioButton selectBtn;
		int ref;
	}

}
