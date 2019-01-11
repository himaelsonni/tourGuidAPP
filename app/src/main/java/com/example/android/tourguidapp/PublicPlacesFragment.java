package com.example.android.tourguidapp;

import android.content.Intent;
import android.media.MediaPlayer;
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

public class PublicPlacesFragment extends Fragment {
    ListView publicPlaceView;
    place mPlace;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.data_list, container, false);
        publicPlaceView = rootView.findViewById(R.id.dataListView);
        final ArrayList<place> publicPlaceList = new ArrayList<>();
        publicPlaceList.add(new place(getString(R.string.abu_bakr_mosque), R.drawable.abo_bakr_mosque));
        publicPlaceList.add(new place(getString(R.string.the_museum), R.drawable.the_museum_of_ismaili_antiquities));
        publicPlaceList.add(new place(getString(R.string.suez_canal), R.drawable.suez_canal));
        publicPlaceList.add(new place(getString(R.string.memorial), R.drawable.memorial));
        publicPlaceList.add(new place(getString(R.string.tabat_alshajara), R.drawable.tabat_alshajara));

        placeAdapter itemAdapter = new placeAdapter(getActivity(), publicPlaceList, R.color.category_public_places);
        publicPlaceView.setAdapter(itemAdapter);
        publicPlaceView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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