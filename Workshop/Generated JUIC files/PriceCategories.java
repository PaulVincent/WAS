/********************************************************************************
** Form generated from reading ui file 'PriceCategories.jui'
**
** Created: Sa 4. Jun 00:12:10 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class PriceCategories implements com.trolltech.qt.QUiForm<QDialog>
{
    public QTreeWidget treeWidget;
    public QPushButton addCategoryButton;
    public QPushButton deleteButton;
    public QDialogButtonBox buttonBox;

    public PriceCategories() { super(); }

    public void setupUi(QDialog PriceCategories)
    {
        PriceCategories.setObjectName("PriceCategories");
        PriceCategories.resize(new QSize(277, 136).expandedTo(PriceCategories.minimumSizeHint()));
        PriceCategories.setWindowIcon(new QIcon(new QPixmap("logo_gik.png")));
        PriceCategories.setModal(true);
        treeWidget = new QTreeWidget(PriceCategories);
        treeWidget.setObjectName("treeWidget");
        treeWidget.setGeometry(new QRect(10, 10, 171, 111));
        addCategoryButton = new QPushButton(PriceCategories);
        addCategoryButton.setObjectName("addCategoryButton");
        addCategoryButton.setGeometry(new QRect(190, 70, 77, 20));
        deleteButton = new QPushButton(PriceCategories);
        deleteButton.setObjectName("deleteButton");
        deleteButton.setGeometry(new QRect(190, 100, 77, 20));
        buttonBox = new QDialogButtonBox(PriceCategories);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(190, 10, 77, 48));
        buttonBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Vertical);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));
        buttonBox.setCenterButtons(false);
        retranslateUi(PriceCategories);
        buttonBox.clicked.connect(PriceCategories, "close()");

        PriceCategories.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog PriceCategories)
    {
        PriceCategories.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "Price Categories", null));
        treeWidget.headerItem().setText(0, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "Category", null));
        treeWidget.headerItem().setText(1, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "Price", null));
        treeWidget.clear();

        QTreeWidgetItem __item = new QTreeWidgetItem(treeWidget);
        __item.setText(0, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "normal", null));
        __item.setText(1, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "50", null));

        QTreeWidgetItem __item1 = new QTreeWidgetItem(treeWidget);
        __item1.setText(0, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "reduced", null));
        __item1.setText(1, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "40", null));
        addCategoryButton.setText(com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "add", null));
        deleteButton.setText(com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "delete", null));
    } // retranslateUi

}

