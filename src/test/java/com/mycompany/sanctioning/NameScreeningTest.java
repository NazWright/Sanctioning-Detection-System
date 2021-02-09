/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sanctioning;

import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nazwright
 */
public class NameScreeningTest {

    public NameScreeningTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        NameScreening name = new NameScreening("input.csv");
    }

    @AfterAll
    public static void tearDownClass() {
        NameScreening name = null; 
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of screenName method, of class NameScreening.
     */
   
    /**
     * Test of checkList method, of class NameScreening.
     */
    @Test
    public void testCheckSanctionList() {
        System.out.println("Testing checkSanctionList");
        SanctionListName givenName = new SanctionListName("Macy Brown");
        String[] existingNames = { "Nazere Wright", "John Adams", "Macy Brown", "Damian Lee" };
        NameScreening instance = new NameScreening();
        double expected = 100.0; 
       double result = instance.checkSanctionList(givenName, existingNames);
        assertEquals(expected, result, 0.0);
        
    }

    /**
     * Test of percentMatch method, of class NameScreening.
     */
    @Test
    public void testPercentMatch() {
        System.out.println("percentMatch");
        SanctionListName givenName = new SanctionListName("Khristopher Toe");
        String currentName = "Khristopher Doe";
        NameScreening instance = new NameScreening();
        double expResult = 97.33333333333334;
        double result = instance.getPercentMatch(givenName, currentName);
        assertEquals(expResult, result, 0.1);

//test 2
        givenName.setName("Nazere Wright");
        currentName = "Nazere Wright";
        expResult = 100.0;
        result = instance.getPercentMatch(givenName, currentName);
        assertEquals(expResult, result, 0.1);

    }

    

    
   

   
    


}
