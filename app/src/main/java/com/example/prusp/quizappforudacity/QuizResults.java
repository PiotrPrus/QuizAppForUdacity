package com.example.prusp.quizappforudacity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

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
        String result = (String.valueOf(quizScore) + getString(R.string.out_of_6));
        resultsTextView.setText(result);
        showToastWithResult();
    }

    private void showToastWithResult() {
        if (quizScore == 6) {
            Toast.makeText(this, R.string.toast_text_for_score_6, Toast.LENGTH_LONG).show();
        } else if (quizScore == 5) {
            Toast.makeText(this, R.string.toast_text_for_score_5, Toast.LENGTH_LONG).show();
        } else {
            String stringForToast = getString(R.string.toast_text_for_score_less_than_5) +" "+ quizScore + getString(R.string.out_of_6);
            Toast.makeText(this, stringForToast, Toast.LENGTH_LONG).show();
        }
    }
}
