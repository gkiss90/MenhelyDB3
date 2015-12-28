/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.sql.Connection;
import java.sql.ResultSet;
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
    @Test
    public void testDBConnect() {
        System.out.println("DBConnect");
        String SQL = "";
        DBResult instance = new DBResult();
        Connection expResult = null;
        Connection result = instance.DBConnect(SQL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RSCreate method, of class DBResult.
     */
    @Test
    public void testRSCreate() {
        System.out.println("RSCreate");
        String SQL = "";
        DBResult instance = new DBResult();
        ResultSet expResult = null;
        ResultSet result = instance.RSCreate(SQL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
