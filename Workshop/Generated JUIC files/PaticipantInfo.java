/********************************************************************************
** Form generated from reading ui file 'PaticipantInfo.jui'
**
** Created: Fr 3. Jun 23:50:35 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class PaticipantInfo implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDialogButtonBox buttonBox;
    public QLabel label_FirstName;
    public QLabel label_Street;
    public QLabel label_Place;
    public QLabel label_HouseNr;
    public QLabel label_ZIPCode;
    public QLabel label_Pricecategory;
    public QLabel label_Price;
    public QLabel label_Registration;
    public QLabel label_SurName;
    public QLineEdit lineEdit_FirstName;
    public QLineEdit lineEdit_Street;
    public QLineEdit lineEdit_Place;
    public QLineEdit lineEdit_ZIPCode;
    public QLineEdit lineEdit_HouseNr;
    public QLineEdit lineEdit_SurName;
    public QLineEdit lineEdit_Price;
    public QComboBox comboBox_PriceCategory;
    public QLabel label_Paid;
    public QCheckBox checkBox_Paid;
    public QDateEdit dateEdit;
    public QPushButton savePartButton;
    public QPushButton clearPartButton;
    public QLabel label_TelNumber;
    public QLineEdit lineEdit_PhoneNumber;
    public QLabel label_E_Mail;
    public QLineEdit lineEdit_eMail;

    public PaticipantInfo() { super(); }

    public void setupUi(QDialog PaticipantInfo)
    {
        PaticipantInfo.setObjectName("PaticipantInfo");
        PaticipantInfo.setWindowModality(com.trolltech.qt.core.Qt.WindowModality.NonModal);
        PaticipantInfo.resize(new QSize(459, 251).expandedTo(PaticipantInfo.minimumSizeHint()));
        PaticipantInfo.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.NoFocus);
        PaticipantInfo.setAcceptDrops(false);
        PaticipantInfo.setWindowIcon(new QIcon(new QPixmap("logo_gik.png")));
        PaticipantInfo.setSizeGripEnabled(false);
        PaticipantInfo.setModal(true);
        buttonBox = new QDialogButtonBox(PaticipantInfo);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(67, 220, 161, 20));
        buttonBox.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.TabFocus);
        buttonBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));
        label_FirstName = new QLabel(PaticipantInfo);
        label_FirstName.setObjectName("label_FirstName");
        label_FirstName.setGeometry(new QRect(20, 10, 61, 16));
        label_Street = new QLabel(PaticipantInfo);
        label_Street.setObjectName("label_Street");
        label_Street.setGeometry(new QRect(20, 41, 51, 20));
        label_Place = new QLabel(PaticipantInfo);
        label_Place.setObjectName("label_Place");
        label_Place.setGeometry(new QRect(20, 80, 31, 20));
        label_HouseNr = new QLabel(PaticipantInfo);
        label_HouseNr.setObjectName("label_HouseNr");
        label_HouseNr.setGeometry(new QRect(240, 45, 51, 16));
        label_ZIPCode = new QLabel(PaticipantInfo);
        label_ZIPCode.setObjectName("label_ZIPCode");
        label_ZIPCode.setGeometry(new QRect(240, 80, 51, 16));
        label_Pricecategory = new QLabel(PaticipantInfo);
        label_Pricecategory.setObjectName("label_Pricecategory");
        label_Pricecategory.setGeometry(new QRect(20, 150, 68, 16));
        label_Price = new QLabel(PaticipantInfo);
        label_Price.setObjectName("label_Price");
        label_Price.setGeometry(new QRect(240, 150, 23, 16));
        label_Registration = new QLabel(PaticipantInfo);
        label_Registration.setObjectName("label_Registration");
        label_Registration.setGeometry(new QRect(20, 185, 71, 16));
        label_SurName = new QLabel(PaticipantInfo);
        label_SurName.setObjectName("label_SurName");
        label_SurName.setGeometry(new QRect(240, 10, 50, 16));
        lineEdit_FirstName = new QLineEdit(PaticipantInfo);
        lineEdit_FirstName.setObjectName("lineEdit_FirstName");
        lineEdit_FirstName.setGeometry(new QRect(100, 10, 115, 20));
        lineEdit_Street = new QLineEdit(PaticipantInfo);
        lineEdit_Street.setObjectName("lineEdit_Street");
        lineEdit_Street.setGeometry(new QRect(100, 45, 115, 20));
        lineEdit_Place = new QLineEdit(PaticipantInfo);
        lineEdit_Place.setObjectName("lineEdit_Place");
        lineEdit_Place.setGeometry(new QRect(100, 80, 115, 20));
        lineEdit_ZIPCode = new QLineEdit(PaticipantInfo);
        lineEdit_ZIPCode.setObjectName("lineEdit_ZIPCode");
        lineEdit_ZIPCode.setGeometry(new QRect(300, 80, 71, 20));
        lineEdit_HouseNr = new QLineEdit(PaticipantInfo);
        lineEdit_HouseNr.setObjectName("lineEdit_HouseNr");
        lineEdit_HouseNr.setGeometry(new QRect(300, 45, 41, 20));
        lineEdit_SurName = new QLineEdit(PaticipantInfo);
        lineEdit_SurName.setObjectName("lineEdit_SurName");
        lineEdit_SurName.setGeometry(new QRect(300, 10, 141, 20));
        lineEdit_Price = new QLineEdit(PaticipantInfo);
        lineEdit_Price.setObjectName("lineEdit_Price");
        lineEdit_Price.setGeometry(new QRect(300, 150, 41, 20));
        comboBox_PriceCategory = new QComboBox(PaticipantInfo);
        comboBox_PriceCategory.setObjectName("comboBox_PriceCategory");
        comboBox_PriceCategory.setGeometry(new QRect(100, 150, 71, 20));
        label_Paid = new QLabel(PaticipantInfo);
        label_Paid.setObjectName("label_Paid");
        label_Paid.setGeometry(new QRect(240, 185, 46, 16));
        checkBox_Paid = new QCheckBox(PaticipantInfo);
        checkBox_Paid.setObjectName("checkBox_Paid");
        checkBox_Paid.setGeometry(new QRect(300, 185, 72, 20));
        dateEdit = new QDateEdit(PaticipantInfo);
        dateEdit.setObjectName("dateEdit");
        dateEdit.setGeometry(new QRect(100, 185, 81, 20));
        dateEdit.setButtonSymbols(com.trolltech.qt.gui.QAbstractSpinBox.ButtonSymbols.NoButtons);
        dateEdit.setDateTime(new QDateTime(new QDate(2011, 5, 20), new QTime(0, 0, 0)));
        dateEdit.setMaximumDateTime(new QDateTime(new QDate(2050, 12, 31), new QTime(23, 59, 59)));
        dateEdit.setMinimumDateTime(new QDateTime(new QDate(1983, 5, 20), new QTime(0, 0, 0)));
        dateEdit.setCalendarPopup(true);
        dateEdit.setDate(new QDate(2011, 5, 20));
        savePartButton = new QPushButton(PaticipantInfo);
        savePartButton.setObjectName("savePartButton");
        savePartButton.setGeometry(new QRect(237, 220, 77, 20));
        clearPartButton = new QPushButton(PaticipantInfo);
        clearPartButton.setObjectName("clearPartButton");
        clearPartButton.setGeometry(new QRect(320, 220, 77, 20));
        label_TelNumber = new QLabel(PaticipantInfo);
        label_TelNumber.setObjectName("label_TelNumber");
        label_TelNumber.setGeometry(new QRect(20, 115, 71, 16));
        lineEdit_PhoneNumber = new QLineEdit(PaticipantInfo);
        lineEdit_PhoneNumber.setObjectName("lineEdit_PhoneNumber");
        lineEdit_PhoneNumber.setGeometry(new QRect(100, 115, 113, 20));
        label_E_Mail = new QLabel(PaticipantInfo);
        label_E_Mail.setObjectName("label_E_Mail");
        label_E_Mail.setGeometry(new QRect(240, 115, 31, 16));
        lineEdit_eMail = new QLineEdit(PaticipantInfo);
        lineEdit_eMail.setObjectName("lineEdit_eMail");
        lineEdit_eMail.setGeometry(new QRect(300, 115, 141, 20));
        retranslateUi(PaticipantInfo);
        buttonBox.clicked.connect(PaticipantInfo, "close()");
        savePartButton.clicked.connect(PaticipantInfo, "close()");

        PaticipantInfo.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog PaticipantInfo)
    {
        PaticipantInfo.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Participant-Info", null));
        label_FirstName.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "First name", null));
        label_Street.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Street", null));
        label_Place.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Place", null));
        label_HouseNr.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "House nr.", null));
        label_ZIPCode.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "ZIP Code", null));
        label_Pricecategory.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Category", null));
        label_Price.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Price", null));
        label_Registration.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Registration", null));
        label_SurName.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Last name", null));
        comboBox_PriceCategory.clear();
        comboBox_PriceCategory.addItem(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "normal", null));
        comboBox_PriceCategory.addItem(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "reduced", null));
        label_Paid.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Paid", null));
        checkBox_Paid.setText("");
        savePartButton.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "save", null));
        clearPartButton.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "clear", null));
        label_TelNumber.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "Phone number", null));
        label_E_Mail.setText(com.trolltech.qt.core.QCoreApplication.translate("PaticipantInfo", "E-mail", null));
        lineEdit_eMail.setText("");
    } // retranslateUi

}

