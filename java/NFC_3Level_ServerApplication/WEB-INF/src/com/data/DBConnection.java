package  com.data;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBConnection {
	/**
	 * Method to create DB Connection
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("finally")
	public static Connection createConnection() throws Exception {
		Connection con = null;
		try {
			Class.forName(Constants.dbClass);
			con = DriverManager.getConnection(Constants.dbUrl, Constants.dbUser, Constants.dbPwd);
		} catch (Exception e) {
			throw e;
		} finally {
			return con;
		}
	}
    
	public static boolean updatepatterndata(String name, String pattern) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "update m_user set  dash_matrix_code='"+pattern+ "' where u_id='"+name+"' ";
			System.out.println(query);
			int records = stmt.executeUpdate(query);
			//System.out.println(records);
			//When record is successfully inserted
			if (records > 0) 
			{
				insertStatus = true;
			}
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return insertStatus;
	}
    
	public static boolean updatenewpass(String name, String pass) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "update m_user set  u_pass='"+pass+ "' where u_id='"+name+"' ";
			System.out.println(query);
			int records = stmt.executeUpdate(query);
			//System.out.println(records);
			//When record is successfully inserted
			if (records > 0) 
			{
				insertStatus = true;
			}
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return insertStatus;
	}
	
	public static boolean updatenewadmin(String curpass, String newpass) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "update m_admin set  admin_pwd='"+newpass+ "' ";
			System.out.println(query);
			int records = stmt.executeUpdate(query);
			//System.out.println(records);
			//When record is successfully inserted
			if (records > 0) 
			{
				insertStatus = true;
			}
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return insertStatus;
	}
	public static boolean updateamount(int price, String tno,int orderno,String stsus,String itemname,String qua,String prr) throws SQLException, Exception {
		boolean insertStatus = false;
		boolean insertStatus1 = false;
		Connection dbConn = null;
		int total=0;
		String st="yes";
		int amount=0;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			Statement stmt = dbConn.createStatement();
			String query = "update m_order set amount='"+price+"' where table_no='"+Integer.parseInt(tno)+"' and order_no='"+orderno+"' and status='"+stsus+"' ";
			System.out.println(query);
			int records = stmt.executeUpdate(query);
			//System.out.println(records);
			//When record is successfully inserted
			if (records > 0) {
				insertStatus = true;
			}
		if(insertStatus)
		{
		String gg=	itemname.replace("[", "");
		String ina=	gg.replace("[", "");
			Statement stmt1 = dbConn.createStatement();
			String query1 = "update t_order set status_order='"+st+"' where item_name='"+ina.trim()+"' and order_no='"+orderno+"' and quantity='"+Integer.parseInt(qua)+"' and price='"+prr.trim()+"'";
			System.out.println(query1);
			int records1 = stmt1.executeUpdate(query1);
			//System.out.println(records);
			//When record is successfully inserted
			if (records1 > 0) {
				insertStatus1 = true;
			}
			
			
			
			
		}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} 
		catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return insertStatus1;
	}
	/*public static boolean updateTotalWork() throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "update m_employee set logout_time='"+time+"' where emp_id='"+empno+"' and emp_name='"+empName+"' and date='"+date+"' ";
			System.out.println(query);
			int records = stmt.executeUpdate(query);
			//System.out.println(records);
			//When record is successfully inserted
			if (records > 0) {
				insertStatus = true;
			}
		} 
		catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return insertStatus;
	}
	*/
	public static boolean checkcustDetails(String user) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "select * from m_customer where name='"+user+"'";
			System.out.println(query);
			ResultSet records = stmt.executeQuery(query);
			//System.out.println(records);
			//When record is successfully inserted
			while(records.next())
			{
				insertStatus = true;
			}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return insertStatus;
	}
	public static boolean checkoldpassadmin(String oldpass) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "select * from m_admin where admin_pwd='"+oldpass+"' ";
			System.out.println(query);
			ResultSet records = stmt.executeQuery(query);
			//System.out.println(records);
			//When record is successfully inserted
			while(records.next())
			{
				insertStatus = true;
			}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return insertStatus;
	}
	
	public static boolean checkoldpassuser(String user,String oldpass) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "select * from m_user where u_id='"+user+"' and u_pass='"+oldpass+"'";
			System.out.println(query);
			ResultSet records = stmt.executeQuery(query);
			//System.out.println(records);
			//When record is successfully inserted
			while(records.next())
			{
				insertStatus = true;
			}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return insertStatus;
	}
	public static int selecttotalamount(String tno,String ono) throws SQLException, Exception {
		boolean insertStatus = false;
		int price=0;
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "select amount from m_order where order_no='"+tno+"' and table_no='"+ono+"'";
			System.out.println(query);
			ResultSet records = stmt.executeQuery(query);
			//System.out.println(records);
			//When record is successfully inserted
			while(records.next())
			{
			price=	records.getInt(1);
			}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return price;
	}
	
	public static String getusermailid(String uid) throws SQLException, Exception {
		boolean insertStatus = false;
		String mail="";
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "select mail from m_customer where name='"+uid+"'";
			System.out.println(query);
			ResultSet records = stmt.executeQuery(query);
			//System.out.println(records);
			//When record is successfully inserted
			while(records.next())
			{
				mail=	records.getString(1);
			}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return mail;
	}
	
	public static ArrayList<String> selectitems(String ono) throws SQLException, Exception {
		boolean insertStatus = false;
		ArrayList<String> data=new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "select * from t_order where order_no='"+ono+"'";
			System.out.println(query);
			ResultSet records = stmt.executeQuery(query);
			//System.out.println(records);
			//When record is successfully inserted
			while(records.next())
			{
				data.add(records.getString(3)+"           "+records.getString(4)+"      "+records.getString(5));
		
			}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return data;
	}
	
	
	
	
	
	
	
	public static int takeamount(String tno,int ordernum,String ssttus) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		int amount=0;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt1 = dbConn.createStatement();
			String query1 = "select amount from m_order where order_no='"+ordernum+"' and table_no='"+Integer.parseInt(tno)+"' and status='"+ssttus+"'";
			System.out.println(query1);
			ResultSet rs = stmt1.executeQuery(query1);
			while(rs.next())
			{
				
			amount=	rs.getInt(1);
				
			}
		
		System.out.println("amount amount is >>>>>>>>>>>>>>>>>>>"+amount);
			//System.out.println(records);
			//When record is successfully inserted
			
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return amount;
	}
	
	public static ArrayList<String> getordereddetails(int ordernum) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		ResultSet rs=null;
		int amount=0;
		ArrayList<String> ll=new ArrayList<String> ();
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt1 = dbConn.createStatement();
			String query1 = "select * from t_order where order_no='"+ordernum+"'";
			System.out.println(query1);
			 rs = stmt1.executeQuery(query1);
			 while(rs.next())
				{
					ll.add(rs.getString(3)+"  "+rs.getInt(4)+"  "+rs.getString(5));
					
					
					
				}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return ll;
	}
	
	public static int selectordernum(String tno) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		int i=0;
		String sts="process";
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "select order_no from m_order where table_no='"+tno+"' and status='"+sts+"'";
			System.out.println(query);
			ResultSet records = stmt.executeQuery(query);
			//System.out.println(records);
			//When record is successfully inserted
			while(records.next())
			{
				i=records.getInt(1);
			}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return i;
	}
	
	public static String getpinuser(String user) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		String pin="";
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "select pin from m_customer where name='"+user+"'";
			System.out.println(query);
			ResultSet records = stmt.executeQuery(query);
			//System.out.println(records);
			//When record is successfully inserted
			while(records.next())
			{
				
			pin=	records.getString(1);
				
			
			}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return pin;
	}
	public static String getmailuser(String user) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		String mail="";
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "select mail from m_customer where name='"+user+"'";
			System.out.println(query);
			ResultSet records = stmt.executeQuery(query);
			//System.out.println(records);
			//When record is successfully inserted
			while(records.next())
			{
				
			mail=	records.getString(1);
				
			
			}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return mail;
	}
	
	public static double getCompLatitude()
	{
		String sql="";
		double latitude = 0;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "select latitude from m_complocation where lo_code='1'";
			System.out.println("********** Getting Bus Latitude By busRouteNumber **********");
			System.out.println(sql);
			ResultSet resultSet = stmt.executeQuery(sql);
			while(resultSet.next())
			{
				latitude = resultSet.getDouble(1);
				
			}
			System.out.println(" Latitude : [1]: "+latitude);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getBusStatus(String busRouteNumber) : ");
			e.printStackTrace();
		}
		return latitude;
	}
	
	public static double getCompLongitude()
	{
		String sql="";
		double longitude = 0;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "select longitude from m_complocation where lo_code='1'";
			System.out.println("********** Getting Bus Longitude By busRouteNumber **********");
			System.out.println(sql);
			ResultSet resultSet = stmt.executeQuery(sql);
			while(resultSet.next())
			{
				longitude = resultSet.getDouble(1);
			}
			System.out.println("comp Longitude : [1]: "+longitude);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getBusLongitude(String busRouteNumber) : ");
			e.printStackTrace();
		}
		return longitude;
	}
	
	public static double getEmpLatitude(String emp_id)
	{
		String sql="";
		double latitude = 0;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "select latitude from m_emplylocation where emp_code='"+emp_id+"' order by lo_code desc limit 1";
			System.out.println("********** Getting Bus Latitude By busRouteNumber **********");
			System.out.println(sql);
			ResultSet resultSet = stmt.executeQuery(sql);
			while(resultSet.next())
			{
				latitude = resultSet.getDouble(1);
				
			}
			System.out.println(" Latitude : [1]: "+latitude);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getBusStatus(String busRouteNumber) : ");
			e.printStackTrace();
		}
		return latitude;
	}
	
	public static double getEmpLongitude(String emp_id)
	{
		String sql="";
		double longitude = 0;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "select longitude from m_emplylocation where emp_code='"+emp_id+"' order by lo_code desc limit 1";
			System.out.println("********** Getting Bus Longitude By busRouteNumber **********");
			System.out.println(sql);
			ResultSet resultSet = stmt.executeQuery(sql);
			while(resultSet.next())
			{
				longitude = resultSet.getDouble(1);
			}
			System.out.println("comp Longitude : [1]: "+longitude);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getBusLongitude(String busRouteNumber) : ");
			e.printStackTrace();
		}
		return longitude;
	}
	
	
	public static boolean checkuser(String username,String password)
	{
		String sql="";
		boolean flag=false;
		String statsu="no";
		double longitude = 0;
		ResultSet resultSet =null;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "select * from m_user where u_id='"+username+"' and u_pass='"+password+"'";
			
			System.out.println(sql);
		    resultSet = stmt.executeQuery(sql);
		    
		    while(resultSet.next())
		    {
		    	flag=true;
		    	
		    }
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>selectitems : ");
			e.printStackTrace();
		}
		return flag;
	}
	public static boolean checkadmin(String username,String password)
	{
		String sql="";
		boolean flag=false;
		String statsu="no";
		double longitude = 0;
		ResultSet resultSet =null;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "select * from m_admin where admin_id='"+username+"' and admin_pwd='"+password+"'";
			
			System.out.println(sql);
		    resultSet = stmt.executeQuery(sql);
		    
		    while(resultSet.next())
		    {
		    	flag=true;
		    	
		    }
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>selectitems : ");
			e.printStackTrace();
		}
		return flag;
	}
	public static boolean checkATMlogin(String username,String password)
	{
		String sql="";
		boolean flag=false;
		String statsu="no";
		double longitude = 0;
		ResultSet resultSet =null;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "select * from m_atm_login where atm_code='"+username+"' and password='"+password+"'";
			
			System.out.println(sql);
		    resultSet = stmt.executeQuery(sql);
		    
		    while(resultSet.next())
		    {
		    	flag=true;
		    	
		    }
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>selectitems : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static String checkaccnum(String anum,String aname,String phone,String email)
	{
		String sql="";
		boolean flag=false;
		String statsu="";
		double longitude = 0;
		ResultSet resultSet =null;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "select acc_name from m_account where acc_no='"+anum+"' and acc_name='"+aname+"' and mobileno='"+phone+"' and email_id='"+email+"'";
			
			System.out.println(sql);
		    resultSet = stmt.executeQuery(sql);
		    
		    while(resultSet.next())
		    {
		    	statsu=resultSet.getString(1);
		    	
		    }
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>selectitems : ");
			e.printStackTrace();
		}
		return statsu;
	}
	
	
	
	public static String takeaccuser(String name)
	{
		String sql="";
		boolean flag=false;
		String statsu="";
		double longitude = 0;
		ResultSet resultSet =null;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "select u_no from m_user where u_id='"+name+"'";
			
			System.out.println(sql);
		    resultSet = stmt.executeQuery(sql);
		    
		    while(resultSet.next())
		    {
		    	statsu=resultSet.getString(1);
		    	
		    }
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>selectitems : ");
			e.printStackTrace();
		}
		return statsu;
	}
	
	
	public static ArrayList< String> getvalues()
	{
		ArrayList< String> list=new ArrayList<>();
		
		String sql="";
		boolean flag=false;
		String statsu="no";
		double longitude = 0;
		ResultSet resultSet =null;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "select atm_branch,atm_macinie_num from m_atm_login";
			
			System.out.println(sql);
		    resultSet = stmt.executeQuery(sql);
		    
		    while(resultSet.next())
		    {
		    	list.add(resultSet.getString(1)+"~~"+resultSet.getString(2));
		    	
		    }
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>selectitems : ");
			e.printStackTrace();
		}
		return list;
	}
	public static boolean insertorderdetails(int oid,String item,String qua,String price,String dte)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "insert into t_order(order_no,item_name,quantity,price,dte) values('"+oid+"','"+item+"','"+Integer.parseInt(qua)+"','"+price+"','"+dte+"')";
		
			System.out.println(sql);
			i = stmt.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in insertorderdetails: ");
			e.printStackTrace();
		}
		return flag;
	}
	


	public static void inserttransdetails(String userid, String accn,
			String bankname, String bankbrabch, String accountname,
			String acctype, String phonenu, String emailid, String machinecode) {
		boolean flag=false;
		String sql = "";
		int i=0;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "insert into m_transactionone(atm_branch,machine_code,acc_no,bank_name,bank_branch,acc_name,acc_type,phone_num,email_id,userid) values((select atm_branch from m_atm_login where atm_macinie_num='"+machinecode+"'),'"+machinecode+"','"+accn+"','"+bankname+"','"+bankbrabch+"','"+accountname+"','"+acctype+"','"+phonenu+"','"+emailid+"','"+userid+"')";
		
			System.out.println(sql);
			i = stmt.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in insertorderdetails: ");
			e.printStackTrace();
		}
		
		
	}

	public static boolean checkdata(String machinecode, String accn,
			String accountname, String phonenu, String emailid) {
		String sql="";
		boolean flag=false;
		String statsu="";
		double longitude = 0;
		ResultSet resultSet =null;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "select * from m_transactionone  where machine_code='"+machinecode+"' and acc_no='"+accn+"' and acc_name='"+accountname+"' and phone_num='"+phonenu+"' and email_id='"+emailid+"'";
			
			System.out.println(sql);
		    resultSet = stmt.executeQuery(sql);
		    
		    while(resultSet.next())
		    {
		    	flag=true;
		    	
		    }
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>selectitems : ");
			e.printStackTrace();
		}
		return flag;
	}
	
}
