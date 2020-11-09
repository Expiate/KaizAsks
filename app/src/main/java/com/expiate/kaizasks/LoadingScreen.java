package com.expiate.kaizasks;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.expiate.kaizasks.utils.ProgressBarAnimation;

public class LoadingScreen extends AppCompatActivity {

    private TextView cargando;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_de_carga);

        cargando = findViewById(R.id.cargandoTextView);
        progressBar = findViewById(R.id.loadScreenProgressBar);

        progressBar.setMax(100);
        progressBarAnimation();
    }

    public void progressBarAnimation() {
        ProgressBarAnimation anim = new ProgressBarAnimation(this, progressBar, cargando,
                0f, 100f);
        anim.setDuration(8000);
        progressBar.setAnimation(anim);
    }

}
