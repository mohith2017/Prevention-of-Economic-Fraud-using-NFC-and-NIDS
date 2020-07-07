/*package com.amutha.Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amutha.Database.DAO;
import com.amutha.Database.adduserdao;
import com.amutha.support.CL_SendMail;
import com.amutha.support.RandomValue;
import com.data.Testduplicate;


*//**
 * Servlet implementation class adduseraction
 *//*
public class AddAccountDetails extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
     
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		String accountNumber = "",accountHolderName="",yyyy="",mm="",dd="",date="",accClosingBalance="",accReferedBy="",accStatus="",mobileNumber="",emailId="";
		int branchId = 0,accountTypeId=0;
		
	    boolean flag = false;
	    int check=0;
	    RequestDispatcher rd;
		HttpSession hs=request.getSession();
		
	    try 
	    {
		   accountNumber = request.getParameter("acc_no");
		   accountHolderName = request.getParameter("acc_holder");
		   yyyy =request.getParameter("date_yyyy");
		   mm = request.getParameter("date_mm");
		   dd = request.getParameter("date_dd");
		   accountTypeId = Integer.parseInt(request.getParameter("acc_type"));
		   branchId = Integer.parseInt(request.getParameter("branch"));
		   accClosingBalance = request.getParameter("closing_balance");
		   accReferedBy = request.getParameter("reffered_by");
		   accStatus = request.getParameter("status");
		   mobileNumber = request.getParameter("contact");
		   emailId = request.getParameter("email_id");
		   
		  
		   String userid = request.getParameter("acc_id");
		   String userpwd = request.getParameter("acc_pwd");
		   String user_cad_no = request.getParameter("acc_card_no");
		   
		   
		   date = yyyy+"-"+mm+"-"+dd;
		   
		   System.out.println("--------------Date : " + date);
		   
		   
		   //to store random images---------Start------------------------------------------------------
		   
		  
		   
		   
		   
		   Map m = DAO.retrieveImage();
			ArrayList<Integer> img_code1 =(ArrayList) m.get("Image_Code") ;
			ArrayList<String> img_name1 =(ArrayList) m.get("Image_Name") ;
//**********************
			//ArrayList<String> rand=Testduplicate.Generate(img_name1.size());
			//System.out.println("Duplicate number removing");

			// Randomly Select 3 Images //
			ArrayList<String> rand=new ArrayList<String>();

			for(int i=0;i<4;i++)
			{
				Random r = new Random();
				
				int val = r.nextInt(img_name1.size());
				
			
				
				if(rand.contains(val))
				{
					
					val = r.nextInt(img_name1.size());
					
					
				}
				
					rand.add(String.valueOf(val));
				
			}

			System.out.println("rand >>>>>>>>>>>>>>>>>>>>>>>>> :"+rand);
			
			Thread.sleep(1000);
			
			
			for(int j=0;j<rand.size();j++)
			{
				
			String elem=	rand.get(j);
				
			System.out.println("element is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+elem);
			
		boolean flag1=	DAO.updaterandomimages(elem,userid);
		
		System.out.println("flag one is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+flag1);
				
				
			}
			
			
			
		   
		   //to store random images-----End--------------------------------------------------------

		   check=adduserdao.checkAccountExistance(accountNumber);
			
			if(check==0)
			{
				
				
				//String session_code = AddAccountDetails.sessionCode(accountNumber);
				
				  flag=adduserdao.addAccountDetails(accountNumber,date,accountHolderName,accountTypeId,branchId,accClosingBalance,accReferedBy,accStatus,mobileNumber,emailId);
				    
				   // boolean flg = Send_SMS_Service.sendSMS(mobileNumber.trim(), "Session Code:"+session_code.trim());
				    
				   if (flag)
				   {
				
					   hs.setAttribute("emailId", emailId);
					   String message = "Hello  "+accountHolderName+",<br>"+"Your Account Number :"+accountNumber+",<br>"+"Get Your Captcha Graphical Password By click on below link <br><br><a href='http://localhost:8080/Captcha_Inkblot/password_set.jsp?no=0&user="+userid+"'>Captcha Password Setting</a><br><br>Thank You....";
						
					  
				    	boolean sendMailStatus = CL_SendMail.sendPersonalizedMail(emailId, "captchaimages@gmail.com", "captcha@dhs", "Account Details",message.trim(),"smtp.gmail.com", "465");
				    	
				    	System.out.println("sendMailStatus :"+sendMailStatus);
				    	
				    	if(sendMailStatus)
				    	{
				    	
				    		adduserdao.addUserDetails(userid,accountHolderName,userpwd,accountNumber,user_cad_no);
							   
				    		hs.setAttribute("add","success");
					    	hs.setAttribute("acc_no", accountNumber);
							rd=request.getRequestDispatcher("account_details.jsp?no=1");
							rd.forward(request,response);
				    	}
				    
				    }
				    else 
				    {
				    	hs.setAttribute("add","failed");
						rd=request.getRequestDispatcher("account_details.jsp");
						rd.forward(request,response);		    
					}
			}
			else if(check==1)
			{
				hs.setAttribute("existenceStatus","yes");
				rd=request.getRequestDispatcher("add_account.jsp");
				rd.forward(request,response);
			}
	   
	    }
	    catch (SQLException e)
	    {
	    	System.out.println("Opps,Exception in Admin-AddAccountDetails Servelet");
			e.printStackTrace();
		}
	    catch (Exception e) 
	    {
	    	System.out.println("Opps,Exception in Admin-AddAccountDetails Servelet");
	    	e.printStackTrace();
		}
	    finally
	    { 
	        out.close();
	    }
	}
	
	public static String sessionCode(String acc_no)
	{
		String final_output="";
		try
		{
			
		
			
			StringBuffer final_val = new StringBuffer();
		String content = acc_no;
		
		RandomValue obj = new RandomValue();
		
		int rand = obj.RandomGen(content);
		
		System.out.println("Total Random Value :"+rand);
		//System.out.println("Start Rand");
		String random = ""+rand;
		//System.out.println("length :"+random.length());
		int ran1=0;
		for(int j =0;j<random.length();j++)
		{
			char c1 = random.charAt(j);
			int count = Character.getNumericValue(c1);
			//System.out.println("Random Number count :"+count);
			ran1 = ran1+count;
			
			
		}
		System.out.println("Sum of Random Number :"+ran1);
		
		
		// Find Sum Of Date //
		
		int sum=0;
		int sumodate = RandomValue.SumOfDate();
		System.out.println("Sum :"+sumodate);
		
		String sumod = ""+sumodate;
		for(int l=0;l<sumod.length();l++)
		{
			char sumofd = sumod.charAt(l);
			int sumofdate = Character.getNumericValue(sumofd);
			sum =sum+sumofdate;
			
			
		}
		
		//System.out.println("Sum of date:"+sum);
		
		// Find Sum of Time //
		
		
			int sum1=0;
			int sumotime = RandomValue.SumOfTime();
			System.out.println("Time :"+sumotime);
		
			String sumotim = ""+sumotime;
			for(int l=0;l<sumotim.length();l++)
			{
				char sumofti = sumotim.charAt(l);
				
				int sumofdate = Character.getNumericValue(sumofti);
				sum1 =sum1+sumofdate;
				
			}
			
			System.out.println("Random Number :"+ran1);
			System.out.println("Sum of Date :"+sum);
			System.out.println("Sum of Time :"+sum1);
			
			// Find First Three Value //
			
			
			int fit = ((ran1)*(ran1))+((sum)*(sum))+((sum1)*(sum1));
			String form = ""+fit;
			
			System.out.println("First Value:"+form);
			
			
			StringBuffer sb1 = new StringBuffer();
			
			if(form.length()==2)
			{
				String fit1=0+""+fit;
				System.out.println("First Calculation output:"+fit1);
				final_val.append(fit1);
			}
			else
			{
				for(int a=0;a<form.length();a++)
				{
					char dcount = form.charAt(a);
					int time_count = Character.getNumericValue(dcount);
					sb1.append(time_count);
					
					if(sb1.length()==3)
					{
						break;
					}
					
					
				}
				
				String first_fit2 = sb1.toString();
				final_val.append(first_fit2);
				System.out.println("First Calculation output cccc:"+first_fit2);
			}
			
			// Find Last Three Value //
			
			int last_val = (((ran1)*ran1)+((sum)*(sum)))+(((ran1)*ran1)+((sum1)*(sum1)));
			
			String la_val = ""+last_val;
			System.out.println("Last Value:"+la_val);

			
			StringBuffer sb2 = new StringBuffer();
			
			if(la_val.length()==2)
			{
				String last_three=0+""+la_val;
				final_val.append(last_three);
				System.out.println("Second Calculation output:"+last_three);
			}
			else
			{
				for(int a=0;a<la_val.length();a++)
				{
					char dcount1 = la_val.charAt(a);
					int time_count1 = Character.getNumericValue(dcount1);
					sb2.append(time_count1);
					
					if(sb2.length()==3)
					{
						break;
					}
					
				}
				
				String las_three = sb2.toString();
				final_val.append(las_three);
				System.out.println("First Calculation output bbb:"+las_three);
			}
			
			
			 final_output = final_val.toString();
			System.out.println("Final Output :"+final_output);
			
		
		}catch(Exception e)
		{
			
			System.out.println("Exception:"+e);
		}
		
		return final_output;
		
	}
	
	

}
*/


