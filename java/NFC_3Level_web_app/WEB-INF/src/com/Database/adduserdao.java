package com.Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Database.DAO;



/**
 * Servlet implementation class adduserdao
 */
public class adduserdao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adduserdao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static int checkid(String id) throws Exception
	{
		int check=0;

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

			rs=stmt.executeQuery("select user_id from m_user where user_id='"+id+"'");

			while(rs.next())
			{
				check=1;
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

		return check;
	}
	
    
    
    
    public static int adduser(String user_id,String user_name,String user_dob,String user_sex,String user_address,String user_email,String user_cellno,String user_qualification,String user_designation,String user_country,String user_pin ) throws SQLException
	{
		int flag=0;

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

			String sql="insert into m_user(user_id,user_name,user_dob,user_sex,user_address,user_email,user_cellno,user_qualification,user_designation,user_country,user_pin,user_pwd,user_flag) values('"+user_id+"','"
					+ user_name + "','" + user_dob + "','" + user_sex + "','" + user_address + "','" + user_email + "','" + user_cellno + "','" + user_qualification + "','" + user_designation + "','" + user_country + "','" + user_pin + "','-null-','f')";
			
			int n=stmt.executeUpdate(sql);

			if(n==1)
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
	
    public static int addUserDetails(String uid,String name,String pwd,String accno,String cardno) throws SQLException
	{
		int flag=0;

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

			String sql="insert into m_user(u_id,u_name,u_pass,acc_no,card_no,hash_code) values('"+uid+"','"+ name + "','" + pwd + "','" + accno + "','" + cardno + "','0')";
			
			System.out.println(sql);
			
			int n=stmt.executeUpdate(sql);

			if(n==1)
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
	
    
    /* Checking Branch Existence */
    
    public static int checkBranchExistance(String branceName) throws Exception
	{
		int check=0;
		String sql = "";

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

			sql = "select * from m_branch where branch_name='"+branceName+"'";
			
			System.out.println("****** Check Branch Existance Info ******");
			System.out.println(sql);
			
			rs=stmt.executeQuery(sql);

			while(rs.next())
			{
				check=1;
			}
			
			System.out.println("Check Branch Existence Status : " + check);

		}
		catch(Exception e)
		{
			System.out.println("Opps,Exception in adduserdao-checkBranchExistance(String branceName):");
			System.out.println(e.getMessage());
		}
		finally
		{
			con.close();
		}

		return check;
	}
    
    /* Adding the Branch Details */
    
    public static boolean addBranchDetails(String branchName,String remarks) throws SQLException
	{
		boolean flag = false;
		String sql = "";

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
			
			sql = "insert into m_branch(branch_name,branch_remarks) values('"+branchName+"','"+remarks+"')";
			
			System.out.println("****** Add Branch Details Info ******");
			System.out.println(sql);

			int n=stmt.executeUpdate(sql);

			if(n==1)
			{
				flag=true;
			}
			
			System.out.println("Add Branch Details Status : " + flag);

		}
		catch(Exception e)
		{
			System.out.println("Opps,Exception in adduserdao-addBranchDetails():");
			System.out.println(e.getMessage());
		}
		finally
		{
			con.close();
		}

		return flag;
	}
    
    /* Getting The Branch Details */
    
    public static ResultSet getBranchDetailsById(int branchId)
    {
    	Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		String sql = "";
		
		try
		{
			DAO obj=new DAO();
			
			con = obj.connector();
			stmt = con.createStatement();
			
			sql = "select * from m_branch where branch_code='"+branchId+"'";
			rs = stmt.executeQuery(sql);
		} 
		catch (SQLException e) 
		{
			System.out.println("Opps,Exception in adduserdao-getBranchDetailsById(int branchId):");
			e.printStackTrace();
		}
		
		return rs;
    }
    
    /* Updating The Branch Details */
    
    public static boolean updateBranchDetails(int branchId,String branchName,String remarks) throws SQLException
	{
		boolean flag = false;
		String sql = "";

		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;

		try
		{
			DAO obj = new DAO();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");
			
			sql = "update m_branch set branch_name='"+branchName+"',branch_remarks='"+remarks+"' where branch_code='"+branchId+"'";
			
			System.out.println("****** Edit Branch Details Info ******");
			System.out.println(sql);

			int n=stmt.executeUpdate(sql);

			if(n==1)
			{
				flag=true;
			}
			
			System.out.println("Edit Branch Details Status : " + flag);

		}
		catch(Exception e)
		{
			System.out.println("Opps,Exception in adduserdao-updateBranchDetails(): ");
			System.out.println(e.getMessage());
		}
		finally
		{
			con.close();
		}

		return flag;
	}
    
 /* Deleting The Branch Details */
    
    public static boolean deleteBranchDetails(int branchId) throws SQLException
	{
		boolean flag = false;
		String sql = "";

		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;

		try
		{
			DAO obj = new DAO();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");
			
			sql = "delete from m_branch where branch_code='"+branchId+"'";
			
			System.out.println("****** Delete Branch Details Info ******");
			System.out.println(sql);

			int n=stmt.executeUpdate(sql);

			if(n==1)
			{
				flag=true;
			}
			
			System.out.println("Delete Branch Details Status : " + flag);

		}
		catch(Exception e)
		{
			System.out.println("Opps,Exception in adduserdao-deleteBranchDetails(int branchId) : ");
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			con.close();
		}

		return flag;
	}
    
    /* Get Account Type By Id */
    
    public static String getAccountTypeById(int accountTypeId) throws SQLException
	{
		String accountType = "";
		String sql = "";

		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;

		try
		{
			DAO obj = new DAO();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");
			
			sql = "select acc_type_name from m_acc_type where acc_type_code='"+accountTypeId+"'";
			
			System.out.println("****** Get Account Type By Id Info ******");
			System.out.println(sql);

			rs =stmt.executeQuery(sql);

			while(rs.next())
			{
				accountType = rs.getString(1);
			}
			
			System.out.println("Account Type : " + accountType);

		}
		catch(Exception e)
		{
			System.out.println("Opps,Exception in adduserdao-getAccountTypeById(int accountTypeId) : ");
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			con.close();
		}

		return accountType;
	}
    
 /* Get Account Type By Id */
    
    public static String getBranchById(int branchId) throws SQLException
	{
		String branch = "";
		String sql = "";

		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;

		try
		{
			DAO obj = new DAO();

			con = obj.connector();
			System.out.println("Connection Established !");

			stmt=con.createStatement();
			System.out.println("Statment Established !");
			
			sql = "select branch_name from m_branch where branch_code='"+branchId+"'";
			
			System.out.println("****** Get Branch By Id Info ******");
			System.out.println(sql);

			rs =stmt.executeQuery(sql);

			while(rs.next())
			{
				branch = rs.getString(1);
			}
			
			System.out.println("Baranch Name  : " + branch);

		}
		catch(Exception e)
		{
			System.out.println("Opps,Exception in adduserdao-getBranchById(int branchId) : ");
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			con.close();
		}

		return branch;
	}
    
 /* Getting The Account Details */
    
    public static ResultSet getAccountDetailsById(String accountNumber)
    {
    	Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		String sql = "";
		
		try
		{
			DAO obj = new DAO();
			con = obj.connector();
			stmt = con.createStatement();
			
			sql = "select * from m_account where acc_no='"+accountNumber+"'";
			rs = stmt.executeQuery(sql);
		} 
		catch (SQLException e) 
		{
			System.out.println("Opps,Exception in adduserdao-getAccountDetailsById(int accountNumber):");
			e.printStackTrace();
		}
		
		return rs;
    }
    
/* Getting The User Details */
    
    public static ResultSet getAccountDetailsById1(String uid)
    {
    	Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		String sql = "";
		
		try
		{
			DAO obj = new DAO();
			con = obj.connector();
			stmt = con.createStatement();
			
			sql = "select *from m_account where acc_name=(select u_name from m_user where u_name='"+uid.trim()+"')";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
		} 
		catch (SQLException e) 
		{
			System.out.println("Opps,Exception in adduserdao-getAccountDetailsById(int accountNumber):");
			e.printStackTrace();
		}
		
		return rs;
    }
    
    /* Getting Account Type Details */
    
    public static ResultSet getAccountType()
    {
    	Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		String sql = "";
		
		try
		{
			DAO obj = new DAO();
			con = obj.connector();
			stmt = con.createStatement();
			
			sql = "select * from m_acc_type";
			rs = stmt.executeQuery(sql);
		} 
		catch (SQLException e) 
		{
			System.out.println("Opps,Exception in adduserdao-getAccountType():");
			e.printStackTrace();
		}
		
		return rs;
    }
    
 /* Getting Branch Details */
    
    public static ResultSet getBranchDetails()
    {
    	Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		String sql = "";
		
		try
		{
			DAO dao = new DAO();
			con = dao.connector();
			stmt = con.createStatement();
			
			sql = "select * from m_branch";
			rs = stmt.executeQuery(sql);
		} 
		catch (SQLException e) 
		{
			System.out.println("Opps,Exception in adduserdao-getBranchDetails():");
			e.printStackTrace();
		}
		
		return rs;
    }
    
 /* Adding the Branch Details */
    
    public static boolean addAccountDetails(String accountNumber,String openingDate,String accountHolderName,int accountType,int branch,String closingBalance,String referedBy,String status,String contactNumber,String emailId) throws SQLException
	{
		boolean flag = false;
		int imgCode = 0;
		String sql = "";
		String password = "-null-";
		String mflag = "f";

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
			
			sql = "insert into m_account(acc_no,acc_open_date,acc_name,acc_type_code,branch_code,acc_closing_balance,acc_referedby,acc_status,mobileno,email_id,password,flag,img_code) values('"+accountNumber+"','"+openingDate+"','"+accountHolderName+"','"+accountType+"','"+branch+"','"+closingBalance+"','"+referedBy+"','"+status+"','"+contactNumber+"','"+emailId+"','"+password+"','"+mflag+"','"+imgCode+"')";
			
			System.out.println("****** Add Account Details Info ******");
			System.out.println(sql);

			int n=stmt.executeUpdate(sql);

			if(n==1)
			{
				flag=true;
			}
			
			System.out.println("Add Account Details Status : " + flag);

		}
		catch(Exception e)
		{
			System.out.println("Opps,Exception in adduserdao-addAccountDetails():");
			e.printStackTrace();
		}
		finally
		{
			con.close();
		}

		return flag;
	}
    
