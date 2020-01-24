package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    ImageButton buttonF1C1, buttonF1C2,buttonF1C3;
    ImageButton buttonF2C1, buttonF2C2,buttonF2C3;
    ImageButton buttonF3C1, buttonF3C2,buttonF3C3;

    Button startButton;
    int cont = 0;
    int numButtons=0;
    TextView titulo;
    TextView clock;
    long maxTime = 60000;

    Handler customHandler = new Handler();
    long starTime=0L,timeInMilliseconds=0L,timeSwapBuff=0L,updateTime=0L;

    Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - starTime;

            if (timeInMilliseconds>=maxTime) {
                clock.setText("GAME OVER");
                Toast toast = Toast.makeText(MainActivity.this, "GAME OVER", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }else {
                updateTime = timeSwapBuff + timeInMilliseconds;
                int secs = (int) (updateTime / 1000);
                int mins = secs / 60;
                secs %= 60;
                int hour = mins / 60;
                mins %= 60;
                int miliseconds = (int) (updateTime % 1000);
                clock.setText("" + String.format("%02d", mins) + ":" + String.format("%02d", secs));
                customHandler.postDelayed(this, 0);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titulo = (TextView)  findViewById(R.id.textView);
        clock = (TextView)  findViewById(R.id.textClock);

        buttonF1C1 = (ImageButton) findViewById(R.id.imageButtonF1C1);
        buttonF1C2 = (ImageButton) findViewById(R.id.imageButtonF1C2);
        buttonF1C3 = (ImageButton) findViewById(R.id.imageButtonF1C3);

        buttonF2C1 = (ImageButton) findViewById(R.id.imageButtonF2C1);
        buttonF2C2 = (ImageButton) findViewById(R.id.imageButtonF2C2);
        buttonF2C3 = (ImageButton) findViewById(R.id.imageButtonF2C3);

        buttonF3C1 = (ImageButton) findViewById(R.id.imageButtonF3C1);
        buttonF3C2 = (ImageButton) findViewById(R.id.imageButtonF3C2);
        buttonF3C3 = (ImageButton) findViewById(R.id.imageButtonF3C3);

        startButton = (Button) findViewById (R.id.button);

        buttonF1C1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (timeInMilliseconds < maxTime) {
                    cont++;
                    titulo.setText("SCORE: "+String.format("%02d", cont));
                    buttonF1C1.setVisibility(View.INVISIBLE);
                    numButtons--;
                    if (numButtons == 0)
                        choseButtons();
                }
            }
        });
        buttonF1C2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (timeInMilliseconds < maxTime) {
                    cont++;
                    titulo.setText("SCORE: "+String.format("%02d", cont));
                    buttonF1C2.setVisibility(View.INVISIBLE);
                    numButtons--;
                    if (numButtons == 0)
                        choseButtons();
                }
            }
        });
        buttonF1C3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (timeInMilliseconds<maxTime) {
                    cont++;
                    titulo.setText("SCORE: "+String.format("%02d", cont));
                    buttonF1C3.setVisibility(View.INVISIBLE);
                    numButtons--;
                    if (numButtons == 0)
                        choseButtons();
                }
            }
        });

        buttonF2C1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (timeInMilliseconds < maxTime) {
                    cont++;
                    titulo.setText("SCORE: "+String.format("%02d", cont));
                    buttonF2C1.setVisibility(View.INVISIBLE);
                    numButtons--;
                    if (numButtons == 0)
                        choseButtons();
                }
            }
        });
        buttonF2C2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (timeInMilliseconds < maxTime) {
                    cont++;
                    titulo.setText("SCORE: "+String.format("%02d", cont));
                    buttonF2C2.setVisibility(View.INVISIBLE);
                    numButtons--;
                    if (numButtons == 0)
                        choseButtons();
                }
            }
        });
        buttonF2C3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (timeInMilliseconds < maxTime) {
                    cont++;
                    titulo.setText("SCORE: "+String.format("%02d", cont));
                    buttonF2C3.setVisibility(View.INVISIBLE);
                    numButtons--;
                    if (numButtons == 0)
                        choseButtons();
                }
            }
        });

        buttonF3C1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (timeInMilliseconds < maxTime) {
                    cont++;
                    titulo.setText("SCORE: "+String.format("%02d", cont));
                    buttonF3C1.setVisibility(View.INVISIBLE);
                    numButtons--;
                    if (numButtons == 0)
                        choseButtons();
                }
            }
        });

        buttonF3C2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (timeInMilliseconds < maxTime) {
                    cont++;
                    titulo.setText("SCORE: "+String.format("%02d", cont));
                    buttonF3C2.setVisibility(View.INVISIBLE);
                    numButtons--;
                    if (numButtons == 0)
                        choseButtons();
                }
            }
        });
        buttonF3C3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (timeInMilliseconds < maxTime) {
                    cont++;
                    titulo.setText("SCORE: "+String.format("%02d", cont));
                    buttonF3C3.setVisibility(View.INVISIBLE);
                    numButtons--;
                    if (numButtons == 0)
                        choseButtons();
                }
            }
        });
        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this, "Let's Go!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

                cont = 0;
                starTime = SystemClock.uptimeMillis();

                customHandler.postDelayed(updateTimerThread, 0);

                buttonF1C1.setVisibility(View.INVISIBLE);
                buttonF1C2.setVisibility(View.INVISIBLE);
                buttonF1C3.setVisibility(View.INVISIBLE);

                buttonF2C1.setVisibility(View.INVISIBLE);
                buttonF2C2.setVisibility(View.INVISIBLE);
                buttonF2C3.setVisibility(View.INVISIBLE);

                buttonF3C1.setVisibility(View.INVISIBLE);
                buttonF3C2.setVisibility(View.INVISIBLE);
                buttonF3C3.setVisibility(View.INVISIBLE);

                numButtons = 0;
                choseButtons();
            }
        });
    }

    protected void choseButtons(){
        numButtons= new Random().nextInt(3) + 1;
        int random2 = 0;
        int exclude1=0,exclude2=0;
        for (int i=0; i<numButtons; i++){
            switch (i){
                case 0:
                    exclude1 = random2 = new Random().nextInt(9) + 1;
                    break;
                case 1:
                    do {
                        exclude2 = random2 = new Random().nextInt(9) + 1;
                    }while (random2 == exclude1);

                    break;
                case 2:
                    do {
                        random2 = new Random().nextInt(9) + 1;
                    }while ((random2 == exclude1) || (random2 == exclude2));

                    break;
            }

            switch (random2){
                case 1:
                    buttonF1C1.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    buttonF1C2.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    buttonF1C3.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    buttonF2C1.setVisibility(View.VISIBLE);
                    break;
                case 5:
                    buttonF2C2.setVisibility(View.VISIBLE);
                    break;
                case 6:
                    buttonF2C3.setVisibility(View.VISIBLE);
                    break;
                case 7:
                    buttonF3C1.setVisibility(View.VISIBLE);
                    break;
                case 8:
                    buttonF3C2.setVisibility(View.VISIBLE);
                    break;
                case 9:
                    buttonF3C3.setVisibility(View.VISIBLE);
                    break;

            }
        }
    }
}
