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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Workshop extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton getWorkshopButton, insertWorkshopButton, deleteWorkshopButton,
      			  updateWorkshopButton, nextButton, previousButton, lastButton,
      			  firstButton, gotoButton, freeQueryButton;
  
  private JList listWorkshop;
  
  private JTextField W_ID_text,W_TITLE_text, W_LECTURER_text,W_PARTICIPANT_text,W_PLACE_text,
  W_CATEGORY_text,W_DURATION_text,W_PRICE_text,W_DESCRIPTION_text, W_LITERATURE_text,W_DATE_text, gotoText,freeQueryText;
  
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
	          .getConnection("jdbc:mysql://localhost/workshop_software_db?user=root&password=test");
	      statement = connection.createStatement();

	    } catch (SQLException connectException) {
	      System.out.println(connectException.getMessage());
	      System.out.println(connectException.getSQLState());
	      System.out.println(connectException.getErrorCode());
	      System.exit(1);
	    }
	  }
  
  // laod data from workshop_table table
  private void loadParticipant() {
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

  // GUI building 
  @SuppressWarnings("deprecation")
private void buildGUI() {
	
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    listWorkshop = new JList();
    loadParticipant();
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
      	  W_PARTICIPANT_text.setText(resultSet.getString("W_PARTICIPANT"));
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
                  +W_PARTICIPANT_text.getText() + "','"
                  +W_PLACE_text.getText() + "','"
                  +W_CATEGORY_text.getText() + "','" 
                  +W_DURATION_text.getText() + "','"
                  +W_PRICE_text.getText() + "','" 
                  +W_DESCRIPTION_text.getText() + "','"
                  +W_LITERATURE_text.getText() + "','" 
                  +W_DATE_text.getText()+ "')");
          errorText.append("Inserted " + i + " rows successfully");
          listWorkshop.removeAll();
          loadParticipant();
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
          loadParticipant();
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
              + "W_PARTICIPANT='"+W_PARTICIPANT_text.getText()+ "',"
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
        	
        	  W_ID_text.setText(resultSet.getString("W_ID"));
        	  W_TITLE_text.setText(resultSet.getString("W_TITLE"));
        	  W_LECTURER_text.setText(resultSet.getString("W_LECTURER"));
        	  W_PARTICIPANT_text.setText(resultSet.getString("W_PARTICIPANT"));
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
        	  W_PARTICIPANT_text.setText(resultSet.getString("W_PARTICIPANT"));
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
      	  W_PARTICIPANT_text.setText(resultSet.getString("W_PARTICIPANT"));
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
      	  W_PARTICIPANT_text.setText(resultSet.getString("W_PARTICIPANT"));
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
      	  W_PARTICIPANT_text.setText(resultSet.getString("W_PARTICIPANT"));
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
          	  W_PARTICIPANT_text.setText(resultSet.getString("W_PARTICIPANT"));
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
            loadParticipant();
          }
        } catch (SQLException insertException) {
          displaySQLErrors(insertException);
        }
      }
    });

    gotoText = new JTextField(3);
    freeQueryText = new JTextField(40);
    W_ID_text = new JTextField(15);
    W_TITLE_text = new JTextField(15);
    W_LECTURER_text = new JTextField(15);
    W_PARTICIPANT_text= new JTextField(15);
    W_PLACE_text= new JTextField(15);
    W_CATEGORY_text= new JTextField(15);
    W_DURATION_text = new JTextField(15);
    W_PRICE_text = new JTextField(15);
    W_DESCRIPTION_text= new JTextField(15);
    W_LITERATURE_text = new JTextField(15);
    W_DATE_text = new JTextField(15);
    
    errorText = new JTextArea(5, 15);
   
    
    JPanel second = new JPanel(new GridLayout(11,1));
    second.setLayout(new GridLayout(15,1));
    second.add(W_ID_text);
    second.add(W_TITLE_text);
    second.add( W_LECTURER_text);
    second.add(W_PARTICIPANT_text);
    second.add(W_PLACE_text);
    second.add(W_CATEGORY_text);
    second.add(W_DURATION_text);
    second.add(W_PRICE_text);
    second.add(W_DESCRIPTION_text);
    second.add(W_LITERATURE_text);
    second.add(W_DATE_text);


    JPanel third = new JPanel();
    third.add(new JScrollPane(errorText));
    errorText.setEditable(false);
    
    JPanel first= new JPanel(new GridLayout(5,1)); 
    first.add(participantNumberListScrollPane);
    first.add(getWorkshopButton);
    first.add(insertWorkshopButton);
    first.add(deleteWorkshopButton);
    first.add(updateWorkshopButton);
 
    
    JPanel fourth = new JPanel();
    fourth.add(firstButton);
    fourth.add(previousButton);
    fourth.add(nextButton);
    fourth.add(lastButton);
    fourth.add(gotoText);
    fourth.add(gotoButton);

    JPanel fifth = new JPanel();
    fifth.add(freeQueryText);

    c.add(first);
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
	  Workshop workshop = new Workshop();

	  workshop.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
	  workshop.setSize(600, 600);
	  workshop.setResizable(false);
	  workshop.init();
	  workshop.buildGUI();
  }
}
