package com.example.maria.footballscoresapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int foulsTeamA = 0;
    int foulsTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void displayScoreForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    private void displayFoulsForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_fouls);
        scoreView.setText(String.valueOf(score));
    }

    private void displayScoreForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    private void displayFoulsForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_fouls);
        scoreView.setText(String.valueOf(score));
    }

    public void addPointForTeamA(View view) {
        scoreTeamA += 1;
        displayScoreForTeamA(scoreTeamA);
    }

    public void addFoulForTeamA(View view) {
        foulsTeamA += 1;
        displayFoulsForTeamA(foulsTeamA);
    }

    public void addPointForTeamB(View view) {
        scoreTeamB += 1;
        displayScoreForTeamB(scoreTeamB);
    }

    public void addFoulForTeamB(View view) {
        foulsTeamB += 1;
        displayFoulsForTeamB(foulsTeamB);
    }

    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulsTeamA = 0;
        foulsTeamB = 0;
        displayScoreForTeamA(scoreTeamA);
        displayScoreForTeamB(scoreTeamB);
        displayFoulsForTeamA(foulsTeamA);
        displayFoulsForTeamB(foulsTeamB);
    }
}
