package com.expiate.kaizasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.expiate.kaizasks.fragments.QuestionsFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GameActivity extends AppCompatActivity {

    private QuestionsFragment questionsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Map<String, ArrayList<String>> data = new TreeMap<>();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Question");
        strings.add("Answer1");
        strings.add("Answer2");
        strings.add("Answer3");
        strings.add("Answer4");
        data.put("1", strings);
        questionsFragmentSetup(data);
    }


    public void questionsFragmentSetup(Map<String, ArrayList<String>> data) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        questionsFragment = QuestionsFragment.newInstance(data);
        ft.replace(R.id.placeholder, questionsFragment);
        ft.commit();
    }
}