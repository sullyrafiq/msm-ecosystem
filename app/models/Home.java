package models;

/**
 * Created with IntelliJ IDEA.
 * User: opeyemi.ajayi
 * Date: 27/03/14
 * Time: 20:31
 * To change this template use File | Settings | File Templates.
 */
public class Home {
    private double price;
    private String homeDescription;
    private String address;
    private String imageURL;

    public double getPrice() {
        return price;
    }

    public String getHomeDescription() {
        return homeDescription;
    }

    public String getAddress() {
        return address;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Home(double price, String homeDescription, String address, String imageURL) {
        this.price = price;
        this.homeDescription = homeDescription;
        this.address = address;
        this.imageURL = imageURL;
    }
}
