/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Knjiga;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author Jelena
 */
//forma kaze kontroleru sta mu je potrebno, kontoler komunicira za dbbrokerom,on uz pomoc konekcije
//skoci u bazu, izvrsi sta treba, vrati ih kontroleru i kontroler prikaze na formi
//dbb nema direktu komunikaciju sa formom NIKADA!
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Autor;
import model.Zanr;
import model.Knjiga;



public class DBBroker {

    public List<Knjiga> ucitajListuKnjigaIzBaze() {
        List<Knjiga> lista= new ArrayList<>();
        try {
            String upit="SELECT * FROM KNJIGA k JOIN AUTOR a ON k.autorid=a.id";
                        
            //kreiramo objekat statement koji nam omogucava da izvrsimo sql upit
            Statement st=Konekcija.getInstance().getConnection().createStatement();
            //linija koda koja izvrsva upit, tabela je smestena u resulSet
            ResultSet rs=st.executeQuery(upit);
            //izvlacimo podatke i smestamo u listu
            while(rs.next()){
                int id=rs.getInt("k.id");
                String naslovKnjige=rs.getString("k.naslovKnjige");
                int godinaIzdanja=rs.getInt("k.godinaIzdanja");
                String isbn=rs.getString("k.isbn");
                String zanr=rs.getString("k.zanr");
                //pretvaramo string u enum
                Zanr z=Zanr.valueOf(zanr);
                int idA=rs.getInt("a.id");
                String ime=rs.getString("a.ime");
                String prezime=rs.getString("a.prezime");
                String biografija=rs.getString("a.biografija");
                int godinRodjenja=rs.getInt("a.godinaRodjenja");
                //kreiramo autora
                Autor a=new Autor(idA, ime, prezime, godinRodjenja, biografija);
                //kreiramo novu knjigu
                Knjiga k=new Knjiga(id, naslovKnjige, a, isbn, godinaIzdanja, z);
                //knjigu dodamo u listu
                lista.add(k);
               
                
            }
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
         return lista;
    }

    public List<Autor> ucitajListuAutoraIzBaze() {
         List<Autor> lista= new ArrayList<>();
        try {
            String upit="SELECT * FROM AUTOR a";
                        
            //kreiramo objekat statement koji nam omogucava da izvrsimo sql upit
            Statement st=Konekcija.getInstance().getConnection().createStatement();
            //linija koda koja izvrsva upit, tabela je smestena u resulSet
            ResultSet rs=st.executeQuery(upit);
            //izvlacimo podatke i smestamo u listu
            while(rs.next()){
                
                int idA=rs.getInt("a.id");
                String ime=rs.getString("a.ime");
                String prezime=rs.getString("a.prezime");
                String biografija=rs.getString("a.biografija");
                int godinRodjenja=rs.getInt("a.godinaRodjenja");
                //kreiramo autora
                Autor a=new Autor(idA, ime, prezime, godinRodjenja, biografija);
                
               
                //autora dodamo u listu
                lista.add(a);
               
                
            }
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
         return lista;
        
    }

    public void obrisiKnjigu(int id) {
        try {
            String upit="DELETE FROM KNJIGA WHERE id=?";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, id);
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dodajKnjigu(Knjiga novaKnjiga) {
        try {
            String upit="INSERT INTO knjiga(id, naslovKnjige, autorId, isbn, godinaIzdanja, zanr)"
                    +"VALUES(?,?,?,?,?,?)";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, novaKnjiga.getId());
            ps.setString(2, novaKnjiga.getNaslov());
            ps.setInt(3, novaKnjiga.getAutor().getId());
            ps.setString(4, novaKnjiga.getISBN());
            ps.setInt(5, novaKnjiga.getGodinaIzdanja());
            ps.setString(6, String.valueOf(novaKnjiga.getZanr()));
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            System.out.println("uspesno dodato");
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void azurirajKnjigu(Knjiga knjigaZaIzmenu) {
         try {
            String upit="UPDATE KNJIGA SET naslov=?, autorId=?, godinaIzdanja=?,"
                    + " zanr=? WHERE id=?";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
           
            ps.setString(1, knjigaZaIzmenu.getNaslov());
            ps.setInt(2, knjigaZaIzmenu.getAutor().getId());
            ps.setInt(3, knjigaZaIzmenu.getGodinaIzdanja());
            ps.setString(4, String.valueOf(knjigaZaIzmenu.getZanr()));
            ps.setInt(5, knjigaZaIzmenu.getId());
            
            
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            System.out.println("uspesno azurirano");
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
