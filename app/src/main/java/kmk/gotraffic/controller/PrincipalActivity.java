package kmk.gotraffic.controller;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.security.Principal;


public class PrincipalActivity extends FragmentActivity implements
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener{

    public static final String TAG = PrincipalActivity.class.getSimpleName();
    SupportMapFragment mapFragment;
    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.principal_Map);
        mapFragment.getMapAsync(this);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(30 * 1000)        // 30 segundos em milisegundos
                .setFastestInterval(3 * 1000); // 3 segundos em milisegundos
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mGoogleApiClient.connect();
        LatLng coord = new LatLng(-22.2046206, -49.939328);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coord, 14));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMyLocationEnabled(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, (LocationListener) this);
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        boolean mRequestingLocationUpdates = false;
        if (mGoogleApiClient.isConnected() && !mRequestingLocationUpdates) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, (LocationListener) this);
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (location == null) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, (LocationListener) this);
        } else {
            markerMap(location);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG, "Location services suspended. Please reconnect.");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    protected void markerMap(Location location) {
        Log.d(TAG, location.toString());

        double currentLatitude = location.getLatitude();
        double currentLongitude = location.getLongitude();
        final LatLng latLng = new LatLng(currentLatitude, currentLongitude);

        final FloatingActionButton acidente = (FloatingActionButton) findViewById(R.id.principal_btnAcidente);
        final FloatingActionButton congestionamento = (FloatingActionButton) findViewById(R.id.principal_btnCongestionamento);
        final FloatingActionButton buraco = (FloatingActionButton) findViewById(R.id.principal_btnBuraco);
        final FloatingActionButton conta = (FloatingActionButton) findViewById(R.id.principal_btnConta);

        congestionamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Congestionamento")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.traffic_map)));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17));
            }
        });

        acidente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Acidente")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.crash_map)));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17));
            }
        });

        buraco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Buraco")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.hole_map)));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17));
            }
        });

        conta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this, ContaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}