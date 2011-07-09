package Controller;

//package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trolltech.qt.core.QDate;
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
				// item.setData(3, 0,
				// // res.getString("W_DATE").toString().split("\\.")[0]);
				// String dateString = res.getString("W_DATE_START");
				item.setData(3, 0, res.getString("W_DATE_START"));
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
					.executeQuery("SELECT * from workshop.participants_table WHERE W_ID = "
							+ Integer.toString(workShopID));

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

	public static ArrayList<QTreeWidgetItem> initSchedule(int workShopID) {
		ArrayList<QTreeWidgetItem> items = new ArrayList<QTreeWidgetItem>();

		try {
			ResultSet res = DBConnection.statement
					.executeQuery("SELECT * from Time_Schedule_table WHERE W_ID = "
							+ Integer.toString(workShopID));

			while (res.next()) {
				QTreeWidgetItem item = new QTreeWidgetItem();
				item.setData(0, 0, res.getString("W_Date"));
				String timeString = res.getString("W_SCHEDULE");
				String start = timeString.split("-")[0];
				String end = timeString.split("-")[1];
				item.setData(1, 0, start);
				item.setData(2, 0, end);
				items.add(item);
			}
		} catch (SQLException selectException) {
			// displaySQLErrors(selectException);
		}
		return items;
	}

	public static ArrayList<QTreeWidgetItem> initPriceCategories(int workShopID){
		ArrayList<QTreeWidgetItem> items = new ArrayList<QTreeWidgetItem>();

		try {
			ResultSet res = DBConnection.statement
					.executeQuery("SELECT * from PriceCategory_table WHERE W_ID = "
							+ Integer.toString(workShopID));

			while (res.next()) {
				QTreeWidgetItem item = new QTreeWidgetItem();
				item.setData(0, 0, res.getString("C_CATEGORY"));
				item.setData(1, 0, res.getString("C_PRICE"));
				
				items.add(item);
			}
		} catch (SQLException selectException) {
			// displaySQLErrors(selectException);
		}
		return items;
	}
	
	public static int newWorkShop(ArrayList<String> workShopData) {
		int id = 0;
		String workShopStr = "','" + workShopData.get(0) + "','"
				+ workShopData.get(1) + "','" + "0" + "','" + "" + "','" + ""
				+ "','" + "0" + "','" + "0" + "','" + workShopData.get(2)
				+ "','" + "" + "','" + workShopData.get(3) + "','"
				+ workShopData.get(4);
		try {
			ResultSet res = DBConnection.statement
					.executeQuery("Select max(W_ID) from workshop.workshop_table");
			while (res.next()) {
				id = res.getInt("max(W_ID)") + 1;
				workShopStr = Integer.toString(id) + workShopStr;
			}
			int i = DBConnection.statement
					.executeUpdate("INSERT INTO workshop_table VALUES('"
							+ workShopStr + "')");
			System.out.println("Inserted " + i + " rows successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public static int newParticipant(String participantStr, int workShopID) {
		int id = 0;
		String newParticipantStr = "";
		try {
			ResultSet res = DBConnection.statement
					.executeQuery("Select max(P_ID) from workshop.participants_table");
			while (res.next()) {
				id = res.getInt("max(P_ID)") + 1;
				newParticipantStr = Integer.toString(workShopID) + "', '"
						+ Integer.toString(id) + participantStr;
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

	public static void newTimeIntervall(String timeStr) {
		// int timeID = 0;
		// String newTimeStr = "";
		try {
			int i = DBConnection.statement
					.executeUpdate("INSERT INTO Time_Schedule_table VALUES('"
							+ timeStr + "')");
			System.out.println("Inserted " + i + " rows successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return timeID;
	}

	public static void newPriceCategory(String priceCategoryStr) {
		// int timeID = 0;
		// String newTimeStr = "";
		try {
			int i = DBConnection.statement
					.executeUpdate("INSERT INTO PriceCategory_table VALUES('"
							+ priceCategoryStr + "')");
			System.out.println("Inserted " + i + " rows successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return timeID;
	}
	
	public static ArrayList<String> loadWorkshop(int id) {
		// TODO Auto-generated method stub
		ArrayList<String> workshopData = new ArrayList<String>();
		String idStr = Integer.toString(id);
		int count = getParticipantCount(Integer.parseInt(idStr));
		int hours = getDuration(id);
//		String place = getPlace(id);
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
				workshopData.add(res.getString("W_DATE_START"));
				workshopData.add(res.getString("W_DATE_END"));
				workshopData.add(Integer.toString(count));
				workshopData.add(Integer.toString(hours));
				
				// // mDImpl.ui.listWidget_Literature.addItem(res
				// // .getString("W_LITERATURE"));
				// System.out.println(res.getString("W_DATE"));
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

	public static ArrayList<String> loadAllPlaces(){
		ArrayList<String> places = new ArrayList<String>();
		
		try {
			ResultSet res = DBConnection.statement
					.executeQuery("SELECT Pl_NAME from Places_table");

			while (res.next()) {
				places.add(res.getString("PL_NAME"));				
			}
		} catch (SQLException selectException) {
			// displaySQLErrors(selectException);
		}
		return places;
	}
	
	public static void deleteWorkShop(int id) {
		try {
			int i = DBConnection.statement
					.executeUpdate("DELETE FROM workshop_table WHERE W_ID = "
							+ Integer.toString(id));
			System.out.println("Deleted " + i + " rows successfully");
			int j = DBConnection.statement
					.executeUpdate("DELETE FROM participants_table WHERE W_ID = "
							+ Integer.toString(id));
			System.out.println("Deleted " + j + " rows successfully");
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

	public static void deleteTimeIntervall(ArrayList<String> timeIntervall, int id)
	{
		try {
			int i = DBConnection.statement
					.executeUpdate("DELETE FROM Time_Schedule_table WHERE W_ID = "
							+ Integer.toString(id) + " AND W_DATE = '" + timeIntervall.get(0)
							+ "' AND W_SCHEDULE = '" + timeIntervall.get(1) + "'");
							
			System.out.println("Deleted " + i + " rows successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateWorkShop(int id, ArrayList<String> dataList) {
		try {
			DBConnection.statement.executeUpdate("UPDATE workshop_table "
					+ "SET W_TITLE='" + dataList.get(0) + "'," + "W_LECTURER='"
					+ dataList.get(1) + "'," + "W_DESCRIPTION='"
					+ dataList.get(2) + "'," + "W_DATE_START ='"
					+ dataList.get(3) + "'," + "W_DATE_END ='"
					+ dataList.get(4) + "'" + "WHERE W_ID = "
					+ Integer.toString(id));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateParticipant(ArrayList<String> partData, int workShopID, int partID){
		try {
			DBConnection.statement.executeUpdate("UPDATE workshop.participants_table "
					+ "SET P_FIRSTNAME='" + partData.get(0) + "',"
					+ "P_LASTNAME='"+ partData.get(1) + "',"
					+ "P_STREETNAME='" + partData.get(2) + "'," 
					+ "P_HOUSE ='" + partData.get(3) + "'," 
					+ "P_PLACE ='" + partData.get(4) + "'," 
					+ "P_ZIPCODE ='" + partData.get(5) + "'," 
					+ "P_PHONE ='" + partData.get(6) + "'," 
					+ "P_EMAIL ='" + partData.get(7) + "'," 
					+ "P_CATEGORY ='" + partData.get(8) + "'," 
					+ "P_PRICE ='" + partData.get(9) + "'," 
					+ "P_REGISTRATION ='" + partData.get(10) + "'," 
					+ "P_PAID ='" + partData.get(11) + "',"
					+ "P_DATE ='" + partData.get(12) + "'"  
					+ "WHERE W_ID = " + Integer.toString(workShopID) 
					+ " AND P_ID = " + Integer.toString(partID));

		} catch (SQLException e) {
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

	public static int getParticipantCount(int workShopID) {
		int number = 0;
		try {
			ResultSet res = DBConnection.statement
					.executeQuery("Select count(P_ID) as number from workshop.participants_table WHERE W_ID = "
							+ Integer.toString(workShopID));
			while (res.next()) {
				number = res.getInt("number");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}

	public static int getDuration(int id) {
		int hours = 0;
		try {
			ResultSet res = DBConnection.statement
					.executeQuery("Select W_SCHEDULE from Time_Schedule_table WHERE W_ID = "
							+ Integer.toString(id));
			while (res.next()) {
				String start = res.getString("W_SCHEDULE").split("-")[0];
				String end = res.getString("W_SCHEDULE").split("-")[1];
				int startHour = Integer.parseInt(start.split(":")[0]);
				int endHour = Integer.parseInt(end.split(":")[0]);
				hours = hours + (endHour - startHour);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hours;
	}

	public static QDate dateString2QDate(String dateString) {
		String year = dateString.split("-")[0];
		String month = dateString.split("-")[1];
		String day = dateString.split("-")[2];

		return new QDate(Integer.parseInt(year), Integer.parseInt(month),
				Integer.parseInt(day));
	}

	public static String qDate2dateString(QDate date) {
		return Integer.toString(date.year()) + "-"
				+ Integer.toString(date.month()) + "-"
				+ Integer.toString(date.day());
	}
}
