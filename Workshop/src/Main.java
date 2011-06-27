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
		
//		QDate date = new QDate();
//		date.setDate(2011, 6, 11);
//		Date javaDate = new Date(0);
//		date.setJavaOwnership();
//		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.PRC);
//		
//		System.out.println(date.year()+"-"+date.month()+"-"+date.day());
		
		

	}

}
