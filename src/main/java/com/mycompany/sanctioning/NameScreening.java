/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sanctioning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;

/**
 *
 * @author nazwright
 */
public final class NameScreening {

    private String filename;

    private final Scanner scanSys = new Scanner(System.in);
    private Scanner scan;
    // object implements the inverse jaro-winkler distance algorithm
    private JaroWinklerSimilarity comparison;
//current name
    private SanctionListName queryName;
//percentage matching
    private double percentage;
//hit or no hit
    private boolean hit;

    private int index;
    
    public NameScreening(){ 
        try {
            scan = new Scanner(new File(filename));
        } catch (FileNotFoundException ex) {
            System.err.println();
        }
        queryName = new SanctionListName();

        comparison = new JaroWinklerSimilarity();

        
    }

    public NameScreening(String filename) {
        this.filename = filename;
        try {
            scan = new Scanner(new File(filename));
        } catch (FileNotFoundException ex) {
            System.err.println();
        }
        queryName = new SanctionListName();

        comparison = new JaroWinklerSimilarity();

        while (true) {
            screenName();
            readSanctionNames();
            printResults();
            System.out.println("Would you like to exit the program. (Type Y or N)");
            exitProgram(scanSys.nextLine());

        }

    }

    public void screenName() {

        System.out.println("Enter a name to check the list.");
       
        queryName.setName(scanSys.nextLine());
        
        
    }

    public String[] readSanctionNames() {
        String[] line = new String[100];
        while (scan.hasNext()) {
            line = scan.nextLine().split(",");
            percentage = checkSanctionList(queryName, line);
        }
        return line;
    }

    public double checkSanctionList(SanctionListName givenName, String[] existingNames) {

        double max = 0.0;

        for (String regName : existingNames) {
            if (getPercentMatch(givenName, regName) >= 75) {
                setHit(true);
            } else {
                if (getIndex() == existingNames.length - 1) {
                    setHit(false);
                }
            }
            if (max < getPercentage()) {
                max = getPercentage();
            }

        }

        return max;
    }

    public double getPercentMatch(SanctionListName givenName, String currentName) {

        setPercentage(getComparison().apply(givenName.getName(), currentName));

        setPercentage(getPercentage() * 100);
        return getPercentage();

    }

    public void printResults() {
        if (getPercentage() >= 75) {
            System.out.println(getName().toString() + " - Hit " + getPercentage() + "%");
        } else {
            System.out.println(getName().toString() + " - No Hit " + getPercentage() + "%");
        }
    }

    /**
     * @return the comparison
     */
    public JaroWinklerSimilarity getComparison() {
        return comparison;
    }

    /**
     * @param comparison the comparison to set
     */
    public void setComparison(JaroWinklerSimilarity comparison) {
        this.comparison = comparison;
    }

    /**
     * @return the name
     */
    public SanctionListName getName() {
        return queryName;
    }

    /**
     * @param name the name to set
     */
    public void setName(SanctionListName name) {
        this.queryName = name;
    }

    /**
     * @return the percentage
     */
    public double getPercentage() {
        return percentage;
    }

    /**
     * @param percentage the percentage to set
     */
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    /**
     * @return the hit
     */
    public boolean isHit() {
        return hit;
    }

    /**
     * @param hit the hit to set
     */
    public void setHit(boolean hit) {
        this.hit = hit;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    public void exitProgram(String con) {
        if (con.equalsIgnoreCase("Y")) {
            System.exit(0);
        } else if (con.equalsIgnoreCase("Y")) {

        }
    }

    /**
     * @return the filename
     */
}
