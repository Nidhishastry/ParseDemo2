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

        Parse.initialize(this, "3gLhF7a7iVahhG3tef32em78RQES0l3FDKiHBqVm", "TSQyw3mocTBeM77MPdpVc9LjzecaPD7FvPoCneI0");
    }
}
