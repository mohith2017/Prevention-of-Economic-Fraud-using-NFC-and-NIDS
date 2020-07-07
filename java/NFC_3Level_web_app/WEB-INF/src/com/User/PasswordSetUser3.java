package com.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.DAO;
import com.Database.UserDAO;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.BooleanType;
import com.support.Algo;
import com.support.HashingTechnique;
import com.support.RandomValue;

public class PasswordSetUser3 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("<<<<<<<<<<Its Came inside passwordimageset class");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		RequestDispatcher rd=null;
		
		boolean flag = false;
		
		String uid=request.getParameter("userid");
		
		String desc=request.getParameter("desc");
		
		String imgname=request.getParameter("imgnme");
		
		
		
		String has_mac = HashingTechnique.MD5(desc);
		System.out.println("has_mac------>>>"+has_mac);
		
		//Boolean flag1 = UserDAO.Checkuserimage(uid, imgname, desc, has_mac);
	boolean flag1 = UserDAO.Checkuserimage(uid.trim(), imgname, desc, has_mac);
		
		if(flag1)
		{
			System.out.println("its came inside ");
			session.setAttribute("user", uid);
			rd = request.getRequestDispatcher("/Res/JSP/userhome.jsp");
			rd.forward(request,response);
			
		}
		else
		{
			rd = request.getRequestDispatcher("checkpassword_set3.jsp?no=1");
			rd.forward(request,response);
		
			
		}
		
		
	}
}
