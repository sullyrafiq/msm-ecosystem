package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.msm.ecosystem.security.SecurityUtils;
import com.msm.ecosystem.util.JsonUtils;
import models.UserMSM;
import play.data.Form;
import play.libs.Json;
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
        if (SecurityUtils.isSubjectPresent(session())) {
            return redirect(routes.Login.success());
        } else {
            return ok(views.html.login.render(userForm));
        }
    }

    public static Result logout(String callback) {
        SecurityUtils.removeUserFromSession(session());

        if (callback != null) {
            return createOKJsonPWrappedResult(callback, "{\"success\": true }");
        } else {
            return ok("You have been logged out");
        }
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

    public static Result ajaxLogin(String callback, String email, String password) throws JsonProcessingException {

        ObjectNode jsonNode = Json.newObject();
        jsonNode.put("username", email);
        jsonNode.put("password", password);

        Form<UserMSM> userMSMForm = Form.form(UserMSM.class).bind(jsonNode);

        if (userMSMForm.hasErrors()) {
            return createBadJsonPWrappedResult(callback, String.format("{\"success\": false, \"errors\": %s}", userMSMForm.errorsAsJson()));

        } else {
            UserMSM userMSM = userMSMForm.get();
            userMSM.setRole("admin");
            SecurityUtils.storeUserInSession(session(), userMSM);

            return createOKJsonPWrappedResult(callback, JsonUtils.toString(Json.newObject()));
        }
    }

    private static Result createOKJsonPWrappedResult(String callback, String json) {
        String content = callback + "(" + json + ")";
        return ok(content);
    }

    private static Result createBadJsonPWrappedResult(String callback, String json) {
        String content = callback + "(" + json + ")";
        return ok(content);
    }


}
