package com.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.adduserdao;



public class UpdateAccountDetails extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		String accountNumber = "",accountHolderName="",yyyy="",mm="",dd="",date="",accClosingBalance="",accReferedBy="",accStatus="",mobileNumber="",emailId="";
		int accountId=0,branchId = 0,accountTypeId=0;
		
	    boolean flag = false;
	    
	    String username= "";
	    
	    RequestDispatcher rd;
		HttpSession hs=request.getSession();
		
	    try 
	    {
	       accountId = Integer.parseInt(request.getParameter("acc_id"));
	    	
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
		   
		   date = yyyy+"-"+mm+"-"+dd;
		   
		       flag=adduserdao.updateAccountDetails(accountId,accountNumber,date,accountHolderName,accountTypeId,branchId,accClosingBalance,accReferedBy,accStatus,mobileNumber,emailId);
				    if (flag)
				    {
				    	/* For Update User Profile in Userlogin Session (Starts) */
				    	 	username = (String) hs.getAttribute("admin_id");
				    	/* For Update User Profile in Userlogin Session (Ends) */
				    	   
				    	   
				    	   if(username == null)
				    	   {
				    		   request.setAttribute("update","success");
				    		   rd=request.getRequestDispatcher("userprofile.jsp");
							   rd.forward(request,response);
				    	   }
				    	   else
				    	   {
				    		     hs.setAttribute("update","success");
								 rd=request.getRequestDispatcher("/Res/JSP/Admin/account_details.jsp?no=3");
								 rd.forward(request,response);
					    	 
				    	   }
				    	 
					}
				    else 
				    {
				    	hs.setAttribute("update","failed");
						rd=request.getRequestDispatcher("/Res/JSP/Admin/account_details.jsp?no=2");
						rd.forward(request,response);			    
					}
			}
	
	    catch (SQLException e)
	    {
	    	System.out.println("Opps,Exception in Admin-UpdateAccountDetails Servelet");
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

}
