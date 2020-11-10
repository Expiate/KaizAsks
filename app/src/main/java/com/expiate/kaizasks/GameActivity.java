package com.expiate.kaizasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.expiate.kaizasks.fragments.QuestionsFragment;

public class GameActivity extends AppCompatActivity {

    private QuestionsFragment questionsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        questionsFragmentSetup();
    }


    public void questionsFragmentSetup() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        questionsFragment = QuestionsFragment.newInstance("test", "test");
        ft.replace(R.id.placeholder, questionsFragment);
        ft.commit();
    }
}