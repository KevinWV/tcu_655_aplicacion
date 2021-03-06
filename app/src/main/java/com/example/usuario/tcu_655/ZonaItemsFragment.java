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

public class ZonaItemsFragment extends Fragment {
    public static ZonaFragment me = null;
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

        View view = inflater.inflate(R.layout.items, container, false);;
        Bundle args = getArguments();
        String nombre = args.getString("titu");
        String com = args.getString("com");
        String uso = args.getString("uso");
        TextView t = (TextView) view.findViewById(R.id.titulo);
        TextView d = (TextView) view.findViewById(R.id.descripcion);
        t.setText(nombre);
        String s = "";
        if(com!= (null)) s = "Comunidades: "+ com;
        if(uso!= (null)) s += "\n\n Uso: "+ uso;
        d.setText(s);

        return view;
    }
}


