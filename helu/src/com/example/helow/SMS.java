package com.example.helow;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
public class SMS extends Activity implements OnClickListener {
	private static final String OFBUT="off";
	
	
	/** Called when the activity is first created. */
	 public void onClick(View v) {
	    if(((Button)v.findViewById(R.id.button1)).getText()=="ON"){
        	 ((Button)v.findViewById(R.id.button1)).setText("OFF");
        	 ((Button)v.findViewById(R.id.button1)).getBackground().setColorFilter(0xFFFF0000,PorterDuff.Mode.MULTIPLY);
        	 Toast.makeText(getApplicationContext(), "bandh thai gayu!", Toast.LENGTH_SHORT).show();                    
             
         }else{
        	 
        	((Button)v.findViewById(R.id.button1)).setText("ON"); 
        	((Button)v.findViewById(R.id.button1)).getBackground().setColorFilter(0xFF00FF00,PorterDuff.Mode.MULTIPLY);
       	 
        	Toast.makeText(getApplicationContext(), "chaalu thai gayu!", Toast.LENGTH_SHORT).show();                    
         }
	    	// do something when the button is clicked
	    
	 }
	@Override
    public void onCreate(Bundle savedInstanceState) {
    	 super.onCreate(savedInstanceState);
         setContentView(R.layout.main);
         Button btnSendSMS = (Button) findViewById(R.id.button1);
         btnSendSMS.setOnClickListener(this); 
     }
    
        
}