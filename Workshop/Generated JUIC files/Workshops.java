/********************************************************************************
** Form generated from reading ui file 'Workshops.jui'
**
** Created: So 26. Jun 23:36:32 2011
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
        Workshops.resize(new QSize(547, 239).expandedTo(Workshops.minimumSizeHint()));
        Workshops.setWindowIcon(new QIcon(new QPixmap("logo_gik.png")));
        Workshops.setModal(true);
        treeWidget = new QTreeWidget(Workshops);
        treeWidget.setObjectName("treeWidget");
        treeWidget.setGeometry(new QRect(10, 10, 521, 192));
        treeWidget.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.DoubleClicked));
        treeWidget.setIndentation(5);
        treeWidget.setItemsExpandable(false);
        treeWidget.setSortingEnabled(true);
        treeWidget.setExpandsOnDoubleClick(false);
        cancelButton = new QPushButton(Workshops);
        cancelButton.setObjectName("cancelButton");
        cancelButton.setGeometry(new QRect(263, 210, 77, 20));
        okButton = new QPushButton(Workshops);
        okButton.setObjectName("okButton");
        okButton.setGeometry(new QRect(180, 210, 77, 20));
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
        cancelButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Workshops", "Cancel", null));
        okButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Workshops", "OK", null));
    } // retranslateUi

}

