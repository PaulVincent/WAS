/********************************************************************************
** Form generated from reading ui file 'NewPriceCategory.jui'
**
** Created: So 26. Jun 11:37:17 2011
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
        NewPriceCategory.resize(new QSize(297, 95).expandedTo(NewPriceCategory.minimumSizeHint()));
        NewPriceCategory.setWindowIcon(new QIcon(new QPixmap("logo_gik.png")));
        NewPriceCategory.setModal(true);
        buttonBox = new QDialogButtonBox(NewPriceCategory);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(10, 60, 131, 20));
        buttonBox.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.TabFocus);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));
        label_Price = new QLabel(NewPriceCategory);
        label_Price.setObjectName("label_Price");
        label_Price.setGeometry(new QRect(155, 6, 23, 16));
        label_Category = new QLabel(NewPriceCategory);
        label_Category.setObjectName("label_Category");
        label_Category.setGeometry(new QRect(10, 6, 43, 16));
        lineEdit_Category = new QLineEdit(NewPriceCategory);
        lineEdit_Category.setObjectName("lineEdit_Category");
        lineEdit_Category.setGeometry(new QRect(10, 31, 133, 20));
        lineEdit_Price = new QLineEdit(NewPriceCategory);
        lineEdit_Price.setObjectName("lineEdit_Price");
        lineEdit_Price.setGeometry(new QRect(155, 31, 133, 20));
        saveButton = new QPushButton(NewPriceCategory);
        saveButton.setObjectName("saveButton");
        saveButton.setGeometry(new QRect(160, 60, 55, 20));
        clearButton = new QPushButton(NewPriceCategory);
        clearButton.setObjectName("clearButton");
        clearButton.setGeometry(new QRect(230, 60, 55, 20));
        retranslateUi(NewPriceCategory);
        buttonBox.clicked.connect(NewPriceCategory, "close()");

        NewPriceCategory.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog NewPriceCategory)
    {
        NewPriceCategory.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("NewPriceCategory", "New Price Category", null));
        label_Price.setText(com.trolltech.qt.core.QCoreApplication.translate("NewPriceCategory", "price", null));
        label_Category.setText(com.trolltech.qt.core.QCoreApplication.translate("NewPriceCategory", "category", null));
        saveButton.setText(com.trolltech.qt.core.QCoreApplication.translate("NewPriceCategory", "save", null));
        clearButton.setText(com.trolltech.qt.core.QCoreApplication.translate("NewPriceCategory", "clear", null));
    } // retranslateUi

}

