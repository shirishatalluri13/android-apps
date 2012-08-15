package com.example.touchtry;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class TouchtryActivity extends Activity implements OnTouchListener{
    
	StringBuilder builder = new StringBuilder();
	TextView tv;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        tv = new TextView(this);
        tv.setText("Touch and drag(single finger)");
        tv.setOnTouchListener(this);
        setContentView(tv);
    }

	@Override
	public boolean onTouch(View v, MotionEvent ev) {
		// TODO Auto-generated method stub
		builder.setLength(0);
		switch(ev.getAction()){
		case MotionEvent.ACTION_DOWN :
			builder.append("down, ");
			break;
		case MotionEvent.ACTION_UP :
			builder.append("up, ");
			break;
		case MotionEvent.ACTION_CANCEL :
			builder.append("cancel, ");
			break;
		case MotionEvent.ACTION_MOVE :
			builder.append("move, ");
			break;
		}
		
		builder.append(ev.getX());
		builder.append(", ");
		builder.append(ev.getY());
		String text=builder.toString();
		Log.d("touchtest",text);
		tv.setText(text);
		
		
		return true;
	}
}