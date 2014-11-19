package com.example.mike.ashiesfitnesstrainer.Tabs;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.example.mike.ashiesfitnesstrainer.R;


public class Tab1Fragment extends SherlockFragment {
    private long startTime;
    private long elapsedTime;
    private final int REFRESH_RATE = 100;
    private long secs, mins, hrs, msecs;
    private boolean stopped = false;
    private String hours, minutes, seconds, milliseconds;
    private Handler mhandler = new Handler();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get the view from fragmenttab1.xml
        View view = inflater.inflate(R.layout.tab_home_screen, container, false);


        final Button start_button = (Button) view.findViewById(R.id.start_button);
        final Button stop_button = (Button) view.findViewById(R.id.stop_button);
        final Button reset_button = (Button) view.findViewById(R.id.reset_button);
        start_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                   // Create Notification
                if(stopped){ startTime = System.currentTimeMillis() - elapsedTime;
                } else{
                    startTime = System.currentTimeMillis();
                }
                mhandler.removeCallbacks(startTimer);
                mhandler.postDelayed(startTimer, 0);
            }
        });


        stop_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                ((TextView) getView().findViewById(R.id.counter_1)).setText("Timer stopped");
                stopped = true;
                mhandler.removeCallbacks(startTimer);
            }
        });

        reset_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                ((TextView) getView().findViewById(R.id.counter_1)).setText("Timer Reset");
                secs = 0; mins = 0; hrs = 0;
                stopped = false;
            }
        });

        return view;
    }



    private void updateTimer(float time){
        secs = (long)(time/1000);
        mins = (long)((time/1000)/60);
        hrs = (long)(((time/1000)/60)/60);
        /* Convert the seconds to String * and format to ensure it has * a leading zero when required */
        secs = secs % 60; seconds=String.valueOf(secs);
        if(secs == 0){ seconds = "00"; }
        if(secs <10 && secs > 0){ seconds = "0"+seconds; }
        /* Convert the minutes to String and format the String */
        mins = mins % 60; minutes=String.valueOf(mins);
        if(mins == 0){ minutes = "00"; }
        if(mins <10 && mins > 0){ minutes = "0"+minutes; }
        /* Convert the hours to String and format the String */
        hours=String.valueOf(hrs); if(hrs == 0){ hours = "00"; }
        if(hrs <10 && hrs > 0){ hours = "0"+hours; }
        /* Although we are not using milliseconds on the timer in this example * I included the code in the event that you wanted to include it on your own */
//        milliseconds = String.valueOf((long)time);
//        if(milliseconds.length()==2){ milliseconds = "0"+milliseconds; }
//        if(milliseconds.length()<=1){ milliseconds = "00"; }
//        milliseconds = milliseconds.substring(milliseconds.length()-3, milliseconds.length()-2);
        /* Setting the timer text to the elapsed time */
        if(getView() != null) {
            ((TextView) getView().findViewById(R.id.counter_1)).setText(hours + ":" + minutes + ":" + seconds);
        }
//        ((TextView)findViewById(R.id.timerMs)).setText("." + milliseconds);
    }

    private Runnable startTimer = new Runnable() {
        public void run() {
            elapsedTime = System.currentTimeMillis() - startTime;
            updateTimer(elapsedTime);
            mhandler.postDelayed(this,REFRESH_RATE);
        }
    };

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        setUserVisibleHint(true);
    }

}