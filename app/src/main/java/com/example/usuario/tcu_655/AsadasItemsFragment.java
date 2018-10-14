package com.example.usuario.tcu_655;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AsadasItemsFragment extends Fragment {
    public static ConceptosFragment me = null;
    ListView mListView = null;
    Activity mParentActivity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mParentActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.items_asadas, container, false);;
        Bundle args = getArguments();
        String nombre = args.getString("titu");
        String canton = args.getString("can");
        String cantC = args.getString("cC");
        String cantP = args.getString("cP");
        String fundacion = args.getString("fund");
        String condicion = args.getString("cond");
        TextView t = (TextView) view.findViewById(R.id.titulo);
        TextView d = (TextView) view.findViewById(R.id.canton);
        TextView e = (TextView) view.findViewById(R.id.cantC);
        TextView f = (TextView) view.findViewById(R.id.cantP);
        TextView g = (TextView) view.findViewById(R.id.fundacion);
        TextView h = (TextView) view.findViewById(R.id.condicion);
        t.setText(nombre);
        d.setText("Cantón: "+canton);
        e.setText("Número de comunidades que abastece: : "+cantC);
        f.setText("Población abastecida: "+cantP);
        g.setText("Fundación: "+fundacion);
        h.setText("Condición: "+condicion);

        return view;
    }
}

