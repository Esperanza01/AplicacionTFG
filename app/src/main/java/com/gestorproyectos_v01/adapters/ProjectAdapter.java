package com.gestorproyectos_v01.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.gestorproyectos_v01.R;
import com.gestorproyectos_v01.databinding.ItemProyectoBinding;
import com.gestorproyectos_v01.modelos.Proyecto;

import java.util.List;

public class ProjectAdapter extends  RecyclerView.Adapter<ProjectAdapter.UserViewHolder>{

    private List<Proyecto> proyectos;

    public ProjectAdapter(List<Proyecto> proyectos){
        this.proyectos = proyectos;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ItemProyectoBinding itemProyectoBinding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.item_proyecto,
                viewGroup,
                false
        );

        return new UserViewHolder(itemProyectoBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int pos) {

        Proyecto proyecto = proyectos.get(pos);
        userViewHolder.itemProyectoBinding.setProyecto(proyecto);

        if(pos % 2 == 0){
            userViewHolder.itemProyectoBinding.linLayout.setBackgroundColor(Color.LTGRAY);
        }

    }

    @Override
    public int getItemCount() {
        return proyectos.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{

        private ItemProyectoBinding itemProyectoBinding;

        public UserViewHolder(@NonNull ItemProyectoBinding itemView) {
            super(itemView.getRoot());
            this.itemProyectoBinding = itemView;
        }
    }

}
