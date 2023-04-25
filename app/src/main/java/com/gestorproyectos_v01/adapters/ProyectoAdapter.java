package com.gestorproyectos_v01.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gestorproyectos_v01.R;
import com.gestorproyectos_v01.modelos.Proyecto;

import io.realm.Realm;
import io.realm.RealmResults;

public class ProyectoAdapter extends  RecyclerView.Adapter<ProyectoAdapter.Holders>{

    private Context context;
    private Realm realm;
    private RealmResults<Proyecto> realmResults;
    private LayoutInflater inflater;

    public ProyectoAdapter(Context context, Realm realm, RealmResults<Proyecto> realmResults) {
        this.context = context;
        this.realm = realm;
        this.realmResults = realmResults;
        this.inflater = LayoutInflater.from(context);
    }



    @NonNull
    @Override
    public Holders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_proyecto, parent, false);
        Holders holders = new Holders(view);

        return holders;
    }

    @Override
    public void onBindViewHolder(@NonNull Holders holder, int position) {

        Proyecto proyecto = realmResults.get(position);
        holder.getProyectos(proyecto, position);

    }

    @Override
    public int getItemCount() {
        return realmResults.size();
    }

    public class Holders extends RecyclerView.ViewHolder{

        private int position;
        private TextView proy_name, proy_descrip;
        private ImageView editProy, deleteProy;

        public Holders(@NonNull View itemView) {
            super(itemView);
            proy_name = itemView.findViewById(R.id.txt_nombre_proy);
            proy_descrip = itemView.findViewById(R.id.txt_descripcion_proy);
            //editProy = itemView.findViewById(R.id.edit_image_view);
            //deleteProy = itemView.findViewById(R.id.delete_image_view);
        }

        public void getProyectos(Proyecto proyecto, int position){

            this.position = position;
            String nombre = proyecto.getNombre_proyecto();
            String descripcion = proyecto.getDescripcion_proyecto();

            proy_name.setText(nombre);
            proy_descrip.setText(descripcion);

        }

    }

}
