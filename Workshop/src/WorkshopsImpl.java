import java.util.ArrayList;

import CONTROLLER.WorkshopController;

import com.trolltech.qt.core.Qt.SortOrder;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QTreeWidgetItem;
import com.trolltech.qt.gui.QWidget;

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

		int widthID = 35;
		int widthTitle = 230;
		ui.treeWidget.setColumnWidth(0, widthID);
		ui.treeWidget.setColumnWidth(1, widthTitle);
		ui.treeWidget.setColumnWidth(3, 75);
		ui.treeWidget.setColumnWidth(4, widthID * 2);

		init();
	}

	public void on_okButton_clicked() {
		if (ui.treeWidget.currentIndex() != null) {
			mDImpl.resetUI();
			QTreeWidgetItem item = ui.treeWidget.currentItem();
			int id = Integer.parseInt((String) item.data(0, 0));
			
			ArrayList<String> workshopData = WorkshopController.loadWorkshop(id);
			mDImpl.workShop2MainDialog(workshopData);
			mDImpl.setToEditingWorkShop(id);
		}
		this.close();
	}

	public void on_treeWidget_itemDoubleClicked() {
		mDImpl.resetUI();
		QTreeWidgetItem item = ui.treeWidget.currentItem();
		int id = Integer.parseInt((String) item.data(0, 0));
		ArrayList<String> workshopData = WorkshopController.loadWorkshop(id);
		mDImpl.workShop2MainDialog(workshopData);
		mDImpl.setToEditingWorkShop(id);
		this.close();
	}

	public void init() {
		SortOrder order = SortOrder.DescendingOrder;
		ui.treeWidget.sortByColumn(0, order);
		ui.treeWidget.setCurrentItem(null);
		ui.treeWidget.addTopLevelItems(WorkshopController.initWorkShops());
	}

}
