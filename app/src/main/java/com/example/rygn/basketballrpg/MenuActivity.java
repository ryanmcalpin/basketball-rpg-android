package com.example.rygn.basketballrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final Intent npIntent = new Intent(MenuActivity.this, NewPlayerActivity.class);
        final Intent cIntent = new Intent(MenuActivity.this, GameActivity.class);

        Button newGameButton = (Button) findViewById(R.id.new_game_button);
        Button continueButton = (Button) findViewById(R.id.continue_button);

        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuActivity.this.startActivity(npIntent);
            }
        });
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuActivity.this.startActivity(cIntent);
            }
        });
    }
}
