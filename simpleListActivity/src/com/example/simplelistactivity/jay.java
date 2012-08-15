package com.example.simplelistactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import android.widget.Toast;

public class jay extends Activity implements OnKeyListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		TextView t = new TextView(this);
		t.setText("hello how are you:");
		t.setOnKeyListener(this);
		t.setFocusableInTouchMode(true);
		t.requestFocus();
		setContentView(t);
	}

	@Override
	public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
		// TODO Auto-generated method stub
		
		
		switch(arg2.getAction()){
		case KeyEvent.ACTION_DOWN :
			Toast.makeText(this,"recieved a key touch"+(char)arg2.getUnicodeChar(),Toast.LENGTH_SHORT).show();
			break;
		}
		return false;
	}
	
	

}
