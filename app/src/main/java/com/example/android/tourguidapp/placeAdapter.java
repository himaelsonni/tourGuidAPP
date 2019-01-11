package com.example.android.tourguidapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class placeAdapter extends ArrayAdapter<place> {
    private int mColorResourceId;
    public placeAdapter(Activity context, ArrayList<place> places, int colorResourceId) {
        super(context, 0, places);
        mColorResourceId=colorResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        place currentPlace = getItem(position);

        TextView placeNameView = (TextView) listItemView.findViewById(R.id.placeName);
        placeNameView.setText(currentPlace.getmPlace());

        ImageView imageView =(ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentPlace.getmImageResourceId());

        View placeContainerView=listItemView.findViewById(R.id.place_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        placeContainerView.setBackgroundColor(color);
        return listItemView;
    }
}
