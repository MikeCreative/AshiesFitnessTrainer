package com.example.mike.ashiesfitnesstrainer.ListViewAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.mike.ashiesfitnesstrainer.R;

import java.util.ArrayList;

/**
 * Created by Mike on 18/10/2014.
 */
public class ListViewAdapter_Cardio extends ArrayAdapter<String> {

    private int layoutResourceId;
    ArrayList<String> names;
    private static LayoutInflater inflater = null;
    private Activity activity;
//    private int toggle_variable = 0;
    list_view_holder_cardio holder;

    public ListViewAdapter_Cardio(Activity context, int layoutResourceId, ArrayList<String> titles) {
        super(context, layoutResourceId, titles);
        this.layoutResourceId = layoutResourceId;
        this.activity = context;
        this.names = titles;


    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
//        list_view_holder_cardio holder = null;
        View vi = convertView;

        if (vi == null){
            holder = new list_view_holder_cardio();

            inflater = activity.getLayoutInflater();


//            if(toggle_variable == 0) {
                vi = inflater.inflate(R.layout.cardio_listitem, parent, false);
                holder.name = (TextView) vi.findViewById(R.id.cardio_title);
                holder.name.setText(names.get(position));
                holder.button = (Button) vi.findViewById(R.id.cardio_button);
//            } else {
//
//            }
            vi.setTag(holder);

        } else {
            holder = (list_view_holder_cardio) vi.getTag();
        }





        //Click on the button
        holder.button.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
//                View toolbar = v.findViewbyId(R.id.toolbar);
//                System.out.println("I was clicked" + names.get(position));
//                toggle_variable = 1;

//               ExpandAnimation expandAni = new ExpandAnimation(toolbar, 500);
//                holder.button.setText("yo");
//               toolbar.startAnimation(expandAni);
           }
        });

//        holder.name.setText(names.get(position));

        return vi;
    }

    @Override
    public int getCount() {
        return names.size();
    }

//    @Override
//    public Object getItem(int i) {
//        return null;
//    }

//    @Override
//    public long getItemId(int arg0) {
//        // TODO Auto-generated method stub
//        return arg0;
//    }

    private void setupItem(list_view_holder_cardio holder) {
//        holder.name.setText(holder.atomPayment.getName());
//        holder.value.setText(String.valueOf(holder.atomPayment.getValue()));
    }

    public static class list_view_holder_cardio {
        public TextView name;
        public Button button;
    }
}


