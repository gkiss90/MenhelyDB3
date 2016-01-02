/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

//import java.sql.Connection;
//import java.sql.DriverManager;
import static Base.Menhely.logger;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


/**
 *
 * @author Gabor
 */
public class Kennelek extends javax.swing.JFrame implements DBConnectionInterface{

    /**
     * Creates new form Kennelek
     */
    /*
    public String host= "jdbc:derby://localhost:1527/Kutya_menhely";
    public String Name = "user1";
    public String Pass = "user1";
    ResultSet rs = RSCreate();
    int curRow = 0;
    Connection con;
    Statement stmt;
    */
    
    //lekérdezés
    
    static Logger logger = Logger.getLogger(Kennelek.class.getName());
    
        DBResult db = new DBResult();
        ResultSet rs = db.RSCreate("select * from cella");
        int curRow = 0;
        
    /**
     *
     */
    public Kennelek() {
        initComponents();
        DBFill();
        logger.log(Level.INFO, "Kennelek form megnyitva");
    }
/*
    @Override
    public Connection DBConnect()
    {
        try{
        Connection connection_ = DriverManager.getConnection(host, Name, Pass);
        return connection_;
        }
        catch(Exception err)
        {JOptionPane.showMessageDialog(this, err.getMessage());
        return null;
        }
    }
    @Override
    public ResultSet RSCreate()
    {
        try{
        con = DBConnect();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
            String SQL = "select * from cella";
            
            ResultSet result = stmt.executeQuery(SQL);
            return result;
        }
        catch(Exception err)
        {JOptionPane.showMessageDialog(this, err.getMessage());
        return null;
        }
    }
    */
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textHossz = new javax.swing.JTextField();
        textMagassag = new javax.swing.JTextField();
        textMelyseg = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textFerohely = new javax.swing.JTextField();
        jButtonUpdate = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jButtonPrev = new javax.swing.JButton();
        jButtonNew = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setText("ID");

