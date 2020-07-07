package com.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO
{
	static Connection connection=null;
	static Statement statement=null;
	static ResultSet rs=null;
	
	
	//User Catcha Graphical Details //
	
	public static List getImagecode(String uid)
	{
		
		List list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			Statement statement = connection.createStatement();
			
			//String sql="select img_code,off_set from img_selected where selected='Y' and userid='"+uid+"'";
			
			String sql="select user_id,img_name,img_desc,img_hash from img_selected where userid='"+uid+"'";
			
			System.out.println(sql);
			
			rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				list.add(rs.getString(1)+"-"+rs.getString(2)+rs.getString(3)+"-"+rs.getString(4)+"-");
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in DAO-->getImage(): "+ e);
		}
		
		return list;
	}
	public static List getImagecode1(String uid)
	{
		
		List list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql="select user_id,img_name,img_desc,img_hash from img_selected where userid='"+uid+"'";
			
			System.out.println(sql);
			
			rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				list.add(rs.getString(1)+"-"+rs.getString(2));
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in DAO-->getImage(): "+ e);
		}
		
		return list;
	}
	
	public static String checkOffsetInfo(String uid)
	{
		
		StringBuffer list =new StringBuffer();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql="select img_code,off_set from cgp_logincheck where selected='Y' and userid='"+uid+"'";
			
			System.out.println(sql);
			
			rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				list.append(rs.getString(1)+"-"+rs.getString(2)+"~");
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in DAO-->getImage(): "+ e);
		}
		
		return list.toString();
	}
	
	public static String getHashMac(String uid)
	{
		
		String hashmac ="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql="select hash_code from m_user where u_id='"+uid+"'";
			
			System.out.println(sql);
			
			rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				hashmac = rs.getString(1);
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in DAO-->getImage(): "+ e);
		}
		
		return hashmac.trim();
	}
	
	
	public static ArrayList getSelectedImage(String uid)
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql="select img_code,img_name from  img_selected where selected='Y' and userid='"+uid+"'";
			
			System.out.println(sql);
			
			rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				list.add(rs.getString(1)+"~"+rs.getString(2));
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getSelectedImage(): "+ e);
		}
		
		return list;
	}
	
	public static ArrayList getSelectedImageCode(String uid)
	{
		
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql="select img_code from  img_selected where selected='Y' and userid='"+uid+"'";
			
			System.out.println(sql);
			
			rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				list.add(rs.getString(1));
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getSelectedImage(): "+ e);
		}
		
		return list;
	}
	
	public static int getCount(String uid)
	{
		
		int count=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql="select count(*) from img_selected where userid='"+uid+"' and selected='Y'";
			
			System.out.println(sql);
			
			rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				count = rs.getInt(1);
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getSelectedImage(): "+ e);
		}
		
		return count;
	}
	
	public static boolean checkLogin(String uid,String pass)
	{
		
		boolean flag = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql="select * from  m_user where u_name='"+uid+"' and dash_matrix_code='"+pass+"'";
			
			System.out.println(sql);
			
			rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in DAO-->checkLogin(): "+ e);
		}
		
		return flag;
	}
	
	public static boolean updateHMAC(String uid,String hashcode)
	{
		
		boolean flag = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql="update m_user set hash_code='"+hashcode+"' where u_id='"+uid+"'";
			
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
	public static boolean upadtetatus(String uid)
	{
		
		boolean flag = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
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
	public static boolean emptyTable()
	{
		
		boolean flag = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			Statement statement = connection.createStatement();
			
			String sql="truncate table cgp_logincheck";
			
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
	
	// User Transaction Details //
	
	 public static String getStatus(String id) throws SQLException
		{
			int flag=0;
			Connection con=null;
			Statement stmt = null;
			ResultSet rs=null;

			String status = null;
			try
			{
				DAO obj=new DAO();

				con = obj.connector();
				System.out.println("Connection Established !");

				stmt=con.createStatement();
				System.out.println("Statment Established !");

				//String sql="select user_id,user_pwd from m_user where user_id='"+id+"' and user_pwd='"+pass+"'";
				//String sql="select * from m_account where acc_no='"+id+"' and password='"+pass+"'";
				
				
				String sql="select temp_pwd_status from m_nuser where user_id='"+id+"'";
				rs=(ResultSet) stmt.executeQuery(sql);

				while(rs.next())
				{
					
					status=rs.getString(1);
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

			return status;
		}
	   
	    public static int logindao_temp(String id, String pass) throws SQLException
		{
			int flag=0;
			Connection con=null;
			Statement stmt = null;
			ResultSet rs=null;
			String statu = null;
			try
			{
				DAO obj=new DAO();

				con = obj.connector();
				System.out.println("Connection Established !");

				stmt=con.createStatement();
				System.out.println("Statment Established !");

				//String sql="select user_id,user_pwd from m_user where user_id='"+id+"' and user_pwd='"+pass+"'";
				//String sql="select * from m_account where acc_no='"+id+"' and password='"+pass+"'";
				
				 statu = UserDAO.getStatus(id);
				 
				if(statu.trim().equals("OFF"))
				{
					System.out.println("Template Password OFF Status ");
					String sql="select * from m_nuser where user_id='"+id+"' and user_pwd='"+pass+"'";
					rs=(ResultSet) stmt.executeQuery(sql);

					while(rs.next())
					{
						
						flag=1;
					}
					
				}
				else
				{
					System.out.println("Template Password ON Status ");
					String chk_pwd = selectcheckPass(id);
					String sql="select * from m_nuser where user_id='"+id+"' and check_pwd='"+chk_pwd+"'";
					rs=(ResultSet) stmt.executeQuery(sql);

					while(rs.next())
					{
						
						flag=1;
					}
					
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
	    
	    public static String selectcheckPass(String id) throws SQLException
		{
			String checkpass="";
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

				//String sql="select user_id,user_pwd from m_user where user_id='"+id+"' and user_pwd='"+pass+"'";
				//String sql="select * from m_account where acc_no='"+id+"' and password='"+pass+"'";
				
					String sql="select check_pwd from m_nuser where user_id='"+id+"'";
					rs=(ResultSet) stmt.executeQuery(sql);

					while(rs.next())
					{
						
						checkpass=rs.getString(1);
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

			return checkpass;
		}
	    public static boolean selectdata() throws SQLException
			{
				String checkpass="";
				Connection con=null;
				Statement stmt = null;
				ResultSet rs=null;
          boolean flag=false;
				try
				{
					DAO obj=new DAO();

					con = obj.connector();
					System.out.println("Connection Established !");

					stmt=con.createStatement();
					System.out.println("Statment Established !");

					//String sql="select user_id,user_pwd from m_user where user_id='"+id+"' and user_pwd='"+pass+"'";
					//String sql="select * from m_account where acc_no='"+id+"' and password='"+pass+"'";
					
						String sql="select * from m_transactionone where status='done'";
						rs=(ResultSet) stmt.executeQuery(sql);

						while(rs.next())
						{
							
							flag=true;
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
	    public static ArrayList getaccountNo(String id) throws SQLException
		{
			String checkpass="";
			Connection con=null;
			Statement stmt = null;
			ResultSet rs=null;
			
			ArrayList list = new ArrayList();

			try
			{
				DAO obj=new DAO();

				con = obj.connector();
				System.out.println("Connection Established !");

				stmt=con.createStatement();
				System.out.println("Statment Established !");

				//String sql="select user_id,user_pwd from m_user where user_id='"+id+"' and user_pwd='"+pass+"'";
				//String sql="select * from m_account where acc_no='"+id+"' and password='"+pass+"'";
				
					String sql="select acc_no,card_number from m_nuser where user_id='"+id+"'";
					rs=(ResultSet) stmt.executeQuery(sql);

					while(rs.next())
					{
						list.add(rs.getString(1));
						list.add(rs.getString(2));
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

			return list;
		}
	    
	    public static ArrayList select_tempno() throws SQLException
		{
			int flag=0;
			Connection con=null;
			Statement stmt = null;
			ResultSet rs=null;

			ArrayList list = new ArrayList();
			try
			{
				DAO obj=new DAO();

				con = obj.connector();
				System.out.println("Connection Established !");

				stmt=con.createStatement();
				System.out.println("Statment Established !");

				String sql="select temp_no from m_template";
				System.out.println("sql "+sql);
				rs=stmt.executeQuery(sql);

				while(rs.next())
				{
					
					list.add(rs.getInt(1));
				}

				System.out.println("Data "+list.size());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			finally
			{
				con.close();
			}

			return list;
		}
	    
	    public static boolean updateTemp_Pass(String tp_status,String temp_no,String checkpass,String userid) throws SQLException
		{
			boolean flag = false;
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

				String sql="update m_nuser set temp_pwd_status='"+tp_status+"',temp_pwd_no='"+temp_no+"',check_pwd='"+checkpass+"' where user_id='"+userid+"'";
				System.out.println("sql "+sql);
				stmt.executeUpdate(sql);

				flag = true;
				

				System.out.println("Update Status "+flag);
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
	    
	    public static boolean updateNormalStatus(String tp_status,String userid) throws SQLException
		{
			boolean flag = false;
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

				String sql="update m_nuser set temp_pwd_status='"+tp_status+"',temp_pwd_no='null',check_pwd='null' where user_id='"+userid+"'";
				System.out.println("sql "+sql);
				stmt.executeUpdate(sql);
					flag = true;
				
				System.out.println("Update Status "+flag);
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
	    
	    public static String username(String id) throws SQLException
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

				String sql="select user_name from m_user where user_id='"+id+"'";
				
				rs=(ResultSet) stmt.executeQuery(sql);

				while(rs.next())
				{
					name=rs.getString(1);
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
	    
	    
	    public static String code(String id) throws SQLException
		{
			int flag=0;
			Connection con=null;
			Statement stmt = null;
			ResultSet rs=null;
			String code="";
			try
			{
				DAO obj=new DAO();

				con = obj.connector();
				System.out.println("Connection Established !");

				stmt=con.createStatement();
				System.out.println("Statment Established !");

				String sql="select user_code from m_user where user_id='"+id+"'";
				
				rs=(ResultSet) stmt.executeQuery(sql);

				while(rs.next())
				{
					code=rs.getString("user_code");
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

			return code;
		}
	    
	    
	    public static int checkeligibledao(String user_code,String ele_code) throws SQLException
		{
			int cc=0;
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

				String sql="select * from m_election_vote";
				
				rs= stmt.executeQuery(sql);
					
				while(rs.next())
				{
					String ucode=rs.getString("user_code");
					
					String ecode=rs.getString("ele_code");
					
					if(ucode.equals(user_code))
					{
						if(ecode.equals(ele_code))
						{
						
							cc=1;
						
						}
					}
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
			
			return cc;
		}
	    
	    
	    public static int castvotedao(String user_code,String ele_code,String can_code) throws SQLException
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
				System.out.println(user_code);
				String sql="insert into m_election_vote(user_code,ele_code,can_code) values('"+user_code+"','"+ele_code+"','"+can_code+"')";
				
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
	    
	    public static int votingcount(String can_code) throws SQLException
		{
			int flag=0;
			Connection con=null;
			Statement stmt = null;
			ResultSet rs=null;
		    int no = 0;
			try
			{
				DAO obj=new DAO();

				con = obj.connector();
				System.out.println("Connection Established !");

				stmt=con.createStatement();
				System.out.println("Statment Established !");
				rs=stmt.executeQuery("select * from m_election_candidate where can_code='"+can_code+"'");
				
				while(rs.next())
				{
					no=rs.getInt("can_no_votes");
				}
				no=no+1;
				String sql="update m_election_candidate set can_no_votes='"+no+"' where can_code='"+can_code+"'";
				
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
	    
	  /* Adding the Benificiary Details */
	    
	    public static boolean addAccountBenificiaryDetails(String userAccNumber,String accountNumber,String AccountHolder,int userRegNumber,String Email) throws SQLException
		{
			boolean flag = false;
			String sql = "";
			String status = "Pending";

			Connection con=null;
			Statement stmt = null;

			try
			{
				DAO obj=new DAO();

				con = obj.connector();
				System.out.println("Connection Established !");

				stmt=con.createStatement();
				System.out.println("Statment Established !");
				
				sql = "insert into m_benificiary(user_acc_no,b_acc_no,b_acc_holder,b_urn,b_status) values('"+userAccNumber+"','"+accountNumber+"','"+AccountHolder+"','"+userRegNumber+"','"+status+"')";
				
				System.out.println("****** Add Account Benificiary Details Info ******");
				System.out.println(sql);

				int n=stmt.executeUpdate(sql);

				if(n==1)
				{
					flag=true;
				}
				
				System.out.println("Add Account Benificiary Status : " + flag);

			}
			catch(Exception e)
			{
				System.out.println("Opps,Exception in userdao-Account Benificiary):");
				System.out.println(e.getMessage());
			}
			finally
			{
				con.close();
			}

			return flag;
		}
	    
	    /* Getting The Pending Benificiary Details */
	    
	    public static ResultSet getPendingBenificiaryDetails(String userAccNumber)
	    {
	    	Connection con=null;
			Statement stmt = null;
			ResultSet rs=null;
			String sql = "";
			String status = "Pending";
			
			try
			{
				DAO serverconnector =new DAO();
				con = serverconnector.connector();
				stmt = con.createStatement();
				
				sql = "select * from m_benificiary where b_status='"+status+"' and user_acc_no='"+userAccNumber+"'";
				rs = stmt.executeQuery(sql);
			} 
			catch (SQLException e) 
			{
				System.out.println("Opps,Exception in userdao-getPendingBenificiaryDetails():");
				e.printStackTrace();
			}
			return rs;
	    }
	    
	/* Getting The Confirmed Benificiary Details */
	    
	    public static ResultSet getConfirmedBenificiaryDetails(String userAccNumber)
	    {
	    	Connection con=null;
			Statement stmt = null;
			ResultSet rs=null;
			String sql = "";
			String status = "Confirmed";
			System.out.println(userAccNumber);
			try
			{
				DAO serverconnector =new DAO();
				con = serverconnector.connector();
				stmt = con.createStatement();
				
				sql = "select * from m_benificiary where b_status='"+status+"' or user_acc_no='"+userAccNumber+"'";
				rs = stmt.executeQuery(sql);
				System.out.println(sql);
			} 
			catch (SQLException e) 
			{
				System.out.println("Opps,Exception in userdao-getPendingBenificiaryDetails():");
				e.printStackTrace();
			}
			return rs;
	    }
	    
	/* Deleting The Branch Details */
	    
	    public static boolean deleteBenificiaryDetails(String userAccNumber,String accountNumber) throws SQLException
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
				
				sql = "delete from m_benificiary where user_acc_no='"+userAccNumber+"' and b_acc_no='"+accountNumber+"'";
				
				System.out.println("****** Reject Benificiary Info ******");
				System.out.println(sql);

				int n=stmt.executeUpdate(sql);

				if(n>0)
				{
					flag=true;
				}
				
				System.out.println("Reject Benificiary Status : " + flag);

			}
			catch(Exception e)
			{
				System.out.println("Opps,Exception in userdao-deleteBenificiaryDetails(String accountNumber) : ");
				//System.out.println(e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				con.close();
			}

			return flag;
		}
	    
	    /* Checking The Urn Existence */
	    
	 /* Checking Branch Existence */
	    
	    public static boolean deletedata() throws SQLException
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
				
				sql = "delete from m_transactionone where status='done' ";
				
				System.out.println("****** Reject Benificiary Info ******");
				System.out.println(sql);

				int n=stmt.executeUpdate(sql);

				if(n>0)
				{
					flag=true;
				}
				
				System.out.println("Reject Benificiary Status : " + flag);

			}
			catch(Exception e)
			{
				
				//System.out.println(e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				con.close();
			}

			return flag;
		}
	      
	    public static int checkUrnExistance(String userAccNumber,String benificiaryAccNumber,String urnNumber) throws Exception
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

				sql = "select * from m_benificiary where user_acc_no='"+userAccNumber+"' and b_acc_no='"+benificiaryAccNumber+"' and  b_urn='"+urnNumber+"'";
				
				System.out.println("****** URN Number Existance Info ******");
				System.out.println(sql);
				
				rs=stmt.executeQuery(sql);

				while(rs.next())
				{
					check=1;
				}
				
				System.out.println("URN Number Existance Status : " + check);

			}
			catch(Exception e)
			{
				System.out.println("Opps,Exception in userdao-checkUrnExistance(String urnNumber):");
				e.printStackTrace();
			}
			finally
			{
				con.close();
			}

			return check;
		}
	    
	    /* Updating The Benificiary Confirmation Status */
	    
	    
	    public static boolean updateBenificiaryConfirmationStatus(String userAccNumber,String accountNumber) throws SQLException
		{
			boolean flag = false;
			String sql = "";
			String status="Confirmed";

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
				
				sql = "update m_benificiary set b_status='"+status+"' where  b_acc_no='"+accountNumber+"'";
				
				System.out.println("****** Update Benificiary Confirmation Status Info ******");
				System.out.println(sql);

				int n=stmt.executeUpdate(sql);

				if(n==1)
				{
					flag=true;
				}
				
				System.out.println("Benificiary Confirmation Status : " + flag);

			}
			catch(Exception e)
			{
				System.out.println("Opps,Exception in adduserdao-updateBenificiaryConfirmationStatus(String accountNumber): ");
				e.printStackTrace();
			}
			finally
			{
				con.close();
			}

			return flag;
		}
	    
	    /* Getting The Transaction Limit */
	    
	    public static String getTransactionLimit(String accTypeId) throws Exception
		{
	        String transactionLimit = "";
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
	            sql = "select acc_trans_limit from m_acc_type where acc_type_code='"+accTypeId+"'";
	            System.out.println("******* Transaction Limit Info *******");
	            System.out.println(sql);
	            
				rs=stmt.executeQuery(sql);

				while(rs.next())
				{
					transactionLimit = rs.getString(1);
				}
				
				System.out.println("Transaction Limit : " + transactionLimit);

			}
			catch(Exception e)
			{
				System.out.println("Opps,Exception in adduserdao-getTransactionLimit(String accTypeId) : ");
				e.printStackTrace();
			}
			finally
			{
				con.close();
			}

			return transactionLimit;
		}
	    
	/* Updating The Account Details */
	    
	    public static boolean updateAccountBalance(String accountNumber,String closingBalance) throws SQLException
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
				
				sql = "update m_account set acc_closing_balance='"+closingBalance+"' where acc_no='"+accountNumber+"'";
				
				System.out.println("****** Update Account Balance Info ******");
				System.out.println(sql);

				int n=stmt.executeUpdate(sql);

				if(n==1)
				{
					flag=true;
				}
				
				System.out.println("Update Account Balance Status : " + flag);

			}
			catch(Exception e)
			{
				System.out.println("Opps,Exception in userdao-updateAccountBalance(String accountNumber,String closingBalance): ");
				e.printStackTrace();
			}
			finally
			{
				con.close();
			}

			return flag;
		}
	    
	 /* Adding The Transaction Details */
	    
	    public static boolean addTransactionDetails(String transactionDate,String userAccountNumber,String transactionType,String transactionAmount,String benificiaryAccNumber) throws SQLException
		{
			boolean flag = false;
			String sql = "";

			Connection con=null;
			Statement stmt = null;

			try
			{
				DAO obj=new DAO();

				con = obj.connector();
				System.out.println("Connection Established !");

				stmt=con.createStatement();
				System.out.println("Statment Established !");
				
				sql = "insert into m_transaction(t_date,acc_no,t_type,fund_trans_amount,fund_trans_acc_no) values('"+transactionDate+"','"+userAccountNumber+"','"+transactionType+"','"+transactionAmount+"','"+benificiaryAccNumber+"')";
				
				System.out.println("****** Add Transaction Details Info ******");
				System.out.println(sql);

				int n=stmt.executeUpdate(sql);

				if(n==1)
				{
					flag=true;
				}
				
				System.out.println("Add Transaction Details Status : " + flag);

			}
			catch(Exception e)
			{
				System.out.println("Opps,Exception in userdao-addTransactionDetails() :");
				e.printStackTrace();
			}
			finally
			{
				con.close();
			}

			return flag;
		}
	    
	/* Getting The Max Transaction Id */
	    
	    public static int getMaxTransactionId() throws Exception
		{
	        int maxTransactionId = 0;
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
	            sql = "select max(t_no) from m_transaction";
	            System.out.println("******* Getting Max Transation Id Info *******");
	            System.out.println(sql);
	            
				rs=stmt.executeQuery(sql);

				while(rs.next())
				{
					maxTransactionId = rs.getInt(1);
				}
				
				System.out.println("Max Transaction Id : " + maxTransactionId);

			}
			catch(Exception e)
			{
				System.out.println("Opps,Exception in userdao-getMaxTransactionId() : ");
				e.printStackTrace();
			}
			finally
			{
				con.close();
			}

			return maxTransactionId;
		}
	    
	/* Getting The Transaction Details */
	    
	    public static ResultSet getTransactionDetails(String accno)
	    {
	    	Connection con=null;
			Statement stmt = null;
			ResultSet rs=null;
			String sql = "";
			
			try
			{
				DAO serverconnector = new DAO();
				con = serverconnector.connector();
				stmt = con.createStatement();
				
				sql = "select * from m_transaction where acc_no='"+accno+"'";
				
				System.out.println(sql);
				
				rs = stmt.executeQuery(sql);
			} 
			catch (SQLException e) 
			{
				System.out.println("Opps,Exception in userdao-getTransactionDetails(String userAccNumber):");
				e.printStackTrace();
			}
			return rs;
	    }
		/*public static boolean insertUser(String uid, String imgname, String desc, String has_mac) {
			
			Connection con=null;
			Statement stmt = null;
		
			String sql = "";
			
			boolean flag = false;
			try
			{
				DAO serverconnector = new DAO();
				con = serverconnector.connector();
				stmt = con.createStatement();
				
				//sql = "select * from m_transaction where acc_no='"+accno+"'";
				sql ="insert into img_selected(img_desc,img_hash)values('"+desc+"','"+has_mac+"')";
				
				System.out.println(sql);
				
				//rs = stmt.executeQuery(sql);
				int n=stmt.executeUpdate(sql);

				if(n==1)
				{
					flag=true;
				}
				
			
			
			} 
			catch (SQLException e) 
			{
				System.out.println("Opps,Exception in userdao-getTransactionDetails(String userAccNumber):");
				e.printStackTrace();
			}
			return flag;
	    
		}
		
		
		*/
		
		public static boolean updateimages(String uid, String imgname, String desc, String has_mac)
		{
			
			boolean flag =false;
			try
			{
				DAO dao=DAO.getInstance();
				Connection connection=dao.connector();
				Statement statement = connection.createStatement();
				
				String sql="update img_selected set img_desc='"+desc+"'  , img_hash='"+has_mac+"' where user_id='"+uid+"' and img_name='"+imgname+"'";
				
				System.out.println(sql);
				
				int i = statement.executeUpdate(sql);
				
				if(i!=0)
				{
					flag=true;
				}
				
				
			}
			catch(Exception e)
			{
				System.out.println("Exception in DAO-->updateimages(): "+ e);
			}
			
			return flag;
		}
		public static boolean Checkuserimage(String uid, String imgname, String desc, String has_mac)
		{
			
			boolean flag =false;
			try
			{
				DAO dao=DAO.getInstance();
				Connection connection=dao.connector();
				Statement statement = connection.createStatement();
				
				String sql="select * from img_selected where user_id='"+uid+"' and img_name='"+imgname+"' and img_desc='"+desc+"' and img_hash='"+has_mac+"'";
				
				System.out.println(sql);
				
		ResultSet rs= statement.executeQuery(sql);
				
				while(rs.next())
				{
					flag=true;
				}
				
				
			}
			catch(Exception e)
			{
				System.out.println("Exception in DAO-->updateimages(): "+ e);
			}
			
			return flag;
		}
		public static boolean dashMatrix(String userid) {
			boolean flag =false;
			try
			{
				DAO dao=DAO.getInstance();
				Connection connection=dao.connector();
				Statement statement = connection.createStatement();
				
				String sql="update m_user set dash_matrix_code=' '  where u_name='"+userid+"'";
				
				System.out.println(sql);
				
				int i = statement.executeUpdate(sql);
				
				if(i!=0)
				{
					flag=true;
				}
				
				
			}
			catch(Exception e)
			{
				System.out.println("Exception in DAO-->updateimages(): "+ e);
			}
			
			return flag;
			
			
		}

}
