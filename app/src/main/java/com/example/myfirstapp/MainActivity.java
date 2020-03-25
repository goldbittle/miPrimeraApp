package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    static final int GENERIC_MESSAGE = 0;
    static final int SCORE_PLUS_5 = 1;
    static final int SCORE_PLUS_10 = 2;
    static final int SCORE_PLUS_20 = 3;
    static final int SCORE_PLUS_30 = 4;

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:

                if (findViewById(v.getId()) instanceof RoskiImageButton) {
                    //if(dedos>0)
                    //    ((RoskiImageButton) findViewById(v.getId())).set2Eated();
                    //else
                        ((RoskiImageButton) findViewById(v.getId())).setEated();
                }

                v.setPressed(true);
                dedos++;
                break;
            case MotionEvent.ACTION_UP:
                if (findViewById(v.getId()) instanceof RoskiImageButton) {
                    ((RoskiImageButton) findViewById(v.getId())).setRegular();
                }
                v.setPressed(false);
                if (!gameOver) {
                    roskis++;
                    switch (dedos)
                    {
                        case 1:
                            score++;
                            break;
                        case 2:
                            if (findViewById(v.getId()) instanceof RoskiImageButton)
                                ((RoskiImageButton) findViewById(v.getId())).set2Eated();
                            score++;
                            score+=5;
                            showCustomMessage("+5",SCORE_PLUS_5);
                            break;
                        case 3:
                            if (findViewById(v.getId()) instanceof RoskiImageButton)
                                ((RoskiImageButton) findViewById(v.getId())).set3Eated();
                            score+=10;
                            showCustomMessage("+10",SCORE_PLUS_10);
                            break;
                        case 4:
                            score+=20;
                            showCustomMessage("+20",SCORE_PLUS_20);
                            break;
                        case 5:
                            score+=30;
                            showCustomMessage("+30",SCORE_PLUS_30);
                            break;
                    }
                    showLevelScore(level, score, roskis);
                    findViewById(v.getId()).setVisibility(View.INVISIBLE);

                    checkAchievement();
                    numButtons--;
                    if (numButtons == 0)
                        choseButtons();
                }
                dedos--;
                break;
        }
        return true;
    }

    //ImageButton buttonF1C1, buttonF1C2,buttonF1C3;
    RoskiImageButton buttonF1C1, buttonF1C2, buttonF1C3;;
    ImageButton buttonF2C1, buttonF2C2,buttonF2C3;
    ImageButton buttonF3C1, buttonF3C2,buttonF3C3;

    private final int initGoal = 50;
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

    int maxTime = 35;

    int dedos = 0;

    CountDownTimer countDown;

    Toast toastCustom = null;

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
            clockTv.setText("TIME 00:00");
            gameOver = true;
            showRoskis();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //Toast Custom
