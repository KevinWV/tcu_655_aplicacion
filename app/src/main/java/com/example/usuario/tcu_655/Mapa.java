package com.example.usuario.tcu_655;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Mapa.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Mapa#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Mapa extends Fragment {

    private MapView map;    // Mapa de la aplicación
    double lat = 0.0, lon = 0.0;    // Latitud y longitud del usuario

    //N.I.
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Mapa.
     */
    // TODO: Rename and change types and number of parameters
    public static Mapa newInstance(String param1, String param2) {
        Mapa fragment = new Mapa();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mapa, container, false);
        // Inflate the layout for this fragment
        Context ctx = getActivity();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        map = view.findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        //Cod propio
        map.setBuiltInZoomControls(false);
        map.setMultiTouchControls(true);
        IMapController mapController = map.getController();
        mapController.setZoom(10.0);
        GeoPoint startPoint = new GeoPoint(9.029868, -83.050470);
        mapController.setCenter(startPoint);
        map.setMultiTouchControls(true);

        return view;
    }

}
