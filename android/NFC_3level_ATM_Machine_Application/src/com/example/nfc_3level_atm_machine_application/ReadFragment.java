package com.example.nfc_3level_atm_machine_application;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import org.json.JSONException;
import org.json.JSONObject;

import com.Database.AES_Encryption;
import com.Database.DataBaseHelper;
import com.Database.GenerateRandomNumber;
import com.Database.KeySet;
import com.Database.User;
import com.Database.XOR_Operation;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;




import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.AsyncTask;
import android.os.Bundle;

import android.telephony.SmsManager;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ReadFragment extends Activity
{

	public static final String MIME_TEXT_PLAIN = "text/plain";
	public static final String TAG = "NfcDemo";
	public static TextView testMag,textencry,otptextview;
	private NfcAdapter mNfcAdapter;
	
	EditText editText,otppassword;
	ImageButton button;
	  String machinenum="";
	String tag_data="";
	
	DataBaseHelper baseHelper;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.read);
		
		editText = (EditText) findViewById(R.id.encrypteddata);
		button = (ImageButton) findViewById(R.id.readdata);
		
		//Validation
		testMag = (TextView) findViewById(R.id.validate);
		
		
		textencry = (TextView) findViewById(R.id.encrypt);
	
		otptextview = (TextView) findViewById(R.id.otppass);
		
		//EditText for OTP
		otppassword = (EditText) findViewById(R.id.otp);
		
		mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
		
		 Intent intent = getIntent();
  machinenum= intent.getStringExtra("machinenum");
          
         
          
          //Toast.makeText(getApplicationContext(),"patient id is recieved in read fragment "+patientid,Toast.LENGTH_LONG).show();
			
		 try
		 {
			 if (mNfcAdapter == null) 
		        {
		            // Stop here, we definitely need NFC
		            Toast.makeText(this, "This device doesn't support NFC.", Toast.LENGTH_LONG).show();
		            //finish();
		            //return;
		        }
		     
		        if (!mNfcAdapter.isEnabled()) 
		        {
		        	testMag.setText("NFC is disabled.");
		        }
		        else 
		        {
		        	testMag.setText("Detected NFC TAG Content :\n");
		        }
		         
		        handleIntent(getIntent());
		        
		        button.setOnClickListener(new OnClickListener()
		        {
					
					@Override
					public void onClick(View v)
					{
						
						String tag_data = editText.getText().toString();
						
						// Split NFC Datas
		            	String[] empInfo = tag_data.split("~");
		            	
		            	String empno = empInfo[0];
		            	String empname = empInfo[1];
		            	String frommobile = empInfo[2];
		            	String tomobile = empInfo[3];
		            	
		            	String user_otp = otppassword.getText().toString();
		            	
		            	baseHelper = new DataBaseHelper(getApplicationContext());
		            	KeySet k = baseHelper.Get_OTP(Integer.parseInt(empno));
		            	
		            	String otp = k.getEmpOtp();
		            	
		            	if(user_otp.trim().equals(otp.trim()))
		            	{

		            		Calendar currentDate = Calendar.getInstance();
		         			SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
		         			String date = formatter.format(currentDate.getTime());
		         			
		         			SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm");
		         			String time = formatter1.format(currentDate.getTime());
		         			
		         			String dt = date+" "+time;
		         			
		         			// MSG Sending to Manager
			            	SmsManager smsManager = SmsManager.getDefault();
			            	String sms = " Employee No: "+empno+" Employee Name :"+empname+" Date and Time :"+dt;
							//System.out.println("smsManager " + smsManager);
							smsManager.sendTextMessage(tomobile, null, sms, null,null);
							Toast.makeText(getApplicationContext(),"SMS has been Sent to Manager ",Toast.LENGTH_LONG).show();
						
							
		            	}
		            	else
		            	{
		            	Toast.makeText(getApplicationContext(), "OTP Invalid  Please Try Again",5000).show();
		            	}
		            	
					}
				});
		        
		 }catch(Exception exception)
		 {
			
			 Toast.makeText(this, exception.toString(), Toast.LENGTH_LONG).show();
			 testMag.setText(exception.toString());
		 }
	}

	public void showCustomAlert() {

		Context context = getApplicationContext();
		// Create layout inflator object to inflate toast.xml file
		LayoutInflater inflater = getLayoutInflater();

		// Call toast.xml file for toast layout
		View toastRoot = inflater.inflate(R.layout.success, null);

		Toast toast = new Toast(context);

		// Set layout to toast
		toast.setView(toastRoot);
		toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL,
				0, 0);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.show();

	}
	
	@Override
    protected void onResume() {
        super.onResume();
         
       /*//**
         It's important, that the activity is in the foreground (resumed). Otherwise
          an IllegalStateException is thrown. 
         //*
*/        setupForegroundDispatch(this, mNfcAdapter);
    }
     
    @Override
    protected void onPause() 
    {
        /**
         * Call this before onPause, otherwise an IllegalArgumentException is thrown as well.
         */
        stopForegroundDispatch(this, mNfcAdapter);
         
        super.onPause();
    }
     
    @Override
    protected void onNewIntent(Intent intent) { 
        /**
         * This method gets called, when a new Intent gets associated with the current activity instance.
         * Instead of creating a new activity, onNewIntent will be called. For more information have a look
         * at the documentation.
         * 
         * In our case this method gets called, when the user attaches a Tag to the device.
         */
        handleIntent(intent);
    }
    
    @SuppressLint("NewApi")
	private void handleIntent(Intent intent) 
    {
        String action = intent.getAction();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action))
        {
             
            String type = intent.getType();
            if (MIME_TEXT_PLAIN.equals(type)) 
            {
     
                Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
               new NdefReaderTask().execute(tag);
                 
            } else 
            {
                Log.d(TAG, "Wrong mime type: " + type);
            }
        } 
        else if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(action))
        {
             
            // In case we would still use the Tech Discovered Intent
            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            String[] techList = tag.getTechList();
            String searchedTech = Ndef.class.getName();
             
            for (String tech : techList) 
            {
                if (searchedTech.equals(tech))
                {
                   new NdefReaderTask().execute(tag);
                    break;
                }
            }
        }
        
        System.out.println(".....");
        
    }
    
    /**
     * Background task for reading the data. Do not block the UI thread while reading. 
     * 
     * @author Ralf Wondratschek
     *
     */
    private class NdefReaderTask extends AsyncTask<Tag, Void, String> 
    {
     
        @SuppressLint("NewApi")
		@Override
        protected String doInBackground(Tag... params)
        {
            Tag tag = params[0];
             
            Ndef ndef = Ndef.get(tag);
            if (ndef == null) {
                // NDEF is not supported by this Tag. 
                return null;
            }
     
            NdefMessage ndefMessage = ndef.getCachedNdefMessage();
     
            NdefRecord[] records = ndefMessage.getRecords();
            for (NdefRecord ndefRecord : records) 
            {
                if (ndefRecord.getTnf() == NdefRecord.TNF_WELL_KNOWN && Arrays.equals(ndefRecord.getType(), NdefRecord.RTD_TEXT)) {
                    try 
                    {
                    	tag_data = readText(ndefRecord);
                    	
                        return readText(ndefRecord);
                    } catch (UnsupportedEncodingException e)
                    {
                        Log.e(TAG, "Unsupported Encoding", e);
                    }
                }
            }
     
            return tag_data;
        }
         
        @SuppressLint("NewApi")
		private String readText(NdefRecord record) throws UnsupportedEncodingException 
        {
            /*
             * See NFC forum specification for "Text Record Type Definition" at 3.2.1 
             * 
             * http://www.nfc-forum.org/specs/
             * 
             * bit_7 defines encoding
             * bit_6 reserved for future use, must be 0
             * bit_5..0 length of IANA language code
             */
     
            byte[] payload = record.getPayload();
     
            // Get the Text Encoding
            String textEncoding = ((payload[0] & 128) == 0) ? "UTF-8" : "UTF-16";
     
            // Get the Language Code
            int languageCodeLength = payload[0] & 0063;
             
            // String languageCode = new String(payload, 1, languageCodeLength, "US-ASCII");
            // e.g. "en"
             
            // Get the Text
            return new String(payload, languageCodeLength + 1, payload.length - languageCodeLength - 1, textEncoding);
        }
         
        @SuppressWarnings("unused")
		@SuppressLint("NewApi")
		@Override
        protected void onPostExecute(String result) 
        {
            if (result != null)
            {
            	//editText.setText(result.trim());
            	textencry.setVisibility(1);
            	editText.setVisibility(1);
            	baseHelper = new DataBaseHelper(getApplicationContext());
            	
            	try 
            	{
            		
            		 Intent intent = getIntent();
                     String patientid= intent.getStringExtra("patientid");
                    // Toast.makeText(getApplicationContext(),"patient id is recieved in ReadFragment "+patientid,Toast.LENGTH_LONG).show();
            		
            		System.out.println("its came inside the post exicute method>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            		
            		//Toast.makeText(getApplicationContext(), "XOR Process Start", 5000).show();
					
            		//String decrypteddata = AES_Encryption.decrypt(result, "1111111111aaaaaa");
            		String s1="Bangalore is a Garden City in India";
            		byte out1[]=XOR_Operation.xorWithData(s1.getBytes(), result.getBytes());
            		
            		 String s4=new String(out1);
            		 Toast.makeText(getApplicationContext(), "Card is detected", Toast.LENGTH_LONG).show();
            		

        			 RequestParams params = new RequestParams();
           			
        				params.put("details", s4+"~"+machinenum);
        			
        			    invokeWS(params,"data");
        			
				}
            	catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            	
            }
        }
    }
    
    /**
     * @param activity The corresponding {@link Activity} requesting the foreground dispatch.
     * @param adapter The {@link NfcAdapter} used for the foreground dispatch.
     */
    @SuppressLint("NewApi")
	public static void setupForegroundDispatch(final Activity activity, NfcAdapter adapter) 
    {
        final Intent intent = new Intent(activity.getApplicationContext(), activity.getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
 
        final PendingIntent pendingIntent = PendingIntent.getActivity(activity.getApplicationContext(), 0, intent, 0);
 
        IntentFilter[] filters = new IntentFilter[1];
        String[][] techList = new String[][]{};
 
        // Notice that this is the same filter as in our manifest.
        filters[0] = new IntentFilter();
        filters[0].addAction(NfcAdapter.ACTION_NDEF_DISCOVERED);
        filters[0].addCategory(Intent.CATEGORY_DEFAULT);
        try
        {
            filters[0].addDataType(MIME_TEXT_PLAIN);
        }
        catch (MalformedMimeTypeException e)
        {
            throw new RuntimeException("Check your mime type.");
        }
         
        adapter.enableForegroundDispatch(activity, pendingIntent, filters, techList);
    }
 
    /**
     * @param activity The corresponding {@link BaseActivity} requesting to stop the foreground dispatch.
     * @param adapter The {@link NfcAdapter} used for the foreground dispatch.
     */
    @SuppressLint("NewApi")
	public static void stopForegroundDispatch(final Activity activity, NfcAdapter adapter) 
    {
        adapter.disableForegroundDispatch(activity);
    }
    
    // Initiating Menu XML file (menu.xml)
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.homemenu, menu);
        return true;
    }
     
    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
         
        switch (item.getItemId())
        {
     
    
       
 
            
        case R.id.logout:
            Toast.makeText(ReadFragment.this, "", Toast.LENGTH_SHORT).show();
            Intent intent3 = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent3);
            return true;
 
       
 
        default:
            return super.onOptionsItemSelected(item);
        }
    }   
    
    @Override
	public void onBackPressed()
	{
		Intent intent1 = new Intent(this,HomeScreen.class);
		startActivity(intent1);
		
	}
    
    public void invokeWS(RequestParams params,String data)
	{
		// Show Progress Dialog
		// prgDialog.show();
		 // Make RESTful webservice call using AsyncHttpClient object
		 AsyncHttpClient client = new AsyncHttpClient();
         client.get(Global.URL+"trans/details",params ,new AsyncHttpResponseHandler()
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
                      String list=obj.getString("status");
	                        
	                       /*  Toast.makeText(getApplicationContext(), "from web server>>>>>"+type, Toast.LENGTH_LONG).show();*/
	                         
	                       if(list.equals("1") )
	                         {
	                        	
	                        	 Toast.makeText(getApplicationContext(), "Card Account Number  is invalid", Toast.LENGTH_LONG).show();
	                        	 
	                         } 
	                         else if (list.equals("3") )
	                         {
	                        	 Toast.makeText(getApplicationContext(), "Card is valid", Toast.LENGTH_LONG).show();
	                        	 
	                         }
	                         else
	                         {
	                        	 
	                        	 Toast.makeText(getApplicationContext(), "This ACcount Number is not Registred with valid User", Toast.LENGTH_LONG).show(); 
	                        	 
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
