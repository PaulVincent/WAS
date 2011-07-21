

import java.util.ArrayList;

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
    	ArrayList<String> timeIntervallData = getTimeFromTID();
    	
    	WorkshopController.newTimeIntervall(timeIntervallData);
			
		sImpl.ui.treeWidget.clear();
		sImpl.init();
		
		int hours = WorkshopController.getDuration(sImpl.mDImpl.workShopID);
		sImpl.mDImpl.setDuration(hours);
    }

	public ArrayList<String> getTimeFromTID()
	{
		ArrayList<String> timeIntervallData = new ArrayList<String>();
		String dateString = WorkshopController.qDate2dateString(ui.dateEdit.date());
		
		timeIntervallData.add(Integer.toString(sImpl.mDImpl.workShopID));
		timeIntervallData.add(dateString);
		timeIntervallData.add(ui.timeEdit_Start.text() + "-" +ui.timeEdit_End.text());
		
//		String timeIntervall = Integer.toString(sImpl.mDImpl.workShopID) + "', '"
//		+ dateString + "', '"
//		+ ui.timeEdit_Start.text() + "-" +ui.timeEdit_End.text();
		
		return timeIntervallData;
	}
    
    public void on_timeEdit_Start_timeChanged() {
		QTime min = ui.timeEdit_Start.time();
		ui.timeEdit_End.setMinimumTime(min);
	}
    
    public void timeInt2TID(ArrayList<String> timeIntervallData){
    	ui.dateEdit.setDate(WorkshopController.dateString2QDate(timeIntervallData.get(0)));
    	ui.timeEdit_Start.setTime(WorkshopController.timeString2QTime(timeIntervallData.get(1)));
    	ui.timeEdit_End.setTime(WorkshopController.timeString2QTime(timeIntervallData.get(2)));
    }
    
    public void init()
    {
    	ui.dateEdit.setMinimumDate(sImpl.mDImpl.ui.dateEdit_Start.date());
    	ui.dateEdit.setMaximumDate(sImpl.mDImpl.ui.dateEdit_End.date());
    }
}
