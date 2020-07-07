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



@Path("/adminchange")
public class ChangepassAdmin
{
	
	@GET
	@Path("/changepassadmin")

	@Produces(MediaType.APPLICATION_JSON)
	public String employeeUpdate(@QueryParam("current_pass") String current_pass,@QueryParam("new_pass") String new_pass,@QueryParam("confirmpa") String confirmpa) throws SQLException, Exception
	{
		ResultSet rs=null;
		String response="";
		boolean flag=false;
		if(Utitlity.isNotNull(current_pass) && Utitlity.isNotNull(new_pass)&& Utitlity.isNotNull(confirmpa) )
		{
				
			
			
			boolean flag1=DBConnection.checkoldpassadmin(current_pass);
			System.out.println("flag value is "+flag1);
			
			if(flag1==true)
			{
				
			      boolean	flag2 = DBConnection.updatenewadmin(current_pass,new_pass);
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