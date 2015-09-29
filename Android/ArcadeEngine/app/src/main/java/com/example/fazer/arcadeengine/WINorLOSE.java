package com.example.fazer.arcadeengine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WINorLOSE extends Activity
{
    //public static boolean donePlaying = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AnimatedSurface.running = false;
        setContentView(R.layout.activity_win_lose);
        TextView loseWin = (TextView) findViewById(R.id.WINlose);
        TextView ScOrE = (TextView) findViewById(R.id.score);
        Intent data = getIntent();
        int winLose = data.getIntExtra("winLose", -1);
        int SCORE = data.getIntExtra("score", 0);
        ScOrE.setText(String.valueOf(SCORE));
        if(winLose == 1)
            WIN(loseWin);
        else if (winLose == 0)
            LOSE(loseWin);
        else
            Error(loseWin);

        Button playAgain = (Button) findViewById(R.id.retry);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAgain();
            }
        });

        Button QUIT = (Button) findViewById(R.id.quit);
        QUIT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                quit();
            }
        });

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        AnimatedSurface.running = true;
    }

    @Override
    public void onPause(){
        super.onPause();
        AnimatedSurface.running = true;
    }

    private void WIN(TextView loseWin){ loseWin.setText("You Win!!"); }

    private void LOSE(TextView loseWin){
        loseWin.setText("You Lose!!");
    }

    private void Error(TextView loseWin){
        loseWin.setText("Error. Please Re-try.");
    }

    protected void playAgain(){
        Intent reStart = new Intent(this, startActivity.class);
        startActivity(reStart);
        finish();
    }

    protected  void quit(){
        finish();
    }
}