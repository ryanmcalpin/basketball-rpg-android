package com.example.rygn.basketballrpg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
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

    List<String> heightsArray;
    List<String> weightsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);

        nameInput = (EditText) findViewById(R.id.nameInput);
        jerseyInput = (EditText) findViewById(R.id.numberInput);
        positionsSpinner = (Spinner) findViewById(R.id.positions_spinner);

        jerseyInput.setVisibility(View.INVISIBLE);
        positionsSpinner.setVisibility(View.INVISIBLE);

        nameInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (nameInput.getText().toString() != "") {
                    jerseyInput.setVisibility(View.VISIBLE);
                    jerseyInput.requestFocus();
                }
                return false;
            }
        });
        jerseyInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (jerseyInput.getText().toString() != "") {
                    positionsSpinner.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });

        ArrayAdapter<CharSequence> positionsAdapter = ArrayAdapter.createFromResource(this, R.array.positions_array, android.R.layout.simple_spinner_item);
        positionsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        positionsSpinner.setAdapter(positionsAdapter);
        positionsSpinner.setOnItemSelectedListener(this);

        heightSpinner = (Spinner) findViewById(R.id.height_spinner);
        String[] hArray = getResources().getStringArray(R.array.heights_array);
        heightsArray = Arrays.asList(hArray);
//        ArrayAdapter<CharSequence> heightAdapter = ArrayAdapter.createFromResource(this, R.array.heights_array, android.R.layout.simple_spinner_item);
//        heightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        heightSpinner.setAdapter(heightAdapter);
        heightSpinner.setOnItemSelectedListener(this);

        weightSpinner = (Spinner) findViewById(R.id.weight_spinner);
        String[] wArray = getResources().getStringArray(R.array.weights_array);
        weightsArray = Arrays.asList(wArray);
