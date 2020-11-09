package com.expiate.kaizasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.expiate.kaizasks.dialogs.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements LoadOrPlayDialog.LoadOrPlayDialogInterface{

    private Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.playButton1);
        // Listener wich invokes the dialog
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogLOP = new LoadOrPlayDialog();
                dialogLOP.show(getSupportFragmentManager(), "LoadOrPlay");
            }
        });
    }

    /**
     * Override interface method to communicate the dialog
     * @param r Represents the user's choice
     */
    @Override
    public void getChoice(int r) {
        if(r == 1) {
            Intent intentToLoadingScreen = new Intent(this, LoadingScreen.class);
            startActivity(intentToLoadingScreen);
        }
    }
}