package controllers;

import be.objectify.deadbolt.java.actions.SubjectPresent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.msm.ecosystem.util.JsonUtils;
import dao.ServicesDao;
import models.Home;
import models.HomeQuote;
import models.InsuranceQuote;
import models.Vehicle;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: opeyemi.ajayi
 * Date: 27/03/14
 * Time: 18:28
 * To change this template use File | Settings | File Templates.
 */

public class Services extends Controller {

    @SubjectPresent
    public static Result cars(String postCode, String callback) throws JsonProcessingException {

        ServicesDao servicesDao = new ServicesDao();

        List<Vehicle> vehicleList = servicesDao.getVehiclesNearYou(postCode);

        ObjectNode resultsObject = Json.newObject();

        resultsObject.putPOJO("vehicles", vehicleList);

        String result = JsonUtils.toString(resultsObject);

        if (callback != null) {
            return createJsonPWrappedResult(callback, result);
        } else {
            return ok(result).as("application/json");
        }
    }

    @SubjectPresent
    public static Result motorQuotes(String registration, String callback) throws JsonProcessingException {

        ServicesDao servicesDao = new ServicesDao();

        List<InsuranceQuote> insuranceQuotes = servicesDao.getQuotesForRegistration(registration);

        ObjectNode resultsObject = Json.newObject();

        resultsObject.putPOJO("motorQuotes", insuranceQuotes);

        String result = JsonUtils.toString(resultsObject);

        if (callback != null) {
            return createJsonPWrappedResult(callback, result);
        } else {
            return ok(result).as("application/json");
        }
    }

    @SubjectPresent
    public static Result homes(String postCode, String callback) throws JsonProcessingException {

        ServicesDao servicesDao = new ServicesDao();

        List<Home> insuranceQuotes = servicesDao.getHomesNearYou(postCode);

        ObjectNode resultsObject = Json.newObject();

        resultsObject.putPOJO("homeQuotes", insuranceQuotes);

        String result = JsonUtils.toString(resultsObject);

        if (callback != null) {
            return createJsonPWrappedResult(callback, result);
        } else {
            return ok(result).as("application/json");
        }

    }

    @SubjectPresent
    public static Result homeQuotes(String postCode, String callback) throws JsonProcessingException {

        ServicesDao servicesDao = new ServicesDao();

        List<HomeQuote> insuranceQuotes = servicesDao.getQuotesForPostcode(postCode);

        ObjectNode resultsObject = Json.newObject();

        resultsObject.putPOJO("homeQuotes", insuranceQuotes);

        String result = JsonUtils.toString(resultsObject);

        if (callback != null) {
            return createJsonPWrappedResult(callback, result);
        } else {
            return ok(result).as("application/json");
        }
    }

    private static Result createJsonPWrappedResult(String callback, String json) {
        String content = callback + "(" + json + ")";
        return ok(content);
    }

}
