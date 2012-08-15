package com.example.appconfigtries;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class afterconf extends Activity implements OnClickListener{
    int i;
	String s,filename;
	Button[] btarr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		
		super.onCreate(savedInstanceState);
		Log.d("tryapp","intent call successful");
		Bundle extras = getIntent().getExtras();
	
		if (extras == null) {//if no extras are passed
			Log.d("tryapp", "bundle empty");
			//read file to get no.
			try {
				
				BufferedReader input = new BufferedReader(new InputStreamReader(
						openFileInput("config")));
				
				s=input.readLine();
				Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
			
				input.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{//get input from extra bundle
			s = extras.getString("no");
		}
			if(s==null){
				Log.d("tryapp","string empty");
			}
			i=Integer.parseInt(s);
			setContentView(R.layout.main);
			adddynamicbuttons(i);
	}

	private void adddynamicbuttons(int i) {
		Log.d("tryapp","entered dynamic function");
		btarr = new Button[i];
		LinearLayout container = (LinearLayout)findViewById(R.id.layoutId);
		for(int k=0;k<i;k++){
			btarr[k]=new Button(this);
			btarr[k].setOnClickListener(this);
			btarr[k].setText("room"+(k+1));
			container.addView(btarr[k]);
		}
			Log.d("tryapp","exiting dynamic function");
	}

	@Override
	public void onClick(View v) {
		int k;
		for(k=0;k<i;k++){
		if(((Button)v).getId()==btarr[k].getId())
			break;
		}
		Intent i = new Intent(this,com.example.appconfigtries.AppconfigtriesActivity.class);
		i.putExtra("filename",Integer.toString(k) );
		startActivity(i);
	}

}
