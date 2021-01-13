package com.example.dicerollingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    TextView textResult;
    EditText textName;
    Button buttonRollDice;
    CardView cardDice;
    GifImageView rollingDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textResult = findViewById(R.id.textResult);
        textName = findViewById(R.id.textName);
        buttonRollDice = findViewById(R.id.buttonRollDice);
        cardDice = findViewById(R.id.cardDice);
        rollingDice = findViewById(R.id.rollingDice);

    }

    public void rollDice(View view) {
        String name = textName.getText().toString().trim();

        if(name==null || name.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
            return;
        }

        rollingDice.setVisibility(View.VISIBLE);
        cardDice.setVisibility(View.GONE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String number = getRolledResult();
                textResult.setText(number);
                rollingDice.setVisibility(View.GONE);
                cardDice.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Congratulations "+name+" got "+number, Toast.LENGTH_SHORT).show();
            }
        },2000);

    }

    private String getRolledResult() {
        int max = 6;
        int min = 1;
        int range = max - min + 1;
        int rand = (int)(Math.random() * range) + min;
        return ""+rand;
    }
}