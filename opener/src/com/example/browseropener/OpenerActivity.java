package com.example.browseropener;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpenerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
    
    }
    
    public void onClick(View v){
    	
    	Button b1 = (Button)findViewById(R.id.button1);
    	Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.vogella.de"));
    	startActivity(i);
       }
}