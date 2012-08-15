package com.android.smslightcontrol;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class NewbostonActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    
	String line;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button b = (Button)findViewById(R.id.openmenubutton);
        Button bfinalsendbutton = (Button)findViewById(R.id.bfinalsend);
       // Button bconfigure = (Button)findViewById(R.id.bconfigure);
        b.setOnClickListener(this);
        bfinalsendbutton.setOnClickListener(this);
       // bconfigure.setOnClickListener(this);

        initializelightstates();
	
	}

	private void initializelightstates() {
		// TODO Auto-generated method stub
		
				
		//see the status of the rooms and edit them
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		if(!prefs.getBoolean("firstTime", false)) {
		    // run your one time code
			Log.d("smslightcontrol","looks like first time install");
			((globalvariable)getApplicationContext()).status=new char[]{'0','#','0','0','0','#','0','0','0','#','0','0','0'};
			String str1 = new String(((globalvariable)getApplicationContext()).status);
			Log.d("smslightcontrol",str1);
			try {
				FileOutputStream fos = openFileOutput(((globalvariable)getApplicationContext()).FILENAME, Context.MODE_PRIVATE);

				try {
					fos.write(str1.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			SharedPreferences.Editor editor = prefs.edit();
		    editor.putBoolean("firstTime", true);
		    editor.commit();
		}else{
			//app already installed so
			//read from file
		try {
		
			BufferedReader input = new BufferedReader(new InputStreamReader(
					openFileInput(((globalvariable)getApplicationContext()).FILENAME)));
			
			line=input.readLine();
			Toast.makeText(this, line,Toast.LENGTH_SHORT).show();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.d("smslightcontrol","found line");
		Log.d("smslightcontrol",line);
		
		((globalvariable)getApplicationContext()).status[2]=line.charAt(2);

		((globalvariable)getApplicationContext()).status[3]=line.charAt(3);

		((globalvariable)getApplicationContext()).status[4]=line.charAt(4);

		((globalvariable)getApplicationContext()).status[6]=line.charAt(6);

		((globalvariable)getApplicationContext()).status[7]=line.charAt(7);

		((globalvariable)getApplicationContext()).status[8]=line.charAt(8);

		((globalvariable)getApplicationContext()).status[10]=line.charAt(10);

		((globalvariable)getApplicationContext()).status[11]=line.charAt(11);

		((globalvariable)getApplicationContext()).status[12]=line.charAt(12);
		
		}//not opened for first time
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
		switch(v.getId()){
			case R.id.openmenubutton :	
				
				//check network connectivity
//				if(isNetworkAvailable()==false){
	//				Toast.makeText(getApplicationContext(), "no network connection", Toast.LENGTH_SHORT).show();
		//			break;
		//		}
				
				Log.d("smslightcontrol","network connection OK");
				
				//finally open menu
				Intent openmenu = new Intent("com.android.smslightcontrol.MENU");
				startActivity(openmenu);
				break;
	
		case R.id.bfinalsend :
				    String str=new String(((globalvariable)getApplicationContext()).status);
				    Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
				    sendSMS("+919429126843",str);
					break;
//			case R.id.bconfigure :
//					Intent openconfigure = new Intent("com.android.smslightcontrol.ADDCONFIG");
//					startActivity(openconfigure);
//					break;
			default :	
						break;
		}
	}
	
    public void onpause(){
    	super.onPause();
	/*	try {
			FileOutputStream fos = openFileOutput(((globalvariable)getApplicationContext()).FILENAME, Context.MODE_PRIVATE);

			try {
				String str1= new String(((globalvariable)getApplicationContext()).status);
				fos.write(str1.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d("smscontrolapp","write complete");
		Log.d("smscontrolapp",((globalvariable)getApplicationContext()).status.toString());
    */
    }

    
    
    @Override
	protected void onDestroy() {  //store to file before destroying the app
		// TODO Auto-generated method stub
		super.onDestroy();
		try {
			FileOutputStream fos = openFileOutput(((globalvariable)getApplicationContext()).FILENAME, Context.MODE_PRIVATE);

			try {
				String str1= new String(((globalvariable)getApplicationContext()).status);
				fos.write(str1.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d("smslightcontrol","write complete");
		Log.d("smslightcontrol",((globalvariable)getApplicationContext()).status.toString());
	}

	public boolean isNetworkAvailable() {
		Log.d("smscontrolapp","looking for network connection");
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        // if no network is available networkInfo will be null, otherwise check if we are connected
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }
	
	private void sendSMS(String phoneNumber, String message)
    {        
		Log.d("smslightcontrol","into the sendSMS");
	   
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message,null, null);        
    }    
    
}