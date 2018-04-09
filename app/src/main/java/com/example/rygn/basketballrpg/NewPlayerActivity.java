package com.example.rygn.basketballrpg;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NewPlayerActivity extends Activity implements AdapterView.OnItemSelectedListener {
    Spinner positionsSpinner;
    Spinner heightSpinner;
    Spinner weightSpinner;
    EditText nameInput;
    EditText jerseyInput;

    String position = null;
    String height = null;
    String weight = null;

    Intent myIntent;

    String[] heightArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);

        nameInput = (EditText) findViewById(R.id.nameInput);
        jerseyInput = (EditText) findViewById(R.id.numberInput);

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
        heightSpinner.setOnItemSelectedListener(this);

        weightSpinner = (Spinner) findViewById(R.id.weight_spinner);
        ArrayAdapter<CharSequence> weightAdapter = ArrayAdapter.createFromResource(this, R.array.weights_array, android.R.layout.simple_spinner_item);
        weightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weightSpinner.setAdapter(weightAdapter);
        weightSpinner.setOnItemSelectedListener(this);

        myIntent = new Intent(NewPlayerActivity.this, MainActivity.class);

        Button button = (Button) findViewById(R.id.create_player_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInput.getText().toString();
                String number = jerseyInput.getText().toString();

                myIntent.putExtra("name", name);
                myIntent.putExtra("number", number);
                NewPlayerActivity.this.startActivity(myIntent);
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        switch (parent.getId()) {
            case R.id.positions_spinner:
                position = parent.getItemAtPosition(pos).toString();
                myIntent.putExtra("position", position);
                break;
            case R.id.height_spinner:
                height = parent.getItemAtPosition(pos).toString();
                myIntent.putExtra("height", height);
                break;
            case R.id.weight_spinner:
                weight = parent.getItemAtPosition(pos).toString();
                myIntent.putExtra("weight", weight);
        }


        if (pos == 0) {
            heightSpinner.setVisibility(View.INVISIBLE);
            weightSpinner.setVisibility(View.INVISIBLE);
        } else {
            heightSpinner.setVisibility(View.VISIBLE);
            weightSpinner.setVisibility(View.VISIBLE);

            position = parent.getItemAtPosition(pos).toString();
            height = parent.getItemAtPosition(pos).toString();

            // set height and weight limits
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
