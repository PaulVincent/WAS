package MODEL;

import javax.swing.JOptionPane;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Create_Tables {
	static Statement stmt;
	static Connection con;

	public static void main(String args[]) {
		JOptionPane.showMessageDialog(null,
				"Create Tables with JDBC Programming");
		int choice = -1;
		do {
			choice = getChoice();
			if (choice != 0) {
				getSelected(choice);
			}
		} while (choice != 0);
		System.exit(0);
	}

	// table creation choice GUI
	public static int getChoice() {
		String choice;
		int ch;
		choice = JOptionPane.showInputDialog(null, "1.Create Workshop Table\n"
				+ "2.Create Participant Table\n" + "0.Exit\n\n"
				+ "Enter your table creation choice");
		ch = Integer.parseInt(choice);
		return ch;
	}

	// tables creation choice selection
	public static void getSelected(int choice) {
		if (choice == 1) {
			createWorkshopTable();
		}
		if (choice == 2) {
			createParticipantTable();
		}
	}

	// to get the database connection with mysql database(Exam
	// bd="workshop_software_db") server with mysql-jdbc driver as a localhost
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

		//		String user = "root"; // mysql database user name
		//		String pass = "test"; // mysql database password

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

	/*
	 * sql syntex for workshop_table creation: CREATE TABLE workshop_table( W_ID
	 * int(11) NOT NULL DEFAULT '0', W_TITLE varchar(30) DEFAULT NULL,
	 * W_LECTURER varchar(30) DEFAULT NULL, W_PARTICIPANT int(11) DEFAULT NULL,
	 * W_PLACE varchar(30) DEFAULT NULL, W_CATEGORY varchar(60) DEFAULT NULL,
	 * W_DURATION double DEFAULT NULL, W_PRICE double DEFAULT NULL,
	 * W_DESCRIPTION text DEFAULT NULL, W_LITERATURE text DEFAULT NULL, W_DATE
	 * timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	 * PRIMARY KEY (W_ID));
	 */

	// workshop table creation method
	public static void createWorkshopTable() {
		Connection con = getConnection();
		String createString;
//<<<<<<< HEAD
		createString = "create table workshop_table (" + "" +
				"W_ID int(11)PRIMARY KEY, " +
		        "W_TITLE varchar(30)," +
		        "W_LECTURER varchar(30)," +
		        "W_PARTICIPANT int(4)," +
		        "W_PLACE varchar(30)," +
		        "W_CATEGORY varchar(60)," +
		        "W_DURATION double," +
		        "W_PRICE double," +
		        "W_DESCRIPTION text," +
		        "W_LITERATURE text," + 
		        "W_DATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)";
//=======
//		createString = "create table workshop_table_1 ("
//				+ ""
//				+ "W_ID int(11)PRIMARY KEY, "
//				+ "W_TITLE varchar(30),"
//				+ "W_LECTURER varchar(30),"
//				+ "W_PARTICIPANT int(4),"
//				+ "W_PLACE varchar(30),"
//				+ "W_CATEGORY varchar(60),"
//				+ "W_DURATION double,"
//				+ "W_PRICE double,"
//				+ "W_DESCRIPTION text,"
//				+ "W_LITERATURE text,"
//				+ "W_DATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)";
//>>>>>>> 3cacf254d4a457f89799996e855c454c5127ce80
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(createString);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Workshop Table Created");
	}

	/*
	 * sql syntex for creating the participants_table: CREATE TABLE
	 * participants_table( P_ID int(11) NOT NULL AUTO_INCREMENT, P_FIRSTNAME
	 * varchar(30) DEFAULT NULL, P_LASTNAME varchar(30) DEFAULT NULL,
	 * P_STREETNAME varchar(50) DEFAULT NULL, P_HOUSE int(11) DEFAULT NULL,
	 * P_PLACE varchar(60) DEFAULT NULL, P_ZIPCODE int(11) DEFAULT NULL, P_PHONE
	 * varchar(15) DEFAULT NULL, P_EMAIL varchar(60) DEFAULT NULL, P_CATEGORY
	 * varchar(60) DEFAULT NULL, P_PRICE double DEFAULT NULL, P_REGISTRATION
	 * varchar(30) DEFAULT NULL, P_PAID varchar(10) DEFAULT NULL, P_DATE
	 * timestamp, PRIMARY KEY (P_ID));
	 */
	// participant table creation method
	public static void createParticipantTable() {
		Connection con = getConnection();
		String createString;
//<<<<<<< HEAD
		createString = "create table participants_table (" + "" +
		        "P_ID int(11)PRIMARY KEY, " +
				"P_FIRSTNAME varchar(30), " +
				"P_LASTNAME varchar(30), " +
				"P_STREETNAME varchar(50), " +
				"P_HOUSE int(11), " +
				"P_PLACE varchar(60), " +
				"P_ZIPCODE int(11), " +
				"P_PHONE varchar(15), " +
				"P_EMAIL varchar(40), " +
				"P_CATEGORY varchar(60), " +
				"P_PRICE double, " +
				"P_REGISTRATION varchar(30), " +
				"P_PAID varchar(10), " +
				"P_DATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)";
//=======
//		createString = "create table participants_table_1 ("
//				+ ""
//				+ "P_ID int(11)PRIMARY KEY, "
//				+ "P_FIRSTNAME varchar(30), "
//				+ "P_LASTNAME varchar(30), "
//				+ "P_STREETNAME varchar(50), "
//				+ "P_HOUSE int(11), "
//				+ "P_PLACE varchar(60), "
//				+ "P_ZIPCODE int(11), "
//				+ "P_PHONE varchar(15), "
//				+ "P_EMAIL varchar(40), "
//				+ "P_CATEGORY varchar(60), "
//				+ "P_PRICE double, "
//				+ "P_REGISTRATION varchar(30), "
//				+ "P_PAID varchar(10), "
//				+ "P_DATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)";
//>>>>>>> 3cacf254d4a457f89799996e855c454c5127ce80
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(createString);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException:" + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Participant Table Created");
	}

}// End of class