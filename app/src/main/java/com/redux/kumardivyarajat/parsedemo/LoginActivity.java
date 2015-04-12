package com.redux.kumardivyarajat.parsedemo;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;




public class LoginActivity extends ActionBarActivity {

    protected EditText mUserName;
    protected EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUserName = (EditText)findViewById(R.id.username);
        mPassword = (EditText)findViewById(R.id.password);



        Button mSignInButton = (Button)findViewById(R.id.login_button);
        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUserName.getEditableText().toString();
                String Password = mPassword.getEditableText().toString();
                username = username.trim();
                Password = Password.trim();

                if(username.isEmpty() || Password.isEmpty() ) {
                    AlertDialog.Builder  popup = new AlertDialog.Builder(LoginActivity.this);
                    popup.setTitle("OOPS!");
                    popup.setMessage("Seems like you left a field blank. Make sure that you fill all the fields.");
                    popup.setPositiveButton("OK",null);
                    AlertDialog dialog = popup.create();
                    dialog.show();
                } else {
                    ParseUser.logInInBackground(username, Password, new LogInCallback() {
                        public void done(ParseUser user, ParseException e) {
                            if (user != null) {
                                Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            } else {
                                // Signup failed. Look at the ParseException to see what happened.
                                AlertDialog.Builder  popup = new AlertDialog.Builder(LoginActivity.this);
                                popup.setTitle("OOPS!");
                                popup.setMessage(e.getMessage());
                                popup.setPositiveButton("OK",null);
                                AlertDialog dialog = popup.create();
                                dialog.show();
                            }
                        }
                    });
                }
            }
        });


        Button mSignUpButton = (Button)findViewById(R.id.signup_login);
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
        }

        return super.onOptionsItemSelected(item);
    }
}
