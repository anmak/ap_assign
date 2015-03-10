
import java.sql.*;
import Driver.*;
import Connection.*;

public class tester {
   
  
   
   public static void main(String[] args) 
{
   Connection conn = null;
   Statement stmt = null;
   try{
     
      Class.forName("com.mysql.jdbc.Driver");

     
      conn = DriverManager.getConnection("jdbc:mysql://localhost",user,anam);

     
     
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT id, first, last, age FROM Employees";
      ResultSet rs = stmt.executeQuery(sql);

     
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("id");
        
         String last = rs.getString("last");

         //Display values
         System.out.print("ID: " + id);
        
         System.out.println(", Last: " + last);
      }
   
      rs.close();
      stmt.close();
      conn.close();
   }
   }

  
}
}