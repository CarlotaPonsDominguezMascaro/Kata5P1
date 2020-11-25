/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author carlotapons
 */
public class Kata5P1 {

    /**
     * @param args the command line arguments
     */
    private static final String filename = "email.txt";
    private static List<String> mailList;
    private final static String url = "jdbc:sqlite:/Users/carlotapons/Documents/Universidades/4_curso/Is2/Kata5P1/Kata5.db";
    private static Connection conn;

    public static void main(String[] args) throws IOException, SQLException {
        // TODO code application logic here
        
        ConectarYCrear();
        mailList = MailListReader.read(filename);
        String sql = "INSERT INTO direcc_email(Mail) VALUES(?)";
        
        try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < mailList.size(); i++) {

                pstmt.setString(1, mailList.get(i));
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void ConectarYCrear() throws IOException {
        ConectarBD con = new ConectarBD();
        con.selectAll();
        try ( Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/carlotapons/Documents/Universidades/4_curso/Is2/Kata5P1/Kata5.db");  Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS direcc_email "
                    + "(\n" + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                    + " Mail text NOT NULL);"
            );

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
