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
public interface DealerDAO {

    public boolean insertDealer(Dealer dealer);

    public boolean updateDealer(Dealer lastDealer, Dealer newDealer);

    public List<Dealer> selectDealers();

    public List<Vehicle> selectVehiclesWithSameModel(String model);

    public List<Vehicle> selectVehiclesWithSameFuel(String fuel);

    public List<Vehicle> selectVehiclesWithSameTransmission(String transmission);

    public List<Vehicle> selectVehiclesWithSameDealer(Dealer dealer);

    public Dealer selectClosestDealer(String model,String fuel,String transmission);

    public boolean removeDealer(Dealer dealer);

    public boolean updateDealer(Dealer dealer);

}
