package com.parkinglot;

public class Ticket {
    private int parkedToID ;
    public Ticket(int parkedToID) {
        this.parkedToID = parkedToID;
    }

    public int getParkedToID() {
        return parkedToID;
    }
}
