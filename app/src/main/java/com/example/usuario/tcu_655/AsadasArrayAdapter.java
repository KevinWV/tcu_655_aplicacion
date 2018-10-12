package com.example.usuario.tcu_655;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.usuario.tcu_655.BaseDeDatos.Asadas;

import java.util.List;

public class AsadasArrayAdapter extends ArrayAdapter<Asadas> {

    List<Asadas> lista;

    public AsadasArrayAdapter(Context context, int textViewResourceId, List<Asadas> objects) {
        super(context, textViewResourceId, objects);
        lista = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.concepto_item_list, null);
        Asadas dato = lista.get(position);
        TextView nombre = (TextView) v.findViewById(R.id.nombre);
        nombre.setText(dato.getNombre());
        return v;

    }
}
