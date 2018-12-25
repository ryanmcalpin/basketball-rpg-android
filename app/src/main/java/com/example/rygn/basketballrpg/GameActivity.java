package com.example.rygn.basketballrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {

    int lMin = 0;
    int lPts = 0;
    int lAst = 0;
    int lReb = 0;
    int lStl = 0;
    int lBlk = 0;
    int games = 0;

    TextView lMinView;
    TextView lPtsView;
    TextView lAstView;
    TextView lRebView;
    TextView lStlView;
    TextView lBlkView;

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

        lMinView = findViewById(R.id.last_minutes_view);
        lPtsView = findViewById(R.id.last_points_view);
        lAstView = findViewById(R.id.last_assists_view);
        lRebView = findViewById(R.id.last_rebounds_view);
        lStlView = findViewById(R.id.last_steals_view);
        lBlkView = findViewById(R.id.last_blocks_view);

        nameView.setText(name);
        infoView.setText("#" + number + " | " + position);
        sizeView.setText(height + " | " + weight);

        Button nextGameButton = (Button)  findViewById(R.id.play_button);
        nextGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simulateGame();
            }
        });
    }

    public void simulateGame() {
        lMin += 1;
        lPts += 1;
        lAst +=1 ;
        lReb +=1;
        lStl+= 1;
        lBlk+= 1;
        games += 1;

        updateViews();
    }

    public void updateViews() {
        lMinView.setText(lMin + "");
        lPtsView.setText(lPts + "");
        lAstView.setText(lAst + "");
        lRebView.setText(lReb + "");
        lStlView.setText(lStl + "");
        lBlkView.setText(lBlk + "");
    }
}
