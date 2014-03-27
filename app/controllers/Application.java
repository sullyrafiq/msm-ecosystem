package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return redirect(routes.Login.login());
    }

    public static Result introduction() {
    	return ok(introduction.render("MSM Eco-System"));
    }

}
