package com.android.newbostonapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class NewbostonActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button b = (Button)findViewById(R.id.openmenubutton);
        Button bfinalsendbutton = (Button)findViewById(R.id.bfinalsend);
        b.setOnClickListener(this);
        bfinalsendbutton.setOnClickListener(this);
        
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
		switch(v.getId()){
			case R.id.openmenubutton :	
				//check network connectivity
				if(isNetworkAvailable()==false){
					Toast.makeText(getApplicationContext(), "no network connection", Toast.LENGTH_SHORT).show();
					break;
				}
				
				//send syn
				
				
				//get acknowledgement
				
				//see the status of the rooms and edit them
				
				//finally open menu
				Intent openmenu = new Intent("com.android.newbostonapp.MENU");
				startActivity(openmenu);
				break;
	
			case R.id.bfinalsend :
				    globalvariable appstate = ((globalvariable)getApplicationContext());
					Toast.makeText(getApplicationContext(),appstate.status,Toast.LENGTH_SHORT).show();
					break;
			default :
						break;
		}
	}
	
    public void onpause(){
    	super.onPause();
    }
   
    public boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        // if no network is available networkInfo will be null, otherwise check if we are connected
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }
    
}