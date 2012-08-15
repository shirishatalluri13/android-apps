package com.example.appconfigtries;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AppconfigtriesActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	String filename;
	Button b;
	EditText e;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conf);
        b=(Button)findViewById(R.id.button1);
        e=(EditText)findViewById(R.id.editText1);
        b.setOnClickListener(this);
        Bundle extras=getIntent().getExtras();
        filename = extras.getString("filename");
        Toast.makeText(this, "filename :"+filename ,Toast.LENGTH_SHORT).show();
    }
	
	@Override
	public void onClick(View v) {
		 String s = e.getText().toString();
	    try {
			FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
			try {
				fos.write(s.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

/*		SharedPreferences.Editor editor = prefs.edit();
	    editor.putBoolean("firstTime", true);
	    editor.commit();
	
	*/
		Intent i = new Intent(this,com.example.appconfigtries.afterconf.class);
		i.putExtra("no",e.getText().toString());
		
		startActivity(i);	
		
	}
}