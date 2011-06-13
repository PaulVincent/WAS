/********************************************************************************
** Form generated from reading ui file 'Workshops.jui'
**
** Created: Sa 4. Jun 00:09:57 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Workshops implements com.trolltech.qt.QUiForm<QDialog>
{
    public QTreeWidget treeWidget;
    public QPushButton cancelButton;
    public QPushButton okButton;

    public Workshops() { super(); }

    public void setupUi(QDialog Workshops)
    {
        Workshops.setObjectName("Workshops");
        Workshops.resize(new QSize(502, 239).expandedTo(Workshops.minimumSizeHint()));
        Workshops.setWindowIcon(new QIcon(new QPixmap("logo_gik.png")));
        Workshops.setModal(true);
        treeWidget = new QTreeWidget(Workshops);
        treeWidget.setObjectName("treeWidget");
        treeWidget.setGeometry(new QRect(10, 10, 481, 192));
        treeWidget.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.DoubleClicked));
        treeWidget.setIndentation(5);
        cancelButton = new QPushButton(Workshops);
        cancelButton.setObjectName("cancelButton");
        cancelButton.setGeometry(new QRect(234, 211, 77, 20));
        okButton = new QPushButton(Workshops);
        okButton.setObjectName("okButton");
        okButton.setGeometry(new QRect(151, 211, 77, 20));
        retranslateUi(Workshops);
        cancelButton.clicked.connect(Workshops, "close()");

        Workshops.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Workshops)
    {
        Workshops.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Workshops", "Existing Workshops", null));
        treeWidget.headerItem().setText(0, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "ID", null));
        treeWidget.headerItem().setText(1, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "Title", null));
        treeWidget.headerItem().setText(2, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "Lecturer", null));
        treeWidget.headerItem().setText(3, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "Date", null));
        treeWidget.headerItem().setText(4, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "Participants", null));
        treeWidget.clear();

        QTreeWidgetItem __item = new QTreeWidgetItem(treeWidget);
        __item.setText(0, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "0", null));
        __item.setText(1, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "GIS", null));
        __item.setText(2, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "Thomas Mayer", null));
        __item.setText(3, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "23.10.2011", null));
        __item.setText(4, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "10", null));

        QTreeWidgetItem __item1 = new QTreeWidgetItem(treeWidget);
        __item1.setText(0, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "1", null));
        __item1.setText(1, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "OO_Modellierung", null));
        __item1.setText(2, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "Heinrich Vern", null));
        __item1.setText(3, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "12.11.2011", null));
        __item1.setText(4, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "17", null));

        QTreeWidgetItem __item2 = new QTreeWidgetItem(treeWidget);
        __item2.setText(0, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "2", null));
        __item2.setText(1, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "Cloud-Computing", null));
        __item2.setText(2, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "Sven Wertig", null));
        __item2.setText(3, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "01.12.2011", null));
        __item2.setText(4, com.trolltech.qt.core.QCoreApplication.translate("Workshops", "8", null));
        cancelButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Workshops", "Cancel", null));
        okButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Workshops", "OK", null));
    } // retranslateUi

}

