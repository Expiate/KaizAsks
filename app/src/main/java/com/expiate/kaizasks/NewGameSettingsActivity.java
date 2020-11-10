package com.expiate.kaizasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewGameSettingsActivity extends AppCompatActivity {

    private Button startNewGame;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game_settings);

        // Get UI ID's
        startNewGame = findViewById(R.id.startNewGameButton);

        startNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LoadingScreen.class);
                startActivity(intent);
            }
        });
    }
}