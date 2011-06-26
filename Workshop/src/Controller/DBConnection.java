package CONTROLLER;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DBConnection {
	public static Connection connection;
	public static Statement statement;
	
	public static void connectToDB() {
	    try {
	      connection = getConnection();
	      statement = connection.createStatement();

	    } catch (SQLException connectException) {
	      System.out.println(connectException.getMessage());
	      System.out.println(connectException.getSQLState());
	      System.out.println(connectException.getErrorCode());
	      System.exit(1);
	    }
	  }
	public static Connection getConnection() {
		Connection con = null;

		Properties properties = new Properties();
		BufferedInputStream stream;
		try {
			stream = new BufferedInputStream(new FileInputStream(
					"lib/MySQL.properties"));
			properties.load(stream);
			stream.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String url = properties.getProperty("server");// localhost and default
														// port 3306 for mysql
		String db = properties.getProperty("dbName"); // your database name
		String user = properties.getProperty("user"); // mysql database user
														// name
		String pass = properties.getProperty("password");// mysql database
															// password
		String driver = "com.mysql.jdbc.Driver"; // mysql jdbc driver
//<<<<<<< HEAD
//		String user = "root"; // mysql database user name
//		String pass = "test"; // mysql database password
//=======
//
//>>>>>>> 3cacf254d4a457f89799996e855c454c5127ce80
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url + db, user, pass);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
