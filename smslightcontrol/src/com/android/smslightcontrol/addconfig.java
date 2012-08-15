package com.android.smslightcontrol;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addconfig extends Activity implements OnClickListener{

	Button bok = (Button)findViewById(R.id.bok);
	EditText et= (EditText)findViewById(R.id.et1);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configurelayout);
		bok.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String s = et.getText().toString();
		Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
	}
	
	

}
