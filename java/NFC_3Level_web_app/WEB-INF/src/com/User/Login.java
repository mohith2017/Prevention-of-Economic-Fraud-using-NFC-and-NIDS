
package com.User;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.UserDAO;





public class Login extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		boolean flag = false;
		
		try
		{
			//get User Details //
			String userid=request.getParameter("uid");
			String pass=request.getParameter("pwd");
			
			
			boolean fg = UserDAO.checkLogin(userid.trim(), pass);
			System.out.println("<<<<<<<<<<<<<>>>>>>>>>>>>"+fg);

			if(fg)
			{
				
				UserDAO.upadtetatus(userid);
				System.out.println("came inside");
				
				session.setAttribute("userid",userid);
				
				
							
					RequestDispatcher rd=request.getRequestDispatcher("/Res/JSP/userhome.jsp");
					rd.forward(request, response);
				}
				else
				{
					//response.sendRedirect(request.getContextPath()+"?no=1");
					
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp?no=1");
					rd.forward(request, response);
				}
				
				boolean b=UserDAO.dashMatrix(userid.trim());
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Exception is in User->NewUser Servlet : ");
			e.printStackTrace();
			out.println("Opps's Exception is in User->NewUser Servlet : ");
			e.printStackTrace();
		}
	}
}

