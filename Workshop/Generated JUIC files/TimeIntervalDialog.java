/********************************************************************************
** Form generated from reading ui file 'TimeIntervalDialog.jui'
**
** Created: Mo 17. Okt 17:45:43 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class TimeIntervalDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDateEdit dateEdit;
    public QTimeEdit timeEdit_Start;
    public QTimeEdit timeEdit_End;
    public QPushButton saveTimeIntervalButton;
    public QLabel label_Date;
    public QLabel label_StartTime;
    public QLabel label_EndTime;
    public QPushButton cancelButton;

    public TimeIntervalDialog() { super(); }

    public void setupUi(QDialog TimeIntervalDialog)
    {
        TimeIntervalDialog.setObjectName("TimeIntervalDialog");
        TimeIntervalDialog.resize(new QSize(225, 76).expandedTo(TimeIntervalDialog.minimumSizeHint()));
        TimeIntervalDialog.setWindowIcon(new QIcon(new QPixmap("logo_gik.png")));
        TimeIntervalDialog.setModal(true);
        dateEdit = new QDateEdit(TimeIntervalDialog);
        dateEdit.setObjectName("dateEdit");
        dateEdit.setGeometry(new QRect(5, 20, 81, 20));
        dateEdit.setButtonSymbols(com.trolltech.qt.gui.QAbstractSpinBox.ButtonSymbols.NoButtons);
        dateEdit.setCalendarPopup(true);
        dateEdit.setDate(new QDate(2011, 5, 25));
        timeEdit_Start = new QTimeEdit(TimeIntervalDialog);
        timeEdit_Start.setObjectName("timeEdit_Start");
        timeEdit_Start.setGeometry(new QRect(95, 20, 55, 20));
        timeEdit_Start.setButtonSymbols(com.trolltech.qt.gui.QAbstractSpinBox.ButtonSymbols.UpDownArrows);
        timeEdit_Start.setCalendarPopup(false);
        timeEdit_End = new QTimeEdit(TimeIntervalDialog);
        timeEdit_End.setObjectName("timeEdit_End");
        timeEdit_End.setGeometry(new QRect(160, 20, 55, 20));
        timeEdit_End.setButtonSymbols(com.trolltech.qt.gui.QAbstractSpinBox.ButtonSymbols.UpDownArrows);
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
        cancelButton = new QPushButton(TimeIntervalDialog);
        cancelButton.setObjectName("cancelButton");
        cancelButton.setGeometry(new QRect(5, 50, 72, 20));
        retranslateUi(TimeIntervalDialog);

        TimeIntervalDialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog TimeIntervalDialog)
    {
        TimeIntervalDialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("TimeIntervalDialog", "Time Interval", null));
        timeEdit_Start.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("TimeIntervalDialog", "HH:mm", null));
        timeEdit_End.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("TimeIntervalDialog", "HH:mm", null));
        saveTimeIntervalButton.setText(com.trolltech.qt.core.QCoreApplication.translate("TimeIntervalDialog", "save", null));
        label_Date.setText(com.trolltech.qt.core.QCoreApplication.translate("TimeIntervalDialog", "Date", null));
        label_StartTime.setText(com.trolltech.qt.core.QCoreApplication.translate("TimeIntervalDialog", "Start", null));
        label_EndTime.setText(com.trolltech.qt.core.QCoreApplication.translate("TimeIntervalDialog", "End", null));
        cancelButton.setText(com.trolltech.qt.core.QCoreApplication.translate("TimeIntervalDialog", "Cancel", null));
    } // retranslateUi

}

