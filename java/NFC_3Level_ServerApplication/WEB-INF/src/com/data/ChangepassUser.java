package com.data;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



@Path("/user")
public class ChangepassUser
{
	
	@GET
	@Path("/changepass")

	@Produces(MediaType.APPLICATION_JSON)
	public String employeeUpdate(@QueryParam("name") String username,@QueryParam("curpass") String curpass,@QueryParam("newpass") String newpass,@QueryParam("confirm") String confirm) throws SQLException, Exception
	{
		ResultSet rs=null;
		String response="";
		boolean flag=false;
		if(Utitlity.isNotNull(username) && Utitlity.isNotNull(curpass)&& Utitlity.isNotNull(newpass)&& Utitlity.isNotNull(confirm) )
		{
				
			
			
			boolean flag1=DBConnection.checkoldpassuser(username,curpass);
			System.out.println("flag value is "+flag1);
			
			if(flag1==true)
			{
				
			      boolean	flag2 = DBConnection.updatenewpass(username,newpass);
				if (flag2==true) 
				{

					
					  response = Utitlity.setchangepassresp("2");
					
					 System.out.println("response"+response);
					
				
				

				} 
				else
				
				{

					
					  response = Utitlity.setchangepassresp("3");
						
					
					 System.out.println("response"+response);
					
				
					
				}
			}
				
				
							
		
			else
			{
				
				  response = Utitlity.setchangepassresp("1");
				
				 System.out.println("response"+response);
				
			
				
				
			}
			
			
		
	
}	
	  
		return response; 
	
	}
	
		
}