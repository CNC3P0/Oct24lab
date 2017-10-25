package com.example.t00597013.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int pass = 12345;
    public int range = 10000;
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

        new Potato().execute(range, pass);
    }

    private class Potato extends AsyncTask<Integer, Integer, String> {

        private int guess = 0;
        private int count = 0;

        @Override
        protected String doInBackground(Integer... integers) {
            int theRange = integers[0];
            int thePass = integers[1];
            Random random = new Random();
            while (guess != thePass) {
                guess = random.nextInt() % theRange;
                count += 1;
                publishProgress((int)count * 100 / theRange);
            }
            return "Found pass: " + guess;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress((int)(values[0] + 100.0 / range * 3));
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setProgress(100);
            progressText.setText(s);
        }
    }
}
