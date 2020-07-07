package com.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.UserDAO;
import com.Database.adduserdao;
import com.Database.admindao;
import com.support.CL_SendMail;
import com.support.GenerateRandomNumber;
import com.support.Send_SMS_Service;




public class ConfirmBenificiary extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();

		String userAccNumber = "",accountNumber = "",accountHolderName="",Email="",submit="",msg="";
	    boolean flag = false;
	    int check = 0,urn=0;
	    RequestDispatcher rd;
	    ResultSet rs = null;
		HttpSession hs=request.getSession();
		
	    try 
	    {
		  
	    	/*String emailId=(String) hs.getAttribute("emailId");
	    	
	    	System.out.println(">>>>>>>>>>>>>>>>>>>emailId from Session Object::::::::::::::::"+emailId);
	    	
	    	String mobileNumber=(String) hs.getAttribute("contact");
	    	System.out.println(">>>>>>>>>>>>>>>>>>>mobile no from Session Object::::::::::::::::"+mobileNumber);
*/
	    	
	    	
	    	
	    	
	    	
	    	userAccNumber = (String) hs.getAttribute("userid");
	    	 System.out.println("userAccNumber :"+userAccNumber);
	       
	       String accno = admindao.getAccNo(userAccNumber);
	       
	      System.out.println("accno::::::::::"+accno);
	       
	       accountNumber = request.getParameter("acc_no");	
	       
	       System.out.println(">>>>accountNumber>>>>>"+accountNumber);
	       
	       accountHolderName = request.getParameter("acc_name");
	       System.out.println(">>>>>>>accountHolderName>>>>>>>>"+accountHolderName);
	       
	      String email=adduserdao.getMail(accountNumber);
	      
	      String mobileno=adduserdao.getmobileno(accno);
	      System.out.println(":::::::::::::mobileno::::::::::::"+mobileno);
	      
	      System.out.println("::::::::::::::email::::::::::::::"+email);
	       submit = request.getParameter("RegAction");
	       
	       if(submit.equals("Confirm Registeration"))
	       {
	    	   
	    	   urn = GenerateRandomNumber.generate4digitNumber();
	    	   
	    	   flag = UserDAO.addAccountBenificiaryDetails(accno,accountNumber,accountHolderName,urn,email);
	    	   
	    	   if(flag)
	    	   {
	    		   rs = adduserdao.getAccountDetailsById(accno);
	    		 
	    			   
	    		   msg = "URN Number : " + urn+"\n"+"Now You Can Confirm the Benificiary By Providing the URN Number.";
	    		
	    		   
	    		String message = "Hello  "+accountHolderName+",<br>"+"Your Account Number :"+accountNumber+",<br>"+"Your URN Number:"+urn+"<br>";
	    		
	    		
	    		System.out.println("<<<<<<<<<<<<<<<<<<<message"+message);
					
	    	
	    			
	    			boolean sendMailStatus = CL_SendMail.sendPersonalizedMail(email, "indprojectemail1@gmail.com", "*projectemail1123", "Account Details",message.trim(),"smtp.gmail.com", "465");
	    			System.out.println("flg of Email :"+sendMailStatus);
	    			
	    			
	    			/*Send_SMS_Service.sendSMS(mobileno, message);
	    			System.out.println(":::::::::::::::sendSMS done successfully::::::::::");
	    		*/
			    	
	    		   if(sendMailStatus)
	    		   {
	    			   hs.setAttribute("status","Yes");
	    			
	    			  // System.out.println("URN Number Sent Sucessfully to Emailid : " + emailId);
	    			   rd = request.getRequestDispatcher("Res/JSP/User/reg_get_benificiary_details.jsp?no=1");
	    			   rd.forward(request, response);
	    		   }
	    		   else
	    		   {
	    			 
	    			  // System.out.println("Opps,Unable to Send URN Number to Emailid : " + emailId);
	    			   
	    			   hs.setAttribute("status","No");
	    			   
	    			   //System.out.println("URN Number Sent Sucessfully to Emailid : " + emailId);
	    			   rd = request.getRequestDispatcher("Res/JSP/User/reg_get_benificiary_details.jsp?no=2");
	    			   rd.forward(request, response);
	    		   }
	    		
	    	   }
	    	 /*  else
	    	   {
	    		   System.out.println("Opps,Somthing Went Wrong!!!");
	    	   }
		       */
	       }
	       else
	       {
	    	   System.out.println("Registration Canceled...............");
	       }
		  
	    }
	    
	    catch (Exception e) 
	    {
	    	//System.out.println("Opps,Exception in User-ConfirmBenificiary Servelet :");
	    	System.out.println(e);
		}
	    finally
	    { 
	        out.close();
	    }
	}

}
