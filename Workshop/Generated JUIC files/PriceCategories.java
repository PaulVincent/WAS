/********************************************************************************
** Form generated from reading ui file 'PriceCategories.jui'
**
** Created: Di 28. Jun 22:42:22 2011
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
        PriceCategories.resize(new QSize(313, 159).expandedTo(PriceCategories.minimumSizeHint()));
        PriceCategories.setMinimumSize(new QSize(313, 159));
        PriceCategories.setMaximumSize(new QSize(313, 159));
        PriceCategories.setWindowIcon(new QIcon(new QPixmap("logo_gik.png")));
        PriceCategories.setModal(true);
        treeWidget = new QTreeWidget(PriceCategories);
        treeWidget.setObjectName("treeWidget");
        treeWidget.setGeometry(new QRect(10, 10, 191, 135));
        treeWidget.setSortingEnabled(true);
        addCategoryButton = new QPushButton(PriceCategories);
        addCategoryButton.setObjectName("addCategoryButton");
        addCategoryButton.setGeometry(new QRect(220, 90, 77, 25));
        deleteButton = new QPushButton(PriceCategories);
        deleteButton.setObjectName("deleteButton");
        deleteButton.setGeometry(new QRect(220, 120, 77, 25));
        buttonBox = new QDialogButtonBox(PriceCategories);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(220, 10, 77, 60));
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
        __item.setText(0, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "zrarz", null));
        __item.setText(1, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "arszsraz", null));

        QTreeWidgetItem __item1 = new QTreeWidgetItem(treeWidget);
        __item1.setText(0, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "wartarwt", null));
        __item1.setText(1, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "wartzwar", null));

        QTreeWidgetItem __item2 = new QTreeWidgetItem(treeWidget);
        __item2.setText(0, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "srazsraz", null));
        __item2.setText(1, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "rzszasr", null));

        QTreeWidgetItem __item3 = new QTreeWidgetItem(treeWidget);
        __item3.setText(0, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "rtwat", null));
        __item3.setText(1, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "wrtawt", null));

        QTreeWidgetItem __item4 = new QTreeWidgetItem(treeWidget);
        __item4.setText(0, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "rtat", null));
        __item4.setText(1, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "wratw", null));

        QTreeWidgetItem __item5 = new QTreeWidgetItem(treeWidget);
        __item5.setText(0, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "reduced", null));
        __item5.setText(1, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "40", null));

        QTreeWidgetItem __item6 = new QTreeWidgetItem(treeWidget);
        __item6.setText(0, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "normal", null));
        __item6.setText(1, com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "50", null));
        addCategoryButton.setText(com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "add", null));
        deleteButton.setText(com.trolltech.qt.core.QCoreApplication.translate("PriceCategories", "delete", null));
    } // retranslateUi

}

