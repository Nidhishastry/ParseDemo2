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

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class SignupActivity extends ActionBarActivity {
    protected EditText mUserName;
    protected EditText mPassword;
    protected EditText mName;
    protected EditText mEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mUserName = (EditText)findViewById(R.id.signup_username);
        mPassword = (EditText)findViewById(R.id.signup_password);
        mName = (EditText)findViewById(R.id.name);
        mEmail = (EditText)findViewById(R.id.email);


        Button mSignUpButton = (Button)findViewById(R.id.signup);
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String Username = mUserName.getEditableText().toString();
                 String Password = mPassword.getEditableText().toString();
                 String Name = mName.getEditableText().toString();
                 String EmailId = mEmail.getEditableText().toString();

                Username = Username.trim();
                Password = Password.trim();
                Name = Name.trim();
                EmailId =EmailId.trim();

                if(Username.isEmpty() || Password.isEmpty() || Name.isEmpty() || EmailId.isEmpty()) {
                    AlertDialog.Builder  popup = new AlertDialog.Builder(SignupActivity.this);
                    popup.setTitle("OOPS!");
                    popup.setMessage("Seems like you left a field blank. Make sure that you fill all the fields.");
                    popup.setPositiveButton("OK",null);
                    AlertDialog dialog = popup.create();
                    dialog.show();
                } else {
                    ParseUser user = new ParseUser();
                    user.setUsername(Username);
                    user.setEmail(EmailId);
                    user.setPassword(Password);
                    user.put("Name",Name);
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if(e== null) {
                                Intent intent = new Intent(SignupActivity.this, Main2Activity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            } else {
                                AlertDialog.Builder  popup = new AlertDialog.Builder(SignupActivity.this);
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




// other fields can be set just like with ParseObject




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signup, menu);
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
