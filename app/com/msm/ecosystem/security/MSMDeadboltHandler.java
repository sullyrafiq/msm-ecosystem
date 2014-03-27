package com.msm.ecosystem.security;

import be.objectify.deadbolt.core.models.Subject;
import be.objectify.deadbolt.java.DeadboltHandler;
import be.objectify.deadbolt.java.DynamicResourceHandler;
import play.libs.F;
import play.mvc.Http;
import play.mvc.SimpleResult;

import static play.mvc.Results.forbidden;

/**
 * Created with IntelliJ IDEA.
 * User: sully.rafiq
 * Date: 27/03/14
 * Time: 18:50
 * To change this template use File | Settings | File Templates.
 */
public class MSMDeadboltHandler implements DeadboltHandler {

    @Override
    public F.Promise<SimpleResult> beforeAuthCheck(Http.Context context) {
        return null; // Apparently returning null means that everything is OK.
    }

    @Override
    public Subject getSubject(Http.Context context) {
        return SecurityUtils.getUserFromSession(context.session());
    }

    @Override
    public F.Promise<SimpleResult> onAuthFailure(Http.Context context, String content) {
        return F.Promise.promise(new F.Function0<SimpleResult>() {
            @Override
            public SimpleResult apply()  {
                return forbidden("authentication failure");
            }
        });
    }

    @Override
    public DynamicResourceHandler getDynamicResourceHandler(Http.Context context) {
        return null;
    }
}
