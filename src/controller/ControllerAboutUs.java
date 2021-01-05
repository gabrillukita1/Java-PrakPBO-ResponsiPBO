package controller;

import java.awt.event.ActionEvent;
import model.ModelAccount;
import model.ModelTransaction;
import ui.AboutUsPage;
import ui.HomePage;
import ui.LoginPage;
import ui.PinjamPage;
import ui.TampilPage;

public class ControllerAboutUs {

    AboutUsPage aboutUsPage;
    ModelAccount modelAccount;
    ModelTransaction modelTransaction;

    public ControllerAboutUs(AboutUsPage aboutUsPage, ModelAccount modelAccount, ModelTransaction modelTransaction) {
        this.aboutUsPage = aboutUsPage;
        this.modelAccount = modelAccount;
        this.modelTransaction = modelTransaction;

        aboutUsPage.jbhome.addActionListener((ActionEvent e) -> {
            HomePage homePage = new HomePage();
            ControllerHome controllerHome = new ControllerHome(homePage, modelAccount, modelTransaction);
            homePage.setVisible(true);
            aboutUsPage.setVisible(false);
            aboutUsPage.dispose();
        });

        aboutUsPage.jbpinjam.addActionListener((ActionEvent e) -> {
            PinjamPage pinjamPage = new PinjamPage();
            ControllerPinjam controllerPinjam = new ControllerPinjam(pinjamPage,modelAccount, modelTransaction);
            aboutUsPage.setVisible(false);
            pinjamPage.setVisible(true);
            aboutUsPage.dispose();
        });

        aboutUsPage.jbtampil.addActionListener((ActionEvent e) -> {
            TampilPage tampilPage = new TampilPage();
            ControllerTampil controllerTampil = new ControllerTampil(tampilPage, modelAccount, modelTransaction);
            aboutUsPage.setVisible(false);
            tampilPage.setVisible(true);
            aboutUsPage.dispose();
        });

        aboutUsPage.jblogout.addActionListener((ActionEvent e) -> {
            LoginPage loginPage = new LoginPage();
            ControllerLogin controllerLogin = new ControllerLogin(loginPage, modelAccount, modelTransaction);
            aboutUsPage.setVisible(false);
            loginPage.setVisible(true);
            aboutUsPage.dispose();
        });

    }

}
