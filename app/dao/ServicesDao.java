package dao;

import models.Home;
import models.HomeQuote;
import models.InsuranceQuote;
import models.Vehicle;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: opeyemi.ajayi
 * Date: 27/03/14
 * Time: 18:36
 * To change this template use File | Settings | File Templates.
 */
public class ServicesDao {
    public List<Vehicle> getVehiclesNearYou(String postCode){

        Vehicle[] vehicles  =   {
                new Vehicle("Ford Focus", "A1", "", 456),
                new Vehicle("Ford Focus", "A1", "", 456),
                new Vehicle("Ford Focus", "A1", "", 456),
                new Vehicle("Ford Focus", "A1", "", 456),
                new Vehicle("Ford Focus", "A1", "", 456),
                new Vehicle("Ford Focus", "A1", "", 456)
        };

        return Arrays.asList(vehicles);
    }

    public List<InsuranceQuote> getQuotesForRegistration(String registration){

        InsuranceQuote[] insuranceQuotes = {
                new InsuranceQuote("Cover", 150),
                new InsuranceQuote("Cover", 150)
        };

        return Arrays.asList(insuranceQuotes);
    }

    public List<Home> getHomesNearYou(String postCode) {
        Home[] homes  =   {
                new Home(650000, "Lorem Ipsum blahdy blah blah", "Shannon Drive, Chester", "/assets/images/MassiveHouse1.jpg"),
                new Home(749500, "Lorem Ipsum blahdy blah blah", "Huntington Road, Saltney", "/assets/images/MassiveHouse2.jpg"),
                new Home(250000, "Lorem Ipsum blahdy blah blah", "Pulwood, Saltney", "/assets/images/MassiveHouse3.jpg"),
                new Home(450000, "Lorem Ipsum blahdy blah blah", "Shannon Close, Saltney", "/assets/images/MassiveHouse4.jpg"),
                new Home(127850, "Lorem Ipsum blahdy blah blah", "Curtzn Park North", "/assets/images/MassiveHouse5.jpg"),
                new Home(124700, "Lorem Ipsum blahdy blah blah", "Lime Wood Close, Chester", "/assets/images/MassiveHouse6.jpg"),
                new Home(450000, "Lorem Ipsum blahdy blah blah", "Church Lane, Chester", "/assets/images/MassiveHouse1.jpg"),
                new Home(300000, "Lorem Ipsum blahdy blah blah", "Withering Lane, Handbridge", "/assets/images/MassiveHouse2.jpg"),
                new Home(225000, "Lorem Ipsum blahdy blah blah", "Bridgeway, Chester", "/assets/images/MassiveHouse3.jpg"),
        };

        return Arrays.asList(homes);
    }

    public List<HomeQuote> getQuotesForPostcode(String postCode) {
        HomeQuote[] homeInsuranceQuotes = {
                new HomeQuote("Buildings Cover", 94.95, true, false, true, 400),
                new HomeQuote("Buildings Cover & Contents", 105.95, true, false, true, 400),
                new HomeQuote("Buildings Cover", 124.95, false, false, true, 400),
                new HomeQuote("Buildings Cover", 130.95, true, true, false, 350),
                new HomeQuote("Buildings Cover", 140.95, true, false, true, 200),
                new HomeQuote("Buildings Cover", 145.95, true, false, true, 300),
                new HomeQuote("Buildings Cover", 155.95, true, false, true, 450),
                new HomeQuote("Buildings Cover", 180.95, true, false, true, 500),
                new HomeQuote("Buildings Cover", 194.95, true, false, true, 450),
                new HomeQuote("Buildings Cover & Contents", 294.95, true, false, true, 200),
        };

        return Arrays.asList(homeInsuranceQuotes);
    }
}
