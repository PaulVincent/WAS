
import java.util.ArrayList;

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
    	pCImpl.mDImpl.NotImplYet();
//    	ArrayList<String> priceCategoryData = getPriceCatFromNPCD();
//    	WorkshopController.newPriceCategory(priceCategoryData);
//    		
//    	pCImpl.ui.treeWidget.clear();
//    	pCImpl.init();    	
    }
    
    public ArrayList<String> getPriceCatFromNPCD(){
    	ArrayList<String> priceCategoryData = new ArrayList<String>();
    	
    	priceCategoryData.add(Integer.toString(pCImpl.mDImpl.workShopID));
    	priceCategoryData.add(ui.lineEdit_Category.text());
    	priceCategoryData.add(ui.lineEdit_Price.text());
    	
//		String priceCategory = Integer.toString(pCImpl.mDImpl.workShopID) + "', '"
//		+ ui.lineEdit_Category.text() + "', '"
//		+ ui.lineEdit_Price.text();
		
		return priceCategoryData;
    }
        
}
