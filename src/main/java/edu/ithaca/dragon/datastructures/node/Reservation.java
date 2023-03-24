package edu.ithaca.dragon.datastructures.node;

import java.util.HashMap;

/**
 * I picked these uses cases because they are the sole methods,
 * of a car rebtal company.
 * Some of the use cases in different classes were to assist me,
 * get to the part of making a reservation with the appropriate objects, 
 * such as cars and customers.
 */

public class Reservation {
    
    private Customer customer;
    private int carID;
    private int rentalPeriod;
    private double totalRentalCost;
    HashMap< Integer, Reservation> AllReservations;


    public Reservation(int carID, Customer customer, int rentalPeriod, double totalRentalCost){
        this.carID = carID;
        this.customer = customer;
        this.rentalPeriod = 0;
        this.totalRentalCost = 0.0;
        this.AllReservations = new HashMap<>();

    }

    /**
     * this method calculates the total rental cost
     * @param pricePerDay
     * @param rentalPeriod
     * @return
     */
    public double calculateRentalCost(double pricePerDay, int rentalPeriod){
        totalRentalCost = pricePerDay*rentalPeriod;
        return totalRentalCost;
    }
    

    /**
     * thiss method creates a reservation by first checking if the car is available
     * then change the status of the car
     * creates a reservation object and add it a collection of all reservation
     * @param car
     * @param carID
     */
    public void makeReservation(Car car, int carID){
        int reservationID = 0;
        if(car.getStatus().equals("available")){
            car.setStatus("unavailable");
            Reservation reservation = new Reservation(carID, customer, rentalPeriod, totalRentalCost);
            reservationID = carID;
            AllReservations.put(reservationID, reservation);
            
        }

        else{
            throw new IllegalArgumentException("The car is not available");
        }
    }


    /**
     * this method cancels a reservation by setting it to null
     * @param reservationID
     * @param reservation
     * @return
     */
    public Reservation cancelReservation(int reservationID, Reservation reservation){
        reservation = null;
        return reservation;        
    }

    /**
     * this method returns a reservation history when requested for by the customer
     * @param customer
     * @param reservationID
     * @param reservation
     * @return
     */
    public Reservation getRentalHistory(Customer customer, int reservationID, Reservation reservation) {
        Reservation customersRentalHistory = null;
        if (AllReservations.get(reservationID) == reservation && reservation.getCustomer() == customer) {
            customersRentalHistory = reservation;
        }
        
        return customersRentalHistory;
        
    }

    public int getCarID(){
        return carID;
    }

    public Customer getCustomer(){
        return customer;
    }

    public int getRentalPeriod(){
        return rentalPeriod;
    }

    public double getTotalRentalCost(){
        return totalRentalCost;
    }

}

