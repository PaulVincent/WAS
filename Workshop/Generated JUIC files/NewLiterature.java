/********************************************************************************
** Form generated from reading ui file 'NewLiterature.jui'
**
** Created: Mo 17. Okt 17:51:15 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class NewLiterature implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGridLayout gridLayout;
    public QLabel label_Title;
    public QLineEdit lineEdit_Title;
    public QLabel label_Author;
    public QLineEdit lineEdit_Author;
    public QLabel label_Year;
    public QLineEdit lineEdit_Year;
    public QPushButton cancelButton;
    public QPushButton saveLiteratureButton;

    public NewLiterature() { super(); }

    public void setupUi(QDialog NewLiterature)
    {
        NewLiterature.setObjectName("NewLiterature");
        NewLiterature.resize(new QSize(266, 154).expandedTo(NewLiterature.minimumSizeHint()));
        NewLiterature.setMinimumSize(new QSize(266, 154));
        NewLiterature.setModal(true);
        gridLayout = new QGridLayout(NewLiterature);
        gridLayout.setObjectName("gridLayout");
        label_Title = new QLabel(NewLiterature);
        label_Title.setObjectName("label_Title");
        label_Title.setMinimumSize(new QSize(20, 25));
        label_Title.setMaximumSize(new QSize(20, 25));

        gridLayout.addWidget(label_Title, 0, 0, 1, 1);

        lineEdit_Title = new QLineEdit(NewLiterature);
        lineEdit_Title.setObjectName("lineEdit_Title");
        lineEdit_Title.setMinimumSize(new QSize(0, 25));

        gridLayout.addWidget(lineEdit_Title, 0, 1, 1, 2);

        label_Author = new QLabel(NewLiterature);
        label_Author.setObjectName("label_Author");
        label_Author.setMinimumSize(new QSize(33, 25));
        label_Author.setMaximumSize(new QSize(33, 25));

        gridLayout.addWidget(label_Author, 1, 0, 1, 1);

        lineEdit_Author = new QLineEdit(NewLiterature);
        lineEdit_Author.setObjectName("lineEdit_Author");
        lineEdit_Author.setMinimumSize(new QSize(0, 25));

        gridLayout.addWidget(lineEdit_Author, 1, 1, 1, 1);

        label_Year = new QLabel(NewLiterature);
        label_Year.setObjectName("label_Year");
        label_Year.setMinimumSize(new QSize(21, 25));
        label_Year.setMaximumSize(new QSize(21, 25));

        gridLayout.addWidget(label_Year, 2, 0, 1, 1);

        lineEdit_Year = new QLineEdit(NewLiterature);
        lineEdit_Year.setObjectName("lineEdit_Year");
        lineEdit_Year.setMinimumSize(new QSize(61, 25));
        lineEdit_Year.setMaximumSize(new QSize(61, 25));

        gridLayout.addWidget(lineEdit_Year, 2, 1, 1, 1);

        cancelButton = new QPushButton(NewLiterature);
        cancelButton.setObjectName("cancelButton");
        cancelButton.setMinimumSize(new QSize(81, 0));
        cancelButton.setMaximumSize(new QSize(81, 16777215));

        gridLayout.addWidget(cancelButton, 3, 1, 1, 1);

        saveLiteratureButton = new QPushButton(NewLiterature);
        saveLiteratureButton.setObjectName("saveLiteratureButton");
        saveLiteratureButton.setMinimumSize(new QSize(81, 25));
        saveLiteratureButton.setMaximumSize(new QSize(81, 25));

        gridLayout.addWidget(saveLiteratureButton, 3, 2, 1, 1);

        retranslateUi(NewLiterature);

        NewLiterature.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog NewLiterature)
    {
        NewLiterature.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("NewLiterature", "New Literature", null));
        label_Title.setText(com.trolltech.qt.core.QCoreApplication.translate("NewLiterature", "Title", null));
        label_Author.setText(com.trolltech.qt.core.QCoreApplication.translate("NewLiterature", "Author", null));
        label_Year.setText(com.trolltech.qt.core.QCoreApplication.translate("NewLiterature", "Year", null));
        cancelButton.setText(com.trolltech.qt.core.QCoreApplication.translate("NewLiterature", "Cancel", null));
        saveLiteratureButton.setText(com.trolltech.qt.core.QCoreApplication.translate("NewLiterature", "save", null));
    } // retranslateUi

}

