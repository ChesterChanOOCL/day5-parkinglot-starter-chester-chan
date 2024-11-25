package com.parkinglot;

import java.util.Calendar;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy implements ParkingStrategy {

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
        throw new ParkingLotFullException(NO_AVAILABLE_POSITION);
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
    @Override
    public Car fetch(Ticket ticket) {
        if (this.getTicketList().contains(ticket)) {
            System.out.println("Smart park boy fetching its "+ticket);
            Car obtainedCar = getParkingLotList().get(ticket.getParkedToID()).fetch(ticket);
            getTicketList().remove(ticket);
            return obtainedCar;
        } else {
            throw new UnrecognizedTicketException(UNRECOGNIZED_PARKING_TICKET);
        }
    }

    @Override
    public List<Ticket> getTicketList() {
        return super.getTicketList();
    }


}