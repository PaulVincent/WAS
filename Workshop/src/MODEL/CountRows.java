package MODEL;

import java.sql.*;
public class CountRows {

public void getParticipant(){	
 
      Connection connection = null;
      String url = "jdbc:mysql://localhost:3306/";
      String dbName = "workshop_software_db";
      String driverName = "com.mysql.jdbc.Driver";
      String userName = "root";
      String password = "riaydh";
      
      try{
        Class.forName(driverName).newInstance();
        connection = DriverManager.getConnection(url+dbName, userName, password);
        try{
          Statement stmt = connection.createStatement();
          String selectquery = "select count(*) from participants_table";
          ResultSet rs = stmt.executeQuery(selectquery);
          rs.next();          
          System.out.println("Number of rows :" + rs.getInt(1));
        }
        catch(SQLException s){
          System.out.println(s);
        }
        connection.close();
      }
      catch (Exception e){
        e.printStackTrace();
      }
  }

public static void main(String[] args) {
	CountRows countRows=new CountRows();
	countRows.getParticipant();
}
}