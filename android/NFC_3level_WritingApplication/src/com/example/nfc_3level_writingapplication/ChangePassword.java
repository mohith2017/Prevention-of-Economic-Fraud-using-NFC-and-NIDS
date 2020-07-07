
package com.example.nfc_3level_writingapplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.HttpClient.CustomHttpClient;
import com.HttpClient.Global;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends Activity
{
	String current_pass = "", new_pass = "", loginu = "", confirmpa = "";
	EditText c_pass, new_password, con_pass;
	String output1 = "";
	String result = "";
	Button change;
	String pass = "";
	String response="";
	
	
	boolean b =false;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.changepass);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = 
			        new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			}
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		c_pass = (EditText) findViewById(R.id.current_pass);
		 
		new_password = (EditText) findViewById(R.id.new_password);
		
		
		con_pass = (EditText) findViewById(R.id.confirm_password);
		

		
		change = (Button) findViewById(R.id.login);

		change.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				current_pass = c_pass.getText().toString();
				new_pass = new_password.getText().toString();
				confirmpa = con_pass.getText().toString();
				System.out.println(""+current_pass);
				System.out.println(""+new_pass);
				System.out.println(""+confirmpa);
				
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("CurrentPass", current_pass));
				nameValuePairs.add(new BasicNameValuePair("NewPass",new_pass));
				nameValuePairs.add(new BasicNameValuePair("ConfirmPass", confirmpa));
			

				System.out.println("All Values " + current_pass + "."+ new_pass + "." + confirmpa);
				

				if ((current_pass.equals("") || current_pass.length() == 0)&& (new_pass.equals(""))&& (confirmpa.equals("") || confirmpa.length() == 0))
				{
					Toast.makeText(getApplicationContext(),	" Please Enter All the Fields ",Toast.LENGTH_SHORT).show();
					
				}
			
				 if("".equals(current_pass))
				{
					
					Toast.makeText(getApplicationContext(),	" Please Enter Current Password ",Toast.LENGTH_SHORT).show();
				}
				 if("".equals(new_pass))
				{
					Toast.makeText(getApplicationContext(),	" Please Enter New Password ",Toast.LENGTH_SHORT).show();
				}
				 if("".equals(confirmpa))
				{
					
					Toast.makeText(getApplicationContext(),	" Please Enter Confirm Password ",Toast.LENGTH_SHORT).show();
				}
				 if(!new_pass.equals(confirmpa))
				{
					
					Toast.makeText(getApplicationContext(),	" New Password and Confirm Password Mismatch ",Toast.LENGTH_SHORT).show();
				}
				 else
				 {
					 
					 
					 
					 RequestParams params = new RequestParams();
			   			
						params.put("current_pass", current_pass);
					
						params.put("new_pass", new_pass);
						params.put("confirmpa", confirmpa);
						
					
						invokeWS(params,"data");
						
							 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 

					
			}
			}		
		});

	}
    public void invokeWS(RequestParams params,String data)
	{
		// Show Progress Dialog
		// prgDialog.show();
		 // Make RESTful webservice call using AsyncHttpClient object
		 AsyncHttpClient client = new AsyncHttpClient();
         client.get(Global.URL+"adminchange/changepassadmin",params ,new AsyncHttpResponseHandler()
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
                        String numb=	obj.getString("num");
	                        
	                       /*  Toast.makeText(getApplicationContext(), "from web server>>>>>"+type, Toast.LENGTH_LONG).show();*/
	                         
	                       if(numb.equals("1") )
	                         {
	                        	
	                        	 Toast.makeText(getApplicationContext(), "Error in old pasword", Toast.LENGTH_LONG).show();
	                        	
	                        	 
	                         } 
	                         else if(numb.equals("2") )
	                         {
	                        	 Toast.makeText(getApplicationContext(), "Password Changed Successfully", Toast.LENGTH_LONG).show();
	                        	 
	                        	 Intent intent=new Intent(getApplicationContext(),HomeScreen.class);
	                        	 startActivity(intent);
	                         }
	                         else
	                         {
	                        	 
	                        	 Toast.makeText(getApplicationContext(), "Error in password Changing", Toast.LENGTH_LONG).show(); 
	                        	 
	                        	 
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

