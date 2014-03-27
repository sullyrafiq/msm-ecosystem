package models;

/**
 * Created with IntelliJ IDEA.
 * User: opeyemi.ajayi
 * Date: 27/03/14
 * Time: 18:38
 * To change this template use File | Settings | File Templates.
 */
public class Vehicle {

    private double price;
    private String vehicleDescription;
    private String vehicleRegistration;
    private String imageURL;

    public Vehicle(String vehicleDescription, String vehicleReg, String imageURL, double price){
        this.vehicleDescription = vehicleDescription;
        this.vehicleRegistration = vehicleReg;
        this.imageURL = imageURL;
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }


    public String getVehicleDescription() {
        return vehicleDescription;
    }

    public double getPrice() {
        return price;
    }

}
