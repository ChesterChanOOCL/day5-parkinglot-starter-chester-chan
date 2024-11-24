package com.parkinglot;

import java.util.Calendar;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy() {
        super();
    }

    @Override
    public Ticket park(Car car) {
        ParkingLot selectedLot = selectParkingLot();
        if (selectedLot != null) {
            Ticket ticket = selectedLot.park(car);
            this.getTicketList().add(ticket);
            return ticket;
        }
        throw new ParkingLotFullException("No available position");
    }


    private ParkingLot selectParkingLot() {
        ParkingLot bestLot = null;
        int maxAvailableSpaces = -1;

        for (ParkingLot lot : getParkingLotList()) {
            int availableSpaces = lot.getAvailablePosition();
            if (availableSpaces > maxAvailableSpaces) {
                maxAvailableSpaces = availableSpaces;
                bestLot = lot;
            }
        }
        return bestLot;
    }
}