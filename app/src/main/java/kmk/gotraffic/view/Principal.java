package kmk.gotraffic.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import android.app.Activity;
import android.os.Bundle;


import kmk.gotraffic.view.util.TipAlert;
import kmk.gotraffic.view.util.Util;

import static com.google.android.gms.maps.UiSettings.*;


public class Principal extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



//        Button btnHole = (Button) findViewById(R.id.principal_btnHole);
//        btnHole.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Util.showAlert(Principal.this, "Testando", TipAlert.HOLE);
//            }
//        });
//
//        Button btnCrash = (Button) findViewById(R.id.principal_btnCrash);
//        btnCrash.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Util.showAlert(Principal.this, "Testando", TipAlert.CRASH);
//            }
//        });
//
//        Button btnTraffic = (Button) findViewById(R.id.principal_btnTraffic);
//        btnTraffic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Util.showAlert(Principal.this, "Testando", TipAlert.TRAFFIC);
//            }
//        });
    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(41.889, -87.622);
//        mMap.addMarker(new MarkerOptions()
////                .icon(BitmapDescriptorFactory.fromResource(R.drawable.crash))
//                .position(sydney)
//                .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
//                .title("Teste Mark"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//    }
//}

    @Override
    public void onMapReady(GoogleMap map) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(41.889, -87.622), 16));

        // You can customize the marker image using images bundled with
        // your app, or dynamically generated bitmaps.
        map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.crash))
                .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                .position(new LatLng(41.889, -87.622)));

        map.getUiSettings().setZoomControlsEnabled(true);
    }
}