//        ArrayAdapter<CharSequence> weightAdapter = ArrayAdapter.createFromResource(this, R.array.weights_array, android.R.layout.simple_spinner_item);
//        weightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        weightSpinner.setAdapter(weightAdapter);
        weightSpinner.setOnItemSelectedListener(this);

        myIntent = new Intent(NewPlayerActivity.this, GameActivity.class);

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

    @Override
    public void onBackPressed() {
        AlertDialog alertDialog = new AlertDialog.Builder(NewPlayerActivity.this).create();
        alertDialog.setTitle("Quit player creation?");
        alertDialog.setMessage("This player will not be saved.");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", (Message) null);

        alertDialog.show();
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        switch (parent.getId()) {

            case R.id.positions_spinner:
                position = parent.getItemAtPosition(pos).toString();
                myIntent.putExtra("position", position);
                if (pos == 0) {
                    heightSpinner.setVisibility(View.INVISIBLE);
                    weightSpinner.setVisibility(View.INVISIBLE);
                } else {
                    heightSpinner.setVisibility(View.VISIBLE);

                    // set height limits based on position
                    List<String> limitedHeightsArray = new ArrayList<String>();
                    int startingHeight = 0;
                    int heightRange = 0;
                    switch (pos) {
                        case 0: // no position selected
                            // validate?
                            startingHeight = 0;
                            heightRange = 0;
                            break;
                        case 1: // pg
                            startingHeight = 1;
                            heightRange = 13;
                            break;
                        case 2: // sg
                            startingHeight = 4;
                            heightRange = 12;
                            break;
                        case 3: // sf
                            startingHeight = 9;
                            heightRange = 10;
                            break;
                        case 4: // pf
                            startingHeight = 11;
                            heightRange = 9;
                            break;
                        case 5: // c
                            startingHeight = 15;
                            heightRange = 6;
                            break;
                        case 6: // guard
                            startingHeight = 4;
                            heightRange = 10;
                            break;
                        case 7: // wing
                            startingHeight = 9;
                            heightRange = 7;
                            break;
                        case 8: // forward
                            startingHeight = 11;
                            heightRange = 8;
                            break;
                        case 9: // big
                            startingHeight = 15;
                            heightRange = 5;
                            break;
                    }
                    limitedHeightsArray.add(heightsArray.get(0));
                    for (int i = startingHeight; i < startingHeight + heightRange; i++) {
                        limitedHeightsArray.add(heightsArray.get(i));
                    }
                    ArrayAdapter<String> heightAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, limitedHeightsArray);
                    heightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    heightSpinner.setAdapter(heightAdapter);
                }
                break;

            case R.id.height_spinner:
                height = parent.getItemAtPosition(pos).toString();
                myIntent.putExtra("height", height);
                if (pos == 0) {
                    weightSpinner.setVisibility(View.INVISIBLE);
                } else {
                    weightSpinner.setVisibility(View.VISIBLE);

                    // set weight limits based on height
                    List<String> limitedWeightsArray = new ArrayList<String>();
                    int startingWeight = 0;
                    int weightRange = 0;

                    // adjust starting item based on altered height array per position
                    int heightSelectionAdjustment = 0;
                    switch (positionsSpinner.getSelectedItemPosition()) {
                        case 0: // no position selected, 3 8 10 14
                            break;
                        case 1: // pg
                            break;
                        case 2: // sg
                            heightSelectionAdjustment = 3;
                            break;
                        case 3: // sf
                            heightSelectionAdjustment = 8;
                            break;
                        case 4: // pf
                            heightSelectionAdjustment = 10;
                            break;
                        case 5: // c
                            heightSelectionAdjustment = 14;
                            break;
                        case 6: // guard
                            heightSelectionAdjustment = 3;
                            break;
                        case 7: // wing
                            heightSelectionAdjustment = 8;
                            break;
                        case 8: // forward
                            heightSelectionAdjustment = 10;
                            break;
                        case 9: // big
                            heightSelectionAdjustment = 14;
                            break;
                    }

                    switch (pos + heightSelectionAdjustment) {
                        case 0: // no height selected
                            startingWeight = 0;
                            weightRange = 0;
                            break;
                        case 1: // 5'7"
                            startingWeight = 1;
                            weightRange = 12;
                            break;
                        case 2: // 5'8"
                            startingWeight = 2;
                            weightRange = 12;
                            break;
                        case 3: // 5'9"
                            startingWeight = 3;
                            weightRange = 12;
                            break;
                        case 4: // 5'10"
                            startingWeight = 4;
                            weightRange = 12;
                            break;
                        case 5: // 5'11"
                            startingWeight = 5;
                            weightRange = 12;
                            break;
                        case 6: // 6'0"
                            startingWeight = 6;
                            weightRange = 12;
                            break;
                        case 7: // 6'1"
                            startingWeight = 7;
                            weightRange = 12;
                            break;
                        case 8: // 6'2"
                            startingWeight = 8;
                            weightRange = 12;
                            break;
                        case 9: // 6'3"
                            startingWeight = 9;
                            weightRange = 12;
                            break;
                        case 10: // 6'4"
                            startingWeight = 10;
                            weightRange = 13;
                            break;
                        case 11: // 6'5"
                            startingWeight = 11;
                            weightRange = 14;
                            break;
                        case 12: // 6'6"
                            startingWeight = 12;
                            weightRange = 15;
                            break;
                        case 13: // 6'7"
                            startingWeight = 13;
                            weightRange = 16;
                            break;
                        case 14: // 6'8"
                            startingWeight = 14;
                            weightRange = 17;
                            break;
                        case 15: // 6'9"
                            startingWeight = 15;
                            weightRange = 18;
                            break;
                        case 16: // 6'10"
                            startingWeight = 16;
                            weightRange = 19;
                            break;
                        case 17: // 6'11"
                            startingWeight = 17;
                            weightRange = 20;
                            break;
                        case 18: // 7'0"
                            startingWeight = 18;
                            weightRange = 21;
                            break;
                        case 19: // 7'1"
                            startingWeight = 19;
                            weightRange = 22;
                            break;
                        case 20: // 7'2"
                            startingWeight = 20;
                            weightRange = 23;
                            break;
                    }

                    limitedWeightsArray.add(weightsArray.get(0));
                    for (int i = startingWeight; i < startingWeight + weightRange; i++) {
                        limitedWeightsArray.add(weightsArray.get(i));
                    }
                    ArrayAdapter<String> weightAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, limitedWeightsArray);
                    weightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    weightSpinner.setAdapter(weightAdapter);
                }
                break;

            case R.id.weight_spinner:
                weight = parent.getItemAtPosition(pos).toString();
                myIntent.putExtra("weight", weight);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
