package com.example.prusp.quizappforudacity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class QuizResults extends AppCompatActivity {

    int quizScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);
        initQuizScoreValue();
        updateQuizScore();
    }

    private void initQuizScoreValue() {
        Intent intent = getIntent();
        quizScore = intent.getIntExtra(String.valueOf(R.string.saved_quiz_score), 0);
    }

    private void updateQuizScore() {
        TextView resultsTextView = (TextView) findViewById(R.id.results_text_view);
        resultsTextView.setText(String.valueOf(quizScore));
    }
}
