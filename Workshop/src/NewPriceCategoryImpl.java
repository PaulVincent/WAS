

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
    
    
}
