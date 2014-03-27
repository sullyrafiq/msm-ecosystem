package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.msm.ecosystem.security.PrincipalStore;
import com.msm.ecosystem.util.UserIdentifierGenerator;
import models.User;
import play.data.Form;
import play.libs.F;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import static java.lang.String.format;
import static play.data.Form.form;

/**
 * Created by sully.rafiq on 27/03/2014.
 */
public class Login extends Controller {

    public static Result login() {
        JsonNode jsonNode = request().body().asJson();
        Form<User> userForm = form(User.class).bind(jsonNode);

        if(userForm.hasErrors()) {
            String json = format("{\"success\": false, \"errors\": %s}", userForm.errorsAsJson().toString());
            return createBadRequestJsonResult(json);

        } else {
            User user = userForm.get();
            user.uniqueIdentifier = UserIdentifierGenerator.generateUniqueId();

            PrincipalStore.login(user);
            return createOkRequestJsonResult();
        }
    }

    private static Result createBadRequestJsonResult(String json) {
        return badRequest(json).as("application/json");
    }

    private static Result createOkRequestJsonResult() {
        ObjectNode result = Json.newObject();
        result.put("status", "OK");
        return ok(result);
    }

}
