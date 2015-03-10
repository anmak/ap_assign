//Connect - This class implements the java.sql.Connection interface a




import java.sql.*;
import java.util.*;
import java.rmi.*;
import com.jw.server.*;

public class Connect implements Connection
{
	//Remote connection
	private IRemoteConnection  remoteConnection;
	
	
	public Connect(IRemoteConnection remCon)
	{
		remoteConnection = remCon;
	}


	
	public Statement createStatement()

	     throws SQLException
	{
		try
		{
			IRemoteStatement remStmt = (IRemoteStatement)remoteConnection.createStatement();
			JWStatement localStmtInstance = new JWStatement(remStmt);
			return (Statement)localStmtInstance;
		
		}		
		catch(RemoteException ex)
		{
			throw(new SQLException("RemoteException:" + ex.getMessage()));
		}
		catch(Exception ex)
		{
			throw(new SQLException("RemoteException:" + ex.getMessage()));
		}
	}

	
	public void close() throws SQLException
	{
		try
		{
		 	remoteConnection.closeConnection();
		}
		catch(RemoteException ex)
		{
			throw ((new SQLException("RemoteException:" + ex.getMessage())));
		}
	}

	
}