        textID.setEnabled(false);
        textID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIDActionPerformed(evt);
            }
        });

        jLabel2.setText("Méret:");

        jLabel3.setText("Hossz");

        jLabel4.setText("Magasság");

        jLabel5.setText("Mélység");

        textMagassag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMagassagActionPerformed(evt);
            }
        });

        jLabel6.setText("m");

        jLabel7.setText("m");

        jLabel8.setText("m");

        jLabel9.setText("Férőhely");

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonNext.setText("Next");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonPrev.setText("Previous");
        jButtonPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrevActionPerformed(evt);
            }
        });

        jButtonNew.setText("New Record");
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel Record");
        jButtonCancel.setEnabled(false);
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save New Record");
        jButtonSave.setEnabled(false);
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonBack.setText("Back");
        jButtonBack.setToolTipText("");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.setActionCommand("");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textHossz, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                    .addComponent(textMagassag)
                                    .addComponent(textMelyseg))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(textFerohely, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                                .addComponent(jButtonBack))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jButtonDelete)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonNew))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonNext)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPrev)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSave)
                            .addComponent(jButtonCancel))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(textFerohely, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBack))
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textHossz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textMagassag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textMelyseg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jButtonDelete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNext)
                    .addComponent(jButtonPrev)
                    .addComponent(jButtonSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonNew)
                    .addComponent(jButtonCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIDActionPerformed

    private void textMagassagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMagassagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMagassagActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        UpdateRecord();
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        // TODO add your handling code here:
        //köveztkező recordra léptetés
        
        try
        {
            if(rs.next())
            {
                logger.log(Level.INFO, "Következő kennel megjelenítése");
                FillIn();
            }
            else
            {
                logger.log(Level.INFO, "Nincs következő kennel a DB-ben");
                rs.previous();
                JOptionPane.showMessageDialog(this, "Utolsó kennel");
            }
        }
        catch(SQLException e)
        {
            logger.log(Level.INFO, "Hiba a kennelek közti léptetés közben:"+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrevActionPerformed
        // TODO add your handling code here:
        
        //előző recordra léptetés
        try
        {
            if(rs.previous())
            {
                logger.log(Level.INFO, "Előző kennel megjelenítése");
                FillIn();
            }
            else
            {
                logger.log(Level.INFO, "Nincs korábbi kennel a DB-ben");
                rs.next();
                JOptionPane.showMessageDialog(this, "Első kennel");
            }
        }
        catch(SQLException e)
        {
            logger.log(Level.INFO, "Hiba a kennelek közti léptetés közben:"+e);
            JOptionPane.showMessageDialog(Kennelek.this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonPrevActionPerformed

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        // TODO add your handling code here:
        
        //a form előkészítése egy új kennel beviteléhez
        
        logger.log(Level.INFO, "új kutya bevitele kezdődik");
        try
        {
        curRow = rs.getRow();
        textID.setText(Integer.toString(db.NextID(rs)));
            textHossz.setText("");
            textMelyseg.setText("");
            textMagassag.setText("");
            textFerohely.setText("");
            jButtonBack.setEnabled(false);
            jButtonSave.setEnabled(true);
            jButtonCancel.setEnabled(true);
            jButtonNext.setEnabled(false);
            jButtonPrev.setEnabled(false);
            jButtonUpdate.setEnabled(false);
            jButtonNew.setEnabled(false);
            jButtonDelete.setEnabled(false);
            logger.log(Level.INFO, "Új kennel felvételére felkészítés");
        }
                catch(SQLException e){
                    logger.log(Level.INFO, "Új kennel felvételére való felkészítés közben hiba lépett fel: "+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        
        //form visszaállítása új bevitelről
        try
        {
        rs.absolute(curRow);
        FillIn();
            jButtonSave.setEnabled(false);
            jButtonCancel.setEnabled(false);
            jButtonBack.setEnabled(true);
            jButtonNext.setEnabled(true);
            jButtonPrev.setEnabled(true);
            jButtonUpdate.setEnabled(true);
            jButtonNew.setEnabled(true);
            jButtonDelete.setEnabled(true);
            logger.log(Level.INFO, "Új kennel létrehozásából való kilépés");
        }
        catch(SQLException e){
            logger.log(Level.INFO, "Hiba új kennel létrehozásából kilépés alatt: "+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
        
        //új kennel insertálás
        
                try
        {
        rs.moveToInsertRow();
        InsertRecord();
        db.stmt.close();
        rs.close();
        rs = db.RSCreate("select * from cella");
        DBFill();
            jButtonSave.setEnabled(false);
            jButtonBack.setEnabled(true);
            jButtonCancel.setEnabled(false);
            jButtonNext.setEnabled(true);
            jButtonPrev.setEnabled(true);
            jButtonUpdate.setEnabled(true);
            jButtonNew.setEnabled(true);
            jButtonDelete.setEnabled(true);
            logger.log(Level.INFO, "Új kennel sikeresen elmentve");
        }
        catch(SQLException e)
        {
            logger.log(Level.INFO, "Hiba az új kennel mentése közben"+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        
        //főmenüre visszalép
        try{
        db.stmt.close();
        rs.close();
        logger.log(Level.INFO, "DB kapcsolat zárása");
        }
         catch(SQLException e)
        {
            logger.log(Level.INFO, "Hiba a db kapcsolat zárása közben: "+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        logger.log(Level.INFO, "Visszaléps Main Menu-be");
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
                //record törlése
        try{
        rs.deleteRow();
        db.stmt.close();
        rs.close();
        rs = db.RSCreate("select * from cella");
        DBFill();
        logger.log(Level.INFO, "Kennel törölve");
        }
        catch(SQLException e)
        {
            logger.log(Level.INFO, "Hiba a kennel törlése közben"+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(Kennelek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kennelek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kennelek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kennelek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new Kennelek().setVisible(true);
            }
        });
        /*  
        try {
               logger.setLevel(Level.FINE);
        logger.addHandler(new ConsoleHandler());
        //adding custom handler
       
        try {
            //FileHandler file name with max size and number of log files limit
            Handler fileHandler = new FileHandler("/Users/Gabor/tmp/logger.log", 2000, 5);
            
            //setting custom filter for FileHandler
            
            logger.addHandler(fileHandler);
             
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        
 */
    }
//mezők kitöltése léptetéssel

    /**
     *
     */
    @Override
    public void DBFill() {
     try{
            rs.next();
            FillIn();
            
        }
        catch
                 (SQLException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
//mezők kitöltése

    /**
     *
     */
    @Override
    public void FillIn() {
        
        try{
            int id_col = rs.getInt("ID");
            String id = Integer.toString(id_col);
            int hossz_col = rs.getInt("hossz");
            String hossz = Integer.toString(hossz_col);
            int melyseg_col = rs.getInt("melyseg");
            String melyseg = Integer.toString(melyseg_col);
            int ferohely_col = rs.getInt("ferohely");
            String ferohely = Integer.toString(ferohely_col);
                       int magassag_col = rs.getInt("magassag");
            String magassag = Integer.toString(magassag_col);
            
            //megjelenites
            
            textID.setText(id);
            textHossz.setText(hossz);
            textMelyseg.setText(melyseg);
            textMagassag.setText(magassag);
            textFerohely.setText(ferohely);
            
            
        }
        catch (SQLException e)
        {
            logger.log(Level.INFO, "Adatlekérés közben fellépett hiba: "+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
//record módosítása

    /**
     *
     */
    @Override
    public void UpdateRecord() {
 
          String id = textID.getText();
          String hosszString = textHossz.getText();
          int hossz = Integer.parseInt(hosszString);
          String melysegString = textMelyseg.getText();
          int melyseg = Integer.parseInt(melysegString);
          String magassagString = textMagassag.getText();
          int magassag = Integer.parseInt(magassagString);
          String ferohelyString = textFerohely.getText();
          int ferohely = Integer.parseInt(ferohelyString);
          
           
             try{
                      
       
        rs.updateInt("hossz", hossz);
        rs.updateInt("melyseg", melyseg);
        rs.updateInt("magassag", magassag);
        rs.updateInt("ferohely", ferohely);
        rs.updateRow();
        logger.log(Level.INFO, "ID. "+id+" módosítva");
        }
        catch (SQLException e)
        {
            logger.log(Level.INFO, "Módosítás közben fellépett hiba: "+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
//új record beillesztése

    /**
     *
     */
    @Override
    public void InsertRecord() {

          String hosszString = textHossz.getText();
          int hossz = Integer.parseInt(hosszString);
          String melysegString = textMelyseg.getText();
          int melyseg = Integer.parseInt(melysegString);
          String magassagString = textMagassag.getText();
          int magassag = Integer.parseInt(magassagString);
          String ferohelyString = textFerohely.getText();
          int ferohely = Integer.parseInt(ferohelyString);
          String IDString = textID.getText();
          int ID = Integer.parseInt(IDString);
        
           
             try{
                      
       rs.updateInt("ID", ID);
        rs.updateInt("hossz", hossz);
        rs.updateInt("melyseg", melyseg);
        rs.updateInt("magassag", magassag);
        rs.updateInt("ferohely", ferohely);
        rs.insertRow();
        logger.log(Level.INFO, "létrehozott új egyed: "+ID);
        }
        catch (SQLException e)
        {
            logger.log(Level.INFO, "Új egyed létrehozása közben fellépett hiba: "+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    //új recordnak következő ID kiszámítása
    /*
    public int NextID(ResultSet rs)
    {
        try
        {
        int curentRow = rs.getRow();
        rs.last();
        int rownumber = rs.getInt("ID");
        rs.absolute(curentRow);
        logger.log(Level.INFO, "Új egyed ID-ja: "+rownumber+1);
        return rownumber + 1;
        }
        catch (SQLException e)
        {
            logger.log(Level.INFO, "Új ID kiszámítás közben fellépett hiba: "+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
            return -1;
        }

    }
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrev;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField textFerohely;
    private javax.swing.JTextField textHossz;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textMagassag;
    private javax.swing.JTextField textMelyseg;
    // End of variables declaration//GEN-END:variables
}
