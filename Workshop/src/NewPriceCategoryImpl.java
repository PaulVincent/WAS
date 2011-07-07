



import Controller.WorkshopController;

import com.trolltech.qt.gui.*;

public class NewPriceCategoryImpl extends QDialog {

    NewPriceCategory ui = new NewPriceCategory();
    PriceCategoriesImpl pCImpl = null;

    public static void main(String[] args) {
        QApplication.initialize(args);

        NewPriceCategoryImpl testNewPriceCategoryImpl = new NewPriceCategoryImpl();
        testNewPriceCategoryImpl.show();

        QApplication.exec();
    }

    public NewPriceCategoryImpl() {
        ui.setupUi(this);
    }

    public NewPriceCategoryImpl(QWidget parent) {
        super(parent);
        ui.setupUi(this);
    }
    
    public NewPriceCategoryImpl(PriceCategoriesImpl pCImpl) {
        ui.setupUi(this);
        this.pCImpl = pCImpl;
    }
    
    public void on_saveButton_clicked(){
    	String timeStr = getPriceCatFromNPCD();
    	WorkshopController.newTimeIntervall(timeStr);
    		
    	pCImpl.ui.treeWidget.clear();
    	pCImpl.init();    	
    }
    
    public String getPriceCatFromNPCD(){
    	
		String priceCategory = Integer.toString(pCImpl.mDImpl.workShopID) + "', '"
		+ ui.lineEdit_Category.text() + "', '"
		+ ui.lineEdit_Price.text();
		
		return priceCategory;
    }
    
    
}
