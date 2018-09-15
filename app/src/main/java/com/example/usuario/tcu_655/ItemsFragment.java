package com.example.usuario.tcu_655;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.usuario.tcu_655.BaseDeDatos.DataBaseAccess;
import com.example.usuario.tcu_655.BaseDeDatos.Datos;

import java.util.List;

public class ItemsFragment extends Fragment {
    public static ConceptosFragment me = null;
    static CustomArrayAdapter conceptAdapter;
    ListView mListView = null;
    static List<Datos> mConceptos;
    Activity mParentActivity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mParentActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.items, container, false);;
        Bundle args = getArguments();
        String nombre = args.getString("titu");
        String descripcion = args.getString("desc");
        String imagen = args.getString("img");
        TextView t = (TextView) view.findViewById(R.id.titulo);
        TextView d = (TextView) view.findViewById(R.id.descripcion);
        ImageView i = (ImageView) view.findViewById(R.id.imagen);
        t.setText(nombre);
        d.setText(descripcion);
        return view;
    }
}
