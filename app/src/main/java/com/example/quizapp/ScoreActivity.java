package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private Button buttonPlayAgain;
    private TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        wiredWidgets();
        setListeners();

        Intent lastIntent = getIntent();
        int score1 = lastIntent.getIntExtra(MainActivity.EXTRA_SCORE, 0);
        score.setText(score.getText().toString() + score1);

    }

    private void setListeners() {
        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent targetIntent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(targetIntent);
                finish();
            }
        });


        }



    private void wiredWidgets() {
       buttonPlayAgain = findViewById(R.id.button_main_playAgain);
        score = findViewById(R.id.textView_main_score);


    }
}