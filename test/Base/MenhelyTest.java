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
public class MenhelyTest {
    
    public MenhelyTest() {
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
     * Test of DBFill method, of class Menhely.
     */
    @Test
    public void testDBFill() {
        System.out.println("DBFill");
        Menhely instance = new Menhely();
        instance.DBFill();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of FillIn method, of class Menhely.
     */
    @Test
    public void testFillIn() {
        System.out.println("FillIn");
        Menhely instance = new Menhely();
        instance.FillIn();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateRecord method, of class Menhely.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("UpdateRecord");
        Menhely instance = new Menhely();
        instance.UpdateRecord();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of InsertRecord method, of class Menhely.
     */
    @Test
    public void testInsertRecord() {
        System.out.println("InsertRecord");
        Menhely instance = new Menhely();
        instance.InsertRecord();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of NextID method, of class Menhely.
     */
    @Test
    public void testNextID() {
        System.out.println("NextID");
        Menhely instance = new Menhely();
        int expResult = 0;
        int result = instance.NextID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CellaCheck method, of class Menhely.
     */
    @Test
    public void testCellaCheck() {
        System.out.println("CellaCheck");
        Menhely instance = new Menhely();
        boolean expResult = false;
        boolean result = instance.CellaCheck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Menhely.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Menhely.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
