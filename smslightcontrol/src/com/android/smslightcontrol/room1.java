package com.android.smslightcontrol;


import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class room1 extends Activity implements OnClickListener{

	ToggleButton tb1,tb2,tb3;
	Button syncbutton;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.room1layout);
		initbuttonsandviews();
	}

	private void initbuttonsandviews() {
		// this method binds buttons to variables and registers listeners
		tb1=(ToggleButton)findViewById(R.id.room1tb1);
		tb2=(ToggleButton)findViewById(R.id.room1tb2);
		tb3=(ToggleButton)findViewById(R.id.room1tb3);
		syncbutton=(Button)findViewById(R.id.room1bsync);
		tb1.setOnClickListener(this);
		tb2.setOnClickListener(this);
		tb3.setOnClickListener(this);
		syncbutton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.d("something clicked"," in room 1");
switch(v.getId()){
		
		case R.id.room1tb1:
			if(((ToggleButton)v.findViewById(R.id.room1tb1)).isChecked())
			Toast.makeText(getApplicationContext(), "tube on", Toast.LENGTH_SHORT).show();
		break;
			
		
		case R.id.room1tb2 :
			if(((ToggleButton)v.findViewById(R.id.room1tb2)).isChecked())
				Toast.makeText(getApplicationContext(), "fan on", Toast.LENGTH_SHORT).show();
			break;
		case R.id.room1tb3 :
			if(((ToggleButton)v.findViewById(R.id.room1tb3)).isChecked())
				Toast.makeText(getApplicationContext(), "laptop on", Toast.LENGTH_SHORT).show();
			break;
		case R.id.room1bsync :
			String temp = "0#";
	//		((globalvariable)getApplicationContext()).status="#1";
			Log.d("sending string","syncing");
			Toast.makeText(getApplicationContext(), " SYNCING ", Toast.LENGTH_SHORT).show();
			if(((ToggleButton)super.findViewById(R.id.room1tb1)).isChecked())
				((globalvariable)getApplicationContext()).status[2]='1';
			else
				((globalvariable)getApplicationContext()).status[2]='0';
			
			if(((ToggleButton)super.findViewById(R.id.room1tb2)).isChecked())
				((globalvariable)getApplicationContext()).status[3]='1';
			else
				((globalvariable)getApplicationContext()).status[3]='0';
			if(((ToggleButton)super.findViewById(R.id.room1tb3)).isChecked())
				((globalvariable)getApplicationContext()).status[4]='1';
			else
				((globalvariable)getApplicationContext()).status[4]='0';
	//		((globalvariable)getApplicationContext()).status+="#"
	//		sendSMS("5554",((globalvariable)getApplicationContext()).status);
//			Toast.makeText(getApplicationContext(), " Message sent to module ", Toast.LENGTH_SHORT).show();
			//((ToggleButton)super.findViewById(R.id.toggleButton2)).setChecked(true);
			//((ToggleButton)super.findViewById(R.id.toggleButton3)).setChecked(true);
			
			break;
		}
		
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("smscontrolapp ","on resume of room1");
		char[] s=((globalvariable)getApplicationContext()).status;
		if(s[2]=='1'){
			tb1.setChecked(true);
		}else{
			tb1.setChecked(false);
		}
		if(s[3]=='1'){
			tb2.setChecked(true);
		}else{
			tb2.setChecked(false);
		}
		if(s[4]=='1'){
			tb3.setChecked(true);
		}else{
			tb3.setChecked(false);
		}
			
		
	}

	private void sendSMS(String phoneNumber, String message)
    {        
		Log.d("entry","into the sendSMS");
	   SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message,null, null);        
    }    
	
}
