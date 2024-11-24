package com.parkinglot;

public class SuperParkingBoy extends ParkingBoy {
    public SuperParkingBoy() {
        super();
    }

    @Override
    public Ticket park(Car car) {
        ParkingLot selectedLot = selectParkingLot();
        if (selectedLot != null) {
            Ticket ticket = selectedLot.park(car);
            getTicketList().add(ticket);
            return ticket;
        }
        throw new ParkingLotFullException("No available position");
    }
}
