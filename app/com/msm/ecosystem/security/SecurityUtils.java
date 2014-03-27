package com.msm.ecosystem.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.UserMSM;
import play.mvc.Http;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: sully.rafiq
 * Date: 27/03/14
 * Time: 18:54
 * To change this template use File | Settings | File Templates.
 */
public class SecurityUtils {

    private static final String SESSION_USER = "user";

    private static ObjectMapper objectMapper;

    /**
     * Class should not be constructed
     */
    private SecurityUtils() {
    }

    public static void removeUserFromSession(Http.Session session) {
        session.remove(SESSION_USER);
    }

    /**
     * Store the User object in the session.
     *
     * @param session The Http Session - Note Session here is a Play Session, which is really a Cookie Client-side!
     * @param user The BackOffice User
     */
    public static void storeUserInSession(Http.Session session, UserMSM user) {
        try {
            session.put(SESSION_USER, getObjectMapper().writeValueAsString(user));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Unexpected exception writing user " + user.getUsername(), e);
        }
    }

    /**
     * Get the user form the session.
     *
     * @param session The http session.
     * @return The User object.
     */
    public static UserMSM getUserFromSession(Http.Session session) {
        String userJson = session.get(SESSION_USER);
        if (userJson == null) {
            return null;
        } else {
            try {
                return getObjectMapper().readValue(userJson, UserMSM.class);
            } catch (IOException e) {
                throw new IllegalStateException("Unexpected exception reading user " + userJson, e);
            }
        }
    }

    /**
     * Determine if a user is logged in
     *
     * @param session
     * @return
     */
    public static boolean isSubjectPresent(Http.Session session) {
        return session.get(SESSION_USER) != null;
    }

    /**
     * Returns the ObjectMapper, throws IllegalStateException if variable not set.
     * @return The specialised ObjectMapper.
     */
    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        return objectMapper;
    }


}
