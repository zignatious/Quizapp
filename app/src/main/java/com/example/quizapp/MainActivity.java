package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = MainActivity.class.getSimpleName();
private Button buttonFalse;
private Button buttonTrue;
private TextView questionPlace;
private Quiz quiz;
public static final String EXTRA_SCORE = "score";

    @Override
    protected void onCreate(Bundle savedInstanceState) { //STACK OVERFLOW
        super.onCreate(savedInstanceState);//STACK OVERFLOW
        setContentView(R.layout.activity_main);//STACK OVERFLOW

        InputStream XmlFileInputStream = getResources().openRawResource(R.raw.questions); // getting XML//STACK OVERFLOW
        String questionsText = readTextFile(XmlFileInputStream);//STACK OVERFLOW
        System.out.println(questionsText);//STACK OVERFLOW
        wiredWidgets();
        setListeners();
// create a gson object
        Gson gson = new Gson();
// read your json file into an array of questions
        Question[] questions =  gson.fromJson(questionsText, Question[].class);
// convert your array to a list using the Arrays utility class
        quiz = new Quiz(Arrays.asList(questions));
// verify that it read everything properly
        Log.d(TAG, "onCreate: " + quiz.getQuestionList().toString());
        questionPlace.setText(quiz.getQuestionText());

    }





    public String readTextFile(InputStream inputStream) {//STACK OVERFLOW
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();//STACK OVERFLOW

        byte buf[] = new byte[1024];//STACK OVERFLOW
        int len;//STACK OVERFLOW
        try {//STACK OVERFLOW
            while ((len = inputStream.read(buf)) != -1) {//STACK OVERFLOW
                outputStream.write(buf, 0, len);//STACK OVERFLOW
            }
            outputStream.close();//STACK OVERFLOW
            inputStream.close();//STACK OVERFLOW
        } catch (IOException e) {//STACK OVERFLOW

        }
        return outputStream.toString();//STACK OVERFLOW

    }





    private void wiredWidgets() {
    buttonFalse = findViewById(R.id.button_main_false);
    buttonTrue = findViewById(R.id.button_main_true);
    questionPlace = findViewById(R.id.textview_main_question);
    }

    private void setListeners() {
        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "CORRECT", Toast.LENGTH_SHORT);
                Toast toast1 = Toast.makeText(getApplicationContext(), "FALSE", Toast.LENGTH_SHORT);
                if (quiz.checkAnswer(true)) {
                    quiz.setScore(quiz.getScore() + 1);
                    toast.show();
                }
                else{
                    toast1.show();

                }
                if (quiz.hasMoreQuestions()) {
                    questionPlace.setText(quiz.nextQuestion());

                }
                else if (!quiz.hasMoreQuestions()){
                    Intent targetIntent = new Intent(MainActivity.this, ScoreActivity.class);
                    targetIntent.putExtra(EXTRA_SCORE, quiz.getScore());
                    startActivity(targetIntent);
                    finish();
                }
            }
        });



        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "CORRECT", Toast.LENGTH_SHORT);
                Toast toast1 = Toast.makeText(getApplicationContext(), "FALSE", Toast.LENGTH_SHORT);
                if (quiz.checkAnswer(false)) {
                    quiz.setScore(quiz.getScore() + 1);toast.show();
                    toast1.show();

                }
                else{
                    toast.show();


                }
                if (quiz.hasMoreQuestions()){
                    questionPlace.setText(quiz.nextQuestion());


                }
                else if (!quiz.hasMoreQuestions()){
                    Intent targetIntent = new Intent(MainActivity.this, ScoreActivity.class);
                    targetIntent.putExtra(EXTRA_SCORE, quiz.getScore());
                    startActivity(targetIntent);
                    finish();
                }
            }
        });
    }





}




// QUESTIONS
//if there are questions left, go to the next question, if there are no questions left
//then cycle to a new screen with the score (int value) and a button that says "Play again?"
//could make the buttons/score invisible to start or use a second screen.
//have to use JSON files and questions to paste.
