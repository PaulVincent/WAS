package MODEL;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Participant_2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton getParticipantButton, insertParticipantButton, deleteParticipantButton,
	  updateParticipantButton, nextButton, previousButton, lastButton,
	  firstButton, gotoButton, freeQueryButton;

private JList listParticipant;

private JTextField P_ID_text,P_FIRSTNAME_text, P_LASTNAME_text,P_STREETNAME_text,P_HOUSE_text,P_PLACE_text, 
P_ZIPCODE_text,P_PHONE_text,P_EMAIL_text, P_CATEGORY_text,P_PRICE_text,P_REGISTRATION_text,
P_PAID_text,P_DATE_text, gotoText,freeQueryText;

private JTextArea errorText;
private Connection connection;
private Statement statement;
private ResultSet resultSet;

//constructor method for checking the loading driver
public Participant_2() {
super("Participant Info");
try {
Class.forName("com.mysql.jdbc.Driver").newInstance();
} 
catch (Exception e) {
System.err.println("Unable to find and load driver");
System.exit(1);
}
}
// mysql database connection method as database name workshop_software_db
public void connectToDB() {
try {
connection = DriverManager
.getConnection("jdbc:mysql://localhost/workshop_software_db?user=root&password=riaydh");
statement = connection.createStatement();

} catch (SQLException connectException) {
System.out.println(connectException.getMessage());
System.out.println(connectException.getSQLState());
System.out.println(connectException.getErrorCode());
System.exit(1);
}
}

// laod data from participants_table table from workshop_software_db database
private void loadParticipant() {
Vector<Integer> v = new Vector<Integer>();
try {
resultSet = statement.executeQuery("SELECT * FROM participants_table");
while (resultSet.next()) {
v.addElement(resultSet.getInt("P_ID"));
}
} 
catch (SQLException e) {
displaySQLErrors(e);
}
listParticipant.setListData(v);
}

	// GUI building
	@SuppressWarnings("deprecation")
	private void buildGUI() {

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		listParticipant = new JList();
		loadParticipant();
		listParticipant.setVisibleRowCount(5);
		JScrollPane participantNumberListScrollPane = new JScrollPane(
				listParticipant);

// Do Get Account Button
		getParticipantButton = new JButton("Get Participant");
		getParticipantButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement statement = connection.createStatement();
					resultSet = statement.executeQuery(
					"SELECT * FROM participants_table WHERE P_ID ="+listParticipant.getSelectedValue());
					if (resultSet.next()) {
						P_ID_text.setText(resultSet.getString("P_ID"));
						P_FIRSTNAME_text.setText(resultSet.getString("P_FIRSTNAME"));
						P_LASTNAME_text.setText(resultSet.getString("P_LASTNAME"));
						P_STREETNAME_text.setText(resultSet.getString("P_STREETNAME"));
						P_HOUSE_text.setText(resultSet.getString("P_HOUSE"));
						P_PLACE_text.setText(resultSet.getString("P_PLACE"));
						P_ZIPCODE_text.setText(resultSet.getString("P_ZIPCODE"));
						P_PHONE_text.setText(resultSet.getString("P_PHONE"));
						P_EMAIL_text.setText(resultSet.getString("P_EMAIL"));
						P_CATEGORY_text.setText(resultSet.getString("P_CATEGORY"));
						P_PRICE_text.setText(resultSet.getString("P_PRICE"));
						P_REGISTRATION_text.setText(resultSet.getString("P_REGISTRATION"));
						P_PAID_text.setText(resultSet.getString("P_PAID"));
						P_DATE_text.setText(resultSet.getString("P_DATE"));
					}
				} catch (SQLException selectException) {
					displaySQLErrors(selectException);
				}
			}
		});

