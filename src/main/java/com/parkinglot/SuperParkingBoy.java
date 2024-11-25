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
        throw new ParkingLotFullException(NO_AVAILABLE_POSITION);
    }
    private ParkingLot selectParkingLot() {
        ParkingLot bestLot = null;
        double maxAvailableRate = -1;

        for (ParkingLot lot : getParkingLotList()) {
            double availableRate = (double) lot.getAvailablePosition() / lot.getCapacity();
            if (availableRate > maxAvailableRate) {
                maxAvailableRate = availableRate;
                bestLot = lot;
            }
        }
        return bestLot;
    }
}
