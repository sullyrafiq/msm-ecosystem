package com.msm.ecosystem.security;

import models.User;

import java.util.Map;

/**
 * Created by sully.rafiq on 27/03/2014.
 */
public class PrincipalStore {

    private static Map<String, User> users;

    public static void login(User userToLogIn) {
        users.put(userToLogIn.uniqueIdentifier, userToLogIn);
    }

    public static void logout(User userToLogout) {
        users.remove(userToLogout.uniqueIdentifier);
    }

    public static boolean isLoggedIn(String uniqueIdentifier) {
        return users.get(uniqueIdentifier) != null;
    }

}
