
package ui;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EditPage extends JFrame{
    public JLabel jlperpustakaan = new JLabel("PERPUSTAKAAN");
    public JLabel jlid_anggota = new JLabel  ("ID Anggota : ");
    public JTextField jtid_anggota = new JTextField();
    public JLabel jlid_buku = new JLabel     ("ID Buku    : ");
    public JTextField jtid_buku = new JTextField();
    public JLabel jlnama = new JLabel        ("Nama       : ");
    public JTextField jtnama = new JTextField();
    public JLabel jljudul_buku = new JLabel  ("Judul Buku : ");
    public JLabel jtjudul_buku = new JLabel();
    
    public JButton jbbatal = new JButton("Batal");
    public JButton jbedit = new JButton("Edit");
    
    public EditPage(){
        setTitle("PERPUSTAKAAN");
        setLayout(null);
        setSize(500,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
                
        add(jlperpustakaan);
        jlperpustakaan.setBounds(220, 50, 120, 20);
        
        add(jlid_anggota);
        jlid_anggota.setBounds(100, 100, 90, 20);
        add(jtid_anggota);
        jtid_anggota.setBounds(180, 100, 165, 20);
        add(jlnama);
        jlnama.setBounds(100, 140, 90, 20);
        add(jtnama);
        jtnama.setBounds(180, 140, 165, 20);
        add(jlid_buku);
        jlid_buku.setBounds(100, 180, 90, 20);
        add(jtid_buku);
        jtid_buku.setBounds(180, 180, 165, 20);
        add(jljudul_buku);
        jljudul_buku.setBounds(100, 220, 90, 20);
        add(jtjudul_buku);
        jtjudul_buku.setBounds(180, 220, 165, 20);
        
        add(jbbatal);
        jbbatal.setBounds(150, 280, 90, 20);
        add(jbedit);
        jbedit.setBounds(255, 280, 90, 20);
    }
    
    public String getID_Anggota(){
        return jtid_anggota.getText();
    }
    
    public String getNama(){
        return jtnama.getText();
    }
    
    public String getID_Buku(){
        return jtid_buku.getText();
    }
    
    public String getJudul(){
        return jtjudul_buku.getText();
    }
}