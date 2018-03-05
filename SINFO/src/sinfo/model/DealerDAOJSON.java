/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinfo.model;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author hugob
 */
public class DealerDAOJSON implements DealerDAO {

    private List<Dealer> dealers;
    private final static String filename = "dataset.json";

    public DealerDAOJSON() {
        dealers = new ArrayList<>();
        loadAll();
    }

    //le do ficheiro
    private void loadAll() {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(
                    filename));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray dealers = (JSONArray) jsonObject.get("dealers");

            Iterator<JSONObject> iterator = dealers.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObj = iterator.next();
                String id = (String) jsonObj.get("id");
                String name = (String) jsonObj.get("name");
                double latitude = (Double) jsonObj.get("latitude");
                double longitude = (Double) jsonObj.get("longitude");
                List<String> closed = readClosed((JSONArray) jsonObj.get("closed"));
                List<Vehicle> vehicles = readVehicles((JSONArray) jsonObj.get("vehicles"), jsonObj);
                Dealer dealer = new Dealer(id, name, latitude, longitude, vehicles, closed);
                this.dealers.add(dealer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private List<String> readClosed(JSONArray jsonArray) {
        List<String> closed = new ArrayList<>();
        Iterator<String> iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            closed.add(iterator.next());
        }
        return closed;
    }

    private List<Vehicle> readVehicles(JSONArray jsonArray, JSONObject jsonObject) {
        List<Vehicle> vehicles = new ArrayList<>();
        Iterator<JSONObject> iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonObj = iterator.next();
            String id = (String) jsonObj.get("id");
            String model = (String) jsonObj.get("model");
            String fuel = (String) jsonObj.get("fuel");
            String transmission = (String) jsonObj.get("transmission");
            Map<String, List<String>> availability = readAvailability(jsonObj);
            Vehicle vehicle = new Vehicle(id, model, fuel, transmission, availability);
            vehicles.add(vehicle);
        }
        return vehicles;
    }

    private Map<String, List<String>> readAvailability(JSONObject jsonObject) {
        Map<String, List<String>> availability = new HashMap<>();
        JSONObject json = (JSONObject) jsonObject.get("availability");
        Iterator<String> it = json.keySet().iterator();
        while (it.hasNext()) {
            String s = it.next();
            availability.put(s, readSlots(((JSONArray) json.get(s))));
        }

        return availability;
    }

    private List<String> readSlots(JSONArray jsonArray) {
        List<String> slots = new ArrayList<>();
        Iterator<String> iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            slots.add(iterator.next());
        }
        return slots;
    }

    //da save
    private void saveAll() {

    }

    @Override
    public boolean insertDealer(Dealer dealer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateDealer(Dealer lastDealer, Dealer newDealer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dealer> selectDealers() {
        return dealers;
    }

    @Override
    public List<Vehicle> selectVehiclesWithSameModel(String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Dealer d : dealers) {
            vehicles.addAll(d.getVehiclesWithSameModel(model));
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> selectVehiclesWithSameFuel(String fuel) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Dealer d : dealers) {
            vehicles.addAll(d.getVehiclesWithSameFuel(fuel));
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> selectVehiclesWithSameTransmission(String transmission) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Dealer d : dealers) {
            vehicles.addAll(d.getVehiclesWithSameTransmission(transmission));
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> selectVehiclesWithSameDealer(Dealer dealer) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Dealer d : dealers) {
            if (d.getId().equals(dealer.getId())) {
                vehicles.addAll(d.getVehicles());
            }
        }
        return vehicles;
    }
    
    public Dealer selectClosestDealer(String model,String fuel,String transmission){
        Dealer closest=null;
        
        return closest;
    }

    @Override
    public boolean removeDealer(Dealer dealer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateDealer(Dealer dealer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
