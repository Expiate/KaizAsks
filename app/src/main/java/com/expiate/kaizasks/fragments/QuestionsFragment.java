package com.expiate.kaizasks.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.expiate.kaizasks.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionsFragment extends Fragment {

    private static final String ARG_PARAM = "map";

    private Map<String, ArrayList<String>> metaData = new TreeMap<>();

    private TextView question;
    private TextView answer1;
    private TextView answer2;
    private TextView answer3;
    private TextView answer4;

    public QuestionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param metaData A Map that contains the main MetaData of the
     *                 fragment.
     * @return A new instance of fragment QuestionsFragment.
     */
    public static QuestionsFragment newInstance(Map<String, ArrayList<String>> metaData) {
        QuestionsFragment fragment = new QuestionsFragment();
        Bundle args = new Bundle();
        Gson gson = new Gson();
        String json = gson.toJson(metaData);
        args.putString(ARG_PARAM, json);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String json = getArguments().getString(ARG_PARAM);
            Gson gson = new Gson();
            metaData = gson.fromJson(json, TreeMap.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get UI ID's
        question = view.findViewById(R.id.questionTitle);
        answer1 = view.findViewById(R.id.respuesta1);
        answer2 = view.findViewById(R.id.respuesta2);
        answer3 = view.findViewById(R.id.respuesta3);
        answer4 = view.findViewById(R.id.respuesta4);

        // Unpack the Data
        ArrayList<String> texts = metaData.get("1");

        // Set the Data on UI
        question.setText(texts.get(0));
        answer1.setText(texts.get(1));
        answer2.setText(texts.get(2));
        answer3.setText(texts.get(3));
        answer4.setText(texts.get(4));

    }
}