package com.Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.DAO;
import com.Database.adduserdao;
import com.support.CL_SendMail;
import com.support.RandomValue;


/**
 * Servlet implementation class adduseraction
 */
public class AddAccountDetails extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
     
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		String accountNumber = "",accountHolderName="",yyyy="",mm="",dd="",date="",accClosingBalance="",accReferedBy="",accStatus="",mobileNumber="",emailId="";
		int branchId = 0,accountTypeId=0;
		ArrayList<String> randvalue=new ArrayList<String>();
	    boolean flag = false;
	    int check=0;
		ArrayList<String> rand=new ArrayList<String>();
	    RequestDispatcher rd;
		HttpSession hs=request.getSession();
		 Set<String> setone = new HashSet<String>();
	    try 
	    {
		   accountNumber = request.getParameter("acc_no");
		   accountHolderName = request.getParameter("acc_holder");
		   yyyy =request.getParameter("date_yyyy");
		   mm = request.getParameter("date_mm");
		   dd = request.getParameter("date_dd");
		   accountTypeId = Integer.parseInt(request.getParameter("acc_type"));
		   branchId = Integer.parseInt(request.getParameter("branch"));
		   accClosingBalance = request.getParameter("closing_balance");
		   accReferedBy = request.getParameter("reffered_by");
		   accStatus = request.getParameter("status");
		   mobileNumber = request.getParameter("contact");
		   emailId = request.getParameter("email_id");
		   
		  
		   String userid = request.getParameter("acc_id");
		   String userpwd = request.getParameter("acc_pwd");
		   String user_cad_no = request.getParameter("acc_card_no");
		   
		   
		   date = yyyy+"-"+mm+"-"+dd;
		   
		   System.out.println("--------------Date : " + date);
		   
		   
		   //to store random images---------Start------------------------------------------------------
		   
		  
		   int rr=0;
		   String imagename="";
		   
		   Map m = DAO.retrieveImage();
			ArrayList<Integer> img_code1 =(ArrayList) m.get("Image_Code") ;
			ArrayList<String> img_name1 =(ArrayList) m.get("Image_Name") ;


			// Randomly Select 9 Images //
			for(int i=0;i<3;i++)
			{
				
		rr=	getRandomNumberInRange(1, 11);
		
		
		//imagename=DAO.getImageparticulr(rr);

		rand.add(String.valueOf(rr));


			}

			/*for(int i=1;i<4;i++)
			{
				Random r = new Random();
				
				int val = r.nextInt(img_name1.size());
				
			
				
				while(rand.contains(val))
				{
					
					val = r.nextInt(img_name1.size());
					
					
				}
				
					rand.add(String.valueOf(val));
				
			}*/

			System.out.println("rand >>>>>>>>>>>>>>>>>>>>>>>>> :"+rand);
			
			Thread.sleep(1000);
			String elem="";
			
			for(int j=0;j<rand.size();j++)
			{
				
			elem=	rand.get(j);
				randvalue.add(elem);
			System.out.println("element is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+elem);
			
	             boolean flag1=	DAO.updaterandomimages(elem,userid);
			
			System.out.println("flag one is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+flag1);
				
				
			}
			System.out.println("randvalue is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+randvalue);
			setone=	findDuplicates(randvalue);
			System.out.println("setone is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+setone);
		if(setone.isEmpty()==false)
		{
			
			
			for(int i=0;i<3;i++)
			{
				
		rr=	getRandomNumberInRange(1, 11);

		rand.add(String.valueOf(rr));


			}
			
			
			
			/*for(int i=1;i<4;i++)
			{
				Random r = new Random();
				
				int val = r.nextInt(img_name1.size());
				
			
				
				while(rand.contains(val))
				{
					
					val = r.nextInt(img_name1.size());
					
					
				}
				
					rand.add(String.valueOf(val));
				
			}*/
              boolean flag11=	DAO.deleteexistingdata(userid);
			for(int j=0;j<rand.size();j++)
			{
				
			elem=	rand.get(j);
				randvalue.add(elem);
			System.out.println("element is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+elem);
			
			
			
			
	             boolean flag1=	DAO.updaterandomimages(elem,userid);
			
			System.out.println("flag one is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+flag1);
				
				
			}	
		
		}
		
				
		   
		   //to store random images-----End--------------------------------------------------------

		   check=adduserdao.checkAccountExistance(accountNumber);
			
			if(check==0)
			{
				
				
				//String session_code = AddAccountDetails.sessionCode(accountNumber);
				
				  flag=adduserdao.addAccountDetails(accountNumber,date,accountHolderName,accountTypeId,branchId,accClosingBalance,accReferedBy,accStatus,mobileNumber,emailId);
				    
				   // boolean flg = Send_SMS_Service.sendSMS(mobileNumber.trim(), "Session Code:"+session_code.trim());
				    
				   if (flag)
				   {
				
					   hs.setAttribute("emailId", emailId);
								 String message = "Hello  "+accountHolderName+",<br>"+"Your Account Number :"+accountNumber+""+"Your Id :"+userid+"+"+"Your Password :"+userpwd+" ";
					  
				    	boolean sendMailStatus = CL_SendMail.sendPersonalizedMail(emailId, "indprojectemail1@gmail.com", "*projectemail1123", "Account Details",message.trim(),"smtp.gmail.com", "465");
				    	
				    	System.out.println("sendMailStatus :"+sendMailStatus);
				    	
				    	if(sendMailStatus)
				    	{
				    	
				    		adduserdao.addUserDetails(userid,accountHolderName,userpwd,accountNumber,user_cad_no);
							   
				    		hs.setAttribute("add","success");
					    	hs.setAttribute("acc_no", accountNumber);
							rd=request.getRequestDispatcher("account_details.jsp?no=1");
							rd.forward(request,response);
				    	}
				    
				    }
				    else 
				    {
				    	hs.setAttribute("add","failed");
						rd=request.getRequestDispatcher("account_details.jsp");
						rd.forward(request,response);		    
					}
			}
			else if(check==1)
			{
				hs.setAttribute("existenceStatus","yes");
				rd=request.getRequestDispatcher("/Res/JSP/Admin/add_account.jsp");
				rd.forward(request,response);
			}
	   
	    }
	    catch (SQLException e)
	    {
	    	System.out.println("Opps,Exception in Admin-AddAccountDetails Servelet");
			e.printStackTrace();
		}
	    catch (Exception e) 
	    {
	    	System.out.println("Opps,Exception in Admin-AddAccountDetails Servelet");
	    	e.printStackTrace();
		}
	    finally
	    { 
	        out.close();
	    }
	}
	
	public static String sessionCode(String acc_no)
	{
		String final_output="";
		try
		{
			
		
			
			StringBuffer final_val = new StringBuffer();
		String content = acc_no;
		
		RandomValue obj = new RandomValue();
		
		int rand = obj.RandomGen(content);
		
		System.out.println("Total Random Value :"+rand);
		//System.out.println("Start Rand");
		String random = ""+rand;
		//System.out.println("length :"+random.length());
		int ran1=0;
		for(int j =0;j<random.length();j++)
		{
			char c1 = random.charAt(j);
			int count = Character.getNumericValue(c1);
			//System.out.println("Random Number count :"+count);
			ran1 = ran1+count;
			
			
		}
		System.out.println("Sum of Random Number :"+ran1);
		
		
		// Find Sum Of Date //
		
		int sum=0;
		int sumodate = RandomValue.SumOfDate();
		System.out.println("Sum :"+sumodate);
		
		String sumod = ""+sumodate;
		for(int l=0;l<sumod.length();l++)
		{
			char sumofd = sumod.charAt(l);
			int sumofdate = Character.getNumericValue(sumofd);
			sum =sum+sumofdate;
			
			
		}
		
		//System.out.println("Sum of date:"+sum);
		
		// Find Sum of Time //
		
		
			int sum1=0;
			int sumotime = RandomValue.SumOfTime();
			System.out.println("Time :"+sumotime);
		
			String sumotim = ""+sumotime;
			for(int l=0;l<sumotim.length();l++)
			{
				char sumofti = sumotim.charAt(l);
				
				int sumofdate = Character.getNumericValue(sumofti);
				sum1 =sum1+sumofdate;
				
			}
			
			System.out.println("Random Number :"+ran1);
			System.out.println("Sum of Date :"+sum);
			System.out.println("Sum of Time :"+sum1);
			
			// Find First Three Value //
			
			
			int fit = ((ran1)*(ran1))+((sum)*(sum))+((sum1)*(sum1));
			String form = ""+fit;
			
			System.out.println("First Value:"+form);
			
			
			StringBuffer sb1 = new StringBuffer();
			
			if(form.length()==2)
			{
				String fit1=0+""+fit;
				System.out.println("First Calculation output:"+fit1);
				final_val.append(fit1);
			}
			else
			{
				for(int a=0;a<form.length();a++)
				{
					char dcount = form.charAt(a);
					int time_count = Character.getNumericValue(dcount);
					sb1.append(time_count);
					
					if(sb1.length()==3)
					{
						break;
					}
					
					
				}
				
				String first_fit2 = sb1.toString();
				final_val.append(first_fit2);
				System.out.println("First Calculation output cccc:"+first_fit2);
			}
			
			// Find Last Three Value //
			
			int last_val = (((ran1)*ran1)+((sum)*(sum)))+(((ran1)*ran1)+((sum1)*(sum1)));
			
			String la_val = ""+last_val;
			System.out.println("Last Value:"+la_val);

			
			StringBuffer sb2 = new StringBuffer();
			
			if(la_val.length()==2)
			{
				String last_three=0+""+la_val;
				final_val.append(last_three);
				System.out.println("Second Calculation output:"+last_three);
			}
			else
			{
				for(int a=0;a<la_val.length();a++)
				{
					char dcount1 = la_val.charAt(a);
					int time_count1 = Character.getNumericValue(dcount1);
					sb2.append(time_count1);
					
					if(sb2.length()==3)
					{
						break;
					}
					
				}
				
				String las_three = sb2.toString();
				final_val.append(las_three);
				System.out.println("First Calculation output bbb:"+las_three);
			}
			
			
			 final_output = final_val.toString();
			System.out.println("Final Output :"+final_output);
			
		
		}catch(Exception e)
		{
			
			System.out.println("Exception:"+e);
		}
		
		return final_output;
		
	}
	
	public static Set<String> findDuplicates(List<String> listContainingDuplicates) 
	{
 
		final Set<String> setToReturn = new HashSet<String>();
		final Set<String> set1 = new HashSet<String>();
 
		for (String yourInt : listContainingDuplicates)
		{
			if (!set1.add(yourInt))
			{
				setToReturn.add(yourInt);
			}
		}
		
		
		System.out.println("setto return"+setToReturn);
		return setToReturn;
	}
	public static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
}
