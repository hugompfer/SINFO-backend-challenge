/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinfo.model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author hugob
 */
public class Booking {

    private String id;
    private String vehicleId;
    private String firstName;
    private String lastName;
    private LocalDateTime pickupDate;
    private LocalDateTime createdAt;
    private LocalDateTime cancelledAt;
    private String cancelledReason;
    
    public Booking(String id,String vehicleId,String firstName,String lastName,LocalDateTime pickupDate,LocalDateTime createdAt){
        this.id=id;
        this.vehicleId=vehicleId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.pickupDate=pickupDate;
        this.createdAt=createdAt;
        this.cancelledReason="";
    }
    
    
    public String getId(){
        return id;    
    }
    
    public boolean compareTo(String id){
        return id.equals(id);
    }
    
    
    public void cancel(String reason){
        this.cancelledReason=reason;
        this.cancelledAt=LocalDateTime.now();
    }
    
}
