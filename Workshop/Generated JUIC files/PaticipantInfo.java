/********************************************************************************
** Form generated from reading ui file 'PaticipantInfo.jui'
**
** Created: Mo 17. Okt 17:25:50 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class PaticipantInfo implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGridLayout gridLayout;
    public QLabel label_FirstName;
    public QLineEdit lineEdit_FirstName;
    public QLabel label_SurName;
    public QLineEdit lineEdit_SurName;
    public QLabel label_Street;
    public QLineEdit lineEdit_Street;
    public QLabel label_HouseNr;
    public QLineEdit lineEdit_HouseNr;
    public QLabel label_Place;
    public QLineEdit lineEdit_Place;
    public QLabel label_ZIPCode;
    public QLineEdit lineEdit_ZIPCode;
    public QLabel label_TelNumber;
    public QLineEdit lineEdit_PhoneNumber;
    public QLabel label_E_Mail;
    public QLineEdit lineEdit_eMail;
    public QLabel label_Pricecategory;
    public QComboBox comboBox_PriceCategory;
    public QLabel label_Price;
    public QLineEdit lineEdit_Price;
    public QLabel label_Registration;
    public QDateEdit dateEdit;
    public QLabel label_Paid;
    public QCheckBox checkBox_Paid;
    public QPushButton CancelButton;
    public QPushButton savePartButton;
    public QPushButton clearPartButton;

    public PaticipantInfo() { super(); }

    public void setupUi(QDialog PaticipantInfo)
    {
        PaticipantInfo.setObjectName("PaticipantInfo");
        PaticipantInfo.setWindowModality(com.trolltech.qt.core.Qt.WindowModality.NonModal);
        PaticipantInfo.resize(new QSize(549, 229).expandedTo(PaticipantInfo.minimumSizeHint()));
        PaticipantInfo.setMinimumSize(new QSize(549, 229));
        PaticipantInfo.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.NoFocus);
        PaticipantInfo.setAcceptDrops(false);
        PaticipantInfo.setWindowIcon(new QIcon(new QPixmap("logo_gik.png")));
        PaticipantInfo.setSizeGripEnabled(false);
        PaticipantInfo.setModal(true);
        gridLayout = new QGridLayout(PaticipantInfo);
        gridLayout.setObjectName("gridLayout");
        label_FirstName = new QLabel(PaticipantInfo);
        label_FirstName.setObjectName("label_FirstName");
        label_FirstName.setMinimumSize(new QSize(61, 25));

        gridLayout.addWidget(label_FirstName, 0, 0, 1, 1);

        lineEdit_FirstName = new QLineEdit(PaticipantInfo);
        lineEdit_FirstName.setObjectName("lineEdit_FirstName");
        lineEdit_FirstName.setMinimumSize(new QSize(115, 25));

        gridLayout.addWidget(lineEdit_FirstName, 0, 1, 1, 1);

        label_SurName = new QLabel(PaticipantInfo);
        label_SurName.setObjectName("label_SurName");
        label_SurName.setMinimumSize(new QSize(50, 25));

        gridLayout.addWidget(label_SurName, 0, 2, 1, 1);

        lineEdit_SurName = new QLineEdit(PaticipantInfo);
        lineEdit_SurName.setObjectName("lineEdit_SurName");
        lineEdit_SurName.setMinimumSize(new QSize(141, 25));

        gridLayout.addWidget(lineEdit_SurName, 0, 3, 1, 1);

        label_Street = new QLabel(PaticipantInfo);
        label_Street.setObjectName("label_Street");
        label_Street.setMinimumSize(new QSize(51, 25));

        gridLayout.addWidget(label_Street, 1, 0, 1, 1);

        lineEdit_Street = new QLineEdit(PaticipantInfo);
        lineEdit_Street.setObjectName("lineEdit_Street");
        lineEdit_Street.setMinimumSize(new QSize(115, 25));

        gridLayout.addWidget(lineEdit_Street, 1, 1, 1, 1);

        label_HouseNr = new QLabel(PaticipantInfo);
        label_HouseNr.setObjectName("label_HouseNr");
        label_HouseNr.setMinimumSize(new QSize(51, 25));

        gridLayout.addWidget(label_HouseNr, 1, 2, 1, 1);

        lineEdit_HouseNr = new QLineEdit(PaticipantInfo);
        lineEdit_HouseNr.setObjectName("lineEdit_HouseNr");
        lineEdit_HouseNr.setMinimumSize(new QSize(41, 25));

        gridLayout.addWidget(lineEdit_HouseNr, 1, 3, 1, 1);

        label_Place = new QLabel(PaticipantInfo);
        label_Place.setObjectName("label_Place");
        label_Place.setMinimumSize(new QSize(31, 25));

        gridLayout.addWidget(label_Place, 2, 0, 1, 1);

        lineEdit_Place = new QLineEdit(PaticipantInfo);
        lineEdit_Place.setObjectName("lineEdit_Place");
        lineEdit_Place.setMinimumSize(new QSize(115, 25));

        gridLayout.addWidget(lineEdit_Place, 2, 1, 1, 1);

        label_ZIPCode = new QLabel(PaticipantInfo);
        label_ZIPCode.setObjectName("label_ZIPCode");
        label_ZIPCode.setMinimumSize(new QSize(51, 25));

        gridLayout.addWidget(label_ZIPCode, 2, 2, 1, 1);

        lineEdit_ZIPCode = new QLineEdit(PaticipantInfo);
        lineEdit_ZIPCode.setObjectName("lineEdit_ZIPCode");
        lineEdit_ZIPCode.setMinimumSize(new QSize(71, 25));

        gridLayout.addWidget(lineEdit_ZIPCode, 2, 3, 1, 1);

        label_TelNumber = new QLabel(PaticipantInfo);
        label_TelNumber.setObjectName("label_TelNumber");
        label_TelNumber.setMinimumSize(new QSize(71, 25));

        gridLayout.addWidget(label_TelNumber, 3, 0, 1, 1);

        lineEdit_PhoneNumber = new QLineEdit(PaticipantInfo);
        lineEdit_PhoneNumber.setObjectName("lineEdit_PhoneNumber");
        lineEdit_PhoneNumber.setMinimumSize(new QSize(113, 25));

        gridLayout.addWidget(lineEdit_PhoneNumber, 3, 1, 1, 1);

        label_E_Mail = new QLabel(PaticipantInfo);
        label_E_Mail.setObjectName("label_E_Mail");
        label_E_Mail.setMinimumSize(new QSize(31, 25));

        gridLayout.addWidget(label_E_Mail, 3, 2, 1, 1);

        lineEdit_eMail = new QLineEdit(PaticipantInfo);
        lineEdit_eMail.setObjectName("lineEdit_eMail");
        lineEdit_eMail.setMinimumSize(new QSize(141, 25));

        gridLayout.addWidget(lineEdit_eMail, 3, 3, 1, 1);

        label_Pricecategory = new QLabel(PaticipantInfo);
        label_Pricecategory.setObjectName("label_Pricecategory");
        label_Pricecategory.setMinimumSize(new QSize(68, 25));

        gridLayout.addWidget(label_Pricecategory, 4, 0, 1, 1);

        comboBox_PriceCategory = new QComboBox(PaticipantInfo);
        comboBox_PriceCategory.setObjectName("comboBox_PriceCategory");
        comboBox_PriceCategory.setMinimumSize(new QSize(71, 25));
        comboBox_PriceCategory.setMaximumSize(new QSize(81, 25));

        gridLayout.addWidget(comboBox_PriceCategory, 4, 1, 1, 1);

        label_Price = new QLabel(PaticipantInfo);
        label_Price.setObjectName("label_Price");
        label_Price.setMinimumSize(new QSize(23, 25));

        gridLayout.addWidget(label_Price, 4, 2, 1, 1);

        lineEdit_Price = new QLineEdit(PaticipantInfo);
        lineEdit_Price.setObjectName("lineEdit_Price");
        lineEdit_Price.setMinimumSize(new QSize(41, 25));
        lineEdit_Price.setMaximumSize(new QSize(41, 25));

        gridLayout.addWidget(lineEdit_Price, 4, 3, 1, 1);

        label_Registration = new QLabel(PaticipantInfo);
        label_Registration.setObjectName("label_Registration");
        label_Registration.setMinimumSize(new QSize(71, 25));

        gridLayout.addWidget(label_Registration, 5, 0, 1, 1);

        dateEdit = new QDateEdit(PaticipantInfo);
        dateEdit.setObjectName("dateEdit");
        dateEdit.setMinimumSize(new QSize(81, 25));
        dateEdit.setButtonSymbols(com.trolltech.qt.gui.QAbstractSpinBox.ButtonSymbols.NoButtons);
        dateEdit.setDateTime(new QDateTime(new QDate(2011, 5, 20), new QTime(0, 0, 0)));
        dateEdit.setMaximumDateTime(new QDateTime(new QDate(2050, 12, 31), new QTime(23, 59, 59)));
        dateEdit.setMinimumDateTime(new QDateTime(new QDate(2011, 5, 20), new QTime(0, 0, 0)));
        dateEdit.setMinimumDate(new QDate(2011, 5, 20));
        dateEdit.setCalendarPopup(true);
        dateEdit.setDate(new QDate(2011, 5, 20));

        gridLayout.addWidget(dateEdit, 5, 1, 1, 1);

        label_Paid = new QLabel(PaticipantInfo);
        label_Paid.setObjectName("label_Paid");
        label_Paid.setMinimumSize(new QSize(46, 25));

        gridLayout.addWidget(label_Paid, 5, 2, 1, 1);

        checkBox_Paid = new QCheckBox(PaticipantInfo);
        checkBox_Paid.setObjectName("checkBox_Paid");
        checkBox_Paid.setMinimumSize(new QSize(72, 25));

        gridLayout.addWidget(checkBox_Paid, 5, 3, 1, 1);

        CancelButton = new QPushButton(PaticipantInfo);
        CancelButton.setObjectName("CancelButton");
        CancelButton.setMinimumSize(new QSize(81, 25));
        CancelButton.setMaximumSize(new QSize(81, 25));

        gridLayout.addWidget(CancelButton, 6, 1, 1, 1);

        savePartButton = new QPushButton(PaticipantInfo);
        savePartButton.setObjectName("savePartButton");
        savePartButton.setMinimumSize(new QSize(81, 25));
        savePartButton.setMaximumSize(new QSize(81, 25));

        gridLayout.addWidget(savePartButton, 6, 2, 1, 1);

        clearPartButton = new QPushButton(PaticipantInfo);
        clearPartButton.setObjectName("clearPartButton");
        clearPartButton.setMinimumSize(new QSize(81, 25));
        clearPartButton.setMaximumSize(new QSize(81, 25));

        gridLayout.addWidget(clearPartButton, 6, 3, 1, 1);

        retranslateUi(PaticipantInfo);

        PaticipantInfo.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog PaticipantInfo)
    {
        PaticipantInfo.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Participant-Info", null));
        label_FirstName.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "First name", null));
        label_SurName.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Last name", null));
        label_Street.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Street", null));
        label_HouseNr.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "House nr.", null));
        label_Place.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Place", null));
        label_ZIPCode.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "ZIP Code", null));
        label_TelNumber.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Phone number", null));
        label_E_Mail.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "E-mail", null));
        lineEdit_eMail.setText("");
        label_Pricecategory.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Category", null));
        comboBox_PriceCategory.clear();
        comboBox_PriceCategory.addItem(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "normal", null));
        comboBox_PriceCategory.addItem(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "reduced", null));
        label_Price.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Price", null));
        label_Registration.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Registration", null));
        label_Paid.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Paid", null));
        checkBox_Paid.setText("");
        CancelButton.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Cancel", null));
        savePartButton.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "save", null));
        clearPartButton.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "clear", null));
    } // retranslateUi

}

