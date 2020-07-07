package com.support;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class RandomValue {
	
	             
	  /*Random Value Generation*/
	
	public static int hash_key()
	{
		int val[] =new int[]{332,454,578,690,721};
		Random random = new Random();
		int x = random.nextInt(val.length);
		
		return val[x];
		
	}
	
	public int RandomGen(String accNum)
	{
		int ran=0;
		int sum=0;
		String random ="";
		System.out.println("Account Number :"+accNum);
		try
		{
		for(int i=0;i<accNum.length();i++)
		{
			char c = accNum.charAt(i);
			int b = Character.getNumericValue(c); 
			//System.out.println("Integer :"+b);
			ran=ran+ b;
			//System.out.println("Random Number Value:"+ran);
			
		}
		
		}catch(Exception e)
		{
			System.out.println("Exception :"+e);
		}
		
		return ran;
		
	}
	
	public static int SumOfDate()
	{
		int sumofda = 0;
		
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
				
		String date = formatter.format(currentDate.getTime());
				
		try
		{
		
		String dat = date.replace("-", "");
		//System.out.println("Dat :"+dat);
		
		for(int k=0;k<dat.length();k++)
		{
			char dcount = dat.charAt(k);
			int date_count = Character.getNumericValue(dcount);
			sumofda =sumofda+date_count;
			//System.out.println("Sum Of Date :"+sumofda);
			
		}
		
		
		}catch(Exception e)
		{
			
		}
		return sumofda;
		
		
		
	}
	
	public static int SumOfTime()
	{
		
		
				// Sum Of Time Calculation //
				Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm");
				String time = formatter1.format(currentDate.getTime());
				
				int sumofti = 0;
				String tim = time.replace(":", "");
				//System.out.println("Dat :"+tim);
				int sum=0;
				try{
				for(int k=0;k<tim.length();k++)
				{
					char dcount = tim.charAt(k);
					int time_count = Character.getNumericValue(dcount);
					sumofti =sumofti+time_count;
					//System.out.println("Sum Of Time :"+sumofti);
					
					
					
				}
				
				//System.out.println("Sum Of Date fhfdh:"+sumofti);
				}
				catch(Exception e)
				{
					
					System.out.println("Exception :"+e);
				}
				return sumofti;
				
				
				
	}
	
}
