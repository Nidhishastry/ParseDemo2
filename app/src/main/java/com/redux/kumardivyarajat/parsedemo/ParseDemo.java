package com.redux.kumardivyarajat.parsedemo;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by kumardivyarajat on 09/04/15.
 */
public class ParseDemo extends Application {

    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "5xEcI5tZ7W0NSl6uQYF1Ls3vLa6GMEZBeHIJgL8K", "G7YL6IpJSNtwFsd2SOz8K4JjfGrlyynZZkCoe8mS");
    }
}
