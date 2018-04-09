package com.example.rygn.basketballrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String number = intent.getStringExtra("number");
        String position = intent.getStringExtra("position");
        String height = intent.getStringExtra("height");
        String weight = intent.getStringExtra("weight");

        TextView nameView = findViewById(R.id.player_name_view);
        TextView infoView = findViewById(R.id.player_info_view);
        TextView sizeView = findViewById(R.id.player_size_view);

        nameView.setText(name);
        infoView.setText("#" + number + " | " + position);
        sizeView.setText(height + " | " + weight);
    }
}
