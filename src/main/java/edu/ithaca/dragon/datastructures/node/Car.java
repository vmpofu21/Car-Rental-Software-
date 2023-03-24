package edu.ithaca.dragon.datastructures.node;

public class Car {
    
    private String modelName;
    private String makeName;
    private String carColor;
    private String carFuelType;
    private double pricePerDay;
    private String status;

    public Car(String makeName, String modelName, String carColor, String carFuelType, double pricePerDay, String status ){
        this.modelName = modelName;
        this.makeName = makeName;
        this.carColor = carColor;
        this.carFuelType = carFuelType;
        this.pricePerDay = 0.00;
        this.status = status;
    }

    public String getModelName(){
       return modelName;
    }

    public String getMakeName(){
        return makeName;
    }
    
    public String getCarColor(){
        return carColor;
    }

    public String getCarFuelType(){
        return carFuelType;
    }

    public double getPricePerDay(){
        return pricePerDay;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String newStatus){
        this.status = newStatus;
    }

}
