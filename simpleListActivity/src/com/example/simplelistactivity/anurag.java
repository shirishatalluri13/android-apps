package com.example.simplelistactivity;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

public class anurag extends Activity implements SensorEventListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	
		SensorManager sem = (SensorManager)this.getSystemService(Context.SENSOR_SERVICE);
		boolean hasaccel = sem.getSensorList(Sensor.TYPE_ACCELEROMETER).size() > 0;
		if(hasaccel){
			Toast.makeText(this,"accelerometer present", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(this,"accelerometer absent", Toast.LENGTH_SHORT).show();
		}
		
		Sensor accelerometer=sem.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
		sem.registerListener(this, accelerometer,SensorManager.SENSOR_DELAY_GAME);
		
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
//		Toast.makeText(this,"onaccuracychanged called", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onSensorChanged(SensorEvent arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(this,"onaccuracychanged called"+arg0.values[0], Toast.LENGTH_SHORT).show();
	}
	
	

}
