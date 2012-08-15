package com.examples.vogellatouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class TouchEventView extends View{

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
	//	return super.onTouchEvent(event);
		float eventX = event.getX();
	    float eventY = event.getY();

	    switch (event.getAction()) {
	      case MotionEvent.ACTION_DOWN:
	        mypath.moveTo(eventX, eventY);
	        mypath.addCircle(eventX, eventY, 50, Path.Direction.CW);
	        return true;
	      case MotionEvent.ACTION_MOVE:
	        mypath.lineTo(eventX, eventY);
	        break;
	      case MotionEvent.ACTION_UP:
	    	  // nothing to do 
	    	  //mypath.
	    	  break;
	      default:
	        return false;
	    }

	    // Schedules a repaint.
	    invalidate();
	    return true;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
	//	super.onDraw(canvas);
		canvas.drawPath(mypath, mypaint);
	}

	private Paint mypaint = new Paint();
	private Path mypath = new Path();
	
	public TouchEventView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	
		mypaint.setAntiAlias(true);
		mypaint.setColor(Color.WHITE);
		mypaint.setStyle(Paint.Style.STROKE);
		mypaint.setStrokeJoin(Paint.Join.ROUND);
		mypaint.setStrokeWidth(5f);
	}

}
