/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinfo.model;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author hugob
 */
public class Dealer {

    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private List<Vehicle> vehicles;
    private List<String> closed;

    public Dealer(String id, String name, double latitude, double longitude, List<Vehicle> vehicles, List<String> closed) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.vehicles = inicializeVehicle(vehicles);
        this.closed = closed;
    }

    private ArrayList<Vehicle> inicializeVehicle(List<Vehicle> vehicles) {
        ArrayList<Vehicle> newVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            newVehicles.add(vehicle);
        }
        return newVehicles;
    }

    public List<Vehicle> getVehiclesWithSameModel(String model) {
        return vehicles.stream()
                .filter(v -> v.getModel().equals(model)).collect(Collectors.toList());
    }

    public List<Vehicle> getVehiclesWithSameFuel(String fuel) {
        return vehicles.stream()
                .filter(v -> v.getFuel().equals(fuel)).collect(Collectors.toList());
    }
    
    public List<Vehicle> getVehiclesWithSameTransmission(String transmission) {
        return vehicles.stream()
                .filter(v -> v.getTransmission().equals(transmission)).collect(Collectors.toList());
    }
    
     public List<Vehicle> getVehicles() {
        return vehicles ;
    }
     
     public String getId(){
         return id;
     }
     
     
}
