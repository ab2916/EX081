package com.example.ex081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    Button btn1, btn2, btn3;
    int countRedButton ;
    int countBlueButton ;
    Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        countRedButton = 0;
        countBlueButton = 0;
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countBlueButton++;
            }
        });
        btn1.setOnLongClickListener(this);
    }

    protected void onActivityResult(int source, int good, Intent data_back) {
        super.onActivityResult(source, good, data_back);
        if(data_back != null)
        {
            countRedButton = data_back.getIntExtra("BBBoyRed", -99999);
            countBlueButton = data_back.getIntExtra("BBBoyBlue", -99999);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        countRedButton += 2;
        return true;
    }

    public void nextActivity(View view) {
        si = new Intent(this, resultsActivity.class);
        si.putExtra("red", countRedButton);
        si.putExtra("blue", countBlueButton);
        startActivityForResult(si, 1);
    }
}