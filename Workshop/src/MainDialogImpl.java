import javax.swing.JFrame;

import Controller.DBConnection;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QFrame;
import com.trolltech.qt.gui.QWidget;

public class MainDialogImpl extends QDialog {

	MainDialog ui = new MainDialog();
	int workShopID = -1;

    public static void main(String[] args) {
        QApplication.initialize(args);

        MainDialogImpl testMainDialogImpl = new MainDialogImpl();
        testMainDialogImpl.init();
        testMainDialogImpl.show();

        QApplication.exec();
    }

    public MainDialogImpl() {
        ui.setupUi(this);
        ui.line_Vertical.setFrameShape(QFrame.Shape.VLine);
    }

    public MainDialogImpl(QWidget parent) {
        super(parent);
        ui.setupUi(this);
    }
    
    public void on_editshowPartButton_clicked()
    {
    	ParticipantsDialogImpl pDpImpl = new ParticipantsDialogImpl(this);
    	pDpImpl.show();
    }   
    
    public void on_detailsButton_clicked()
    {
    	ScheduleImpl sImpl = new ScheduleImpl(this);
    	sImpl.show();
//    	System.out.println("Not implemented yet!");

//    	detailsButton clicked
    }
    
    public void on_addPlaceButton_clicked()
    {
    	NotImplYet();
    	System.out.println("Not implemented yet!");

//    	addPlaceButton clicked

    }
    
    public void on_addPriceButton_clicked()
    {
    	NotImplYet();
    	System.out.println("Not implemented yet!");

//    	addPriceButton clicked

    }
    
    public void on_deleteCourseButton_clicked()
    {
    	WorkshopControler.deleteWorkShop(workShopID);
    	NotImplYet();
    	System.out.println("Not implemented yet!");
//    	delete current course from database
    	resetUI();
//    	deleteCourseButton clicked
    }
    
    public void on_loadCourseButton_clicked()
    {
    	WorkshopsImpl testWorkshopsImpl = new WorkshopsImpl(this);
    	testWorkshopsImpl.show();
    	
    }
    
    public void on_saveCourseButton_clicked()
    {
    	int id = 0;
    	
    	if (workShopID == -1)
    	{    		
			id = WorkshopControler.newWorkShop(this);
		
    	}
    	else{
//        	get current WS ID that was set by loading an existing course
//        	overwrite course in database and reload data into main dialog
    		NotImplYet();
        	System.out.println("Not implemented yet!");
    		id = workShopID;
    	}
    	WorkshopControler.ws2MainDialog(id, this);
    	setToEditingWorkShop(id);
    }
    
    public void on_clearCourseButton_clicked()
    {
    	resetUI();
    }
    
    public void on_comboBox_Price_currentStringChanged()
    {
//    	String str = ui.comboBox_Price.currentText();
    	
//    	get price texts from database and related prices
    	
//    	if (str.equals("reduced"))
//    	{
//    		ui.lineEdit_Price.setText("30");
//    	}
//    	
//    	else if (str.equals("normal"))
//    	{
//    		ui.lineEdit_Price.setText("40");
//    	}
    }
    
    public void on_generateHTMLButton_clicked()
    {
    	NotImplYet();
    	System.out.println("Not implemented yet!");
//    	GenerateHTMLButton clicked
    }
    
    public void on_editshowPriceButton_clicked()

    {
    	PriceCategoriesImpl pCImpl = new PriceCategoriesImpl(this);
    	pCImpl.show();
    }

    public void on_addLiteratureButton_clicked()
    {
//    	NotImplYet();
    	NewLiteratureImpl nLImpl = new NewLiteratureImpl(this);
    	nLImpl.show();
    	
    }
    
    public void on_deleteLiteratureButton_clicked()
    {
    	NotImplYet();
    }
    
    public void resetUI()
    {
    	workShopID = -1;
    	ui.deleteCourseButton.setEnabled(false);
    	ui.generateHTMLButton.setEnabled(false);
    	ui.listWidget_Literature.clear();
    	ui.comboBox_Price.clear();
    	ui.lineEdit_dateStart.clear();
        ui.lineEdit_dateEnd.clear();
        ui.lineEdit_Duration.clear();
        ui.lineEdit_Part.clear();
        ui.lineEdit_Prof.clear();
        ui.lineEdit_Titel.clear();
        ui.textEdit_Description.clear();
        ui.lineEdit_Price.clear();
    }
    
    public void setToEditingWorkShop(int id)
    {
    	workShopID = id;
    	ui.deleteCourseButton.setEnabled(true);
    	ui.generateHTMLButton.setEnabled(true);
    	ui.comboBox_Price.setEnabled(true);
    }
    
    public void NotImplYet()
    {
    	JFrame frame;
    	frame = new JFrame("Show Message Dialog");
    	frame.setSize(400, 400);
    	frame.setVisible(false);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	frame.hide();
    	javax.swing.JOptionPane.showMessageDialog(frame,"Not implemented yet!");
    	
    }
    
    public void init() {
    	DBConnection.connectToDB();
      }
}
