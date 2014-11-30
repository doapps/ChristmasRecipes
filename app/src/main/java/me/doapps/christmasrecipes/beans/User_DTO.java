package me.doapps.christmasrecipes.beans;

import com.parse.ParseClassName;
import com.parse.ParseUser;

/**
 * Created by jonathan on 29/11/2014.
 */
@ParseClassName("_User")
public class User_DTO extends ParseUser {
    private String username;
    private String email;
    private String password;

    public User_DTO(){}

    @Override
    public String getUsername() {
        return getString("username");
    }

    @Override
    public void setUsername(String username) {
        put("username",username);
    }

    @Override
    public String getEmail() {
        return getString("email");
    }

    @Override
    public void setEmail(String email) {
        put("email", email);
    }

    public String getPassword() {
        return getString("password");
    }

    @Override
    public void setPassword(String password) {
        put("password", password);
    }
}

