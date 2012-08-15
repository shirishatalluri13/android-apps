package com.android.smslightcontrol;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class status extends Activity implements OnClickListener{

	Button finalsend;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.statuslayout);
		finalsend = (Button)findViewById(R.id.statusbfinalsend);
		finalsend.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "finalclicked",Toast.LENGTH_SHORT).show();
	}
	
	
}
