package com.evolution.promedan.promedanmob.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.evolution.promedan.promedanmob.MainActivity;
import com.evolution.promedan.promedanmob.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class LoginActivity extends FragmentActivity  {

    private EditText loginEmail;
    private EditText loginPass;

    //libreria para evitar usar tanto codigo especialmente con los onclic, puedo hacer injeccion de codigo
    @InjectView(R.id.NoAccount)
    TextView sample_textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.inject(this);

        //boton de login
        Button login = (Button) findViewById(R.id.login);

        loginEmail = (EditText) findViewById(R.id.email);
        loginPass = (EditText) findViewById(R.id.password);


        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                        Login();
            }
        });
    }

    @OnClick(R.id.NoAccount)
    public void showToastMessage(){
        Toast.makeText(LoginActivity.this, "Prueba libreria JakeWharton", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
    }
    public void crearCuenta(View view){

      //  Toast.makeText(getApplicationContext(),"Crear cuenta",Toast.LENGTH_LONG).show();
        Intent i = new Intent(LoginActivity.this, RegistreActivity.class);
        startActivity(i);
    }
    private void Login() {

        Intent i = new Intent(LoginActivity.this, ContainerActivity.class);
        startActivity(i);

        //Intent i = new Intent(LoginActivity.this, NavigationDrawer.class);
        //startActivity(i);

        loginEmail.setError(null);
        loginPass.setError(null);

        // Store values at the time of the login attempt.
        String email = loginEmail.getText().toString();
        String password = loginPass.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        /*
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            loginPass.setError(getString(R.string.error_invalid_password));
            focusView = loginPass;
            cancel = true;
        }

        if (TextUtils.isEmpty(password)) {
            loginPass.setError(getString(R.string.error_field_required));
            focusView = loginPass;
            cancel = true;
        }
*/
        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            loginEmail.setError(getString(R.string.error_field_required));
            focusView = loginEmail;
            cancel = true;
        } else if (!isEmailValid(email)) {
            loginEmail.setError(getString(R.string.error_invalid_email));
            focusView = loginEmail;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {

        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

}

