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


import com.Database.admindao;
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class adminchangepwdaction
 */
public class adminchangepwdaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminchangepwdaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		
        int flag=0;
        RequestDispatcher rd;
		HttpSession hs=request.getSession();
		try
		{
		String id=request.getParameter("admin_id");
		String pwdold=request.getParameter("old_password");
		String pwd=request.getParameter("new_password");
		String conpwd=request.getParameter("confirm_password");
		flag = admindao.logindao(id, pwdold);
		
		if(flag==1)
		{
			if(pwd.equals(conpwd))
			{
				flag=admindao.changepwd(id ,pwd);
				
				if(flag==1)
				{
					//hs.setAttribute("update","success");
					rd=request.getRequestDispatcher("/Res/JSP/Admin/adminchangepwd.jsp?no=1");
					rd.forward(request,response);
				}
			}
			else
			{
			
					
					rd=request.getRequestDispatcher("/Res/JSP/Admin/adminchangepwd.jsp?no=4");
					rd.forward(request,response);
			}
			
		}
		else
		{
			//hs.setAttribute("update","failed");
			rd=request.getRequestDispatcher("/Res/JSP/Admin/adminchangepwd.jsp?no=3");
			rd.forward(request,response);	
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
            out.close();
        }
	}
}
