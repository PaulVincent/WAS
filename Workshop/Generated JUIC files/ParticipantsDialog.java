/********************************************************************************
** Form generated from reading ui file 'ParticipantsDialog.jui'
**
** Created: Sa 25. Jun 18:01:23 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class ParticipantsDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDialogButtonBox buttonBox_OK_Cancel;
    public QTreeWidget treeWidget;
    public QPushButton addRealPartButton;
    public QPushButton deleteRealPartButton;

    public ParticipantsDialog() { super(); }

    public void setupUi(QDialog ParticipantsDialog)
    {
        ParticipantsDialog.setObjectName("ParticipantsDialog");
        ParticipantsDialog.resize(new QSize(452, 258).expandedTo(ParticipantsDialog.minimumSizeHint()));
        ParticipantsDialog.setWindowIcon(new QIcon(new QPixmap("logo_gik.png")));
        ParticipantsDialog.setModal(true);
        buttonBox_OK_Cancel = new QDialogButtonBox(ParticipantsDialog);
        buttonBox_OK_Cancel.setObjectName("buttonBox_OK_Cancel");
        buttonBox_OK_Cancel.setGeometry(new QRect(61, 220, 160, 20));
        buttonBox_OK_Cancel.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.TabFocus);
        buttonBox_OK_Cancel.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        buttonBox_OK_Cancel.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));
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
        addRealPartButton.setGeometry(new QRect(227, 220, 77, 20));
        deleteRealPartButton = new QPushButton(ParticipantsDialog);
        deleteRealPartButton.setObjectName("deleteRealPartButton");
        deleteRealPartButton.setGeometry(new QRect(310, 220, 81, 20));
        retranslateUi(ParticipantsDialog);
        buttonBox_OK_Cancel.clicked.connect(ParticipantsDialog, "close()");

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
        treeWidget.clear();

        QTreeWidgetItem __item = new QTreeWidgetItem(treeWidget);
        __item.setText(0, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "2", null));
        __item.setText(1, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "Stefanie", null));
        __item.setText(2, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "Schmidt", null));
        __item.setText(3, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "19.05.2011", null));
        __item.setText(4, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "40", null));
        __item.setText(5, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "Ja", null));

        QTreeWidgetItem __item1 = new QTreeWidgetItem(treeWidget);
        __item1.setText(0, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "1", null));
        __item1.setText(1, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "Peter", null));
        __item1.setText(2, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "M\u00fcller", null));
        __item1.setText(3, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "29.05.2011", null));
        __item1.setText(4, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "50", null));
        __item1.setText(5, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "Nein", null));

        QTreeWidgetItem __item2 = new QTreeWidgetItem(treeWidget);
        __item2.setText(0, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "0", null));
        __item2.setText(1, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "Andr\u00e9", null));
        __item2.setText(2, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "Dittrich", null));
        __item2.setText(3, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "27.05.2011", null));
        __item2.setText(4, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "40", null));
        __item2.setText(5, com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "Ja", null));
        addRealPartButton.setText(com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "add", null));
        deleteRealPartButton.setText(com.trolltech.qt.core.QCoreApplication.translate("ParticipantsDialog", "delete", null));
    } // retranslateUi

}

