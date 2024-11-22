package com.parkinglot;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ParkingLotTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Test
    public void should_return_ticket_when_park_given_a_car(){
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //When
        Ticket ticket = parkingLot.park(car);
        //Return
        Assertions.assertNotNull(ticket);

    }
    @Test
    public void should_return_the_car_when_fetch_given_a_ticket(){
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        //When
        Car fetchedCar = parkingLot.fetch(ticket);
        //Return
        Assertions.assertEquals(car, fetchedCar);
    }
    @Test
    public void should_return_the_right_car_when_fetch_the_car_twice_given_a_parking_lot_with_2_cars(){
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
        Assertions.assertEquals(car1, fetchedCar1);
        Assertions.assertEquals(car2, fetchedCar2);

    }
    @Test
    public void should_return_null_when_fetch_the_car_given_a_parking_lot_and_a_wrong_parking_ticket(){
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = null;

        //When
        Car fetchedCar1 = parkingLot.fetch(ticket1);
        Assertions.assertNull(fetchedCar1);

    }
    @Test
    public void should_return_null_with_err_msg_when_fetch_the_car_given_the_ticket_is_used(){
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        //When
        Car fetchedCar1 = parkingLot.fetch(ticket1);
        assertThrows(UnrecognizedTicketException.class, () -> parkingLot.fetch(ticket1), "Unrecognized parking ticket.");
    }
    @Test
    public void should_return_null_when_parking_a_car_given_the_car_park_is_full(){
        // Given
        ParkingLot parkingLot = new ParkingLot();
         for (int i = 0; i < 3; i++) {
            parkingLot.park(new Car());
        }

        //When and Return
        assertThrows(ParkingLotFullException.class, () -> parkingLot.park(new Car()), "No available position");
    }
    private String systemOut() {
        return outContent.toString();
    }
    
    
    
    @Test
    void should_return_a_ticket_when_park_a_car_given_a_parkingLot_And_a_parkingBoy(){
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //When
        
        //Return
        
    }
       
}
