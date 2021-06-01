package com.utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbCon {
	
	static Connection con = null;
	
	private static final String URL = "jdbc:mysql://localhost:8889/movies?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "px";
	
	public static Connection getConnection()
	{
		if(con==null)
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(URL,USER,PASSWORD);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static void closeConnection()
	{
		try
		{
			if(con != null && !con.isClosed())
			{
				con.close();
			}
			con = null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
