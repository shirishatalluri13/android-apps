package com.example.appconfigtries;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class first extends Activity implements OnClickListener{
	
	Button b1,b2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.first);
		b1=(Button)findViewById(R.id.fb1);
		b2=(Button)findViewById(R.id.fb2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
			
	}

	@Override
	public void onClick(View v) {
		switch( v.getId()){
		case R.id.fb1 : 
				
				String s;
				Intent i = new Intent(this,com.example.appconfigtries.AppconfigtriesActivity.class);
				i.putExtra("filename", "config");
				startActivity(i);
			break;
		case R.id.fb2 :
			     
				Intent i2 = new Intent(this,com.example.appconfigtries.afterconf.class);
				i2.putExtra("filename", "config");
				startActivity(i2);
			break;
			
		}
		
	}
	
	

}
