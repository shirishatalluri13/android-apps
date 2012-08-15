package com.example.simplelistactivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class shapedrawable extends Activity{

	class mycustomdrawableview extends View{
		ShapeDrawable mShapDrawable;
		Button b;
		public mycustomdrawableview(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			int x=10;
			int y=10;
			int width = 300;
			int height = 300;
			mShapDrawable = new ShapeDrawable(new OvalShape());
			mShapDrawable.getPaint().setColor(0xff74AC23);
			mShapDrawable.setBounds(x, y, x + width, y + height);
			b=new Button(context);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			super.onDraw(canvas);
			b.draw(canvas);
			mShapDrawable.draw(canvas);
		}
		
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
		mycustomdrawableview mcd = new mycustomdrawableview(this);
		setContentView(mcd);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	

}
