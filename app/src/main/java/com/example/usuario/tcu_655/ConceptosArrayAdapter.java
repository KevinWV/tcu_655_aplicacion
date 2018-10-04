package com.example.usuario.tcu_655;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import com.example.usuario.tcu_655.BaseDeDatos.Datos;



public class ConceptosArrayAdapter extends ArrayAdapter<Datos> {

    List<Datos> lista;

    public ConceptosArrayAdapter(Context context, int textViewResourceId, List<Datos> objects) {
        super(context, textViewResourceId, objects);
        lista = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.concepto_item_list, null);
        Datos dato = lista.get(position);
        TextView nombre = (TextView) v.findViewById(R.id.nombre);
        nombre.setText(dato.getNombre());
        ImageView imagen = (ImageView) v.findViewById(R.id.imagen);
        if(dato.getImagen() != "" && dato.getImagen() != null) {
            //imagen.setBackground(Drawable.createFromPath(dato.getImagen()));
            imagen.setBackgroundResource(R.drawable.water);
        }

        return v;

    }
}
