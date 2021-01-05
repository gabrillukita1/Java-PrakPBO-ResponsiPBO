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

public class ModelTransaction {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/responsi_perpus";
    static final String USER = "root";
    static final String PASS = "";
    Connection koneksi;
    Statement statement;

    public ModelTransaction() {
        try {
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public void insert(String Memberid, String Membername, String BookId, String Bookname) {
        int jmlData = 0;
        try {

            String query = "Select * from transactions WHERE Bookid=" + "\"" + BookId + "\"";
            statement = (Statement) koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                jmlData++;
            }

            if (jmlData == 0) {
                query = "INSERT INTO transactions(Memberid, Membername, Bookid, Bookname) VALUES ('" + Memberid + "','" + Membername + "',"
                        + "'" + BookId + "','" + Bookname + "')";

                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            } else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateTransaction(String memberId, String memberName, String bookId, String bookName) {
        int jmlData = 0;
        int id = 0;
        try {
            String query = "SELECT id FROM transactions WHERE MemberId=" + "\"" + memberId + "\"" + " AND " + "BookId=" + "\"" + bookId + "\"";
            System.out.println(query);
            statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
            query = "SELECT * FROM transactions";
            statement = koneksi.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                jmlData++;
            }

            if (jmlData == 1) {
               query = "UPDATE transactions SET MemberName= "+ "\""+memberName+"\""+",BookId ="+"\""+bookId+"\""+ " where id=" + "\""+id+"\"";
                System.out.println(query);
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }

        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public String[][] readTransactions() {
        try {
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][4]; //baris, kolom nya ada 3

            String query = "Select * from transactions";
            statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                data[jmlData][0] = resultSet.getString("MemberId"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("MemberName");
                data[jmlData][2] = resultSet.getString("BookId");
                data[jmlData][3] = resultSet.getString("BookName");
                jmlData++;
            }
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public int getBanyakData() {
        int jmlData = 0;
        try {
            statement = koneksi.createStatement();
            String query = "Select * from transactions";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                jmlData++;
            }
            return jmlData;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public void deleteTransaction(String memberId, String bookId) {
        int id = 0;
        try {
            String query = "SELECT id FROM transactions WHERE MemberId=" + "\"" + memberId + "\"" + " AND " + "BookId=" + "\"" + bookId + "\"";
            statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }

            query = "DELETE FROM transactions WHERE Id = '" + id + "'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
