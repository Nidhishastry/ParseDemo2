package com.redux.kumardivyarajat.parsedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;


public class Main2Activity extends ActionBarActivity {

    public Students s;
    private List<Students> studentsList= new ArrayList<Students>();
    private CustomAdapter adapter;
     private  ListView lv;


    public static final String TAG = Main2Activity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        adapter = new CustomAdapter(this, studentsList);
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            // do stuff with the user
            Log.i(TAG,currentUser.getUsername());
        } else {
            // show the signup or login screen
            navigateToLogin();
        }
         lv = (ListView)findViewById(R.id.listView);
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Students");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if(e==null) {

                    for(ParseObject ob: parseObjects) {

                       s.setName(ob.getString("Name"));
                        s.setUSN(ob.getString("USN"));
                       // s.setPic(ob.getBytes());
                        s.setSemester(ob.getString("Semester"));
                        studentsList.add(s);


                        lv.setAdapter(adapter);

                       
                    }
                } else {
                    Toast.makeText(Main2Activity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void navigateToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_logout) {
            ParseUser.logOut();
            navigateToLogin();
        }

        return super.onOptionsItemSelected(item);
    }
}
