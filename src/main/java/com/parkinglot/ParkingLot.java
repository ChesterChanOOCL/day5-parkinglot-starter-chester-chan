package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity ;
    private Map<Ticket,Car> parkRecord;
    private int availablePosition;
    final int parkingLotID;

    public ParkingLot(int parkingLotID) {
        this.capacity = 3; ;
        this.availablePosition = 10;
        this.parkRecord = new HashMap<>();
        this.parkingLotID = parkingLotID;
    }

    public int getParkingLotID() {
        return parkingLotID;
    }

    public Ticket park(Car car) {
        if (!this.isFull()) {
            Ticket ticket = new Ticket(this.parkingLotID);
            this.parkRecord.put(ticket, car);
            availablePosition--;

            return ticket;
        }

        throw new ParkingLotFullException("No available position");
    }

    public int getCapacity() {
        return capacity;
    }

    public Car fetch(Ticket ticket) {
        if (parkRecord.get(ticket) == null) {
            throw new UnrecognizedTicketException("Unrecognized parking ticket.");
        }
        Car obtainedCar =  parkRecord.get(ticket);
        parkRecord.remove(ticket);
        return obtainedCar;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Map<Ticket, Car> getParkRecord() {
        return parkRecord;
    }

    public void setParkRecord(Map<Ticket, Car> parkRecord) {
        this.parkRecord = parkRecord;
    }

    public int getAvailablePosition() {
        return availablePosition;
    }

    public void setAvailablePosition(int availablePosition) {
        this.availablePosition = availablePosition;
    }

    public boolean isFull() {
        if (parkRecord.size() >= capacity) {
            return true;
        }
        return false;
    }
}
