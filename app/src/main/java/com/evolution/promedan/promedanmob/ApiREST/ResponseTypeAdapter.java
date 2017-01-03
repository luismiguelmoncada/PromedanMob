package com.evolution.promedan.promedanmob.ApiREST;

import com.evolution.promedan.promedanmob.Model.Usuario;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by LUISM on 28/12/2016.
 */

public class ResponseTypeAdapter extends TypeAdapter{
    @Override
    public void write(JsonWriter out, Object value) throws IOException {

    }

    @Override
    public Object read(JsonReader reader) throws IOException {

        Usuario usuario = new Usuario();
        reader.nextName();
        reader.beginObject();

        while(reader.hasNext()){

            String next=reader.nextName();

            switch (next){
                case "name":
                    usuario.setName(reader.nextString());
                    break;
                case "username":
                    usuario.setUsername(reader.nextString());
                    break;
                case "email":
                    usuario.setEmail(reader.nextString());
                    break;
                case "password":
                    usuario.setPassword(reader.nextString());
                    break;
            }
        }

        reader.endObject();
        return usuario;
    }
}
