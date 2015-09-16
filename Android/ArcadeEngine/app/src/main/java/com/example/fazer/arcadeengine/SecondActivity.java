package com.example.fazer.arcadeengine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by spockm on 7/1/2014.
 */
public class SecondActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_lose);
        TextView loseWin = (TextView) findViewById(R.id.WINlose);
        Intent data = getIntent();
        int winLose = data.getIntExtra("winLose", -1);
        if(winLose == 1)
            WIN(loseWin);
        else if (winLose == 0)
            LOSE(loseWin);
        else
            Error(loseWin);
    }

    private void WIN(TextView loseWin){
        loseWin.setText("You Win!!");
    }

    private void LOSE(TextView loseWin){
        loseWin.setText("You Lose!!");
    }

    private void Error(TextView loseWin){
        loseWin.setText("Error. Please Re-try.");
    }

}