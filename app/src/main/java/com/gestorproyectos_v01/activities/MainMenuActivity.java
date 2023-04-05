package com.gestorproyectos_v01.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.gestorproyectos_v01.BD.BaseDatos;
import com.gestorproyectos_v01.R;
import com.gestorproyectos_v01.adapters.ProjectAdapter;
import com.gestorproyectos_v01.databinding.ActivityMainMenuBinding;
import com.gestorproyectos_v01.modelos.Proyecto;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class MainMenuActivity extends AppCompatActivity {

    private Realm con;

    private ActivityMainMenuBinding mainMenuBinding;
    private ProjectAdapter projectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        con = BaseDatos.getInstance().conectar(getBaseContext());

        mainMenuBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_menu);
        mainMenuBinding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        mainMenuBinding.recyclerview.setHasFixedSize(true);

        projectAdapter = new ProjectAdapter(getProyectos());
        mainMenuBinding.recyclerview.setAdapter(projectAdapter);
        mainMenuBinding.executePendingBindings();

    }

    private List<Proyecto> getProyectos(){

        List<Proyecto> proyectos = new ArrayList<>();
        Proyecto proyecto01 = new Proyecto("Test01");
        Proyecto proyecto02 = new Proyecto("Test02");

        proyectos.add(proyecto01);
        proyectos.add(proyecto02);

        return proyectos;
    }


}