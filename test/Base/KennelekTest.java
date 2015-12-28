/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

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
public class KennelekTest {
    
    public KennelekTest() {
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
     * Test of main method, of class Kennelek.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Kennelek.main(args);
        
    }

    /**
     * Test of DBFill method, of class Kennelek.
     */
    @Test
    public void testDBFill() {
        System.out.println("DBFill");
        Kennelek instance = new Kennelek();
        instance.DBFill();
        
    }

    /**
     * Test of FillIn method, of class Kennelek.
     */
    @Test
    public void testFillIn() {
        System.out.println("FillIn");
        Kennelek instance = new Kennelek();
        instance.FillIn();
        
    }

    /**
     * Test of UpdateRecord method, of class Kennelek.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("UpdateRecord");
        Kennelek instance = new Kennelek();
        instance.UpdateRecord();
        
    }

    /**
     * Test of InsertRecord method, of class Kennelek.
     */
    @Test
    public void testInsertRecord() {
        System.out.println("InsertRecord");
        Kennelek instance = new Kennelek();
        instance.InsertRecord();
        
    }

    /**
     * Test of NextID method, of class Kennelek.
     */
    @Test
    public void testNextID() {
        System.out.println("NextID");
        Kennelek instance = new Kennelek();
        int expResult = 0;
        int result = instance.NextID();
        assertEquals(expResult, result);
        
    }
    
}
