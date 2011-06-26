/********************************************************************************
** Form generated from reading ui file 'Schedule.jui'
**
** Created: Sa 25. Jun 18:01:23 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Schedule implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDialogButtonBox buttonBox;
    public QTreeWidget treeWidget;
    public QPushButton addTimeIntervalButton;
    public QPushButton deleteTimeIntervalButton;

    public Schedule() { super(); }

    public void setupUi(QDialog Schedule)
    {
        Schedule.setObjectName("Schedule");
        Schedule.resize(new QSize(332, 248).expandedTo(Schedule.minimumSizeHint()));
        Schedule.setMinimumSize(new QSize(332, 248));
        Schedule.setMaximumSize(new QSize(332, 248));
        Schedule.setWindowIcon(new QIcon(new QPixmap("logo_gik.png")));
        Schedule.setModal(true);
        buttonBox = new QDialogButtonBox(Schedule);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(10, 220, 121, 20));
        buttonBox.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.TabFocus);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));
        treeWidget = new QTreeWidget(Schedule);
        treeWidget.setObjectName("treeWidget");
        treeWidget.setGeometry(new QRect(10, 10, 311, 192));
        treeWidget.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        treeWidget.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        treeWidget.setIndentation(10);
        treeWidget.setItemsExpandable(false);
        addTimeIntervalButton = new QPushButton(Schedule);
        addTimeIntervalButton.setObjectName("addTimeIntervalButton");
        addTimeIntervalButton.setGeometry(new QRect(220, 220, 101, 20));
        deleteTimeIntervalButton = new QPushButton(Schedule);
        deleteTimeIntervalButton.setObjectName("deleteTimeIntervalButton");
        deleteTimeIntervalButton.setGeometry(new QRect(140, 220, 75, 20));
        retranslateUi(Schedule);
        buttonBox.clicked.connect(Schedule, "close()");

        Schedule.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Schedule)
    {
        Schedule.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Schedule", "Schedule", null));
        treeWidget.headerItem().setText(0, com.trolltech.qt.core.QCoreApplication.translate("Schedule", "Date", null));
        treeWidget.headerItem().setText(1, com.trolltech.qt.core.QCoreApplication.translate("Schedule", "Start", null));
        treeWidget.headerItem().setText(2, com.trolltech.qt.core.QCoreApplication.translate("Schedule", "End", null));
        treeWidget.clear();

        QTreeWidgetItem __item = new QTreeWidgetItem(treeWidget);
        __item.setText(0, com.trolltech.qt.core.QCoreApplication.translate("Schedule", "01.12.2011", null));
        __item.setText(1, com.trolltech.qt.core.QCoreApplication.translate("Schedule", "8:00", null));
        __item.setText(2, com.trolltech.qt.core.QCoreApplication.translate("Schedule", "11:00", null));

        QTreeWidgetItem __item1 = new QTreeWidgetItem(treeWidget);
        __item1.setText(0, com.trolltech.qt.core.QCoreApplication.translate("Schedule", "01.12.2011", null));
        __item1.setText(1, com.trolltech.qt.core.QCoreApplication.translate("Schedule", "13:00", null));
        __item1.setText(2, com.trolltech.qt.core.QCoreApplication.translate("Schedule", "16:00", null));

        QTreeWidgetItem __item2 = new QTreeWidgetItem(treeWidget);
        __item2.setText(0, com.trolltech.qt.core.QCoreApplication.translate("Schedule", "02.12.2011", null));
        __item2.setText(1, com.trolltech.qt.core.QCoreApplication.translate("Schedule", "9:00", null));
        __item2.setText(2, com.trolltech.qt.core.QCoreApplication.translate("Schedule", "12:00", null));
        addTimeIntervalButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Schedule", "add time interval", null));
        deleteTimeIntervalButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Schedule", "delete", null));
    } // retranslateUi

}

