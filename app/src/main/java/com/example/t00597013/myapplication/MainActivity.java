package com.example.t00597013.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int pass = 12345;
    public int range = 10000000;
    private int guess = 0;
    TextView progressText;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressText = (TextView) findViewById(R.id.progressText);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


    }

    public void go(View view) {
        progressText.setText("Calculating...");
        progressBar.setProgress(2);
        Random random = new Random();
        while (guess != pass) {
            guess = random.nextInt() % range;
        }

        progressText.setText("Found pass: " + guess);
        progressBar.setProgress(100);
    }
}
