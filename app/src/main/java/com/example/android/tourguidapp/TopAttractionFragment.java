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

public class TopAttractionFragment extends Fragment {

    ListView topAttractionView;
    place mPlace;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.data_list, container, false);
        topAttractionView = rootView.findViewById(R.id.dataListView);
        final ArrayList<place> topAttractionList = new ArrayList<>();
        topAttractionList.add(new place(getString(R.string.elfyrooz), R.drawable.elfayrooz));
        topAttractionList.add(new place(getString(R.string.tolip), R.drawable.tolip));
        topAttractionList.add(new place(getString(R.string.nemra6), R.drawable.nemra_6));
        topAttractionList.add(new place(getString(R.string.abo_atwa_tanks_exhibition), R.drawable.abo_atwa_tanks));

        placeAdapter itemAdapter = new placeAdapter(getActivity(), topAttractionList, R.color.category_top_attraction);
        topAttractionView.setAdapter(itemAdapter);
        topAttractionView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
