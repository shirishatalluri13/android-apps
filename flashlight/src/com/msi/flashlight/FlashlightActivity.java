package com.msi.flashlight;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class FlashlightActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TextView tv = new TextView(this);
        //tv.setText("hello Jedi");
        //s/etContentView(tv);
        setContentView(R.layout.main);
    }
}