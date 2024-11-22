package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity ;
    private Map<Ticket,Car> ticketToCar;
    private int availablePosition;
     ParkingLot() {
        this.capacity = 3; ;
        this.availablePosition = 10;
        this.ticketToCar = new HashMap<>();
    }



    public Ticket park(Car car) {
        if (!this.isFull()) {
            Ticket ticket = new Ticket();
            ticketToCar.put(ticket, car);
            availablePosition--;
            return ticket;
        }

        throw new ParkingLotFullException("No available position");
    }


    public Car fetch(Ticket ticket) {
        Car obtainedCar =  ticketToCar.get(ticket);
        ticketToCar.remove(ticket);
        return obtainedCar;
    }
    public boolean isFull() {
        if (ticketToCar.size() >= capacity) {
            return true;
        }
        return false;
    }
}
