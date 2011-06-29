/********************************************************************************
** Form generated from reading ui file 'ParticipantsDialog.jui'
**
** Created: Di 28. Jun 21:57:15 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class ParticipantsDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGridLayout gridLayout;
    public QTreeWidget treeWidget;
    public QPushButton OKButton;
    public QPushButton addRealPartButton;
    public QPushButton deleteRealPartButton;
    public QPushButton CancelButton;

    public ParticipantsDialog() { super(); }

    public void setupUi(QDialog ParticipantsDialog)
    {
        ParticipantsDialog.setObjectName("ParticipantsDialog");
        ParticipantsDialog.resize(new QSize(552, 258).expandedTo(ParticipantsDialog.minimumSizeHint()));
        ParticipantsDialog.setMinimumSize(new QSize(552, 258));
        ParticipantsDialog.setWindowIcon(new QIcon(new QPixmap("logo_gik.png")));
        ParticipantsDialog.setModal(true);
        gridLayout = new QGridLayout(ParticipantsDialog);
        gridLayout.setObjectName("gridLayout");
        treeWidget = new QTreeWidget(ParticipantsDialog);
        treeWidget.setObjectName("treeWidget");
        treeWidget.setMinimumSize(new QSize(531, 192));
        treeWidget.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.DoubleClicked,com.trolltech.qt.gui.QAbstractItemView.EditTrigger.EditKeyPressed,com.trolltech.qt.gui.QAbstractItemView.EditTrigger.SelectedClicked));
        treeWidget.setIndentation(0);
        treeWidget.setRootIsDecorated(true);
        treeWidget.setUniformRowHeights(true);
        treeWidget.setItemsExpandable(false);
        treeWidget.setSortingEnabled(true);
        treeWidget.setAnimated(true);

        gridLayout.addWidget(treeWidget, 0, 0, 1, 5);

        OKButton = new QPushButton(ParticipantsDialog);
        OKButton.setObjectName("OKButton");
        OKButton.setMinimumSize(new QSize(91, 25));
        OKButton.setMaximumSize(new QSize(91, 25));

        gridLayout.addWidget(OKButton, 1, 0, 1, 1);

        addRealPartButton = new QPushButton(ParticipantsDialog);
        addRealPartButton.setObjectName("addRealPartButton");
        addRealPartButton.setMinimumSize(new QSize(91, 25));
        addRealPartButton.setMaximumSize(new QSize(91, 25));

        gridLayout.addWidget(addRealPartButton, 1, 3, 1, 1);

        deleteRealPartButton = new QPushButton(ParticipantsDialog);
        deleteRealPartButton.setObjectName("deleteRealPartButton");
        deleteRealPartButton.setMinimumSize(new QSize(91, 25));
        deleteRealPartButton.setMaximumSize(new QSize(91, 25));

        gridLayout.addWidget(deleteRealPartButton, 1, 4, 1, 1);

        CancelButton = new QPushButton(ParticipantsDialog);
        CancelButton.setObjectName("CancelButton");
        CancelButton.setMinimumSize(new QSize(91, 25));
        CancelButton.setMaximumSize(new QSize(91, 25));

        gridLayout.addWidget(CancelButton, 1, 1, 1, 1);

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
        OKButton.setText(com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "OK", null));
        addRealPartButton.setText(com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "add", null));
        deleteRealPartButton.setText(com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "delete", null));
        CancelButton.setText(com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "Cancel", null));
    } // retranslateUi

}

