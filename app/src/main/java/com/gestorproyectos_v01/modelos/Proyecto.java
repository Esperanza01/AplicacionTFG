package com.gestorproyectos_v01.modelos;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Proyecto extends RealmObject implements Parcelable {

    @PrimaryKey
    private String id;

    @Required
    private String nombre_proyecto;

    private String descripcion_proyecto;

    //private String tipo_proy;
    //private boolean pendiente;

    public enum tipo_proyecto{
        MANUAL, LIBRE, IOT
    }

    public Proyecto(){

    }

    public Proyecto(String nombre_proyecto, String desc/*, boolean pendiente*/) {
        this.nombre_proyecto = nombre_proyecto;
        this.descripcion_proyecto = desc;
        //this.pendiente = pendiente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    public String getDescripcion_proyecto() {
        return descripcion_proyecto;
    }

    public void setDescripcion_proyecto(String descripcion_proyecto) {
        this.descripcion_proyecto = descripcion_proyecto;
    }
/*
    public boolean isPendiente() {
        return pendiente;
    }

    public void setPendiente(boolean pendiente) {
        this.pendiente = pendiente;
    }*/

    @Override
    public String toString() {
        return "Proyecto{" +
                "id=" + id +
                ", nombre_proyecto='" + nombre_proyecto + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.nombre_proyecto);
        //dest.writeValue(this.pendiente);
    }

    protected Proyecto(Parcel in){
        this.id = in.readString();
        this.nombre_proyecto = in.readString();
        //this.pendiente = (boolean) in.readValue(boolean.class.getClassLoader());
    }

    public static final Creator<Proyecto> CREATOR = new Creator<Proyecto>(){

        @Override
        public Proyecto createFromParcel(Parcel source) {
            return new Proyecto(source);
        }

        @Override
        public Proyecto[] newArray(int size) {
            return new Proyecto[size];
        }
    };

}
