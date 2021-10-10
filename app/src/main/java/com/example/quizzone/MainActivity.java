package com.example.quizzone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Quiz[] quiz1;
    private Button mNext,mAnswer1, mAnswer2, mAnswer3, mAnswer4;
    private TextView mQuestion;
    private int ris,totalPoint;
    private static int mCurrentIndex = 0;
    private boolean isSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quiz1 = new Quiz[]{
                new Quiz(getString(R.string.question1), getString(R.string.answer1),
                        getString(R.string.answer2),getString(R.string.answer3),
                        getString(R.string.answer4), 1),

                new Quiz(getString(R.string.question2), getString(R.string.answer1_2),
                        getString(R.string.answer2_2),getString(R.string.answer3_2),
                        getString(R.string.answer4_2), 3),

                new Quiz(getString(R.string.question3), getString(R.string.answer1_3),
                        getString(R.string.answer2_3),getString(R.string.answer3_3),
                        getString(R.string.answer4_3), 2),
        };

        mNext = findViewById(R.id.next);
        mQuestion = findViewById(R.id.question);
        mAnswer1 = findViewById(R.id.answer1);
        mAnswer2 = findViewById(R.id.answer2);
        mAnswer3 = findViewById(R.id.answer3);
        mAnswer4 = findViewById(R.id.answer4);

        setTextElement();

        mNext.setOnClickListener(view -> {

            if(isSelected){
                mCurrentIndex++;
                isSelected=false;
                if(mCurrentIndex < quiz1.length){
                    setTextElement();
                    stateButton(true, mAnswer1,mAnswer2,mAnswer3,mAnswer4);
                    resetColorButton(mAnswer1,mAnswer2,mAnswer3,mAnswer4);
                }
            }else
                Toast.makeText(getApplicationContext(), "Devi Selezionare Una Risposta!", Toast.LENGTH_LONG).show();

        });
    }

    @SuppressLint("NonConstantResourceId")
    public void onClickButton(@NonNull View view)
    {
        int id = view.getId();
        Button b = findViewById(id);
        isSelected = true;
        stateButton(false, mAnswer1,mAnswer2,mAnswer3,mAnswer4);

        switch(id){
            case R.id.answer1: ris = 1;
                break;

            case R.id.answer2: ris = 2;
                break;

            case R.id.answer3: ris = 3;
                break;

            case R.id.answer4: ris = 4;
                break;
        }
        checkCorrectAnswer(ris,b);
    }

    private void setTextElement(){
        mQuestion.setText(quiz1[mCurrentIndex].getQuestion());
        mAnswer1.setText(quiz1[mCurrentIndex].getAnswer1());
        mAnswer2.setText(quiz1[mCurrentIndex].getAnswer2());
        mAnswer3.setText(quiz1[mCurrentIndex].getAnswer3());
        mAnswer4.setText(quiz1[mCurrentIndex].getAnswer4());
    }

    private void stateButton(boolean enable, Button... buttons){
        for (Button button : buttons) button.setEnabled(enable);
    }

    private void checkCorrectAnswer(int ris, Button b){
        if(quiz1[mCurrentIndex].isCorrectAnswer(ris)) {
            totalPoint += 5;
            Toast.makeText(getApplicationContext(), "Risposta Esatta! :)", Toast.LENGTH_SHORT).show();
            b.setBackgroundColor(Color.GREEN);
        }
        else{
            Toast.makeText(getApplicationContext(), "Risposta Sbagliata! :(", Toast.LENGTH_SHORT).show();
            b.setBackgroundColor(Color.RED);
            getButton(quiz1[mCurrentIndex].getTrueAnswer()).setBackgroundColor(Color.GREEN);
        }
    }

    private Button getButton(int n){
        Button b=null;
        switch(n){
            case 1: b = findViewById(R.id.answer1);
                break;

            case 2: b = findViewById(R.id.answer2);
                break;

            case 3: b = findViewById(R.id.answer3);
                break;

            case 4: b = findViewById(R.id.answer4);
                break;
        }
        return b;
    }

    private void resetColorButton(Button... buttons){
        for (Button button : buttons) button.setBackgroundColor(Color.TRANSPARENT);
    }
}