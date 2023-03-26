package com.gestorproyectos_v01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gestorproyectos_v01.BD.BaseDatos;
import com.gestorproyectos_v01.modelos.Usuario;

import io.realm.Realm;

public class UserModificationActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText password;

    private Realm con;

    //TODO menú desplegable para acceder a configuracion y modificar el ususario
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_modification);

        usuario = findViewById(R.id.usuario);
        password = findViewById(R.id.password);

        con = BaseDatos.getInstance().conectar(getBaseContext());

        Usuario u = con.where(Usuario.class).findFirst();
        usuario.setText(u.getNombre());
        password.setText(u.getPassword());

        Button btn_guardar = findViewById(R.id.btn_guardar);
        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
            }
        });

    }

    public void guardar(){
        con.beginTransaction();
        Usuario u = con.where(Usuario.class).findFirst();
        u.setNombre(usuario.getText().toString());
        u.setPassword(password.getText().toString());
        con.copyToRealmOrUpdate(u);
        con.commitTransaction();
    }
}