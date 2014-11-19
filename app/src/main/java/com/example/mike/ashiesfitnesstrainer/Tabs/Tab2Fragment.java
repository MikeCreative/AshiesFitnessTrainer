package com.example.mike.ashiesfitnesstrainer.Tabs;


import android.app.Application;
import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockListFragment;
import com.example.mike.ashiesfitnesstrainer.ListViewAdapter.ListViewAdapter_Cardio;
import com.example.mike.ashiesfitnesstrainer.R;
import com.example.mike.ashiesfitnesstrainer.Tracker.Tracker;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;


public class Tab2Fragment extends SherlockFragment {

//    private ListView listView;
//    ArrayList<String> names;

//    private GoogleMap myMap;
//    private LocationClient myLocationClient;

//    private static final LocationRequest REQUEST = LocationRequest.create()
//            .setInterval(5000)         // 5 seconds
//            .setFastestInterval(16)    // 16ms = 60fps
//            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_cardio_screen, container, false);

        Button button = (Button) view.findViewById(R.id.TrackerApp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tracker = new Intent(view.getContext(), Tracker.class);
                startActivity(tracker);
            }
        });

        return view;
    }




    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
//        ListViewAdapter_Cardio adapter = new ListViewAdapter_Cardio(getActivity(), R.layout.cardio_listitem, names);
//        listView.setAdapter(adapter);
//        listView.invalidate();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        setUserVisibleHint(true);
    }

}