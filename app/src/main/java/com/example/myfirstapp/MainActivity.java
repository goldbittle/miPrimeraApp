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

    ImageButton button1, button2,button3;
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
                titulo.setText("GAME OVER");
            }else {
                updateTime = timeSwapBuff + timeInMilliseconds;
                int secs = (int) (updateTime / 1000);
                int mins = secs / 60;
                secs %= 60;
                int hour = mins / 60;
                mins %= 60;
                int miliseconds = (int) (updateTime % 1000);
                clock.setText("" + String.format("%08d", timeInMilliseconds) + " - " + String.format("%02d", hour) + ":" + String.format("%02d", mins) + ":" + String.format("%02d", secs) + "." + String.format("%03d", miliseconds));
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

        button1 = (ImageButton) findViewById(R.id.imageButton2);
        button2 = (ImageButton) findViewById(R.id.imageButton3);
        button3 = (ImageButton) findViewById(R.id.imageButton4);

        startButton = (Button) findViewById (R.id.button);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (cont== 0)
                    Toast.makeText(MainActivity.this, "It's works", Toast.LENGTH_LONG).show();
                cont++;
                titulo.setText("Click "+cont+" Botón 1");
                button1.setVisibility(View.INVISIBLE);
                numButtons--;
                if (numButtons==0)
                    choseButtons();
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (cont== 0)
                    Toast.makeText(MainActivity.this, "It's works", Toast.LENGTH_LONG).show();
                cont++;
                titulo.setText("Click "+cont+" Botón 2");
                button2.setVisibility(View.INVISIBLE);
                numButtons--;
                if (numButtons==0)
                    choseButtons();
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (cont== 0)
                    Toast.makeText(MainActivity.this, "It's works", Toast.LENGTH_LONG).show();
                cont++;
                titulo.setText("Click "+cont+" Botón 3");
                button3.setVisibility(View.INVISIBLE);
                numButtons--;
                if (numButtons==0)
                    choseButtons();
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

                numButtons = 0;
                choseButtons();
            }
        });
    }

    protected void choseButtons(){
        if (timeInMilliseconds>=maxTime)
            return;
        final int random = new Random().nextInt(7) + 1;
        switch (random){
            case 1:
                button1.setVisibility(View.VISIBLE);
                numButtons=1;
                break;
            case 2:
                button2.setVisibility(View.VISIBLE);
                numButtons=1;
                break;
            case 3:
                button3.setVisibility(View.VISIBLE);
                numButtons=1;
                break;
            case 4:
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                numButtons=2;
                break;
            case 5:
                button1.setVisibility(View.VISIBLE);
                button3.setVisibility(View.VISIBLE);
                numButtons=2;
            break;
            case 6:
                button2.setVisibility(View.VISIBLE);
                button3.setVisibility(View.VISIBLE);
                numButtons=2;
                break;
            case 7:
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                button3.setVisibility(View.VISIBLE);
                numButtons=3;
                break;
        }

    }

    protected void onStart(Bundle savedInstanceState){

        titulo.setText("onStart");
        choseButtons();
    }
}
