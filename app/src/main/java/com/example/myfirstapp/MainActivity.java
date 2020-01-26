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

    private final int initGoal = 100;
    private final int septGoal = 10;
    private final int initNumBtn = 3;

    Button startButton;
    boolean gameOver = false;
    int level = 1;
    int goal = initGoal;
    int roskis = 0;
    int score = 0;
    int contTime = 0;
    int numButtons=0;
    int numBtn = initNumBtn;
    TextView scoreTv;
    TextView levelTv;
    TextView clockTv;
    TextView roskisTv;

    int maxTime = 60;

    CountDownTimer countDown;

    private void showLevelScore(int l, int s, int r)
    {
        scoreTv.setText("SCORE "+String.format("%04d", score));
        levelTv.setText("LEVEL "+String.format("%02d", level));
        roskisTv.setText("ROSKIS "+String.format("%03d", (goal - roskis)));
    }

    private boolean isGoalAchieved()
    {
       return (goal <= roskis);
    }

    private void checkAchievement(){
        if (isGoalAchieved()) {
            try {
                showMessage("LEVEL "+level+" UP!");
                countDown.cancel();
                int dif = maxTime - contTime;
                for (int i=0;i<dif;i++)
                {
                    score++;
                    showLevelScore(level, score, roskis);
                }
            } catch (Exception e) {  }
            levelUp();
            roskis = 0;
            showLevelScore(level, score, roskis);
            startButton.setText("NEXT LEVEL");
            startButton.setVisibility(View.VISIBLE);
            gameOver = true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTv = (TextView)  findViewById(R.id.score);
        levelTv = (TextView)  findViewById(R.id.level);
        clockTv = (TextView)  findViewById(R.id.textClock);
        roskisTv = (TextView)  findViewById(R.id.roskis);

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
                    roskis++;
                    score++;
                    showLevelScore(level, score, roskis);
                    buttonF1C1.setVisibility(View.INVISIBLE);
                    checkAchievement();
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
                    roskis++;
                    score++;
                    showLevelScore(level, score, roskis);
                    buttonF1C2.setVisibility(View.INVISIBLE);
                    numButtons--;
                    checkAchievement();
                    if (numButtons == 0)
                        choseButtons();
                }
            }
        });
        buttonF1C3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!gameOver) {
                    roskis++;
                    score++;
                    showLevelScore(level, score, roskis);
                    buttonF1C3.setVisibility(View.INVISIBLE);
                    numButtons--;
                    checkAchievement();
                    if (numButtons == 0)
                        choseButtons();
                }
            }
        });

        buttonF2C1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!gameOver) {
                    roskis++;
                    score++;
                    showLevelScore(level, score, roskis);
                    buttonF2C1.setVisibility(View.INVISIBLE);
                    numButtons--;
                    checkAchievement();
                    if (numButtons == 0)
                        choseButtons();
                }
            }
        });
        buttonF2C2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!gameOver) {
                    roskis++;
                    score++;
                    showLevelScore(level, score, roskis);
                    buttonF2C2.setVisibility(View.INVISIBLE);
                    numButtons--;
                    checkAchievement();
                    if (numButtons == 0)
                        choseButtons();
                }
            }
        });
        buttonF2C3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!gameOver) {
                    roskis++;
                    score++;
                    showLevelScore(level, score, roskis);
                    buttonF2C3.setVisibility(View.INVISIBLE);
                    numButtons--;
                    checkAchievement();
                    if (numButtons == 0)
                        choseButtons();
                }
            }
        });

        buttonF3C1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!gameOver) {
                    roskis++;
                    score++;
                    showLevelScore(level, score, roskis);
                    buttonF3C1.setVisibility(View.INVISIBLE);
                    numButtons--;
                    checkAchievement();
                    if (numButtons == 0)
                        choseButtons();
                }
            }
        });

        buttonF3C2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!gameOver) {
                    roskis++;
                    score++;
                    showLevelScore(level, score, roskis);
                    buttonF3C2.setVisibility(View.INVISIBLE);
                    numButtons--;
                    checkAchievement();
                    if (numButtons == 0)
                        choseButtons();
                }
            }
        });
        buttonF3C3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!gameOver) {
                    roskis++;
                    score++;
                    showLevelScore(level, score, roskis);
                    buttonF3C3.setVisibility(View.INVISIBLE);
                    numButtons--;
                    checkAchievement();
                    if (numButtons == 0)
                        choseButtons();
                }
            }
        });


        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if (level == 1)
                {
                    score = 0;
                    goal = initGoal;
                    numBtn = initNumBtn;
                }

                roskis = 0;
                gameOver = false;
                contTime = 0;

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

                showLevelScore(level, score, roskis);

                reverseTimer(getMaxTime(),clockTv);
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
        clockTv.setText("TIME UP");
        gameOver = true;
        startButton.setText("START");
        startButton.setVisibility(View.VISIBLE);
        level = 1;

    }

    private int  getGoal()
    {
        return goal;
    }

    private int getMaxTime()
    {
        return maxTime;
    }

    private void levelUp()
    {
        goal+=septGoal;
        level++;
        if ((level%2==0)&&(numBtn<5))
            numBtn++;

        showLevelScore(level, score, roskis);
        choseButtons();
    }

    public void reverseTimer(int Seconds,final TextView tv){

        countDown =new CountDownTimer(Seconds* 1000+1000, 1000) {
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText("TIME " + String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
                contTime++;
            }

            public void onFinish() {
                    gameOver();
            }
        }.start();
    }
}
