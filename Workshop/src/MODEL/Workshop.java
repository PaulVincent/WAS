package MODEL;


import java.awt.BorderLayout;

import java.awt.Container;
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

public class Workshop extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton getWorkshopButton, insertWorkshopButton, deleteWorkshopButton,
      			  updateWorkshopButton, nextButton, previousButton, lastButton,
      			  firstButton, gotoButton, freeQueryButton,getParticipantNumber,getParticipantNumber1;
  
  private JList listWorkshop,listParticipant;

  
  private JTextField W_ID_text,W_ID_text1,W_TITLE_text, W_LECTURER_text,W_PLACE_text,
  W_CATEGORY_text,W_DURATION_text,W_PRICE_text,W_DESCRIPTION_text, W_LITERATURE_text,W_DATE_text, gotoText,freeQueryText
  ,P_Number_text,P_Number_text1;
  
  private JTextArea errorText;
  private Connection connection;
  private Statement statement;
  private ResultSet resultSet;
  
// constructor method for checking the loading driver
  public Workshop() {
	  
	 super("Workshop Administrator");   
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
	      statement = connection.createStatement();

	    } catch (SQLException connectException) {
	      System.out.println(connectException.getMessage());
	      System.out.println(connectException.getSQLState());
	      System.out.println(connectException.getErrorCode());
	      System.exit(1);
	    }
	  }
  
  // laod data from workshop_table table
  private void loadWorkshop() {
    Vector<Integer> v = new Vector<Integer>();
    try {
    	resultSet = statement.executeQuery("SELECT * FROM workshop_table");
      while (resultSet.next()) {
        v.addElement(resultSet.getInt("W_ID"));
      }
    } 
    catch (SQLException e) {
//      displaySQLErrors(e);
    }
    listWorkshop.setListData(v);
  }
  private void loadParticipant() {
		Vector<Integer> v1 = new Vector<Integer>();
		try {
		resultSet = statement.executeQuery("SELECT * FROM participant_table");
		while (resultSet.next()) {
		v1.addElement(resultSet.getInt("P_ID"));
		}
		}
		catch (SQLException e) {
			displaySQLErrors(e);
			}
		listParticipant.setListData(v1);
		}
  
  // GUI building 
  @SuppressWarnings("deprecation")
