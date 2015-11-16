package com.idealdevelopers.dzirecybercafe.ui.Parse;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseCrashReporting;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

/**
 * Created by Project I on 8/25/2015.
 */
public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        Parse.enableLocalDatastore(this);
        ParseCrashReporting.enable(this);
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        Parse.initialize(this, "fzumBn28YYe68SF19EIbPdX7jTjlsJeStrtdPUyC", "7V76TVr5scMg20okNsV66WoAu5VQRMtURa0PyFQr");
        ParseInstallation.getCurrentInstallation().saveInBackground();
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
    }
}
