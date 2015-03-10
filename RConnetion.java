//server connection

import java.rmi.*;
import java.sql.*;

public interface RConnection extends Remote
{
	IRemoteStatement createStatement() throws RemoteException,SQLException;
	void closeConnection() throws RemoteException,SQLException;
}