package me.doapps.christmasrecipes.application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

import me.doapps.christmasrecipes.R;
import me.doapps.christmasrecipes.beans.Recipe_DTO;
import me.doapps.christmasrecipes.beans.User_DTO;

/**
 * Created by jonathan on 29/11/2014.
 */
public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(User_DTO.class);
        ParseObject.registerSubclass(Recipe_DTO.class);

        Parse.initialize(this, getResources().getString(R.string.application_id), getResources().getString(R.string.client_key));

        ParseUser.enableAutomaticUser();

        ParseACL defaultACl = new ParseACL();
        defaultACl.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACl, true);
    }
}
