/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinfo.model;

import java.util.List;

/**
 *
 * @author hugob
 */
public interface BookingDAO {

    public boolean insertBooking(Booking booking);

    public List<Booking> selectBookings();

    public boolean cancelBooking(String id,String reason);

}
