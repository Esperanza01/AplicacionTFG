package com.gestorproyectos_v01.BD;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class BaseDatos {

    private static BaseDatos instance = new BaseDatos();
    public static BaseDatos getInstance() { return instance;}

    //Para hacer la conexíon a la bbdd se hace baseDatos.getInstance() yt devuelve el singleton

    private Realm con;

    public Realm conectar(Context context){
        if(con == null){
            Realm.init(context);
            String nombre = "bbdd_gestor_proyectos_v02";
            RealmConfiguration config = new RealmConfiguration.Builder().name(nombre).build();
            con = Realm.getInstance(config);
        }
        return con;
    }


}
