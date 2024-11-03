/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Knjiga;

/**
 *
 * @author Jelena
 */
//popuniti tabelu sa podacima
public class ModelTabeleKnjige extends AbstractTableModel {
    //dajemo redove
    private  List<Knjiga>listaKnjiga;
    //dajemo kolone, niz stringova sa nazivima kolona
    private final String[] kolone={"id", "Naslov","Autor","ISBN","Godina izdanja"};
    //da bi formi prosledili nasu listu knjiga
    
   public ModelTabeleKnjige(List<Knjiga> listaKnjiga) {
       this.listaKnjiga= listaKnjiga;
    }
    
    

    @Override
    public int getRowCount() {
       return listaKnjiga.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }
    //metoda koja ce mi vratiti u odredjenoj celiji odredjenu vrednost
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //uzimamo 1 knjigu iz liste ako prosledimo jednom
       Knjiga knjiga=listaKnjiga.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return knjiga.getId();
            case 1:
                return knjiga.getNaslov();
            case 2:
                return knjiga.getAutor().getIme()+" "+knjiga.getAutor().getPrezime();
            case 3:
                return knjiga.getISBN();
            case 4:
                return knjiga.getGodinaIzdanja();
                
            default:
                return "N/A";
        }
    }
    //davanje imena koloni
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    void osveziPodatke() {
        fireTableDataChanged();
    }

    public List<Knjiga> getListaKnjiga() {
        return listaKnjiga;
    }

    public void setListaKnjiga(List<Knjiga> listaKnjiga) {
        this.listaKnjiga = listaKnjiga;
    }
    
    
    
}
