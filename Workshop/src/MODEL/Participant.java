package MODEL;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

public class Participant extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton getParticipantButton, insertParticipantButton, deleteParticipantButton,
	  updateParticipantButton, nextButton, previousButton, lastButton,
	  firstButton, gotoButton, freeQueryButton,getParticipantNumber1;

private JList listParticipant, listWorkshop;

private JTextField W_ID_text,W_DATE_text,W_DATE_TimeSchedule_text, P_ID_text,P_FIRSTNAME_text, P_LASTNAME_text,P_STREETNAME_text,P_HOUSE_text,P_PLACE_text, 
P_ZIPCODE_text,P_PHONE_text,P_EMAIL_text, P_CATEGORY_text,P_PRICE_text,P_REGISTRATION_text,
P_PAID_text,P_DATE_text, gotoText,freeQueryText,P_Number_text1;

private JTextArea errorText;
private Connection connection;
private Statement statement;
private ResultSet resultSet;

//constructor method for checking the loading driver
public Participant() {
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
resultSet = statement.executeQuery("SELECT * FROM participant_table");
while (resultSet.next()) {
v.addElement(resultSet.getInt("P_ID"));
}
} 
catch (SQLException e) {
displaySQLErrors(e);
}
listParticipant.setListData(v);
}

