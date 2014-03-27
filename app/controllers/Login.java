package controllers;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

/**
 * Created by sully.rafiq on 27/03/2014.
 */
public class Login extends Controller {

    static Form<User> userForm = Form.form(User.class);

    public static Result login() {
        return ok(views.html.login.render(userForm));
    }

    public static Result access() {
        System.out.println("Logging in");

        Form<User> filledForm = userForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(
                views.html.login.render(filledForm)
            );
        } else {
            return redirect(routes.Login.login());
        }
    }

}
