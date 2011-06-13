import java.util.List;

import com.trolltech.qt.gui.*;

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
        ui.treeWidget.setCurrentItem(null);
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
}