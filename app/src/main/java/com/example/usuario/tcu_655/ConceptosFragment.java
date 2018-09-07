package com.example.usuario.tcu_655;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.List;

import com.example.usuario.tcu_655.BaseDeDatos.DataBaseAccess;
import com.example.usuario.tcu_655.BaseDeDatos.Datos;




public class ConceptosFragment extends Fragment {

    public static ConceptosFragment me = null;
    static CustomArrayAdapter conceptAdapter;
    ListView mListView = null;
    static List<Datos> mConceptos;
    Activity mParentActivity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mParentActivity = getActivity();
        DataBaseAccess databaseAccess = DataBaseAccess.getInstance(mParentActivity);
        databaseAccess.open();
        mConceptos = databaseAccess.getConceptos();
        databaseAccess.close();
        conceptAdapter = new CustomArrayAdapter(mParentActivity, R.layout.item_list, mConceptos);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_fragment, container, false);;
        mListView = (ListView) view.findViewById(R.id.lista_datos);
        mListView.setAdapter(conceptAdapter);
        mListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {


                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view,
                                            int position, long id) {

                        //click listener
                    }
                }
        );
        return view;
    }
}