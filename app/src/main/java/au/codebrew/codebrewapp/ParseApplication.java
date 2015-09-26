package au.codebrew.codebrewapp;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by jizhizili on 26/09/15.
 */
public class ParseApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();



        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "C7eA7ylVEXc6H8QaNyEe77nq1PtugMkN3qsfYbmS", "XpFwWDviE8NTODB9Oqu7Bf36ALKS01XXSnLwpnJv");







    }




}