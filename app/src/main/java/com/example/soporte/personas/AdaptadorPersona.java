package com.example.soporte.personas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by soporte on 02/05/2017.
 */

public class AdaptadorPersona extends BaseAdapter {
    private Context contexto;
    private ArrayList<Persona> personas;

    public AdaptadorPersona(Context contexto, ArrayList<Persona> personas){
        this.contexto=contexto;
        this.personas=personas;
    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Object getItem(int position) {
        return personas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Declarar variables
        TextView nombre,apellido,edad;
        ImageView foto;
        LayoutInflater inflater;
        View itemView;

        //Uso del Inflater
        inflater = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView = inflater.inflate(R.layout.item_persona,null);

        //Captura de los objetos
        nombre = (TextView)itemView.findViewById(R.id.txtNombrePersona);
        apellido = (TextView)itemView.findViewById(R.id.txtApellidoPersona);
        edad = (TextView)itemView.findViewById(R.id.txtEdadPersona);
        foto = (ImageView)itemView.findViewById(R.id.imgFoto);

        //Pasar la información

        nombre.setText(personas.get(position).getNombre());
        apellido.setText(personas.get(position).getApellido());
        edad.setText(""+personas.get(position).getEdad());
        foto.setImageResource(Integer.parseInt(personas.get(position).getFoto()));

        //retornar itemview

        return itemView;
    }
}
