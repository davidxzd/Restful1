package com.davidx.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.*;
import com.davidx.dao.*;

@Path("/v1/status")
public class V1_status {
	private static final String version="00.01.00";
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		
		return "<p>Java Web Service</p>";
	}
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion(){
		
		return "<p><h1>Java Restful version</h1></p> "+version;
	}
	
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception{
		
		PreparedStatement query=null;
		String myString=null;
		String returnString=null;
		Connection conn=null;
		String queryString="select to_char(sysdate,'YYYY-MM-DD HH24:MI:SS') DATETIME "+"from sys.dual";
		
		try{
			
			conn=OracleA.oracleConn().getConnection();
			query=conn.prepareStatement(queryString);
			ResultSet rs=query.executeQuery();
			
			while(rs.next()){
				
				myString=rs.getString("DATETIME");
			}
			query.close();
			returnString="<p>Database Status</p> "+"<p>Database date/Time return: "
					+myString+"</p>";
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(conn!=null) conn.close();
		}
		
		return returnString;
	}
	
	
	
	
	

}
