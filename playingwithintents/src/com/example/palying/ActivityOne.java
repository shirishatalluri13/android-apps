package com.example.palying;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ActivityOne extends Activity {
	private static final int REQUEST_CODE = 10;

	
/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void onClick(View view) {
		Intent i = new Intent(this, ActivityTwo.class);
		i.putExtra("Value1", "This value one for ActivityTwo ");
		i.putExtra("Value2", "This value two ActivityTwo");
		// Set the request code to any code you like, you can identify the
		// callback via this code
		startActivityForResult(i, REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
			if (data.hasExtra("returnKey2")) {
				Toast.makeText(this, data.getExtras().getString("returnKey2"),
						Toast.LENGTH_SHORT).show();
			}
		}
	}
}