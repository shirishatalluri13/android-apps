package com.example.simplelistactivity;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class deepak extends Activity implements OnClickListener{

	int soundID=-1;
	SoundPool spool;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		this.setVolumeControlStream(am.STREAM_MUSIC); // tie music stream to this activity
		spool = new SoundPool(10,am.STREAM_MUSIC,0); //get a soundpool object for music stream
		soundID=spool.load(this, R.raw.dogsound, 1); //load sound into pool
		Button b = new Button(this);
		b.setText("bhau bhau");
		Log.d("simplelistactivity","going to call setcontentview");
		setContentView(b);
		b.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(soundID!=-1){
			spool.play(soundID, 1, 1, 0, 0, 1); // if loaded then play
		}
	}
	

}
