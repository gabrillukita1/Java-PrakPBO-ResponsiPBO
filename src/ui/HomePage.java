
package ui;



import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 *
 * @author user
 */

public class HomePage extends JFrame{
    public JLabel jlperpustakaan = new JLabel("PERPUSTAKAAN");
    public JLabel jlwelcome = new JLabel("WELCOME TO PERPUSTAKAAN");
    
    public JButton jblogout = new JButton("LOGOUT");
    public JButton jbtambah = new JButton("Tambah");
    public JButton jbbatal = new JButton("Batal");
    public JButton jbhome = new JButton("Home");
    public JButton jbpinjam = new JButton("Pinjam");
    public JButton jbabout_us = new JButton("About Us");
    public JButton jbtampil = new JButton("Tampil");
    
    public HomePage(){
        setTitle("PERPUSTAKAAN");
        setLayout(null);
        setSize(500,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(jblogout);
        jblogout.setBounds(380, 20, 90, 40);
        
        add(jlperpustakaan);
        jlperpustakaan.setBounds(190, 50, 110, 20);
        add(jlwelcome);
        jlwelcome.setBounds(150, 160, 200, 20);
            
        add(jbhome);
        jbhome.setBounds(30, 100, 90, 40);
        add(jbpinjam);
        jbpinjam.setBounds(30, 150, 90, 40);
        add(jbtampil);
        jbtampil.setBounds(30, 200, 90, 40);
        add(jbabout_us);
        jbabout_us.setBounds(30, 250, 90, 40);  
    }
    
}