// Do Insert Participant Button
		insertParticipantButton = new JButton("Insert Participant");
		insertParticipantButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement statement = connection.createStatement();
					//(P_ID,P_FIRSTNAME,P_LASTNAME,P_STREETNAME,P_HOUSE,P_PLACE,P_ZIPCODE,P_PHONE,P_EMAIL,P_CATEGORY,P_PRICE, P_REGISTRATION,P_PAID,P_DATE)
					int i = statement.executeUpdate("INSERT INTO participants_table VALUES('" 
					+P_ID_text.getText()+ "','"  
					+ P_FIRSTNAME_text.getText()+ "','"+ P_LASTNAME_text.getText() +"','"+ P_STREETNAME_text.getText() +"','" 
				    + P_HOUSE_text.getText()+ "','" + P_PLACE_text.getText() +"','" + P_ZIPCODE_text.getText() +"','"
					+ P_PHONE_text.getText()+"','"+ P_EMAIL_text.getText() +"','"+ P_CATEGORY_text.getText() +"','"
					+ P_PRICE_text.getText()+ "','"+ P_REGISTRATION_text.getText() +"','"+ P_PAID_text.getText() +"','"
					+ P_DATE_text.getText()+ "')");

					errorText.append("Inserted " + i + " rows successfully");
					listParticipant.removeAll();
					loadParticipant();
				} catch (SQLException insertException) {
					displaySQLErrors(insertException);
				}
			}
		});
		
	//Do Delete Participant Button
	    deleteParticipantButton = new JButton("Delete Participant");
	    deleteParticipantButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        try {
	          Statement statement = connection.createStatement();
	          int i = statement.executeUpdate("DELETE FROM participants_table WHERE P_ID =" + listParticipant.getSelectedValue());
	          errorText.append("Deleted " + i + " rows successfully");
	          listParticipant.removeAll();
	          loadParticipant();
	        } catch (SQLException insertException) {
	          displaySQLErrors(insertException);
	        }
	      }
	    });

	    //Do Update Participant Button
	    updateParticipantButton = new JButton("Update Participant");
	    updateParticipantButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        try {
	          Statement statement = connection.createStatement();
	          int i = statement.executeUpdate("UPDATE participants_table "	  
	              + "SET P_FIRSTNAME='"+P_FIRSTNAME_text.getText()+"',"
	              + "P_LASTNAME='"+P_LASTNAME_text.getText()+"',"
	              + "P_STREETNAME='"+P_STREETNAME_text.getText()+ "',"
	              + "P_HOUSE='"+P_HOUSE_text.getText()+ "',"
	              + "P_PLACE='"+P_PLACE_text.getText()+ "',"
	              + "P_ZIPCODE='"+P_ZIPCODE_text.getText()+ "',"
	              + "P_PHONE='"+P_PHONE_text.getText()+ "',"
	              + "P_EMAIL='"+P_EMAIL_text.getText()+"',"
	              + "P_CATEGORY='"+P_CATEGORY_text.getText()+"',"
	              + "P_PRICE='"+P_PRICE_text.getText()+"',"
	              + "P_REGISTRATION='"+P_REGISTRATION_text.getText()+"',"
	              + "P_PAID='"+P_PAID_text.getText()+"',"
	              + "P_DATE =now()"
	              + "WHERE P_ID= "+listParticipant.getSelectedValue());
	        
	          errorText.append("Updated " + i + " rows successfully");
	          listParticipant.removeAll();
	          loadParticipant();
	        } catch (SQLException insertException) {
	          displaySQLErrors(insertException);
	        }
	      }
	    });

	  //Do Next Button
	    nextButton = new JButton(">");
	    nextButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        try {
	          if (!resultSet.isLast()) {
	        	  resultSet.next();
	        	
	        	  P_ID_text.setText(resultSet.getString("P_ID"));
	        	  P_FIRSTNAME_text.setText(resultSet.getString("P_FIRSTNAME"));
	        	  P_LASTNAME_text.setText(resultSet.getString("P_LASTNAME"));
	        	  P_STREETNAME_text.setText(resultSet.getString("P_STREETNAME"));
	        	  P_HOUSE_text.setText(resultSet.getString("P_HOUSE"));
	        	  P_PLACE_text.setText(resultSet.getString("P_PLACE"));
	        	  P_ZIPCODE_text.setText(resultSet.getString("P_ZIPCODE"));
	        	  P_PHONE_text.setText(resultSet.getString("P_PHONE"));
	        	  P_EMAIL_text.setText(resultSet.getString("P_EMAIL"));
	        	  P_CATEGORY_text.setText(resultSet.getString("P_CATEGORY"));
	        	  P_PRICE_text.setText(resultSet.getString("P_PRICE"));
	        	  P_REGISTRATION_text.setText(resultSet.getString("P_REGISTRATION"));
	        	  P_PAID_text.setText(resultSet.getString("P_PAID"));
	        	  P_DATE_text.setText(resultSet.getString("P_DATE")); 
	          }
	        } catch (SQLException insertException) {
	          displaySQLErrors(insertException);
	        }
	      }
	    });

	    //Do Next Button
	    previousButton = new JButton("<");
	    previousButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        try {
	          if (!resultSet.isFirst()) {
	        	  resultSet.previous();
	        	  P_ID_text.setText(resultSet.getString("P_ID"));
	        	  P_FIRSTNAME_text.setText(resultSet.getString("P_FIRSTNAME"));
	        	  P_LASTNAME_text.setText(resultSet.getString("P_LASTNAME"));
	        	  P_STREETNAME_text.setText(resultSet.getString("P_STREETNAME"));
	        	  P_HOUSE_text.setText(resultSet.getString("P_HOUSE"));
	        	  P_PLACE_text.setText(resultSet.getString("P_PLACE"));
	        	  P_ZIPCODE_text.setText(resultSet.getString("P_ZIPCODE"));
	        	  P_PHONE_text.setText(resultSet.getString("P_PHONE"));
	        	  P_EMAIL_text.setText(resultSet.getString("P_EMAIL"));
	        	  P_CATEGORY_text.setText(resultSet.getString("P_CATEGORY"));
	        	  P_PRICE_text.setText(resultSet.getString("P_PRICE"));
	        	  P_REGISTRATION_text.setText(resultSet.getString("P_REGISTRATION"));
	        	  P_PAID_text.setText(resultSet.getString("P_PAID"));
	        	  P_DATE_text.setText(resultSet.getString("P_DATE")); 
	          }
	        } catch (SQLException insertException) {
	          displaySQLErrors(insertException);
	        }
	      }
	    });

	    //Do last Button
	    lastButton = new JButton(">|");
	    lastButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        try {
	        	resultSet.last();
	        	
	          P_ID_text.setText(resultSet.getString("P_ID"));
	       	  P_FIRSTNAME_text.setText(resultSet.getString("P_FIRSTNAME"));
	       	  P_LASTNAME_text.setText(resultSet.getString("P_LASTNAME"));
	       	  P_STREETNAME_text.setText(resultSet.getString("P_STREETNAME"));
	       	  P_HOUSE_text.setText(resultSet.getString("P_HOUSE"));
	       	  P_PLACE_text.setText(resultSet.getString("P_PLACE"));
	       	  P_ZIPCODE_text.setText(resultSet.getString("P_ZIPCODE"));
	       	  P_PHONE_text.setText(resultSet.getString("P_PHONE"));
	       	  P_EMAIL_text.setText(resultSet.getString("P_EMAIL"));
	       	  P_CATEGORY_text.setText(resultSet.getString("P_CATEGORY"));
	       	  P_PRICE_text.setText(resultSet.getString("P_PRICE"));
	       	  P_REGISTRATION_text.setText(resultSet.getString("P_REGISTRATION"));
	       	  P_PAID_text.setText(resultSet.getString("P_PAID"));
	       	  P_DATE_text.setText(resultSet.getString("P_DATE")); 
	          
	          
	        } catch (SQLException insertException) {
	          displaySQLErrors(insertException);
	        }
	      }
	    });

	    //Do first Button
	    firstButton = new JButton("|<");
	    firstButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        try {
	        	resultSet.first();
	        	  P_ID_text.setText(resultSet.getString("P_ID"));
	         	  P_FIRSTNAME_text.setText(resultSet.getString("P_FIRSTNAME"));
	         	  P_LASTNAME_text.setText(resultSet.getString("P_LASTNAME"));
	         	  P_STREETNAME_text.setText(resultSet.getString("P_STREETNAME"));
	         	  P_HOUSE_text.setText(resultSet.getString("P_HOUSE"));
	         	  P_PLACE_text.setText(resultSet.getString("P_PLACE"));
	         	  P_ZIPCODE_text.setText(resultSet.getString("P_ZIPCODE"));
	         	  P_PHONE_text.setText(resultSet.getString("P_PHONE"));
	         	  P_EMAIL_text.setText(resultSet.getString("P_EMAIL"));
	         	  P_CATEGORY_text.setText(resultSet.getString("P_CATEGORY"));
	         	  P_PRICE_text.setText(resultSet.getString("P_PRICE"));
	         	  P_REGISTRATION_text.setText(resultSet.getString("P_REGISTRATION"));
	         	  P_PAID_text.setText(resultSet.getString("P_PAID"));
	         	  P_DATE_text.setText(resultSet.getString("P_DATE")); 
	          
	          
	        } catch (SQLException insertException) {
	          displaySQLErrors(insertException);
	        }
	      }
	    });

	    //Do gotoButton
	    gotoButton = new JButton("Goto");
	    gotoButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        try {
	        	resultSet.absolute(Integer.parseInt(gotoText.getText()));
	          
	        	  P_ID_text.setText(resultSet.getString("P_ID"));
	        	  P_FIRSTNAME_text.setText(resultSet.getString("P_FIRSTNAME"));
	        	  P_LASTNAME_text.setText(resultSet.getString("P_LASTNAME"));
	        	  P_STREETNAME_text.setText(resultSet.getString("P_STREETNAME"));
	        	  P_HOUSE_text.setText(resultSet.getString("P_HOUSE"));
	        	  P_PLACE_text.setText(resultSet.getString("P_PLACE"));
	        	  P_ZIPCODE_text.setText(resultSet.getString("P_ZIPCODE"));
	        	  P_PHONE_text.setText(resultSet.getString("P_PHONE"));
	        	  P_EMAIL_text.setText(resultSet.getString("P_EMAIL"));
	        	  P_CATEGORY_text.setText(resultSet.getString("P_CATEGORY"));
	        	  P_PRICE_text.setText(resultSet.getString("P_PRICE"));
	        	  P_REGISTRATION_text.setText(resultSet.getString("P_REGISTRATION"));
	        	  P_PAID_text.setText(resultSet.getString("P_PAID"));
	        	  P_DATE_text.setText(resultSet.getString("P_DATE")); 
	        	  
	        } catch (SQLException insertException) {
	          displaySQLErrors(insertException);
	        }
	      }
	    });

	    //Do freeQueryButton
	    freeQueryButton = new JButton("Execute Query");
	    freeQueryButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        try {
	          if (freeQueryText.getText().toUpperCase().indexOf("SELECT") >= 0) {
	        	  resultSet = statement.executeQuery(freeQueryText.getText());
	            if (resultSet.next()) {
	            	
	              P_ID_text.setText(resultSet.getString("P_ID"));
	          	  P_FIRSTNAME_text.setText(resultSet.getString("P_FIRSTNAME"));
	          	  P_LASTNAME_text.setText(resultSet.getString("P_LASTNAME"));
	          	  P_STREETNAME_text.setText(resultSet.getString("P_STREETNAME"));
	          	  P_HOUSE_text.setText(resultSet.getString("P_HOUSE"));
	          	  P_PLACE_text.setText(resultSet.getString("P_PLACE"));
	          	  P_ZIPCODE_text.setText(resultSet.getString("P_ZIPCODE"));
	          	  P_PHONE_text.setText(resultSet.getString("P_PHONE"));
	          	  P_EMAIL_text.setText(resultSet.getString("P_EMAIL"));
	          	  P_CATEGORY_text.setText(resultSet.getString("P_CATEGORY"));
	          	  P_PRICE_text.setText(resultSet.getString("P_PRICE"));
	          	  P_REGISTRATION_text.setText(resultSet.getString("P_REGISTRATION"));
	          	  P_PAID_text.setText(resultSet.getString("P_PAID"));
	          	  P_DATE_text.setText(resultSet.getString("P_DATE"));
	              
	            }
	          } else {
	            int i = statement.executeUpdate(freeQueryText.getText());
	            errorText.append("Rows affected = " + i);
	            loadParticipant();
	          }
	        } catch (SQLException insertException) {
	          displaySQLErrors(insertException);
	        }
	      }
	    });
	    
	    gotoText = new JTextField(3);
	    freeQueryText = new JTextField(40);
	    P_ID_text = new JTextField(15);
	    P_FIRSTNAME_text = new JTextField(15);
	    P_LASTNAME_text = new JTextField(15);
	    P_STREETNAME_text= new JTextField(15);
	    P_HOUSE_text = new JTextField(15);
	    P_PLACE_text = new JTextField(15);
	    P_ZIPCODE_text = new JTextField(15);
	    P_PHONE_text = new JTextField(15);
	    P_EMAIL_text= new JTextField(15);
	    P_CATEGORY_text = new JTextField(15);
	    P_PRICE_text = new JTextField(15);
	    P_REGISTRATION_text = new JTextField(15);
	    P_PAID_text = new JTextField(15);
	    P_DATE_text= new JTextField(15);
	    errorText = new JTextArea(5, 15);
	   
	    
	    JPanel allButton= new JPanel(new GridLayout(5,1)); 
	    allButton.add(participantNumberListScrollPane);
	    allButton.add(getParticipantButton);
	    allButton.add(insertParticipantButton);
	    allButton.add(deleteParticipantButton);
	    allButton.add(updateParticipantButton);
	    
	    
	    JPanel second = new JPanel(new GridLayout(15,1));
	    second.setLayout(new GridLayout(15,1));
	    JLabel textLabel =new JLabel();
	    textLabel.add(second);
	    second.add(P_ID_text);
	    second.add(P_FIRSTNAME_text);
	    second.add(P_LASTNAME_text);
	    second.add(P_STREETNAME_text);
	    second.add(P_HOUSE_text);
	    second.add(P_PLACE_text);
	    second.add(P_ZIPCODE_text);
	    second.add(P_PHONE_text);
	    second.add(P_EMAIL_text);
	    second.add(P_CATEGORY_text);
	    second.add(P_PRICE_text);
	    second.add(P_REGISTRATION_text);
	    second.add(P_PAID_text);
	    second.add( P_DATE_text);
	    
	    JPanel third = new JPanel();
	    third.add(new JScrollPane(errorText));
	    errorText.setEditable(false);
	    
	    
	    JPanel fourth = new JPanel();
	    fourth.add(firstButton);
	    fourth.add(previousButton);
	    fourth.add(nextButton);
	    fourth.add(lastButton);
	    fourth.add(gotoText);
	    fourth.add(gotoButton);

	    JPanel fifth = new JPanel();
	    fifth.add(freeQueryText);

	    c.add(allButton);
	    c.add(second);
	    c.add(third);
	    c.add(fourth);
	    c.add(fifth);
	    c.add(freeQueryButton);
	    show();
	  }
	  private void displaySQLErrors(SQLException e) {
	    errorText.append("SQLException: " + e.getMessage() + "\n");
	    errorText.append("SQLState:     " + e.getSQLState() + "\n");
	    errorText.append("VendorError:  " + e.getErrorCode() + "\n");
	  }

	  private void init() {
	    connectToDB();
	  }

	  public static void main(String[] args) {
		  Participant_2 participant = new Participant_2();

		  participant.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
		  participant.setSize(600, 600);
		  participant.setResizable(true);
		  participant.init();
		  participant.buildGUI();
	  }
	}
