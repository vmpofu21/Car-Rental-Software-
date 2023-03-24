package edu.ithaca.dragon.datastructures.node;

import java.util.HashMap;

public class ManagementSystem {

    HashMap<Integer, Car> AllRentalCars;
    HashMap<Integer, Car> RentedCars;
    HashMap<Integer, Car> AvailableCars;

    public ManagementSystem(){
        this.AllRentalCars = new HashMap<>();
        this.RentedCars = new HashMap<>();
        this.AvailableCars = new HashMap<>();
    }

    /**
     * this method updates the status of a car
     * and add it to the appropriate list of cars
     * @param car
     * @param carID
     */
    public void updateCarStatus(Car car, int carID){
       if(car.getStatus().equals("available")){
            if(RentedCars.containsKey(carID) && RentedCars.get(carID) == car){
                RentedCars.remove(carID, car);
            }
            AvailableCars.put(carID, car);
        }

       else if(car.getStatus().equals("unavailable")){
            if(AvailableCars.containsKey(carID) && AvailableCars.get(carID) == car){
                AvailableCars.remove(carID, car);
            }
            RentedCars.put(carID, car);
        }

       else{
        throw new IllegalArgumentException("Car's status is invalid");
       }
    }

    /**
     * this method checks if a car is available to be rented
     * and returns a corresponding boolean
     * then the car is available, otherwise its not
     * @param carID
     * @param car
     * @return
     */
    public boolean checkCarAvailability(int carID, Car car){
        if(car.getStatus().equals("available")){
            return true;
        }
        else if(car.getStatus().equals("unavailable")){
            return false;
        }
        
        else{
            throw new IllegalArgumentException("There's no car with that Key");
        }
    }


    public  HashMap<Integer, Car> getAllRentalCars(){
        return AllRentalCars;
    }

    
    public  HashMap<Integer, Car> getRentedCars(){
        return RentedCars;
    }

}
