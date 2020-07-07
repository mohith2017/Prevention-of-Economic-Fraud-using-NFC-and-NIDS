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



public class ConfirmBenificiary1 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
	//	String userAccNumber = "",accountNumber = "",accountHolderName="",mobileNumber="",submit="",msg="";
		String userAccNumber = "",accountNumber = "",accountHolderName="",Email="",submit="",msg="";
	    boolean flag = false;
	    int check = 0,urn=0;
	    RequestDispatcher rd;
	    ResultSet rs = null;
		HttpSession hs=request.getSession();
		
	    try 
	    {
		  
	    	String email=(String) hs.getAttribute("emailId");
	    	
	    	System.out.println(">>>>>>>>>>>>>>>>>>>email:"+email);
	    	
	    	userAccNumber = (String) hs.getAttribute("userid");
	       
	       String accno = admindao.getAccNo(userAccNumber);
	       
	       System.out.println("userAccNumber :"+userAccNumber);
	       
	       accountNumber = request.getParameter("acc_no");	
	       
	       System.out.println(">>>>>>>>>"+accountNumber);
	       
	       accountHolderName = request.getParameter("acc_name");
	       System.out.println(">>>>>>>accountHolderName>>>>>>>>"+accountHolderName);
	       
	      /* String userid = request.getParameter("u_id");
	       
	       System.out.println(">>>>>>>>userid>>>>>>>>>"+userid);*/
	       
	       submit = request.getParameter("RegAction");
	       
	       if(submit.equals("Confirm Registeration"))
	       {
	    	   
	    	   urn = GenerateRandomNumber.generate4digitNumber();
	    	   
	    	   flag = UserDAO.addAccountBenificiaryDetails(accno,accountNumber,accountHolderName,urn,email);
	    	   
	    	   if(flag)
	    	   {
	    		   rs = adduserdao.getAccountDetailsById(accno);
	    		   /*while(rs.next())
	    		   {
	    			  // mobileNumber = rs.getString("mobileno");
	    			 //  Email = rs.getString("email");
	    			   Email = request.getParameter("email");
	    		   }*/
	    			   
	    		   msg = "URN Number : " + urn+"\n"+"Now You Can Confirm the Benificiary By Providing the URN Number.";
	    		  // flag = SendMSG.sendSMS(mobileNumber,msg);
	    		   
	    		String message = "Hello  "+accountHolderName+",<br>"+"Your Account Number :"+accountNumber+",<br>"+"Your URN Number:"+urn+"<br>"+"Get Your URN Number to Emailid By click on below link";
	    		
	    		
	    		System.out.println("<<<<<<<<<<<<<<<<<<<message"+message);
					
	    		  // boolean flg = Send_SMS_Service.sendSMS(mobileNumber.trim(), msg.trim());
	    		   //boolean flg = CL_SendMail.sendPersonalizedMail(Email.trim(), msg.trim());
	    			//boolean flg = CL_SendMail.sendPersonalizedMail(Email, "captchaimages@gmail.com", "captcha@dhs", "Account Details",msg.trim(),"smtp.gmail.com", "465");
	    			
	    			boolean sendMailStatus = CL_SendMail.sendPersonalizedMail(email, "indprojectemail1@gmail.com", "*projectemail1123", "Account Details",message.trim(),"smtp.gmail.com", "465");
	    			System.out.println("flg of Email :"+sendMailStatus);
			    	
	    		   if(sendMailStatus)
	    		   {
	    			   hs.setAttribute("status","Yes");
	    			 //  System.out.println("URN Number Sent Sucessfully to MobileNumber : " + mobileNumber);
	    			   System.out.println("URN Number Sent Sucessfully to Emailid : " + Email);
	    			   rd = request.getRequestDispatcher("Res/JSP/User/reg_get_benificiary_details.jsp?no=1");
	    			   rd.forward(request, response);
	    		   }
	    		   else
	    		   {
	    			  // System.out.println("Opps,Unable to Send URN Number to MobileNumber : " + mobileNumber);
	    			   System.out.println("Opps,Unable to Send URN Number to Emailid : " + Email);
	    			   
	    			   hs.setAttribute("status","No");
	    			   //System.out.println("URN Number Sent Sucessfully to MobileNumber : " + mobileNumber);
	    			   System.out.println("URN Number Sent Sucessfully to Emailid : " + Email);
	    			   rd = request.getRequestDispatcher("Res/JSP/User/reg_get_benificiary_details.jsp?no=2");
	    			   rd.forward(request, response);
	    		   }
	    		
	    	   }
	    	   else
	    	   {
	    		   System.out.println("Opps,Somthing Went Wrong!!!");
	    	   }
		       
	       }
	       else
	       {
	    	   System.out.println("Registration Canceled...............");
	       }
		  
	    }
	    
	    catch (Exception e) 
	    {
	    	System.out.println("Opps,Exception in User-ConfirmBenificiary Servelet :");
	    	e.printStackTrace();
		}
	    finally
	    { 
	        out.close();
	    }
	}

}
