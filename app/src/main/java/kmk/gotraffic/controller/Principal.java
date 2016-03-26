package kmk.gotraffic.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Principal extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        final FloatingActionButton acidente = (FloatingActionButton) findViewById(R.id.fab1);
        final FloatingActionButton congestionamento = (FloatingActionButton) findViewById(R.id.fab2);
        final FloatingActionButton buraco = (FloatingActionButton) findViewById(R.id.fab3);

        acidente.hide(true);
        congestionamento.hide(true);
        buraco.hide(true);
    }

//C    public void onMapReady(GoogleMap map) {
////        LatLng coord = new LatLng(-22.2046206,-49.939328);
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-22.2046206, -49.939328), 13));
////        map.moveCamera(CameraUpdateFactory.newLatLng(coord));
//
//        map.addMarker(new MarkerOptions()
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.crash_map))
//                .anchor(0.0f, 1.0f)
//                .position(new LatLng(-22.2046206,-49.939328)));
//
//        map.getUiSettings().setZoomControlsEnabled(true);
//    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        final FloatingActionButton acidente = (FloatingActionButton) findViewById(R.id.fab1);
        final FloatingActionButton congestionamento = (FloatingActionButton) findViewById(R.id.fab2);
        final FloatingActionButton buraco = (FloatingActionButton) findViewById(R.id.fab3);

        LatLng coord = new LatLng(-22.2046206, -49.939328);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coord, 13));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(final LatLng latLng) {

                acidente.showButtonInMenu(true);
                congestionamento.showButtonInMenu(true);
                buraco.showButtonInMenu(true);

                acidente.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMap.addMarker(new MarkerOptions()
                                .position(latLng)
                                .title("Acidente")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.crash_map)));

                        acidente.hide(true);
                        congestionamento.hide(true);
                        buraco.hide(true);
                    }
                });

                congestionamento.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMap.addMarker(new MarkerOptions()
                                .position(latLng)
                                .title("Congestionamento")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.traffic_map)));

                        acidente.hide(true);
                        congestionamento.hide(true);
                        buraco.hide(true);                    }
                });

                buraco.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMap.addMarker(new MarkerOptions()
                                .position(latLng)
                                .title("Buraco")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hole_map)));

                        acidente.hide(true);
                        congestionamento.hide(true);
                        buraco.hide(true);
                    }
                });

                mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng latLng) {
                        acidente.hide(true);
                        congestionamento.hide(true);
                        buraco.hide(true);
                    }
                });
            }
        });
    }
}