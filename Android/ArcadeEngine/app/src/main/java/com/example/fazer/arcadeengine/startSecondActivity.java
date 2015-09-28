package com.example.fazer.arcadeengine;

import android.content.Context;
import android.content.Intent;

/**
 * Created by 18balanagav on 9/25/2015.
 */
public class startSecondActivity {

    /**
     * starts the activity that's called when the game ends
     */
    public  void startSecondActivity(int Losewin, int Score) {
        Context context = AnimatedSurface.context;
        Intent winLose = new Intent(context, WINorLOSE.class);
        winLose.putExtra("winLose", Losewin);
        winLose.putExtra("score", Score);
        context.startActivity(winLose);
    }
}
