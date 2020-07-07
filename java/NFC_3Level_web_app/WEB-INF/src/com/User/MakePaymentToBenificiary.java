package com.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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


public class MakePaymentToBenificiary extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		String userAccNumber = "",accountNumber = "",amountToPay="",submit="",transactionLimit="",accTypeId="",
		userBalance="",benificiaryBalance="",userTransactionType="",benificiaryTransactionType="";
	    float transaction_limit = 0,amount_toPay=0,user_balance=0,benificiary_balance=0;
	    int transactionId = 0;
		boolean flag = false;
	    RequestDispatcher rd;
	    ResultSet rs = null;
		HttpSession session=request.getSession();
		
	    try 
	    {
	    	submit = request.getParameter("Action");
	    	
	    	if(submit.equals("Cancel"))
	    	{
	    		   System.out.println("Amount Transfer Process Canceled Successfully...");
		    	   session.setAttribute("validationMsg","canceled");
		    	   rd = request.getRequestDispatcher("usercontent.jsp");
		    	   rd.forward(request, response);
	    	}
	    	else if(submit.equals("Pay Amount"))
		    {
		    	  
	    		 userAccNumber = (String) session.getAttribute("userid");
			     
	  	       String accno = admindao.getAccNo(userAccNumber);
	    		
	    		
	 	        accountNumber = request.getParameter("acc_no");	
	 	        amountToPay = request.getParameter("amt_toPaid");
	 	        
	 	        userTransactionType = "Debited";
	 	        benificiaryTransactionType = "Credited";
	 	        
	 	        rs = adduserdao.getAccountDetailsById(accno);
	 	        if(rs.next())
	 	        {
	 	        	accTypeId = rs.getString(5);
	 	        	userBalance = rs.getString(7);
	 	        }
	 	        
	 	        transactionLimit = UserDAO.getTransactionLimit(accTypeId);
	 	        
	 	        transaction_limit = new Float(transactionLimit);
	 	        amount_toPay = new Float(amountToPay);
	 	        user_balance = new Float(userBalance);
	 	        
	 	        if(amount_toPay <= transaction_limit)
	 	        {
	 	        	rs = adduserdao.getAccountDetailsById(accountNumber);
	 	        	if(rs.next())
	 	 	        {
	 	 	        	benificiaryBalance = rs.getString(7);
	 	 	        }
	 	        	
	 	        	benificiary_balance = new Float(benificiaryBalance);
	 	        	
	 	        	user_balance = user_balance - amount_toPay;
	 	        	
	 	        	benificiary_balance = benificiary_balance + amount_toPay;
	 	        	
	 	        	userBalance = new Float(user_balance).toString();
	 	        	benificiaryBalance = new Float(benificiary_balance).toString();
	 	        	
	 	        	flag = UserDAO.updateAccountBalance(accountNumber, benificiaryBalance);
	 	        	System.out.println("Benificiary Amount Updated Sucessfully...");
	 	        	if(flag)
	 	        	{
	 	        		flag = UserDAO.updateAccountBalance(accno,userBalance);
	 	        		System.out.println("User Amount Updated Sucessfully...");
	 	        		if(flag)
	 	        		{
	 	        			/* Getting The Current Date */
	 	        			
	 	        			Date date = new Date();
	 	        			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
	 	        			String today = f.format(date);
	 	        			/* Adding The Transactions */
	 	        			flag = UserDAO.addTransactionDetails(today,accountNumber,benificiaryTransactionType,amountToPay,accno);
	 	        			flag = UserDAO.addTransactionDetails(today,accno,userTransactionType,amountToPay,accountNumber);
	 	        			
	 	        			
	 	        			if(flag)
	 	        			{
	 	        				transactionId = UserDAO.getMaxTransactionId();
	 	        				session.setAttribute("paymentStatus","Done");
	 	        				session.setAttribute("transaction_id",new Integer(transactionId).toString());
	 	        				session.setAttribute("user_acc_no",accno);
	 	        				session.setAttribute("benf_acc_no",accountNumber);
	 	        				session.setAttribute("amout_paid",amountToPay);
	 	        				
		 	        			rd = request.getRequestDispatcher("Res/JSP/User/make_payment.jsp?no=2");
				 	        	rd.forward(request, response);
	 	        			}
	 	        			else
	 	        			{
	 	        				System.out.println("Opps,Something Went Wrong....");
	 	        				session.setAttribute("error","Yes");
			 	        		rd = request.getRequestDispatcher("Res/JSP/User/make_payment.jsp?no=1");
				 	        	rd.forward(request, response);
	 	        			}
	 	        			
	 	        			
	 	        			
	 	        		}
	 	        		else
	 	        		{
	 	        			session.setAttribute("error","Yes");
		 	        		rd = request.getRequestDispatcher("Res/JSP/User/make_payment.jsp?no=1");
			 	        	rd.forward(request, response);
	 	        		}
	 	        	}
	 	        	else
	 	        	{
	 	        		session.setAttribute("error","Yes");
	 	        		rd = request.getRequestDispatcher("Res/JSP/User/make_payment.jsp?no=1");
		 	        	rd.forward(request, response);
	 	        	}
	 	        	
	 	        }
	 	        else
	 	        {
	 	        	session.setAttribute("validationMsg","outOfLimit");
	 	        	session.setAttribute("transLimit",transactionLimit);
	 	        	rd = request.getRequestDispatcher("Res/JSP/User/make_payment.jsp");
	 	        	rd.forward(request, response);
	 	        }
	 	        
	 	       
	 	       System.out.println("***** Payment Information *****");
	 	       System.out.println("User Acc Number : " + userAccNumber);
	 	       System.out.println("Benificiary Acc Number : " + accountNumber);
	 	       System.out.println("Amount To Pay : " + amountToPay);
	 	       System.out.println("Amount TypeId : " + accTypeId);
	 	       System.out.println("Transaction Limit  : " + transactionLimit);
	 	       System.out.println("User Balance  : " + userBalance);
	 	       System.out.println("Benificiary Balance  : " + benificiaryBalance);
	 	       System.out.println("Transaction Id : " + transactionId);
	 	       
		    }
		   
	    
	    }
	    
	    catch (Exception e) 
	    {
	    	System.out.println("Opps,Exception in User-MakePaymentToBenificiary Servelet :");
	    	e.printStackTrace();
		}
	    finally
	    { 
	        out.close();
	    }
	}

}
