package com.expiate.kaizasks;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.expiate.kaizasks.utils.ProgressBarAnimation;
import com.google.gson.Gson;

import java.util.ArrayList;

public class LoadingScreen extends AppCompatActivity {

    private TextView chargeText;
    private ProgressBar progressBar;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_de_carga);

        // Get UI id's
        chargeText = findViewById(R.id.cargandoTextView);
        progressBar = findViewById(R.id.loadScreenProgressBar);

        ArrayList<String> intentData = unpackIntentData();
        Log.i("Prueba", intentData.toString());

        progressBar.setMax(100);
        startProgressBarAnimation();
    }

    /**
     * Start the ProgressBar animation
     */
    public void startProgressBarAnimation() {
        ProgressBarAnimation anim = new ProgressBarAnimation(this, progressBar, chargeText,
                0f, 100f);
        anim.setDuration(8000);
        progressBar.setAnimation(anim);
    }

    /**
     * Deserialize the Json String coming from the previous activity into an ArrayList.
     *
     * @return ArrayList<String>
     */
    public ArrayList<String> unpackIntentData() {
        Gson gson = new Gson();
        intent = getIntent();
        String intentData = intent.getStringExtra("1");
        ArrayList<String> optionsData = gson.fromJson(intentData, ArrayList.class);
        return optionsData;
    }

}
