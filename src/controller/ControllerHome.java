
package controller;

import java.awt.event.ActionEvent;
import model.ModelAccount;
import model.ModelTransaction;
import ui.AboutUsPage;
import ui.HomePage;
import ui.LoginPage;
import ui.PinjamPage;
import ui.TampilPage;

public class ControllerHome {
    HomePage homePage;
    ModelAccount modelAccount;
    ModelTransaction modelTransaction;

    public ControllerHome(HomePage homePage, ModelAccount modelAccount, ModelTransaction modelTransaction) {
        this.homePage = homePage;
        this.modelAccount = modelAccount;
        this.modelTransaction = modelTransaction;
        
        homePage.jbabout_us.addActionListener((ActionEvent e)->{
            AboutUsPage aboutUsPage = new AboutUsPage();
            ControllerAboutUs controller = new ControllerAboutUs(aboutUsPage,modelAccount,modelTransaction);
            homePage.setVisible(false);
            aboutUsPage.setVisible(true);
            homePage.dispose();
        });
        
        homePage.jbpinjam.addActionListener((ActionEvent e)->{
            PinjamPage pinjamPage = new PinjamPage();
            ControllerPinjam controllerPinjam = new ControllerPinjam(pinjamPage,modelAccount,modelTransaction);
            homePage.setVisible(false);
            pinjamPage.setVisible(true);
            homePage.dispose();
        });
        
        homePage.jbtampil.addActionListener((ActionEvent e)->{
            TampilPage tampilPage = new TampilPage();
            ControllerTampil controllerTampil = new ControllerTampil(tampilPage,modelAccount, modelTransaction);
            homePage.setVisible(false);
            tampilPage.setVisible(true);
            homePage.dispose();
        });
        
        homePage.jblogout.addActionListener((ActionEvent e)->{
            LoginPage loginPage= new LoginPage();
            ControllerLogin controllerLogin = new ControllerLogin(loginPage, modelAccount, modelTransaction);
            loginPage.setVisible(true);
            homePage.setVisible(false);
            homePage.dispose();
        });
    }   
}
