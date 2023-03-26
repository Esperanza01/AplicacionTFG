package com.gestorproyectos_v01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gestorproyectos_v01.BD.BaseDatos;
import com.gestorproyectos_v01.modelos.Usuario;

import io.realm.Realm;

public class UserRegisterActivity extends AppCompatActivity {

    private int id;
    private EditText usuario;
    private EditText password;
    private EditText password2;

    private Realm con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        id = 1;
        usuario = findViewById(R.id.usuario_regis);
        password = findViewById(R.id.password_regis);
        password2 = findViewById(R.id.password_regis2);

        con = BaseDatos.getInstance().conectar(getBaseContext());

        Button btn_guardar = findViewById(R.id.btn_guardar_regis);
        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
            }
        });

    }

    private void guardar() {

        if(password.getText().toString().equals(password2.getText().toString())){
            try{
                Usuario u = new Usuario();
                u.setId(id + 1);
                u.setNombre(usuario.getText().toString());
                u.setPassword(password.getText().toString());
                con.beginTransaction();
                con.copyToRealmOrUpdate(u);
                con.commitTransaction();
            } finally {
                con.close();
                Toast.makeText(this, "Usuario creado", Toast.LENGTH_LONG).show();
            }
        } else{
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
        }


    }
}