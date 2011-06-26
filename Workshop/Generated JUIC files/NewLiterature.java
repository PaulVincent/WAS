/********************************************************************************
** Form generated from reading ui file 'NewLiterature.jui'
**
** Created: So 26. Jun 11:37:17 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class NewLiterature implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDialogButtonBox buttonBox;
    public QLineEdit lineEdit_Title;
    public QLineEdit lineEdit_Author;
    public QLineEdit lineEdit_Year;
    public QLabel label_Title;
    public QLabel label_Author;
    public QLabel label_Year;
    public QPushButton saveLiteratureButton;

    public NewLiterature() { super(); }

    public void setupUi(QDialog NewLiterature)
    {
        NewLiterature.setObjectName("NewLiterature");
        NewLiterature.resize(new QSize(221, 121).expandedTo(NewLiterature.minimumSizeHint()));
        NewLiterature.setModal(true);
        buttonBox = new QDialogButtonBox(NewLiterature);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(10, 90, 131, 20));
        buttonBox.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.TabFocus);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));
        lineEdit_Title = new QLineEdit(NewLiterature);
        lineEdit_Title.setObjectName("lineEdit_Title");
        lineEdit_Title.setGeometry(new QRect(50, 10, 161, 20));
        lineEdit_Author = new QLineEdit(NewLiterature);
        lineEdit_Author.setObjectName("lineEdit_Author");
        lineEdit_Author.setGeometry(new QRect(50, 35, 161, 20));
        lineEdit_Year = new QLineEdit(NewLiterature);
        lineEdit_Year.setObjectName("lineEdit_Year");
        lineEdit_Year.setGeometry(new QRect(50, 60, 61, 20));
        label_Title = new QLabel(NewLiterature);
        label_Title.setObjectName("label_Title");
        label_Title.setGeometry(new QRect(10, 10, 20, 20));
        label_Author = new QLabel(NewLiterature);
        label_Author.setObjectName("label_Author");
        label_Author.setGeometry(new QRect(10, 35, 33, 20));
        label_Year = new QLabel(NewLiterature);
        label_Year.setObjectName("label_Year");
        label_Year.setGeometry(new QRect(10, 60, 21, 20));
        saveLiteratureButton = new QPushButton(NewLiterature);
        saveLiteratureButton.setObjectName("saveLiteratureButton");
        saveLiteratureButton.setGeometry(new QRect(150, 90, 61, 20));
        retranslateUi(NewLiterature);
        buttonBox.clicked.connect(NewLiterature, "close()");

        NewLiterature.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog NewLiterature)
    {
        NewLiterature.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("NewLiterature", "New Literature", null));
        label_Title.setText(com.trolltech.qt.core.QCoreApplication.translate("NewLiterature", "Title", null));
        label_Author.setText(com.trolltech.qt.core.QCoreApplication.translate("NewLiterature", "Author", null));
        label_Year.setText(com.trolltech.qt.core.QCoreApplication.translate("NewLiterature", "Year", null));
        saveLiteratureButton.setText(com.trolltech.qt.core.QCoreApplication.translate("NewLiterature", "save", null));
    } // retranslateUi

}

