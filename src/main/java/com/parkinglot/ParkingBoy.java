package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<Ticket> ticketList = new ArrayList<>();
    private List<ParkingLot> parkingLotList = new ArrayList<>();


    public ParkingBoy() {

    }

    public Ticket park(Car car){
        for (ParkingLot parkingLot : parkingLotList) {
            if (!parkingLot.isFull()) {
                Ticket ticket = new Ticket(parkingLot.parkingLotID);
                ticketList.add(ticket);
                System.out.println("got in");
                parkingLot.park(car);
                return ticket;
            }
        }
        throw new ParkingLotFullException("No available position");
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Car fetch(Ticket ticket) {

        if (ticketList.contains(ticket)) {
           Car obtainedCar = parkingLotList.get(ticket.getParkedToID()).fetch(ticket);
            ticketList.remove(ticket);
            return obtainedCar;
        }
        throw new UnrecognizedTicketException("Unrecognized parking ticket.");
    }
}
