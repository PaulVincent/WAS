

import java.util.ArrayList;

import CONTROLLER.WorkshopController;

import com.trolltech.qt.core.Qt.SortOrder;
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
		
		init();
	}

	public void on_addRealPartButton_clicked() {
		
		ui.treeWidget.setCurrentItem(null);
		partID = -1;
		PaticipantInfoImpl testParticipantsInfoImpl = new PaticipantInfoImpl(this);
		testParticipantsInfoImpl.show();
	}

	public void on_deleteRealPartButton_clicked() {
		
		
		QTreeWidgetItem item = ui.treeWidget.currentItem();
		String strID = (String) item.data(0, 0);
		WorkshopController.deleteParticipant(Integer.parseInt(strID));
		
		init();
		
	}

	public void on_treeWidget_itemDoubleClicked()
	{
		QTreeWidgetItem item = ui.treeWidget.currentItem();
		String ID = (String) item.data(0, 0);
		partID = Integer.parseInt(ID);
		
		ArrayList<String> participantData = WorkshopController.loadParticipant(partID);
		
		PaticipantInfoImpl testParticipantsInfoImpl = new PaticipantInfoImpl(this);
		testParticipantsInfoImpl.part2PID(participantData);
		testParticipantsInfoImpl.show();

	}

	public void setAdditionalLayoutOptions()
	{
		int width = 70;
		int widthID = 45;
		ui.treeWidget.setColumnWidth(0, widthID);
		ui.treeWidget.setColumnWidth(4, width);
		ui.treeWidget.setColumnWidth(3, 110);
	}

	public void init() {
		partID = -1;
		ui.treeWidget.clear();
		SortOrder order = SortOrder.AscendingOrder;
		ui.treeWidget.sortByColumn(0, order);
		ui.treeWidget.setCurrentItem(null);
		ui.treeWidget.addTopLevelItems(WorkshopController.initWSParticipants(mDImpl.workShopID));
	}
	
	public ArrayList<String> getParticipantFromPD()
	{
		ArrayList<String> data = new ArrayList<String>();
		QTreeWidgetItem item = ui.treeWidget.currentItem();
    	if (item == null || item.data(0,0).toString().equals(""))
    	{
    		return null;    		
    	}
    	else
    	{
    		for (int i = 0; i < 6; i++)
    		{
    			data.add((String) item.data(i,0));
    		}    		
        	return data;
    	}		
	}

	public void on_OKButton_clicked()
	{
		if (ui.treeWidget.currentIndex() != null) {
			QTreeWidgetItem item = ui.treeWidget.currentItem();
			partID = Integer.parseInt((String) item.data(0, 0));
			
			ArrayList<String> participantData = WorkshopController.loadParticipant(partID);
			
			PaticipantInfoImpl testParticipantsInfoImpl = new PaticipantInfoImpl(this);
			testParticipantsInfoImpl.part2PID(participantData);
			testParticipantsInfoImpl.show();
		}
	}
}
