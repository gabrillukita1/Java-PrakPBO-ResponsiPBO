package controller;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.ModelAccount;
import model.ModelTransaction;
import ui.EditPage;
import ui.TampilPage;

public class ControllerEdit {

    ModelTransaction modelTransaction;
    ModelAccount modelAccount;
    EditPage editPage;

    public ControllerEdit(
            EditPage editPage,
            ModelAccount modelAccount,
            ModelTransaction modelTransaction,
            String memberId,
            String memberName,
            String bookId,
            String bookName) {

        this.editPage = editPage;
        this.modelTransaction = modelTransaction;
        this.modelAccount = modelAccount;
        editPage.jtjudul_buku.setText(bookName);
        editPage.jtid_anggota.setText(memberId);
        editPage.jtid_anggota.enableInputMethods(false);
        editPage.jtnama.setText(memberName);
        editPage.jtid_buku.setText(bookId);

        editPage.jbedit.addActionListener((ActionEvent e) -> {
            String newBookName = editPage.jtjudul_buku.getText();
            String newMemberName = editPage.jtnama.getText();

            if (newBookName.isEmpty() && newMemberName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Form tidak boleh kosong");
            } else {
                modelTransaction.updateTransaction(memberId, newMemberName, bookId, newBookName);
                TampilPage tampilPage = new TampilPage();
                ControllerTampil controllerTampil = new ControllerTampil(tampilPage, modelAccount, modelTransaction);
                tampilPage.setVisible(true);
                editPage.setVisible(false);
                editPage.dispose();
            }

        });

        editPage.jbbatal.addActionListener((ActionEvent e) -> {
            TampilPage tampilPage = new TampilPage();
            ControllerTampil controllerTampil = new ControllerTampil(tampilPage, modelAccount, modelTransaction);
            tampilPage.setVisible(true);
            editPage.setVisible(false);
            editPage.dispose();
        });
    }

}
