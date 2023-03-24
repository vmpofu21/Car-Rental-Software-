package edu.ithaca.dragon.datastructures.node;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ReservationTest {

    @Test
    void calculateRentalCostTest(){
        Car car3 = new Car("Honda", "Civic", "Silver", "Petrol", 75.00, "available");
        Customer customer1 = new Customer("Vanessa", "veempofu@gmail.com", "password2");
        Reservation reservation = new Reservation(1023, customer1, 1, 75.0);
        reservation.makeReservation(car3, 1025);
        assertEquals(150.00, reservation.calculateRentalCost(75.00, 2));
        

    }

    @Test
    /**
     * INTEGRATION TEST
     */
    void makeReservationTest(){
        Car car1 = new Car("Nissan", "Altima", "Black", "Diesel", 55.00, "available");
        Car car2 = new Car("Nissan", "Rogue", "Black", "Diesel", 55.00, "available");
        Car car3 = new Car("Nissan", "Rogue", "Black", "Diesel", 55.00, "unavailable");

        Customer customer1 = new Customer("Vanessa", "veempofu@gmail.com", "password2");
        Reservation reservation = new Reservation(1023, customer1, 1, 80.0);
        //equivalence case - because it ensures that when car is available, a reservation is made
        reservation.makeReservation(car1, 1023);
        reservation.makeReservation(car2, 1026);
        assertEquals(2, reservation.AllReservations.size());
        //equivalence case - because it ensures that when car is unavailable, a reservation is not made
        assertThrows(IllegalArgumentException.class, ()->    reservation.makeReservation(car3, 1027));

       
    }

    @Test
    void cancelReservationTest(){
        Car car3 = new Car("Honda", "Civic", "Silver", "Petrol", 75.00, "available");
        Customer customer1 = new Customer("Vanessa", "veempofu@gmail.com", "password2");
        Reservation reservation = new Reservation(1025, customer1, 1, 80.0);
        reservation.makeReservation(car3, 1025);
        assertNull(reservation.cancelReservation(1025, reservation));
        
    }
    

    @Test
    void getCustomerHistoryTest(){
        Car car1 = new Car("Nissan", "Altima", "Black", "Diesel", 55.00, "available");
        Car car2 = new Car("Nissan", "Rogue", "Black", "Diesel", 55.00, "available");
        Customer customer1 = new Customer("Vanessa", "veempofu@gmail.com", "password2");
        Reservation reservation = new Reservation(1023, customer1, 1, 80.0);
        reservation.makeReservation(car1, 1023);
        reservation.makeReservation(car2, 1026);
        assertEquals(reservation, reservation.getRentalHistory(customer1, 1023, reservation));
    }
    
}
