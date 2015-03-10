/**
* Driver - This class implements the java.sql.Driver interface and acts as a
* Client driver
* 
*/



import java.io.*;
import java.util.*;
import java.sql.*;
import java.rmi.*;


public class Driver implements java.sql.Driver
{
	
	static RDriver remoteDriver = null;
        private static final String URL_PREFIX = "jdbc:JWDriver:";

	public static String getURLPrefix()
	{
		return URL_PREFIX;
	}
	
	
	
	

	static
	{
		try
		{
			
			Driver driverInst = new Driver();
			DriverManager.registerDriver(driverInst);
			
			
		}
		catch(Exception e)
		{}
	}
	
	
	
	
	
	public Connect connect(String url,Properties loginProp)
			throws SQLException
	{	
		Connect localConInstance = null;
		
		if(acceptsURL(url))
		{			
			try
			{	
				
				String serverName = url.substring(URL_PREFIX.length(),url.length());
								
				
				connectRemote(serverName);
				
				
				RConnection remoteConInstance = (RConnection)remoteDriver.getConnection();
				
				
				localConInstance = new Connect(remoteConInstance);
				
			}
			catch(RemoteException ex)
			{	
				throw(new SQLException(ex.getMessage()));
			}
			catch(Exception ex)
			{
				throw(new SQLException(ex.getMessage()));
			}
		}
					
		return (Connect)localConInstance;
	}
	
	
}