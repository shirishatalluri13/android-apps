package com.example.listview;


import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

 
public class ListviewActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	public String status="";
	public void onClick(View v){

		Log.d("something clicked","a log val");
		switch(v.getId()){
		
		case R.id.toggleButton1:
			if(((ToggleButton)v.findViewById(R.id.toggleButton1)).isChecked())
			Toast.makeText(getApplicationContext(), "tube on", Toast.LENGTH_SHORT).show();
		break;
			
		
		case R.id.toggleButton2 :
			if(((ToggleButton)v.findViewById(R.id.toggleButton2)).isChecked())
				Toast.makeText(getApplicationContext(), "fan on", Toast.LENGTH_SHORT).show();
			break;
		case R.id.toggleButton3 :
			if(((ToggleButton)v.findViewById(R.id.toggleButton3)).isChecked())
				Toast.makeText(getApplicationContext(), "laptop on", Toast.LENGTH_SHORT).show();
			break;
		case R.id.button1 :
			status="#";
			Log.d("sending string","syncing");
			Toast.makeText(getApplicationContext(), " SYNCING ", Toast.LENGTH_SHORT).show();
			if(((ToggleButton)super.findViewById(R.id.toggleButton1)).isChecked())
				status+="1";
			else
				status+="0";
			
			if(((ToggleButton)super.findViewById(R.id.toggleButton2)).isChecked())
				status+="1";
			else
				status+="0";
			if(((ToggleButton)super.findViewById(R.id.toggleButton3)).isChecked())
				status+="1";
			else
				status+="0";
			status+="#";
			sendSMS("9428319372",status);
			Toast.makeText(getApplicationContext(), " Message sent to module ", Toast.LENGTH_SHORT).show();
			//((ToggleButton)super.findViewById(R.id.toggleButton2)).setChecked(true);
			//((ToggleButton)super.findViewById(R.id.toggleButton3)).setChecked(true);
			
			break;
		}
		
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
     
        ToggleButton tb1 = (ToggleButton) findViewById(R.id.toggleButton1);
        ToggleButton tb2 = (ToggleButton) findViewById(R.id.toggleButton2);
        ToggleButton tb3 = (ToggleButton) findViewById(R.id.toggleButton3);
        Button b = (Button) findViewById(R.id.button1);
        tb1.setOnClickListener(this);
        tb2.setOnClickListener(this);
        tb3.setOnClickListener(this);
        b.setOnClickListener(this);

    }
	private void sendSMS(String phoneNumber, String message)
    {        
		Log.d("entry","into the sendSMS");
	   
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message,null, null);        
    }    
}