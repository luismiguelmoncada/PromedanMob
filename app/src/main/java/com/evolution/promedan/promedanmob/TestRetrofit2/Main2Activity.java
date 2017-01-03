package com.evolution.promedan.promedanmob.TestRetrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.evolution.promedan.promedanmob.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


public void InsertUsers(View v){
    Toast.makeText(Main2Activity.this, "entro a registro", Toast.LENGTH_LONG).show();


}


    public void getUsers(View v)
    {

        Call<List<UsuarioTest>> call = ApiClient.get().getUsers();

        call.enqueue(new Callback<List<UsuarioTest>>() {
            @Override
            public void onResponse(Call<List<UsuarioTest>> call, Response<List<UsuarioTest>> response) {
                List<UsuarioTest> users = response.body();
                TextView name = (TextView)findViewById(R.id.textView4);
                TextView email = (TextView)findViewById(R.id.textView5);
                for (UsuarioTest user : users) {

                    name.setText(user.getName());
                    email.setText(user.getEmail());
                }
            }

            @Override
            public void onFailure(Call<List<UsuarioTest>> call, Throwable t) {
                Log.d("my_tag", "ERROR: " + t.getMessage());
            }


        });

    }
}
