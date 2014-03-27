package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok("Up and running");
    }

    public static Result introduction() {
    	return ok(introduction.render("MSM Eco-System"));
    }

     public static Result carDetails() {
    	return ok(carDetails.render("Policy details - Car Insurance"));
    }

}
