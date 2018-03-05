/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinfo.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hugob
 */
public class Vehicle {

    private String id;
    private String model;
    private String fuel;
    private String transmission;
    private Map<String, List<String>> availability;

    public Vehicle(String id, String model, String fuel, String transmission, Map<String, List<String>> availability) {
        this.id = id;
        this.model = model;
        this.fuel = fuel;
        this.transmission = transmission;
        this.availability = inicializeAvailability(availability);
    }

    private HashMap<String, List<String>> inicializeAvailability(Map<String, List<String>> availability) {
        HashMap<String, List<String>> available = new HashMap<>();
        for (Map.Entry<String, List<String>> es : availability.entrySet()) {
            available.put(es.getKey(),es.getValue());            
        }
        return available;
    }
    
    public String getModel(){
        return model;
    }
    
    public String getFuel(){
        return fuel;
    }
    
    public String getTransmission(){
        return transmission;
    }
    
    
}
