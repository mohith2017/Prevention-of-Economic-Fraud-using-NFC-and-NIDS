/**
 * 
 */
package com.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import com.sun.corba.se.spi.orbutil.fsm.State;


public class DAO 
{
	private static DAO dao=null;
		public static DAO getInstance()
	{
		if(dao==null)
		{
			dao=new DAO();
		}
		return dao;
	}
	public Connection connector()
	{
		Connection con=null;
		try {

			Class.forName(Global.JDBC_DRIVER);
			
			System.out.println("Driver has loaded");
			con = DriverManager.getConnection(Global.JDBC_HOST_URL_WITH_DBNAME,Global.DATABASE_USERNAME, Global.DATABASE_PASSWORD);
			System.out.println("Connected" + con);

		} catch (Exception e) 
		{
			System.out.println("Exception in serverconnector-->connector(): "+ e);
		}
		return con;
	}
	
	
	public static boolean updatestatus(String uid)
	{
		
		boolean flag = false;
		try
		{
			DAO dao=DAO.getInstance();
			Connection connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql="update m_transactionone set status='done' where acc_name='"+uid.trim()+"'";
			
			System.out.println(sql);
			
			int i = statement.executeUpdate(sql);
			
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in DAO-->getImage(): "+ e);
		}
		
		return flag;
	}
	public static String getusername()
	{
		StringBuffer sb=new StringBuffer();
		String name="";
		try
		{
			DAO dao=DAO.getInstance();
			Connection connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql = "select acc_name from m_transactionone";
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			System.out.println("<<<<<<<<<<<<<sql>>>>>>>>"+sql);
			
			 while(resultSet.next())
			 {
				
				 
				 name=	resultSet.getString(1) ;
			
					
			 }
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return name;
	}	
	public static ArrayList getImage()
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			Connection connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql="select img_name from m_image";
			
			System.out.println(sql);
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next())
			{
				list.add(resultSet.getString(1));
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in DAO-->getImage(): "+ e);
		}
		
		return list;
	}
	
	
	
	public static String getImageparticulr(int id)
	{
		String data="";
		
		try
		{
			DAO dao=DAO.getInstance();
			Connection connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql="select img_name from m_image where img_id='"+id+"'";
			
			System.out.println(sql);
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next())
			{
			data	=resultSet.getString(1);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in DAO-->getImageparticulr(): "+ e);
		}
		
		return data;
	}
	public static Map retrieveImage()
	{
		Map m=new HashMap(); 
		
		ArrayList<Integer> img_id = new ArrayList<Integer>();
		ArrayList<String> img_name = new ArrayList<String>();
		try
		{
			DAO dao=DAO.getInstance();
			Connection connection=dao.connector();
			Statement statement = connection.createStatement();
			String sql = "select img_id,img_name from m_image";
			
			ResultSet resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				/*img_code.add(resultSet.getInt(1)) ;
				img_name.add(resultSet.getString(2));*/
				 
				 img_id.add(resultSet.getInt(1)) ;
					img_name.add(resultSet.getString(2));
			 }
			 int len = img_id.size();
			 int len1 = img_name.size();
			 System.out.println("len"+len+" "+"len1 "+len1);
			 
			 m.put("Image_Id", img_id);
			 m.put("Image_Name", img_name);
			 
			System.out.println("Retrieving Process Completed......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return m;
	}
	
	public static String retrieveImageone(String uid)
	{
		StringBuffer sb=new StringBuffer();
		
		try
		{
			DAO dao=DAO.getInstance();
			Connection connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql = "select img_name from img_selected where user_id='"+uid+"'";
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			System.out.println("<<<<<<<<<<<<<sql>>>>>>>>"+sql);
			
			 while(resultSet.next())
			 {
				
				 
				 sb.append(resultSet.getString(1)) ;
				 sb.append(",");
					
			 }
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return sb.toString();
	}
	public static boolean updaterandomimages(String imageid,String userid)
	{	ResultSet rs=null;
		
		boolean flag =false;
		try
		{
			DAO dao=DAO.getInstance();
			Connection connection=dao.connector();
			Statement statement = connection.createStatement();
			String imagename="";
			
			String sql="select img_name from m_image where img_id='"+imageid+"'";
			
rs= statement.executeQuery(sql);
			
			while(rs.next())
			{
				
			imagename=	rs.getString(1);
				
    
			
			
		}
			
		
			  String sql1="insert into img_selected(user_id,img_name) values('"+userid+"','"+imagename+"')";
				
				
				System.out.println(sql1);
				
				int i = statement.executeUpdate(sql1);
				
				if(i!=0)
				{
					flag=true;
				}
		
		
		}
		catch(Exception e)
		{
			System.out.println("Exception in DAO-->updaterandomimages(): "+ e);
		}
		
		return flag;
	}
	
public static boolean deleteexistingdata(String uid)
	{
		
		boolean flag =false;
		try
		{
			DAO dao=DAO.getInstance();
			Connection connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql="delete from img_selected where user_id='"+uid+"'";
			System.out.println(sql);
			
			int i = statement.executeUpdate(sql);
			
			if(i!=0)
			{
				flag=true;
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in DAO-->deleteexistingdata(): "+ e);
		}
		
		return flag;
	}
	
	/*public static boolean updateSeImage(String imgnm,int x,int y,String xcoordinate,String ycoordinate)
	{
		
		boolean flag =false;
		try
		{
			DAO dao=DAO.getInstance();
			Connection connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql="update img_selected set off_set='"+x+","+y+"',for_img='"+xcoordinate+","+ycoordinate+"',selected='Y' where img_name='"+imgnm+"'";
			
			System.out.println(sql);
			
			int i = statement.executeUpdate(sql);
			
			if(i!=0)
			{
				flag=true;
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in DAO-->getImage(): "+ e);
		}
		
		return flag;
	}
	*/
	/*public static boolean updateUserImage(String imgnm,int x,int y,String xcoordinate,String ycoordinate)
	{
		
		boolean flag =false;
		try
		{
			DAO dao=DAO.getInstance();
			Connection connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql="update cgp_logincheck set off_set='"+x+","+y+"',for_img='"+xcoordinate+","+ycoordinate+"',selected='Y' where img_name='"+imgnm+"'";
			
			System.out.println(sql);
			
			int i = statement.executeUpdate(sql);
			
			if(i!=0)
			{
				flag=true;
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in DAO-->updateUserImage(): "+ e);
		}
		
		return flag;
	}
	*/
	
	public static ArrayList getImageName(String uid)
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			Connection connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql="select img_name from img_selected where userid='"+uid+"'";
			
			System.out.println(sql);
			
			ResultSet i = statement.executeQuery(sql);
			
			while(i.next())
			{
				list.add(i.getString(1));
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in DAO-->getImage(): "+ e);
		}
		
		return list;
	}
	
	public static ArrayList loginImageName(String uid)
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			Connection connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql="select img_name from cgp_logincheck where userid='"+uid+"'";
			
			System.out.println(sql);
			
			ResultSet i = statement.executeQuery(sql);
			
			while(i.next())
			{
				list.add(i.getString(1));
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in DAO-->getImage(): "+ e);
		}
		
		return list;
	}
	
}
