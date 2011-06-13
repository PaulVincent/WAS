/********************************************************************************
** Form generated from reading ui file 'TimeIntervalDialog.jui'
**
** Created: Fr 3. Jun 23:51:28 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class TimeIntervalDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDialogButtonBox buttonBox_OK_Cancel;
    public QDateEdit dateEdit_Start;
    public QTimeEdit timeEdit;
    public QTimeEdit timeEdit_2;
    public QPushButton saveTimeIntervalButton;
    public QLabel label_Date;
    public QLabel label_StartTime;
    public QLabel label_EndTime;

    public TimeIntervalDialog() { super(); }

    public void setupUi(QDialog TimeIntervalDialog)
    {
        TimeIntervalDialog.setObjectName("TimeIntervalDialog");
        TimeIntervalDialog.resize(new QSize(225, 76).expandedTo(TimeIntervalDialog.minimumSizeHint()));
        TimeIntervalDialog.setWindowIcon(new QIcon(new QPixmap("logo_gik.png")));
        TimeIntervalDialog.setModal(true);
        buttonBox_OK_Cancel = new QDialogButtonBox(TimeIntervalDialog);
        buttonBox_OK_Cancel.setObjectName("buttonBox_OK_Cancel");
        buttonBox_OK_Cancel.setGeometry(new QRect(10, 50, 126, 20));
        buttonBox_OK_Cancel.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.TabFocus);
        buttonBox_OK_Cancel.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));
        dateEdit_Start = new QDateEdit(TimeIntervalDialog);
        dateEdit_Start.setObjectName("dateEdit_Start");
        dateEdit_Start.setGeometry(new QRect(5, 20, 81, 20));
        dateEdit_Start.setButtonSymbols(com.trolltech.qt.gui.QAbstractSpinBox.ButtonSymbols.NoButtons);
        dateEdit_Start.setCalendarPopup(true);
        dateEdit_Start.setDate(new QDate(2011, 5, 25));
        timeEdit = new QTimeEdit(TimeIntervalDialog);
        timeEdit.setObjectName("timeEdit");
        timeEdit.setGeometry(new QRect(95, 20, 55, 20));
        timeEdit.setButtonSymbols(com.trolltech.qt.gui.QAbstractSpinBox.ButtonSymbols.UpDownArrows);
        timeEdit.setCalendarPopup(false);
        timeEdit_2 = new QTimeEdit(TimeIntervalDialog);
        timeEdit_2.setObjectName("timeEdit_2");
        timeEdit_2.setGeometry(new QRect(160, 20, 55, 20));
        timeEdit_2.setButtonSymbols(com.trolltech.qt.gui.QAbstractSpinBox.ButtonSymbols.UpDownArrows);
        saveTimeIntervalButton = new QPushButton(TimeIntervalDialog);
        saveTimeIntervalButton.setObjectName("saveTimeIntervalButton");
        saveTimeIntervalButton.setGeometry(new QRect(141, 50, 72, 20));
        label_Date = new QLabel(TimeIntervalDialog);
        label_Date.setObjectName("label_Date");
        label_Date.setGeometry(new QRect(5, 0, 46, 20));
        label_StartTime = new QLabel(TimeIntervalDialog);
        label_StartTime.setObjectName("label_StartTime");
        label_StartTime.setGeometry(new QRect(95, 0, 31, 20));
        label_EndTime = new QLabel(TimeIntervalDialog);
        label_EndTime.setObjectName("label_EndTime");
        label_EndTime.setGeometry(new QRect(160, 0, 21, 20));
        retranslateUi(TimeIntervalDialog);
        buttonBox_OK_Cancel.clicked.connect(TimeIntervalDialog, "close()");

        TimeIntervalDialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog TimeIntervalDialog)
    {
        TimeIntervalDialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("TimeIntervalDialog", "Time Interval", null));
        timeEdit.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("TimeIntervalDialog", "HH:mm", null));
        timeEdit_2.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("TimeIntervalDialog", "HH:mm", null));
        saveTimeIntervalButton.setText(com.trolltech.qt.core.QCoreApplication.translate("TimeIntervalDialog", "save", null));
        label_Date.setText(com.trolltech.qt.core.QCoreApplication.translate("TimeIntervalDialog", "Date", null));
        label_StartTime.setText(com.trolltech.qt.core.QCoreApplication.translate("TimeIntervalDialog", "Start", null));
        label_EndTime.setText(com.trolltech.qt.core.QCoreApplication.translate("TimeIntervalDialog", "End", null));
    } // retranslateUi

}

