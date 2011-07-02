/********************************************************************************
** Form generated from reading ui file 'Schedule.jui'
**
** Created: Sa 2. Jul 16:40:08 2011
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
        Schedule.resize(new QSize(384, 256).expandedTo(Schedule.minimumSizeHint()));
        Schedule.setMinimumSize(new QSize(384, 256));
        Schedule.setMaximumSize(new QSize(384, 256));
        Schedule.setWindowIcon(new QIcon(new QPixmap("logo_gik.png")));
        Schedule.setModal(true);
        buttonBox = new QDialogButtonBox(Schedule);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(10, 220, 161, 25));
        buttonBox.setMinimumSize(new QSize(161, 25));
        buttonBox.setMaximumSize(new QSize(161, 25));
        buttonBox.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.TabFocus);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));
        treeWidget = new QTreeWidget(Schedule);
        treeWidget.setObjectName("treeWidget");
        treeWidget.setGeometry(new QRect(10, 10, 361, 192));
        treeWidget.setMinimumSize(new QSize(361, 192));
        treeWidget.setMaximumSize(new QSize(361, 192));
        treeWidget.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        treeWidget.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        treeWidget.setIndentation(10);
        treeWidget.setItemsExpandable(false);
        addTimeIntervalButton = new QPushButton(Schedule);
        addTimeIntervalButton.setObjectName("addTimeIntervalButton");
        addTimeIntervalButton.setGeometry(new QRect(270, 220, 101, 25));
        addTimeIntervalButton.setMinimumSize(new QSize(101, 25));
        addTimeIntervalButton.setMaximumSize(new QSize(101, 25));
        deleteTimeIntervalButton = new QPushButton(Schedule);
        deleteTimeIntervalButton.setObjectName("deleteTimeIntervalButton");
        deleteTimeIntervalButton.setGeometry(new QRect(190, 220, 75, 25));
        deleteTimeIntervalButton.setMinimumSize(new QSize(75, 25));
        deleteTimeIntervalButton.setMaximumSize(new QSize(75, 25));
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
        addTimeIntervalButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Schedule", "add time interval", null));
        deleteTimeIntervalButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Schedule", "delete", null));
    } // retranslateUi

}

