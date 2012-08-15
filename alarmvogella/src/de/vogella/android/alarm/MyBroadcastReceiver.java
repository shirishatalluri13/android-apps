package de.vogella.android.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		
		Toast.makeText(context, "your time is up , man!", Toast.LENGTH_SHORT).show();
		Vibrator vib = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
		vib.vibrate(2000);
	}

}
