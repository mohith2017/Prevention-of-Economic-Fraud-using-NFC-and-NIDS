package com.example.nfc_3level_atm_machine_application;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Branch extends Activity {
	   Spinner spnr1;
	   Button btn;
	   EditText etd;
	   int position=0;
	   String number="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_branch);
		ArrayList<String> datac=new ArrayList<String>();
		Intent intent=getIntent();
	String listdata=	intent.getStringExtra("listdata");
	// Toast.makeText(getApplicationContext(), listdata, Toast.LENGTH_LONG).show();
	   spnr1 = (Spinner)findViewById(R.id.spinnerl);
	   btn= (Button)findViewById(R.id.button);
       
	   etd = (EditText)findViewById(R.id.edittext);
	   final String arraybgg[]=null;
	   final String bgg[]=      listdata.split(",");

	    for (int i = 0; i < bgg.length; i++) {
	    	
					   String data= 	bgg[i];
					    	
					String[] dataone=   data.split("~~");
					 Pattern pattern = Pattern.compile("[^a-z A-Z]");
					    Matcher matcher = pattern.matcher(dataone[0]);
					    String branch = matcher.replaceAll("");
					datac.add(branch);
					
					
	
	    	
			
		}
	   
	    String[] stockArr = new String[datac.size()];
	    stockArr = datac.toArray(stockArr);  
	   
	   
	   
       ArrayAdapter<String> adapter = new ArrayAdapter<String>(
               this, android.R.layout.simple_spinner_item, stockArr);

       spnr1.setAdapter(adapter);
       spnr1.setOnItemSelectedListener(
               new AdapterView.OnItemSelectedListener() {

                   @Override
                   public void onItemSelected(AdapterView<?> arg0, View arg1,
                           int arg2, long arg3) {

                     position = spnr1.getSelectedItemPosition();
                 //   Toast.makeText(getApplicationContext(),"You have selected "+bgg[+position],Toast.LENGTH_LONG).show();
                     
              String[] mac=      bgg[+position].split("~~");
              
              Pattern pattern = Pattern.compile("[^0-9]");
              Matcher matcher = pattern.matcher(mac[1]);
       number = matcher.replaceAll("");
           
              etd.setText(number);
                    
                    
                
                    
                   }

                   @Override
                   public void onNothingSelected(AdapterView<?> arg0) {
                       // TODO Auto-generated method stub

                   }

               }
           );
        	
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				 Intent intent=new Intent(getApplicationContext(),ReadFragment.class);
            	 intent.putExtra("machinenum", number);
            	 startActivity(intent);
            	 
				
				
				
				
			}
		});
		
	}

	
}
