package com.example.android.tourguidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class DescriptionActivity extends AppCompatActivity {
    TextView description;
    Intent intent;
    int itemPosition;
    String PlaceName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_activity);
        description = findViewById(R.id.description);
        intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("placeName")) {
                Bundle bundle = getIntent().getExtras();
                assert bundle != null;
                itemPosition = bundle.getInt("itemPosition");
                PlaceName = bundle.getString("placeName");
            }
        }

        if (PlaceName.equals(getString(R.string.abu_bakr_mosque))) {
            description.setText(getString(R.string.abu_bakr_details));
        } else if (PlaceName.equals(getString(R.string.the_museum))) {
            description.setText(getString(R.string.the_museum_details));
        } else if (PlaceName.equals(getString(R.string.suez_canal))) {
            description.setText(getString(R.string.suez_canal_details));
        } else if (PlaceName.equals(getString(R.string.memorial))) {
            description.setText(getString(R.string.memorial_details));
        } else if (PlaceName.equals(getString(R.string.tabat_alshajara))) {
            description.setText(getString(R.string.tabat_alshajara_details));
        } else if (PlaceName.equals(getString(R.string.bicicletta))) {
            description.setText(getString(R.string.biciclettaDetails));
        } else if (PlaceName.equals(getString(R.string.redaHelmi))) {
            description.setText(getString(R.string.redaHelmiDetails));
        } else if (PlaceName.equals(getString(R.string.specttra))) {
            description.setText(getString(R.string.specttra_details));
        } else if (PlaceName.equals(getString(R.string.flames))) {
            description.setText(getString(R.string.flamesDetails));
        } else if (PlaceName.equals(getString(R.string.semsemya))) {
            description.setText(getString(R.string.semsemya_details));
        } else if (PlaceName.equals(getString(R.string.police_day))) {
            description.setText(getString(R.string.police_day_details));
        } else if (PlaceName.equals(getString(R.string.elfyrooz))) {
            description.setText(getString(R.string.elfyrooz_details));
        } else if (PlaceName.equals(getString(R.string.tolip))) {
            description.setText(getString(R.string.tolip_details));
        } else if (PlaceName.equals(getString(R.string.nemra6))) {
            description.setText(getString(R.string.nemra6_details));
        } else if (PlaceName.equals(getString(R.string.abo_atwa_tanks_exhibition))) {
            description.setText(getString(R.string.abo_atwa_tanks_exhibition_details));
        }
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
