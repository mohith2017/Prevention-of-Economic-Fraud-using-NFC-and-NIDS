/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Admin;


import com.Database.DAO;
import com.Database.adduserdao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DeleteBranchDetails extends HttpServlet
{
   
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd;
        HttpSession hs=request.getSession();
        
        int branchId = 0;
        boolean flag = false;
        
        try 
        {
			
        	DAO serverconnector=new DAO();
			java.sql.Connection con = serverconnector.connector();
			Statement st=(Statement) con.createStatement();
			branchId = Integer.parseInt(request.getParameter("branch_id"));
			
			flag = adduserdao.deleteBranchDetails(branchId);
			if(flag)
			{
				hs.setAttribute("delete","success");
				rd=request.getRequestDispatcher("Res/JSP/Admin/branch_details.jsp?no=3");
				rd.forward(request,response);	
			}
			else
			{
				hs.setAttribute("delete","failed");
				rd=request.getRequestDispatcher("Res/JSP/Admin/branch_details.jsp");
				rd.forward(request,response);	
			}

        }
        catch (SQLException e)
        {
			e.printStackTrace();
			hs.setAttribute("delete","failed");
			rd=request.getRequestDispatcher("Res/JSP/Admin/branch_details.jsp");
			rd.forward(request,response);	
		}
        finally
        { 
            out.close();
        }
    } 

  
    
}
