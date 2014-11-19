package com.example.mike.ashiesfitnesstrainer.Tracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.mike.ashiesfitnesstrainer.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Mike on 19/11/2014.
 */
public class Tracker extends FragmentActivity implements
        GooglePlayServicesClient.ConnectionCallbacks,
        GooglePlayServicesClient.OnConnectionFailedListener {

    GoogleMap googleMap;
    LocationClient myLocationClient;
    Criteria myCriteria;

//    LocationManager myLocationManager = null;
//    OnLocationChangedListener myLocationListener = null;

    private static final LocationRequest REQUEST = LocationRequest.create()
            .setInterval(5000)         // 5 seconds
            .setFastestInterval(16)    // 16ms = 60fps
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trackerview);


        googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();


        if (googleMap != null){
            googleMap.setMyLocationEnabled(true);
        }

        assert googleMap != null;
        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        myCriteria = new Criteria();
        myCriteria.setAccuracy(Criteria.ACCURACY_FINE);

//        myLocationManager = (LocationManager)getSystemService(LOCATION_SERVICE);

        myLocationClient = new LocationClient(getApplicationContext(), this, this);

        if (myLocationClient != null){
            myLocationClient.connect();
        }
    }


    @Override
    protected void onPause(){
        googleMap.setLocationSource(null);
//        myLocationManager.removeUpdates(this);

        super.onPause();
    }


//    @Override
//    public void onLocationChanged(Location location) {
//        if (myLocationListener != null) {
//            myLocationListener.onLocationChanged(location);
//
//            double lat = location.getLatitude();
//            double lon = location.getLongitude();
//        }
//    }
//
//    @Override
//    public void onStatusChanged(String s, int i, Bundle bundle) {
//
//    }
//
//    @Override
//    public void onProviderEnabled(String s) {
//
//    }
//
//    @Override
//    public void onProviderDisabled(String s) {

//    }

//    @Override
//    public void activate(OnLocationChangedListener onLocationChangedListener) {
//        myLocationListener = onLocationChangedListener;
//    }

//    @Override
//    public void deactivate() {
//        myLocationListener = null;
//    }


    // TODO:
    /**
     * Function to show settings alert dialog
     * */
    public void showSettingsAlert(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        // Setting Dialog Title
        alertDialog.setTitle("GPS is settings");

        // Setting Dialog Message
        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");

        // Setting Icon to Dialog
        //alertDialog.setIcon(R.drawable.delete);

        // On pressing Settings button
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        });

        // on pressing cancel button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }


    @Override
    public void onConnected(Bundle bundle) {
        Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
        Location location = myLocationClient.getLastLocation();
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 18);
        googleMap.animateCamera(cameraUpdate);
    }

    @Override
    public void onDisconnected() {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
