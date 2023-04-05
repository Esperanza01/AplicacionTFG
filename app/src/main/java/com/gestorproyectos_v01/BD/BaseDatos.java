package com.gestorproyectos_v01.BD;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class BaseDatos {

    private static BaseDatos instance = new BaseDatos();
    public static BaseDatos getInstance() { return instance;}

    //Para hacer la conexíon a la bbdd se hace baseDatos.getInstance() yt devuelve el singleton

    private Realm con;

    //devuelve un objeto realm con la conexión
    public Realm conectar(Context context){
        if(con == null){
            Realm.init(context);
            String nombre = "bbdd_gestor_proyectos_v02";
            RealmConfiguration config = new RealmConfiguration.Builder().name(nombre).schemaVersion(2).migration(new RealmMigrations()).build();
            Realm.setDefaultConfiguration(config);
            con = Realm.getInstance(config);
        }
        return con;
    }

    //cierra la conexíon con la base de datos (TODO:buscar si existe método onTerminate)
    public void desconectar(Context context){
        Realm.getDefaultInstance().close();
    }

}
