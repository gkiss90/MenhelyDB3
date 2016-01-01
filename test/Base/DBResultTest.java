/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;


import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabor
 */
public class DBResultTest {
    
    public DBResultTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of DBConnect method, of class DBResult.
     */
   

    /**
     * Test of RSCreate method, of class DBResult.
     */
    @Test
    public void testRSCreate() {
        System.out.println("RSCreate");
        String SQL = "select * from kutyak";
        DBResult instance = new DBResult();
        ResultSet rs = instance.RSCreate(SQL);
        try
        {
        rs.next();
        int expResult = rs.getRow();
        
        int result = rs.getInt("ID");
        assertEquals(expResult, result);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of NextID method, of class DBResult.
     */
    @Test
    public void testNextID() {
        System.out.println("NextID");
        
        
        DBResult instance = new DBResult();
        ResultSet rs = instance.RSCreate("select * from kutyak");
        try{
                rs.last();
        int expResult = rs.getInt("ID")+1;
        
        int result = instance.NextID(rs);
        rs.close();
        assertEquals(expResult, result);}
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
