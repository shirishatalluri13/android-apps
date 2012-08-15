package de.vogella.android.alarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlarmvogellaActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	
	Button counter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        counter = (Button)findViewById(R.id.button1);
        counter.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		EditText text=(EditText)findViewById(R.id.editText1);
		int i = Integer.parseInt(text.getText().toString());
		Intent intent= new Intent(this,MyBroadcastReceiver.class);
		PendingIntent pendingintent = PendingIntent.getBroadcast(this.getApplicationContext(), 34234234, intent, 0);
		AlarmManager alarmmanager = (AlarmManager)getSystemService(ALARM_SERVICE);
		alarmmanager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(i*1000), pendingintent);
		Toast.makeText(this, "alarm set in "+ i + "seconds", Toast.LENGTH_SHORT).show();
	}
}