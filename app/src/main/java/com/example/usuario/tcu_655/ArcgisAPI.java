package com.example.usuario.tcu_655;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.esri.arcgisruntime.data.ShapefileFeatureTable;
import com.esri.arcgisruntime.layers.FeatureLayer;
import com.esri.arcgisruntime.loadable.LoadStatus;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.Viewpoint;
import com.esri.arcgisruntime.mapping.view.MapView;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ArcgisAPI.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ArcgisAPI#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArcgisAPI extends Fragment {

    private MapView mMapView;


    //private OnFragmentInteractionListener mListener;


    private void setupMap() {
        if (mMapView != null) {
            Basemap.Type basemapType = Basemap.Type.STREETS_VECTOR;
            double latitude = 9.029868;
            double longitude = -83.050470;
            int levelOfDetail = 11;
            ArcGISMap map = new ArcGISMap(basemapType, latitude, longitude, levelOfDetail);
            mMapView.setMap(map);
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ArcgisAPI.
     */
    // TODO: Rename and change types and number of parameters
    public static ArcgisAPI newInstance() {
        ArcgisAPI fragment = new ArcgisAPI();
        //Bundle args = new Bundle();
        //fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        int c =1;
        View view = inflater.inflate(R.layout.fragment_arcgis_api, container, false);
        mMapView = view.findViewById(R.id.mapView);
        setupMap();
        //featureLayerShapefile();
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        //if (mListener != null) {
            //mListener.onFragmentInteraction(uri);
       // }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
       // mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/

    private void featureLayerShapefile() {
        // load the shapefile with a local path
        ShapefileFeatureTable shapefileFeatureTable = new ShapefileFeatureTable("p.shp");

        shapefileFeatureTable.loadAsync();
        shapefileFeatureTable.addDoneLoadingListener(() -> {
            if (shapefileFeatureTable.getLoadStatus() == LoadStatus.LOADED) {

                // create a feature layer to display the shapefile
                FeatureLayer shapefileFeatureLayer = new FeatureLayer(shapefileFeatureTable);

                // add the feature layer to the map
                mMapView.getMap().getOperationalLayers().add(shapefileFeatureLayer);

                // zoom the map to the extent of the shapefile
                mMapView.setViewpointAsync(new Viewpoint(shapefileFeatureLayer.getFullExtent()));
            } else {
                String error = "Shapefile feature table failed to load: " + shapefileFeatureTable.getLoadError().toString();
                Log.e(TAG, error);

            }
        });
    }
}
