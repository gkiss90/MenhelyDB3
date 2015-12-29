/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import static Base.Kennelek.logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
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
    
    //hibás
    @Test
    public void testDBConnect() {
        System.out.println("DBConnect");
        
        DBResult instance = new DBResult();
        Connection expResult = null;
        Connection result = instance.DBConnect();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of RSCreate method, of class DBResult.
     */
    @Test
    public void testRSCreate() {
        System.out.println("RSCreate");
        try{String SQL = "select * from kutyak";
        
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Kutya_menhely", "user1", "user1");           
        Statement stmt = con.createStatement();
        
        
        DBResult instance = new DBResult();
        ResultSet expResult = stmt.executeQuery(SQL);
        ResultSet result = instance.RSCreate(SQL);
        assertEquals(expResult, result);
        }
        catch(Exception e)
            {JOptionPane.showMessageDialog(null, e.getMessage());
    }
    
}
    
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
            JOptionPane.showMessageDialog(null, e.getMessage());
            return -1;
        }
}
}