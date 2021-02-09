/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sanctioning;

/**
 *
 * @author nazwright
 */
public class SanctionListName {
    
    private String name; 
    
    public SanctionListName()  {
        name = "";
    }
    public SanctionListName(String name) { 
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() { 
        return name;
    }
    
    
    
}
