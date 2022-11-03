package com.example.ex081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resultsActivity extends AppCompatActivity {
    TextView tv;
    Button btn;
    Intent gi;
    int countRedButton;
    int countBlueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);
        gi = getIntent();
        countRedButton = gi.getIntExtra("red", -99999);
        countBlueButton = gi.getIntExtra("blue", -99999);
        if(countRedButton > countBlueButton)
        {
            tv.setText("Blue: " + countBlueButton + "\nRed: " + countRedButton + "\nWinner: Red");
        }
        else if(countRedButton < countBlueButton)
        {
            tv.setText("Blue: " + countBlueButton + "\nRed: " + countRedButton + "\nWinner: Blue");
        }
        else
        {
            tv.setText("Blue: " + countBlueButton + "\nRed: " + countRedButton + "\nWinner: Erel");
        }
    }

    public void go(View view) {
        countRedButton = 0;
        countBlueButton = 0;
        gi.putExtra("BBBoyRed", countRedButton);
        gi.putExtra("BBBoyBlue", countBlueButton);
        setResult(RESULT_OK, gi);
        finish();
    }
}