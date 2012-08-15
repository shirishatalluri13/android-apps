package com.examples.vogellatouch;

import android.app.Activity;
import android.os.Bundle;

public class VogellatouchActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TouchEventView(this,null));
    }
}