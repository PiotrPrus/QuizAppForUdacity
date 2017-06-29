package com.example.prusp.quizappforudacity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by prusp on 14.06.2017.
 */

public class QuizPage extends AppCompatActivity {

    private int quizScore = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_page_layout);
    }

    public void goToPageTwo(View view) {
        if (isProperAnswerSelected()) {
            quizScore++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show();
        }
        Intent startSecondQuestion = new Intent(this, QuizPageTwo.class);
        startSecondQuestion.putExtra(String.valueOf(R.string.saved_quiz_score), quizScore);
        startActivity(startSecondQuestion);
        finish();
    }

    private boolean isProperAnswerSelected() {
        EditText editText = (EditText) findViewById(R.id.type_title_edit_text_view);
        return editText.getText().toString().equals("INCEPTION");
    }
}
