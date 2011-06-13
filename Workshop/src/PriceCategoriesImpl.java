

import com.trolltech.qt.gui.*;

public class PriceCategoriesImpl extends QDialog {

    PriceCategories ui = new PriceCategories();
    MainDialogImpl mDImpl = null;

    public static void main(String[] args) {
        QApplication.initialize(args);

        PriceCategoriesImpl testPriceCategoriesImpl = new PriceCategoriesImpl();
        testPriceCategoriesImpl.show();

        QApplication.exec();
    }

    public PriceCategoriesImpl() {
        ui.setupUi(this);
    }

    public PriceCategoriesImpl(QWidget parent) {
        super(parent);
        ui.setupUi(this);
    }
    
    public PriceCategoriesImpl(MainDialogImpl mDImpl) {
        ui.setupUi(this);
        this.mDImpl = mDImpl;
        
        int widthCategory = 80;
        int widthPrice = 40;
        ui.treeWidget.setColumnWidth(0, widthCategory);
        ui.treeWidget.setColumnWidth(1, widthPrice);
        
		ui.treeWidget.setCurrentItem(null);
    }
    
    public void on_addCategoryButton_clicked()
    {
    	ui.treeWidget.setCurrentItem(null);
    	NewPriceCategoryImpl nPCImpl = new NewPriceCategoryImpl(this);
    	nPCImpl.show();
    }
}
