import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JFrame;

import Controller.DBConnection;
import Controller.WorkshopController;

import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QBrush;
import com.trolltech.qt.gui.QColor;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QFrame;
import com.trolltech.qt.gui.QListWidgetItem;
import com.trolltech.qt.gui.QPalette;
import com.trolltech.qt.gui.QPalette.ColorGroup;
import com.trolltech.qt.gui.QPalette.ColorRole;
import com.trolltech.qt.gui.QPlastiqueStyle;
import com.trolltech.qt.gui.QTreeWidgetItem;
import com.trolltech.qt.gui.QWidget;

public class MainDialogImpl extends QDialog {

	MainDialog ui = new MainDialog();
	int workShopID = -1;

	public static void main(String[] args) {
		QApplication.initialize(args);
		QApplication.setStyle(new QPlastiqueStyle());
		MainDialogImpl testMainDialogImpl = new MainDialogImpl();
		testMainDialogImpl.init();
		testMainDialogImpl.show();

		QApplication.exec();
	}

	public MainDialogImpl() {
		ui.setupUi(this);
		ui.line_Vertical.setFrameShape(QFrame.Shape.VLine);
	}

	public MainDialogImpl(QWidget parent) {
		super(parent);
		ui.setupUi(this);
	}

	public void on_editshowPartButton_clicked() {
		ParticipantsDialogImpl pDpImpl = new ParticipantsDialogImpl(this);
		pDpImpl.show();
	}

	public void on_detailsButton_clicked() {
		ScheduleImpl sImpl = new ScheduleImpl(this);
		sImpl.show();
		// System.out.println("Not implemented yet!");

		// detailsButton clicked
	}

	public void on_addPlaceButton_clicked() {
		NotImplYet();
		System.out.println("Not implemented yet!");

		// addPlaceButton clicked

	}

	public void on_addPriceButton_clicked() {
		NotImplYet();
		System.out.println("Not implemented yet!");

		// addPriceButton clicked

	}

	public void on_deleteCourseButton_clicked() {
		WorkshopController.deleteWorkShop(workShopID);
		resetUI();
	}

	public void on_loadCourseButton_clicked() {

		WorkshopsImpl testWorkshopsImpl = new WorkshopsImpl(this);
		testWorkshopsImpl.show();

	}

	public void on_saveCourseButton_clicked() {

		int id = 0;
		if (!(ui.lineEdit_Titel.text().isEmpty() || ui.lineEdit_Prof.text()
				.isEmpty())) {
			ArrayList<String> workShopData = getWSFromMD();
			if (workShopID == -1) {
				id = WorkshopController.newWorkShop(workShopData);

			} else {
				id = workShopID;
				WorkshopController.updateWorkShop(id, workShopData);
			}
			workShopData = WorkshopController.loadWorkshop(id);
			workShop2MainDialog(workShopData);
			setToEditingWorkShop(id);
		} else if (ui.lineEdit_Titel.text().isEmpty()
				&& ui.lineEdit_Prof.text().isEmpty()) {
			highligthWidget(ui.lineEdit_Titel, "red");
			highligthWidget(ui.lineEdit_Prof, "red");
		} else if (ui.lineEdit_Prof.text().isEmpty()) {
			highligthWidget(ui.lineEdit_Prof, "red");
		} else if (ui.lineEdit_Titel.text().isEmpty()) {
			highligthWidget(ui.lineEdit_Prof, "red");
			highligthWidget(ui.lineEdit_Titel, "red");
		}
	}

	public void highligthWidget(QWidget widget, String color) {
		QPalette palette = widget.palette();
		ColorRole role = QPalette.ColorRole.Base;
		QColor newcolor = new QColor(color);
		palette.setColor(role, newcolor);
		widget.setPalette(palette);
	}

	public void on_clearCourseButton_clicked() {
		resetUI();
	}

	public void on_comboBox_Price_currentStringChanged() {
		// String str = ui.comboBox_Price.currentText();

		// get price texts from database and related prices

		// if (str.equals("reduced"))
		// {
		// ui.lineEdit_Price.setText("30");
		// }
		//
		// else if (str.equals("normal"))
		// {
		// ui.lineEdit_Price.setText("40");
		// }
	}

	public void on_generateHTMLButton_clicked() {
		NotImplYet();
		System.out.println("Not implemented yet!");
		// GenerateHTMLButton clicked
	}

	public void on_editshowPriceButton_clicked()

	{
		PriceCategoriesImpl pCImpl = new PriceCategoriesImpl(this);
		pCImpl.show();
	}

	public void on_addLiteratureButton_clicked() {
		// NotImplYet();
		ui.listWidget_Literature.setCurrentItem(null);
		NewLiteratureImpl nLImpl = new NewLiteratureImpl(this);
		nLImpl.show();

	}

	public void on_deleteLiteratureButton_clicked() {
		String selectedLit = getLitFromMD();

		if (selectedLit != null) {
			String literature = WorkshopController.deleteLiterature(workShopID,
					selectedLit);
			literature2MainDialog(literature);
		}
	}

	public void on_listWidget_itemDoubleClicked() {
		NewLiteratureImpl nLImpl = new NewLiteratureImpl(this);
		nLImpl.show();
	}

	public void on_dateEdit_Start_dateChanged() {
		if (workShopID != -1) {
			QDate min = ui.dateEdit_Start.date();
			ui.dateEdit_End.setMinimumDate(min);
		}
		QDate min = ui.dateEdit_Start.date();
		ui.dateEdit_End.setMinimumDate(min);

	}

	public void on_lineEdit_Titel_textChanged() {
		highligthWidget(ui.lineEdit_Titel, "white");
	}

