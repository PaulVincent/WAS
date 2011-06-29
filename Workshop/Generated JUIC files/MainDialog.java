/********************************************************************************
** Form generated from reading ui file 'WorkshopDialog.jui'
**
** Created: Mi 29. Jun 20:24:22 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class MainDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGridLayout gridLayout;
    public QLabel label_Title;
    public QLineEdit lineEdit_Titel;
    public QFrame line_Vertical;
    public QDialogButtonBox buttonBox_OK_Cancel;
    public QLabel label_Prof;
    public QLineEdit lineEdit_Prof;
    public QLabel label_Participants;
    public QLineEdit lineEdit_Part;
    public QPushButton editshowPartButton;
    public QLabel label_From;
    public QDateEdit dateEdit_Start;
    public QLabel label_To;
    public QDateEdit dateEdit_End;
    public QPushButton detailsButton;
    public QFrame lineHorizontal1;
    public QLabel label_Duration;
    public QLineEdit lineEdit_Duration;
    public QLabel label_Hours;
    public QPushButton deleteCourseButton;
    public QLabel label_Place;
    public QComboBox comboBox_Ort;
    public QPushButton loadCourseButton;
    public QLabel label_Price;
    public QComboBox comboBox_Price;
    public QLabel label_Price_2;
    public QLineEdit lineEdit_Price;
    public QLabel label_Currency;
    public QPushButton editshowPriceButton;
    public QFrame lineHorizontal2;
    public QLabel label_Description;
    public QTextEdit textEdit_Description;
    public QPushButton saveCourseButton;
    public QPushButton clearCourseButton;
    public QLabel label_Literature;
    public QListWidget listWidget_Literature;
    public QFrame line_Horizontal3;
    public QPushButton addLiteratureButton;
    public QPushButton generateHTMLButton;
    public QPushButton deleteLiteratureButton;
    public QPushButton addPlaceButton;

    public MainDialog() { super(); }

    public void setupUi(QDialog MainDialog)
    {
        MainDialog.setObjectName("MainDialog");
        MainDialog.setWindowModality(com.trolltech.qt.core.Qt.WindowModality.NonModal);
        MainDialog.setEnabled(true);
        MainDialog.resize(new QSize(717, 490).expandedTo(MainDialog.minimumSizeHint()));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy.setHorizontalStretch((byte)30);
        sizePolicy.setVerticalStretch((byte)30);
        sizePolicy.setHeightForWidth(MainDialog.sizePolicy().hasHeightForWidth());
        MainDialog.setSizePolicy(sizePolicy);
        MainDialog.setMinimumSize(new QSize(717, 490));
        MainDialog.setMaximumSize(new QSize(1024, 815));
        MainDialog.setSizeIncrement(new QSize(5, 5));
        MainDialog.setWindowIcon(new QIcon(new QPixmap("logo_gik.png")));
        MainDialog.setSizeGripEnabled(false);
        MainDialog.setModal(false);
        gridLayout = new QGridLayout(MainDialog);
        gridLayout.setObjectName("gridLayout");
        label_Title = new QLabel(MainDialog);
        label_Title.setObjectName("label_Title");
        label_Title.setMinimumSize(new QSize(66, 25));
        QFont font = new QFont();
        font.setPointSize(10);
        label_Title.setFont(font);

        gridLayout.addWidget(label_Title, 0, 0, 1, 1);

        lineEdit_Titel = new QLineEdit(MainDialog);
        lineEdit_Titel.setObjectName("lineEdit_Titel");
        lineEdit_Titel.setMinimumSize(new QSize(401, 25));

        gridLayout.addWidget(lineEdit_Titel, 0, 1, 1, 8);

        line_Vertical = new QFrame(MainDialog);
        line_Vertical.setObjectName("line_Vertical");
        line_Vertical.setMinimumSize(new QSize(20, 401));
        line_Vertical.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Sunken);
        line_Vertical.setFrameShape(QFrame.Shape.HLine);
        line_Vertical.setFrameShadow(QFrame.Shadow.Sunken);

        gridLayout.addWidget(line_Vertical, 0, 9, 12, 1);

        buttonBox_OK_Cancel = new QDialogButtonBox(MainDialog);
        buttonBox_OK_Cancel.setObjectName("buttonBox_OK_Cancel");
        buttonBox_OK_Cancel.setMinimumSize(new QSize(101, 55));
        buttonBox_OK_Cancel.setOrientation(com.trolltech.qt.core.Qt.Orientation.Vertical);
        buttonBox_OK_Cancel.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));

        gridLayout.addWidget(buttonBox_OK_Cancel, 0, 10, 2, 1);

        label_Prof = new QLabel(MainDialog);
        label_Prof.setObjectName("label_Prof");
        label_Prof.setMinimumSize(new QSize(66, 25));
        QFont font1 = new QFont();
        font1.setPointSize(10);
        label_Prof.setFont(font1);

        gridLayout.addWidget(label_Prof, 1, 0, 1, 1);

        lineEdit_Prof = new QLineEdit(MainDialog);
        lineEdit_Prof.setObjectName("lineEdit_Prof");
        lineEdit_Prof.setMinimumSize(new QSize(401, 25));

        gridLayout.addWidget(lineEdit_Prof, 1, 1, 1, 8);

        label_Participants = new QLabel(MainDialog);
        label_Participants.setObjectName("label_Participants");
        label_Participants.setMinimumSize(new QSize(66, 25));
        QFont font2 = new QFont();
        font2.setPointSize(10);
        label_Participants.setFont(font2);

        gridLayout.addWidget(label_Participants, 2, 0, 1, 1);

        lineEdit_Part = new QLineEdit(MainDialog);
        lineEdit_Part.setObjectName("lineEdit_Part");
        lineEdit_Part.setEnabled(true);
        lineEdit_Part.setMinimumSize(new QSize(41, 25));
        lineEdit_Part.setFrame(false);
        lineEdit_Part.setReadOnly(true);

        gridLayout.addWidget(lineEdit_Part, 2, 1, 1, 1);

        editshowPartButton = new QPushButton(MainDialog);
        editshowPartButton.setObjectName("editshowPartButton");
        editshowPartButton.setEnabled(false);
        editshowPartButton.setMinimumSize(new QSize(101, 25));

        gridLayout.addWidget(editshowPartButton, 2, 4, 1, 1);

        label_From = new QLabel(MainDialog);
        label_From.setObjectName("label_From");
        label_From.setMinimumSize(new QSize(66, 25));
        QFont font3 = new QFont();
        font3.setPointSize(10);
        label_From.setFont(font3);

        gridLayout.addWidget(label_From, 3, 0, 1, 1);

        dateEdit_Start = new QDateEdit(MainDialog);
        dateEdit_Start.setObjectName("dateEdit_Start");
        dateEdit_Start.setEnabled(true);
        dateEdit_Start.setMinimumSize(new QSize(83, 25));
        dateEdit_Start.setReadOnly(false);
        dateEdit_Start.setCalendarPopup(true);

        gridLayout.addWidget(dateEdit_Start, 3, 1, 1, 1);

        label_To = new QLabel(MainDialog);
        label_To.setObjectName("label_To");
        label_To.setMinimumSize(new QSize(16, 25));
        QFont font4 = new QFont();
        font4.setPointSize(10);
        label_To.setFont(font4);

        gridLayout.addWidget(label_To, 3, 4, 1, 1);

        dateEdit_End = new QDateEdit(MainDialog);
        dateEdit_End.setObjectName("dateEdit_End");
        dateEdit_End.setEnabled(true);
        dateEdit_End.setMinimumSize(new QSize(83, 25));
        dateEdit_End.setCalendarPopup(true);

        gridLayout.addWidget(dateEdit_End, 3, 5, 1, 1);

        detailsButton = new QPushButton(MainDialog);
        detailsButton.setObjectName("detailsButton");
        detailsButton.setEnabled(false);
        detailsButton.setMinimumSize(new QSize(101, 25));

        gridLayout.addWidget(detailsButton, 3, 7, 1, 2);

        lineHorizontal1 = new QFrame(MainDialog);
        lineHorizontal1.setObjectName("lineHorizontal1");
        lineHorizontal1.setMinimumSize(new QSize(101, 16));
        lineHorizontal1.setFrameShape(QFrame.Shape.HLine);
        lineHorizontal1.setFrameShadow(QFrame.Shadow.Sunken);

        gridLayout.addWidget(lineHorizontal1, 3, 10, 1, 1);

        label_Duration = new QLabel(MainDialog);
        label_Duration.setObjectName("label_Duration");
        label_Duration.setMinimumSize(new QSize(66, 25));
        QFont font5 = new QFont();
        font5.setPointSize(10);
        label_Duration.setFont(font5);

        gridLayout.addWidget(label_Duration, 4, 0, 1, 1);

        lineEdit_Duration = new QLineEdit(MainDialog);
        lineEdit_Duration.setObjectName("lineEdit_Duration");
        lineEdit_Duration.setMinimumSize(new QSize(87, 25));
        lineEdit_Duration.setFrame(false);
        lineEdit_Duration.setReadOnly(true);

        gridLayout.addWidget(lineEdit_Duration, 4, 1, 1, 1);

        label_Hours = new QLabel(MainDialog);
        label_Hours.setObjectName("label_Hours");
        label_Hours.setMinimumSize(new QSize(36, 25));
        QFont font6 = new QFont();
        font6.setPointSize(10);
        label_Hours.setFont(font6);

        gridLayout.addWidget(label_Hours, 4, 3, 1, 1);

        deleteCourseButton = new QPushButton(MainDialog);
        deleteCourseButton.setObjectName("deleteCourseButton");
        deleteCourseButton.setEnabled(false);
        deleteCourseButton.setMinimumSize(new QSize(101, 25));

        gridLayout.addWidget(deleteCourseButton, 4, 10, 1, 1);

        label_Place = new QLabel(MainDialog);
        label_Place.setObjectName("label_Place");
        label_Place.setMinimumSize(new QSize(66, 25));
        QFont font7 = new QFont();
        font7.setPointSize(10);
        label_Place.setFont(font7);

        gridLayout.addWidget(label_Place, 5, 0, 1, 1);

        comboBox_Ort = new QComboBox(MainDialog);
        comboBox_Ort.setObjectName("comboBox_Ort");
        comboBox_Ort.setMinimumSize(new QSize(111, 25));
        QFont font8 = new QFont();
        font8.setPointSize(8);
        comboBox_Ort.setFont(font8);
        comboBox_Ort.setEditable(false);

        gridLayout.addWidget(comboBox_Ort, 5, 1, 1, 1);

        loadCourseButton = new QPushButton(MainDialog);
        loadCourseButton.setObjectName("loadCourseButton");
        loadCourseButton.setMinimumSize(new QSize(101, 25));

        gridLayout.addWidget(loadCourseButton, 5, 10, 1, 1);

        label_Price = new QLabel(MainDialog);
        label_Price.setObjectName("label_Price");
        label_Price.setMinimumSize(new QSize(66, 25));
        QFont font9 = new QFont();
        font9.setPointSize(10);
        label_Price.setFont(font9);

        gridLayout.addWidget(label_Price, 6, 0, 1, 1);

        comboBox_Price = new QComboBox(MainDialog);
        comboBox_Price.setObjectName("comboBox_Price");
        comboBox_Price.setEnabled(true);
        comboBox_Price.setMinimumSize(new QSize(111, 25));
        QFont font10 = new QFont();
        font10.setPointSize(8);
        comboBox_Price.setFont(font10);
        comboBox_Price.setEditable(false);
        comboBox_Price.setFrame(true);

        gridLayout.addWidget(comboBox_Price, 6, 1, 1, 1);

        label_Price_2 = new QLabel(MainDialog);
        label_Price_2.setObjectName("label_Price_2");
        label_Price_2.setMinimumSize(new QSize(31, 25));
        QFont font11 = new QFont();
        font11.setPointSize(10);
        label_Price_2.setFont(font11);
        label_Price_2.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.RightToLeft);

        gridLayout.addWidget(label_Price_2, 6, 4, 1, 1);

        lineEdit_Price = new QLineEdit(MainDialog);
        lineEdit_Price.setObjectName("lineEdit_Price");
        lineEdit_Price.setMinimumSize(new QSize(51, 25));
        lineEdit_Price.setMaximumSize(new QSize(81, 25));
        lineEdit_Price.setFrame(false);
        lineEdit_Price.setReadOnly(true);

        gridLayout.addWidget(lineEdit_Price, 6, 5, 1, 1);

        label_Currency = new QLabel(MainDialog);
        label_Currency.setObjectName("label_Currency");
        label_Currency.setMinimumSize(new QSize(21, 25));
        QFont font12 = new QFont();
        font12.setPointSize(10);
        label_Currency.setFont(font12);

        gridLayout.addWidget(label_Currency, 6, 6, 1, 1);

        editshowPriceButton = new QPushButton(MainDialog);
        editshowPriceButton.setObjectName("editshowPriceButton");
        editshowPriceButton.setEnabled(false);
        editshowPriceButton.setMinimumSize(new QSize(101, 25));

        gridLayout.addWidget(editshowPriceButton, 6, 7, 1, 2);

        lineHorizontal2 = new QFrame(MainDialog);
        lineHorizontal2.setObjectName("lineHorizontal2");
        lineHorizontal2.setFrameShape(QFrame.Shape.HLine);
        lineHorizontal2.setFrameShadow(QFrame.Shadow.Sunken);

        gridLayout.addWidget(lineHorizontal2, 6, 10, 1, 1);

        label_Description = new QLabel(MainDialog);
        label_Description.setObjectName("label_Description");
        label_Description.setMinimumSize(new QSize(66, 31));
        QFont font13 = new QFont();
        font13.setPointSize(10);
        label_Description.setFont(font13);

        gridLayout.addWidget(label_Description, 7, 0, 1, 1);

        textEdit_Description = new QTextEdit(MainDialog);
        textEdit_Description.setObjectName("textEdit_Description");
        textEdit_Description.setMinimumSize(new QSize(401, 84));

        gridLayout.addWidget(textEdit_Description, 7, 1, 2, 8);

        saveCourseButton = new QPushButton(MainDialog);
        saveCourseButton.setObjectName("saveCourseButton");
        saveCourseButton.setEnabled(true);
        saveCourseButton.setMinimumSize(new QSize(101, 25));

        gridLayout.addWidget(saveCourseButton, 7, 10, 1, 1);

        clearCourseButton = new QPushButton(MainDialog);
        clearCourseButton.setObjectName("clearCourseButton");
        clearCourseButton.setEnabled(true);
        clearCourseButton.setMinimumSize(new QSize(101, 25));
        clearCourseButton.setSizeIncrement(new QSize(2, 2));

        gridLayout.addWidget(clearCourseButton, 8, 10, 1, 1);

        label_Literature = new QLabel(MainDialog);
        label_Literature.setObjectName("label_Literature");
        label_Literature.setMinimumSize(new QSize(66, 42));
        QFont font14 = new QFont();
        font14.setPointSize(10);
        label_Literature.setFont(font14);

        gridLayout.addWidget(label_Literature, 9, 0, 2, 1);

        listWidget_Literature = new QListWidget(MainDialog);
        listWidget_Literature.setObjectName("listWidget_Literature");
        listWidget_Literature.setMinimumSize(new QSize(310, 91));
        QFont font15 = new QFont();
        font15.setPointSize(8);
        listWidget_Literature.setFont(font15);
        listWidget_Literature.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        listWidget_Literature.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);

        gridLayout.addWidget(listWidget_Literature, 9, 1, 3, 7);

        line_Horizontal3 = new QFrame(MainDialog);
        line_Horizontal3.setObjectName("line_Horizontal3");
        line_Horizontal3.setMinimumSize(new QSize(101, 16));
        line_Horizontal3.setFrameShape(QFrame.Shape.HLine);
        line_Horizontal3.setFrameShadow(QFrame.Shadow.Sunken);

        gridLayout.addWidget(line_Horizontal3, 9, 10, 1, 1);

        addLiteratureButton = new QPushButton(MainDialog);
        addLiteratureButton.setObjectName("addLiteratureButton");
        addLiteratureButton.setEnabled(false);
        addLiteratureButton.setMinimumSize(new QSize(81, 25));

        gridLayout.addWidget(addLiteratureButton, 10, 8, 1, 1);

        generateHTMLButton = new QPushButton(MainDialog);
        generateHTMLButton.setObjectName("generateHTMLButton");
        generateHTMLButton.setEnabled(false);
        generateHTMLButton.setMinimumSize(new QSize(101, 25));

        gridLayout.addWidget(generateHTMLButton, 10, 10, 1, 1);

        deleteLiteratureButton = new QPushButton(MainDialog);
        deleteLiteratureButton.setObjectName("deleteLiteratureButton");
        deleteLiteratureButton.setEnabled(false);
        deleteLiteratureButton.setMinimumSize(new QSize(81, 25));

        gridLayout.addWidget(deleteLiteratureButton, 11, 8, 1, 1);

        addPlaceButton = new QPushButton(MainDialog);
        addPlaceButton.setObjectName("addPlaceButton");
        addPlaceButton.setEnabled(false);
        addPlaceButton.setMinimumSize(new QSize(101, 25));
        addPlaceButton.setMaximumSize(new QSize(135, 16777215));

        gridLayout.addWidget(addPlaceButton, 5, 4, 1, 1);

        label_Title.setBuddy(lineEdit_Titel);
        label_Prof.setBuddy(lineEdit_Prof);
        label_Place.setBuddy(comboBox_Ort);
        label_Price.setBuddy(comboBox_Price);
        label_Literature.setBuddy(listWidget_Literature);
        retranslateUi(MainDialog);
        buttonBox_OK_Cancel.clicked.connect(MainDialog, "close()");

        MainDialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog MainDialog)
    {
        MainDialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "Workshop Administration", null));
        label_Title.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "Title", null));
        lineEdit_Titel.setText("");
        label_Prof.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "Lecturer", null));
        lineEdit_Prof.setText("");
        label_Participants.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "Participants", null));
        editshowPartButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "edit/show", null));
        label_From.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "From", null));
        label_To.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "to", null));
        detailsButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "details...", null));
        label_Duration.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "Duration", null));
        label_Hours.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "hours", null));
        deleteCourseButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "Delete Course", null));
        label_Place.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "Place", null));
        comboBox_Ort.clear();
        comboBox_Ort.addItem(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "Jordan-H\u00f6rsaal", null));
        comboBox_Ort.addItem(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "Sky-H\u00f6rsaal", null));
        comboBox_Ort.addItem(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "Haid-H\u00f6rsaal", null));
        loadCourseButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "Load...", null));
        label_Price.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "Category", null));
        label_Price_2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "Price", null));
        lineEdit_Price.setText("");
        label_Currency.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "\u20ac", null));
        editshowPriceButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "edit/show", null));
        label_Description.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "Description", null));
        textEdit_Description.setHtml(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt;\"></p></body></html>", null));
        saveCourseButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "Save", null));
        clearCourseButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "Clear", null));
        label_Literature.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "Literature", null));
        addLiteratureButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "add", null));
        generateHTMLButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "To HTML", null));
        deleteLiteratureButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "delete", null));
        addPlaceButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainDialog", "add", null));
    } // retranslateUi

}

