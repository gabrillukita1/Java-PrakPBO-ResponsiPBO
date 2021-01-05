package controller;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.ModelAccount;
import model.ModelTransaction;
import ui.DaftarPage;
import ui.LoginPage;

public class ControllerDaftar {

    ModelAccount modelAccount;
    DaftarPage daftarPage;
    ModelTransaction modelTransaction;

    public ControllerDaftar(DaftarPage daftarPage, ModelAccount modelAccount, ModelTransaction modelTransaction) {
        this.modelTransaction = modelTransaction;
        this.modelAccount = modelAccount;
        this.daftarPage = daftarPage;

        daftarPage.jbdaftar.addActionListener((ActionEvent e) -> {
            String username = daftarPage.jtusername.getText();
            String password = daftarPage.jtpassword.getText();

            if (username.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Form tidak boleh kosong");
            } else {
                modelAccount.insertAccounts(username, password);
            }
        });

        daftarPage.jbbatal.addActionListener((ActionEvent e) -> {
            LoginPage loginPage = new LoginPage();
            ControllerLogin controllerLogin = new ControllerLogin(loginPage, modelAccount, modelTransaction);
            daftarPage.setVisible(false);
            daftarPage.dispose();
            loginPage.setVisible(true);
        });

        daftarPage.jbexit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }
}
