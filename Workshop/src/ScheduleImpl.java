import java.util.ArrayList;

import Controller.WorkshopController;

import com.trolltech.qt.core.Qt.SortOrder;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QTreeWidgetItem;
import com.trolltech.qt.gui.QWidget;

public class ScheduleImpl extends QDialog {

    Schedule ui = new Schedule();
    int timeID = -1;
    MainDialogImpl mDImpl = null;
    

    public static void main(String[] args) {
        QApplication.initialize(args);

        ScheduleImpl testScheduleImpl = new ScheduleImpl();
        testScheduleImpl.show();

        QApplication.exec();
    }

    public ScheduleImpl() {
        ui.setupUi(this);
    }

    public ScheduleImpl(QWidget parent) {
        super(parent);
        ui.setupUi(this);
    }
    
    public ScheduleImpl(MainDialogImpl mDImpl) {
        ui.setupUi(this);
        this.mDImpl = mDImpl;
        init();
    }
    
    public void on_addTimeIntervalButton_clicked()
    {
    	ui.treeWidget.setCurrentItem(null);
    	TimeIntervalDialogImpl tIDImpl = new TimeIntervalDialogImpl(this);
    	tIDImpl.show();
//    	System.out.println(ui.treeWidget.);
    }
    
    public void on_deleteTimeIntervalButton_clicked()
    {
    	if (ui.treeWidget.currentItem() != null) {
			QTreeWidgetItem item = ui.treeWidget.currentItem();
			System.out.println((String) item.data(1, 0) + "-" + (String) item.data(2, 0));
//			String dateString = WorkshopController.qDate2dateString(ui.dateEdit.date());
			ArrayList<String> timeIntervall = new ArrayList<String>();
			timeIntervall.add((String) item.data(0, 0));
			timeIntervall.add((String) item.data(1, 0) + "-" + (String) item.data(2, 0));	
			
			WorkshopController.deleteTimeIntervall(timeIntervall, mDImpl.workShopID);
			
			init();
			int hours = WorkshopController.getDuration(mDImpl.workShopID);
			mDImpl.setDuration(hours);
		}
//    	Chosen time interval delete from database if possible
//    	clear treewidget and reload ???
    }
    
    public void on_treeWidget_itemDoubleClicked()
    {
//    	setze timeIntervalID auf ID des geklickten timeintervals
    	TimeIntervalDialogImpl tIDImpl = new TimeIntervalDialogImpl(this);
    	tIDImpl.show();
    	
//    	get id of current time interval and load data from database
//    	and fill the timeinterval GUI and set timeID
//    	List <QTreeWidgetItem> items = ui.treeWidget.selectedItems();
//    	
//    	for (QTreeWidgetItem item : items)
//    	{
//    		item.
//    	}
//    	
    	
    }

    public void init()
    {
    	ui.treeWidget.clear();
    	ui.treeWidget.setCurrentItem(null);
    	ui.treeWidget.addTopLevelItems(WorkshopController.initSchedule(mDImpl.workShopID));
    	SortOrder order = SortOrder.AscendingOrder;
		ui.treeWidget.sortByColumn(0, order);
    }
}