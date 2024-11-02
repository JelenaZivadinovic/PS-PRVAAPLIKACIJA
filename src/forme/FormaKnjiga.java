/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import controller.Controller;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Autor;
import model.Knjiga;
import model.Zanr;

/**
 *
 * @author Jelena
 */
public class FormaKnjiga extends javax.swing.JDialog {
    private Controller kontroler;
    private GlavnaForma gf;
    private Knjiga knjigazaizmenu;
    /**
     * Creates new form FormaKnjiga
     */
    public FormaKnjiga(java.awt.Frame parent, boolean modal,Knjiga knjigazaizmenu) {
        super(parent, modal);
        initComponents();
        kontroler=Controller.getInstance();
        this.gf=(GlavnaForma) parent;
        popuniComboBoxAutorima();
        if(knjigazaizmenu!=null){
            this.knjigazaizmenu=knjigazaizmenu;
            jTextFieldNaziv.setText(knjigazaizmenu.getNaslov());
            jComboBoxAutori.setSelectedItem(knjigazaizmenu.getAutor());
            jTextFieldISBN.setText(knjigazaizmenu.getISBN());
            //isbn ne moze da se menja
            jTextFieldISBN.setEnabled(false);
            jComboBoxZanr.setSelectedItem(knjigazaizmenu.getZanr());
            //uzima integer i konvertuje u string
            jTextFieldGodinaIzdanja.setText(String.valueOf(knjigazaizmenu.getGodinaIzdanja()));
            jButtonDodaj.setVisible(false);
        }else{
            jButtonIzmeni.setVisible(false);
        }
    }

    private FormaKnjiga(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldNaziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldISBN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxAutori = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldGodinaIzdanja = new javax.swing.JTextField();
        jButtonOdustani = new javax.swing.JButton();
        jButtonDodaj = new javax.swing.JButton();
        jLabelZanr = new javax.swing.JLabel();
        jComboBoxZanr = new javax.swing.JComboBox<>();
        jButtonIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv");

        jLabel2.setText("ISBN");

        jLabel3.setText("Autor");

        jLabel4.setText("Godina izdanja");

        jButtonOdustani.setText("Odustani");
        jButtonOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOdustaniActionPerformed(evt);
            }
        });

        jButtonDodaj.setText("Dodaj");
        jButtonDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDodajActionPerformed(evt);
            }
        });

        jLabelZanr.setText("Zanr");

        jComboBoxZanr.setModel(new DefaultComboBoxModel(Zanr.values()));

        jButtonIzmeni.setText("Izmeni");
        jButtonIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jButtonDodaj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jButtonOdustani)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jComboBoxZanr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(47, 47, 47)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldGodinaIzdanja, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxAutori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(119, 119, 119))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabelZanr, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jButtonIzmeni)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxAutori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldGodinaIzdanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelZanr)
                    .addComponent(jComboBoxZanr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOdustani)
                    .addComponent(jButtonDodaj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonIzmeni)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOdustaniActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButtonOdustaniActionPerformed

    private void jButtonDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajActionPerformed
        String naziv=jTextFieldNaziv.getText();
        String isbn=jTextFieldISBN.getText();
        int godinaIzdanja;
        try{
        godinaIzdanja=Integer.parseInt(jTextFieldGodinaIzdanja.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Godina izdanja mora biti broj!", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Zanr zanr= (Zanr) jComboBoxZanr.getSelectedItem();
        Autor odabraniAutor=(Autor) jComboBoxAutori.getSelectedItem();
        
        Knjiga novaKnjiga=new Knjiga(naziv,odabraniAutor,isbn,godinaIzdanja,zanr);
        kontroler.dodajKnjigu(novaKnjiga);
        gf.osveziTabelu();
        JOptionPane.showMessageDialog(this, "Knjiga je uspesno dodata!", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_jButtonDodajActionPerformed

    private void jButtonIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniActionPerformed
        String naziv=jTextFieldNaziv.getText();
        
        int godinaIzdanja;
        try{
        godinaIzdanja=Integer.parseInt(jTextFieldGodinaIzdanja.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Godina izdanja mora biti broj!", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Zanr zanr= (Zanr) jComboBoxZanr.getSelectedItem();
        Autor odabraniAutor=(Autor) jComboBoxAutori.getSelectedItem();
        
        knjigazaizmenu.setAutor(odabraniAutor);
        knjigazaizmenu.setNaslov(naziv);
        knjigazaizmenu.setGodinaIzdanja(godinaIzdanja);
        knjigazaizmenu.setZanr(zanr);
        gf.osveziTabelu();
        JOptionPane.showMessageDialog(this, "Knjiga je uspeno izmenjena", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
        
        this.dispose();
    }//GEN-LAST:event_jButtonIzmeniActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormaKnjiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaKnjiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaKnjiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaKnjiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormaKnjiga dialog = new FormaKnjiga(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDodaj;
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JButton jButtonOdustani;
    private javax.swing.JComboBox<Autor> jComboBoxAutori;
    private javax.swing.JComboBox<String> jComboBoxZanr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelZanr;
    private javax.swing.JTextField jTextFieldGodinaIzdanja;
    private javax.swing.JTextField jTextFieldISBN;
    private javax.swing.JTextField jTextFieldNaziv;
    // End of variables declaration//GEN-END:variables

    private void popuniComboBoxAutorima() {
       jComboBoxAutori.removeAllItems();
       List<Autor> autori=Controller.getInstance().getListaAutora();
       for(Autor autor:autori){
           jComboBoxAutori.addItem(autor);
       }
       
    }
}