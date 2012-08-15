package com.android.newbostonapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Menu extends ListActivity {

	String classes[]={"room1","room2","room3","status","exit"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1,classes));
	
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		
		super.onListItemClick(l, v, position, id);
		
		String cheese = classes[position];
		
		Class ourClass;
		try {
			ourClass = Class.forName("com.android.newbostonapp."+cheese);
			Toast.makeText(this,"com.android.newbostonapp."+cheese, Toast.LENGTH_LONG).show();
			Intent ourIntent = new Intent(Menu.this,ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	

	
		
}
