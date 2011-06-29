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

public class Workshop_Time_Schedule_Info extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton getTimeScheduleButton, insertTimeScheduleButton, deleteTimeScheduleButton,
	  updateTimeScheduleButton, nextButton, previousButton, lastButton,
	  firstButton, gotoButton, freeQueryButton;

private JList listWorkshop;

private JTextField W_ID_text, W_DATE_text, W_SCHEDULE_text, gotoText,freeQueryText;


private JTextArea errorText;
private Connection connection;
private Statement statement;
private ResultSet resultSet;

//constructor method for checking the loading driver
public Workshop_Time_Schedule_Info() {
super("Workshop Time Schedule Detail Info");
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

private void loadWorkshop() {
	Vector<Integer> v1 = new Vector<Integer>();
	try {
	resultSet = statement.executeQuery("SELECT * FROM Time_Schedule_table");
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
	
		listWorkshop = new JList();
		loadWorkshop();
		listWorkshop.setVisibleRowCount(5);
		JScrollPane workshopNumberListScrollPane = new JScrollPane(listWorkshop);

// Do Get workshop schedule Button
		getTimeScheduleButton = new JButton("Get Workshop Detail");
		getTimeScheduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement statement = connection.createStatement();
					resultSet = statement.executeQuery(
					"SELECT * FROM Time_Schedule_table WHERE W_ID ="+listWorkshop.getSelectedValue());
					if (resultSet.next()) {
						W_ID_text.setText(resultSet.getString("W_ID"));
						W_DATE_text.setText(resultSet.getString("W_DATE"));
						W_SCHEDULE_text.setText(resultSet.getString("W_SCHEDULE"));	
					}
				} catch (SQLException selectException) {
					displaySQLErrors(selectException);
				}
			}
		});

