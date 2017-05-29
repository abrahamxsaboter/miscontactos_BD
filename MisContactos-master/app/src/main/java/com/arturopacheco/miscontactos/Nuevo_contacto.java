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

            Intent evento;
            evento = new Intent(this, MainActivity.class);

            String nombre1 = nombre.getText().toString();
            String telefono1 = telefono.getText().toString();
            String correo1 = correo.getText().toString();
            try {
                                                       //Esta clase BaseDatos Puerto VersionSQL
                SqlLiteHelper sql = new SqlLiteHelper ( this, "contacts.db", null, 1 );
                SQLiteDatabase db = sql.getWritableDatabase (); // nos permite escribir dentro de la base de datos

                db.execSQL ( "INSERT INTO contact (" +
                        "nombre,telefono,email) VALUES ('" + nombre1 + "','" + telefono1 + "','" + correo1 + "')" );
                db.close ();
                Toast.makeText ( this, "Se ingreso correctamente el contacto", Toast.LENGTH_SHORT ).show ();

                startActivity ( evento );
            }catch (Exception e){
                Toast.makeText ( this,e.getMessage ().toString (),Toast.LENGTH_SHORT ).show ();
            }

    }


}
