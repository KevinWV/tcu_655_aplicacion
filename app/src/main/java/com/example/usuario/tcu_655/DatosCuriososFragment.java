package com.example.usuario.tcu_655;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class DatosCuriososFragment extends Fragment {

    Activity mParentActivity;
    static int anterior = 20;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mParentActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.datos_curiosos_fragment, container, false);
        TextView text = (TextView) view.findViewById(R.id.texto);
        Random rand = new Random();
        int random = 20;
        while(random == anterior) {
            random = rand.nextInt(9);
        }
        anterior = random;
        text.setText(Global.datosCuriosos[random]);
        return view;
    }

}
