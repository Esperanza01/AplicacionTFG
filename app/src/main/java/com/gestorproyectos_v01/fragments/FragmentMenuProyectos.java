package com.gestorproyectos_v01.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gestorproyectos_v01.BD.BaseDatos;
import com.gestorproyectos_v01.R;
import com.gestorproyectos_v01.adapters.ProjectAdapter;
import com.gestorproyectos_v01.modelos.Proyecto;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

//TODO: adaptar clase activity_main_menu a este fragment
public class FragmentMenuProyectos extends Fragment {

    private Realm con;
    private List<Proyecto> proyectos;

    private ProjectAdapter projectAdapter;
    private RecyclerView recyclerView;


    public FragmentMenuProyectos() {
        // Required empty public constructor
    }

    public static FragmentMenuProyectos newInstance(String param1, String param2) {
        FragmentMenuProyectos fragment = new FragmentMenuProyectos();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_proyectos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInitialize();
/*
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        projectAdapter = new ProjectAdapter(getContext(), proyectos);
        recyclerView.setAdapter(projectAdapter);
        projectAdapter.notifyDataSetChanged();
*/
    }

    private void dataInitialize() {

        proyectos = new ArrayList<>();
        //lo mismo que getproyectos


    }


    private List<Proyecto> getProyectos(){

        //TODO: tomar los datos de la bbdd
        /*List<Proyecto> proyectos = new ArrayList<>();
        Proyecto proyecto01 = new Proyecto("Test01");
        Proyecto proyecto02 = new Proyecto("Test02");

        proyectos.add(proyecto01);
        proyectos.add(proyecto02);
*/
        return null;
    }

}