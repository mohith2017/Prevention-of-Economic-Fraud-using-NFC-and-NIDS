package com.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.adduserdao;




public class RegisterBenificiary extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		//String accountNumber = "",accountHolderName="",mobileNumber="";
		String accountNumber = "",accountHolderName="",Email="";
	    boolean flag = false;
	    int check = 0;
	    RequestDispatcher rd;
	    ResultSet rs = null;
		HttpSession hs=request.getSession();
		
	    try 
	    {
		   
	       accountNumber = request.getParameter("acc_no");	
		   check = adduserdao.checkAccountExistance(accountNumber);
		   if(check == 1)
		   {
			   rs = adduserdao.getAccountDetailsById(accountNumber);
			   while(rs.next())
			   {
				   accountNumber = rs.getString(2);
				   accountHolderName = rs.getString(4);
			   }
			   
			   hs.setAttribute("acc_info","Get");
			   hs.setAttribute("acc_no",accountNumber);
			   hs.setAttribute("acc_name",accountHolderName);
			   
			   rd = request.getRequestDispatcher("/Res/JSP/User/reg_get_benificiary_details.jsp");
			   rd.forward(request,response);
			   
			   
		   }
		   else
		   {
			   hs.setAttribute("existenceStatus","Yes");
			   rd = request.getRequestDispatcher("/Res/JSP/User/register_benificiary.jsp");
			   rd.forward(request, response);
		   }
			   
		   
	    }
	    
	    catch (Exception e) 
	    {
	    	System.out.println("Opps,Exception in User-RegisterBenificiary Servelet :");
	    	e.printStackTrace();
		}
	    finally
	    { 
	        out.close();
	    }
	}

}
