

import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.*;


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
    
    public void on_savePartButton_clicked()

    {
    	if (pDImpl.partID != -1)
    	{
//    		get infos from dialog and add new participant to workshop
//    		with ID pDImpl.mDImpl.workShopID;
    	}
    	else 
    	{
//    		get infos from dialog and change participant infos of
//    		participant with ID pDImpl.partID;
		}
    	
    	pDImpl.ui.treeWidget.clear();
    	
    }

    public void on_clearPartButton_clicked()
    {
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
}