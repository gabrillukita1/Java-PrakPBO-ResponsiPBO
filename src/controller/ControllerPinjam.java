package controller;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.ModelTransaction;
import model.ModelAccount;
import ui.AboutUsPage;
import ui.HomePage;
import ui.LoginPage;
import ui.PinjamPage;
import ui.TampilPage;

public class ControllerPinjam {

    PinjamPage pinjamPage;
    ModelTransaction modelTransaction;
    ModelAccount modelAccount;

    public ControllerPinjam(PinjamPage pinjamPage, ModelAccount modelAccount, ModelTransaction modelTransaction) {
        this.pinjamPage = pinjamPage;
        this.modelTransaction = modelTransaction;
        this.modelAccount = modelAccount;

        pinjamPage.jbhome.addActionListener((ActionEvent e) -> {
            HomePage homePage = new HomePage();
            ControllerHome controllerHome = new ControllerHome(homePage, modelAccount, modelTransaction);
            homePage.setVisible(true);
            pinjamPage.setVisible(false);
            pinjamPage.dispose();
        });

        pinjamPage.jbtampil.addActionListener((ActionEvent e) -> {
            TampilPage tampilPage = new TampilPage();
            ControllerTampil controllerTampil = new ControllerTampil(tampilPage, modelAccount, modelTransaction);
            pinjamPage.setVisible(false);
            tampilPage.setVisible(true);
            pinjamPage.dispose();
        });

        pinjamPage.jbabout_us.addActionListener((ActionEvent e) -> {
            AboutUsPage aboutUsPage = new AboutUsPage();
            ControllerAboutUs controller = new ControllerAboutUs(aboutUsPage, modelAccount, modelTransaction);
            pinjamPage.setVisible(false);
            aboutUsPage.setVisible(true);
            pinjamPage.dispose();
        });

        pinjamPage.jblogout.addActionListener((ActionEvent e) -> {
            LoginPage loginPage = new LoginPage();
            ControllerLogin controllerLogin = new ControllerLogin(loginPage, modelAccount, modelTransaction);
            loginPage.setVisible(true);
            pinjamPage.setVisible(false);
            pinjamPage.dispose();
        });

        pinjamPage.jbtambah.addActionListener((ActionEvent e) -> {
            String idAnggota = pinjamPage.jtid_anggota.getText();
            String nama = pinjamPage.jtnama.getText();
            String idBuku = pinjamPage.jtid_buku.getText();
            String judulBuku = pinjamPage.jtjudul_buku.getText();

            if (idAnggota.isEmpty() && nama.isEmpty() && idBuku.isEmpty() && judulBuku.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Form tidak boleh kosong");
            } else {
                modelTransaction.insert(idAnggota, nama, idBuku, judulBuku);
                TampilPage tampilPage = new TampilPage();
                ControllerTampil controllerTampil = new ControllerTampil(tampilPage, modelAccount, modelTransaction);
                pinjamPage.setVisible(false);
                tampilPage.setVisible(true);
                pinjamPage.dispose();
            }
        });

        pinjamPage.jbbatal.addActionListener((ActionEvent e) -> {
            HomePage homePage = new HomePage();
            ControllerHome controllerHome = new ControllerHome(homePage, modelAccount, modelTransaction);
            pinjamPage.setVisible(false);
            homePage.setVisible(true);
            pinjamPage.dispose();
        });

    }
}
