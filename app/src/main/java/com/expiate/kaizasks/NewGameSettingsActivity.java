package com.expiate.kaizasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.gson.Gson;

import java.util.ArrayList;

public class NewGameSettingsActivity extends AppCompatActivity {

    private Context context = this;

    private Button startNewGame;

    private Spinner themeSpinner;
    private Spinner difficultySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game_settings);

        // Get UI ID's
        startNewGame = findViewById(R.id.startNewGameButton);
        themeSpinner = findViewById(R.id.themeSpinner);
        difficultySpinner = findViewById(R.id.difficultySpinner);

        // Listeners
        startNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();

                // Collect the user choices
                ArrayList<String> options = new ArrayList<>();
                options.add(themeSpinner.getSelectedItem().toString());
                options.add(difficultySpinner.getSelectedItem().toString());
                // Serialize
                String json = gson.toJson(options);
                // Intent to Game Activity
                Intent intent = new Intent(context, LoadingScreen.class);
                intent.putExtra("1", json);
                startActivity(intent);
            }
        });

        // Spinners Adapters
        ArrayAdapter<CharSequence> themeAdapter = ArrayAdapter.createFromResource(context,
                R.array.themes, android.R.layout.simple_spinner_item);
        themeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        themeSpinner.setAdapter(themeAdapter);

        ArrayAdapter<CharSequence> diffAdapter = ArrayAdapter.createFromResource(context,
                R.array.diff, android.R.layout.simple_spinner_item);
        diffAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(diffAdapter);
    }
}