package controllers;

import com.msm.ecosystem.security.SecurityUtils;
import models.UserMSM;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

/**
 * Created with IntelliJ IDEA.
 * User: sully.rafiq
 * Date: 27/03/14
 * Time: 19:14
 * To change this template use File | Settings | File Templates.
 */
public class Login extends Controller {

    static Form<UserMSM> userForm = Form.form(UserMSM.class);

    public static Result index() {
        if (SecurityUtils.getUserFromSession(session()) != null) {
            return redirect(routes.Login.success());
        } else {
            return ok(views.html.login.render(userForm));
        }
    }

    public static Result logout() {
        SecurityUtils.removeUserFromSession(session());
        return ok("You have been logged out");
    }

    public static Result success() {
        return ok("You are logged in");
    }

    public static Result access() {
        Form<UserMSM> filledUserForm = userForm.bindFromRequest();

        if (filledUserForm.hasErrors()) {
            return badRequest(views.html.login.render(filledUserForm));

        } else {
            UserMSM userMSM = filledUserForm.get();
            userMSM.setRole("admin");
            SecurityUtils.storeUserInSession(session(), userMSM);
        }

        return redirect(routes.Login.success());
    }

}
