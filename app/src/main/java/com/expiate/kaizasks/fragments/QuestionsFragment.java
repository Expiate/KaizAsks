package com.expiate.kaizasks.fragments;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
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

    private int correctAnswer;
    private int selectedAnswer = 0;

    private Drawable selectedAnswerDrawable;
    private Drawable notSelectedAnswerDrawable;

    private Resources res;

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

        // Get the Resources needed for the Answer Logic
        res = getResources();
        selectedAnswerDrawable = ResourcesCompat.getDrawable(res, R.drawable.selected_answer,
                null);
        notSelectedAnswerDrawable = ResourcesCompat.getDrawable(res, R.drawable.two_state_element,
                null);

        // Set the Question
        loadQuestion("1");

        // Listeners
        addAnswerListener(answer1, 1);
        addAnswerListener(answer2, 2);
        addAnswerListener(answer3, 3);
        addAnswerListener(answer4, 4);
    }

    /**
     * Load the Question Text's that are returned from the Database Query
     *
     * @param set Points the target set of texts that forms the question ( Is a number )
     */
    public void loadQuestion(String set) {
        ArrayList<String> texts = metaData.get(set);

        question.setText(texts.get(0));
        answer1.setText(texts.get(1));
        answer2.setText(texts.get(2));
        answer3.setText(texts.get(3));
        answer4.setText(texts.get(4));
        correctAnswer = Integer.parseInt(texts.get(5));
    }

    /**
     * Changes the actual Drawable Resource of the desired TextView
     *
     * @param textView Target TextView
     * @param drawable New Drawable
     */
    public void changeAnswerDrawable(TextView textView, Drawable drawable) {
        textView.setBackground(drawable);
    }

    /**
     * Add a custom listener to the target TextView
     *
     * @param textView Target TextView
     * @param number This defines the number which later will be the representation of
     *               the answer tied to that TextView
     */
    public void addAnswerListener(TextView textView, int number) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedAnswer != 0) {
                    TextView target;
                    switch (selectedAnswer) {
                        case 1:
                            target = answer1;
                            break;
                        case 2:
                            target = answer2;
                            break;
                        case 3:
                            target = answer3;
                            break;
                        case 4:
                            target = answer4;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + selectedAnswer);
                    }
                    changeAnswerDrawable((TextView) target, notSelectedAnswerDrawable);
                }
                changeAnswerDrawable((TextView) v, selectedAnswerDrawable);
                selectedAnswer = number;
            }
        });
    }
}