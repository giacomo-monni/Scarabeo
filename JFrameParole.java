/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parole;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.File;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

/**
 *
 * @author giacomo-monni
 */

public class JFrameParole extends javax.swing.JFrame
{

    /**
     * Creates new form JFrameParole
     */
    private int contatore = 120;
    private JFrameParole.Temporizzatore temporizzatore;
    private DefaultListModel<String> lista;
    private DefaultListModel<String> lista2;
    

    public void AggiungeStringaAllElenco(String parola)
    {
        int indice;
        String stringa;
        
        stringa = parola;
        indice = lista.indexOf(stringa);
        if (indice >= 0)
            lista.addElement(parola);
    }


    class Temporizzatore extends Thread
    {
        public void run()
        {
            while (true)
            {
                try
                {
                    contatore--;
                    jLabel3.setText(""+contatore/3600+":"+contatore/60+":"+contatore%60);
                    jLabel3.repaint();
                    sleep(1000);
                    if (contatore == 0)
                        System.exit(0);
                }
                catch(Exception e)
                {
                    System.err.println("Errore");
                }
            }
        }
    }  
    
    String stringhe[] = new String[20];
    boolean stato = false; 
    String s = new String();
    File file;
    Scanner f;
    Random r = new Random();
    int punteggio = 0;
    String paroleUsate[] = new String[100];
    boolean presente = false;
    int j=0;
    
    public JFrameParole (String args) 
    {
        int i,j=0;
        initComponents();
        temporizzatore = new Temporizzatore();
        temporizzatore.start();
        lista = new DefaultListModel<String>();
        jList1.setModel(lista);
        lista2 = new DefaultListModel<String>();
        jList2.setModel(lista2);
        
        CopiaDizionario();
        try
        {
            i=r.nextInt(9);
            file = new File ("configurazioni.txt");
            f = new Scanner(file);
            while(f.hasNextLine())
                stringhe[j++] = f.nextLine();
            s = stringhe[i];
        }
        catch(Exception e)
        {
            System.err.println("Errore nell'apertura del file");
        }
        jButton1.setText(s.substring(0,1));
        jButton2.setText(s.substring(1,2));
        jButton3.setText(s.substring(2,3));
        jButton4.setText(s.substring(3,4));
        jButton5.setText(s.substring(4,5));
        jButton6.setText(s.substring(5,6));
        jButton7.setText(s.substring(6,7));
        jButton8.setText(s.substring(7,8));
        jButton9.setText(s.substring(8,9));
        jButton10.setText(s.substring(9,10));
        jButton11.setText(s.substring(10,11));
        jButton12.setText(s.substring(11,12));
        jButton13.setText(s.substring(12,13));
        jButton14.setText(s.substring(13,14));
        jButton15.setText(s.substring(14,15));
        jButton16.setText(s.substring(15,16));
    }
     
    
    private void Reset (JButton pulsante, MouseEvent evt)
    {
        stato=!stato;
        ControllaParola();
        jLabel1.setText("Word:");
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        jButton7.setEnabled(true);
        jButton8.setEnabled(true);
        jButton9.setEnabled(true);
        jButton10.setEnabled(true);
        jButton11.setEnabled(true);
        jButton12.setEnabled(true);
        jButton13.setEnabled(true);
        jButton14.setEnabled(true);
        jButton15.setEnabled(true);
        jButton16.setEnabled(true);
        
        stato=!stato;
        
    }
    
    private void CopiaDizionario()
    {
        File file;
        Scanner f;
        
        try
        {
            file = new File ("dizionario.txt");
            f = new Scanner (file);
            
            while (f.hasNextLine())
                lista2.addElement(f.nextLine());
        }
        catch(Exception e)
        {
            System.err.println("Errore nella copia del file");
        }
    }
    
    private void ControllaParola()
    {
        String parola = new String(jLabel1.getText());
        
        File dizionario;
        Scanner f;
        
        parola = parola.substring(5);
        parola = parola.toLowerCase();
                
        int i = 0;
  
        System.out.println(parola);
        while(i<lista2.size())
        {
            if(parola.equals(lista2.elementAt(i)) && lista.indexOf(parola)<0)
            {
                jPanel2.setBackground(Color.green);
                punteggio += parola.length();
                jLabel2.setText("Punteggio:"+punteggio);
                lista.addElement(parola);
                break;                    
            }
            else
            {
                jPanel2.setBackground(Color.red);
                
            }
            if(lista.indexOf(parola)>=0)
            {
                jPanel2.setBackground(Color.yellow);
            }
            i++;
        }
        System.out.println("Punteggio: "+punteggio);
    }
    
