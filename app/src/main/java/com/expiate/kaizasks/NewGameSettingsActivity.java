package com.expiate.kaizasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class NewGameSettingsActivity extends AppCompatActivity {

    private Button startNewGame;
    private Spinner themeSpinner;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game_settings);

        // Get UI ID's
        startNewGame = findViewById(R.id.startNewGameButton);
        themeSpinner = findViewById(R.id.themeSpinner);

        // Listeners
        startNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LoadingScreen.class);
                startActivity(intent);
            }
        });

        // Spinners Adapters
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                R.array.themes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        themeSpinner.setAdapter(adapter);
    }
}