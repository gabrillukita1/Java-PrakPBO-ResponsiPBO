package ui;

import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LoginPage extends JFrame {

    public JLabel jllogin = new JLabel("LOGIN");
    public JLabel jlusername = new JLabel("Username : ");
    public JTextField jtusername = new JTextField();
    public JLabel jlpassword = new JLabel("Password : ");
    public JTextField jtpassword = new JTextField();

    public JButton jbdaftar = new JButton("DAFTAR");
    public JButton jblogin = new JButton("LOGIN");
    public JButton jbexit = new JButton("EXIT");

    public LoginPage() {
        setTitle("PERPUSTAKAAN");
        setLayout(null);
        setSize(500, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(jbexit);
        jbexit.setBounds(380, 20, 90, 20);

        add(jllogin);
        jllogin.setBounds(220, 50, 90, 20);
        add(jlusername);
        jlusername.setBounds(100, 130, 90, 20);
        add(jtusername);
        jtusername.setBounds(180, 130, 165, 20);
        add(jlpassword);
        jlpassword.setBounds(100, 170, 90, 20);
        add(jtpassword);
        jtpassword.setBounds(180, 170, 165, 20);

        add(jblogin);
        jblogin.setBounds(150, 280, 90, 20);
        add(jbdaftar);
        jbdaftar.setBounds(255, 280, 90, 20);
    }

    public String getUsername() {
        return jtusername.getText();
    }

    public String getPassword() {
        return jtpassword.getText();
    }
}
