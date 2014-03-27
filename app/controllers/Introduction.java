package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Introduction extends Controller {

    public static Result index() {
        return ok(introduction.render("MSM Eco-System"));
    }

}