//        toastCustom = new Toast(this);


        //TextViews - Indicators
        scoreTv = (TextView)  findViewById(R.id.score);
        levelTv = (TextView)  findViewById(R.id.level);
        clockTv = (TextView)  findViewById(R.id.textClock);
        roskisTv = (TextView)  findViewById(R.id.roskis);

        //ImageButtons - Roskis
        buttonF1C1 = (RoskiImageButton) findViewById(R.id.imageButtonF1C1);
        buttonF1C1.setRegular();
        buttonF1C2 = (RoskiImageButton) findViewById(R.id.imageButtonF1C2);
        buttonF1C2.setRegular();
        buttonF1C3 = (RoskiImageButton)  findViewById(R.id.imageButtonF1C3);
        buttonF1C3.setRegular();

        buttonF2C1 = (ImageButton) findViewById(R.id.imageButtonF2C1);
        buttonF2C2 = (ImageButton) findViewById(R.id.imageButtonF2C2);
        buttonF2C3 = (ImageButton) findViewById(R.id.imageButtonF2C3);

        buttonF3C1 = (ImageButton) findViewById(R.id.imageButtonF3C1);
        buttonF3C2 = (ImageButton) findViewById(R.id.imageButtonF3C2);
        buttonF3C3 = (ImageButton) findViewById(R.id.imageButtonF3C3);

        //Button - Start
        startButton = (Button) findViewById (R.id.button);

        gameOver = true;

        //Roski - Listeners

        buttonF1C1.setOnTouchListener(this);
        buttonF1C2.setOnTouchListener(this);
        buttonF1C3.setOnTouchListener(this);

        buttonF2C1.setOnTouchListener(this);
        buttonF2C2.setOnTouchListener(this);
        buttonF2C3.setOnTouchListener(this);

        buttonF3C1.setOnTouchListener(this);
        buttonF3C2.setOnTouchListener(this);
        buttonF3C3.setOnTouchListener(this);

        //Start Button Listener
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

                hideRoskis();

                startButton.setVisibility(View.INVISIBLE);

                showLevelScore(level, score, roskis);

                reverseTimer(getMaxTime(),clockTv);
                choseButtons();
            }
        });
    }
    private void hideRoskis()
    {
        buttonF1C1.setVisibility(View.INVISIBLE);
        buttonF1C2.setVisibility(View.INVISIBLE);
        buttonF1C3.setVisibility(View.INVISIBLE);

        buttonF2C1.setVisibility(View.INVISIBLE);
        buttonF2C2.setVisibility(View.INVISIBLE);
        buttonF2C3.setVisibility(View.INVISIBLE);

        buttonF3C1.setVisibility(View.INVISIBLE);
        buttonF3C2.setVisibility(View.INVISIBLE);
        buttonF3C3.setVisibility(View.INVISIBLE);
    }
    private void showRoskis()
    {
        buttonF1C1.setVisibility(View.VISIBLE);
        buttonF1C2.setVisibility(View.VISIBLE);
        buttonF1C3.setVisibility(View.VISIBLE);

        buttonF2C1.setVisibility(View.VISIBLE);
        buttonF2C2.setVisibility(View.VISIBLE);
        buttonF2C3.setVisibility(View.VISIBLE);

        buttonF3C1.setVisibility(View.VISIBLE);
        buttonF3C2.setVisibility(View.VISIBLE);
        buttonF3C3.setVisibility(View.VISIBLE);
    }
    private void showMessage(String text){
/*
        Toast toast = Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

 */
        showCustomMessage(text,GENERIC_MESSAGE);

    }

    private void showCustomMessage(String text, int type){
        if (toastCustom!=null) {
            toastCustom.cancel();
            //toastCustom.setDuration(0);
        }
        toastCustom = new Toast(this);
        View toast_layout;

        switch (type){
            case SCORE_PLUS_5:
                toast_layout = getLayoutInflater().inflate(R.layout.custom_toast_yellow, null);
                break;
            case SCORE_PLUS_10:
                toast_layout = getLayoutInflater().inflate(R.layout.custom_toast_orange, null);
                break;
            case SCORE_PLUS_20:
                toast_layout = getLayoutInflater().inflate(R.layout.custom_toast_red, null);
                break;
            case SCORE_PLUS_30:
                toast_layout = getLayoutInflater().inflate(R.layout.custom_toast_green, null);
                break;
            default:
                toast_layout = getLayoutInflater().inflate(R.layout.custom_toast, null);
                break;
        }


        toastCustom.setView(toast_layout);

        TextView textView = (TextView) toast_layout.findViewById(R.id.toastMessage);
        textView.setText(text);
        if (type==GENERIC_MESSAGE)
            toastCustom.setGravity(Gravity.CENTER, 0, 0);
        else
            toastCustom.setGravity(Gravity.TOP|Gravity.RIGHT, 0, 0);
        toastCustom.setDuration(Toast.LENGTH_SHORT);
        toastCustom.show();
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
        showRoskis();

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
        if ((level%5==0)&&(numBtn<5))
            numBtn++;
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
