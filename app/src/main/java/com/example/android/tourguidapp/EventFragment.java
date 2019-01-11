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

public class EventFragment extends Fragment {


    ListView eventView;
    place mPlace;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.data_list, container, false);
        eventView = rootView.findViewById(R.id.dataListView);
        final ArrayList<place> eventList = new ArrayList<>();
        eventList.add(new place(getString(R.string.police_day), R.drawable.police_day));
        eventList.add(new place(getString(R.string.semsemya), R.drawable.semsemya));

        placeAdapter itemAdapter = new placeAdapter(getActivity(), eventList, R.color.category_events);
        eventView.setAdapter(itemAdapter);
        eventView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
