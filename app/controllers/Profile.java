package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.msm.ecosystem.util.JsonUtils;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by sully.rafiq on 27/03/2014.
 */
public class Profile extends Controller {

    public static Result data(String callback) throws JsonProcessingException {

        ObjectNode result = Json.newObject();
        result.put("html", "<p>You need to login</p>");

        return createJsonpWrappedResult(callback, JsonUtils.toString(result));
    }

    private static Result createJsonpWrappedResult(String callback, String json) {
        String content = callback + "(" + json + ")";
        return ok(content);
    }

}
