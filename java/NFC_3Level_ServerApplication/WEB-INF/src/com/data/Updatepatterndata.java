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



@Path("/update")
public class Updatepatterndata
{
	
	@GET
	@Path("/patterndata")

	@Produces(MediaType.APPLICATION_JSON)
	public String employeeUpdate(@QueryParam("name") String username,@QueryParam("pattern") String password) throws SQLException, Exception
	{
		ResultSet rs=null;
		String response="";
		boolean flag=false;
		if(Utitlity.isNotNull(username) && Utitlity.isNotNull(password) )
		{
				System.out.println(username+" "+password);
					
			
			
			
		flag=	DBConnection.updatepatterndata(username.trim(),password.trim());	
		
		if(flag==true)
		{
			
			
		
			
		  response = Utitlity.constructJSONlogin(flag);
		
		 System.out.println("response"+response);
		
	
			
		}
		
		else
		{
			
			
			  response = Utitlity.constructJSONlogin(flag);
				
				 System.out.println("response"+response);
				
				
			
			
		}
			
			
			
			
	
		
		
	
}	
	  
		return response; 
	
	}
	
		
}