	public void on_lineEdit_Prof_textChanged() {
		highligthWidget(ui.lineEdit_Prof, "white");
	}

	public void resetUI() {
		workShopID = -1;
		ui.deleteCourseButton.setEnabled(false);
		ui.generateHTMLButton.setEnabled(false);
		ui.deleteLiteratureButton.setEnabled(false);
		ui.detailsButton.setEnabled(false);
		ui.addPlaceButton.setEnabled(false);
		ui.addLiteratureButton.setEnabled(false);
		ui.editshowPartButton.setEnabled(false);
		ui.editshowPriceButton.setEnabled(false);
		ui.listWidget_Literature.clear();
		ui.comboBox_Price.clear();
		ui.lineEdit_Duration.clear();
		ui.lineEdit_Part.clear();
		ui.lineEdit_Prof.clear();
		ui.lineEdit_Titel.clear();
		ui.textEdit_Description.clear();
		ui.lineEdit_Price.clear();
		QDate min = QDate.currentDate();
		ui.dateEdit_Start.setDate(min);
		ui.dateEdit_End.setDate(min);
	}

	public void setToEditingWorkShop(int id) {
		workShopID = id;
		ui.deleteCourseButton.setEnabled(true);
		ui.generateHTMLButton.setEnabled(true);
		ui.deleteLiteratureButton.setEnabled(true);
		ui.detailsButton.setEnabled(true);
		ui.addPlaceButton.setEnabled(true);
		ui.addLiteratureButton.setEnabled(true);
		ui.editshowPartButton.setEnabled(true);
		ui.editshowPriceButton.setEnabled(true);
		ui.comboBox_Price.setEnabled(true);

	}

	public void NotImplYet() {
		JFrame frame;
		frame = new JFrame("Show Message Dialog");
		frame.setSize(400, 400);
		frame.setVisible(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.hide();
		javax.swing.JOptionPane
				.showMessageDialog(frame, "Not implemented yet!");

	}

	public void init() {
		QDate min = QDate.currentDate();
		ui.dateEdit_Start.setMinimumDate(min);
		ui.dateEdit_End.setMinimumDate(min);
		DBConnection.connectToDB();
	}

	public void literature2MainDialog(String lit) {
		ui.listWidget_Literature.clear();
		String[] items = lit.split(";");
		ArrayList<String> itemsList = new ArrayList<String>(
				Arrays.asList(items));
		// System.out.println(itemsList.toString());
		if (!itemsList.isEmpty()) {
			ui.listWidget_Literature.addItems(itemsList);
		}

		// ui.listWidget_Literature.addItems(itemsList);
	}

	public void workShop2MainDialog(ArrayList<String> wsData) {
		ui.lineEdit_Titel.setText(wsData.get(0));
		ui.lineEdit_Prof.setText(wsData.get(1));
		ui.lineEdit_Part.setText(wsData.get(2));
		// mDImpl.ui.comboBox_Ort.setCurrentIndex(index)

		// mDImpl.ui.comboBox_Price.setItemText(index, text)
		// W_CATEGORY_text.setText(resultSet.getString("W_CATEGORY"));
		ui.lineEdit_Duration.setText(wsData.get(3));
		ui.lineEdit_Price.setText(wsData.get(4));
		ui.textEdit_Description.setText(wsData.get(5));
		literature2MainDialog(wsData.get(6));

		String startDate = wsData.get(7);
		ui.dateEdit_Start.setDate(WorkshopController
				.dateString2QDate(startDate));

		String endDate = wsData.get(8);
		ui.dateEdit_End.setDate(WorkshopController.dateString2QDate(endDate));
		ui.lineEdit_Part.setText(wsData.get(9));
		// mDImpl.ui.listWidget_Literature.addItem(res
		// .getString("W_LITERATURE"));
		// mDImpl.ui.lineEdit_dateEnd.setText(arg__1);
		// mDImpl.ui.lineEdit_dateStart.setText(arg__1);
	}

	public ArrayList<String> getWSFromMD() {
		Calendar cal = Calendar.getInstance();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,
				DateFormat.MEDIUM, Locale.PRC);
		// System.out.println(df.format(cal.getTime()));

		QDate start = ui.dateEdit_Start.date();
		QDate end = ui.dateEdit_End.date();
		String startString = WorkshopController.qDate2dateString(start);
		String endString = WorkshopController.qDate2dateString(end);

		System.out.println(startString);
		System.out.println(endString);

		ArrayList<String> workShopData = new ArrayList<String>();
		workShopData.add(ui.lineEdit_Titel.text());
		workShopData.add(ui.lineEdit_Prof.text());
		workShopData.add(ui.textEdit_Description.toPlainText());
		workShopData.add(startString);
		workShopData.add(endString);
		//
		// String workShopStr = "','" + ui.lineEdit_Titel.text() + "','"
		// + ui.lineEdit_Prof.text() + "','" + "0" + "','" + "" + "','"
		// + "" + "','" + "0" + "','" + "0" + "','"
		// + ui.textEdit_Description.toPlainText() + "','" + "" + "','"
		// + startString + "','" + endString;

		return workShopData;
	}

	public String getLitFromMD() {
		QListWidgetItem item = ui.listWidget_Literature.currentItem();
		if (item == null || item.data(0).toString().equals("")) {
			return null;
		} else {
			String data = (String) item.data(0);
			System.out.println(data);
			return data;
		}

	}

	public void setNumOfParts(int numOfParticipants) {
		ui.lineEdit_Part.setText(Integer.toString(numOfParticipants));
	}
}
