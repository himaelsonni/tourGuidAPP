package com.example.android.tourguidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantFragment extends Fragment {
    ListView restaurantView;
    place mPlace;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.data_list, container, false);
        restaurantView = rootView.findViewById(R.id.dataListView);
        final ArrayList<place> restaurantList = new ArrayList<>();
        restaurantList.add(new place(getString(R.string.flames), R.drawable.flames));
        restaurantList.add(new place(getString(R.string.bicicletta), R.drawable.bicicletta));
        restaurantList.add(new place(getString(R.string.redaHelmi), R.drawable.reda_helmi));
        restaurantList.add(new place(getString(R.string.specttra), R.drawable.spectra));

        placeAdapter itemAdapter = new placeAdapter(getActivity(), restaurantList, R.color.category_restaurant);
        restaurantView.setAdapter(itemAdapter);
        restaurantView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DescriptionActivity.class);
                intent.putExtra("itemPosition", position);
                mPlace = (place) parent.getItemAtPosition(position);
                String placeName = mPlace.getmPlace();
                intent.putExtra("placeName", placeName);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
