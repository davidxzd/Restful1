package com.davidx.dao;

import javax.naming.*;
import javax.sql.*;

public class OracleA {
	
	private static DataSource oracle1=null;
	private static Context context=null;
	
	public static DataSource oracleConn() throws Exception{
		if(oracle1!=null){
			return oracle1;
		}
		try{
			if(context==null){
				context=new InitialContext();
				oracle1=(DataSource) context.lookup("davidx1");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return oracle1;
	}

}
