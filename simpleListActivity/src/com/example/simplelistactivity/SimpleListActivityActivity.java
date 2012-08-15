package com.example.simplelistactivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SimpleListActivityActivity extends ListActivity {
    /** Called when the activity is first created. */
    
    String s[]={"anurag","jay","parth","deepak","extra","onemore","fullscreen","shapedrawable","exit"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,s));
               
       // setContentView(R.layout.main);
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String selstring = s[position];
		if(selstring.equalsIgnoreCase("exit")){
			this.finish();
			return ;
		}
		Class clazz;
		try {
			clazz = Class.forName("com.example.simplelistactivity."+selstring);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			Log.d("simplelistactivity","inside catch block");
			e.printStackTrace();
			clazz=null;
		}
		Toast.makeText(this, selstring, Toast.LENGTH_SHORT).show();
		Intent i = new Intent(this,clazz);
		startActivity(i);
	}
    
    
}