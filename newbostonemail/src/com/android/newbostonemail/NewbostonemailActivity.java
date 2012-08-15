package com.android.newbostonemail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NewbostonemailActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    
	EditText personsEmail, intro, personsName, stupidThings, hatefulAction, outro;
	String emailAdd,beginning,name,stupidaction,hatefulact, out;
	Button sendEmail;	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        setContentView(R.layout.email);
        initializevars();
        sendEmail.setOnClickListener(this);
        
    }
    
    public void initializevars()
    {
    	personsEmail = (EditText)findViewById(R.id.etEmails);
    	intro = (EditText)findViewById(R.id.etIntro);
    	personsName = (EditText)findViewById(R.id.etName);
    	stupidThings = (EditText)findViewById(R.id.etThings);
    	hatefulAction = (EditText)findViewById(R.id.etAction);
    	outro = (EditText) findViewById(R.id.etOutro);
    	sendEmail = (Button)findViewById(R.id.bSentEmail);
    }

	@Override
	public void onClick(View v) {
		conettostr();//convert edit texts to strings
		String emailaddress[]={emailAdd};
		String message = "well hello" + name + "hey , " + beginning + " you do stupid action : " + stupidaction + "I just want to make "+hatefulact + " oh and "+out+'\n'+"ps. nice to meet you";
		
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,emailaddress);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"i hate you!" );
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,message);
		startActivity(emailIntent);
		
	}
	
	public void conettostr(){
		emailAdd = personsEmail.getText().toString();
		beginning = intro.getText().toString();
		name = personsName.getText().toString();
		stupidaction = stupidThings.getText().toString();
		hatefulact = hatefulAction.getText().toString();
		out = outro.getText().toString();
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	
}