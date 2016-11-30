package com.evolution.promedan.promedanmob.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evolution.promedan.promedanmob.Adapter.AdapterRecylclerView;
import com.evolution.promedan.promedanmob.Model.Picture;
import com.evolution.promedan.promedanmob.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        verToolbar("",false,view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL); //Orientacion puede ser Horizontal o Vertical

        /*Instancia e inicio del RecyclerView*/
        RecyclerView pictureRecyclerView = (RecyclerView) view.findViewById(R.id.picturerecycler_search);
        pictureRecyclerView.setLayoutManager(linearLayoutManager); // Se le asigna el LinearLayout al RecyclerView

        /*Inicializo el Adapter y le paso el arreglo de datos, el layout que debera pintarse con esos datos y la actividad actual*/
        AdapterRecylclerView adapterRecylclerView = new AdapterRecylclerView(buildPicture(),R.layout.cardview_picture,getActivity());
        pictureRecyclerView.setAdapter(adapterRecylclerView); //Le asigna un adapter al recyclerview


        return view;
    }


    public ArrayList<Picture> buildPicture(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("Luis Miguel Moncada Ocampo","HOLA","MUNDO","http://www.een.edu/blog/wp-content/uploads/2015/01/estrategia-956x597.jpg"));
        pictures.add(new Picture("Luis Miguel Moncada Ocampo","HOLA","MUNDO","http://www.een.edu/blog/wp-content/uploads/2015/01/estrategia-956x597.jpg"));
        pictures.add(new Picture("Luis Miguel Moncada Ocampo","HOLA","MUNDO","http://www.een.edu/blog/wp-content/uploads/2015/01/estrategia-956x597.jpg"));
        pictures.add(new Picture("Luis Miguel Moncada Ocampo","HOLA","MUNDO","http://www.een.edu/blog/wp-content/uploads/2015/01/estrategia-956x597.jpg"));

        return  pictures;
    }

    public  void verToolbar(String titulo,Boolean UpButton,View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(UpButton);

    }
}
