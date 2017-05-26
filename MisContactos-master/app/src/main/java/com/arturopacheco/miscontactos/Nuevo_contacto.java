package com.arturopacheco.miscontactos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Nuevo_contacto extends AppCompatActivity  {
    TextInputEditText nombre, telefono,correo;
    SqlLiteHelper sql;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);

        nombre = (TextInputEditText)findViewById(R.id.personName);
        telefono = (TextInputEditText)findViewById(R.id.personTel);
        correo=(TextInputEditText)findViewById(R.id.personEmail);
        b1 = (Button)findViewById(R.id.buttonAgregar);


    }
    public void INSERTAR(View v) {
        try {
            Intent evento;
            evento = new Intent(this, MainActivity.class);

            String nombre1 = nombre.getText().toString();
            String telefono1 = telefono.getText().toString();
            String correo1 = correo.getText().toString();


            sql.Insert(nombre1, telefono1, correo1);
            startActivity(evento);
        } catch (Exception e) {

            Toast.makeText(this,e.getMessage().toString(),Toast.LENGTH_LONG).show();
        }
    }


}
