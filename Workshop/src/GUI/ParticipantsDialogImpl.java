package GUI;
import ParticipantsDialog;

import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QTreeWidgetItem;
import com.trolltech.qt.gui.QWidget;

public class ParticipantsDialogImpl extends QDialog {

	ParticipantsDialog ui = new ParticipantsDialog();
	int partID = -1;
	MainDialogImpl mDImpl = null;

	public static void main(String[] args) {
		QApplication.initialize(args);

		ParticipantsDialogImpl testParticipantsDialogImpl = new ParticipantsDialogImpl();
		testParticipantsDialogImpl.show();
		QApplication.exec();
	}

	public ParticipantsDialogImpl() {
		ui.setupUi(this);
		
	}

	public ParticipantsDialogImpl(QWidget parent) {
		super(parent);
		ui.setupUi(this);
	}
	
	public ParticipantsDialogImpl(MainDialogImpl mDImpl) {
		ui.setupUi(this);
		this.mDImpl = mDImpl;
		
		ui.treeWidget.setCurrentItem(null);
		setAdditionalLayoutOptions();
	}

	public void on_addRealPartButton_clicked() {
		
		System.out.println(ui.treeWidget.currentIndex());
		ui.treeWidget.setCurrentItem(null);
		PaticipantInfoImpl testParticipantsInfoImpl = new PaticipantInfoImpl(this);
		testParticipantsInfoImpl.show();
	}

	public void on_deleteRealPartButton_clicked() {
		
		if (ui.treeWidget.selectedItems().isEmpty())
		{
			// Code to remove participant from database
//			clear treewidget and reload from database
		}
	}

	public void on_treeWidget_itemDoubleClicked()
	{
		QTreeWidgetItem item = ui.treeWidget.currentItem();
		String  strID = item.data(0, 0).toString();
		int ID = Integer.parseInt(strID);
		partID = ID;
//		get all infos of currently selected participant from database and write 
//		info in participant Info dialog !!!
		PaticipantInfoImpl testParticipantsInfoImpl = new PaticipantInfoImpl(this);
		testParticipantsInfoImpl.show();

		String vorname = item.data(1, 0).toString();
		testParticipantsInfoImpl.ui.lineEdit_FirstName.setText(vorname);
		
		String nachname = item.data(2, 0).toString();
		testParticipantsInfoImpl.ui.lineEdit_SurName.setText(nachname);

		String preis = item.data(4, 0).toString();
		testParticipantsInfoImpl.ui.lineEdit_Price.setText(preis);

		String bezahlt = item.data(5, 0).toString();
		Boolean bez;
		if (bezahlt.startsWith("J"))
		{
			bez = true;
			testParticipantsInfoImpl.ui.checkBox_Paid.setChecked(bez);
		}
		else if (bezahlt.startsWith("N"))
		{
			bez = false;
			testParticipantsInfoImpl.ui.checkBox_Paid.setChecked(bez);
		}

		String Str_datum = item.data(3, 0).toString();
		String[] datum = Str_datum.split("\\.");
						
		String Str_year = datum[2];
		String Str_month = datum[1];
		String Str_day = datum[0];
		
		int year = Integer.parseInt(Str_year);
		int month = Integer.parseInt(Str_month);
		int day = Integer.parseInt(Str_day);
		
		QDate date = new QDate();
		date.setDate(year, month, day);
		
		testParticipantsInfoImpl.ui.dateEdit.setDate(date);

	}

	public void setAdditionalLayoutOptions()
	{
		int width = 40;
		int widthID = 25;
		ui.treeWidget.setColumnWidth(0, widthID);
		ui.treeWidget.setColumnWidth(4, width);
		ui.treeWidget.setColumnWidth(5, width);
	}
}
