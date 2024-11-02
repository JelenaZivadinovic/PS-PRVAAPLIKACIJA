/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Autor;
import model.Knjiga;
import model.Zanr;

/**
 *
 * @author Jelena
 */
public class Controller {
    //povezuje model i formu
    private List<Knjiga> listaKnjiga=new ArrayList<>();
    private List<Autor> listaAutora= new ArrayList<>();
    //u svakom trenutku postoji samo jedan objekat klase kontroler-patern Singlton
    //static-ne treba nam objekat klase controller da bi smo tome pristupili,jer se cuvaju u statickoj memoriji
    //Contoroller.getInstance()-ovako se pristupa controller-u
    private static Controller instance;
    public static Controller getInstance(){
        if(instance==null){
            instance=new Controller();//kreiranje nove instance
        }
        return instance;
    }

    
    //inicijalizacija listi
    private Controller() {
        //napravimo listu autor i dodamo parametrizovan konstruktor
        Autor autor1=new Autor("Ivo","Anderic",1892,"Bigrafija autora Ive Andrica bla bla");
        Autor autor2=new Autor("Danilo","Kis",1935,"Bigrafija autora Danila Kisa bla bla");
        Autor autor3=new Autor("Mesa","Selimovic",1910,"Mesa Selimovic je u rodjen u BIH");
        
        Knjiga knjiga1=new Knjiga("Na Drini cuprija",autor1,"1234567890",1945,Zanr.ROMAN);
        Knjiga knjiga2=new Knjiga("Basta, pepeo",autor2,"0987654321",1982,Zanr.POEZIJA);
        Knjiga knjiga3=new Knjiga("Tvrdjava",autor3,"1122334455",1970,Zanr.ISTORIJSKI);
     
        //ubacamo parametre u listu
        listaKnjiga.add(knjiga1);
        listaKnjiga.add(knjiga2);
        listaKnjiga.add(knjiga3);
        
        listaAutora.add(autor1);
        listaAutora.add(autor2);
        listaAutora.add(autor3);
        
        
    }

    public List<Knjiga> getListaKnjiga() {
        return listaKnjiga;
    }

    public void setListaKnjiga(List<Knjiga> listaKnjiga) {
        this.listaKnjiga = listaKnjiga;
    }

    public List<Autor> getListaAutora() {
        return listaAutora;
    }

    public void setListaAutora(List<Autor> listaAutora) {
        this.listaAutora = listaAutora;
    }
    //korisnik je kliknuo dugme obrisi,forma je rekla kontroleru da obrise i onda je kontorler brise
    public void obrisiKnjigu(int selektovaniRed) {
       listaKnjiga.remove(selektovaniRed);
    }

    public void dodajKnjigu(Knjiga novaKnjiga) {
        listaKnjiga.add(novaKnjiga);
       
    }
    
}
    
    

