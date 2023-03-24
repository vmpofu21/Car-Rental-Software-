package edu.ithaca.dragon.datastructures.node;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ManagementTest {
    
    @Test
    void updateCarStatusTest(){
        Car car1 = new Car("Nissan", "Altima", "Black", "Diesel", 55.00, "available");
        Car car2 = new Car("Nissan", "Rogue", "Black", "Diesel", 55.00, "available");
        Car car3 = new Car("Honda", "Civic", "Silver", "Petrol", 75.00, "unavailable");
        Car car4 = new Car("Nissan", "Altima", "Black", "Diesel", 55.00, "available");
        Car car5 = new Car("Nissan", "Rogue", "Black", "Diesel", 55.00, "available");
        Car car6 = new Car("Honda", "Civic", "Silver", "Petrol", 75.00, "neither");
        ManagementSystem MS = new ManagementSystem();
        MS.AvailableCars.put(1023, car1);
        MS.AvailableCars.put(1024, car2);
        MS.AvailableCars.put(1025, car3);
        MS.AvailableCars.put(1026, car4);
        MS.RentedCars.put(1027, car5);
        MS.AvailableCars.put(1028, car6);
        // equivalence case - because the status is unavailable, a valid status
        MS.updateCarStatus(car3, 1025);
        assertEquals(2, MS.RentedCars.size());
        assertEquals(car3, MS.RentedCars.get(1025));
        //equivalence case - because the status is available, a valid status
        MS.updateCarStatus(car5, 1027);
        assertEquals(5, MS.AvailableCars.size());
        assertEquals(car5, MS.AvailableCars.get(1027));
        //boundary case - because the status is neither unavailable nor available, an invalid status
        assertThrows(IllegalArgumentException.class, ()->  MS.updateCarStatus(car6, 1028));



    }

    @Test
    void checkCarAvailabilityTest(){
        ManagementSystem MS = new ManagementSystem();
        Car car1 = new Car("Nissan", "Altima", "Black", "Diesel", 55.00, "neither");
        Car car2 = new Car("Nissan", "Rogue", "Black", "Diesel", 55.00, "unavailable");
        Car car3 = new Car("Honda", "Civic", "Silver", "Petrol", 75.00, "available");
        MS.AllRentalCars.put(1023, car1);
        MS.AllRentalCars.put(1024, car2);
        MS.AllRentalCars.put(1025, car3);
        // equivalence case - because the car is available, thus availability is true
        assertTrue(MS.checkCarAvailability(1025, car3));
        // equivalence case - because the car is unavailable, thus availability is false
        assertFalse(MS.checkCarAvailability(1024, car2));
        // boundary case - because the car is neither available nor unavailable, thus the exception
        assertThrows(IllegalArgumentException.class, ()->  MS.checkCarAvailability(1023, car1));


    }
}

