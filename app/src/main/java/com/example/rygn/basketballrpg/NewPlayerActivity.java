package com.example.rygn.basketballrpg;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NewPlayerActivity extends Activity implements AdapterView.OnItemSelectedListener {
    Spinner positionsSpinner;
    Spinner heightSpinner;
    Spinner weightSpinner;

    String[] heightArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);

        positionsSpinner = (Spinner) findViewById(R.id.positions_spinner);
        ArrayAdapter<CharSequence> positionsAdapter = ArrayAdapter.createFromResource(this, R.array.positions_array, android.R.layout.simple_spinner_item);
        positionsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        positionsSpinner.setAdapter(positionsAdapter);
        positionsSpinner.setOnItemSelectedListener(this);

        heightSpinner = (Spinner) findViewById(R.id.height_spinner);
//        heightArray = getResources().getStringArray(R.array.heights_array);  trying to limit heights based on position
        ArrayAdapter<CharSequence> heightAdapter = ArrayAdapter.createFromResource(this, R.array.heights_array, android.R.layout.simple_spinner_item);
        heightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        heightSpinner.setAdapter(heightAdapter);

        weightSpinner = (Spinner) findViewById(R.id.weight_spinner);
        ArrayAdapter<CharSequence> weightAdapter = ArrayAdapter.createFromResource(this, R.array.weights_array, android.R.layout.simple_spinner_item);
        weightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weightSpinner.setAdapter(weightAdapter);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Toast.makeText(this, "" + pos, Toast.LENGTH_SHORT).show();

        if (pos == 0) {
            heightSpinner.setVisibility(View.INVISIBLE);
            weightSpinner.setVisibility(View.INVISIBLE);
        } else {
            heightSpinner.setVisibility(View.VISIBLE);
            weightSpinner.setVisibility(View.VISIBLE);

            // set height and weight limits

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
