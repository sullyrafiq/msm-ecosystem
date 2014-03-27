package models;

import play.data.validation.Constraints;

/**
 * Created by sully.rafiq on 27/03/2014.
 */
public class User {

    @Constraints.Required
    public String username;

    @Constraints.Required
    public String password;

}
