package controller;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.ModelAccount;
import model.ModelTransaction;
import ui.HomePage;
import ui.LoginPage;
import ui.DaftarPage;

public class ControllerLogin {

    ModelAccount modelAccount;
    LoginPage loginPage;
    ModelTransaction modelTransaction;

    public ControllerLogin(LoginPage loginPage, ModelAccount modelAccount, ModelTransaction modelTransaction) {
        this.modelAccount = modelAccount;
        this.loginPage = loginPage;

        loginPage.jblogin.addActionListener((ActionEvent e) -> {
            String username = loginPage.jtusername.getText();
            String password = loginPage.jtpassword.getText();

            if (username.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Form tidak boleh kosong");
            } else {
                modelAccount.login(username, password);
                if (modelAccount.isLoginSuccess()) {
                    HomePage homePage = new HomePage();
                    ControllerHome controllerHome = new ControllerHome(homePage, modelAccount, modelTransaction);
                    loginPage.setVisible(false);
                    homePage.setVisible(true);
                    loginPage.dispose();
                }
            }
        });

        loginPage.jbdaftar.addActionListener((ActionEvent e) -> {
            DaftarPage daftarPage = new DaftarPage();
            ControllerDaftar controllerDaftar = new ControllerDaftar(daftarPage, modelAccount, modelTransaction);
            daftarPage.setVisible(true);
            loginPage.setVisible(false);
            loginPage.dispose();
        });

        loginPage.jbexit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }
}
