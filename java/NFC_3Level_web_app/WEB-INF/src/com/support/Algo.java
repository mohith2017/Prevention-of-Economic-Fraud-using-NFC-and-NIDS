package com.support;
import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.util.Random;


public class Algo 
{
/* MD5 Algorithm(Starts) */
	
	
	public static String getMD5(String input,int key) 
	{
		String hashtext = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
           hashtext = number.toString(key);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) 
            {
                hashtext = "0" + hashtext;
            }
            
           // System.out.println("hashtext ------????"+hashtext);
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return hashtext.trim();
    }
	
	/* MD5 Algorithm(Ends) */
	
	public static String keyGeneration(String name,String bytes) 
	{
		String rand="";
		String extension = name.substring(name.indexOf("."));
		String file[]=name.split(extension);
	
		int l=file[0].length();
		String name1=file[0];
		//System.out.println("   file  name  length :"+l);
		name1=len(name1);
		String by=len(bytes);
		//System.out.println("   file  name   :"+name1+"      "+by);
		Random r=new Random();
		for(int i=0;i<6;i++)
		{
			int r1=r.nextInt(9);
			
			rand=rand+r1;
		}
	//	System.out.println("   file  rand   :"+rand);
		String key=name1+"+"+by+"+"+rand;
		return key;
        
    }
	public static String len(String name)
	{
		while(name.length()<5)
		{
			name="0"+name;
		}
		return name;
		
	}
	
	public static void main(String[] args) 
	{
		
			keyGeneration("f.txt", "128");
			//System.out.println(getMD5("null",16));
		
	}
	
}
