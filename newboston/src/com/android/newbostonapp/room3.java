package com.android.newbostonapp;


import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class room3 extends Activity implements OnClickListener{


	ToggleButton tb1,tb2,tb3;
	Button syncbutton;


	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.room3layout);
		initbuttonsandviews();
	}
	
	private void initbuttonsandviews() {
		// this method binds buttons to variables and registers listeners
		tb1=(ToggleButton)findViewById(R.id.room3tb1);
		tb2=(ToggleButton)findViewById(R.id.room3tb2);
		tb3=(ToggleButton)findViewById(R.id.room3tb3);
		syncbutton=(Button)findViewById(R.id.room3bsync);
		tb1.setOnClickListener(this);
		tb2.setOnClickListener(this);
		tb3.setOnClickListener(this);
		syncbutton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
switch(v.getId()){
		
		case R.id.room3tb1:
			if(((ToggleButton)v.findViewById(R.id.room3tb1)).isChecked())
			Toast.makeText(getApplicationContext(), "tube on", Toast.LENGTH_SHORT).show();
		break;
			
		
		case R.id.room3tb2 :
			if(((ToggleButton)v.findViewById(R.id.room3tb2)).isChecked())
				Toast.makeText(getApplicationContext(), "fan on", Toast.LENGTH_SHORT).show();
			break;
		case R.id.room3tb3 :
			if(((ToggleButton)v.findViewById(R.id.room3tb3)).isChecked())
				Toast.makeText(getApplicationContext(), "laptop on", Toast.LENGTH_SHORT).show();
			break;
		case R.id.room3bsync :
	//		((globalvariable)getApplicationContext()).status="#3";
			Log.d("sending string","syncing");
			Toast.makeText(getApplicationContext(), " SYNCING ", Toast.LENGTH_SHORT).show();
			if(((ToggleButton)super.findViewById(R.id.room3tb1)).isChecked())
				((globalvariable)getApplicationContext()).status+="1";
			else
				((globalvariable)getApplicationContext()).status+="0";
			
			if(((ToggleButton)super.findViewById(R.id.room3tb2)).isChecked())
				((globalvariable)getApplicationContext()).status+="1";
			else
				((globalvariable)getApplicationContext()).status+="0";
			if(((ToggleButton)super.findViewById(R.id.room3tb3)).isChecked())
				((globalvariable)getApplicationContext()).status+="1";
			else
				((globalvariable)getApplicationContext()).status+="0";
			((globalvariable)getApplicationContext()).status+="#";
	//		sendSMS("5554",((globalvariable)getApplicationContext()).status);
			Toast.makeText(getApplicationContext(), " Message sent to module ", Toast.LENGTH_SHORT).show();
			//((ToggleButton)super.findViewById(R.id.toggleButton2)).setChecked(true);
			//((ToggleButton)super.findViewById(R.id.toggleButton3)).setChecked(true);
			
			break;
		}
	}
	
protected void onstop(){
		
	}
	
	protected void onrestart(){
		
	}
	
	private void sendSMS(String phoneNumber, String message)
    {        
		Log.d("entry","into the sendSMS");
	   
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message,null, null);        
    }    

}
