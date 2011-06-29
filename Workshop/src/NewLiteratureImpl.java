import CONTROLLER.WorkshopController;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QWidget;

public class NewLiteratureImpl extends QDialog {

	NewLiterature ui = new NewLiterature();
	MainDialogImpl mDImpl = null;

	public static void main(String[] args) {
		QApplication.initialize(args);

		NewLiteratureImpl testNewLiteratureImpl = new NewLiteratureImpl();
		testNewLiteratureImpl.show();

		QApplication.exec();
	}

	public NewLiteratureImpl() {
		ui.setupUi(this);
	}

	public NewLiteratureImpl(QWidget parent) {
		super(parent);
		ui.setupUi(this);
	}

	public NewLiteratureImpl(MainDialogImpl mDImpl) {

		ui.setupUi(this);
		this.mDImpl = mDImpl;
	}

	public void on_saveLiteratureButton_clicked() {
		
		if (!ui.lineEdit_Author.text().isEmpty()
				&& !ui.lineEdit_Title.text().isEmpty()
				&& !ui.lineEdit_Year.text().isEmpty()) {
			String author = ui.lineEdit_Author.text();
			String title = ui.lineEdit_Title.text();
			String year = ui.lineEdit_Year.text();
			String literature = title + ", " + author + ", " + year + ";";
			this.close();
			literature = WorkshopController.newLiterature(literature,
					mDImpl.workShopID);
			mDImpl.literature2MainDialog(literature);
		}

	}

}