private void loadWorkshop() {
	Vector<Integer> v1 = new Vector<Integer>();
	try {
	resultSet = statement.executeQuery("SELECT * FROM participant_table");
	while (resultSet.next()) {
	v1.addElement(resultSet.getInt("W_ID"));
	}
	}
	catch (SQLException e) {
		displaySQLErrors(e);
		}
	listWorkshop.setListData(v1);
	}
	// GUI building
	@SuppressWarnings("deprecation")
	private void buildGUI() {

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		listParticipant = new JList();
		loadParticipant();
		listParticipant.setVisibleRowCount(5);
		JScrollPane participantNumberListScrollPane = new JScrollPane(listParticipant);
		
		listWorkshop = new JList();
		loadWorkshop();
		listWorkshop.setVisibleRowCount(5);
		JScrollPane workshopNumberListScrollPane = new JScrollPane(listWorkshop);

// Do Get Account Button
		getParticipantButton = new JButton("Get Participant");
		getParticipantButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement statement = connection.createStatement();
					resultSet = statement.executeQuery(
					"SELECT * FROM participant_table WHERE P_ID ="+listParticipant.getSelectedValue());
					if (resultSet.next()) {
						W_ID_text.setText(resultSet.getString("W_ID"));
						W_DATE_text.setText(resultSet.getString("W_DATE"));
						W_DATE_TimeSchedule_text.setText(resultSet.getString("W_DATE_TimeSchedule"));
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
					//(W_ID, P_ID,P_FIRSTNAME,P_LASTNAME,P_STREETNAME,P_HOUSE,P_PLACE,P_ZIPCODE,P_PHONE,P_EMAIL,P_CATEGORY,P_PRICE, P_REGISTRATION,P_PAID,P_DATE)
					int i = statement.executeUpdate("INSERT INTO participant_table VALUES('" 
					+W_ID_text.getText()+ "','"
					+W_DATE_text.getText()+ "','"
					+W_DATE_TimeSchedule_text.getText()+ "','" 
					+P_ID_text.getText()+ "','" 
					+ P_FIRSTNAME_text.getText()+ "','"+ P_LASTNAME_text.getText() +"','"+ P_STREETNAME_text.getText() +"','" 
				    + P_HOUSE_text.getText()+ "','" + P_PLACE_text.getText() +"','" + P_ZIPCODE_text.getText() +"','"
					+ P_PHONE_text.getText()+"','"+ P_EMAIL_text.getText() +"','"+ P_CATEGORY_text.getText() +"','"
					+ P_PRICE_text.getText()+ "','"+ P_REGISTRATION_text.getText() +"','"+ P_PAID_text.getText() +"','"
					+ P_DATE_text.getText()+ "')");

					errorText.append("Inserted " + i + " rows successfully");
					listParticipant.removeAll();
					loadParticipant();
					loadWorkshop();
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
	          int i = statement.executeUpdate("DELETE FROM participant_table WHERE P_ID =" + listParticipant.getSelectedValue());
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
	          int i = statement.executeUpdate("UPDATE participant_table "	  
	              + "SET W_ID='"+W_ID_text.getText()+ "'," 
	              + "W_DATE='"+W_DATE_text.getText()+ "',"
	              + "W_DATE_TimeSchedule='"+W_DATE_TimeSchedule_text.getText()+ "',"
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
	          loadWorkshop();
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
	        	  W_ID_text.setText(resultSet.getString("W_ID"));
	        	  W_DATE_text.setText(resultSet.getString("W_DATE"));
	        	  W_DATE_TimeSchedule_text.setText(resultSet.getString("W_DATE_TimeSchedule"));
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
	        	  W_ID_text.setText(resultSet.getString("W_ID"));
	        	  W_DATE_text.setText(resultSet.getString("W_DATE"));
	        	  W_DATE_TimeSchedule_text.setText(resultSet.getString("W_DATE_TimeSchedule"));
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
	          W_ID_text.setText(resultSet.getString("W_ID"));
	          W_DATE_text.setText(resultSet.getString("W_DATE"));
	          W_DATE_TimeSchedule_text.setText(resultSet.getString("W_DATE_TimeSchedule"));
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
	        	  W_ID_text.setText(resultSet.getString("W_ID"));
	        	  W_DATE_text.setText(resultSet.getString("W_DATE"));
	        	  W_DATE_TimeSchedule_text.setText(resultSet.getString("W_DATE_TimeSchedule"));
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
	        	
	        	  W_ID_text.setText(resultSet.getString("W_ID"));
	        	  W_DATE_text.setText(resultSet.getString("W_DATE"));
	        	  W_DATE_TimeSchedule_text.setText(resultSet.getString("W_DATE_TimeSchedule"));
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
	              W_ID_text.setText(resultSet.getString("W_ID"));
		          W_DATE_text.setText(resultSet.getString("W_DATE"));
		          W_DATE_TimeSchedule_text.setText(resultSet.getString("W_DATE_TimeSchedule"));
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
	            loadWorkshop();
	          }
	        } catch (SQLException insertException) {
	          displaySQLErrors(insertException);
	        }
	      }
	    });
	    
	    getParticipantNumber1 = new JButton("Each Workshop Participants");
	    getParticipantNumber1.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        try{
	          Statement statement = connection.createStatement();
	          resultSet = statement.executeQuery(
	  				"SELECT count(P_ID)as number from participant_table WHERE W_ID ="+listWorkshop.getSelectedValue());
	            if(resultSet.next()) {
	            	P_Number_text1.setText(resultSet.getString("number"));
	            }
	 
	      } catch (SQLException selectException) {
	        displaySQLErrors(selectException);
	      }
	    }
	  });
	    
	    W_ID_text = new JTextField(15);
	    W_DATE_text=new JTextField(15);
	    W_DATE_TimeSchedule_text =new JTextField(15);
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
	    P_Number_text1 =new JTextField(15);
	    gotoText = new JTextField(15);
	    errorText = new JTextArea(5, 5);
	    freeQueryText = new JTextField(15);
	    
	
	    
	    //all button
	    JPanel panel_button= new JPanel(new GridBagLayout());
	    GridBagConstraints c1= new GridBagConstraints();
	    c1.fill=GridBagConstraints.HORIZONTAL;
	    
	    /// label info
	    JLabel l_w_id= new JLabel("Workshop ID:");
	    c1.gridx=0;
	    c1.gridy=0; 
	    c1.insets=new Insets(5,5,5,5);
	    panel_button.add(l_w_id,c1);
	    c1.gridx=1;
	    c1.gridy=0; 
	    panel_button.add(W_ID_text,c1);
	    
	    JLabel l_w_date= new JLabel("Workshop Date:");
	    c1.gridx=2;
	    c1.gridy=0; 
	    panel_button.add(l_w_date,c1);
	    c1.gridx=3;
	    c1.gridy=0; 
	    panel_button.add(W_DATE_text,c1);
	    
	    JLabel l_p_id= new JLabel("Participant ID:");
	    c1.gridx=2;
	    c1.gridy=1; 
	    panel_button.add(l_p_id,c1);
	    c1.gridx=3;
	    c1.gridy=1; 
	    panel_button.add(P_ID_text,c1);
	    
	    JLabel l_W_DATE_TimeSchedule= new JLabel("Workshop Schedule:");
	    c1.gridx=0;
	    c1.gridy=1; 
	    panel_button.add(l_W_DATE_TimeSchedule,c1);
	    c1.gridx=1;
	    c1.gridy=1; 
	    panel_button.add(W_DATE_TimeSchedule_text,c1);
	    
	    
	    JLabel l_p_firstname= new JLabel("Participant First Name:");
	    c1.gridx=0;
	    c1.gridy=2;
	    panel_button.add(l_p_firstname,c1);
	    c1.gridx=1;
	    c1.gridy=2;
	    panel_button.add(P_FIRSTNAME_text,c1);
	    
	    JLabel l_p_lastname= new JLabel("Participant Last Name:");
	    c1.gridx=2;
	    c1.gridy=2;
	    panel_button.add(l_p_lastname,c1);
	    c1.gridx=3;
	    c1.gridy=2;
	    panel_button.add(P_LASTNAME_text,c1);
	    
	    JLabel l_p_streetname= new JLabel("Street Name:");
	    c1.gridx=0;
	    c1.gridy=4;
	    panel_button.add(l_p_streetname,c1);
	    c1.gridx=1;
	    c1.gridy=4;
	    panel_button.add(P_STREETNAME_text,c1);
	    
	    JLabel l_p_house= new JLabel("House Number:");
	    c1.gridx=2;
	    c1.gridy=4;
	    panel_button.add(l_p_house,c1);
	    c1.gridx=3;
	    c1.gridy=4;
	    panel_button.add(P_HOUSE_text,c1);
	    
	    JLabel l_p_place= new JLabel("City Name:");
	    c1.gridx=0;
	    c1.gridy=5;
	    panel_button.add(l_p_place,c1);
	    c1.gridx=1;
	    c1.gridy=5;
	    panel_button.add(P_PLACE_text,c1);
	    
	    JLabel l_p_zipcode= new JLabel( "Postal Code:");
	    c1.gridx=2;
	    c1.gridy=5;
	    panel_button.add(l_p_zipcode,c1);
	    c1.gridx=3;
	    c1.gridy=5;
	    panel_button.add(P_ZIPCODE_text,c1);
	    
	    JLabel l_p_phone= new JLabel( "Phone Number:");
	    c1.gridx=0;
	    c1.gridy=6;
	    panel_button.add(l_p_phone,c1);
	    c1.gridx=1;
	    c1.gridy=6;
	    panel_button.add(P_PHONE_text,c1);
	    
	    
	    JLabel l_p_email= new JLabel("E-Mail Address:");
	    c1.gridx=2;
	    c1.gridy=6;
	    panel_button.add(l_p_email,c1);
	    c1.gridx=3;
	    c1.gridy=6;
	    panel_button.add(P_EMAIL_text,c1);
	    
	    JLabel l_p_category= new JLabel("Participant Occupation:");
	    c1.gridx=0;
	    c1.gridy=7;
	    panel_button.add(l_p_category,c1);
	    c1.gridx=1;
	    c1.gridy=7;
	    panel_button.add(P_CATEGORY_text,c1);
	    
	    JLabel l_p_price= new JLabel("Price in Euro:");
	    c1.gridx=2;
	    c1.gridy=7;
	    panel_button.add(l_p_price,c1);
	    c1.gridx=3;
	    c1.gridy=7;
	    panel_button.add(P_PRICE_text,c1);
	    
	    JLabel l_p_registration= new JLabel("Registration Confirmation:");
	    c1.gridx=0;
	    c1.gridy=8;
	    panel_button.add(l_p_registration,c1);
	    c1.gridx=1;
	    c1.gridy=8;
	    panel_button.add(P_REGISTRATION_text,c1);
	    
	    JLabel l_p_paid= new JLabel("Paid Confirmation:");
	    c1.gridx=2;
	    c1.gridy=8;
	    panel_button.add(l_p_paid,c1);
	    c1.gridx=3;
	    c1.gridy=8;
	    panel_button.add(P_PAID_text,c1);
	    
	    JLabel l_p_date= new JLabel("Confirmation Date:");
	    c1.gridx=0;
	    c1.gridy=9;
	    panel_button.add(l_p_date,c1);
	    c1.gridx=1;
	    c1.gridy=9;
	    panel_button.add(P_DATE_text,c1);
	    
	    
	    // button info
	    c1.gridx=0;
	    c1.gridy=10;
	    panel_button.add(gotoButton,c1);
	    c1.gridx=1;
	    c1.gridy=10;
	    panel_button.add(gotoText,c1);
	    JLabel l_w_id1= new JLabel(" Go to Participant ID");
	    c1.gridx=2;
	    c1.gridy=10;
	    panel_button.add(l_w_id1,c1);
	    
	    c1.gridx=0;
	    c1.gridy=11;
	    panel_button.add(getParticipantButton,c1);
	    c1.gridx=1;
	    c1.gridy=11;
	    panel_button.add(insertParticipantButton,c1);
	    c1.gridx=2;
	    c1.gridy=11;
	    panel_button.add(deleteParticipantButton,c1);
	    c1.gridx=3;
	    c1.gridy=11;
	    panel_button.add(updateParticipantButton,c1);
	  
	    
	    
	    // all direction
	    c1.gridx=0;
	    c1.gridy=12;
	    panel_button.add(firstButton,c1);
	    c1.gridx=1;
	    c1.gridy=12;
	    panel_button.add(previousButton,c1);
	    c1.gridx=2;
	    c1.gridy=12;
	    panel_button.add(nextButton,c1);
	    c1.gridx=3;
	    c1.gridy=12;
	    panel_button.add(lastButton,c1);
	
	    c1.gridx=0;
	    c1.gridy=13;
	    panel_button.add(freeQueryButton,c1);
	    c1.gridx=1;
	    c1.gridy=13;
	    panel_button.add(freeQueryText,c1);
	    JLabel l_w_id5= new JLabel("Select Query Acccording to the P_ID");
	    c1.gridx=2;
	    c1.gridy=13;
	    panel_button.add(l_w_id5,c1); 
	   
	    JLabel l_w_id2= new JLabel("Workshop ID:");
	    c1.gridx=0;
	    c1.gridy=14;
	    panel_button.add(l_w_id2,c1); 
	    c1.gridx=0;
	    c1.gridy=15;
	   panel_button.add(workshopNumberListScrollPane, c1);
	   
	   JLabel l_w_id3= new JLabel("Participant ID:");
	    c1.gridx=1;
	    c1.gridy=14;
	   panel_button.add(l_w_id3,c1); 
	    c1.gridx=1;
	    c1.gridy=15;
	    panel_button.add(participantNumberListScrollPane, c1);
	    c1.gridx=2;
	    c1.gridy=15;
	    panel_button.add(errorText,c1);
	    JLabel l_w_id4= new JLabel("Query Message");
	    c1.gridx=3;
	    c1.gridy=15;
	    panel_button.add(l_w_id4,c1); 
	    
	    c1.gridx=0;
	    c1.gridy=16;
	    panel_button.add(getParticipantNumber1,c1); 
	    c1.gridx=1;
	    c1.gridy=16;
	    panel_button.add(P_Number_text1,c1);
	    JLabel l_w_id6= new JLabel("Select the Workshop ID");
	    c1.gridx=2;
	    c1.gridy=16;
	    panel_button.add(l_w_id6,c1); 
	    
	    c.add(panel_button);
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
		  Participant participant = new Participant();

		  participant.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
		  participant.setSize(900, 625);
		  participant.setResizable(false);
		  participant.init();
		  participant.buildGUI();
	  }
	}
