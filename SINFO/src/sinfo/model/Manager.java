/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinfo.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hugob
 */
public class Manager {

    private DealerDAO dealers;
    private BookingDAO bookings;

    public Manager() {
        dealers = new DealerDAOJSON();
        bookings = new BookingDAOJSON();
    }

}
