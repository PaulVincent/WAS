package MODEL;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

import javax.swing.JButton;




public class RowCount {
	  private Connection connection;
	  private ResultSet resultSet;
	  private JButton getParticipantNumber;
	  
	public RowCount() {
		 
	    try {
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	    } 
	    catch (Exception e) {
	      System.err.println("Unable to find and load driver");
	      System.exit(1);
	    }
	  }
	  // mysql database connection method as database name cftmp7
	  public void connectToDB() {
		    try {
		      connection = DriverManager
		          .getConnection("jdbc:mysql://localhost/workshop_software_db?user=root&password=riaydh");
		  
		    } catch (SQLException connectException) {
		      System.out.println(connectException.getMessage());
		      System.out.println(connectException.getSQLState());
		      System.out.println(connectException.getErrorCode());
		      System.exit(1);
		    }
		  
	  }
	  public void getPartivipantNumber(){
		  
	  
	  getParticipantNumber = new JButton("Number of Participant");
	  getParticipantNumber.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  try {
			        Statement statement = connection.createStatement();
					resultSet = statement.executeQuery("SELECT count(*) FROM participants_table");
	          resultSet.next();
	          System.out.println("Number of rows :" + resultSet.getInt(1));
	         
	    	  }
	          catch(SQLException s){
	            System.out.println(s);
	          }
	          try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        }
	    });
	  } 
	  public static void main(String[] args) {
		  RowCount rowCount=new RowCount();
		  rowCount.connectToDB();
	}
}



