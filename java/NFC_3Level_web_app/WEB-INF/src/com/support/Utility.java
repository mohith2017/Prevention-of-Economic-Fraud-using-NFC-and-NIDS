/**
 @Author : Munna Kumar Singh
 Date : Aug 20, 2013
 File : Utility.java
 Package : com.dev.util
*/

package com.support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class Utility
{
	public static int parse(String str) 
	{ 
		int p=0; 
		if(str==null) 
		{ 
			str="0"; 
		} 
		else if((str.trim()).equals("null")) 
		{ 
			str="0"; 
		} 
		else if(str.equals("")) 
		{ 
			str="0"; 
		} 
		try
		{ 
			p=Integer.parseInt(str); 
		} 
		catch(Exception e) 
		{
			System.out.println("Opp's error is in Utility parse(String str) "+e);
		} 
		return p; 
	}
	
	public static String parse1(Object str) 
	{ 
		String p=""; 
		if(str==null) 
		{ 
			str=""; 
		} 
		else if(str.equals("")) 
		{ 
			str=""; 
		} 
		try
		{ 
			p=(String)str; 
		} 
		catch(Exception e) 
		{
			System.out.println("Opp's error is in Utility parse1(String str) "+e);
		} 
		return p; 
	}
	
	public static Object parse2(Object str) 
	{ 
		Object obj=null;
		if(str!=null) 
			return str;
		else
			return obj; 
	}
	
	public static String getPro(String str) 
	{
		String pro="";
		try
		{
			java.security.ProtectionDomain pd =	Utility.class.getProtectionDomain();
			java.security.CodeSource cs = pd.getCodeSource();
			java.net.URL url = cs.getLocation();
			java.io.File f = new File( url.getFile());
			String path=f.getParent();
			Properties property = new Properties();
			FileInputStream in=null;
			in = new FileInputStream(path+"\\Config.properties");
			property.load(in);
			pro=property.getProperty(str);
			//System.out.println("Property to return : "+pro);
		}
		catch(Exception e)
		{
			System.out.println("Opp's error is in Utility getPro(String str) "+e);
		}
		return pro;
	}
	
	public static String getDate()
	{
		String date="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");
			date = formatter1.format(currentDate.getTime());
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDate( ): "+ e);
		}
		return date;
	}
	public static String getTime()
	{
		String time="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
			time = formatter1.format(currentDate.getTime());
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getTime( ): "+ e);
		}
		return time;
	}
	
	public static String getDateTime()
	{
		String dateTime="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			
			SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dateTime = formatter1.format(currentDate.getTime());
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in Utility-->getDateTime() : ");
			e.printStackTrace();
		}
		return dateTime;
	}
	
	public static String getDay()
	{
		String day="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			int no=currentDate.get(Calendar.DAY_OF_WEEK);
			if(no==1)
				day="Sunday";
			else if(no==2)
				day="Monday";
			else if(no==3)
				day="TUESDAY";
			else if(no==4)
				day="WEDNESDAY";
			else if(no==5)
				day="THURSDAY";
			else if(no==6)
				day="FRIDAY";
			else if(no==7)
				day="SATURDAY";
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDay( ): "+ e);
		}
		return day;
	}
	
/* MD5 Algorithm(Starts) */
	
	public static String MD(File file) throws NoSuchAlgorithmException, FileNotFoundException 
	{
		String output="";
		MessageDigest digest = MessageDigest.getInstance("MD5");
		InputStream is = new FileInputStream(file);				
		byte[] buffer = new byte[8192];
		int read = 0;
		try {
			while( (read = is.read(buffer)) > 0) 
			{
				digest.update(buffer, 0, read);
			}		
			byte[] md5sum = digest.digest();
				System.out.print("Digets:"+md5sum);
			
			System.out.println();
			BigInteger bigInt = new BigInteger(1, md5sum);
			output = bigInt.toString(16);
			System.out.println("MD5: " + output);
		}
		catch(IOException e) 
		{
			System.out.println("Unable to process file for MD5"+e);
		}
		return output;
	}
	
/* MD5 Algorithm(Ends) */
	
/* MD5 Algorithm(Starts) */
	
	public static String MD(InputStream inputStream) throws NoSuchAlgorithmException, FileNotFoundException 
	{
		String output="";
		MessageDigest digest = MessageDigest.getInstance("MD5");
		InputStream is = inputStream;				
		byte[] buffer = new byte[8192];
		int read = 0;
		try {
			while( (read = is.read(buffer)) > 0) 
			{
				digest.update(buffer, 0, read);
			}		
			byte[] md5sum = digest.digest();
				System.out.print("Digets:"+md5sum);
			
			System.out.println();
			BigInteger bigInt = new BigInteger(1, md5sum);
			output = bigInt.toString(16);
			System.out.println("MD5: " + output);
		}
		catch(IOException e) 
		{
			System.out.println("Unable to process file for MD5"+e);
		}
		return output;
	}
	
/* MD5 Algorithm(Ends) */
}
