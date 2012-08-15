package com.example.intfilters;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class BrowserActivitiy extends Activity {
	
/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Intent intent = getIntent();
		TextView text = (TextView) findViewById(R.id.textView);
		// To get the action of the intent use
		System.out.println(intent.getAction());
		// We current open a hard-coded URL
		// To get the data the intent use the following line
		//Uri data = intent.getData();
		URL url;
		try {
			// url = new URL(data.getScheme(), data.getHost(), data.getPath());
			url = new URL("http://www.vogella.de");
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					url.openStream()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				text.append(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}