package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.msm.ecosystem.security.SecurityUtils;
import com.msm.ecosystem.util.JsonUtils;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by sully.rafiq on 27/03/2014.
 */
public class Widgets extends Controller {

    public static Result signIn(String callback, String channel) throws JsonProcessingException {

        ObjectNode result = Json.newObject();

        if (SecurityUtils.isSubjectPresent(session())) {

            result.put("html", "<div class=\"container\">\n" +
                    "\t\t\t\t\t\t<div class=\"signedin\">\n" +
                    "\t\t\t\t\t\t\t<h3>Your signed in with <strong>MoneySuperMarket</strong></h3>\n" +
                    "\t\t\t\t\t\t\t<div class=\"button-container\">\n" +
                    "\t\t\t\t\t\t\t\t<input type=\"submit\" value=\"Sign out\" id=\"signout\" class=\"btn\" />\n" +
                    "\t\t\t\t\t\t\t\t<img class=\"powered-by display-none\" src=\"@routes.Assets.at(\"images/powered-by-msm-square.png\")\" alt=\"powered by msm\" />\n" +
                    "\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t<div class=\"header-text\">\n" +
                    "\t\t\t\t\t\t\t<p>\n" +
                    "\t\t\t\t\t\t\t\t<span class=\"blue-text\">Compare the</span> <span class=\"pink-text\">b&pound;st</span><span class=\"blue-text\">where you live</span> on " + channel + " insurance &amp; breakdown cover\n" +
                    "\t\t\t\t\t\t\t</p>\n" +
                    "\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t</div>");

        } else {

            result.put("html", "<div class=\"container\">\n" +
                    "\t\t\t\t\t\t<div class=\"signin\">\n" +
                    "\t\t\t\t\t\t\t<h3>Sign in with <strong>MoneySuperMarket</strong> account to see your best deals</h3>\n" +
                    "\t\t\t\t\t\t\t<input type=\"email\" name=\"EmailAddress\" id=\"emailAddress\" placeholder=\"Your email\" maxlength=\"50\" />\n" +
                    "\t\t\t\t\t\t\t<input type=\"password\" name=\"Password\" id=\"password\" placeholder=\"Password\" maxlength=\"20\" />\n" +
                    "\t\t\t\t\t\t\t<input type=\"submit\" value=\"Sign in\" class=\"btn\" />\n" +
                    "\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t<div class=\"header-text\">\n" +
                    "\t\t\t\t\t\t\t<p>\n" +
                    "\t\t\t\t\t\t\t\t<span class=\"blue-text\">Sign in to see your</span> <span class=\"pink-text\">b&pound;st</span> deals <span class=\"blue-text\">on</span> " + channel + " insurance &amp; breakdown cover\n" +
                    "\t\t\t\t\t\t\t</p>\n" +
                    "\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t</div>");

        }

        return createJsonPWrappedResult(callback, JsonUtils.toString(result));
    }

    private static Result createJsonPWrappedResult(String callback, String json) {
        String content = callback + "(" + json + ")";
        return ok(content);
    }

}
