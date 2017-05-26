package com.arturopacheco.miscontactos;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by arturopacheco on 25/05/17.
 */

public class SqlLiteHelper extends SQLiteOpenHelper{


    private static final String TABLE_NAME= "contact";
    private static final String KEY_ROWID = "id";

    private static final String DATABASE_NAME = "contacts.db";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    private static final String DATABASE_CREATE = "create table "+TABLE_NAME+" ( "+KEY_ROWID+" integer primary key autoincrement," +
            "nombre text not null, telefono text not null , email text);";

    public SqlLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //ejecuta la BD
        db.execSQL(DATABASE_CREATE);
        //Inserta un valor en la tabla
        db.execSQL("insert into " + TABLE_NAME + "("
                +   "nombre,telefono,email) values('Juan Perez','5534334455','juan@perez.com')");

    }

    public void Insert(String nombre, String tel, String correo){
            SQLiteDatabase db = null;
            db.execSQL(DATABASE_CREATE);
            db.execSQL("insert into " + TABLE_NAME + "(nombre,telefono,email) values('"+nombre+"','"+tel+"','"+correo+"')");
        }
        //nombre = (R.id.activity_detalles_contacto = nombre.charAt(nombre));




    //borra los registros (actualiza los datos)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
