package com.example.graphicstry;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

public class GraphicstryActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        
    }

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// processing single touch events
		switch (event.getAction()){
		case MotionEvent.ACTION_DOWN:
			Toast.makeText(this, "action down event "+event.getX()+" , "+event.getY(), Toast.LENGTH_SHORT).show();
			break;
			
		case MotionEvent.ACTION_UP:
			Toast.makeText(this, "action up event"+event.getX()+" , "+event.getY(), Toast.LENGTH_SHORT).show();
			break;
			
		}
		return super.onTouchEvent(event);
	}
}