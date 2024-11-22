package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_a_car(){
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //When
        Ticket ticket = parkingLot.park(car);
        //Return
        assertNotNull(ticket);

    }
    @Test
    void should_return_the_car_when_fetch_given_a_ticket(){
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        //When
        Car fetchedCar = parkingLot.fetch(ticket);
        //Return
        assertEquals(car, fetchedCar);
    }
    @Test
    void should_return_the_right_car_when_fetch_the_car_twice_given_a_parking_lot_with_2_cars(){
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);
        //When
        Car fetchedCar1 = parkingLot.fetch(ticket1);
        Car  fetchedCar2 = parkingLot.fetch(ticket2);

        //Return
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);

    }
    @Test
    void should_return_null_when_fetch_the_car_given_a_parking_lot_and_a_wrong_parking_ticket (){
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = null;

        //When
        Car fetchedCar1 = parkingLot.fetch(ticket1);
        //Return nothing
        assertNull(fetchedCar1);

    }
    @Test
    void should_return_null_when_fetch_the_car_given_the_ticket_is_used(){
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        //When
        Car fetchedCar1 = parkingLot.fetch(ticket1);
        Car fetchAgain = parkingLot.fetch(ticket1);
        //Return
        assertNull(fetchAgain);
    }
    @Test
    void should_return_null_when_parking_a_car_given_the_car_park_is_full(){
        // Given
        ParkingLot parkingLot = new ParkingLot();
         for (int i = 0; i < 3; i++) {
            parkingLot.park(new Car());
        }
        //When
        Ticket ticket1 = parkingLot.park(new Car());
        //Return
        assertNull(ticket1);
    }

}
