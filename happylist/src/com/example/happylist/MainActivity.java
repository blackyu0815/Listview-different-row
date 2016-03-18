package com.example.happylist;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	ListView listView;
	TextView tv1;
	//MyAdapter myAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView)findViewById(R.id.list);
		tv1 = (TextView)findViewById(R.id.tv1);
		listView.setAdapter(new MyAdapter(this));
	}
	
	public void ChangeWord(String command) {
		// TODO Auto-generated method stub
		tv1.setText(command);
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.e("List", "onPause called");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.e("List", "onStop called");
	}
	
}
