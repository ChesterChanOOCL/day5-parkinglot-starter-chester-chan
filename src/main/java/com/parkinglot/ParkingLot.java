package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity ;
    private Map<Ticket,Car> ticketToCar;
    private int availablePosition;

    public ParkingLot() {
        this.capacity = 3; ;
        this.availablePosition = 10;
        this.ticketToCar = new HashMap<>();
    }

    public Ticket park(Car car) {
        if (!this.isFull()) {
        Ticket ticket = new Ticket();
        ticketToCar.put(ticket,car);
        availablePosition -- ;
        return ticket;
        }
        return null;
    }

    public Car fetch(Ticket ticket) {
        Car obtainedCar =  ticketToCar.get(ticket);
        ticketToCar.remove(ticket);
        return obtainedCar;
    }
    // the parking lot is full when the size of the map is 10
    public boolean isFull() {
        if (ticketToCar.size() >= capacity) {
            return true;
        }
        return false;
    }
}
