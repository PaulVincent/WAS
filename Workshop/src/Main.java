import java.util.ArrayList;

import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QPlastiqueStyle;
import com.trolltech.qt.gui.QWindowsStyle;


public class Main 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		QApplication.initialize(args);
		
		QApplication.setStyle(new QPlastiqueStyle());
	
		MainDialogImpl mainDialog = new MainDialogImpl();
		mainDialog.init();
		mainDialog.show();
		
		QApplication.exec();
		
	}

}
