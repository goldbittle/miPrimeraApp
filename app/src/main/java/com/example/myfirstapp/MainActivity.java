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
    boolean gameOver = false;
    int level = 1;
    int goal = 50;
    int cont = 0;
    int numButtons=150;
    int numBtn = 3;
    TextView score;
    TextView levelTv;

    TextView clock;

    int maxTime = 60;

    private void showLevelScore(int l, int s)
    {
        score.setText("ROSKIS: "+String.format("%03d", cont));
        levelTv.setText("LEVEL "+String.format("%02d", level));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = (TextView)  findViewById(R.id.score);
        levelTv = (TextView)  findViewById(R.id.level);
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
                if (!gameOver) {
                    cont++;
                    showLevelScore(level, cont);
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
                if (!gameOver) {
                    cont++;
                    showLevelScore(level, cont);
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
                if (!gameOver) {
                    cont++;
                    showLevelScore(level, cont);
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
                if (!gameOver) {
                    cont++;
                    showLevelScore(level, cont);
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
                if (!gameOver) {
                    cont++;
                    showLevelScore(level, cont);
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
                if (!gameOver) {
                    cont++;
                    showLevelScore(level, cont);
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
                if (!gameOver) {
                    cont++;
                    showLevelScore(level, cont);
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
                if (!gameOver) {
                    cont++;
                    showLevelScore(level, cont);
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
                if (!gameOver) {
                    cont++;
                    showLevelScore(level, cont);
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

                cont = 0;
                gameOver = false;

                showMessage("LET'S GO!");

                buttonF1C1.setVisibility(View.INVISIBLE);
                buttonF1C2.setVisibility(View.INVISIBLE);
                buttonF1C3.setVisibility(View.INVISIBLE);

                buttonF2C1.setVisibility(View.INVISIBLE);
                buttonF2C2.setVisibility(View.INVISIBLE);
                buttonF2C3.setVisibility(View.INVISIBLE);

                buttonF3C1.setVisibility(View.INVISIBLE);
                buttonF3C2.setVisibility(View.INVISIBLE);
                buttonF3C3.setVisibility(View.INVISIBLE);


                startButton.setVisibility(View.INVISIBLE);

                showLevelScore(level, cont);

                reverseTimer(getMaxTime(),clock);
                numButtons = 0;
                choseButtons();
            }
        });
    }

    private void showMessage(String text){
        Toast toast = Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }
    protected void choseButtons(){
        numButtons= new Random().nextInt(numBtn) + 1;
        int random2 = 0;
        int exclude1=0,exclude2=0,exclude3=0,exclude4=0,exclude5=0;
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
                        exclude3 = random2 = new Random().nextInt(9) + 1;
                    }while ((random2 == exclude1) || (random2 == exclude2));

                    break;
                case 3:
                    do {
                        exclude4 = random2 = new Random().nextInt(9) + 1;
                    }while ((random2 == exclude1) || (random2 == exclude2) || (random2 == exclude3));

                    break;
                case 4:
                    do {
                        random2 = new Random().nextInt(9) + 1;
                    }while ((random2 == exclude1) || (random2 == exclude2) || (random2 == exclude3) || (random2 == exclude4));

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

    private void gameOver()
    {
        showMessage("GAME OVER!");
        clock.setText("GAME OVER");
        gameOver = true;
    }

    private int  getGoal()
    {
        return level * goal;
    }

    private int getMaxTime()
    {
        return maxTime;
    }
    private void levelUp()
    {
        showMessage("LEVEL UP!");
        if (level<9)
        {
            level++;
            if (numBtn<5)
                numBtn++;

        }

        showLevelScore(level,cont);
        reverseTimer(getMaxTime(),clock);
        numButtons = 0;
        choseButtons();
    }

    public void reverseTimer(int Seconds,final TextView tv){

        new CountDownTimer(Seconds* 1000+1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText("TIME : " + String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }

            public void onFinish() {
                if (cont >= getGoal()){
                    levelUp();
                }
                else{
                    gameOver();
                }
            }
        }.start();
    }
}
