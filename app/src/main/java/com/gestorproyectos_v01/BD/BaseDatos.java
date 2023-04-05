package com.gestorproyectos_v01.BD;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;

import com.gestorproyectos_v01.modelos.Proyecto;
import com.gestorproyectos_v01.modelos.Usuario;

import io.realm.BuildConfig;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class BaseDatos {

    private static BaseDatos instance = new BaseDatos();
    public static BaseDatos getInstance() { return instance;}

    //Para hacer la conexíon a la bbdd se hace baseDatos.getInstance() yt devuelve el singleton

    private Realm con;

    private Class[] models = {Usuario.class, Proyecto.class};
    private int realmVersion;

    //devuelve un objeto realm con la conexión
    public Realm conectar(Context context){
        if(con == null){
            Realm.init(context);
            String nombre = "bbdd_gestor_proyectos_v03";
            /*
            AÑADIR PARA USAR MIGRACION (no funciona)

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            //DEPRECATED int versionCode = sharedPreferences.getInt("VERSION_CODE", 0);
            String versionName = sharedPreferences.getString("VERSION_NAME", "0");

            if(versionName.compareToIgnoreCase(BuildConfig.VERSION_NAME) != 0){
                realmVersion++; //TODO: esta vble de dónde sale (https://medium.com/anycode/android-automatic-migration-of-realm-schema-version-6d6e862ea8ff)
            } else if (realmVersion < 0) {
                realmVersion = 0;
            }
            sharedPreferences.edit().putString("VERSION_NAME", BuildConfig.VERSION_NAME).apply();

            RealmConfiguration config = new RealmConfiguration.Builder().name(nombre).schemaVersion(realmVersion).migration(new RealmMigrations(models)).build();
             */
            RealmConfiguration config = new RealmConfiguration.Builder().name(nombre).build();
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
/*
* con esta función conectar funciona (creando una nueva base de datos)
* public Realm conectar(Context context){
        if(con == null){
            Realm.init(context);
            String nombre = "bbdd_gestor_proyectos_v03";
            RealmConfiguration config = new RealmConfiguration.Builder().name(nombre).build();
            con = Realm.getInstance(config);
        }
        return con;
    }
* */