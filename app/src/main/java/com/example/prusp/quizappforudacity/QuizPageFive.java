package com.example.prusp.quizappforudacity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QuizPageFive extends AppCompatActivity {

    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;

    int quizScore;
    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page_five);
        initRadioButtons();
        initQuizScoreValue();
    }

    private void initQuizScoreValue() {
        Intent intent = getIntent();
        quizScore = intent.getIntExtra(String.valueOf(R.string.saved_quiz_score), 0);
    }
    private void initRadioButtons() {
        radioButton1 = (RadioButton) findViewById(R.id.radio_button_1);
        radioButton2 = (RadioButton) findViewById(R.id.radio_button_2);
        radioButton3 = (RadioButton) findViewById(R.id.radio_button_3);
        radioButton4 = (RadioButton) findViewById(R.id.radio_button_4);
        radioGroup1 = (RadioGroup) findViewById(R.id.radio_group1);
        radioGroup2 = (RadioGroup) findViewById(R.id.radio_group2);
        radioGroup1.clearCheck();
        radioGroup2.clearCheck();
        radioGroup1.setOnCheckedChangeListener(listener1);
        radioGroup2.setOnCheckedChangeListener(listener2);
    }
    private RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId != -1) {
                radioGroup2.setOnCheckedChangeListener(null);
                radioGroup2.clearCheck();
                radioGroup2.setOnCheckedChangeListener(listener2);
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1){
                radioGroup1.setOnCheckedChangeListener(null);
                radioGroup1.clearCheck();
                radioGroup1.setOnCheckedChangeListener(listener1);
            }
        }
    };

    public void goToPageSixth(View view) {
        if (isProperAnswerSelected()) {
            quizScore++;
        }
        Log.d("quizResult", "Result after fifth question is :" + quizScore);
        Intent startSixthQuestion = new Intent(this, QuizPageSix.class);
        startSixthQuestion.putExtra(String.valueOf(R.string.saved_quiz_score), quizScore);
        startActivity(startSixthQuestion);
        finish();
    }
    private boolean isProperAnswerSelected(){
        return (radioButton4.isChecked());
    }
}