private void buildGUI() {
	  
	   Container c = getContentPane();
	   c.setLayout(new GridBagLayout());
	   JFrame f=new JFrame();
	   
    listWorkshop = new JList();
    loadWorkshop();
    listWorkshop.setVisibleRowCount(5);
    JScrollPane participantNumberListScrollPane = new JScrollPane(listWorkshop);
   
  
    //Do Get Account Button
    getWorkshopButton = new JButton("Get Workshop");
    getWorkshopButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
    	  try {
		        Statement statement = connection.createStatement();
				resultSet = statement.executeQuery(
				"SELECT * FROM workshop_table WHERE W_ID ="+listWorkshop.getSelectedValue());
          if(resultSet.next()) {
          W_ID_text.setText(resultSet.getString("W_ID"));
          W_TITLE_text.setText(resultSet.getString("W_TITLE"));
          W_LECTURER_text.setText(resultSet.getString("W_LECTURER"));
      	 // W_PARTICIPANT_text.setText(resultSet.getString("W_PARTICIPANT"));
      	  W_PLACE_text.setText(resultSet.getString("W_PLACE"));
      	  W_CATEGORY_text.setText(resultSet.getString("W_CATEGORY"));
      	  W_DURATION_text.setText(resultSet.getString("W_DURATION"));
      	  W_PRICE_text.setText(resultSet.getString("W_PRICE"));
      	  W_DESCRIPTION_text.setText(resultSet.getString("W_DESCRIPTION"));
      	  W_LITERATURE_text.setText(resultSet.getString("W_LITERATURE"));
      	  W_DATE_text.setText(resultSet.getString("W_DATE"));
          }
        } catch (SQLException selectException) {
          displaySQLErrors(selectException);
        }
   
      }
    });
    
    //Do Insert Participant Button
    insertWorkshopButton = new JButton("Insert Workshop");
    insertWorkshopButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          Statement statement = connection.createStatement();
          int i = statement.executeUpdate("INSERT INTO workshop_table VALUES('"
                  +W_ID_text.getText() + "','" 
                  +W_TITLE_text.getText() + "','"
                  +W_LECTURER_text.getText() + "','"
                //  +W_PARTICIPANT_text.getText() + "','"
                  +W_PLACE_text.getText() + "','"
                  +W_CATEGORY_text.getText() + "','" 
                  +W_DURATION_text.getText() + "','"
                  +W_PRICE_text.getText() + "','" 
                  +W_DESCRIPTION_text.getText() + "','"
                  +W_LITERATURE_text.getText() + "','" 
                  +W_DATE_text.getText()+ "')");
          errorText.append("Inserted " + i + " rows successfully");
          listWorkshop.removeAll();
          loadWorkshop();
        } catch (SQLException insertException) {
          displaySQLErrors(insertException);
        }
      }
    });

    //Do Delete Workshop Button
    deleteWorkshopButton = new JButton("Delete Workshop");
    deleteWorkshopButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          Statement statement = connection.createStatement();
          int i = statement.executeUpdate("DELETE FROM workshop_table WHERE W_ID = "+ listWorkshop.getSelectedValue());
          errorText.append("Deleted " + i + " rows successfully");
          listWorkshop.removeAll();
          loadWorkshop();
        } catch (SQLException insertException) {
          displaySQLErrors(insertException);
        }
      }
    });

    //Do Update Workshop Button
    updateWorkshopButton = new JButton("Update Workshop");
    updateWorkshopButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          Statement statement = connection.createStatement();
          int i = statement.executeUpdate("UPDATE workshop_table "
              + "SET W_TITLE='"+W_TITLE_text.getText()+"',"
              + "W_LECTURER='"+W_LECTURER_text.getText()+"',"
           //   + "W_PARTICIPANT='"+W_PARTICIPANT_text.getText()+ "',"
              + "W_PLACE='"+W_PLACE_text.getText()+"',"
              + "W_CATEGORY='"+W_CATEGORY_text.getText()+"',"
              + "W_DURATION='"+W_DURATION_text.getText()+"',"
              + "W_PRICE='"+W_PRICE_text.getText()+"',"
              + "W_DESCRIPTION='"+W_DESCRIPTION_text.getText()+"',"
              + "W_LITERATURE='"+W_LITERATURE_text.getText()+"',"
              + "W_DATE =now()"
              + "WHERE W_ID = "+listWorkshop.getSelectedValue());
          
          errorText.append("Updated " + i + " rows successfully");
          listWorkshop.removeAll();
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
        	  W_TITLE_text.setText(resultSet.getString("W_TITLE"));
        	  W_LECTURER_text.setText(resultSet.getString("W_LECTURER"));
        	//  W_PARTICIPANT_text.setText(resultSet.getString("W_PARTICIPANT"));
        	  W_PLACE_text.setText(resultSet.getString("W_PLACE"));
        	  W_CATEGORY_text.setText(resultSet.getString("W_CATEGORY"));
        	  W_DURATION_text.setText(resultSet.getString("W_DURATION"));
        	  W_PRICE_text.setText(resultSet.getString("W_PRICE"));
        	  W_DESCRIPTION_text.setText(resultSet.getString("W_DESCRIPTION_text"));
        	  W_LITERATURE_text.setText(resultSet.getString("W_LITERATURE"));
        	  W_DATE_text.setText(resultSet.getString("W_DATE")); 	  
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
        	  W_TITLE_text.setText(resultSet.getString("W_TITLE"));
        	  W_LECTURER_text.setText(resultSet.getString("W_LECTURER"));
        	 // W_PARTICIPANT_text.setText(resultSet.getString("W_PARTICIPANT"));
        	  W_PLACE_text.setText(resultSet.getString("W_PLACE"));
        	  W_CATEGORY_text.setText(resultSet.getString("W_CATEGORY"));
        	  W_DURATION_text.setText(resultSet.getString("W_DURATION"));
        	  W_PRICE_text.setText(resultSet.getString("W_PRICE"));
        	  W_DESCRIPTION_text.setText(resultSet.getString("W_DESCRIPTION_text"));
        	  W_LITERATURE_text.setText(resultSet.getString("W_LITERATURE"));
        	  W_DATE_text.setText(resultSet.getString("W_DATE")); 
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
      	  W_TITLE_text.setText(resultSet.getString("W_TITLE"));
      	  W_LECTURER_text.setText(resultSet.getString("W_LECTURER"));
      	 // W_PARTICIPANT_text.setText(resultSet.getString("W_PARTICIPANT"));
      	  W_PLACE_text.setText(resultSet.getString("W_PLACE"));
      	  W_CATEGORY_text.setText(resultSet.getString("W_CATEGORY"));
      	  W_DURATION_text.setText(resultSet.getString("W_DURATION"));
      	  W_PRICE_text.setText(resultSet.getString("W_PRICE"));
      	  W_DESCRIPTION_text.setText(resultSet.getString("W_DESCRIPTION"));
      	  W_LITERATURE_text.setText(resultSet.getString("W_LITERATURE"));
      	  W_DATE_text.setText(resultSet.getString("W_DATE")); 
          
          
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
      	  W_TITLE_text.setText(resultSet.getString("W_TITLE"));
      	  W_LECTURER_text.setText(resultSet.getString("W_LECTURER"));
      	//  W_PARTICIPANT_text.setText(resultSet.getString("W_PARTICIPANT"));
      	  W_PLACE_text.setText(resultSet.getString("W_PLACE"));
      	  W_CATEGORY_text.setText(resultSet.getString("W_CATEGORY"));
      	  W_DURATION_text.setText(resultSet.getString("W_DURATION"));
      	  W_PRICE_text.setText(resultSet.getString("W_PRICE"));
      	  W_DESCRIPTION_text.setText(resultSet.getString("W_DESCRIPTION"));
      	  W_LITERATURE_text.setText(resultSet.getString("W_LITERATURE"));
      	  W_DATE_text.setText(resultSet.getString("W_DATE")); 
          
          
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
      	  W_TITLE_text.setText(resultSet.getString("W_TITLE"));
      	  W_LECTURER_text.setText(resultSet.getString("W_LECTURER"));
      	 // W_PARTICIPANT_text.setText(resultSet.getString("W_PARTICIPANT"));
      	  W_PLACE_text.setText(resultSet.getString("W_PLACE"));
      	  W_CATEGORY_text.setText(resultSet.getString("W_CATEGORY"));
      	  W_DURATION_text.setText(resultSet.getString("W_DURATION"));
      	  W_PRICE_text.setText(resultSet.getString("W_PRICE"));
      	  W_DESCRIPTION_text.setText(resultSet.getString("W_DESCRIPTION"));
      	  W_LITERATURE_text.setText(resultSet.getString("W_LITERATURE"));
      	  W_DATE_text.setText(resultSet.getString("W_DATE")); 
        	  
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
          	  W_TITLE_text.setText(resultSet.getString("W_TITLE"));
          	  W_LECTURER_text.setText(resultSet.getString("W_LECTURER"));
          	 // W_PARTICIPANT_text.setText(resultSet.getString("W_PARTICIPANT"));
          	  W_PLACE_text.setText(resultSet.getString("W_PLACE"));
          	  W_CATEGORY_text.setText(resultSet.getString("W_CATEGORY"));
          	  W_DURATION_text.setText(resultSet.getString("W_DURATION"));
          	  W_PRICE_text.setText(resultSet.getString("W_PRICE"));
          	  W_DESCRIPTION_text.setText(resultSet.getString("W_DESCRIPTION"));
          	  W_LITERATURE_text.setText(resultSet.getString("W_LITERATURE"));
          	  W_DATE_text.setText(resultSet.getString("W_DATE")); 
              
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
	    W_TITLE_text = new JTextField(15);
	    W_LECTURER_text = new JTextField(15);
	   // W_PARTICIPANT_text= new JTextField(15);
	    W_PLACE_text= new JTextField(15);
	    W_CATEGORY_text= new JTextField(15);
	    W_DURATION_text = new JTextField(15);
	    W_PRICE_text = new JTextField(15);
	    W_DESCRIPTION_text= new JTextField(15);
	    W_LITERATURE_text = new JTextField(15);
	    W_DATE_text = new JTextField(15);
	    P_Number_text = new JTextField(15);
	     
	    W_ID_text1  = new JTextField(15);
	    errorText = new JTextArea(5, 5);
	    gotoText = new JTextField(15);
	    freeQueryText = new JTextField(15);
	  //  freeQueryText1 = new JTextField(20);
	   P_Number_text1 = new JTextField(15);
	    
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
	    
	    JLabel l_w_title= new JLabel("Workshop Title:");
	    c1.gridx=2;
	    c1.gridy=0;
	    panel_button.add(l_w_title,c1);
	    c1.gridx=3;
	    c1.gridy=0;
	    panel_button.add(W_TITLE_text,c1);
	    
	    JLabel l_w_lecturer= new JLabel("Workshop Lecturer:");
	    c1.gridx=0;
	    c1.gridy=1;
	    panel_button.add(l_w_lecturer,c1);
	    c1.gridx=1;
	    c1.gridy=1;
	    panel_button.add( W_LECTURER_text,c1);
	 /*   
	    JLabel l_w_participant= new JLabel("Workshop Participants:");
	    c1.gridx=0;
	    c1.gridy=3;
	    panel_button.add(l_w_participant,c1);
	    c1.gridx=1;
	    c1.gridy=3;
	    panel_button.add( W_PARTICIPANT_text,c1);
	    */
	    JLabel l_w_place= new JLabel("Workshop Place:");
	    c1.gridx=2;
	    c1.gridy=1;
	    panel_button.add(l_w_place,c1);
	    c1.gridx=3;
	    c1.gridy=1;
	    panel_button.add( W_PLACE_text,c1);
	    
	    JLabel l_w_category= new JLabel("Workshop Category:");
	    c1.gridx=0;
	    c1.gridy=2;
	    panel_button.add(l_w_category,c1);
	    c1.gridx=1;
	    c1.gridy=2;
	    panel_button.add( W_CATEGORY_text,c1);
	    
	    JLabel l_w_duration= new JLabel( "Workshop Duration [day]:");
	    c1.gridx=2;
	    c1.gridy=2;
	    panel_button.add(l_w_duration,c1);
	    c1.gridx=3;
	    c1.gridy=2;
	    panel_button.add(W_DURATION_text,c1);
	    
	    JLabel l_w_price= new JLabel( "Workshop Price [Euro]:");
	    c1.gridx=0;
	    c1.gridy=4;
	    panel_button.add(l_w_price,c1);
	    c1.gridx=1;
	    c1.gridy=4;
	    panel_button.add(W_PRICE_text,c1);
	    
	    
	    JLabel l_w_description= new JLabel("Workshop Description:");
	    c1.gridx=2;
	    c1.gridy=4;
	    panel_button.add(l_w_description,c1);
	    c1.gridx=3;
	    c1.gridy=4;
	    panel_button.add(W_DESCRIPTION_text,c1);
	    
	    JLabel l_w_literature= new JLabel("Workshop Literature:");
	    c1.gridx=0;
	    c1.gridy=5;
	    panel_button.add(l_w_literature,c1);
	    c1.gridx=1;
	    c1.gridy=5;
	    panel_button.add(W_LITERATURE_text,c1);
	    
	    JLabel l_w_date= new JLabel("Workshop Date:");
	    c1.gridx=2;
	    c1.gridy=5;
	    panel_button.add(l_w_date,c1);
	    c1.gridx=3;
	    c1.gridy=5;
	    panel_button.add(W_DATE_text,c1);
	    
	    // button info
	    c1.gridx=1;
	    c1.gridy=6;
	    panel_button.add(gotoText,c1);
	    c1.gridx=0;
	    c1.gridy=6;
	    panel_button.add(gotoButton,c1);
	    JLabel l_w_id1= new JLabel("Go to Workshop ID");
	    c1.gridx=2;
	    c1.gridy=6;
	    panel_button.add(l_w_id1,c1);
	    
	    c1.gridx=0;
	    c1.gridy=7;
	    panel_button.add(getWorkshopButton,c1);
	    c1.gridx=1;
	    c1.gridy=7;
	    panel_button.add(insertWorkshopButton,c1);
	    c1.gridx=2;
	    c1.gridy=7;
	    panel_button.add(deleteWorkshopButton,c1);
	    c1.gridx=3;
	    c1.gridy=7;
	    panel_button.add(updateWorkshopButton,c1);
	    
	    // all direction
	    c1.gridx=0;
	    c1.gridy=8;
	    panel_button.add(firstButton,c1);
	    c1.gridx=1;
	    c1.gridy=8;
	    panel_button.add(previousButton,c1);
	    c1.gridx=2;
	    c1.gridy=8;
	    panel_button.add(nextButton,c1);
	    c1.gridx=3;
	    c1.gridy=8;
	    panel_button.add(lastButton,c1);
	
	    c1.gridx=1;
	    c1.gridy=9;
	    panel_button.add(freeQueryText,c1);
	    c1.gridx=0;
	    c1.gridy=9;
	    panel_button.add(freeQueryButton,c1);
	    JLabel l_w_id5= new JLabel("Select Query W_ID");
	    c1.gridx=2;
	    c1.gridy=9;
	    panel_button.add(l_w_id5,c1); 
	    
	    
	    JLabel l_w_id3= new JLabel("Workshop ID:");
	    c1.gridx=0;
	    c1.gridy=10;
	   panel_button.add(l_w_id3,c1); 
	    c1.gridx=1;
	    c1.gridy=10;
	    panel_button.add(participantNumberListScrollPane, c1);
	   
	    c1.gridx=2;
	    c1.gridy=10;
	    panel_button.add(errorText,c1);
	    JLabel l_w_id4= new JLabel("Query Message");
	    c1.gridx=3;
	    c1.gridy=10;
	    panel_button.add(l_w_id4,c1); 
	   
	   
	    
	    c1.gridx=0;
	    c1.gridy=11;
	    panel_button.add(getParticipantNumber1,c1); 
	    c1.gridx=1;
	    c1.gridy=11;
	    panel_button.add(P_Number_text1,c1);
	    JLabel l_w_id6= new JLabel("Select the Workshop ID");
	    c1.gridx=2;
	    c1.gridy=11;
	    panel_button.add(l_w_id6,c1); 
	   
	    f.add(panel_button,BorderLayout.WEST);
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
		  Workshop workshop = new Workshop();

		  workshop.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
		  workshop.setSize(850, 500);
		  workshop.setResizable(false);
		  workshop.init();
		  workshop.buildGUI();
	  }
	}
