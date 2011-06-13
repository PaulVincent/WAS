

import com.trolltech.qt.core.QModelIndex;
import com.trolltech.qt.gui.*;

public class WorkshopsImpl extends QDialog {

    Workshops ui = new Workshops();
    MainDialogImpl mDImpl = null;
    
    public static void main(String[] args) {
        QApplication.initialize(args);

        WorkshopsImpl testWorkshopsImpl = new WorkshopsImpl();
        testWorkshopsImpl.show();

        QApplication.exec();
    }

    public WorkshopsImpl() {
        ui.setupUi(this);
    }

    public WorkshopsImpl(QWidget parent) {
        super(parent);
        ui.setupUi(this);
    }
    
    public WorkshopsImpl(MainDialogImpl mDImpl) {
        ui.setupUi(this);
       
        this.mDImpl = mDImpl;
        
        int widthID = 25;
        int widthTitle = 180;
		ui.treeWidget.setColumnWidth(0, widthID);
		ui.treeWidget.setColumnWidth(1, widthTitle);
		ui.treeWidget.setColumnWidth(4, widthID*2);
		ui.treeWidget.setCurrentItem(null);
    }
    
    public void on_okButton_clicked()
    {
    	
    	if (ui.treeWidget.currentIndex() == null)
    	{
    		this.close();
    	}
    	else
    	{
//    		get ID of current workshop and write info from database to MainDialog
//    		and set mDImpl = ID of workshop
    		setToEditingWorkShop();
        	this.close();
    	}	
    }
    
    public void on_treeWidget_itemDoubleClicked()
    {
//    	get ID of current workshop and write info from database to MainDialog
//    	and set mDImpl.workshopID = ID of workshop
		setToEditingWorkShop();
    	this.close();
    }
    
    public void setToEditingWorkShop()
    {
    	mDImpl.setToEditingWorkShop();
    }
}
