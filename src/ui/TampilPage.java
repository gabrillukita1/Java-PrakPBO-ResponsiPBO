
package ui;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


public class TampilPage extends JFrame{
    public JLabel jlperpustakaan = new JLabel("PERPUSTAKAAN");
    
    public JButton jbhapus = new JButton("Hapus");
    public JButton jbedit = new JButton("Edit");
    
    public JLabel jllist = new JLabel("LIST BUKU YANG DIPINJAM");
    
    public JButton jblogout = new JButton("LOGOUT");
    public JButton jbtambah = new JButton("Tambah");
    public JButton jbbatal = new JButton("Batal");
    public JButton jbhome = new JButton("Home");
    public JButton jbpinjam = new JButton("Pinjam");
    public JButton jbabout_us = new JButton("About Us");
    public JButton jbtampil = new JButton("Tampil");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"ID","Nama", "ID Buku", "Judul Buku"};
    
    public TampilPage(){
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("PERPUSTAKAAN");
        setLayout(null);
        setSize(500,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(jblogout);
        jblogout.setBounds(380, 20, 90, 40);
        
        add(jlperpustakaan);
        jlperpustakaan.setBounds(150, 50, 110, 20);
        
        add(jbhapus);
        jbhapus.setBounds(100, 90, 90, 20);
        add(jbedit);
        jbedit.setBounds(205, 90, 90, 20);
        
        add(jllist);
        jllist.setBounds(120, 130, 200, 20);
        
        add(scrollPane);
        scrollPane.setBounds(20, 170, 350, 175);        
        
        add(jbhome);
        jbhome.setBounds(380, 100, 90, 40);
        add(jbpinjam);
        jbpinjam.setBounds(380, 150, 90, 40);
        add(jbtampil);
        jbtampil.setBounds(380, 200, 90, 40);
        add(jbabout_us);
        jbabout_us.setBounds(380, 250, 90, 40);
    }
    
    
}