/* Checking Account Existence */
    
    public static int checkAccountExistance(String accountNumber) throws Exception
	{
		int check=0;
		String sql = "";

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

			sql = "select * from m_account where acc_no='"+accountNumber+"'";
			
			System.out.println("****** Check Account Existance Info ******");
			System.out.println(sql);
			
			rs=stmt.executeQuery(sql);

			while(rs.next())
			{
				check=1;
			}
			
			System.out.println("Check Branch Existence Status : " + check);

		}
		catch(Exception e)
		{
			System.out.println("Opps,Exception in adduserdao-checkAccountExistance(String accountNumber):");
			System.out.println(e.getMessage());
		}
		finally
		{
			con.close();
		}

		return check;
	}
    
 /* Updating The Account Details */
    
    public static boolean updateAccountDetails(int accountId,String accountNumber,String openingDate,String accountHolderName,int accountType,int branch,String closingBalance,String referedBy,String status,String contactNumber,String emailId) throws SQLException
	{
		boolean flag = false;
		String sql = "";

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
			
			sql = "update m_account set acc_open_date='"+openingDate+"',acc_name='"+accountHolderName+"',acc_type_code='"+accountType+"',branch_code='"+branch+"',acc_closing_balance='"+closingBalance+"',acc_referedby='"+referedBy+"',acc_status='"+status+"',mobileno='"+contactNumber+"',email_id='"+emailId+"' where acc_id='"+accountId+"'";
			
			System.out.println("****** Edit Account Details Info ******");
			System.out.println(sql);

			int n=stmt.executeUpdate(sql);

			if(n==1)
			{
				flag=true;
			}
			
			System.out.println("Edit Account Details Status : " + flag);

		}
		catch(Exception e)
		{
			System.out.println("Opps,Exception in adduserdao-updateAccountDetails(): ");
			e.printStackTrace();
		}
		finally
		{
			con.close();
		}

		return flag;
	}
    
