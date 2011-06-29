/********************************************************************************
** Form generated from reading ui file 'Workshops.jui'
**
** Created: Di 28. Jun 21:47:12 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Workshops implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGridLayout gridLayout;
    public QTreeWidget treeWidget;
    public QPushButton okButton;
    public QPushButton cancelButton;

    public Workshops() { super(); }

    public void setupUi(QDialog Workshops)
    {
        Workshops.setObjectName("Workshops");
        Workshops.resize(new QSize(723, 248).expandedTo(Workshops.minimumSizeHint()));
        Workshops.setWindowIcon(new QIcon(new QPixmap("logo_gik.png")));
        Workshops.setModal(true);
        gridLayout = new QGridLayout(Workshops);
        gridLayout.setObjectName("gridLayout");
        treeWidget = new QTreeWidget(Workshops);
        treeWidget.setObjectName("treeWidget");
        treeWidget.setMinimumSize(new QSize(701, 192));
        treeWidget.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.DoubleClicked));
        treeWidget.setSelectionBehavior(com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior.SelectRows);
        treeWidget.setIndentation(5);
        treeWidget.setItemsExpandable(false);
        treeWidget.setSortingEnabled(true);
        treeWidget.setAnimated(true);
        treeWidget.setAllColumnsShowFocus(false);
        treeWidget.setExpandsOnDoubleClick(false);

        gridLayout.addWidget(treeWidget, 0, 0, 1, 3);

        okButton = new QPushButton(Workshops);
        okButton.setObjectName("okButton");
        okButton.setMinimumSize(new QSize(91, 25));
        okButton.setMaximumSize(new QSize(91, 25));

        gridLayout.addWidget(okButton, 1, 0, 1, 1);

        cancelButton = new QPushButton(Workshops);
        cancelButton.setObjectName("cancelButton");
        cancelButton.setMinimumSize(new QSize(91, 25));
        cancelButton.setMaximumSize(new QSize(91, 25));

        gridLayout.addWidget(cancelButton, 1, 1, 1, 1);

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
        okButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Workshops", "OK", null));
        cancelButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Workshops", "Cancel", null));
    } // retranslateUi

}

