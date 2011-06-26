


import com.trolltech.qt.gui.*;

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
			String literature = author + ", " + title + ", " + year;
			this.close();
			mDImpl.ui.listWidget_Literature.addItem(literature);
		}
	}
}
