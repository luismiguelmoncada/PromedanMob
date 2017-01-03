package com.evolution.promedan.promedanmob.view;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.evolution.promedan.promedanmob.Model.Usuario;
import com.evolution.promedan.promedanmob.R;
import com.evolution.promedan.promedanmob.TestRetrofit2.RestApi;
import com.evolution.promedan.promedanmob.TestRetrofit2.UsuarioTest;
import com.evolution.promedan.promedanmob.view.Login_Registre.Constants;
import com.evolution.promedan.promedanmob.view.Login_Registre.RegisterAPI;
import com.evolution.promedan.promedanmob.view.Login_Registre.RequestInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import okhttp3.OkHttpClient;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistreActivity extends AppCompatActivity implements View.OnClickListener{


    //Declaring views
    private EditText editTextName;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextEmail;

    private Button buttonRegister;

    //This is our root url
    public static final String ROOT_URL = "http://webserverandroid.site88.net/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
        //se ejecuta el toolbar y se le pasan propiedades, el nombre desde los recursos de strings
        verToolbar(getResources().getString(R.string.toolbar_titulo),true);

        //Initializing Views
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        //Adding listener to button
        buttonRegister.setOnClickListener(this);
    }

    public  void verToolbar(String titulo,Boolean UpButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar6);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(UpButton);

    }

    private void insertUserhttp()  {

        HttpClient httpClient = new DefaultHttpClient();

        HttpPost post = new HttpPost("http://webserverandroid.site88.net/");

        post.setHeader("content-type", "application/json");

        boolean resul = true;
        try
        {
            //Construimos el objeto cliente en formato JSON
            JSONObject dato = new JSONObject();

            dato.put("name","luis");
            dato.put("username", "asdDSDS2");
            dato.put("password", "asdDSDS2");
            dato.put("email", "asdDSDS2");

            StringEntity entity = new StringEntity(dato.toString());
            post.setEntity(entity);

            HttpResponse resp = httpClient.execute(post);
            String respStr = EntityUtils.toString(resp.getEntity());

            if(!respStr.equals("true"))
                Toast.makeText(RegistreActivity.this, "ooook", Toast.LENGTH_LONG).show();
                resul = false;
        }
        catch(Exception ex)
        {
            Log.e("ServicioRest","Error!", ex);
            resul = false;
        }
    }

    private void insertUser(){
        //Here we will handle the http request to insert user to mysql db
        //Creating a RestAdapter

        JSONObject dato = new JSONObject();

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        RegisterAPI api = adapter.create(RegisterAPI.class);

        //Defining the method insertuser of our interface
        api.insertUser(

                //Passing the values by getting it from editTexts
                editTextName.getText().toString(),
                editTextUsername.getText().toString(),
                editTextPassword.getText().toString(),
                editTextEmail.getText().toString(),

                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;

                        //An string to store output from the server
                        String output = "";

                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        //Displaying the output as a toast
                        Toast.makeText(RegistreActivity.this, output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        //If any error occured displaying the error as toast
                        Toast.makeText(RegistreActivity.this, error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
    }



    @Override
    public void onClick(View v) {
        insertUser();
    }
}
