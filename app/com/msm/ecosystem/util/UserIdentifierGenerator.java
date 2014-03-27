package com.msm.ecosystem.util;

/**
 * Created by sully.rafiq on 27/03/2014.
 */
public class UserIdentifierGenerator {

    public static String generateUniqueId() {
        return Long.toString(System.currentTimeMillis());
    }
}
