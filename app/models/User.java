package models;

import play.data.validation.Constraints;

/**
 * Created by sully.rafiq on 27/03/2014.
 */
public class User {

    public String uniqueIdentifier;

    @Constraints.Required
    public String username;

    @Constraints.Required
    public String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (uniqueIdentifier != null ? !uniqueIdentifier.equals(user.uniqueIdentifier) : user.uniqueIdentifier != null)
            return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uniqueIdentifier != null ? uniqueIdentifier.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "uniqueIdentifier='" + uniqueIdentifier + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
