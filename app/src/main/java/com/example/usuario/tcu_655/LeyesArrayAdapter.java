package com.example.usuario.tcu_655;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import com.example.usuario.tcu_655.BaseDeDatos.Leyes;


public class LeyesArrayAdapter extends ArrayAdapter<Leyes> {

    List<Leyes> lista;
    static String titulo;

    public LeyesArrayAdapter(Context context, int textViewResourceId, List<Leyes> objects) {
        super(context, textViewResourceId, objects);
        lista = objects;
        titulo = "";
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.leyes_item_list, null);
        Leyes ley = lista.get(position);
        TextView articulo = (TextView) v.findViewById(R.id.articulo);
        articulo.setText(ley.getArticulo());
        if(titulo.compareTo(ley.getNombre()) != 0){
            TextView nombre = (TextView) v.findViewById(R.id.nombre);
            nombre.setText(ley.getNombre());
            nombre.setVisibility(View.VISIBLE);
            titulo = ley.getNombre();
        }
        ImageView imagen = (ImageView) v.findViewById(R.id.imagen);
        if(ley.getImagen() != "" && ley.getImagen() != null) {
            //imagen.setBackground(Drawable.createFromPath(dato.getImagen()));
            imagen.setBackgroundResource(R.drawable.water);
        }

        return v;

    }
}
