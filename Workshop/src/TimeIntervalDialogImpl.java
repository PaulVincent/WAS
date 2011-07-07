

import Controller.WorkshopController;

import com.trolltech.qt.core.QTime;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QWidget;

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
        
        init();
    }
    
    public void on_saveTimeIntervalButton_clicked()
    {    
    	String timeStr = getTimeFromTID();
		WorkshopController.newTimeIntervall(timeStr);
			
		sImpl.ui.treeWidget.clear();
		sImpl.init();
		
		int hours = WorkshopController.getDuration(sImpl.mDImpl.workShopID);
		sImpl.mDImpl.setDuration(hours);
    }

	public String getTimeFromTID()
	{
		String dateString = WorkshopController.qDate2dateString(ui.dateEdit.date());
		
		String timeIntervall = Integer.toString(sImpl.mDImpl.workShopID) + "', '"
		+ dateString + "', '"
		+ ui.timeEdit_Start.text() + "-" +ui.timeEdit_End.text();
		
		return timeIntervall;
	}
    
    public void on_timeEdit_Start_timeChanged() {
		QTime min = ui.timeEdit_Start.time();
		ui.timeEdit_End.setMinimumTime(min);
	}
    
    public void init()
    {
    	ui.dateEdit.setMinimumDate(sImpl.mDImpl.ui.dateEdit_Start.date());
    	ui.dateEdit.setMaximumDate(sImpl.mDImpl.ui.dateEdit_End.date());
    }
}
