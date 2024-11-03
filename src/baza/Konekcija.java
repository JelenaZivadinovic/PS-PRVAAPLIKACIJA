/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;

/**
 *
 * @author Jelena
 */
public class Konekcija {
    //zelimo da imamo jedan objekat u komunikaciji izmedju baze i kontrolera-Singlton pattern
    private static Konekcija instance;
    //objekat konekcije, objekat nad kojim cemo moci da pozovemo funkcije commit i rolback
    private Connection connection;

    public Konekcija() {
        try {
            //adresa baze podataka
            String url="jdbc:mysql://localhost:3306/bazapodataka_1";
            connection=DriverManager.getConnection(url,"root", "");
            //sami upravljamo transakcijma
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static Konekcija getInstance(){
        if(instance==null){
            instance=new Konekcija();
        }
        return instance;
    }
    public Connection getConnection(){
        return connection;
    }

   
   
    
    
    
}
