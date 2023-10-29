package com.example.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    //Using Custom Layouts -->MyCustomAdapter
    //Using Custom Objects -->extends ArrayAdapter<Planet>

    Context context;
    private ArrayList<Planet> planetArrayList;

    public MyCustomAdapter(ArrayList<Planet> planetArrayList, Context context) {
        super(context,R.layout.item_list_layout, planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      //1- Get the Planet Object for the current position
       Planet planet = getItem(position);

       //2- Inflate Layout:
        MyViewHolder myViewHolder;
        final View result;

        if(convertView == null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater  = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );
            //finding Views:
            myViewHolder.planetName = (TextView)convertView.findViewById(R.id.planetName);
        myViewHolder.moonCount = (TextView) convertView.findViewById(R.id.moon_name);
        myViewHolder.planetImg = (ImageView) convertView.findViewById(R.id.imageView);

        result = convertView;

        convertView.setTag(myViewHolder);
        }else{
            //view is not recycled
            myViewHolder = (MyViewHolder)convertView.getTag();
            result = convertView;
        }
        //getting the data from model
        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.moonCount.setText(planet.getMoonCount());
        myViewHolder.planetImg.setImageResource(planet.getPlanetImage());
        return convertView;
    }
    //getView() : used to create and return a view for a
    //specified item in the list.

    //ViewHolder Class : used to cache references to the views within an item layout
    //so that they don't need to be repeatedly looked up during scrolling
    private  static  class MyViewHolder{
        TextView planetName;
        TextView moonCount;
        ImageView planetImg;

    }
}
