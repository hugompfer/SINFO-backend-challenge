/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinfo.model;

import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author hugob
 */
public class BookingDAOJSON implements BookingDAO {

    private List<Booking> bookings;
    private final static String filename = "dataset.json";

    public BookingDAOJSON() {
        bookings = new ArrayList<>();
        loadAll();
    }

    //le do ficheiro
    private void loadAll() {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(
                    filename));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray bookings = (JSONArray) jsonObject.get("bookings");

            Iterator<JSONObject> iterator = bookings.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObj = iterator.next();
                String id = (String) jsonObj.get("id");
                String firstName = (String) jsonObj.get("firstName");
                String lastName = (String) jsonObj.get("lastName");
                String vehicleId = (String) jsonObj.get("vehicleId");
                LocalDateTime pickupDate = toLocalDateTime((String) jsonObj.get("pickupDate"));
                LocalDateTime createdAt = toLocalDateTime((String) jsonObj.get("pickupDate"));
                Booking booking = new Booking(id, firstName, lastName, vehicleId, pickupDate, createdAt);
                this.bookings.add(booking);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private LocalDateTime toLocalDateTime(String datetime) {
        LocalDateTime dateTime = LocalDateTime.parse(datetime);
        return dateTime;
    }

    //da save
    private void saveAll() {

    }

    @Override
    public boolean insertBooking(Booking booking) {
        return bookings.add(booking);
    }


    @Override
    public List<Booking> selectBookings() {
        return bookings;
    }
   

    @Override
    public boolean cancelBooking(String id,String reason) {
       for(Booking b:bookings){
           if(b.compareTo(id)){
               b.cancel(reason);
               return true;
           }
       }
       return false;
       
    }

  
}
