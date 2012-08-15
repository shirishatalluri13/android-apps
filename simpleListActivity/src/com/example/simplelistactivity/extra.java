package com.example.simplelistactivity;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

public class extra extends Activity{
	MediaPlayer mymediaplayer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Toast.makeText(this, "extra activity",Toast.LENGTH_SHORT).show();
		mymediaplayer = new MediaPlayer();// instantiate an object
		try {
			AssetManager am = this.getAssets();
			AssetFileDescriptor afd = am.openFd("dogsound.ogg");
			mymediaplayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
			mymediaplayer.prepare();//blocks until media player is ready for playback
			mymediaplayer.setLooping(true);
			
		}catch(IOException e){
			
		}
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(mymediaplayer!=null){
			mymediaplayer.start();
		}
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if(mymediaplayer!=null){
			mymediaplayer.pause();
			if(isFinishing()){
				mymediaplayer.reset();
				mymediaplayer.release();
			}
		}
	}
	
	
	

}
