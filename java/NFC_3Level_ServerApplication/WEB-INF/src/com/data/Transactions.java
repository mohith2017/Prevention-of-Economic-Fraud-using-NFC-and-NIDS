package com.data;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



@Path("/trans")
public class Transactions
{
	
	@GET
	@Path("/details")

	@Produces(MediaType.APPLICATION_JSON)
	public String employeeUpdate(@QueryParam("details") String details) throws SQLException, Exception
	{
		ResultSet rs=null;
		String response="";
		boolean flag=false;
		if(Utitlity.isNotNull(details)  )
		{
				System.out.println(details);
					
		String data[]=		details.split("~");
				
	String accn=	data[0];
	String bankname=	data[1];
	String bankbrabch=	data[2];
	String accountname=	data[3];
	String acctype=	data[4];
	String phonenu=	data[5];
	String emailid=	data[6];
	String machinecode=	data[7];	
		
		
		String accnumber=	DBConnection.checkaccnum(accn,accountname,phonenu,emailid);	
		
		if(accnumber==null)
		{
			
			
			   response = Utitlity.constructJSONloginsTRING("1");
				
				 System.out.println("response"+response);
		
			
		}
		
		
		
		
		else
		{
			
			String userid=	DBConnection.takeaccuser(accnumber);	
			
			if(userid==null)
			{
				 
				response = Utitlity.constructJSONloginsTRING("2");
					
					 System.out.println("response"+response);	
					
				
				
				
			}
			
			else
			{
				
				
				
				
				
				
				
		boolean flagdaata=		DBConnection.checkdata(machinecode,accn,accountname,phonenu,emailid);
				
			if(flagdaata==true)	
			{
				
				response = Utitlity.constructJSONloginsTRING("3");
				
				 System.out.println("response"+response);	
				
				
			}
			else
			{
				
				
				
			
			DBConnection.inserttransdetails(userid,accn,bankname,bankbrabch,accountname,acctype,phonenu,emailid,machinecode);
			response = Utitlity.constructJSONloginsTRING("3");
			
			 System.out.println("response"+response);	
			
			
			}
			
			
		}
			
			
			
		
		
		
	
}	
	  
	
	
	}
	
		return response; 		
}
	



}