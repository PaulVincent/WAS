import com.trolltech.qt.gui.QApplication;


public class Main 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		QApplication.initialize(args);
		
		MainDialogImpl mainDialog = new MainDialogImpl();
		mainDialog.init();
		mainDialog.show();
		
		QApplication.exec();

	}

}
