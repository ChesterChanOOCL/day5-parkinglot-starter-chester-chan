package com.parkinglot;

public class ParkingBoy {
    private ParkingLot parkingLot;
    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) {
        if (!this.parkingLot.isFull()) {
            Ticket ticket = new Ticket();
            parkingLot.getTicketToCar().put(ticket, car);
            parkingLot.setAvailablePosition(parkingLot.getAvailablePosition() -1 )  ;
            return ticket;
        }

        throw new ParkingLotFullException("No available position");
    }

    public Car fetch(Ticket ticket) {
        if (parkingLot.getTicketToCar().get(ticket) == null) {
            throw new UnrecognizedTicketException("Unrecognized parking ticket.");
        }
        Car obtainedCar =  parkingLot.getTicketToCar().get(ticket);
        parkingLot.getTicketToCar().remove(ticket);
        return obtainedCar;
    }
}