/* Deleting The Account Details */
    
    public static boolean deleteAccountDetails(String accountNumber) throws SQLException
	{
		boolean flag = false;
		String sql = "";

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
			
			sql = "delete from m_account where acc_no='"+accountNumber+"'";
			
			System.out.println("****** Delete Account Details Info ******");
			System.out.println(sql);

			int n=stmt.executeUpdate(sql);

			if(n==1)
			{
				flag=true;
			}
			
			System.out.println("Delete Delete Details Status : " + flag);

		}
		catch(Exception e)
		{
			System.out.println("Opps,Exception in deleteAccountDetails(String accountNumber) : ");
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			con.close();
		}

		return flag;
	}
  //select the email id
    
    public static String getMail(String accountNumber) throws SQLException
   	{
   		int flag=0;
   		Connection con=null;
   		Statement stmt = null;
   		ResultSet rs=null;
   		String email="";
   		try
   		{
   			DAO obj=new DAO();

   			con = obj.connector();
   			System.out.println("Connection Established !");

   			stmt=con.createStatement();
   			System.out.println("Statment Established !");

   			String sql="select email_id from m_account where acc_no='"+accountNumber+"'";
   			
   			rs=(ResultSet) stmt.executeQuery(sql);

   			while(rs.next())
   			{
   				email=rs.getString(1);
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

   		return email;
   	}
       
//getmobile no
    
    public static String getmobileno(String accountNumber) throws SQLException
   	{
   		int flag=0;
   		Connection con=null;
   		Statement stmt = null;
   		ResultSet rs=null;
   		String mobileno="";
   		try
   		{
   			DAO obj=new DAO();

   			con = obj.connector();
   			System.out.println("Connection Established !");

   			stmt=con.createStatement();
   			System.out.println("Statment Established !");

   			String sql="select mobileno from m_account where acc_no='"+accountNumber+"'";
   			
   			rs=(ResultSet) stmt.executeQuery(sql);

   			while(rs.next())
   			{
   				mobileno=rs.getString(1);
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

   		return mobileno;
   	}
       


    
    
}
