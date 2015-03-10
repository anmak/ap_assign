//server driver


import java.rmi.*;
import java.sql.*;

public interface RDriver extends Remote
{
	RConnection getConnection() throws RemoteException,SQLException;    
}