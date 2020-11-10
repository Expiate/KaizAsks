package com.expiate.kaizasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

import com.expiate.kaizasks.dialogs.*;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements LoadOrPlayDialog.LoadOrPlayDialogInterface{

    private Button play;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get UI elements
        play = findViewById(R.id.playButton1);
        constraintLayout = findViewById(R.id.layoutMain);

        startBackgroundAnimation();
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
     * Override interface method to communicate the LoadOrPlay Dialog
     *
     * @param r Represents the user's choice
     */
    @Override
    public void getChoice(int r) {
        if(r == 1) {
            Intent intentToLoadingScreen = new Intent(this, LoadingScreen.class);
            startActivity(intentToLoadingScreen);
        }
    }

    /**
     * Start the background animation of the main activity
     */
    public void startBackgroundAnimation() {
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }
}