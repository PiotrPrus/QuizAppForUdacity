package com.example.prusp.quizappforudacity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QuizPageFour extends AppCompatActivity {
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;

    int quizScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page_four);
        initCheckBoxes();
        initQuizScoreValue();
    }

    private void initCheckBoxes() {
        checkBox1 = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
    }

    private void initQuizScoreValue() {
        Intent intent = getIntent();
        quizScore = intent.getIntExtra(String.valueOf(R.string.saved_quiz_score), 0);
    }

    public void goToPageFifth(View view) {
        if (isProperAnswerSelected()) {
            quizScore++;
        }
        Log.d("quizResult", "Result after forth question is :" + quizScore);
        Intent startFifthQuestion = new Intent(this, QuizPageFive.class);
        startFifthQuestion.putExtra(String.valueOf(R.string.saved_quiz_score), quizScore);
        startActivity(startFifthQuestion);
        finish();
    }

    private boolean isProperAnswerSelected() {
        return (checkBox1.isChecked() && checkBox4.isChecked());
    }
}