    private boolean ParolaGiaTrovata(String parola)
    {
        for(int i=0;i < lista.size() && presente == false; i++)
            if(parola==lista.elementAt(i))
            {
                presente=true;
                
            }
        j++;
        return presente;
    }
    public void AggiungiLettera(java.awt.event.MouseEvent evt){
            javax.swing.JButton but;
            but=(javax.swing.JButton)evt.getSource();
            if(but.isEnabled())
                jLabel1.setText(jLabel1.getText()+but.getText());
            but.setEnabled(false);
            
                
            
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Word:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel2.setLayout(new java.awt.GridLayout(4, 4, 20, 20));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jButton1.setMaximumSize(new java.awt.Dimension(130, 60));
        jButton1.setMinimumSize(new java.awt.Dimension(130, 60));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jButton2.setMaximumSize(new java.awt.Dimension(130, 60));
        jButton2.setMinimumSize(new java.awt.Dimension(130, 60));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton3.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jButton3.setMaximumSize(new java.awt.Dimension(130, 60));
        jButton3.setMinimumSize(new java.awt.Dimension(130, 60));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
        });
        jPanel2.add(jButton3);

        jButton4.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jButton4.setMaximumSize(new java.awt.Dimension(130, 60));
        jButton4.setMinimumSize(new java.awt.Dimension(130, 60));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
        });
        jPanel2.add(jButton4);

        jButton5.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jButton5.setMaximumSize(new java.awt.Dimension(130, 60));
        jButton5.setMinimumSize(new java.awt.Dimension(130, 60));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
        });
        jPanel2.add(jButton5);

        jButton6.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jButton6.setMaximumSize(new java.awt.Dimension(130, 60));
        jButton6.setMinimumSize(new java.awt.Dimension(130, 60));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
        });
        jPanel2.add(jButton6);

        jButton7.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jButton7.setMaximumSize(new java.awt.Dimension(130, 60));
        jButton7.setMinimumSize(new java.awt.Dimension(130, 60));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
        });
        jPanel2.add(jButton7);

        jButton8.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jButton8.setMaximumSize(new java.awt.Dimension(130, 60));
        jButton8.setMinimumSize(new java.awt.Dimension(130, 60));
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);

        jButton9.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jButton9.setMaximumSize(new java.awt.Dimension(130, 60));
        jButton9.setMinimumSize(new java.awt.Dimension(130, 60));
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
        });
        jPanel2.add(jButton9);

        jButton10.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jButton10.setMaximumSize(new java.awt.Dimension(130, 60));
        jButton10.setMinimumSize(new java.awt.Dimension(130, 60));
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
        });
        jPanel2.add(jButton10);

        jButton11.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jButton11.setMaximumSize(new java.awt.Dimension(130, 60));
        jButton11.setMinimumSize(new java.awt.Dimension(130, 60));
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton11MouseEntered(evt);
            }
        });
        jPanel2.add(jButton11);

        jButton12.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jButton12.setMaximumSize(new java.awt.Dimension(130, 60));
        jButton12.setMinimumSize(new java.awt.Dimension(130, 60));
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton12MouseEntered(evt);
            }
        });
        jPanel2.add(jButton12);

        jButton13.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jButton13.setMaximumSize(new java.awt.Dimension(130, 60));
        jButton13.setMinimumSize(new java.awt.Dimension(130, 60));
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton13MouseEntered(evt);
            }
        });
        jPanel2.add(jButton13);

        jButton14.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jButton14.setMaximumSize(new java.awt.Dimension(130, 60));
        jButton14.setMinimumSize(new java.awt.Dimension(130, 60));
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton14MouseEntered(evt);
            }
        });
        jPanel2.add(jButton14);

        jButton15.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jButton15.setMaximumSize(new java.awt.Dimension(130, 60));
        jButton15.setMinimumSize(new java.awt.Dimension(130, 60));
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton15MouseEntered(evt);
            }
        });
        jPanel2.add(jButton15);

        jButton16.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jButton16.setMaximumSize(new java.awt.Dimension(130, 60));
        jButton16.setMinimumSize(new java.awt.Dimension(130, 60));
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton16MouseEntered(evt);
            }
        });
        jPanel2.add(jButton16);

        jLabel2.setText("Punteggio:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setViewportView(jList1);

        jList2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1307, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
        if (stato==true){
            AggiungiLettera(evt);
            jButton5.setEnabled(false);
        } 
               
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
        if (stato==true){
            AggiungiLettera(evt);
            jButton6.setEnabled(false);
        }
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        // TODO add your handling code here:
        if (stato==true){
            AggiungiLettera(evt);
            jButton7.setEnabled(false);
        }
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        // TODO add your handling code here:
        if (stato==true){
            AggiungiLettera(evt);
            jButton8.setEnabled(false);
        }
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
        // TODO add your handling code here:
        if (stato==true){
            AggiungiLettera(evt);
            jButton9.setEnabled(false);
        }
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        if (stato==true){
            AggiungiLettera(evt);
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        if (stato==true){
            AggiungiLettera(evt);
            jButton2.setEnabled(false);
        }
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        if (stato==true){
            AggiungiLettera(evt);
            jButton3.setEnabled(false);
        }
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
        if (stato==true){
            AggiungiLettera(evt);
            jButton4.setEnabled(false);
        }
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
        // TODO add your handling code here:
        if (stato==true){
            AggiungiLettera(evt);
            jButton10.setEnabled(false);
        }
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseEntered
        // TODO add your handling code here:
        if (stato==true){
            AggiungiLettera(evt);
            jButton11.setEnabled(false);
        }
    }//GEN-LAST:event_jButton11MouseEntered

    private void jButton12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseEntered
        // TODO add your handling code here:
        if (stato==true){
            AggiungiLettera(evt);
            jButton12.setEnabled(false);
        }
    }//GEN-LAST:event_jButton12MouseEntered

    private void jButton13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseEntered
        // TODO add your handling code here:
        if (stato==true){
            AggiungiLettera(evt);
            jButton13.setEnabled(false);
        }
    }//GEN-LAST:event_jButton13MouseEntered

    private void jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseEntered
        // TODO add your handling code here:
        if (stato==true){
            AggiungiLettera(evt);
            jButton14.setEnabled(false);
        }
    }//GEN-LAST:event_jButton14MouseEntered

    private void jButton15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseEntered
        // TODO add your handling code here:
        if (stato==true){
            AggiungiLettera(evt);
            jButton15.setEnabled(false);
        }
    }//GEN-LAST:event_jButton15MouseEntered

    private void jButton16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseEntered
        // TODO add your handling code here:
        if (stato==true){
            AggiungiLettera(evt);
            jButton16.setEnabled(false);
        }
    }//GEN-LAST:event_jButton16MouseEntered

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        stato =! stato;
        AggiungiLettera(evt);
        if (stato==false)            
            if (jLabel1.getText().length()>6)
                Reset (jButton1,evt);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        stato =! stato;
        AggiungiLettera(evt);
        if (stato==false)            
            if (jLabel1.getText().length()>6)
                Reset (jButton2,evt);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here: 
        stato =! stato;
        AggiungiLettera(evt);
        if (stato==false)            
            if (jLabel1.getText().length()>6)
                Reset (jButton3,evt);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        stato =! stato;
        AggiungiLettera(evt);
        if (stato==false)            
            if (jLabel1.getText().length()>6)
                Reset (jButton4,evt);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        stato =! stato;
        AggiungiLettera(evt);
        if (stato==false)            
            if (jLabel1.getText().length()>6)
                Reset (jButton5,evt);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        stato =! stato;
        AggiungiLettera(evt);
        if (stato==false)            
            if (jLabel1.getText().length()>6)
                Reset (jButton6,evt);
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
        stato =! stato;
        AggiungiLettera(evt);
        if (stato==false)            
            if (jLabel1.getText().length()>8)
                Reset (jButton7,evt);
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
        stato =! stato;
        AggiungiLettera(evt);
        if (stato==false)            
            if (jLabel1.getText().length()>6)
                Reset (jButton8,evt);
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // TODO add your handling code here:
        stato =! stato;
        AggiungiLettera(evt);
        if (stato==false)            
            if (jLabel1.getText().length()>6)
                Reset (jButton9,evt);
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        // TODO add your handling code here:
        stato =! stato;
        AggiungiLettera(evt);
        if (stato==false)            
            if (jLabel1.getText().length()>6)
                Reset (jButton10,evt);
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        // TODO add your handling code here:
        stato =! stato;
        AggiungiLettera(evt);
        if (stato==false)            
            if (jLabel1.getText().length()>6)
                Reset (jButton11,evt);
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseClicked
        // TODO add your handling code here:
        stato =! stato;
        AggiungiLettera(evt);
        if (stato==false)            
            if (jLabel1.getText().length()>6)
                Reset (jButton12,evt);
    }//GEN-LAST:event_jButton12MouseClicked

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked
        // TODO add your handling code here:
        stato =! stato;
        AggiungiLettera(evt);
        if (stato==false)            
            if (jLabel1.getText().length()>6)
                Reset (jButton13,evt);
    }//GEN-LAST:event_jButton13MouseClicked

    private void jButton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseClicked
        // TODO add your handling code here:
        stato =! stato;
        AggiungiLettera(evt);
        if (stato==false)            
            if (jLabel1.getText().length()>6)
                Reset (jButton15,evt);
    }//GEN-LAST:event_jButton15MouseClicked

    private void jButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseClicked
        // TODO add your handling code here:
        stato =! stato;
        AggiungiLettera(evt);
        if (stato==false)            
            if (jLabel1.getText().length()>6)
                Reset (jButton14,evt);
    }//GEN-LAST:event_jButton14MouseClicked

    private void jButton16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseClicked
        // TODO add your handling code here:
        stato =! stato;
        AggiungiLettera(evt);
        if (stato==false)            
            if (jLabel1.getText().length()>6)
                Reset (jButton16,evt);
    }//GEN-LAST:event_jButton16MouseClicked

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
            java.util.logging.Logger.getLogger(JFrameParole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameParole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameParole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameParole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            //    new JFrameParole().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
