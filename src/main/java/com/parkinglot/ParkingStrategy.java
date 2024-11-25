package com.parkinglot;

public interface ParkingStrategy {
    Ticket park(Car car);
    Car fetch(Ticket ticket);



}
