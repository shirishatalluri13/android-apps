package com.android.newbostonwallpaper;

import android.app.Activity;
import android.os.Bundle;

public class NewbostonwallpaperActivity extends Activity {
    /** Called when the activity is first created. */
    
	private static final String TAG = "MyActivity";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}