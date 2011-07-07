
import java.util.ArrayList;

import Controller.WorkshopController;

import com.trolltech.qt.core.Qt.SortOrder;
import com.trolltech.qt.gui.*;

public class PriceCategoriesImpl extends QDialog {

    PriceCategories ui = new PriceCategories();
    int priceCatID = -1;
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
    
//    public void on_treeWidget_itemDoubleClicked()
//    {
//    	QTreeWidgetItem item = ui.treeWidget.currentItem();
//		String ID = (String) item.data(0, 0);
//		priceCatID = Integer.parseInt(ID);
//
//		ArrayList<String> participantData = WorkshopController
//				.loadParticipant(partID);
//
//		PaticipantInfoImpl testParticipantsInfoImpl = new PaticipantInfoImpl(
//				this);
//		testParticipantsInfoImpl.part2PID(participantData);
//		testParticipantsInfoImpl.show();
//    	
//    	NewPriceCategoryImpl nPCImpl = new NewPriceCategoryImpl(this);
//    	nPCImpl.show();
//    }
    
    public void init(){
    	ui.treeWidget.setCurrentItem(null);
		ui.treeWidget.addTopLevelItems(WorkshopController.initPriceCategories(mDImpl.workShopID));
		SortOrder order = SortOrder.AscendingOrder;
		ui.treeWidget.sortByColumn(0, order);
    }
}
