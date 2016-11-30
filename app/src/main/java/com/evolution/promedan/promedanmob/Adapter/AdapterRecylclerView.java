package com.evolution.promedan.promedanmob.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.evolution.promedan.promedanmob.Model.Picture;
import com.evolution.promedan.promedanmob.R;
import com.evolution.promedan.promedanmob.view.PictureDetailActivity;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by LUISM on 26/11/2016.
 */

//Este es el adapter, utilizara la clase para crear o reciclar tantos views como sean necesarios a partir del modelo(Picture)
public class AdapterRecylclerView extends RecyclerView.Adapter<AdapterRecylclerView.PicturevewHolder>{ //(clic derecho antes de { - implementaar metodos)

    private ArrayList<Picture> pictures; //Arreglo de objetos de tipo Picture
    private int resource; //Recurso donde estara el layout de nuestro cardview
    private Activity activity;  //Objeto actividad de donde se esta llamando AdapterRecylclerView

    //Constructor para lo elementos anteriores (clic derecho, Generar- constructor)
    public AdapterRecylclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    /* Inicializa la clase PicturevewHolder, le pasa el layout (resorce)*/
    public PicturevewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new PicturevewHolder(view);
    }

    @Override
    /*Asigna los datos del modelo a los correspondientes cards que se crearan*/
    public void onBindViewHolder(PicturevewHolder holder, int position) {
        Picture picture = pictures.get(position);
        //Se accede a los views que se crearon previamente desde el PictureViewHolder
        holder.usernameCard.setText(picture.getUsernameCard());
        holder.firstWord.setText(picture.getFirstWord());
        holder.secondWord.setText(picture.getSecondWord());
        //se utiliza la libreria picasso para traer imagenes desde internet y optimizar su uso
        Picasso.with(activity).load(picture.getImagen()).into(holder.imagen);

        //Puedo generar el onclic de cualquier view, en este caso la imagen
        //Defino en este metodo la transicion porque sera el que determine el cambio de pantallas, debo validar la version de android primero
        holder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, PictureDetailActivity.class);

                //Valido la version de Android, este formato de transicion es para clases de tipo recycler, en un activity no necesitamos activity.get...
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(i, ActivityOptionsCompat.makeSceneTransitionAnimation(activity,v,activity.getString(R.string.transition_name)).toBundle());

                }else{
                    activity.startActivity(i); //para poder lanzar la actividad, no se puede directo porq esto es un recycler view

                }
//TESTCOMMITjgjhg

            }
        });
    }

    @Override
    /*Retorna el numero de elemtos que contiene el arreglo de Objetos*/
    public int getItemCount() {
        return pictures.size();
    }

    // Primero se crea esta clase, (PicturevewHolder clase inner) esta clase se concentra solo en crear un cardview a la vez, el adapter (AdapterRecylclerView) se encargara de crear los necesarios
    public class PicturevewHolder extends RecyclerView.ViewHolder{

        //private ImageView pictureCard;
        private TextView usernameCard;
        private TextView firstWord;
        private TextView secondWord;
        private ImageView imagen;

        //Constructor (RecyclerView.ViewHolder{ ALT + Enter antes de { para crear el constructor automaticamente)
        public PicturevewHolder(View itemView) {
            super(itemView);

            usernameCard = (TextView) itemView.findViewById(R.id.UsernameCard);
            firstWord    = (TextView) itemView.findViewById(R.id.firstWord);
            secondWord   = (TextView) itemView.findViewById(R.id.secondWord);
            imagen       = (ImageView) itemView.findViewById(R.id.card_imagen);
        }
    }
}
