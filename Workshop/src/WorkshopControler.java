//package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Controller.DBConnection;

import com.trolltech.qt.gui.QTreeWidgetItem;

public class WorkshopControler {

	public static ArrayList<QTreeWidgetItem> initWorkShops() {
		
		ArrayList<QTreeWidgetItem> items = new ArrayList<QTreeWidgetItem>();
		
		try {
			ResultSet res = DBConnection.statement
					.executeQuery("SELECT * from workshop_table");
			
			while (res.next()) {
				QTreeWidgetItem item = new QTreeWidgetItem();
				item.setData(0, 0, res.getString("W_ID"));				
				item.setData(1, 0, res.getString("W_TITLE"));
				item.setData(2, 0, res.getString("W_LECTURER"));
				item.setData(3, 0, res.getString("W_DATE"));
				item.setData(4, 0, res.getString("W_PARTICIPANT"));
				items.add(item);
			}
		} catch (SQLException selectException) {
			// displaySQLErrors(selectException);
		}
		return items;
	}

	public static int newWorkShop(MainDialogImpl mDImpl)
	{
		int id = 0;
		try {
			ResultSet res = DBConnection.statement.executeQuery("Select max(W_ID) from workshop_table");
			while (res.next())
			{
				id = res.getInt("max(W_ID)") + 1;
				System.out.println(id);
			}			
			int i = DBConnection.statement.executeUpdate("INSERT INTO workshop_table VALUES('"
					+Integer.toString(id)  + "','" 
					+mDImpl.ui.lineEdit_Titel.text()  + "','" 
			        +mDImpl.ui.lineEdit_Prof.text() + "','"
			        +"0" + "','"
			        +"LEER" + "','"
			        +"LEER" + "','"
			        +"0" + "','"
			        +"0" + "','" 
			        +mDImpl.ui.textEdit_Description.toPlainText() + "','"
			        +"LEER" + "','" 
			        +"2011-12-24 12:00:00" + "')");
			System.out.println("Inserted " + i + " rows successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public static void ws2MainDialog(int id, MainDialogImpl mDImpl) {
		// TODO Auto-generated method stub
		String idStr = Integer.toString(id);
		try {
			ResultSet res = DBConnection.statement
					.executeQuery("SELECT * FROM workshop_table WHERE W_ID = "
							+ idStr);
			while (res.next()) {
				mDImpl.ui.lineEdit_Titel.setText(res
						.getString("W_TITLE"));
				mDImpl.ui.lineEdit_Prof.setText(res
						.getString("W_LECTURER"));
				mDImpl.ui.lineEdit_Part.setText(res
						.getString("W_PARTICIPANT"));
				// mDImpl.ui.comboBox_Ort.setCurrentIndex(index)

				// mDImpl.ui.comboBox_Price.setItemText(index, text)
				// W_CATEGORY_text.setText(resultSet.getString("W_CATEGORY"));
				mDImpl.ui.lineEdit_Duration.setText(res
						.getString("W_DURATION"));
				mDImpl.ui.lineEdit_Price.setText(res
						.getString("W_PRICE"));
				mDImpl.ui.textEdit_Description.setText(res
						.getString("W_DESCRIPTION"));
				mDImpl.ui.listWidget_Literature.addItem(res
						.getString("W_LITERATURE"));
				// mDImpl.ui.lineEdit_dateEnd.setText(arg__1);
				// mDImpl.ui.lineEdit_dateStart.setText(arg__1);

				id = Integer.parseInt(idStr);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mDImpl.setToEditingWorkShop(id);
	}

	public static void deleteWorkShop(int id){
		try {
			int i = DBConnection.statement.executeUpdate("DELETE FROM workshop_table WHERE W_ID = "+ Integer.toString(id));
	          System.out.println("Deleted " + i + " rows successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
