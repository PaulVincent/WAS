package CONTROLLER;
//package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.trolltech.qt.gui.QTreeWidgetItem;

public class WorkshopController {

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
				item.setData(3, 0, res.getString("W_DATE").toString().split("\\.")[0]);
				item.setData(4, 0, res.getString("W_PARTICIPANT"));
				items.add(item);
			}
		} catch (SQLException selectException) {
			// displaySQLErrors(selectException);
		}
		return items;
	}
	
	public static ArrayList<QTreeWidgetItem> initWSParticipants(int workShopID) {

		ArrayList<QTreeWidgetItem> items = new ArrayList<QTreeWidgetItem>();
//
		try {
			ResultSet res = DBConnection.statement
					.executeQuery("SELECT * from workshop.participants_table");

			while (res.next()) {
				QTreeWidgetItem item = new QTreeWidgetItem();
				item.setData(0, 0, res.getString("P_ID"));
				item.setData(1, 0, res.getString("P_FIRSTNAME"));
				item.setData(2, 0, res.getString("P_LASTNAME"));
				item.setData(3, 0, res.getString("P_REGISTRATION"));
				item.setData(4, 0, res.getString("P_PRICE"));
				item.setData(5, 0, res.getString("P_PAID"));
				items.add(item);
			}
		} catch (SQLException selectException) {
			// displaySQLErrors(selectException);
		}
		return items;
	}

	public static int newWorkShop(String workShopStr) {
		int id = 0;
		String newWorkShopStr = "";
		try {
			ResultSet res = DBConnection.statement
					.executeQuery("Select max(W_ID) from workshop.workshop_table");
			while (res.next()) {
				id = res.getInt("max(W_ID)") + 1;
				newWorkShopStr = Integer.toString(id) + workShopStr;
			}
			int i = DBConnection.statement
					.executeUpdate("INSERT INTO workshop_table VALUES('"
							+ newWorkShopStr + "')");
			System.out.println("Inserted " + i + " rows successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public static int newParticipant(String participantStr) {
		int id = 0;
		String newParticipantStr = "";
		try {
			ResultSet res = DBConnection.statement
					.executeQuery("Select max(P_ID) from workshop.participants_table");
			while (res.next()) {
				id = res.getInt("max(P_ID)") + 1;
				newParticipantStr = Integer.toString(id) + participantStr;
			}
			int i = DBConnection.statement
					.executeUpdate("INSERT INTO participants_table VALUES('"
							+ newParticipantStr + "')");
			System.out.println("Inserted " + i + " rows successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public static ArrayList<String> loadWorkshop(int id) {
		// TODO Auto-generated method stub
		ArrayList<String> workshopData = new ArrayList<String>();
		String idStr = Integer.toString(id);
		try {
			ResultSet res = DBConnection.statement
					.executeQuery("SELECT * FROM workshop.workshop_table WHERE W_ID = "
							+ idStr);
			while (res.next()) {
				workshopData.add(res.getString("W_TITLE"));
				// mDImpl.ui.lineEdit_Titel.setText(res.getString("W_TITLE"));
				workshopData.add(res.getString("W_LECTURER"));
				workshopData.add(res.getString("W_PARTICIPANT"));
				// // mDImpl.ui.comboBox_Ort.setCurrentIndex(index)
				//
				// // mDImpl.ui.comboBox_Price.setItemText(index, text)
				// //
				// W_CATEGORY_text.setText(resultSet.getString("W_CATEGORY"));
				workshopData.add(res.getString("W_DURATION"));
				workshopData.add(res.getString("W_PRICE"));
				workshopData.add(res.getString("W_DESCRIPTION"));
				workshopData.add(res.getString("W_LITERATURE"));
				// // mDImpl.ui.listWidget_Literature.addItem(res
				// // .getString("W_LITERATURE"));
//				System.out.println(res.getString("W_DATE"));
				// // mDImpl.ui.lineEdit_dateEnd.setText(arg__1);
				// // mDImpl.ui.lineEdit_dateStart.setText(arg__1);

				id = Integer.parseInt(idStr);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workshopData;
		// mDImpl.setToEditingWorkShop(id);
	}

	public static ArrayList<String> loadParticipant(int id) {
		// TODO Auto-generated method stub
		ArrayList<String> participantData = new ArrayList<String>();
		String idStr = Integer.toString(id);
		try {
			ResultSet res = DBConnection.statement
					.executeQuery("SELECT * FROM workshop.participants_table WHERE P_ID = "
							+ idStr);
			while (res.next()) {
				participantData.add(res.getString("P_FIRSTNAME"));
				participantData.add(res.getString("P_LASTNAME"));
				participantData.add(res.getString("P_STREETNAME"));
				participantData.add(res.getString("P_HOUSE"));
				participantData.add(res.getString("P_PLACE"));
				participantData.add(res.getString("P_ZIPCODE"));
				participantData.add(res.getString("P_PHONE"));
				participantData.add(res.getString("P_EMAIL"));
				participantData.add(res.getString("P_CATEGORY"));
				participantData.add(res.getString("P_PRICE"));
				participantData.add(res.getString("P_REGISTRATION"));
				participantData.add(res.getString("P_PAID"));
				
				id = Integer.parseInt(idStr);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return participantData;
		// mDImpl.setToEditingWorkShop(id);
	}

	public static void deleteWorkShop(int id) {
		try {
			int i = DBConnection.statement
					.executeUpdate("DELETE FROM workshop_table WHERE W_ID = "
							+ Integer.toString(id));
			System.out.println("Deleted " + i + " rows successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteParticipant(int id) {
		try {
			int i = DBConnection.statement
					.executeUpdate("DELETE FROM participants_table WHERE P_ID = "
							+ Integer.toString(id));
			System.out.println("Deleted " + i + " rows successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String newLiterature(String lit, int id) {
		String newLits = editLiterature(id, lit, "add");
		return newLits;

	}

	public static String deleteLiterature(int id, String selectedLit) {
		String newLits = editLiterature(id, selectedLit, "delete");
		return newLits;
	}

	public static String editLiterature(int id, String lit, String editType) {
		String newLits = "";
		try {
			ResultSet res = DBConnection.statement
					.executeQuery("Select W_LITERATURE from workshop.workshop_table WHERE W_ID = "
							+ Integer.toString(id));
			while (res.next()) {
				String currentLits = res.getString("W_LITERATURE");
				if (editType == "add") {
					newLits = currentLits + lit;
				} else if (editType == "delete") {
					newLits = currentLits.replace(lit + ";", "");
				}
			}
			DBConnection.statement
					.executeUpdate("UPDATE workshop.workshop_table SET W_LITERATURE = '"
							+ newLits
							+ "' WHERE W_ID = "
							+ Integer.toString(id));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ResultSet res;
		try {
			ResultSet res = DBConnection.statement
					.executeQuery("Select W_LITERATURE from workshop.workshop_table WHERE W_ID = "
							+ Integer.toString(id));
			while (res.next()) {
				newLits = res.getString("W_LITERATURE");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newLits;
	}
}
