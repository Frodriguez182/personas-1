package com.example.soporte.personas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by soporte on 04/04/2017.
 */

public class Datos {


   public static ArrayList<Persona> traerPersonas(Context contexto){
       //Declaro variables
       SQLiteDatabase db;
       String sql, foto,nombre,apellido,pasatiempo;
       int edad;
       ArrayList<Persona> personas = new ArrayList();

       //Abrir la base de datos de lectura
       PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto,"DBPersonas",null,1);
       db = aux.getReadableDatabase();

       //Cursor
       sql = "Select foto, nombre, apellido, edad, pasatiempo from Personas";
       Cursor c = db.rawQuery(sql,null);

       //Recorrido del cursor
       if(c.moveToFirst()){
           do{
               foto = c.getString(0);
               nombre = c.getString(1);
               apellido = c.getString(2);
               edad = Integer.parseInt(c.getString(3));
               pasatiempo = c.getString(4);

               Persona p = new Persona(foto,nombre,apellido,edad,pasatiempo);
               personas.add(p);
           }while(c.moveToNext());
       }

       // cierro la conexión
       db.close();

       //retorno Personas
       return personas;
   }

    public static Persona buscarPersona(Context contexto,String nomb){
        //Declaro variables
        SQLiteDatabase db;
        String sql, foto,nombre,apellido,pasatiempo;
        int edad;
        Persona p=null;

        //Abrir la base de datos de lectura
        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto,"DBPersonas",null,1);
        db = aux.getReadableDatabase();

        //Cursor
        sql = "Select foto, nombre, apellido, edad, pasatiempo from Personas where nombre like '%"+nomb+"%'";
        Cursor c = db.rawQuery(sql,null);

        //Recorrido del cursor
        if(c.moveToFirst()){

                foto = c.getString(0);
                nombre = c.getString(1);
                apellido = c.getString(2);
                edad = Integer.parseInt(c.getString(3));
                pasatiempo = c.getString(4);

                 p = new Persona(foto,nombre,apellido,edad,pasatiempo);
                return p;

        }

        // cierro la conexión
        db.close();

        //retorno Personas
        return p;
    }
}
