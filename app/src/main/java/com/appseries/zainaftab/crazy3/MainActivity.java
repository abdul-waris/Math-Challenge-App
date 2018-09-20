package com.appseries.zainaftab.crazy3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int current;
    int lives = 3;
    int factor = 3;
    Random rand = new Random();
    TextView tvNumber;
    int score = 0;
    private EditText etName;
    TextView tvScore;
    TextView tvLives;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNumber = findViewById(R.id.txt_number);
        tvScore = findViewById(R.id.lives);
        tvLives = findViewById(R.id.score);
        etName = findViewById(R.id.et_name);
//        genNext();
    }

    @Override
    protected void onResume() {
        super.onResume();
        lives = 3;
        factor = 3;
        score = 0;
        genNext();
    }

    public void genNext() {
        tvNumber.setText("" + (300 + rand.nextInt(5000)));
    }

    public void multiple(View view) {
        int i = Integer.parseInt(tvNumber.getText().toString());
        switch (view.getTag().toString()) {
            case "1":
                if (i % factor == 0) {
                    score++;
                    tvLives.setText("Score: " + score);
                    genNext();
                } else {
                    lives--;
//                    tvLives.setText("Lives: " + lives);
                    if (lives <= 0)
                        startActivity(new Intent(this, HighScoreActivity.class)
                                .putExtra("name", etName.getText().toString())
                                .putExtra("score", score));
                    else genNext();
                }

                break;
            case "0":
                if (i % factor == 0) {
                    lives--;
                    tvLives.setText("Lives: " + lives);
                    if (lives <= 0)
                        startActivity(new Intent(this, HighScoreActivity.class)
                                .putExtra("name", etName.getText().toString())
                                .putExtra("score", score));
                    else genNext();
                } else {
                    score++;
//                    tvLives.setText("Score: " + score);
                    genNext();
                }
                break;
        }
    }

}
