
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import Controller.WorkshopController;

import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QWidget;

public class PaticipantInfoImpl extends QDialog {

	PaticipantInfo ui = new PaticipantInfo();
	ParticipantsDialogImpl pDImpl = null;

	public static void main(String[] args) {
		QApplication.initialize(args);

		PaticipantInfoImpl testPaticipantInfoImpl = new PaticipantInfoImpl();
		testPaticipantInfoImpl.show();

		QApplication.exec();
	}

	public PaticipantInfoImpl() {
		ui.setupUi(this);
	}

	public PaticipantInfoImpl(QWidget parent) {
		super(parent);
		ui.setupUi(this);
	}

	public PaticipantInfoImpl(ParticipantsDialogImpl pDImpl) {
		ui.setupUi(this);
		this.pDImpl = pDImpl;		
	}

	public void on_savePartButton_clicked() {
		
		if (pDImpl.partID == -1) {
			String participantStr = getParticipantFromPID();
			pDImpl.partID = WorkshopController.newParticipant(participantStr, pDImpl.mDImpl.workShopID);
			
		} else {
			pDImpl.mDImpl.NotImplYet();
			System.out.println("Not implemented yet!");
		}

		pDImpl.ui.treeWidget.clear();
		pDImpl.init();
		int numOfParticipants = WorkshopController.getParticipantCount(pDImpl.mDImpl.workShopID);
		pDImpl.mDImpl.setNumOfParts(numOfParticipants);
	}

	public void on_clearPartButton_clicked() {
		pDImpl.partID = -1;
		ui.checkBox_Paid.setChecked(false);
		QDate minDate = ui.dateEdit.minimumDate();
		ui.dateEdit.setDate(minDate);
		ui.lineEdit_FirstName.clear();
		ui.lineEdit_HouseNr.clear();
		ui.lineEdit_PhoneNumber.clear();
		ui.lineEdit_Place.clear();
		ui.lineEdit_Price.clear();
		ui.lineEdit_Street.clear();
		ui.lineEdit_SurName.clear();
		ui.lineEdit_ZIPCode.clear();
		ui.lineEdit_eMail.clear();
	}

	public String getParticipantFromPID() {
		Calendar cal = Calendar.getInstance();
		DateFormat dtf = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,
				DateFormat.MEDIUM, Locale.PRC);
		String checkState = "";		
		
		if (ui.checkBox_Paid.checkState().toString() == "Checked")
		{
			checkState = "Ja";
		}
		else{
			checkState = "Nein";
		}
		
		String dateString = qDate2dateString(ui.dateEdit.date());
		
		String participantStr = "', '" + ui.lineEdit_FirstName.text() + "', '"
				+ ui.lineEdit_SurName.text() + "', '"
				+ ui.lineEdit_Street.text() + "', '"
				+ ui.lineEdit_HouseNr.text() + "', '"
				+ ui.lineEdit_Place.text() + "', '"
				+ ui.lineEdit_ZIPCode.text() + "', '"
				+ ui.lineEdit_PhoneNumber.text() + "', '"
				+ ui.lineEdit_eMail.text() + "', '"
				+ ui.comboBox_PriceCategory.currentText() + "', '"
				+ ui.lineEdit_Price.text() + "', '" + dateString
				+ "', '" + checkState + "', '"
				+ dtf.format(cal.getTime());
		
		return participantStr;
	}

	public void part2PID(ArrayList<String> participantData)
	{
		ui.lineEdit_FirstName.setText(participantData.get(0));
		ui.lineEdit_SurName.setText(participantData.get(1));
		ui.lineEdit_Street.setText(participantData.get(2));
		ui.lineEdit_HouseNr.setText(participantData.get(3));
		ui.lineEdit_Place.setText(participantData.get(4));
		ui.lineEdit_ZIPCode.setText(participantData.get(5));
		ui.lineEdit_PhoneNumber.setText(participantData.get(6));
		ui.lineEdit_eMail.setText(participantData.get(7));
//		ui.comboBox_PriceCategory.setCurrentIndex(participantData.get(8));
		ui.lineEdit_Price.setText(participantData.get(9));
//		String dateStrin
//		QDate date;
//		date.setDate(year, month, day);
//		ui.dateEdit.setDate(date);
//		ui.dateEdit.setDate(participantData.get(10));
		if (participantData.get(11).equals("Ja"))
		{
			ui.checkBox_Paid.setChecked(true);
		}
		else {
			ui.checkBox_Paid.setChecked(false);
		}		
	}

	public void on_OKButton_clicked()
	{
		this.close();
		pDImpl.partID = -1;
	}
	
	public void on_CancelButton_clicked()
	{
		this.close();
		pDImpl.partID = -1;
	}

	public QDate dateString2QDate(String dateString)
	{
		String year = dateString.split("-")[0];
		String month = dateString.split("-")[1];
		String day = dateString.split("-")[2];
		
		return new QDate(Integer.parseInt(year),
				Integer.parseInt(month), Integer.parseInt(day));
	}

	public String qDate2dateString(QDate date)
	{
		return Integer.toString(date.year()) + "-"
		+ Integer.toString(date.month()) + "-"
		+ Integer.toString(date.day());
	}

}