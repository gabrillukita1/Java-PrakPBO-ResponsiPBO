package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.ModelAccount;
import model.ModelTransaction;
import ui.AboutUsPage;
import ui.EditPage;
import ui.HomePage;
import ui.LoginPage;
import ui.PinjamPage;
import ui.TampilPage;

public class ControllerTampil {

    TampilPage tampilPage;
    ModelTransaction modelTransaction;
    ModelAccount modelAccount;

    public ControllerTampil(TampilPage tampilPage, ModelAccount modelAccount, ModelTransaction modelTransaction) {
        this.tampilPage = tampilPage;
        this.modelTransaction = modelTransaction;
        this.modelAccount = modelAccount;

        tampilPage.jbedit.setEnabled(false);
        tampilPage.jbhapus.setEnabled(false);

        if (modelTransaction.getBanyakData() != 0) {
            String dataTransaction[][] = modelTransaction.readTransactions();
            tampilPage.tabel.setModel((new JTable(dataTransaction, tampilPage.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        tampilPage.jbpinjam.addActionListener((ActionEvent e) -> {
            PinjamPage pinjamPage = new PinjamPage();
            ControllerPinjam controllerPinjam = new ControllerPinjam(pinjamPage, modelAccount, modelTransaction);
            tampilPage.setVisible(false);
            pinjamPage.setVisible(true);
            tampilPage.dispose();
        });

        tampilPage.jbhome.addActionListener((ActionEvent e) -> {
            HomePage homePage = new HomePage();
            ControllerHome controllerHome = new ControllerHome(homePage, modelAccount, modelTransaction);
            tampilPage.setVisible(false);
            homePage.setVisible(true);
            tampilPage.dispose();
        });

        tampilPage.jblogout.addActionListener((ActionEvent e) -> {
            LoginPage loginPage = new LoginPage();
            ControllerLogin controllerLogin = new ControllerLogin(loginPage, modelAccount, modelTransaction);
            loginPage.setVisible(true);
            tampilPage.setVisible(false);
            tampilPage.dispose();
        });

        tampilPage.jbabout_us.addActionListener((ActionEvent e) -> {
            AboutUsPage aboutUsPage = new AboutUsPage();
            ControllerAboutUs controller = new ControllerAboutUs(aboutUsPage, modelAccount, modelTransaction);
            tampilPage.setVisible(false);
            aboutUsPage.setVisible(true);
            tampilPage.dispose();
        });

        tampilPage.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = tampilPage.tabel.getSelectedRow();

                String idAnggotaTerpilih = tampilPage.tabel.getValueAt(baris, 0).toString();
                String namaAnggotaTerpilih = tampilPage.tabel.getValueAt(baris, 1).toString();
                String idBukuTerpilih = tampilPage.tabel.getValueAt(baris, 2).toString();
                String judulBukuTerpilih = tampilPage.tabel.getValueAt(baris, 3).toString();

                tampilPage.jbedit.setEnabled(true);
                tampilPage.jbhapus.setEnabled(true);

                tampilPage.jbedit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        EditPage editPage = new EditPage();
                        ControllerEdit controllerEdit = new ControllerEdit(editPage, modelAccount, modelTransaction, idAnggotaTerpilih, namaAnggotaTerpilih, idBukuTerpilih, judulBukuTerpilih);
                        editPage.setVisible(true);
                        tampilPage.setVisible(false);
                        tampilPage.dispose();
                    }
                });

                tampilPage.jbhapus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int input = JOptionPane.showConfirmDialog(null,
                                "Yakin?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                        if (input == 0) {
                            modelTransaction.deleteTransaction(idAnggotaTerpilih, idBukuTerpilih);
                            String data[][] = modelTransaction.readTransactions();
                            tampilPage.tabel.setModel(new JTable(data, tampilPage.namaKolom).getModel());
                        } else {
                            JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                        }
                    }
                });

            }
        });
    }

}
