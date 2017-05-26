package com.arturopacheco.miscontactos;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Nuevo_contacto extends AppCompatActivity  {
    TextInputEditText nombre, telefono,correo;
    SqlLiteHelper sql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);

        nombre = (TextInputEditText)findViewById(R.id.personName);
        telefono = (TextInputEditText)findViewById(R.id.personTel);
        correo=(TextInputEditText)findViewById(R.id.personEmail);


    }

    public void Agregar(){
        Intent evento;
        evento = new Intent(this,MainActivity.class);

        String nom = nombre.getText().toString();
        String email = correo.getText().toString();
        String tel= telefono.getText().toString();
        int tel1 = Integer.parseInt(tel);

        /*
        sql = new SqlLiteHelper();
        sql.Insert(nom,email,tel1);
*/
    }

}
