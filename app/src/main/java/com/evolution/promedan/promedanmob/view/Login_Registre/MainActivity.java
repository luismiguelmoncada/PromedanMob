package com.evolution.promedan.promedanmob.view.Login_Registre;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.evolution.promedan.promedanmob.R;


public class MainActivity extends AppCompatActivity {

    private SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getPreferences(0);
        initFragment();

        //verToolbar("Layout de Prueba",true);

    }

    private void initFragment(){
       // Fragment fragment;
        if(pref.getBoolean(Constants.IS_LOGGED_IN,false)){
            //fragment = new ProfileFragment();
            ProfileFragment profileFragment= new ProfileFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame,profileFragment)
                    .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(null).commit();
        }else {
            //fragment = new LoginFragment();
            LoginFragment loginFragment= new LoginFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame,loginFragment)
                    .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(null).commit();
        }
        /*
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame,fragment);
        ft.commit();
        */
    }
/*
    public  void verToolbar(String titulo,Boolean UpButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(UpButton);

    }

*/




}
