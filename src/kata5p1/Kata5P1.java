/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author carlotapons
 */
public class Kata5P1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConectarBD con = new ConectarBD();
        con.selectAll();
        try(Connection conn = DriverManager.getConnection( "jdbc:sqlite:/Users/carlotapons/Documents/Universidades/4_curso/Is2/Kata5P1/Kata5.db"); 
                Statement stmt = conn.createStatement()){
            stmt.execute("CREATE TABLE IF NOT EXISTS direcc_email "
                    + "(\n" + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                    + " Mail text NOT NULL);"
                                );
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
