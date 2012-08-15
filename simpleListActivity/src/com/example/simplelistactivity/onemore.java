package com.example.simplelistactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class onemore extends Activity{

	LinearLayout mLinearLayout; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		mLinearLayout = new LinearLayout(this);
		ImageView i = new ImageView(this);
		i.setImageResource(R.drawable.androidicon);
		i.setAdjustViewBounds(true);
		i.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		
		mLinearLayout.addView(i);
		setContentView(mLinearLayout);
		
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		Toast.makeText(this, "one more activity",Toast.LENGTH_SHORT).show();
	
	}
	
	

}
