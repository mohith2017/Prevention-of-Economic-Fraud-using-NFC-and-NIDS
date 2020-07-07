package com.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.adduserdao;



/**
 * Servlet implementation class adduseraction
 */
public class AddBranchDetails extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		String branchName = "",branchRemarks="";
		
	    boolean flag = false;
	    int check=0;
	    RequestDispatcher rd;
		HttpSession hs=request.getSession();
		
	    try 
	    {
		   branchName = request.getParameter("branch_name");	
		   branchRemarks =request.getParameter("branch_remarks");
			
		   check=adduserdao.checkBranchExistance(branchName);
			
			if(check==0)
			{
				    flag=adduserdao.addBranchDetails(branchName,branchRemarks);
				    if (flag)
				    {
				    	//hs.setAttribute("add","success");
				    	
				    			
						rd=request.getRequestDispatcher("/Res/JSP/Admin/branch_details.jsp?no=1");
						rd.forward(request,response);
					}
				    else 
				    {
				    	//hs.setAttribute("add","failed");
						rd=request.getRequestDispatcher("/Res/JSP/Admin/branch_details.jsp?no=2");
						rd.forward(request,response);			    
					}
			}
			else if(check==1)
			{
				//hs.setAttribute("existenceStatus","yes");
				rd=request.getRequestDispatcher("/Res/JSP/Admin/add_branch.jsp?no=1");
				rd.forward(request,response);
			}
	   
	    }
	    catch (SQLException e)
	    {
	    	System.out.println("Opps,Exception in Admin-AddBranchDetails Servelet");
			e.printStackTrace();
		}
	    catch (Exception e) 
	    {
	    	System.out.println("Opps,Exception in Admin-AddBranchDetails Servelet");
	    	e.printStackTrace();
		}
	    finally
	    { 
	        out.close();
	    }
	}

}
