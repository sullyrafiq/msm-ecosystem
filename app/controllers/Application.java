package controllers;

import be.objectify.deadbolt.java.actions.SubjectPresent;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok("Up and running");
    }

    @SubjectPresent
    public static Result restricted() {
        return ok("You have access");
    }

    public static Result introduction() {
    	return ok(introduction.render("MSM Eco-System"));
    }

    public static Result carDetails() {
    	return ok(carDetails.render("Policy details - Car Insurance"));
    }

    public static Result homeDetails() {
    	return ok(homeDetails.render("Policy details - Home Insurance"));
    }

}
