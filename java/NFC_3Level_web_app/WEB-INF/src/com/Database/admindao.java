package com.Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class admindao
 */
public class admindao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public admindao() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static int logindao(String adminid, String adminpass) throws SQLException
	{
		int flag=0;
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		String sql = "";

		try
		{
			DAO obj=new DAO();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");

			sql="select admin_id,admin_pwd from m_admin where admin_id='"+adminid+"' and admin_pwd='"+adminpass+"'";
			System.out.println(sql);
			rs=(ResultSet) stmt.executeQuery(sql);

			while(rs.next())
			{
	
				flag=1;
			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			con.close();
		}

		return flag;
	}
    
    
    
    
    public static int changepwd(String adminid, String newpwd) throws SQLException
	{
		int flag=0,n2;
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;

		try
		{
			DAO obj=new DAO();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");
			
			n2=stmt.executeUpdate("update m_admin set admin_pwd='"+newpwd+"' where admin_id='"+adminid+"'");
			
			System.out.println(n2);
			if(n2==1)
			{
				flag=1;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			con.close();
		}

		return flag;
	}
    
    public static int upfateSession(String accno, String session) throws SQLException
	{
		int flag=0,n2;
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;

		try
		{
			DAO obj=new DAO();
			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");
			
			n2=stmt.executeUpdate("update m_account set session_code='"+session+"' where acc_no='"+accno+"'");
			
			System.out.println(n2);
			if(n2==1)
			{
				flag=1;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			con.close();
		}

		return flag;
	}
    
    public static String username(String adminid) throws SQLException
	{
		int flag=0;
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		String name="";
		try
		{
			DAO obj=new DAO();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");

			String sql="select admin_name from m_admin where admin_id='"+adminid+"'";
			
			rs=(ResultSet) stmt.executeQuery(sql);

			while(rs.next())
			{
				name=rs.getString("admin_name");
			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			con.close();
		}

		return name;
	}
    
    public static String getAccno() throws SQLException
	{
		int flag=0;
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		String name="";
		try
		{
			DAO obj=new DAO();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");

			String sql="select acc_no from m_account ";
			
			rs=(ResultSet) stmt.executeQuery(sql);

			while(rs.next())
			{
				name=rs.getString(1)+"~";
			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			con.close();
		}

		return name;
	}
    
    public static String getAccNo(String userid) throws SQLException
	{
		int flag=0;
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		String accno="";
		try
		{
			DAO obj=new DAO();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");

			String sql="select acc_no from m_user where u_name='"+userid.trim()+"'";
			
			rs=(ResultSet) stmt.executeQuery(sql);

			while(rs.next())
			{
				accno=rs.getString(1);
			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			con.close();
		}

		return accno;
	}
    
    public static String getSscode(String userid) throws SQLException
	{
		int flag=0;
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		String accno="";
		try
		{
			DAO obj=new DAO();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");

			String sql="select session_code from m_account where acc_no='"+userid+"'";
			
			rs=(ResultSet) stmt.executeQuery(sql);

			while(rs.next())
			{
				accno=rs.getString(1);
			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			con.close();
		}

		return accno;
	}
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs2=request.getSession();
	}

}
