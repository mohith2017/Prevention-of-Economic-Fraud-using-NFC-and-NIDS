package com.example.nfc_3level_atm_machine_application;


import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;



import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
Button btn;
EditText txt1;
Toast toast;
String	response;
EditText txt2;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		try
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = 
			        new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			}
		
		btn=(Button) findViewById(R.id.signinbutton);
		
		txt1=(EditText) findViewById(R.id.username);
		
		txt2=(EditText) findViewById(R.id.password);
		
		
	btn.setOnClickListener(new OnClickListener() {
		
		@SuppressLint("ShowToast")
		@Override
		public void onClick(View v) {
			
		String username=	txt1.getText().toString();
		
		System.out.println("username is >>>>>>>>>>>>>>>>>>>>>"+username);
		String password=	txt2.getText().toString();
		
		System.out.println("password is >>>>>>>>>>>>>>>>>>>>>"+password);
		if(username.equals(""))
		{
				Toast.makeText(getApplicationContext(), "Please,Enter User Id", Toast.LENGTH_LONG).show();
				return;
		}
		if(password.equals(""))
		{
				Toast.makeText(getApplicationContext(), "Please,Enter User Password", Toast.LENGTH_LONG).show();
				return;
		}
		else
		{
			 RequestParams params = new RequestParams();
   			
				params.put("username", username);
			
				params.put("password", password);
			
				invokeWS(params,"data");
				
				
				
				
     
	}
	
	
	
	
	
		
		
		

		
		
		}	
		
	
	});	
		
		
	
			
	
		}catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
    public void invokeWS(RequestParams params,String data)
	{
		// Show Progress Dialog
		// prgDialog.show();
		 // Make RESTful webservice call using AsyncHttpClient object
		 AsyncHttpClient client = new AsyncHttpClient();
         client.get(Global.URL+"atm/atmlogin",params ,new AsyncHttpResponseHandler()
         {
        	 // When the response returned by REST has Http response code '200'
             @Override
             public void onSuccess(String response)
             {
            	 // Hide Progress Dialog
            	// prgDialog.hide();
                 try {
                	 		System.out.println("=============================");
                	       System.out.println("ur response is :"+response);
                	    /*   Toast.makeText(getApplicationContext(), "##"+response, 1500).show();*/
                	       System.out.println("=============================");
                	       // JSON Object
                        	JSONObject obj = new JSONObject(response);
                        	// When the JSON response has status boolean value assigned with true
                      String list=obj.getString("list");
	                        
	                       /*  Toast.makeText(getApplicationContext(), "from web server>>>>>"+type, Toast.LENGTH_LONG).show();*/
	                         
	                       if(obj.getBoolean("status")==true )
	                         {
	                        	
	                        	 Toast.makeText(getApplicationContext(), "ATM Machine Login", Toast.LENGTH_LONG).show();
	                        	 
	                        	 Intent intent=new Intent(getApplicationContext(),Branch.class);
	                        	 intent.putExtra("listdata", list);
	                        	 startActivity(intent);
	                        	 
	                         } 
	                         else 
	                         {
	                        	 Toast.makeText(getApplicationContext(), "Please Enter ATM Code and password Correctly", Toast.LENGTH_LONG).show();
	                        	 
	                         }
                         
                         
                         /*// Else display error message
                         else{
                        	// errorMsg.setText(obj.getString("error_msg"));
                        	 Toast.makeText(getApplicationContext(), obj.getString("error_msg"), Toast.LENGTH_LONG).show();
                         }*/
                 } 
                 catch (JSONException e) {
                     // TODO Auto-generated catch block
                     Toast.makeText(getApplicationContext(), "Error Occured [Server's JSON response might be invalid]!", Toast.LENGTH_LONG).show();
                     e.printStackTrace();
                     
                 }
             }
             // When the response returned by REST has Http response code other than '200'
             @Override
             public void onFailure(int statusCode, Throwable error,
                 String content) {
                 // Hide Progress Dialog 
                 //prgDialog.hide();
                 // When Http response code is '404'
                 if(statusCode == 404){
                     Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
                 } 
                 // When Http response code is '500'
                 else if(statusCode == 500){
                     Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
                 } 
                 // When Http response code other than 404, 500
                 else{
                     Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]", Toast.LENGTH_LONG).show();
                 }
             }
         });
		
	}
}
