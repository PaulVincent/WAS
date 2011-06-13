import com.trolltech.qt.gui.*;

public class TimeIntervalDialogImpl extends QDialog {

    TimeIntervalDialog ui = new TimeIntervalDialog();
    ScheduleImpl sImpl = null;

    public static void main(String[] args) {
        QApplication.initialize(args);

        TimeIntervalDialogImpl testTimeIntervalDialogImpl = new TimeIntervalDialogImpl();
        testTimeIntervalDialogImpl.show();

        QApplication.exec();
    }

    public TimeIntervalDialogImpl() {
        ui.setupUi(this);
    }

    public TimeIntervalDialogImpl(QWidget parent) {
        super(parent);
        ui.setupUi(this);
    }
    
    public TimeIntervalDialogImpl(ScheduleImpl sImpl) {
        ui.setupUi(this);
        this.sImpl = sImpl;
    }
    
    public void on_saveTimeIntervalButton_clicked()
    {
    	if (sImpl.ui.treeWidget.currentItem() == null)
    	{
//    		add new time interval to database if possible
//        	reload schedule from database and write into Schedule GUI
    		sImpl.ui.treeWidget.clear();
    	}
    	else
    	{
    		QTreeWidgetItem item = sImpl.ui.treeWidget.currentItem();
        	String str_ID = (String) item.data(0, 0);
        	int ID = Integer.parseInt(str_ID);
        	System.out.println(ID);
//        	update current timeinterval in database
        	sImpl.ui.treeWidget.clear();
//        	reload schedule from database and write into Schedule GUI
    	}
    	System.out.println(sImpl.mDImpl.workShopID);
    }
}
