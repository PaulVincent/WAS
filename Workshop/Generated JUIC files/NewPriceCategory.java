/********************************************************************************
** Form generated from reading ui file 'NewPriceCategory.jui'
**
** Created: Do 7. Jul 20:01:10 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class NewPriceCategory implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDialogButtonBox buttonBox;
    public QLabel label_Price;
    public QLabel label_Category;
    public QLineEdit lineEdit_Category;
    public QLineEdit lineEdit_Price;
    public QPushButton saveButton;
    public QPushButton clearButton;

    public NewPriceCategory() { super(); }

    public void setupUi(QDialog NewPriceCategory)
    {
        NewPriceCategory.setObjectName("NewPriceCategory");
        NewPriceCategory.resize(new QSize(331, 102).expandedTo(NewPriceCategory.minimumSizeHint()));
        NewPriceCategory.setMinimumSize(new QSize(331, 102));
        NewPriceCategory.setMaximumSize(new QSize(331, 102));
        NewPriceCategory.setWindowIcon(new QIcon(new QPixmap("logo_gik.png")));
        NewPriceCategory.setModal(true);
        buttonBox = new QDialogButtonBox(NewPriceCategory);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(10, 60, 151, 25));
        buttonBox.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.TabFocus);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));
        label_Price = new QLabel(NewPriceCategory);
        label_Price.setObjectName("label_Price");
        label_Price.setGeometry(new QRect(175, 6, 23, 25));
        label_Category = new QLabel(NewPriceCategory);
        label_Category.setObjectName("label_Category");
        label_Category.setGeometry(new QRect(10, 6, 61, 25));
        lineEdit_Category = new QLineEdit(NewPriceCategory);
        lineEdit_Category.setObjectName("lineEdit_Category");
        lineEdit_Category.setGeometry(new QRect(10, 31, 151, 25));
        lineEdit_Price = new QLineEdit(NewPriceCategory);
        lineEdit_Price.setObjectName("lineEdit_Price");
        lineEdit_Price.setGeometry(new QRect(175, 31, 71, 25));
        saveButton = new QPushButton(NewPriceCategory);
        saveButton.setObjectName("saveButton");
        saveButton.setGeometry(new QRect(175, 60, 71, 25));
        clearButton = new QPushButton(NewPriceCategory);
        clearButton.setObjectName("clearButton");
        clearButton.setGeometry(new QRect(250, 60, 71, 25));
        retranslateUi(NewPriceCategory);
        buttonBox.clicked.connect(NewPriceCategory, "close()");

        NewPriceCategory.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog NewPriceCategory)
    {
        NewPriceCategory.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("NewPriceCategory", "New Price Category", null));
        label_Price.setText(com.trolltech.qt.core.QCoreApplication.translate("NewPriceCategory", "Price", null));
        label_Category.setText(com.trolltech.qt.core.QCoreApplication.translate("NewPriceCategory", "Category", null));
        saveButton.setText(com.trolltech.qt.core.QCoreApplication.translate("NewPriceCategory", "save", null));
        clearButton.setText(com.trolltech.qt.core.QCoreApplication.translate("NewPriceCategory", "clear", null));
    } // retranslateUi

}

