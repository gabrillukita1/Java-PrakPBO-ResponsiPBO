/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelAccount {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/responsi_perpus";
    static final String USER = "root";
    static final String PASS = "";
    Connection koneksi;
    Statement statement;

    public ModelAccount() {
        try {
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public void insertAccounts(String username, String password) {
        int jmlData = 0;
        try {

            String query = "Select * from accounts WHERE username=" + "\"" + username + "\"";
            statement = (Statement) koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                jmlData++;
            }

            if (jmlData == 0) {
                query = "INSERT INTO accounts(username, password) VALUES ('" + username + "','" + password + "')";

                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Akun Berhasil ditambahkan");
            } else {
                JOptionPane.showMessageDialog(null, "Username telah terdaftar");
            }
        } catch (Exception sql) {
            System.out.println("error:" + sql.getMessage());
        }
    }

    boolean state = false;

    public void login(String username, String password) {
        int jmlData = 0;
        try {
            String query = "Select * from accounts where username =" + "\"" + username + "\"";
            statement = (Statement) koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String queryUser = "";
            String queryPassword = "";
            while (resultSet.next()) {
                queryUser = resultSet.getString("Username");
                queryPassword = resultSet.getString("Password");
                jmlData++;
            }
            
            if (jmlData == 0) {
                JOptionPane.showMessageDialog(null, "username belum terdaftar");
            } else {
                if (password.equals(queryPassword)) {
                    state = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Password tidak sesuai");
                }

            }
        } catch (SQLException sql) {
            System.out.println("error : " + sql.getMessage());
        }
    }

    public boolean isLoginSuccess() {
        return state;
    }

   
}
