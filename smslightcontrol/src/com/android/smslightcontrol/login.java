package com.android.smslightcontrol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends Activity implements OnClickListener{

	Button blogin;
	EditText etname,etpassword;
	final String name="project";
	final String password="project";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
	
		
		etname = (EditText)findViewById(R.id.loginet1);
		etpassword = (EditText)findViewById(R.id.loginet2);
		blogin = (Button)findViewById(R.id.loginb1);
		blogin.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Log.d("something clicked","inside onclicke");
		// TODO Auto-generated method stub
		String n=etname.getText().toString();
		String p=etpassword.getText().toString();
		//check for user name and password
		if(n.equals(name)){
			if(p.equals(password)){
				Log.d("something clicked","------CALLING INTENT-----------");
				Intent i= new Intent("com.android.smslightcontrol.NEWBOSTONACTIVITY");
				startActivity(i);
			}else{
				Toast.makeText(this, "Authentication Failure", Toast.LENGTH_LONG).show();
			}
		}else{
			Toast.makeText(this,"Authentication Failure", Toast.LENGTH_LONG).show();
		}
	}
	

}
