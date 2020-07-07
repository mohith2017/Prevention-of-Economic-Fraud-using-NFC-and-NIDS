package com.example.nfc_3level_writingapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Viewreadeddata extends Activity {
	TextView ed1,ed2,ed3,ed4,ed5,ed6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewcontent);
	
		
		Button back = (Button) findViewById(R.id.back);
		final EditText accno = (EditText) findViewById(R.id.accno);
		/*final EditText vehicleno = (EditText) findViewById(R.id.vehicleno);*/
		final EditText bankname = (EditText) findViewById(R.id.bankname);
		final EditText branch = (EditText) findViewById(R.id.branch);
		/*final EditText model = (EditText) findViewById(R.id.model);*/
		final EditText accname = (EditText) findViewById(R.id.accname);
		final EditText acctype = (EditText) findViewById(R.id.acctype);
		/*final EditText vehicleno = (EditText) findViewById(R.id.vehicleno);*/
		final EditText phone = (EditText) findViewById(R.id.phone);
		final EditText emailid = (EditText) findViewById(R.id.emailid);
		
		
		
		 Intent intent = getIntent();
         String readdata= intent.getStringExtra("readdata");
		System.out.println("read data is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+readdata);
		
		
		String[] data=readdata.split("~");
	String accno1=	data[0];
	
	String bankname2=	data[1];

	String branch3=	data[2];
	
	String accname4=	data[3];
String acctype5=	data[4];
	
	String phone6=	data[5];

	String emailid7=	data[6];
	

	accno.setKeyListener(null); 
	accno.setEnabled(false);
	accno.setText(accno1);
	
	
	bankname.setKeyListener(null); 
	bankname.setEnabled(false);
	bankname.setText(bankname2);
	
	branch.setKeyListener(null); 
	branch.setEnabled(false);
	branch.setText(branch3);
	
	accname.setKeyListener(null); 
	accname.setEnabled(false);
	accname.setText(accname4);
	
	
	
	acctype.setKeyListener(null); 
	acctype.setEnabled(false);
	acctype.setText(acctype5);
	
	
	
	
	phone.setKeyListener(null); 
	phone.setEnabled(false);
	phone.setText(phone6);
	
	
	
	emailid.setKeyListener(null); 
	emailid.setEnabled(false);
	emailid.setText(emailid7);
	
	
	
	
	
	
	
	
	
	
	
		
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				
				
    			Intent intentdata=new Intent(getApplicationContext(),HomeScreen.class);
    			
    			startActivity(intentdata);
    			
				
				
				
				
				
				
				
				
				
				
			}
		});
		
		
		
		
		
		
		
		
		
	}
}
