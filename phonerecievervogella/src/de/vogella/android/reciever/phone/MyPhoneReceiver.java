package de.vogella.android.reciever.phone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyPhoneReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context c, Intent i) {
		// TODO Auto-generated method stub
		Bundle extras=i.getExtras();
		if(extras!=null){
			String state = extras.getString(TelephonyManager.EXTRA_STATE);
			Log.w("DEBUG",state);
			if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
				String phonenumber=extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
				Log.w("DEBUG",phonenumber);
			}
		}
	}

	
}
