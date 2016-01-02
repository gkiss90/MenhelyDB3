/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

/**
 *
 * @author Gabor
 */

//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Menhely extends javax.swing.JFrame implements DBConnectionInterface {

    /**
     * Creates new form Menhely
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
    int curRow = 0;   
    
    static Logger logger = Logger.getLogger(Kennelek.class.getName());
    
    //db kapcsolat felállítása
    
     DBResult db = new DBResult();
    ResultSet rs = db.RSCreate("select * from kutyak");
    
    public Menhely() {
        initComponents();
       //ComboFill();
       DBFill();
       
        
    }
    /*
    
    //@Override
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
    //@Override
    public ResultSet RSCreate()
    {
        try{
        con = DBConnect();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
            String SQL = "select * from kutyak";
            
            ResultSet result = stmt.executeQuery(SQL);
            return result;
        }
        catch(Exception err)
        {JOptionPane.showMessageDialog(this, err.getMessage());
        return null;
        }
    }
    */
  
    
    
    //mezők kitöltése léptetéssel
    
    @Override
    public void DBFill()
    {
        try{
            rs.next();
            FillIn();
            /**
            String combo = (String)(jComboBox1.getSelectedItem());
            while(rs.next())
            {
                if (rs.getInt("ID") == Integer.parseInt(combo))
                        FillIn();
                else
                    rs.next();
            }
            * */
        }
        catch
                 (SQLException e)
        {
            logger.log(Level.INFO, "Hiba: "+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    //drop down lista feltöltése
    /*
    public void ComboFill()
    {
        try
        {
        while(rs.next())
        {
            String id = Integer.toString(rs.getInt("ID"));
            jComboBox1.addItem(id);
        }
        }
        catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }
    }
      */
    
    
    // mezők kitöltése rs resultsetből
    @Override
    public void FillIn()
    {
        try{
            int id_col = rs.getInt("ID");
            String id = Integer.toString(id_col);
            String nev = rs.getString("Nev");
            String fajta = rs.getString("Fajta");
            int kor_col = rs.getInt("Kor");
            String kor = Integer.toString(kor_col);
            int cella_col = rs.getInt("Cella_id");
            String cella = Integer.toString(cella_col);
            boolean apolas = rs.getBoolean("Apolas_alatt");
            
            //megjelenites
            
            textID.setText(id);
            textNev.setText(nev);
            textFaj.setText(fajta);
            textCella.setText(cella);
            textKor.setText(kor);
            if(apolas)
            {
                checkApolas.setSelected(true);
            }
            else
            {
                checkApolas.setSelected(false);
            }
            logger.log(Level.INFO, "Kutya adatok megjelenitve");
            
        }
        catch (SQLException e)
        {
            logger.log(Level.INFO, "Hiba: "+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    //record módosítása, 
    
    @Override
    public void UpdateRecord()    
    {
        
        String IDString = textID.getText();
            int ID = Integer.parseInt(IDString);
            String Nev = textNev.getText();
            String Faj = textFaj.getText();
            String CellaString = textCella.getText();
            int Cella = Integer.parseInt(CellaString);
            String KorString = textKor.getText();
            int Kor = Integer.parseInt(KorString);
        boolean apolase;
        if(checkApolas.isSelected())
            {
                apolase = true;
            }
            else
            {
                apolase = false;
            }
        
           
             try{
                      
       
        rs.updateString("Nev", Nev);
        rs.updateString("Fajta", Faj);
        rs.updateInt("Kor", Kor);
        rs.updateInt("Cella_id", Cella);
        rs.updateBoolean("apolas_alatt", apolase);
        rs.updateRow();
        logger.log(Level.INFO, ID+" kutya modositva");
        
        }
        catch (SQLException e)
        {
            logger.log(Level.INFO, "Hiba: "+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    // új record beillesztése
    @Override
    public void InsertRecord()    
    {
        
        String IDString = textID.getText();
            int ID = Integer.parseInt(IDString);
            String Nev = textNev.getText();
            String Faj = textFaj.getText();
            String CellaString = textCella.getText();
            int Cella = Integer.parseInt(CellaString);
            String KorString = textKor.getText();
            int Kor = Integer.parseInt(KorString);
            boolean apolase;
        if(checkApolas.isSelected())
            {
                apolase = true;
            }
            else
            {
                apolase = false;
            }
           
             try{
                      
       rs.updateInt("ID", ID);
        rs.updateString("Nev", Nev);
        rs.updateString("Fajta", Faj);
        rs.updateInt("Kor", Kor);
        rs.updateInt("Cella_id", Cella);
        rs.updateBoolean("apolas_alatt", apolase);
        rs.insertRow();
        logger.log(Level.INFO, ID+" kutya elmentve");
        }
        catch (SQLException e)
        {
            logger.log(Level.INFO, "Hiba: "+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    //kiszámítja a sorban következő ID értékét
    /*
    public int NextID()
    {
        try
        {
        int curentRow = rs.getRow();
        rs.last();
        int rownumber = rs.getInt("ID");
        rs.absolute(curentRow);
        return rownumber + 1;
    
        }
        catch (SQLException err)
        {
            JOptionPane.showMessageDialog(this, err.getMessage());
            return 0;
        }

    }*/
    
    //leellenőrzi a kennel férőhelyét
    public boolean CellaCheck()
    {
        try
        {
        curRow = rs.getRow();
        int count = 0;
        
        String select = "select * from cella where id = " + textCella.getText();
        
        
        //Statement stamt = db.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
          //                            ResultSet.CONCUR_UPDATABLE);
        
        ResultSet rsCella = db.RSCreate(select);
                
                //stamt.executeQuery(select);
        rs.first();
        rsCella.first();
        while(rs.next())
        {
            if(rs.getInt("cella_id") == Integer.parseInt(textCella.getText()))
            {
            count = count + 1;
                rs.next();
            }
                else
                rs.next();
        }
        
        if (count >= rsCella.getInt("ferohely"))
        {
            rsCella.close();
            rs.absolute(curRow);
            return false;
            
        }
        else
            rsCella.close();
            rs.absolute(curRow);
            return true;
        }
        catch (SQLException e)
        {
            logger.log(Level.INFO, "Hiba: "+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
            return false;
        }
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
        textID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textNev = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textCella = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textFaj = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textKor = new javax.swing.JTextField();
        checkApolas = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonUpdate = new javax.swing.JButton();
        jButtonNew = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jButtonPrev = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setText("ID");

        textID.setEnabled(false);

        jLabel2.setText("Név");

        textNev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNevActionPerformed(evt);
            }
        });

        jLabel3.setText("Kennel");

        textCella.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textCellaFocusLost(evt);
            }
        });

        jLabel4.setText("Faj");

        jLabel5.setText("Életkor");

        checkApolas.setText("Ápolás alatt?");

        jComboBox1.setEnabled(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update Record");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonNew.setText("New Record");
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save New Record");
        jButtonSave.setEnabled(false);
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel New Record");
        jButtonCancel.setEnabled(false);
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonRefresh.setText("Refresh");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
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

        jButtonDelete.setText("Delete Row");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(textNev, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(textFaj, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkApolas)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textKor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(textCella, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonUpdate)
                        .addGap(42, 42, 42)
                        .addComponent(jButtonRefresh))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jButtonSave)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonNew, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonCancel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(86, 86, 86))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNext)
                .addGap(51, 51, 51)
                .addComponent(jButtonPrev)
                .addGap(41, 41, 41)
                .addComponent(jButtonDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonBack)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(textCella, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textFaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(textKor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkApolas)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonNew)
                    .addComponent(jButtonRefresh))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNext)
                    .addComponent(jButtonPrev)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonBack))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNevActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        //végrehajtja a módosítást
        
        UpdateRecord();
    logger.log(Level.INFO, "Adatmodositas sikeres");
    
        
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        // TODO add your handling code here:
        
        //felkészíti a formot új adatok bevitelére
        
        try{
        curRow = rs.getRow();
        textID.setText(Integer.toString(db.NextID(rs)));
        textNev.setText("");
        textFaj.setText("");
        textCella.setText("");
        textKor.setText("");
            
        checkApolas.setSelected(false);
            
        jButtonUpdate.setEnabled(false);
        jButtonNew.setEnabled(false);
        jComboBox1.setEnabled(false);
        jButtonRefresh.setEnabled(false);
        jButtonSave.setEnabled(true);
        jButtonCancel.setEnabled(true);
         jButtonNext.setEnabled(false);
        jButtonPrev.setEnabled(false);
        jButtonDelete.setEnabled(false);
        jButtonBack.setEnabled(false);
        logger.log(Level.INFO, "Form uj adatbevitelre elokeszitve");
        }
        catch(SQLException e){
            logger.log(Level.INFO, "Hiba: "+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        
        //visszaállítja a formot új adat beütéséről
        
        try{
            rs.absolute(curRow);
            FillIn();
        jButtonUpdate.setEnabled(true);
        jButtonNew.setEnabled(true);
        jButtonSave.setEnabled(false);
        jButtonCancel.setEnabled(false);
        jComboBox1.setEnabled(true);
        jButtonRefresh.setEnabled(true);
         jButtonNext.setEnabled(true);
 jButtonPrev.setEnabled(true);
 jButtonDelete.setEnabled(true);
 jButtonBack.setEnabled(true);
        textID.setEnabled(false);
        logger.log(Level.INFO, "Uj adatbevitelbol kilepes");
        }
        catch(SQLException e){
            logger.log(Level.INFO, "Hiba: "+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        
        //frissíti a mutatott record adatait
        
        try
        {
            curRow = rs.getRow();
            
        db.stmt.close();
        rs.close();
        rs = db.RSCreate("select * from kutyak");
        rs.absolute(curRow);
        FillIn();
        logger.log(Level.INFO, "Adatok ujra megjelenitve");
        }
        catch(SQLException e){
            logger.log(Level.INFO, "Hiba: "+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        // TODO add your handling code here:
        
        //következő record megjelenítése
        try
        {
            if(rs.next())
            {
                FillIn();
                logger.log(Level.INFO, "Elore leptetes");
            }
            else
            {
                rs.previous();
                JOptionPane.showMessageDialog(Menhely.this, "End of file");
                logger.log(Level.INFO, "Nincs tobb kutya");
            }
        }
        catch(SQLException e)
        {
            logger.log(Level.INFO, "Hiba: "+e);
            JOptionPane.showMessageDialog(Menhely.this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrevActionPerformed
        // TODO add your handling code here:
        
        //előző record megjelenítése
        try
        {
            if(rs.previous())
            {
                FillIn();
                logger.log(Level.INFO, "Hatra leptetes");
            }
            else
            {
                rs.next();
                logger.log(Level.INFO, "Nincs több kutya");
                JOptionPane.showMessageDialog(Menhely.this, "Beginning of file");
            }
        }
        catch(SQLException e)
        {
            logger.log(Level.INFO, "Hiba: "+e);
            JOptionPane.showMessageDialog(Menhely.this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonPrevActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        
        //record törlése
        try{
        rs.deleteRow();
        db.stmt.close();
        rs.close();
        rs = db.RSCreate("select * from kutyak");
        DBFill();
        logger.log(Level.INFO, "Kutya torolve");
        }
        catch(SQLException e)
        {
            logger.log(Level.INFO, "Hiba: "+e);
            JOptionPane.showMessageDialog(Menhely.this, e.getMessage());
        }
        
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void textCellaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textCellaFocusLost
        // TODO add your handling code here:
        
        //kennel férőhely ellenőrzése
        if(CellaCheck()==false)
        {
        JOptionPane.showMessageDialog(this,"A kennel tele van. Válasz másikat");
        textCella.setText("");
        }
        
        
    }//GEN-LAST:event_textCellaFocusLost

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
        
        //új record mentése
        try
        {
        rs.moveToInsertRow();
        InsertRecord();
        db.stmt.close();
        rs.close();
        rs = db.RSCreate("select * from kutyak");
        DBFill();
        jButtonUpdate.setEnabled(true);
        jButtonNew.setEnabled(true);
        jButtonSave.setEnabled(false);
        jButtonCancel.setEnabled(false);
        jComboBox1.setEnabled(true);
        textID.setEnabled(false);
        checkApolas.setSelected(false);
         jButtonNext.setEnabled(true);
 jButtonPrev.setEnabled(true);
 jButtonDelete.setEnabled(true);
 jButtonBack.setEnabled(true);
        jButtonRefresh.setEnabled(true);
        logger.log(Level.INFO, "Uj kutya mentese sikeres");
        }
        catch(SQLException e)
        {
            logger.log(Level.INFO, "Hiba: "+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        
        //kezdő menübe visszalépés
         try{
        db.stmt.close();
        rs.close();
        logger.log(Level.INFO, "Kilepes fomenube");
        }
         catch(SQLException e)
        {
            logger.log(Level.INFO, "Hiba: "+e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

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
            java.util.logging.Logger.getLogger(Menhely.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menhely.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menhely.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menhely.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menhely().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkApolas;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrev;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textCella;
    private javax.swing.JTextField textFaj;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textKor;
    private javax.swing.JTextField textNev;
    // End of variables declaration//GEN-END:variables
}