// Do Insert workshop schedule  Button
		insertTimeScheduleButton = new JButton("Insert Workshop Detail");
		insertTimeScheduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement statement = connection.createStatement();
					//()
					int i = statement.executeUpdate("INSERT INTO Time_Schedule_table VALUES('" 
					+W_ID_text.getText()+ "','"  
					+ W_DATE_text.getText() +"','"
					+ W_SCHEDULE_text.getText()+ "')");			
					errorText.append("Inserted " + i + " rows successfully");
					listWorkshop.removeAll();
				
				} catch (SQLException insertException) {
					displaySQLErrors(insertException);
				}
			}
		});
		
	//Do Delete workshop schedule Button
	    deleteTimeScheduleButton = new JButton("Delete Workshop Detail");
	    deleteTimeScheduleButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        try {
	          Statement statement = connection.createStatement();
	          int i = statement.executeUpdate("DELETE FROM Time_Schedule_table WHERE W_ID =" + listWorkshop.getSelectedValue());
	          errorText.append("Deleted " + i + " rows successfully");
	          listWorkshop.removeAll();
	     
	        } catch (SQLException insertException) {
	          displaySQLErrors(insertException);
	        }
	      }
	    });

	
	    //Do Update workshop schedule  Button
	    updateTimeScheduleButton = new JButton("Update Workshop Detail");
	    updateTimeScheduleButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        try {
	          Statement statement = connection.createStatement();
	          int i = statement.executeUpdate("UPDATE Time_Schedule_table "	  
	              + "SET W_ID='"+W_ID_text.getText()+"',"
	              + "W_DATE ='"+W_DATE_text.getText()+ "',"
	              + "W_SCHEDULE='"+W_SCHEDULE_text.getText()+"',"
	              + "WHERE W_ID= "+listWorkshop.getSelectedValue());
	        
	          errorText.append("Updated " + i + " rows successfully");
	          
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
	        	  W_SCHEDULE_text.setText(resultSet.getString("W_SCHEDULE"));
	        	  
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
	        	  W_SCHEDULE_text.setText(resultSet.getString("W_SCHEDULE"));
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
	        	  W_SCHEDULE_text.setText(resultSet.getString("W_SCHEDULE"));
	        	  
	          
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
	        	  W_SCHEDULE_text.setText(resultSet.getString("W_SCHEDULE"));
	        	  
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
	        	  W_SCHEDULE_text.setText(resultSet.getString("W_SCHEDULE"));
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
		        	  W_SCHEDULE_text.setText(resultSet.getString("W_SCHEDULE"));
	            }
	          } else {
	            int i = statement.executeUpdate(freeQueryText.getText());
	            errorText.append("Rows affected = " + i);
	            loadWorkshop();
	          }
	        } catch (SQLException insertException) {
	          displaySQLErrors(insertException);
	        }
	      }
	    });
	    
	   
	    
	    W_ID_text = new JTextField(15);
	    W_DATE_text= new JTextField(15);
	    W_SCHEDULE_text = new JTextField(50);
	    
	    gotoText = new JTextField(3);
	    errorText = new JTextArea(5, 5);
	    freeQueryText = new JTextField(20);
	    
	
	    
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
	    c1.gridx=0;
	    c1.gridy=2;
	    panel_button.add(l_w_date,c1);
	    c1.gridx=1;
	    c1.gridy=2;
	    panel_button.add(W_DATE_text,c1);
	    
	    JLabel l_W_DATE_TimeSchedule_text= new JLabel("Time Schedule for Workshop:");
	    c1.gridx=0;
	    c1.gridy=3;
	    panel_button.add(l_W_DATE_TimeSchedule_text,c1);
	    c1.gridx=1;
	    c1.gridy=3;
	    panel_button.add(W_SCHEDULE_text,c1);
	   	    
	    
	    // button info
	   
	    c1.gridx=1;
	    c1.gridy=4;
	    panel_button.add(gotoText,c1);
	    c1.gridx=0;
	    c1.gridy=4;
	    panel_button.add(gotoButton,c1);
	    JLabel l_w_id1= new JLabel("Go to Workshop ID");
	    c1.gridx=2;
	    c1.gridy=4;
	    panel_button.add(l_w_id1,c1);
	    
	    c1.gridx=0;
	    c1.gridy=5;
	    panel_button.add(getTimeScheduleButton,c1);
	    c1.gridx=1;
	    c1.gridy=5;
	    panel_button.add(insertTimeScheduleButton,c1);
	    c1.gridx=2;
	    c1.gridy=5;
	    panel_button.add(deleteTimeScheduleButton,c1);
	    c1.gridx=3;
	    c1.gridy=5;
	    panel_button.add(updateTimeScheduleButton,c1);
	  
	    
	    
	    // all direction
	    c1.gridx=0;
	    c1.gridy=6;
	    panel_button.add(firstButton,c1);
	    c1.gridx=1;
	    c1.gridy=6;
	    panel_button.add(previousButton,c1);
	    c1.gridx=2;
	    c1.gridy=6;
	    panel_button.add(nextButton,c1);
	    c1.gridx=3;
	    c1.gridy=6;
	    panel_button.add(lastButton,c1);
	
	    c1.gridx=1;
	    c1.gridy=7;
	    panel_button.add(freeQueryText,c1);
	    c1.gridx=0;
	    c1.gridy=7;
	    panel_button.add(freeQueryButton,c1);
	    JLabel l_w_id5= new JLabel("Select Query Acccording to the W_ID");
	    c1.gridx=2;
	    c1.gridy=7;
	    panel_button.add(l_w_id5,c1); 
    
	    JLabel l_w_id2= new JLabel("Workshop ID:");
	    c1.gridx=0;
	    c1.gridy=8;
	    panel_button.add(l_w_id2,c1); 
	    c1.gridx=0;
	    c1.gridy=9;
	   panel_button.add(workshopNumberListScrollPane, c1);
	    c1.gridx=1;
	    c1.gridy=9;
	    panel_button.add(errorText,c1);
	   
	    JLabel l_w_id4= new JLabel("Query Message");
	    c1.gridx=2;
	    c1.gridy=9;
	   panel_button.add(l_w_id4,c1); 
	   
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
		  Workshop_Time_Schedule_Info workshop_Time_Schedule_Info = new Workshop_Time_Schedule_Info();

		  workshop_Time_Schedule_Info.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
		  workshop_Time_Schedule_Info.setSize(1200, 445);
		  workshop_Time_Schedule_Info.setResizable(true);
		  workshop_Time_Schedule_Info.init();
		  workshop_Time_Schedule_Info.buildGUI();
	  }
	}

