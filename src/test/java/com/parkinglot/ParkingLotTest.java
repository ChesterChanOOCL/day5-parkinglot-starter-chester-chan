package com.parkinglot;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;


public class ParkingLotTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Test
    public void should_return_ticket_when_park_given_a_car(){
        // Given

        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot( 0);
        parkingBoy.getParkingLotList().add(parkingLot);


        Car car = new Car();
        //When
        Ticket ticket = parkingLot.park(car);
        //Return
        assertNotNull(ticket);

    }

    @Test
    public void should_return_the_car_when_fetch_given_a_ticket(){
        // Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot( 0);
        parkingBoy.getParkingLotList().add(parkingLot);
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
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot( 0);
        parkingBoy.getParkingLotList().add(parkingLot);
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
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(  0);
        parkingBoy.getParkingLotList().add(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = null;

        //When and Return
        assertThrows(UnrecognizedTicketException.class, () -> parkingLot.fetch(ticket1), "Unrecognized parking ticket.");
    }
    @Test
    public void should_return_null_with_err_msg_when_fetch_the_car_given_the_ticket_is_used(){
        // Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(  0);
        parkingBoy.getParkingLotList().add(parkingLot);
        Car car1 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        //When
        Car fetchedCar1 = parkingLot.fetch(ticket1);
        assertThrows(UnrecognizedTicketException.class, () -> parkingLot.fetch(ticket1), "Unrecognized parking ticket.");
    }

    @Test
    public void should_return_null_when_parking_a_car_given_the_car_park_is_full(){
        // Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(  0);
        parkingBoy.getParkingLotList().add(parkingLot);
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
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot1 = new ParkingLot(  0);
        ParkingLot parkingLot2 = new ParkingLot(  0);
        parkingBoy.getParkingLotList().add(parkingLot1);
        parkingBoy.getParkingLotList().add(parkingLot2);

        Car car1 = new Car();

        //When
        Ticket ticket = parkingBoy.park(car1);
        //Return
        assertNotNull(ticket);
    }
    @Test
    void should_return_a_car_when_fetch_a_car_given_a_parkingLot_And_a_parkingBoy_And_a_ticket(){
        // Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot( 0);
        parkingBoy.getParkingLotList().add(parkingLot);
        Car car1 = new Car();



        //When
        Ticket ticket = parkingBoy.park(car1);
        //Return
        assertNotNull(car1);

    }
    @Test
    void should_return_the_right_car_when_fetch_the_car_twice_given_a_parking_boy_with_2_cars(){
        // Given

        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(  0);
        parkingBoy.getParkingLotList().add(parkingLot);



        Car car1 = new Car();
        Car car2 = new Car();

        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);
        //When
        Car fetchedCar1 = parkingBoy.fetch(ticket1);
        Car  fetchedCar2 = parkingBoy.fetch(ticket2);

        //Return
        Assertions.assertEquals(car1, fetchedCar1);
        Assertions.assertEquals(car2, fetchedCar2);

    }
    @Test
     void should_return_null_when_fetch_the_car_given_a_parking_Boy_and_a_wrong_parking_ticket(){
        // Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(  0);
        parkingBoy.getParkingLotList().add(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();

        Ticket ticket1 = parkingBoy.park(car1);
        Ticket invalidTicket = new Ticket(3);

        //When and return
        assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(invalidTicket), "Unrecognized parking ticket.");

    }
    @Test
    void should_return_null_with_err_msg_when_fetch_the_car_given_a_parking_Boy_And_the_ticket_is_used(){
        // Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(  0);
        parkingBoy.getParkingLotList().add(parkingLot);
        Car car1 = new Car();
        Ticket ticket1 = parkingBoy.park(car1);

        //When
        Car fetchedCar1 = parkingBoy.fetch(ticket1);

        // Then
        assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(ticket1), "Unrecognized parking ticket.");
    }
    @Test
    public void should_return_null_when_parking_a_car_given_the_car_park_is_full_and_a_parking_boy(){
        // Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(  0);
        parkingBoy.getParkingLotList().add(parkingLot);
        for (int i = 0; i < 3; i++) {
            parkingBoy.park(new Car());
        }
        //When and Return
        assertThrows(ParkingLotFullException.class, () -> parkingBoy.park(new Car()), "No available position");
    }
    // Story 4
    @Test
    void should_park_the_Car_to_2nd_parkingLot_when_park_the_car_given_1st_parkingLot_isFull_And_2nd_parkingLot_isNOTFULL(){
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot1 = new ParkingLot(  0);
        parkingBoy.getParkingLotList().add(parkingLot1);
        ParkingLot parkingLot2 = new ParkingLot(  0);
        parkingBoy.getParkingLotList().add(parkingLot2);

        Car car = new Car();
        //When
        Ticket ticket = parkingBoy.park(car);
        //Return
        assertNotNull(ticket);
    }
    @Test
    public void should_return_FULL_errorMsg_when_parking_a_car_given_BOTH_car_park_are_full_with_a_parking_boy(){
        // Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot1 = new ParkingLot(  0);
        ParkingLot parkingLot2 = new ParkingLot(  1);
        parkingLot1.setCapacity(0);
        parkingLot2.setCapacity(0);
        //When and Return
        assertThrows(ParkingLotFullException.class, () -> parkingBoy.park(new Car()), "No available position");
    }
    @Test
    void should_park_in_first_lot_when_both_have_same_empty_positions() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingLot lot1 = new ParkingLot(1);
        ParkingLot lot2 = new ParkingLot(2);
        smartParkingBoy.getParkingLotList().add(lot1);
        smartParkingBoy.getParkingLotList().add(lot2);

        Car car = new Car();
        Ticket ticket = smartParkingBoy.park(car);

        assertTrue(lot1.getParkRecord().containsKey(ticket));
        assertFalse(lot2.getParkRecord().containsKey(ticket));
    }

    @Test
    void should_park_in_second_lot_when_it_has_more_empty_positions() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingLot lot1 = new ParkingLot(0);
        ParkingLot lot2 = new ParkingLot(1);
        smartParkingBoy.getParkingLotList().add(lot1);
        smartParkingBoy.getParkingLotList().add(lot2);

        Car car = new Car();
        lot1.park(new Car());
        Ticket ticket = smartParkingBoy.park(car);

        assertFalse(lot1.getParkRecord().containsKey(ticket));
        assertTrue(lot2.getParkRecord().containsKey(ticket));
    }

    @Test
    void should_return_right_car_with_each_ticket_when_fetch_car_given_2_parking_lot_And_2_ticket() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingLot lot1 = new ParkingLot(0);
        ParkingLot lot2 = new ParkingLot(1);
        smartParkingBoy.getParkingLotList().add(lot1);
        smartParkingBoy.getParkingLotList().add(lot2);

        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = smartParkingBoy.park(car1);
        Ticket ticket2 = smartParkingBoy.park(car2);

        assertEquals(car1, smartParkingBoy.fetch(ticket1));
        assertEquals(car2, smartParkingBoy.fetch(ticket2));
    }

    @Test
    void should_throw_exception_for_unrecognized_ticket_when_fetch_a_car_given_1_smartParkingBoy_2_parkingLots_1_unrecognised_ticket() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingLot lot1 = new ParkingLot(0);
        ParkingLot lot2 = new ParkingLot(1);
        smartParkingBoy.getParkingLotList().add(lot1);
        smartParkingBoy.getParkingLotList().add(lot2);

        Ticket invalidTicket = new Ticket(999);

        assertThrows(UnrecognizedTicketException.class, () -> smartParkingBoy.fetch(invalidTicket), "Unrecognized parking ticket.");
    }

    @Test
    void should_throw_exception_for_used_ticket_when_fetch_a_car_given_1_smartParkingBoy_2_parkingLots_1_and_used_ticket() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingLot lot1 = new ParkingLot(0);
        ParkingLot lot2 = new ParkingLot(1);
        smartParkingBoy.getParkingLotList().add(lot1);
        smartParkingBoy.getParkingLotList().add(lot2);

        Car car = new Car();
        Ticket ticket = smartParkingBoy.park(car);
        smartParkingBoy.fetch(ticket); // Use the ticket

        assertThrows(UnrecognizedTicketException.class, () -> smartParkingBoy.fetch(ticket), "Unrecognized parking ticket.");
    }

//    @Test
//    void should_throw_exception_when_park_a_car_given_no_available_position() {
//        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
//        ParkingLot lot1 = new ParkingLot(0);
//        ParkingLot lot2 = new ParkingLot(0);
//        smartParkingBoy.getParkingLotList().add(lot1);
//        smartParkingBoy.getParkingLotList().add(lot2);
//
//        lot1.park(new Car());
//        lot2.park(new Car());
//
//        Car car = new Car();
//
//        assertThrows(ParkingLotFullException.class, () -> smartParkingBoy.park(car), "No available position");
//    }
}




