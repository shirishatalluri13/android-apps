package com.example.helloandroid.test;

import com.example.helloandroid.HelloAndroidActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class HelloAndroidTest extends
		ActivityInstrumentationTestCase2<HelloAndroidActivity> {

	 private HelloAndroidActivity mActivity;
	    private TextView mView;
	    private String resourceString;
	
	   
	public HelloAndroidTest(String pkg,
			Class<HelloAndroidActivity> activityClass) {
		super("com.example.helloandroid", HelloAndroidActivity.class);
		// TODO Auto-generated constructor stub
	}

	 @Override
	    protected void setUp() throws Exception {
	        super.setUp();
	        mActivity = this.getActivity();
	        mView = (TextView) mActivity.findViewById(com.example.helloandroid.R.id.textview);
	        resourceString = mActivity.getString(com.example.helloandroid.R.string.hello);
	    }
	 public void testPreconditions() {
	      assertNotNull(mView);
	    }
	    public void testText() {
	        assertEquals(resourceString,(String)mView.getText());
	      }
}
