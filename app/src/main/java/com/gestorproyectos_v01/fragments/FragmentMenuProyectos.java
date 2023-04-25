package com.gestorproyectos_v01.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gestorproyectos_v01.R;
import com.gestorproyectos_v01.activities.AddProyectoActivity;
import com.gestorproyectos_v01.adapters.ProyectoAdapter;
import com.gestorproyectos_v01.modelos.Proyecto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

//TODO: adaptar clase activity_main_menu a este fragment
public class FragmentMenuProyectos extends Fragment {

    private Realm con;
    private List<Proyecto> proyectos;
    private Context context;

    //para manejar el recycler view
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ProyectoAdapter proyectoAdapter;

    FloatingActionButton botonAdd;

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

        con = Realm.getDefaultInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_menu_proyectos, container, false);

        botonAdd = root.findViewById(R.id.btn_nuevo);

        botonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddProyectoActivity.class);
                startActivity(intent);

            }
        });


        return root;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getAllProyectos(view);

    }

    @Override
    public void onResume() {
        super.onResume();
        if(proyectoAdapter != null){
            proyectoAdapter.notifyDataSetChanged();
        }

    }

    private List<Proyecto> getAllProyectos(View view){

        RealmResults<Proyecto> results = con.where(Proyecto.class).findAll();
        recyclerView = view.findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        proyectoAdapter = new ProyectoAdapter( getContext(), con, results);
        recyclerView.setAdapter(proyectoAdapter);


        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        con.close();
    }
}