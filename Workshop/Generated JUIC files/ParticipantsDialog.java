/********************************************************************************
** Form generated from reading ui file 'ParticipantsDialog.jui'
**
** Created: So 26. Jun 23:12:49 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class ParticipantsDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QTreeWidget treeWidget;
    public QPushButton addRealPartButton;
    public QPushButton deleteRealPartButton;
    public QPushButton OKButton;
    public QPushButton CancelButton;

    public ParticipantsDialog() { super(); }

    public void setupUi(QDialog ParticipantsDialog)
    {
        ParticipantsDialog.setObjectName("ParticipantsDialog");
        ParticipantsDialog.resize(new QSize(452, 258).expandedTo(ParticipantsDialog.minimumSizeHint()));
        ParticipantsDialog.setWindowIcon(new QIcon(new QPixmap("logo_gik.png")));
        ParticipantsDialog.setModal(true);
        treeWidget = new QTreeWidget(ParticipantsDialog);
        treeWidget.setObjectName("treeWidget");
        treeWidget.setGeometry(new QRect(10, 10, 431, 192));
        treeWidget.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.DoubleClicked,com.trolltech.qt.gui.QAbstractItemView.EditTrigger.EditKeyPressed,com.trolltech.qt.gui.QAbstractItemView.EditTrigger.SelectedClicked));
        treeWidget.setIndentation(0);
        treeWidget.setRootIsDecorated(true);
        treeWidget.setUniformRowHeights(true);
        treeWidget.setItemsExpandable(false);
        treeWidget.setSortingEnabled(true);
        treeWidget.setAnimated(true);
        addRealPartButton = new QPushButton(ParticipantsDialog);
        addRealPartButton.setObjectName("addRealPartButton");
        addRealPartButton.setGeometry(new QRect(230, 220, 77, 20));
        deleteRealPartButton = new QPushButton(ParticipantsDialog);
        deleteRealPartButton.setObjectName("deleteRealPartButton");
        deleteRealPartButton.setGeometry(new QRect(310, 220, 77, 20));
        OKButton = new QPushButton(ParticipantsDialog);
        OKButton.setObjectName("OKButton");
        OKButton.setGeometry(new QRect(50, 220, 77, 20));
        CancelButton = new QPushButton(ParticipantsDialog);
        CancelButton.setObjectName("CancelButton");
        CancelButton.setGeometry(new QRect(130, 220, 77, 20));
        retranslateUi(ParticipantsDialog);
        CancelButton.clicked.connect(ParticipantsDialog, "close()");

        ParticipantsDialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog ParticipantsDialog)
    {
        ParticipantsDialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "Participants", null));
        treeWidget.headerItem().setText(0, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "ID", null));
        treeWidget.headerItem().setText(1, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "Name", null));
        treeWidget.headerItem().setText(2, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "Nachname", null));
        treeWidget.headerItem().setText(3, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "Anmeldedatum", null));
        treeWidget.headerItem().setText(4, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "Preis", null));
        treeWidget.headerItem().setText(5, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "Bezahlt", null));
        addRealPartButton.setText(com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "add", null));
        deleteRealPartButton.setText(com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "delete", null));
        OKButton.setText(com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "OK", null));
        CancelButton.setText(com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "Cancel", null));
    } // retranslateUi

}

